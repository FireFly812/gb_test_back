
package lesson3.shopingList.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "amount",
    "unit"
})
@Data
public class Us {

    @JsonProperty("amount")
    public Double amount;
    @JsonProperty("unit")
    public String unit;

}
