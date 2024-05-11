package com.example.urlshortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class UrlShortenerApplication implements CommandLineRunner {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	public static void main(String[] args) {
		SpringApplication.run(UrlShortenerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Save a value in Redis
		redisTemplate.opsForValue().set("testKey", "testValue");

		// Retrieve the value from Redis
		String value = redisTemplate.opsForValue().get("testKey");
		System.out.println("Value from Redis: " + value);
	}
}
