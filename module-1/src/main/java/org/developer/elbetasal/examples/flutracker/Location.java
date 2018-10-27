package org.developer.elbetasal.examples.flutracker;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Location {
	private String stateName;
	private String stateShortName;
	private String country;
	private String countryCode;
}
