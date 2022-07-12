package com.dmcc.sample.pages.expedia;

public enum PackageAdultsHpPackageEnum {
	VALUE_OF_1(0),
	VALUE_OF_2(1),
	VALUE_OF_3(2),
	VALUE_OF_4(3),
	VALUE_OF_5(4),
	VALUE_OF_6(5);

	protected String[] actualValues = {
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

	PackageAdultsHpPackageEnum(final int intVal){
		this.intVal = intVal;
	}
}
