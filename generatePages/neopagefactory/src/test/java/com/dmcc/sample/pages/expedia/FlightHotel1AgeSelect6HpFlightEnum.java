package com.dmcc.sample.pages.expedia;

public enum FlightHotel1AgeSelect6HpFlightEnum {
	Age(0),
	Under1(1),
	VALUE_OF_1(2),
	VALUE_OF_2(3),
	VALUE_OF_3(4),
	VALUE_OF_4(5),
	VALUE_OF_5(6),
	VALUE_OF_6(7),
	VALUE_OF_7(8),
	VALUE_OF_8(9),
	VALUE_OF_9(10),
	VALUE_OF_10(11),
	VALUE_OF_11(12),
	VALUE_OF_12(13),
	VALUE_OF_13(14),
	VALUE_OF_14(15),
	VALUE_OF_15(16),
	VALUE_OF_16(17),
	VALUE_OF_17(18);

	protected String[] actualValues = {
		"Age",
		"Under 1",
		"1",
		"2",
		"3",
		"4",
		"5",
		"6",
		"7",
		"8",
		"9",
		"10",
		"11",
		"12",
		"13",
		"14",
		"15",
		"16",
		"17",
	};

	private int intVal = -1;

	public String toString(){
		return actualValues[intVal];
	}

	FlightHotel1AgeSelect6HpFlightEnum(final int intVal){
		this.intVal = intVal;
	}
}
