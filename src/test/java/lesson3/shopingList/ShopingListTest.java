package lesson3.shopingList;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lesson3.AbstractTest;
import lesson3.ConnectUser;
import lesson3.shopingList.dto.request.ItemShopingListRequest;
import lesson3.shopingList.dto.request.User;
import lesson3.shopingList.dto.AisleList;
import lesson3.shopingList.dto.ItemShopingList;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Sveta
 */
public class ShopingListTest extends AbstractTest {
    private static String hashParam;
    private static String userName;
    private static int itemID;
    protected static RequestSpecification requestShoppingListSpec;
    protected static RequestSpecification requestForItemShoppingListSpec;

    @SneakyThrows
    @BeforeAll
    static void init() {
        ObjectMapper mapper = new ObjectMapper();
        User user = new User(userName, "randomFirstName", "randomLastName", "randomEmail");

        ConnectUser connectUser = given().body(mapper.writeValueAsString(user))
                .when()
                .post("https://api.spoonacular.com/users/connect")
                .prettyPeek()
                .then()
                .statusCode(200)
                .extract()
                .response()
                .body()
                .as(ConnectUser.class);

        assertThat(connectUser.getStatus(), equalTo("success"));
        hashParam = connectUser.getHash();
        userName = connectUser.getUsername();

        requestShoppingListSpec = new RequestSpecBuilder()
                .addPathParam("username", userName)
                .addPathParam("start-date", "2022-08-23")
                .addPathParam("end-date", "2022-08-23")
                .addQueryParam("hash", hashParam)
                .setContentType(ContentType.JSON)
                .build();

        requestForItemShoppingListSpec = new RequestSpecBuilder()
                .addPathParam("username", userName)
                .addQueryParam("hash", hashParam)
                .build();
    }

    @Test
    void generateShopingList() {
        given().spec(requestShoppingListSpec)
                .when()
                .post(getBaseUrl() + "mealplanner/{username}/shopping-list/{start-date}/{end-date}")
                .prettyPeek()
                .then()
                .statusCode(200);

        ItemShopingListRequest item = new ItemShopingListRequest("1 package baking powder", "Baking", true);
        ItemShopingList addItem = given(requestForItemShoppingListSpec)
                .contentType(ContentType.JSON).body(item)
                .when()
                .post(getBaseUrl() + "mealplanner/{username}/shopping-list/items")
                .then()
                .extract()
                .response()
                .body()
                .as(ItemShopingList.class);
        assertThat(addItem.getName(), containsString("baking powder"));
        assertThat(addItem.getAisle(), containsString("Baking"));
        itemID = addItem.getId();

        AisleList getItem = given(requestForItemShoppingListSpec)
                .when()
                .get(getBaseUrl() + "mealplanner/{username}/shopping-list")
                .then()
                .extract()
                .response()
                .body()
                .as(AisleList.class);
        assertThat(getItem.getAisles().get(0).getAisle(), containsString("Baking"));
    }

    @AfterAll
    static void tearDown() {
        given(requestForItemShoppingListSpec)
                .pathParam("id", itemID)
                .delete(getBaseUrl() + "mealplanner/{username}/shopping-list/items/{id}")
                .then()
                .body(containsString("success"));
    }
}