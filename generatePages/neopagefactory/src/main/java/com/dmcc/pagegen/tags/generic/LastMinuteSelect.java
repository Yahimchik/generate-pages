package com.dmcc.pagegen.tags.generic;

import static com.dmcc.utils.io.Io.debug;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dmcc.pagegen.exceptions.PageElementParseException;
import com.dmcc.pagegen.tags.parent.ByTypeEnum;
import com.dmcc.pagegen.tags.parent.Tag;

public class LastMinuteSelect extends Select {

	String completeSearchExpression = 
			"(<fieldset[ |\t]+[^>]+>.*?</fieldset>)";

	@Override
	protected boolean tidy(final String attrs, final String data) {
		return true;
	}
	
	private String getNameOfElement(String fullHtml){
		String elementName=null;
		
		Pattern p = Pattern.compile("<fieldset[^>]+>[ |\t]*<label[ |\t]+for[^>]+>([^<]*).*");
	
		Matcher m2 = p.matcher(fullHtml);
		
		if( m2.find() ){
			elementName=m2.group(1);
		}
		
		return elementName;
	}
	
	private String getIdOfElement(String fullHtml){
		String elementId=null;
		
		Pattern p = Pattern.compile("<fieldset[^>]+>.*<input[ |\t]+[^>]+id=\"([^\"]*).*");
	
		Matcher m2 = p.matcher(fullHtml);
		
		if( m2.find() ){
			elementId=m2.group(1);
		}
		
		return elementId;
	}
	
	@Override
	protected Tag generateTagFromMatcher(Matcher m) throws PageElementParseException{
		String html=" "+m.group(1);

		LastMinuteSelect tag = new LastMinuteSelect();
		
		String elementName=getNameOfElement(html);
		String id=getIdOfElement(html);
			
		if(elementName!=null){
			tag.setHtmlType("text");
			tag.setName(elementName);
			tag.setByExpr(id);
			tag.setByType(ByTypeEnum.id);
			
			Pattern p = Pattern.compile("<p[ |\t]*[^<]*class=\"[^\"]*\"[^>]*>(.*?)<\\/p>");
			
			Matcher m2 = p.matcher(html);
	
			List<String> optionslist = new ArrayList<String>();
			
			while(m2.find()){		
				String value=m2.group(1);
				
				Pattern p3 = Pattern.compile("([^<]*)<[^>]*>([^<]*)");
				
				Matcher m3 = p3.matcher(value);
				
				StringBuffer buffer = new StringBuffer();
	
				while(m3.find()){
					buffer.append(m3.group(1)+m3.group(2));
				}
				
				if(buffer.length()>0){
					value=buffer.toString();
				}
	
				optionslist.add(value);			
			}
			
			if(optionslist.size()>0){
				debug("Successfully created tag LastMinuteSelect. Name = '"+tag.getName()+"' ("+tag.getClass().getName()+")");
			}
			
			tag.setOptions(optionslist);
		}
	
		debug(tag.toString());
		
		return tag;
	}
	
	@Override
	protected String getCompleteElementSearchExpression() throws PageElementParseException {
		String expression=completeSearchExpression;
		
		return expression;
	}	
}
