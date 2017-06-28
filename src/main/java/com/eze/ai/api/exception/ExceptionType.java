package com.eze.ai.api.exception;


public enum ExceptionType {
	CONFIG_ERROR("COnfiguration is Missing/Invalid.!!", 1000, "APP ERROR",
			"Application Issue", 500),
	VALIDATION_ERROR("Validation of data failed", 1001, "BAD Request",
			"CLIENT[DATA]", 400),
	METHOD_NOT_SUPPORTED("Method Not Supported by API", 1002, "BAD Request",
			"CLIENT-REQUEST", 501),
	INVALID_URL("URL is not supported by API", 1003, "BAD Request",
			"CLIENT-REQUEST", 404),
	KAFKA_INIT_ERROR("Cannot Start Kafka Connector", 1004,
			"INITIALIZATION-ERROR", "KAFKA", 500),
	KAFKA_CONNECTOR_ERROR("Kafka connector cannot connect to Kafka-Cluster",
			1005, "CONNECTION-ISSUE", "KAFKA", 500),
	JSON_PARSE_ERROR("Json Parsing Failed !!", 1006, "BAD Request",
			"CLIENT-REQUEST", 400),
	NO_RECORDS_FOUND_ERROR("No records in AERO", 1007, "NO-RECORDS",
			"AEROSPIKE", 404),
	INVALID_TEMPORAL_FIELDS("Invalid data/format for date/month fields", 1008,
			"BAD_REQUEST", "CLIENT-REQUEST", 400),
	KAFKA_SERIALIZATION_ERROR("Cannot Serialize Data to bytes", 1009,
			"BAD_REQUEST", "CLIENT-REQUEST", 400),
	SOLR_INIT_ERROR("Cannot Connect to SOLR, with given Config", 1010,
			"BAD_CONFIG", "APP_ISSUE", 500),
	INVALID_USER_ERROR("Cannot Find this USER !!", 1011, "BAD Request",
			"CLIENT-REQUEST", 400),
	INVALID_USER_REQUIREMENT("Cannot Find this  Requirement for this User !!",
			1012, "BAD Request", "CLIENT-REQUEST", 400),
	SOLR_QUERY_EXCEPTION("Solr Client throws SOLR Exception, while Querying !!",
			1013, "CONNECTION-ISSUE", "Solr Communication Issue", 500),
	NO_REQMT_MATCH_FOR_CRITERIA(
			"No Requiremnts Match the given Criteria for this User !!", 1014,
			"BAD Request", "CLIENT-REQUEST", 404),
	USER_REQUIREMENT_NOT_AVAILABLE("Profile is exist but Requirements are not available for this User!!",
			1012, "BAD Request", "CLIENT-REQUEST", 400),;

	private String message;
	private int errorCode;
	private String localizedMessage;
	private String cause;
	private int responseCode;

	private ExceptionType(String message, int errorCode,
			String localizedMessage, String cause, int responseCode) {
		this.message = message;
		this.errorCode = errorCode;
		this.localizedMessage = localizedMessage;
		this.cause = cause;
		this.responseCode = responseCode;
	}

	/**
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return name() + "[message=" + message + ", errorCode=" + errorCode
				+ ", localizedMessage=" + localizedMessage + ", cause=" + cause
				+ ", responseCode=" + responseCode + "]";
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @return the localizedMessage
	 */
	public String getLocalizedMessage() {
		return localizedMessage;
	}

	/**
	 * @return the cause
	 */
	public String getCause() {
		return cause;
	}

	/**
	 * @return the responseCode
	 */
	public int getResponseCode() {
		return responseCode;
	}

}
