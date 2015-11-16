package com.spring.redis.sentinel.cache;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.JedisSentinelPool;

import com.spring.redis.sentinel.config.RedisConfig;

/**
 *
 *
 * @author yaochong.chen
 */
public final class RedisCache {

	private String id;

	private static JedisSentinelPool pool;

	public RedisCache(final String id) {
		if (id == null) {
			throw new IllegalArgumentException("Cache instances require an ID");
		}
		this.id = id;
		RedisConfig redisConfig = RedisConfig.getInstance();
		Set<String> sentines = new HashSet<String>();
		sentines.add(redisConfig.getHost() + ":" + redisConfig.getPort());
		pool = new JedisSentinelPool("mymaster", sentines, redisConfig,
				redisConfig.getConnectionTimeout(), redisConfig.getSoTimeout(),
				redisConfig.getPassword(), redisConfig.getDatabase(),
				redisConfig.getClientName());
	}

}
