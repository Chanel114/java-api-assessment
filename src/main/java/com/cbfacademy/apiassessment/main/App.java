package com.cbfacademy.apiassessment.main;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbfacademy.apiassessment.api.entities.Holiday;

@SpringBootApplication
@RestController
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);

		Holiday h1 = new Holiday("Valentine's Day", LocalDate.now().plusDays(5), true);
		Holiday h2 = new Holiday("St.Patricks Day", LocalDate.now().plusDays(5), false);
		System.out.println(h1);
		System.out.println(h2);
	}

	@GetMapping("/holidays")
	@ResponseBody
	public List<Holiday> hello() {
		return List.of(
			new Holiday("Valentine's Day",
							 LocalDate.now().plusDays(5),
							 false));
	}
	
	
	
	//public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
	//	return String.format("Hello %s", name);
	}

