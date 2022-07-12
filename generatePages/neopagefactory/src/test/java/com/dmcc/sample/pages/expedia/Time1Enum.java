package com.dmcc.sample.pages.expedia;

public enum Time1Enum {
	Basedonflight(0),
	VALUE_OF_0000(1),
	VALUE_OF_0100(2),
	VALUE_OF_0200(3),
	VALUE_OF_0300(4),
	VALUE_OF_0400(5),
	VALUE_OF_0500(6),
	VALUE_OF_0600(7),
	VALUE_OF_0700(8),
	VALUE_OF_0800(9),
	VALUE_OF_0900(10),
	VALUE_OF_1000(11),
	VALUE_OF_1100(12),
	VALUE_OF_1200(13),
	VALUE_OF_1300(14),
	VALUE_OF_1400(15),
	VALUE_OF_1500(16),
	VALUE_OF_1600(17),
	VALUE_OF_1700(18),
	VALUE_OF_1800(19),
	VALUE_OF_1900(20),
	VALUE_OF_2000(21),
	VALUE_OF_2100(22),
	VALUE_OF_2200(23),
	VALUE_OF_2300(24);

	protected String[] actualValues = {
		"Based on flight",
		"00:00",
		"01:00",
		"02:00",
		"03:00",
		"04:00",
		"05:00",
		"06:00",
		"07:00",
		"08:00",
		"09:00",
		"10:00",
		"11:00",
		"12:00",
		"13:00",
		"14:00",
		"15:00",
		"16:00",
		"17:00",
		"18:00",
		"19:00",
		"20:00",
		"21:00",
		"22:00",
		"23:00",
	};

	private int intVal = -1;

	public String toString(){
		return actualValues[intVal];
	}

	Time1Enum(final int intVal){
		this.intVal = intVal;
	}
}
