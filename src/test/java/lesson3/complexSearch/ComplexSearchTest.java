package lesson3.complexSearch;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import lesson3.AbstractTest;
import lesson4.AnalyzedInstruction;
import lesson4.Example;
import lesson4.Ingredient__1;
import lesson4.Nutrient;
import lesson4.Result;
import lesson4.Step;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Sveta
 */
public class ComplexSearchTest extends AbstractTest {
    private static RequestSpecification complexSearchSpec = null;

    @BeforeAll
    static void init() {
        complexSearchSpec = new RequestSpecBuilder()
                .addQueryParam("query", "pasta")
                .addQueryParam("addRecipeNutrition", true).build();
    }

    @Test
    void getResponseData() {
        System.out.println(getApiKey());
        JsonPath response = given(complexSearchSpec)
                .queryParam("diet", "vegetarian")
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .body()
                .jsonPath();
        assertThat(response.get("vegetarian"), true);

    }

    @Test
    void checkCuisine() {
        Example result = given().spec(complexSearchSpec)
                .queryParam("cuisine", "Italian")
                .when()
                .get(getComplexSearchUrl())
                .body()
                .as(Example.class);

        for (Result item : result.getResults()) {
            boolean hasItalian = false;
            for (String cuisine : item.getCuisines()) {
                if (cuisine.equals("Italian")) {
                    hasItalian = true;
                    break;
                }
            }
            assertThat("reqipe is Italian", hasItalian);
        }

    }

    @Test
    void checkcheckIntolerances() {
        Example result = given().spec(complexSearchSpec)
                .queryParam("intolerances", "Dairy")
                .when()
                .get(getComplexSearchUrl())
                .body()
                .as(Example.class);
        for (Result item : result.getResults()) {
            assertThat(item.getDairyFree(), is(true));
        }
    }

    @Test
    void checkIncludeIngredients() {

        Example result = given().spec(complexSearchSpec)
                .queryParam("includeIngredients", "capers")
                .when()
                .get(getComplexSearchUrl())
                .body()
                .as(Example.class);
        for (Result item : result.getResults()) {
            boolean found = false;
            for (AnalyzedInstruction analyzedInstructionitem : item.getAnalyzedInstructions()) {
                for (Step steps : analyzedInstructionitem.getSteps()) {
                    for (Ingredient__1 ingredient : steps.getIngredients()) {
                        if (ingredient.getName().equals("capers")) {
                            found = true;
                            break;
                        }
                    }
                }

            }
            assertThat(found, is(true));
        }
    }

    @Test
    void checkExcludeIngredients() {

        Example result = given().spec(complexSearchSpec)
                .queryParam("excludeIngredients", "onion")
                .when()
                .get(getComplexSearchUrl())
                .body()
                .as(Example.class);
        for (Result item : result.getResults()) {
            boolean found = false;
            for (AnalyzedInstruction analyzedInstructionitem : item.getAnalyzedInstructions()) {
                for (Step steps : analyzedInstructionitem.getSteps()) {
                    for (Ingredient__1 ingredient : steps.getIngredients()) {
                        if (ingredient.getName().equals("onion")) {
                            found = true;
                            break;
                        }
                    }
                }
            }
            assertThat(found, is(false));
        }

    }

    @Test
    void checkType() {

        Example result = given().spec(complexSearchSpec)
                .queryParam("type", "side dish")
                .when()
                .get(getComplexSearchUrl())
                .body()
                .as(Example.class);
        for (Result item : result.getResults()) {
            boolean found = false;
            for (String dishType : item.getDishTypes()) {
                if (dishType.contains("side dish")) {
                    found = true;
                    break;
                }
            }
            assertThat(found, is(true));
        }

    }

    @Test
    void checkMaxReadyTime() {

        Example result = given().spec(complexSearchSpec)
                .queryParam("maxReadyTime", 30)
                .when()
                .get(getComplexSearchUrl())
                .body()
                .as(Example.class);
        for (Result item : result.getResults()) {
            assertThat(item.getReadyInMinutes() <= 30, is(true));
        }

    }

    @Test
    void checkAuthor() {
        Example result = given().spec(complexSearchSpec)
                .queryParam("author", "coffeebean")
                .when()
                .get(getComplexSearchUrl())
                .body()
                .as(Example.class);
        for (Result item : result.getResults()) {
            assertThat(item.getAuthor(), containsString("coffeebean"));
        }
    }

    @Test
    void checkCalories() {

        Example result = given().spec(complexSearchSpec)
                .queryParam("minCalories", 350)
                .queryParam("maxCalories", 400)
                .when()
                .get(getComplexSearchUrl())
                .body()
                .as(Example.class);
        for (Result item : result.getResults()) {
            boolean found = false;
            for (Nutrient nutrient : item.getNutrition().getNutrients()) {
                if (nutrient.getName().equals("Calories")) {
                    if (nutrient.getAmount() >= 350 || nutrient.getAmount() <= 400) {
                        found = true;
                        break;
                    }
                }
            }
            assertThat(found, is(true));
        }

    }

    @Test
    void checkFat() {

        Example result = given().spec(complexSearchSpec)
                .queryParam("minFat", 8.0)
                .queryParam("maxFat", 11.0)
                .when()
                .get(getComplexSearchUrl())
                .body()
                .as(Example.class);
        for (Result item : result.getResults()) {
            boolean found = false;
            for (Nutrient nutrient : item.getNutrition().getNutrients()) {
                if (nutrient.getName().equals("Fat")) {
                    if (nutrient.getAmount() >= 8.0 || nutrient.getAmount() <= 11.0) {
                        found = true;
                        break;
                    }
                }
            }
            assertThat(found, is(true));
        }

    }

    @Test
    void checkSugar() {

        Example result = given().spec(complexSearchSpec)
                .queryParam("minSugar", 10.0)
                .queryParam("maxSugar", 20.0)
                .when()
                .get(getComplexSearchUrl())
                .body()
                .as(Example.class);
        for (Result item : result.getResults()) {
            boolean found = false;
            for (Nutrient nutrient : item.getNutrition().getNutrients()) {
                if (nutrient.getName().equals("Sugar")) {
                    if (nutrient.getAmount() >= 10.0 || nutrient.getAmount() <= 20.00) {
                        found = true;
                        break;
                    }
                }
            }
            assertThat(found, is(true));
        }

    }

    @Test
    void checkVitaminA() {

        Example result = given().spec(complexSearchSpec)
                .queryParam("minVitaminA", 2000.0)
                .queryParam("maxVitaminA", 2500.0)
                .when()
                .get(getComplexSearchUrl())
                .body()
                .as(Example.class);
        for (Result item : result.getResults()) {
            boolean found = false;
            for (Nutrient nutrient : item.getNutrition().getNutrients()) {
                if (nutrient.getName().equals("Vitamin A")) {
                    if (nutrient.getAmount() >= 2000.0 || nutrient.getAmount() <= 2500.0) {
                        found = true;
                        break;
                    }
                }
            }
            assertThat(found, is(true));
        }

    }

    @Test
    void checkVitaminC() {

        Example result = given().spec(complexSearchSpec)
                .queryParam("minVitaminC", 250.0)
                .queryParam("maxVitaminC", 80.0)
                .when()
                .get(getComplexSearchUrl())
                .body()
                .as(Example.class);
        for (Result item : result.getResults()) {
            boolean found = false;
            for (Nutrient nutrient : item.getNutrition().getNutrients()) {
                if (nutrient.getName().equals("Vitamin C")) {
                    if (nutrient.getAmount() >= 250.0 || nutrient.getAmount() <= 80.0) {
                        found = true;
                        break;
                    }
                }
            }
            assertThat(found, is(true));
        }

    }

    void checkVitaminE() {

        Example result = given().spec(complexSearchSpec)
                .queryParam("minVitaminE", 1.5)
                .queryParam("maxVitaminE", 3.0)
                .when()
                .get(getComplexSearchUrl())
                .body()
                .as(Example.class);
        for (Result item : result.getResults()) {
            boolean found = false;
            for (Nutrient nutrient : item.getNutrition().getNutrients()) {
                if (nutrient.getName().equals("Vitamin E")) {
                    if (nutrient.getAmount() >= 1.5 || nutrient.getAmount() <= 3.0) {
                        found = true;
                        break;
                    }
                }
            }
            assertThat(found, is(true));
        }

    }

    void checkCalcium() {

        Example result = given().spec(complexSearchSpec)
                .queryParam("minCalcium", 100.0)
                .queryParam("maxCalcium", 130.0)
                .when()
                .get(getComplexSearchUrl())
                .body()
                .as(Example.class);
        for (Result item : result.getResults()) {
            boolean found = false;
            for (Nutrient nutrient : item.getNutrition().getNutrients()) {
                if (nutrient.getName().equals("Calcium")) {
                    if (nutrient.getAmount() >= 100.0 || nutrient.getAmount() <= 130.0) {
                        found = true;
                        break;
                    }
                }
            }
            assertThat(found, is(true));
        }

    }

    void checkCopper() {

        Example result = given().spec(complexSearchSpec)
                .queryParam("minCopper", 0.15)
                .queryParam("maxCopper", 1.5)
                .when()
                .get(getComplexSearchUrl())
                .body()
                .as(Example.class);
        for (Result item : result.getResults()) {
            boolean found = false;
            for (Nutrient nutrient : item.getNutrition().getNutrients()) {
                if (nutrient.getName().equals("Copper")) {
                    if (nutrient.getAmount() >= 0.15 || nutrient.getAmount() <= 1.5) {
                        found = true;
                        break;
                    }
                }
            }
            assertThat(found, is(true));
        }

    }
}
