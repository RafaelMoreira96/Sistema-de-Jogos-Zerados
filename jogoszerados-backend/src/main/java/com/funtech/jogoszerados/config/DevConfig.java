package com.funtech.jogoszerados.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import com.funtech.jogoszerados.services.DBService;

public class DevConfig {
	
	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String value;
	
	@Bean
	public boolean instanciaDB() {
		if (value.equals(dbService)) {
			this.dbService.instanciaDB();
		}
		return false;
	}
}
