package com.eze.ai.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConnectorAPIMain {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConnectorAPIMain.class);

	public static void main(String[] args) {
		LOGGER.info("Starting ConnectorAPI Service..!!");
		SpringApplication.run(ConnectorAPIMain.class, args);
	}
}

