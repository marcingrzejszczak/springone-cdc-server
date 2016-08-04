package com.example;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

	@RequestMapping(value = "/check",
			method=RequestMethod.POST,
			consumes="application/json",
			produces="application/json")
	public Response check(@RequestBody PersonToCheck personToCheck) {
		if (personToCheck.age >= 20) {
			return new Response(BeerCheckStatus.OK);
		}
		return new Response(BeerCheckStatus.NOT_OK);
	}
	
}

class PersonToCheck {
	public int age;
}

class Response {
	public BeerCheckStatus status;
	
	Response(BeerCheckStatus status) {
		this.status = status;
	}
}

enum BeerCheckStatus {
	OK, NOT_OK
}