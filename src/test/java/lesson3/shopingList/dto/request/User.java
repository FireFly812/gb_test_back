package lesson3.shopingList.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "username", "firstName", "lastName", "email" })
public class User implements Serializable {

	@JsonProperty("username")
	public String username;
	@JsonProperty("firstName")
	public String firstName;
	@JsonProperty("lastName")
	public String lastName;
	@JsonProperty("email")
	public String email;
	private final static long serialVersionUID = 7676294368867987089L;

	/**
	 * No args constructor for use in serialization
	 */
	public User() {
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param username
	 */
	public User(String username, String firstName, String lastName, String email) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

}