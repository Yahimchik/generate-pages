package com.dmcc.sample.pages.expedia;

public enum RetSearchByEnum {
	Departat(0),
	Arriveby(1);

	protected String[] actualValues = {
		"Depart at",
		"Arrive by",
	};

	private int intVal = -1;

	public String toString(){
		return actualValues[intVal];
	}

	RetSearchByEnum(final int intVal){
		this.intVal = intVal;
	}
}
