package digital.quintino.financeiroapi.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import digital.quintino.financeiroapi.utility.DateUtility;

public class ErrorMensageResponseDTO {
	
	@JsonProperty("Status Code")
	private String statusCode;
	
	@JsonProperty("Message")
	private String message;
	
	@JsonProperty("Data")
	private String date;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDate() {
		return DateUtility.formatarData(new Date());
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
