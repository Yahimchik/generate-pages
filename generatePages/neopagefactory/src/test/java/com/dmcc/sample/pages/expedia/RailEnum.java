package com.dmcc.sample.pages.expedia;

public enum RailEnum {
	Selectrailcard(0),
	UKAnnualGoldCard(1),
	UKDisabilityChildRailcard(2),
	UKDisabilityRailcard(3),
	UKFamilyandFriendsRailcard(4),
	UKHMForcesRailcard(5),
	UKJobcentrePlus(6),
	UKNetworkRailcard(7),
	ScottishYouthRailcard(8),
	UKSeniorRailcard(9),
	UKTwoTogether(10),
	UKYouthRailcard1625(11);

	protected String[] actualValues = {
		"Select railcard",
		"UK Annual Gold Card",
		"UK Disability Child Railcard",
		"UK Disability Railcard",
		"UK Family and Friends Railcard",
		"UK HM Forces Railcard",
		"UK Jobcentre Plus",
		"UK Network Railcard",
		"Scottish Youth Railcard",
		"UK Senior Railcard",
		"UK Two Together",
		"UK Youth Railcard (16-25)",
	};

	private int intVal = -1;

	public String toString(){
		return actualValues[intVal];
	}

	RailEnum(final int intVal){
		this.intVal = intVal;
	}
}
