package com.spring.redis.sentinel.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;
@Configuration
@PropertySource("classpath:/com/spring/redis/sentinel/config/redis.properties")
class Config{
}
public class RedisConfig2 extends JedisPoolConfig{
	private String host = Protocol.DEFAULT_HOST;
	private int port = Protocol.DEFAULT_PORT;
	private int connectionTimeout = Protocol.DEFAULT_TIMEOUT;
	private int soTimeout = Protocol.DEFAULT_TIMEOUT;
	private String password;
	private int database = Protocol.DEFAULT_DATABASE;
	private String clientName;
	public static AnnotationConfigApplicationContext init(){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(Config.class);
		ctx.refresh();
		return ctx;
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
