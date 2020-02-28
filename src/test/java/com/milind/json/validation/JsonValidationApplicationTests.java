package com.milind.json.validation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonValidationApplicationTests {

	@Test
	public void testJsonSchemaInRequestObject() {

		JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder()
				.setValidationConfiguration(
						ValidationConfiguration.newBuilder().setDefaultVersion(SchemaVersion.DRAFTV4).freeze())
				.freeze();

		given().body(JsonValidationApplicationTests.class.getResourceAsStream("schema/employee.json")).when()
				.get("/validate").then().assertThat()
				.body(matchesJsonSchemaInClasspath("schema/schema.json").using(jsonSchemaFactory));

	}

}
