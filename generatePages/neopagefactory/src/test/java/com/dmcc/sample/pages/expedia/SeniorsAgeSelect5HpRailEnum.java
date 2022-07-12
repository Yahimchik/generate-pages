package com.dmcc.sample.pages.expedia;

public enum SeniorsAgeSelect5HpRailEnum {
	Age(0),
	VALUE_OF_60(1),
	VALUE_OF_61(2),
	VALUE_OF_62(3);

	protected String[] actualValues = {
		"Age",
		"60",
		"61",
		"62+",
	};

	private int intVal = -1;

	public String toString(){
		return actualValues[intVal];
	}

	SeniorsAgeSelect5HpRailEnum(final int intVal){
		this.intVal = intVal;
	}
}
