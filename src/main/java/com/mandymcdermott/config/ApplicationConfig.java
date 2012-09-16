package com.mandymcdermott.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

import com.mandymcdermott.config.annotation.Dev;
import com.mandymcdermott.config.annotation.Prod;

@Configuration
@ImportResource("WEB-INF/spring/*-context.xml")
@ComponentScan(basePackages = "com.mandymcdermott", excludeFilters = { @Filter(Configuration.class) })
public class ApplicationConfig {

	/** Properties to support the 'embedded' mode of operation. */
	@Dev @Configuration
	@PropertySource("config/dev.properties")
	static class Development {
	}

	/** Properties to support the 'standard' mode of operation. */
	@Prod @Configuration
	@PropertySource("config/prod.properties")
	static class Production {
	}
}
