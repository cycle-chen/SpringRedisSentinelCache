package com.spring.redis.sentinel.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 *
 */
@Configuration
@EnableCaching
@PropertySource("classpath:/redis.properites")
public class RedisConfig {
	private @Value("${host}") String redisHost;
	private @Value("${port}") Integer redisPort;
	private @Value("${master}") String master;
	private @Value("${connectionTimeout}") Integer connectionTimeout;
	private @Value("${soTimeout}") Integer soTimeout;
	private @Value("${password}") String password;
	private @Value("${database}") Integer database;
	private @Value("${password}") String clientName;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		RedisSentinelConfiguration sentinel_config = new RedisSentinelConfiguration()
				.master(master).sentinel(redisHost, redisPort);
		JedisConnectionFactory factory = new JedisConnectionFactory(
				sentinel_config);
		// JedisConnectionFactory factory = new JedisConnectionFactory();
		factory.setHostName(redisHost);
		factory.setPort(redisPort);
		factory.setTimeout(3000);
		factory.setUsePool(true);
		return factory;
	}

	@Bean
	public RedisTemplate<Object, Object> redisTemplate() {
		RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<Object, Object>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}

	@Bean
	public Map<String, Long> cachedObjectValues() {
		Map<String, Long> stringLongMap = new HashMap<String, Long>();
		stringLongMap.put("cache1", 200L);
		return stringLongMap;
	}

	@Bean
	public CacheManager cacheManager() {
		RedisCacheManager redisCacheManager = new RedisCacheManager(
				redisTemplate());
		redisCacheManager.setExpires(cachedObjectValues());

		return redisCacheManager;
	}

}
