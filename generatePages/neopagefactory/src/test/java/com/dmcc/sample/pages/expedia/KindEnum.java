package com.dmcc.sample.pages.expedia;

public enum KindEnum {
	Nopreference(0),
	Economy(1),
	Compact(2),
	Midsize(3),
	Standard(4),
	Fullsize(5),
	Premium(6),
	Luxury(7);

	protected String[] actualValues = {
		"No preference",
		"Economy",
		"Compact",
		"Midsize",
		"Standard",
		"Fullsize",
		"Premium",
		"Luxury",
	};

	private int intVal = -1;

	public String toString(){
		return actualValues[intVal];
	}

	KindEnum(final int intVal){
		this.intVal = intVal;
	}
}
