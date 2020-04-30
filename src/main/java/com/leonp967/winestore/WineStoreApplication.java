package com.leonp967.winestore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableCaching
@ComponentScan(basePackages = "com.leonp967.winestore")
@EnableJpaRepositories(basePackages = "com.leonp967.winestore.dao")
@EnableFeignClients(basePackages = "com.leonp967.winestore.client")
public class WineStoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(WineStoreApplication.class, args);
	}
}
