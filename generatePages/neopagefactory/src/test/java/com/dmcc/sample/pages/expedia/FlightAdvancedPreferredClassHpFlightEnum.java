package com.dmcc.sample.pages.expedia;

public enum FlightAdvancedPreferredClassHpFlightEnum {
	Firstclass(0),
	Business(1),
	Premiumeconomy(2),
	Economy(3);

	protected String[] actualValues = {
		"First class",
		"Business",
		"Premium economy",
		"Economy",
	};

	private int intVal = -1;

	public String toString(){
		return actualValues[intVal];
	}

	FlightAdvancedPreferredClassHpFlightEnum(final int intVal){
		this.intVal = intVal;
	}
}
