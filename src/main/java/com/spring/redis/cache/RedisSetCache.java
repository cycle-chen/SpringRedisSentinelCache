package com.spring.redis.cache;

/*------------------------------------------------------------------------------
 * COPYRIGHT Ericsson 2015
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *----------------------------------------------------------------------------*/

import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisSetCache extends RedisCache {

	public RedisSetCache(String name, byte[] prefix,
			RedisTemplate<? extends Object, ? extends Object> template,
			long expiration) {
		super(name, prefix, template, expiration);
	}

}
