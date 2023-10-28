package com.hhovhann.rsstrackerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestRssTrackerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(RssTrackerServiceApplication::main).with(TestRssTrackerServiceApplication.class).run(args);
	}

}
