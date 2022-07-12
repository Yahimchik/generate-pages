package com.dmcc.sample.pages.expedia;

public enum RailAdultsHpRailEnum {
	VALUE_OF_0(0),
	VALUE_OF_1(1),
	VALUE_OF_2(2),
	VALUE_OF_3(3),
	VALUE_OF_4(4),
	VALUE_OF_5(5),
	VALUE_OF_6(6),
	VALUE_OF_7(7),
	VALUE_OF_8(8),
	VALUE_OF_9(9);

	protected String[] actualValues = {
		"0",
		"1",
		"2",
		"3",
		"4",
		"5",
		"6",
		"7",
		"8",
		"9",
	};

	private int intVal = -1;

	public String toString(){
		return actualValues[intVal];
	}

	RailAdultsHpRailEnum(final int intVal){
		this.intVal = intVal;
	}
}
