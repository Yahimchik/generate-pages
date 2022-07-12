package com.dmcc.sample.pages.expedia;

public enum ChildrenAgeSelect2HpRailEnum {
	Age(0),
	VALUE_OF_0(1),
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
	VALUE_OF_15(16);

	protected String[] actualValues = {
		"Age",
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
		"10",
		"11",
		"12",
		"13",
		"14",
		"15",
	};

	private int intVal = -1;

	public String toString(){
		return actualValues[intVal];
	}

	ChildrenAgeSelect2HpRailEnum(final int intVal){
		this.intVal = intVal;
	}
}
