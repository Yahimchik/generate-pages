package com.dmcc.sample.pages.expedia;

public enum RoomsEnum {
	VALUE_OF_1(0),
	VALUE_OF_2(1),
	VALUE_OF_3(2),
	VALUE_OF_4(3),
	VALUE_OF_5(4),
	VALUE_OF_6(5),
	VALUE_OF_7(6),
	VALUE_OF_8(7),
	VALUE_OF_9(8);

	protected String[] actualValues = {
		"1",
		"2",
		"3",
		"4",
		"5",
		"6",
		"7",
		"8",
		"9+",
	};

	private int intVal = -1;

	public String toString(){
		return actualValues[intVal];
	}

	RoomsEnum(final int intVal){
		this.intVal = intVal;
	}
}
