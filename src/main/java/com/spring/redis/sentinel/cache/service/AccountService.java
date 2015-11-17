/*------------------------------------------------------------------------------
 * COPYRIGHT Ericsson 2015
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *----------------------------------------------------------------------------*/
package com.spring.redis.sentinel.cache.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;
import com.spring.redis.sentinel.cache.entity.Account;

@Service
public class AccountService {
	private final Logger logger = LoggerFactory.getLogger(AccountService.class);

	// 使用了一个缓存名叫 accountCache
	@Cacheable(value = "accountCache")
	public Account getAccountByName(String accountName) {
		System.out.println("real querying account... {}" + accountName);
		// 方法内部实现不考虑缓存逻辑，直接实现业务
		logger.info("real querying account... {}", accountName);
		Optional<Account> accountOptional = getFromDB(accountName);
		if (!accountOptional.isPresent()) {
			throw new IllegalStateException(String.format(
					"can not find account by account name : [%s]", accountName));
		}

		return accountOptional.get();
	}

	private Optional<Account> getFromDB(String accountName) {
		logger.info("real querying db... {}", accountName);
		// Todo query data from database
		return Optional.fromNullable(new Account(accountName));
	}
}
