
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
    "vegetarian",
    "vegan",
    "glutenFree",
    "dairyFree",
    "veryHealthy",
    "cheap",
    "veryPopular",
    "sustainable",
    "lowFodmap",
    "weightWatcherSmartPoints",
    "gaps",
    "preparationMinutes",
    "cookingMinutes",
    "aggregateLikes",
    "healthScore",
    "creditsText",
    "license",
    "sourceName",
    "pricePerServing",
    "id",
    "title",
    "readyInMinutes",
    "servings",
    "sourceUrl",
    "image",
    "imageType",
    "nutrition",
    "summary",
    "cuisines",
    "dishTypes",
    "diets",
    "occasions",
    "analyzedInstructions",
    "spoonacularSourceUrl"
})
@Data
public class Result {

    @JsonProperty("vegetarian")
    private Boolean vegetarian;

    /*
       @JsonProperty("vegetarian")
       public Boolean getVegetarian() {
           return vegetarian;
       }
   */
    @JsonProperty("vegan")
    private Boolean vegan;
    @JsonProperty("glutenFree")
    private Boolean glutenFree;
    @JsonProperty("dairyFree")
    private Boolean dairyFree;
    @JsonProperty("veryHealthy")
    private Boolean veryHealthy;
    @JsonProperty("cheap")
    private Boolean cheap;
    @JsonProperty("veryPopular")
    private Boolean veryPopular;
    @JsonProperty("sustainable")
    private Boolean sustainable;
    @JsonProperty("lowFodmap")
    private Boolean lowFodmap;
    @JsonProperty("weightWatcherSmartPoints")
    private Integer weightWatcherSmartPoints;
    @JsonProperty("author")
    private String author;
    @JsonProperty("gaps")
    private String gaps;
    @JsonProperty("preparationMinutes")
    private Integer preparationMinutes;
    @JsonProperty("cookingMinutes")
    private Integer cookingMinutes;
    @JsonProperty("aggregateLikes")
    private Integer aggregateLikes;
    @JsonProperty("healthScore")
    private Integer healthScore;
    @JsonProperty("creditsText")
    private String creditsText;
    @JsonProperty("license")
    private String license;
    @JsonProperty("sourceName")
    private String sourceName;
    @JsonProperty("pricePerServing")
    private Double pricePerServing;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("readyInMinutes")
    private Integer readyInMinutes;
    @JsonProperty("servings")
    private Integer servings;
    @JsonProperty("sourceUrl")
    private String sourceUrl;
    @JsonProperty("image")
    private String image;
    @JsonProperty("imageType")
    private String imageType;
    @JsonProperty("nutrition")
    private Nutrition nutrition;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("cuisines")
    private List<String> cuisines = null;
    @JsonProperty("dishTypes")
    private List<String> dishTypes = null;
    @JsonProperty("diets")
    private List<Object> diets = null;
    @JsonProperty("occasions")
    private List<Object> occasions = null;
    @JsonProperty("analyzedInstructions")
    private List<AnalyzedInstruction> analyzedInstructions = null;
    @JsonProperty("spoonacularSourceUrl")
    private String spoonacularSourceUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("vegetarian")
    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    @JsonProperty("vegan")
    public Boolean getVegan() {
        return vegan;
    }

    @JsonProperty("vegan")
    public void setVegan(Boolean vegan) {
        this.vegan = vegan;
    }

    @JsonProperty("glutenFree")
    public Boolean getGlutenFree() {
        return glutenFree;
    }

    @JsonProperty("glutenFree")
    public void setGlutenFree(Boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    @JsonProperty("dairyFree")
    public Boolean getDairyFree() {
        return dairyFree;
    }

    @JsonProperty("dairyFree")
    public void setDairyFree(Boolean dairyFree) {
        this.dairyFree = dairyFree;
    }

    @JsonProperty("veryHealthy")
    public Boolean getVeryHealthy() {
        return veryHealthy;
    }

    @JsonProperty("veryHealthy")
    public void setVeryHealthy(Boolean veryHealthy) {
        this.veryHealthy = veryHealthy;
    }

    @JsonProperty("cheap")
    public Boolean getCheap() {
        return cheap;
    }

    @JsonProperty("cheap")
    public void setCheap(Boolean cheap) {
        this.cheap = cheap;
    }

    @JsonProperty("veryPopular")
    public Boolean getVeryPopular() {
        return veryPopular;
    }

    @JsonProperty("veryPopular")
    public void setVeryPopular(Boolean veryPopular) {
        this.veryPopular = veryPopular;
    }

    @JsonProperty("sustainable")
    public Boolean getSustainable() {
        return sustainable;
    }

    @JsonProperty("sustainable")
    public void setSustainable(Boolean sustainable) {
        this.sustainable = sustainable;
    }

    @JsonProperty("lowFodmap")
    public Boolean getLowFodmap() {
        return lowFodmap;
    }

    @JsonProperty("lowFodmap")
    public void setLowFodmap(Boolean lowFodmap) {
        this.lowFodmap = lowFodmap;
    }

    @JsonProperty("weightWatcherSmartPoints")
    public Integer getWeightWatcherSmartPoints() {
        return weightWatcherSmartPoints;
    }

    @JsonProperty("weightWatcherSmartPoints")
    public void setWeightWatcherSmartPoints(Integer weightWatcherSmartPoints) {
        this.weightWatcherSmartPoints = weightWatcherSmartPoints;
    }

    @JsonProperty("gaps")
    public String getGaps() {
        return gaps;
    }

    @JsonProperty("gaps")
    public void setGaps(String gaps) {
        this.gaps = gaps;
    }

    @JsonProperty("preparationMinutes")
    public Integer getPreparationMinutes() {
        return preparationMinutes;
    }

    @JsonProperty("preparationMinutes")
    public void setPreparationMinutes(Integer preparationMinutes) {
        this.preparationMinutes = preparationMinutes;
    }

    @JsonProperty("cookingMinutes")
    public Integer getCookingMinutes() {
        return cookingMinutes;
    }

    @JsonProperty("cookingMinutes")
    public void setCookingMinutes(Integer cookingMinutes) {
        this.cookingMinutes = cookingMinutes;
    }

    @JsonProperty("aggregateLikes")
    public Integer getAggregateLikes() {
        return aggregateLikes;
    }

    @JsonProperty("aggregateLikes")
    public void setAggregateLikes(Integer aggregateLikes) {
        this.aggregateLikes = aggregateLikes;
    }

    @JsonProperty("healthScore")
    public Integer getHealthScore() {
        return healthScore;
    }

    @JsonProperty("healthScore")
    public void setHealthScore(Integer healthScore) {
        this.healthScore = healthScore;
    }

    @JsonProperty("creditsText")
    public String getCreditsText() {
        return creditsText;
    }

    @JsonProperty("creditsText")
    public void setCreditsText(String creditsText) {
        this.creditsText = creditsText;
    }

    @JsonProperty("license")
    public String getLicense() {
        return license;
    }

    @JsonProperty("license")
    public void setLicense(String license) {
        this.license = license;
    }

    @JsonProperty("sourceName")
    public String getSourceName() {
        return sourceName;
    }

    @JsonProperty("sourceName")
    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    @JsonProperty("pricePerServing")
    public Double getPricePerServing() {
        return pricePerServing;
    }

    @JsonProperty("pricePerServing")
    public void setPricePerServing(Double pricePerServing) {
        this.pricePerServing = pricePerServing;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("readyInMinutes")
    public Integer getReadyInMinutes() {
        return readyInMinutes;
    }

    @JsonProperty("readyInMinutes")
    public void setReadyInMinutes(Integer readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }

    @JsonProperty("servings")
    public Integer getServings() {
        return servings;
    }

    @JsonProperty("servings")
    public void setServings(Integer servings) {
        this.servings = servings;
    }

    @JsonProperty("sourceUrl")
    public String getSourceUrl() {
        return sourceUrl;
    }

    @JsonProperty("sourceUrl")
    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("imageType")
    public String getImageType() {
        return imageType;
    }

    @JsonProperty("imageType")
    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    @JsonProperty("nutrition")
    public Nutrition getNutrition() {
        return nutrition;
    }

    @JsonProperty("nutrition")
    public void setNutrition(Nutrition nutrition) {
        this.nutrition = nutrition;
    }

    @JsonProperty("summary")
    public String getSummary() {
        return summary;
    }

    @JsonProperty("summary")
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @JsonProperty("cuisines")
    public List<String>  getCuisines() {
        return cuisines;
    }

    @JsonProperty("cuisines")
    public void setCuisines(List<String> cuisines) {
        this.cuisines = cuisines;
    }

    @JsonProperty("dishTypes")
    public List<String> getDishTypes() {
        return dishTypes;
    }

    @JsonProperty("dishTypes")
    public void setDishTypes(List<String> dishTypes) {
        this.dishTypes = dishTypes;
    }

    @JsonProperty("diets")
    public List<Object> getDiets() {
        return diets;
    }

    @JsonProperty("diets")
    public void setDiets(List<Object> diets) {
        this.diets = diets;
    }

    @JsonProperty("occasions")
    public List<Object> getOccasions() {
        return occasions;
    }

    @JsonProperty("occasions")
    public void setOccasions(List<Object> occasions) {
        this.occasions = occasions;
    }

    @JsonProperty("analyzedInstructions")
    public List<AnalyzedInstruction> getAnalyzedInstructions() {
        return analyzedInstructions;
    }

    @JsonProperty("analyzedInstructions")
    public void setAnalyzedInstructions(List<AnalyzedInstruction> analyzedInstructions) {
        this.analyzedInstructions = analyzedInstructions;
    }

    @JsonProperty("spoonacularSourceUrl")
    public String getSpoonacularSourceUrl() {
        return spoonacularSourceUrl;
    }

    @JsonProperty("spoonacularSourceUrl")
    public void setSpoonacularSourceUrl(String spoonacularSourceUrl) {
        this.spoonacularSourceUrl = spoonacularSourceUrl;
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
