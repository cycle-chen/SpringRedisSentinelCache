/*------------------------------------------------------------------------------
 * COPYRIGHT Ericsson 2015
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *----------------------------------------------------------------------------*/
package com.spring.redis.sentinel.cache.entity;

import java.io.Serializable;

public class Account implements Serializable {
	/**
	 * TODO javadoc for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;

	public Account(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	//
	// @Override
	// public String toString() {
	// return this.name + this.id;
	// }
}
