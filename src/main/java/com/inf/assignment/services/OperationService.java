package com.inf.assignment.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.inf.assignment.models.Request;
import com.inf.assignment.models.Result;

@Service
public class OperationService {

	/**
	 * @param request
	 * @returns Result
	 * @throws Exception
	 */
	public Result getResults(Request request) throws Exception {
		
		Result result = null;
		
//		Validates the length of the array
		if (request.getInput().length == 0) {
			throw new Exception("Empty Array. Please enter a valid array.");
		}
		
//		Validates the elements in the input array
		for (int i = 0; i < request.getInput().length; i++) {
			if (!(request.getInput()[i] instanceof Integer))
				throw new Exception("Numeric input expected, received invalid numbers in input");
		}
		
		List<Object>inputList = Arrays.asList(request.getInput());	
		result = Result.builder()
				.sum(findSum(inputList))
				.build();
		result.setAverage( result.getSum() / request.getInput().length );
		result.setGreaterThanAverage(findGreaterThanNumbers(inputList, result.getAverage()));
		return result;
	}
	
	
	/**
	 * @param request
	 * @return
	 */
	private int findSum(List<Object> inputObjects) {
		return inputObjects.stream()
				.mapToInt(i -> Integer.parseInt(i.toString())).sum();
	}
		
	/**
	 * @Compares the input elements with the average value available in the Results object 
	 * @param results
	 * @ returns the updated Results object
	 */
	private Object[] findGreaterThanNumbers(List<Object> inputObjects, float average) {
			
		return inputObjects.stream()
				.map(i->Integer.parseInt(i.toString()))
				.filter(i->i>average).collect(Collectors.toList()).toArray();
	}
	
	
}
