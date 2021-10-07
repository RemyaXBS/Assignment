package com.inf.assignment.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Request {
	/**
	 * variable used to store the input array
	 */
	private Object[] input;
}
