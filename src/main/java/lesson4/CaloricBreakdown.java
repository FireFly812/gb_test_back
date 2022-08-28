
package lesson4;

import java.util.HashMap;
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
    "percentProtein",
    "percentFat",
    "percentCarbs"
})
@Data
public class CaloricBreakdown {

    @JsonProperty("percentProtein")
    private Double percentProtein;
    @JsonProperty("percentFat")
    private Double percentFat;
    @JsonProperty("percentCarbs")
    private Double percentCarbs;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("percentProtein")
    public Double getPercentProtein() {
        return percentProtein;
    }

    @JsonProperty("percentProtein")
    public void setPercentProtein(Double percentProtein) {
        this.percentProtein = percentProtein;
    }

    @JsonProperty("percentFat")
    public Double getPercentFat() {
        return percentFat;
    }

    @JsonProperty("percentFat")
    public void setPercentFat(Double percentFat) {
        this.percentFat = percentFat;
    }

    @JsonProperty("percentCarbs")
    public Double getPercentCarbs() {
        return percentCarbs;
    }

    @JsonProperty("percentCarbs")
    public void setPercentCarbs(Double percentCarbs) {
        this.percentCarbs = percentCarbs;
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
