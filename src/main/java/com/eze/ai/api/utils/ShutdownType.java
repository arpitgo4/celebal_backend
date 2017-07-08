package com.eze.ai.api.utils;


public enum ShutdownType {

	// App Initialization Error
	APP_INIT_ERROR(1, "Initialization Error",
			"App Cannot be Initialized,Shutting Down..!!"),
	// Required Config is missing OR Invalid
	INVALID_CONFIG_ERROR(2, "Config Error",
			"Mandatory Configuration is missing/invalid,Shutting Down..!!"),
	// Cannot initialze Aero Client
	AERO_INIT_ERROR(3, "Aero Client Issue",
			"Cannot Connect to Aerospike, Shutting Down..!!"),
	// Aerspike Connectivity issues
	AERO_CONNECTION_ERROR(4, "Aerospike Connection Issues",
			"Cannot Connect to Aerospike, Shutting down !!"),
	// Kafka Client Initialization Issue
	KAFKA_INIT_ERROR(5, "Kafka Client Initializtaion Error",
			"Cannoot connect to Kafka Cluster, Shutting Down !!"),
	// Kafka Connectivity issues
	KAFKA_CONNECTION_ERROR(6, "Kafka Connection Issues",
			"Cannot connect to kafka cluster, Shutting down !!"),
	// SOLR Initialization Issue
	SOLR_INIT_ERROR(7, "Solr Initializarion Error",
			"Solr Cannot be Initialized,Shutting Down..!! ");

	private int shutdown_code;
	private String shutdown_cause;
	private String shutdown_message;

	/**
	 * @constructor ShutdownType
	 */
	private ShutdownType(int shutdown_code, String shutdown_cause,
			String shutdown_message) {
		this.shutdown_code = shutdown_code;
		this.shutdown_cause = shutdown_cause;
		this.shutdown_message = shutdown_message;
	}

	/**
	 * Prints the enum in beautiful style
	 * 
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ShutdownType={");
		builder.append(" shutdownCode=" + shutdown_code);
		builder.append(" ,shutdown_cause=" + shutdown_cause);
		builder.append(" ,shutdown_message=" + shutdown_message + " }");

		return builder.toString();
	}

	/**
	 * @return the shutdown_code
	 */
	public int getShutdown_code() {
		return shutdown_code;
	}

	/**
	 * @return the shutdown_cause
	 */
	public String getShutdown_cause() {
		return shutdown_cause;
	}

	/**
	 * @return the shutdown_message
	 */
	public String getShutdown_message() {
		return shutdown_message;
	}

}
