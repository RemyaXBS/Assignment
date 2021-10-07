package com.inf.assignment.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Result {

	/**
	 * variable used to keep the sum
	 */
	private int sum;
	/**
	 * variable used to keep the average 
	 */
	private float average;
	private Object[] greaterThanAverage;

}
