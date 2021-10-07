package com.inf.assignment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inf.assignment.models.CommonResponse;
import com.inf.assignment.models.Request;
import com.inf.assignment.models.Result;
import com.inf.assignment.services.OperationService;

@RestController
@RequestMapping("/api")
public class OperationController {
	
	@Autowired
	OperationService operationService;

	@PostMapping("/numberoperations")
	public ResponseEntity<?> numberOperations(@RequestBody Request input) {
		
		try {
			Result result = operationService.getResults(input) ;			
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(CommonResponse.builder().status("SUCCESS")
							.results(result)
							.build()	 
						);
		} catch (Exception e) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(CommonResponse.builder().status("FAILED").msg(e.getMessage()).build());
		}
		
	}
	
}
