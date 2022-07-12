package com.dmcc.pagegen.tags.generic;

import static com.dmcc.utils.io.Io.debug;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.internal.seleniumemulation.GetConfirmation;

import com.dmcc.pagegen.exceptions.PageElementParseException;
import com.dmcc.pagegen.tags.parent.ByTypeEnum;
import com.dmcc.pagegen.tags.parent.Tag;

public class Select extends Tag {

	@Override
	protected String getCompleteElementSearchExpression() throws PageElementParseException {
		return getElementWithChildElementsExpression(this.getTagName());
	}
	
	@Override
	protected Tag generateTagFromMatcher(Matcher m) throws PageElementParseException{
		
		String attrs=m.group(1);
		String data=m.group(2);
		
		String id=getAttrValue("id", attrs);
		String name=getAttrValue("name", attrs);
		
		Tag tag=new Select();
		
		tag.setHtmlType("select");

		if( (name!=null) && (name.length()>0) ){
			tag.setByExpr(name);
			tag.setByType(ByTypeEnum.name);
			tag.setName(name);
		}
		else
		if( (id!=null) && (id.length()>0) ){
			tag.setByExpr(id);
			tag.setByType(ByTypeEnum.id);
			tag.setName(id);
		}
		
		if(tag.getName()!=null){
			Pattern p = Pattern.compile("<option[^>]*?>([^<]*?)</option>");
			
			Matcher m2=p.matcher(data);
			
			List<String> optionslist = new ArrayList<String>();
			
			while( m2.find()){
				optionslist.add(m2.group(1));
			}
			
			if(optionslist.size()>0){
				tag.setOptions(optionslist);
			}
		}
		
		return tag;
	}
	
	@Override
	protected boolean tidy(final String attrs, final String data) {
		
		Pattern p = Pattern.compile("<option[^>]*>(.*?)(</option>)");
		
		Matcher m = p.matcher(data);
		
		ByTypeEnum byType=getByType();
		
		boolean isTidy=true;
		
		if(byType!=null){
			if(byType.equals(ByTypeEnum.name) || byType.equals(ByTypeEnum.id) ){
				setName(getByExpr());
				
				while(m.find()){
						String optionvalue=m.group(1).replace("\n", "").trim();
		
						if(optionvalue.contains(">") && optionvalue.contains("<")){
							isTidy=false; break;
						}
						
						if( !getOptions().contains(optionvalue) ){
							getOptions().add(optionvalue);
						}
				}
			}
		}
		else
		{
			isTidy=false;
		}
		
		return isTidy;
	}

	@Override
	public String toString(){
		
		StringBuffer buffer = new StringBuffer();
		
		if( isClean() )
		{
			buffer.append("\t\t{\n");
			buffer.append("\t\t\t\"name\" : \""+this.getName()+"\",\n");
			buffer.append("\t\t\t\"byExpr\" : \""+this.getByExpr()+"\",\n");
			buffer.append("\t\t\t\"byType\" : \""+this.getByType()+"\",\n");
			buffer.append("\t\t\t\"htmlType\" : \""+this.getHtmlType()+"\"");
			
			if(getOptions().size()>0){
				buffer.append(",\n");
				buffer.append("\t\t\t\"options\" : [\n");
					
				int count=0;
				
				for(String option :getOptions()){
					buffer.append("\t\t\t\t\""+option+"\"");
					
					if(count<(getOptions().size()-1)){
						buffer.append(",\n");
					}
					else
					{
						buffer.append("\n");
					}
					
					++count;
				}
				
				buffer.append("\t\t\t]\n");
			}
			else
			{
				buffer.append("\n");
			}
			
			buffer.append("\t\t}\n");
		}
		
		return buffer.toString();
	}
}
