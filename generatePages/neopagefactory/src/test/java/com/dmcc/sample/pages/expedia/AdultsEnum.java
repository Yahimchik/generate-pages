package com.dmcc.sample.pages.expedia;

public enum AdultsEnum {
	VALUE_OF_1(0),
	VALUE_OF_2(1),
	VALUE_OF_3(2),
	VALUE_OF_4(3),
	VALUE_OF_5(4),
	VALUE_OF_6(5),
	VALUE_OF_7(6),
	VALUE_OF_8(7),
	VALUE_OF_9(8),
	VALUE_OF_10(9),
	VALUE_OF_11(10),
	VALUE_OF_12(11),
	VALUE_OF_13(12),
	VALUE_OF_14(13);

	protected String[] actualValues = {
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
	};

	private int intVal = -1;

	public String toString(){
		return actualValues[intVal];
	}

	AdultsEnum(final int intVal){
		this.intVal = intVal;
	}
}
