package com.speaktoit.twilio;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class TwilioProperties {
	private static final Logger LOGGER = LoggerFactory.getLogger(TwilioProperties.class);
	private static final String TWILIO_PROP_NAME = "twilio.properties";

	public static final TwilioProperties INSTANCE = new TwilioProperties();

	private final Properties properties;

	private TwilioProperties() {
		properties = new Properties();
		try {
			properties.load(this.getClass().getClassLoader().getResourceAsStream(TWILIO_PROP_NAME));
		} catch (IOException e) {
			LOGGER.error("Failed to parse properties: " + TWILIO_PROP_NAME, e);
		}
	}

	public String get(String name) {
		return properties.getProperty(name);
	}

	public String getApiUrl() {
		return get("apiai.url");
	}

	public String getApiAccessToken() {
		return get("apiai.accessToken");
	}

	public String getTimezone() {
		return properties.getProperty("apiai.timezone", "-0700");
	}
}
