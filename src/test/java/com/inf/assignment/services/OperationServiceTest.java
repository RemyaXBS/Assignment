package com.inf.assignment.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.inf.assignment.models.Request;
import com.inf.assignment.models.Result;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class OperationServiceTest {

	@InjectMocks
	private OperationService service;

	
	private Request request;	
	private Result expectedResult;

	@Before
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetResultsSuccessResponse() {
		request = Request.builder().input(new Object[] { 10, 20, 30 }).build();
		Result testResult = null;
		try {
			testResult = service.getResults(request);
		} catch (Exception e) {
			log.error("ERROR - ", e);

		}
		expectedResult = Result.builder().sum(60).average(20).greaterThanAverage(new Object[] { 30 }).build();
		assertEquals(testResult, expectedResult);
	}

	@Test
	public void testGetResultsInvalidInput() {
		request = Request.builder().input(new Object[] { "a", 20, 30 }).build();
		String expectedErrorMsg = "Numeric input expected, received invalid numbers in input";
		Exception exception = null;		
		try {
			service.getResults(request);
		} catch (Exception e) {
			log.error("ERROR - ", e.getMessage());
			exception= e;
		}
		assertEquals(exception.getMessage(), expectedErrorMsg);
	}
	
}
