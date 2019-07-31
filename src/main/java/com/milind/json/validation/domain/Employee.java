package com.milind.json.validation.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@JsonPropertyOrder(value = {"id","name", "age", "dateOfBirth"})
public class Employee {
	
	@JsonProperty
	@Getter
	@Setter
    private int id;
	
	@JsonProperty
	@Getter
	@Setter
	private String name;
	
	@JsonProperty
	@Getter
	@Setter
	private int age;
	
	@JsonProperty
	@Getter
	@Setter
	private String dateOfBirth;

}
