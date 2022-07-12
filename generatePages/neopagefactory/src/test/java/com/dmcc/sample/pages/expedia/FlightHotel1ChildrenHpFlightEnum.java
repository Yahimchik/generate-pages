package com.dmcc.sample.pages.expedia;

public enum FlightHotel1ChildrenHpFlightEnum {
	VALUE_OF_0(0),
	VALUE_OF_1(1),
	VALUE_OF_2(2),
	VALUE_OF_3(3),
	VALUE_OF_4(4),
	VALUE_OF_5(5),
	VALUE_OF_6(6);

	protected String[] actualValues = {
		"0",
		"1",
		"2",
		"3",
		"4",
		"5",
		"6",
	};

	private int intVal = -1;

	public String toString(){
		return actualValues[intVal];
	}

	FlightHotel1ChildrenHpFlightEnum(final int intVal){
		this.intVal = intVal;
	}
}
