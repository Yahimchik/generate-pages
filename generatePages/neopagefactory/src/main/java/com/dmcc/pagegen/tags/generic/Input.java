package com.dmcc.pagegen.tags.generic;

import com.dmcc.pagegen.exceptions.PageElementParseException;
import com.dmcc.pagegen.tags.parent.Tag;

public class Input extends Tag {
	
	@Override
	protected boolean expectChildElements(){
		return false;
	}
	
	@Override
	protected String getCompleteElementSearchExpression()throws PageElementParseException {
		return getElementWithNoChildElementsExpression(this.getTagName());
	}
	
	@Override
	protected boolean tidy(final String attrs, final String data) {

		boolean tidied=true;
		
		if( getHtmlType()!=null){
			InputTypeEnum inputType=InputTypeEnum.parse(getHtmlType());
			
			// *** HTMLType must be one of the valid types ...
			if( inputType!=null ){
				if(inputType.equals(InputTypeEnum.Submit)){
					
					String value=getAttrValue("value", attrs);
					
					if(value!=null){
						setName(value);
					}
				}
			}
			else
			{
				tidied=false;
			}
		}
		else {
			tidied=false;
		}
		
		return tidied;
	}
	
	protected InputTypeEnum getInputType(){
		return InputTypeEnum.parse(getType());
	}
	
	@Override
	public String getHtmlType() {
		return this.getInputType()!=null?this.getInputType().toString():null;
	}	
}
