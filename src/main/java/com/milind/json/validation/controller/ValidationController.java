package com.milind.json.validation.controller;



import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.milind.json.validation.domain.Employee;
import com.milind.json.validation.impl.ValidationUtil;

@RestController
public class ValidationController {
	
	private static final Logger log = LogManager.getLogger(ValidationController.class);
	
	@GetMapping("/validate")
	public Boolean validateRequestData(@RequestBody Employee emp){
		
		boolean validJson = false;
		
		File schemaFile = new File("/schema/schema.json");
	    File jsonFile = new File("/Users/XYZ/data.json");
	    	
	    try {
			if (ValidationUtil.isJsonValid(schemaFile, jsonFile)){
				validJson = true;
				log.info("The received JSON is valid {}", validJson);
			}else{
				log.info("The received JSON is valid {}", validJson);
			}
		} catch (ProcessingException | IOException e) {
			log.error("Exception received while processing message {}", e.getCause());
		}
		
		return validJson;
		
	}
	
}
