package com.digitalhouse.backend.integrador.clinicaOdontologica;

import org.apache.juli.logging.Log;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class ClinicaOdontologicaApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(ClinicaOdontologicaApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ClinicaOdontologicaApplication.class, args);
		LOGGER.info("LA CLINICA ODONTOLÓGICA MM ARRANCÓ A FUNCIONAR");
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}


}
