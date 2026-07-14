package com.niraj.config;

import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfig extends ResourceConfig{

	public ApplicationConfig() {
		packages("com.niraj.resources");
	}
}
