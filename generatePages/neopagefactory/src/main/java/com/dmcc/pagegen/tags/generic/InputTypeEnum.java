package com.dmcc.pagegen.tags.generic;

import static com.dmcc.utils.io.Io.debug;

public enum InputTypeEnum {
	 Text(0), Password(1),	 Submit(2),
	 Reset(3), Radio(4), Checkbox(5),
	 Button(6), Color(7), Date(8),
	 Datetimelocal(9), Email(10),
	 File(11), Month(12), Number(13),
	 Range(14), Search(15), Tel(16), 
	 Time(17), Url(18), Week(19);
	
	 private int intVal;
	
	 InputTypeEnum(int intVal){
		 this.intVal=intVal;
	 }
	 
	 public static boolean isInputTextField(final InputTypeEnum type){
		 return (type!=null?isInputTextField(type.toString()):false);
	 }
	 
	 public static boolean isInputTextField(final String type){
		 boolean isSettable=false;
		 
		 InputTypeEnum enumVal = parse(type);
		 

		 if(enumVal!=null){
			 if(enumVal.equals(Date) || enumVal.equals(Email) || enumVal.equals(Text) || enumVal.equals(Password) || enumVal.equals(Number)){
				 isSettable=true;
			 }
		 }
		 
		 return isSettable;
	 }
	 
	 public static InputTypeEnum parse(final String value){
		 InputTypeEnum inputTypeEnum = null;
		 
		 if(value!=null){
			 for(InputTypeEnum tempInputTypeEnum : InputTypeEnum.values()){
				 	if(tempInputTypeEnum.toString().equals(value)){
				 		inputTypeEnum = tempInputTypeEnum;
				 		break;
				 	}
			 }
		 }
		 
		 return inputTypeEnum;
	 }
	 
	 public int getIntVal(){
		 return this.intVal;
	 }
	 
	 public String toString(){
		 
		 String stringRepresentation = this.name().toLowerCase();
		 
		 if(stringRepresentation.equals("datetimelocal")){
			 stringRepresentation="datetime-local";
		 }
		 
		 return stringRepresentation;
	 }
}
