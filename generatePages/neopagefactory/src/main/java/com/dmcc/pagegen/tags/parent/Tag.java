package com.dmcc.pagegen.tags.parent;

import static com.dmcc.utils.io.Io.debug;
import static com.dmcc.utils.io.Io.error;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dmcc.pagegen.exceptions.PageBuildException;
import com.dmcc.pagegen.exceptions.PageElementParseException;
import com.dmcc.pagegen.exceptions.TagNameNotSetException;
import com.dmcc.pagegen.tags.generic.A;
import com.dmcc.pagegen.tags.generic.Button;
import com.dmcc.pagegen.tags.generic.Input;
import com.dmcc.pagegen.tags.generic.InputTypeEnum;
import com.dmcc.pagegen.tags.generic.Select;
import com.dmcc.utils.text.Convert;

public class Tag {
		
	private List<String> options = new ArrayList<String>();
	
	protected String id;
	protected String name;
	protected String type;
	protected String htmlType;
	protected String byExpr;
	protected ByTypeEnum byType;
	
	private String href;
	
	protected String tagname=null;
	
	public Tag(){}
	
	protected boolean tidy(final String attrs, final String data){
		return true;
	}

	public List<String> getOptions(){
		return options;
	}
	
	public void setOptions(List<String> optionslist){
		this.options = optionslist;
	}
	
	public String getType(){
		return type;
	}
	
	public void setType(final String value){
		this.type = value;
	}
	
	protected String camelCase(final String value){
		String outvalue=Convert.toCamelCase(value);
		
		return outvalue;
	}
	
	protected String normaliseSpaces(final String value){
		String description=value;
		
		if(description!=null){
			Pattern pattern = Pattern.compile("([ ]+)");
	        Matcher matcher = pattern.matcher(description);
	        
	        while (matcher.find()) {
	            String prevalue = matcher.group(1);
	            
	            description=description.replace(prevalue, " ");
	        }
		}
	
		return description;
	}
	
	protected String removeNonAlphaNumericCharacters(final String value){		
		return Convert.removeNonAlphaNumericCharacters(value);
	}
	
	protected String tidyDescription(final String value){
		String description=value;
		
		if(description!=null){
			description=normaliseSpaces(removeNonAlphaNumericCharacters(camelCase(description)));			
		}
			
		return description;
	}
	
	public String getByExpr(){
		return byExpr;
	}
	
	public void setByExpr(final String value){
		this.byExpr = value;
	}
	
	public ByTypeEnum getByType(){
		return byType;
	}
	
	public void setByType(final ByTypeEnum value){
		this.byType = value;
	}
	
	public void setHtmlType(final String value){
		this.htmlType=value;
		debug("(setHtmlType()): "+getHtmlType());
	}
	
	public String getHtmlType() {
		if(this.htmlType==null){
			String[] split = this.getClass().getName().split("\\.");
		
			this.htmlType = split[split.length-1].toLowerCase();
		}
		
		return this.htmlType;
	}
	
	public String getName(){
		return name;
	}
	
	protected String clean(final String value){
		
		String newValue=value;
		
		if(value!=null){
			if(value.trim().equals("&nbsp;")){
				newValue="";
			}
		}
		
		return newValue;
	}
	
	public void setName(final String value){
		this.name = tidyDescription(value);
	}
	
	public boolean isClean(){
		boolean isclean=
				(this.getByExpr()!=null) && (this.getByExpr().length()>0);
		
		if( isclean ){
				isclean =  (this.getByType()!=null);

			if( isclean ){
					isclean = (this.getHtmlType()!=null) && (this.getHtmlType().length()>0);
					
					if(isclean){
							isclean = (this.getName()!=null) && (this.getName().length()>0);
							
							if(isclean){
								isclean=!getHtmlType().trim().equals("hidden");
								
								if(isclean){
									isclean=!this.getName().toUpperCase().equals("NBSP");
								}
							}
					}
			}
		}

		return isclean;
	}
	
	public String toString(){
	
		StringBuffer buffer = new StringBuffer();
		
		if( isClean() )
		{
			// *** this is bad, but put a hardcoded flag in 
			// *** for now to generate .NET type JSON expression ...
			boolean dotnet=true;
			
			if(!dotnet){
				buffer.append("\t\t{\n");
				buffer.append("\t\t\t\"name\" : \""+this.getName()+"\",\n");
				buffer.append("\t\t\t\"byExpr\" : \""+this.getByExpr()+"\",\n");
				buffer.append("\t\t\t\"byType\" : \""+this.getByType()+"\",\n");
				buffer.append("\t\t\t\"htmlType\" : \""+this.getHtmlType()+"\"\n");
				buffer.append("\t\t}\n");
			}
			else
			{
				buffer.append("\t\t\t\t{\n");
				
				buffer.append("\t\t\t\t\t\"Name\": \""+this.getName()+"\",\n");
				
				if(this.getByType().equals(ByTypeEnum.xpath)){
					buffer.append("\t\t\t\t\t\"XPath\": \""+this.getByExpr()+"\"\n");
				}
				else
				if(this.getByType().equals(ByTypeEnum.id)){
					buffer.append("\t\t\t\t\t\"ElementId\": \""+this.getByExpr()+"\"\n");
				}
				else
				if(this.getByType().equals(ByTypeEnum.name)){
					buffer.append("\t\t\t\t\t\"ElementName\": \""+this.getByExpr()+"\"\n");
				}

				buffer.append("\t\t\t\t}\n");
			}
		}
		
		return buffer.toString();
	}

	public String getTagName(){
		
		String[] tagNameList=this.getClass().getName().toLowerCase().split("\\.");
		
		String tagName=tagNameList[tagNameList.length-1];
		
		return tagName;
	}
	
	protected List<Tag> dedupeTagList(final List<Tag> inTagList){
		
		List<Tag> outTagList = new ArrayList<Tag>();
		
		if(inTagList==null){
			return null;
		}
		else
		if(inTagList.size()>0){
			for(Tag inTag : inTagList){				
				if( inTag.isClean() ){
					boolean addToList=true;
					
					for(Tag outTag : outTagList){
						if(outTag.isClean() && outTag.getName().trim().toLowerCase().equals(inTag.getName().trim().toLowerCase())){
							addToList=false;
						}
					}
					
					if(addToList){
						outTagList.add(inTag);
					}
				}
			}
		}
		
		return outTagList;
	}
	
	public List<Tag> parse(final String html)
		throws PageElementParseException {
		
		List<Tag> list = new ArrayList<Tag>();
		
		
		
		list.addAll(parseCompleteElements(html));
		
		//list.addAll(parseInlineElements(tagName, html, this));
		list.addAll(parseInCompleteElements(html, this));
		
		List<Tag> dedupedlist = dedupeTagList(list);
		
		for(Tag tag : list){
			debug("NAME: "+tag.getName());
		}
		
		return dedupedlist;
	}
	
	protected Tag clean(final Tag value){
		Tag tag = value;
		
		if(tag!=null){		
			if(tag.getHtmlType()==null){
				tag=null;
			}
		}
		
		
		return tag;
	}
	
	protected boolean expectChildElements(){
		return true;
	}
	
	protected String getElementWithChildElementsExpression(final String tagName){
		return "<"+tagName+" ([^>]*)[^\\/]>(.*?)</"+tagName+">";
	}
	
	protected String getElementWithNoChildElementsExpression(final String tagName){
		return "<"+tagName+" ([^>]*)[^\\/]>([^<]*)</"+tagName+">";
	}
	
	protected String getInCompleteElementSearchExpression(){
		String tagName=getTagName();
		
		return "<"+tagName+" ([^>]*?)[^\\/]>";
	}

	protected String getCompleteElementSearchExpression()throws PageElementParseException {
		throw new PageElementParseException("This method needs to be overriden by implementation");
	}
	
	protected  List<Tag> parseCompleteElements(final String input) throws PageElementParseException{	
		String tagName=getTagName();
		
		String expression = getCompleteElementSearchExpression();
	
		List<Tag> list = new ArrayList<Tag>();

		if(expression!=null){
			Pattern p=Pattern.compile(expression);
			
			Matcher m = p.matcher(input);
				
			boolean expressionFound=false;
			
			while(m.find()){
					expressionFound = true;
					
					Tag tag = generateTagFromMatcher(m);
					
					if(tag!=null){					
						if( tag.isClean()  )
						{
							debug("Element is clean");
							list.add(tag);
						}
						else
						{
							debug("Element is NOT clean");
						}
					}
					else
					{
						debug("Element is null");
					}
			}		
			
			if(!expressionFound){
				debug("NOTFOUND (parseElements()) element type '"+tagName+"'");
			}
		}
		
		return list;
	}
	
	protected List<Tag> parseInlineElements(String tagName, 
			String input, Tag element) throws PageElementParseException{
		
		Pattern p = Pattern.compile("<"+tagName+"([^/]*)/>");
		
		Matcher m = p.matcher(input);
		
		List<Tag> list = new ArrayList<Tag>();
		
		if( (element instanceof Input) || (element instanceof Button) )
		{
			while(m.find()){
				
				String attrs=" "+m.group(1);
				
				String description=getAttrValue("name",attrs);
				
				if( (description==null) || (description.length()==0) )
				{
					description=getAttrValue("id",attrs);
				}
				
				debug("FOUND (parseInlineElements()) element type '"+tagName+"'. DESCRIPTION '"+description+"'. ATTRS: "+attrs);
				
				Tag tag = getTag(attrs,description);
				
				if(isClean()){
					list.add(tag);
					debug("ELEMENT is clean");
				}
				else
				{
					debug("ELEMENT is NOT clean");
				}
			}
		}
		
		return list;
	}
	
	protected List<Tag> parseInCompleteElements(String input, Tag element) throws PageElementParseException{
		String tagName=getTagName();
		
		Pattern p = Pattern.compile("<"+tagName+"[ |\t]*([^>]*)>");
		
		Matcher m = p.matcher(input);
		
		List<Tag> list = new ArrayList<Tag>();
		
		while(m.find()){			
			String attrs=" "+m.group(1);
			
			String description=getAttrValue("name",attrs);
			
			if( (description==null) || (description.length()==0) )
			{
				description=getAttrValue("id",attrs);
			}
			
			debug("FOUND (parseInCompleteElements()) element type '"+tagName+"'. DESCRIPTION(from attr) '"+description+"'. ATTRS: "+attrs);
			
			Tag tag = getTag(attrs,description);
			
			if(tag.isClean()){
				debug("ELEMENT is clean");
				list.add(tag);
			}
			else
			{
				debug("ELEMENT is NOT clean");
			}
		}
		
		return list;
	}
	
	private String cleanElementData(final String input){
		if( (input==null) || (input.trim().length()==0) ){
			return null;
		}
		
		String cleanInput=input.trim();
		
		if(cleanInput.contains("<") && cleanInput.contains(">") ){
			cleanInput=null;
		}
				
		return cleanInput;
	}
	
	private void initByExprAndByType(final String id, final String name){
		if( (id!=null) && (id.length()>0) ){
			this.setByExpr(id);
			this.setByType(ByTypeEnum.id);
		}
		else
		if( (name!=null) && (name.length()>0) ) {
			this.setByExpr(name);
			this.setByType(ByTypeEnum.name);
		}	
	}
	
	private void initHtmlType(final String type){		
		if( (type==null) || (type.length()==0) ){
			this.setType("text");
			this.setHtmlType("text");
		}
		else
		{
			this.setType(type);
			this.setHtmlType(type);
		}		
	}
	
	private void initName(final String tagData){
		if( (tagData!=null) && (tagData.length()>0) ){
			this.setName(tagData.trim());
		}	
		else
		if(this.getByExpr()!=null){
			this.setName(this.getByExpr());
		}
	}

	private void initHref(final String href){
		if( (href!=null) && (href.length()>0) ){
			this.setHref(href);	
		}
	}

	private void initXPath(final String tagData){
		if( !this.isClean() ){
			if(this.getByType()==null) {
				if(tagData!=null){					
					String cleanTagData=cleanElementData(tagData);
					
					if( cleanTagData!=null ){
						this.setByExpr("//"+getTagName()+"[contains(text(),'"+cleanTagData+"')]");
						this.setByType(ByTypeEnum.xpath);
					}
				}
				else
				if( this.getHref()!=null){
					this.setByExpr("//"+getTagName()+"[@href='"+this.getHref()+"']");
					this.setByType(ByTypeEnum.xpath);
				}
			}
		}
	}
	
	protected Tag generateTagFromMatcher(Matcher m) throws PageElementParseException{
		
		int numberOfGroups=m.groupCount();
		
		String attrs=" "+m.group(1);
		String data=numberOfGroups>=2?m.group(2):null;
		
		debug("FOUND (parseElements()) element type '"+getTagName()+"'.\nATTRS: "+attrs+".\nDATA: "+data);
		
		Tag tag = this.getTag(attrs,data);
		
		return tag;
	}
	
	protected Tag getNewTagInstance() throws PageElementParseException {
		try {
			return this.getClass().newInstance();
		} catch (InstantiationException e) {
			throw new PageElementParseException(e.getMessage());
		} catch (IllegalAccessException e) {
			throw new PageElementParseException(e.getMessage());
		} 
	}
	
	private boolean byTypeIsSet(){
		return (this.getByType()!=null) && (this.getByType().equals(ByTypeEnum.id) || this.getByType().equals(ByTypeEnum.name));
	}
	
	protected Tag getTag(final String attrs,
			final String tagData)
		throws PageElementParseException {
		Tag t = this.getNewTagInstance();
		
		String id=getAttrValue("id",attrs);
		String name=getAttrValue("name",attrs);
		String type=getAttrValue("type",attrs);
		String href=getAttrValue("href",attrs);

		t.initByExprAndByType(id,name);
		t.initHtmlType(type);
		
		debug("1 TYPE=["+type+"] byExpr=["+t.getByExpr()+"] htmlType=["+t.getHtmlType()+"]");
		
		if( (tagData!=null) && (tagData.length()>0) ){
			t.initName(tagData);
		}
		else
		if( t.byTypeIsSet() ){
			t.initName(t.getByExpr());
		}
		
		if( (t.getByExpr()==null) || (t.getByExpr().length()==0) ){
			t.initHref(href);
			t.initXPath(tagData);
		}
		
		debug("2 TYPE=["+type+"] byExpr=["+t.getByExpr()+"]");
			
		return t;
	}
	
	protected String getAttrValue(String attrName, String attrs){
		
		String[] attrsplit = attrs.split(" ");
		
		String value=null;
		
		for(String s : attrsplit){		
			if( (s!=null) && (s.trim().length()>0) ){
				String[] attrsplit2 = s.split("=");
				if(attrsplit2.length==2){
					String searchname=attrsplit2[0].trim().replace("\"","").replace("'", "");
					if(searchname.equals(attrName)){
						value=attrsplit2[1].trim().replace("\"", "").replace("'", "").replace("/", "");
						
						if(value.length()==0){
							value=null;
						}
					}
				}
			}
		}
		
		return value;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
}