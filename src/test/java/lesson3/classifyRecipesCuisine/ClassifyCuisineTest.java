package lesson3.classifyRecipesCuisine;

import lesson3.AbstractTest;
import lesson3.classifyRecipesCuisine.dto.ClassifyCuisineRespone;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Sveta
 */
public class ClassifyCuisineTest extends AbstractTest {

    void checkClassifyCuisine(String title, String cuisine, String cuisineDetail) {
        ClassifyCuisineRespone response = given()
                .when()
                .formParam("title", title)
                .post(getClassifyCuisineUrl())
                .prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(ClassifyCuisineRespone.class);
        assertThat(response.getCuisine(), containsString(cuisine));
        assertThat(response.getConfidence() >= 0.80, is(true));

        if (cuisineDetail != null) {
            boolean hasDetail = false;
            for (String c : response.getCuisines()) {
                if (c.equals(cuisineDetail)) {
                    hasDetail = true;
                    break;
                }
            }
            assertThat("reqipe is " + cuisineDetail, hasDetail);
        }
    }

    @Test
    void checkAmericanCuisine() {
        checkClassifyCuisine("Falafel Burgers", "American", "American");
    }

    @Test
    void checkAfricanCuisine() {
        checkClassifyCuisine("African Chicken Peanut Stew", "African", "African");

    }

    @Test
    void checkFrenchCuisine() {
        checkClassifyCuisine("Baked Ratatouille", "Mediterranean", "French");

    }

    @Test
    void checKoreanCuisine() {
        checkClassifyCuisine("Chapchae (Korean Stir-Fried Noodles", "Korean", "Korean");
    }

    @Test
    void checkAsianCuisine() {
        checkClassifyCuisine("Thai Street Vendor Salmon Skewers", "Asian", "Thai");
    }

    @Test
    void checNordicCuisine() {
        checkClassifyCuisine("Baked Swedish Pancake", "Scandinavian", "Nordic");

    }

    @Test
    void checkChineseCuisine() {
        checkClassifyCuisine("Cauliflower, Brown Rice, and Vegetable Fried Rice", "Chinese", "Chinese");

    }

    @Test
    void checkVietnameseCuisine() {
        checkClassifyCuisine("Easy To Make Spring Rolls", "Vietnamese", "Vietnamese");
    }

    @Test
    void checkBritishCuisine() {
        checkClassifyCuisine("Beef Wellington", "European", "British");
    }

    @Test
    void checkIrishCuisine() {
        checkClassifyCuisine("Slow Cooked Corned Beef and Cabbage", "European", "Irish");
    }
}
