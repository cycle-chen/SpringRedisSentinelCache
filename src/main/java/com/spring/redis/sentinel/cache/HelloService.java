package com.spring.redis.sentinel.cache;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class HelloService {
	public String sayHello() {
		return "test!";
	}

	@Cacheable(value = "cache1", condition = "#test.equals(#test)")
	public String sayHello(String test) {
		System.out.println("that was not int the cache...,query from db");
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return "test! " + dateFormat.format(date);
	}
}
