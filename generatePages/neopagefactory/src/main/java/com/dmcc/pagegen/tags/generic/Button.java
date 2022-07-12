package com.dmcc.pagegen.tags.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dmcc.pagegen.exceptions.PageElementParseException;
import com.dmcc.pagegen.tags.parent.Tag;

public class Button extends Tag {	
	
	@Override
	protected String getCompleteElementSearchExpression() throws PageElementParseException {
		return getElementWithNoChildElementsExpression(this.getTagName());
	}
	
	@Override
	protected boolean expectChildElements(){
		return false;
	}
	
	@Override
	protected boolean tidy(final String attrs, final String data) {
		return true;
	}
}
