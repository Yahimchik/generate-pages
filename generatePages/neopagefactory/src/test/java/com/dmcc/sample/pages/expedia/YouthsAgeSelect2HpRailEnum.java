package com.dmcc.sample.pages.expedia;

public enum YouthsAgeSelect2HpRailEnum {
	Age(0),
	VALUE_OF_16(1),
	VALUE_OF_17(2),
	VALUE_OF_18(3),
	VALUE_OF_19(4),
	VALUE_OF_20(5),
	VALUE_OF_21(6),
	VALUE_OF_22(7),
	VALUE_OF_23(8),
	VALUE_OF_24(9),
	VALUE_OF_25(10);

	protected String[] actualValues = {
		"Age",
		"16",
		"17",
		"18",
		"19",
		"20",
		"21",
		"22",
		"23",
		"24",
		"25",
	};

	private int intVal = -1;

	public String toString(){
		return actualValues[intVal];
	}

	YouthsAgeSelect2HpRailEnum(final int intVal){
		this.intVal = intVal;
	}
}
