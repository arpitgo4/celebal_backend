package com.eze.ai.api.utils;

import com.eze.ai.api.utils.ShutdownType;


public class Shutdown {

	private ShutdownType shutdownType;

	public Shutdown(ShutdownType shutdownType) {
		this.shutdownType = shutdownType;
	}

	/**
	 * Exit the application..!! Sorry.. But Bye !!
	 */
	public void exit() {
		System.exit(shutdownType.getShutdown_code());
	}

}
