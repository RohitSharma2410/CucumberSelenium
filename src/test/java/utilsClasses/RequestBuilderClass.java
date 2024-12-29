package utilsClasses;

import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class RequestBuilderClass {
	private Properties property = null;
	private RequestSpecification rest = null;
	private String requestName = null;

	public RequestBuilderClass(Properties properties, String requestName) {
		this.property = properties;
		rest = RestAssured.given();
		this.requestName = requestName;

	}

	public RequestSpecification buildHeadersParameters() {
		String headerKey = "";
		for (Object e : property.keySet()) {
			if (e.toString().equalsIgnoreCase(requestName + "_headers")) {
				headerKey = e.toString();
			}
		}

		if (headerKey != "") {
			for (String headers : headerKey.split("&&&")) {

				rest.header(headers.split("=")[0], headers.split("=")[1]);
			}
		}
		return rest;
	}

	public RequestSpecification buildQueryParameters() {
		String queryKey = "";
		for (Object e : property.keySet()) {
			if (e.toString().equalsIgnoreCase(requestName + "queries")) {
				queryKey = e.toString();
			}
		}

		if (queryKey != "") {
			for (String headers : queryKey.split("&&&")) {

				rest.header(headers.split("=")[0], headers.split("=")[1]);
			}
		}
		return rest;
	}
}
