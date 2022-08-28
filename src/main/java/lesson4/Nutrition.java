
package lesson4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "nutrients",
    "properties",
    "flavonoids",
    "ingredients",
    "caloricBreakdown",
    "weightPerServing"
})
@Data
public class Nutrition {

    @JsonProperty("nutrients")
    private List<Nutrient> nutrients = null;
    @JsonProperty("properties")
    private List<Property> properties = null;
    @JsonProperty("flavonoids")
    private List<Flavonoid> flavonoids = null;
    @JsonProperty("ingredients")
    private List<Ingredient> ingredients = null;
    @JsonProperty("caloricBreakdown")
    private CaloricBreakdown caloricBreakdown;
    @JsonProperty("weightPerServing")
    private WeightPerServing weightPerServing;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("nutrients")
    public List<Nutrient> getNutrients() {
        return nutrients;
    }

    @JsonProperty("nutrients")
    public void setNutrients(List<Nutrient> nutrients) {
        this.nutrients = nutrients;
    }

    @JsonProperty("properties")
    public List<Property> getProperties() {
        return properties;
    }

    @JsonProperty("properties")
    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    @JsonProperty("flavonoids")
    public List<Flavonoid> getFlavonoids() {
        return flavonoids;
    }

    @JsonProperty("flavonoids")
    public void setFlavonoids(List<Flavonoid> flavonoids) {
        this.flavonoids = flavonoids;
    }

    @JsonProperty("ingredients")
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @JsonProperty("ingredients")
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @JsonProperty("caloricBreakdown")
    public CaloricBreakdown getCaloricBreakdown() {
        return caloricBreakdown;
    }

    @JsonProperty("caloricBreakdown")
    public void setCaloricBreakdown(CaloricBreakdown caloricBreakdown) {
        this.caloricBreakdown = caloricBreakdown;
    }

    @JsonProperty("weightPerServing")
    public WeightPerServing getWeightPerServing() {
        return weightPerServing;
    }

    @JsonProperty("weightPerServing")
    public void setWeightPerServing(WeightPerServing weightPerServing) {
        this.weightPerServing = weightPerServing;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
