package com.spring.redis.sentinel.config;

import java.io.IOException;

import org.springframework.core.io.support.ResourcePropertySource;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;

/*
 * author:yaochong.chen
 */
public class RedisConfig extends JedisPoolConfig {
	private static final RedisConfig instance = new RedisConfig();
	private String host = Protocol.DEFAULT_HOST;
	private int port = Protocol.DEFAULT_PORT;
	private int connectionTimeout = Protocol.DEFAULT_TIMEOUT;
	private int soTimeout = Protocol.DEFAULT_TIMEOUT;
	private String password;
	private int database = Protocol.DEFAULT_DATABASE;
	private String clientName;

	public static RedisConfig getInstance() {
		return instance;
	}

	private RedisConfig() {
		try {
			ResourcePropertySource r = new ResourcePropertySource(
					"fsdfresources", "classpath:/redis.properties");
			host = r.getProperty("host").toString();
			port = Integer.getInteger(r.getProperty("port").toString());
			connectionTimeout = Integer.getInteger(r.getProperty(
					"connectionTimeout").toString());
			soTimeout = Integer.getInteger(r.getProperty("soTimeout")
					.toString());
			password = r.getProperty("password").toString();
			database = Integer.getInteger(r.getProperty("database").toString());
			clientName = r.getProperty("clientName").toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		if ((host == null) || "".equals(host)) {
			host = Protocol.DEFAULT_HOST;
		}
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if ("".equals(password)) {
			password = null;
		}
		this.password = password;
	}

	public int getDatabase() {
		return database;
	}

	public void setDatabase(int database) {
		this.database = database;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		if ("".equals(clientName)) {
			clientName = null;
		}
		this.clientName = clientName;
	}

	public int getConnectionTimeout() {
		return connectionTimeout;
	}

	public void setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}

	public int getSoTimeout() {
		return soTimeout;
	}

	public void setSoTimeout(int soTimeout) {
		this.soTimeout = soTimeout;
	}

}
