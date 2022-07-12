package com.dmcc.sample.pages.expedia;

public enum FlightAdvancedPreferredAirlineHpFlightEnum {
	Nopreference(0);

	protected String[] actualValues = {
		" No preference"
	};

	private int intVal = -1;

	public String toString(){
		return actualValues[intVal];
	}

	FlightAdvancedPreferredAirlineHpFlightEnum(final int intVal){
		this.intVal = intVal;
	}
}
