package com.dmcc.sample.pages.expedia;

public enum FlightHotelsRoomsHpFlightEnum {
	VALUE_OF_1(0),
	VALUE_OF_2(1),
	VALUE_OF_3(2);

	protected String[] actualValues = {
		"1",
		"2",
		"3",
	};

	private int intVal = -1;

	public String toString(){
		return actualValues[intVal];
	}

	FlightHotelsRoomsHpFlightEnum(final int intVal){
		this.intVal = intVal;
	}
}
