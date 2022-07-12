package com.dmcc.pagegen.tags.parent;

public enum ByTypeEnum {

	id(0), name(1), xpath(2);
	
	private int intVal;
	
	ByTypeEnum(final int intVal){
		this.intVal = intVal;
	}
	
	public int getIntVal(){
		return this.intVal;
	}
	
	public static boolean valid(String val){
		
		if(val==null){
			return false;
		}
		
		return ByTypeEnum.valueOf(val)!=null;
	}
}
