package com.samirsantos.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.samirsantos.cursomc.services.DbService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DbService dbService;
	
	@Bean
	public boolean instanciateDatabase() throws ParseException {
		
		dbService.instaciateDatabase();
		return true;
	}
}
