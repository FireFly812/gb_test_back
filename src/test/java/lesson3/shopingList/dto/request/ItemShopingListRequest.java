package lesson3.shopingList.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;

/**
 * @author Sveta
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "item", "aisle", "parse" })
public class ItemShopingListRequest implements Serializable {
	@JsonProperty("item")
	public String item;
	@JsonProperty("aisle")
	public String aisle;
	@JsonProperty("parse")
	public Boolean parse;
	private final static long serialVersionUID = 7571580364969367089L;

	/**
	 * No args constructor for use in serialization
	 */
	public ItemShopingListRequest() {
	}

	/**
	 * @param item
	 * @param parse
	 * @param aisle
	 */
	public ItemShopingListRequest(String item, String aisle, Boolean parse) {
		super();
		this.item = item;
		this.aisle = aisle;
		this.parse = parse;
	}
}

