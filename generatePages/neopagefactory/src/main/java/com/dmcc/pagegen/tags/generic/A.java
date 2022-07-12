package com.dmcc.pagegen.tags.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dmcc.pagegen.exceptions.PageElementParseException;
import com.dmcc.pagegen.tags.parent.Tag;

public class A extends Tag {	
	
	@Override
	protected String getCompleteElementSearchExpression() throws PageElementParseException {
		return getElementWithNoChildElementsExpression(this.getTagName());
	}
	
	@Override
	protected boolean expectChildElements(){
		return false;
	}
	
	protected  List<Tag> parseCompleteElements(String input) throws PageElementParseException{
	
		List<Tag> list = super.parseCompleteElements(input);
		
		return list;
	}

	@Override
	protected boolean tidy(final String attrs, final String data) {
		return true;
	}
}
