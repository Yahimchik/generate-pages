package com.dmcc.pagegen.page;

import com.dmcc.pagegen.exceptions.*;
import com.dmcc.pagegen.fields.FieldUtils;
import com.dmcc.pagegen.page.mccarterp.McCarterDotNetPage;
import com.dmcc.pagegen.page.webdriver.WebDriverUtils;
import com.dmcc.pagegen.tags.generic.Button;
import com.dmcc.pagegen.tags.generic.*;
import com.dmcc.pagegen.tags.parent.Tag;
import com.dmcc.utils.exceptions.UtilsException;
import com.dmcc.utils.file.FileUtil;
import com.dmcc.utils.serialisation.json.JsonSerialisation;
import com.dmcc.utils.text.Convert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.dmcc.utils.io.Io.*;

public abstract class Page extends WebDriverUtils {
	
	private String packageName;
	
	private String srcRoot;
	
	private String resourcesRoot;
	
	private final String dumpFile="dump.log";
	
	private String pageContent=null;
	
	private List<Tag> elementDefinitions = new ArrayList<Tag>();
	
	private List<Tag> elements = new ArrayList<Tag>();
	
	protected String getPageFileName(){
		return FieldUtils.getNameFromUrl(this.getUrlValue())+".json";
	}
	
	protected String getPageName(){
		return FieldUtils.getPageNameFromUrl(this.getUrlValue());
	}
	
	protected String getPageFileNameWithPath(){
		return getResourcesRoot() + "/" + getPageFileName();
	}
	
	protected By getBy(final Tag tag)throws PageException {
		try {
			By by = null;						
			
			Method byMethod = By.class.getMethod(tag.getByType().name(), 
					new Class[] { String.class });
		
			Object obj = byMethod.invoke(null, new Object[] { tag.getByExpr() });
			
			if(obj instanceof By){
				by=(By)obj;
			}
			else
			{
				throw new PageException("Expected object of 'By' class type");
			}
			
			return by;
		} catch (IllegalAccessException e) {
			throw new PageException(e.getMessage());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new PageException(e.getMessage());
		} catch (SecurityException e) {
			throw new PageException(e.getMessage());
		} catch (IllegalArgumentException e) {
			throw new PageException(e.getMessage());
		} catch (InvocationTargetException e) {
			throw new PageException(e.getMessage());
		}
	}
	
	protected String getFormatForBy(final Tag tag){
		return "("+"expression "+tag.getByExpr()+" found/find by "+tag.getByType()+")";
	}
	
	protected WebElement getWebElement(final Tag tag)throws PageException {
		try
		{
			WebElement webElement = getWebDriver().findElement(getBy(tag));
			return webElement;
		}
		catch(NoSuchElementException e){
			throw new PageException("[ERR] Element '"+tag.getName()+"' does not exist on current page. "+getFormatForBy(tag));
		}
		catch(ElementNotVisibleException e){
			throw new PageException("[ERR] Element '"+tag.getName()+"' found but is not visible on current page. "+getFormatForBy(tag));
		}
	}
	
	protected WebElement getDisplayedWebElement(final String name)throws PageException {
		debug("START (getDisplayedWebElement()) : start '"+name+"'");
		
		Tag tag = getTag(name);

		WebElement webElement = null;

		try {
			webElement=getWebDriver().findElement(getBy(tag));
		}
		catch(Exception e){
			error(e.getMessage());
			throw new PageException(e.getMessage());
		}
		
		debug("END  (getDisplayedWebElement()) : end '"+name+"'");
		
		return webElement;
	}
	
	protected void setText(final String name, final String value) throws PageException{
		debug("Setting field '"+name+"' to value '"+value+"' on page");
        
		Actions actions = new Actions(getWebDriver());
        
        WebElement element = getDisplayedWebElement(name);
        
        actions.clickAndHold(element).sendKeys(Keys.HOME+value+Keys.TAB).build().perform();
		
        debug("DONE: (Field '"+name+"' set to value '"+value+"' on page");
	}
	
	protected void pasteText(final String name, final String value) throws PageException {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        StringSelection strSel = new StringSelection(value);
        clipboard.setContents(strSel, null);
        
		Actions actions = new Actions(getWebDriver());
        
        WebElement element = getDisplayedWebElement(name);
        
        actions.clickAndHold(element).sendKeys(Keys.chord(Keys.CONTROL, "a")+Keys.chord(Keys.CONTROL,"v")+Keys.TAB).clickAndHold().build().perform();
	}
	
	protected void setDropdownText(final String name, final String value) throws PageException{
		debug("Setting dropdown field '"+name+"' to value '"+value+"' on page");
		WebElement webElement = getDisplayedWebElement(name);
		
		org.openqa.selenium.support.ui.Select dropdown = 
				new org.openqa.selenium.support.ui.Select(webElement);
		
		dropdown.selectByVisibleText(value);
		
		debug("DONE: (Field '"+name+"' set to value '"+value+"' on page");
	}
	
	public void setValue(final String name, final String value) throws PageException {
		try
		{
			if( (value!=null) && (name!=null) ){
				Tag tag = getTag(name);
				
				if(tag.isClean()){
					if(InputTypeEnum.isInputTextField(tag.getHtmlType())){
						this.setText(name, value);
					}
					else
					if(tag.getHtmlType().equals("select")){
						this.setDropdownText(name, value);
					}
				}
			}
		}
		catch(Exception e){
			error("(setValue()) ["+e.getMessage()+"]");
			throw new PageException(e.getMessage());
		}
	}
	
	public void click(final Enum name) throws PageException {
		if(name!=null){
			Tag tag = getTag(name.toString());
			
			if(tag.isClean()){
				debug("(click()) Clicking field '"+name+"' on page");
				
				WebElement webElement = getDisplayedWebElement(name.toString());
				
				Actions clickActions = new Actions(getWebDriver());
				
				clickActions.moveToElement(webElement).click().perform();
				
				debug("(click()) DONE: (Field '"+name+"' has been clicked on page");
			}
			else {
				warn("(click()) Tag '"+name+"' is not clean.");
			}
		}
		else
		{
			warn("(click()) Tag name is null");
		}
	}
	
	public void setValue(final Enum name, final String value) throws PageException {
		
		if(name==null){
			throw new PageException("[ERR] (setValue()): name of field cannot be null");
		}
		
		setValue(name.toString(),value);
	}
	
	public List<Tag> getElementDefinitions(){
		return elementDefinitions;
	}
	
	public void setElementDefinitions(final List<Tag> value){
		this.elementDefinitions=value;
	}
	
	protected List<Tag> getElements(){
		return elements;
	}
	
	protected void setElements(final List<Tag> elements){
		this.elements=elements;
	}
	
	protected void dumpText(final String content, final String file) throws PageDumpTextException {
		
		if( (file==null) || (file.length()==0) ){
			// No null/empty filenames ..
			throw new PageDumpTextException("[ERR] File name is null");
		}
		
	    BufferedWriter writer=null;
	    
		try {
			writer = new BufferedWriter(new FileWriter(file));
		} catch (IOException e) {
			// Failed to open file ..
			throw new PageDumpTextException("[ERR] Failed to open "+file+" for writing:\n"+e.getMessage());
		}
		
	    try {
			writer.write(content);
		} catch (IOException e) {
			// Failed to write to file ..
			throw new PageDumpTextException("[ERR] Failed to write to file "+file+":\n"+e.getMessage());
		}
	     
	    try {
			writer.close();
		} catch (IOException e) {
			// Failed to write to file ..
			throw new PageDumpTextException("[ERR] Failed to close file "+file+":\n"+e.getMessage());
		}		
	}
	
	public abstract String toString();

	protected static McCarterDotNetPage getPageClassInstance(final String packageName,
			final String srcRoot, final String resourcesRoot) throws PageLoadException {
		
    	ApplicationContext context = new ClassPathXmlApplicationContext("appbeans.xml");

    	McCarterDotNetPage page =  (McCarterDotNetPage)context.getBean("PageBean");
		
		page.setPackageName(packageName);
		page.setSrcRoot(srcRoot);
		page.setResourcesRoot(resourcesRoot);
		
		setTagsToLookFor(page);
		
		return page;
	}

	protected static void setTagsToLookFor(final Page page){
		List<Tag> definitions = new ArrayList<Tag>();
		
		definitions.add(new Input());
		definitions.add(new Button());
		definitions.add(new Select());
		definitions.add(new A());
		definitions.add(new LastMinuteSelect());

		page.setElementDefinitions(definitions);
	}
	
	public static Page generatePageClassFromUrl(final String url, final String packageName,
			final String srcRoot, final String resourcesRoot) throws PageLoadException{
		
		McCarterDotNetPage page = getPageClassInstance(
				packageName, srcRoot, resourcesRoot);
		
		page.buildFromUrl(url);
		
		return page;
	}
	
	public static Page generatePageClassFromFile(final String file, final String url, final String packageName,
			final String srcRoot, final String resourcesRoot) throws PageLoadException{
		
		McCarterDotNetPage page = getPageClassInstance(
				packageName, srcRoot, resourcesRoot);
		
		try {
			page.setUrlValue(url);
		} catch (PageException e) {
			throw new PageLoadException(e.getMessage());
		}
		
		page.buildFromFile(file);
		
		return page;
	}
	
	public void navigate(final String url) throws PageException{
		try {
			this.setUrlValue(url);
			this.deserialise();
			getWebDriver();
		}  catch (PageSerialiseException e) {
			throw new PageException(e.getMessage());
		}
	}
	
	protected void serialise() throws PageSerialiseException {
		String pageFile=getResourcesRoot()+"/"+getPageFileName();
		
		try {
			
			debug("Creating page file resource: "+pageFile);
			
			java.io.File dir = new java.io.File(getResourcesRoot());
			
			if( !dir.exists() ){
				dir.mkdir();
			}
			
			dumpText(toString(),pageFile);
		} catch (PageDumpTextException e) {
			// Failed to write to file ..
			throw new PageSerialiseException("[ERR] Failed to write file "+pageFile);
		}
	}
	
	protected void deserialise() throws PageSerialiseException {
		
		try {
			Page p = (Page) 
					JsonSerialisation.deserialiseFileAsClassInstance(getPageFileNameWithPath(),this.getClass());
			
			this.elements=p.elements;
			
		}  catch (UtilsException e) {
			throw new PageSerialiseException("[ERR] Failed to deserialise page file "+getPageFileNameWithPath()+":\n"+e.getMessage());
		}
	}
	
	protected List<String> extractBody(final String input) throws PageException {
		Pattern p = Pattern.compile("<body[^>]*>(.*?)</body>");
		
		Matcher m = p.matcher(input.replace("\n", ""));
		
		List<String> bodyList = new ArrayList<String>();
		
		while( m.find() ){
			bodyList.add(m.group(1));
		}
		
		if( bodyList.size()==0 ){
			errorAndFail("Body not found within input string:\n"+input);
		}
		
		debug("Extracted "+bodyList.size()+" number of body elements from HTML source.");
		
		return bodyList;
	}
	
	protected List<Tag>  compileElements(String pageContent)throws PageResponseContentException, PageElementParseException, PageException {
		
		if(pageContent==null){
			throw new PageResponseContentException("[ERR] Page content is null");
		}
		
		List<String> bodyList=extractBody(pageContent);
		List<Tag> elements = new ArrayList<Tag>();
		
		if(getElementDefinitions()!=null){
			for(Tag tag : getElementDefinitions()){
				for(String body : bodyList){
					elements.addAll(tag.parse(body));
				}
			}
			
			if(elements.size()>0){
				List<Tag> dedupedtaglist = dedupeTagList(elements);
				this.elements = dedupedtaglist;
			}
			
			for(Tag tag : elements){
				debug("TAGNAME: "+tag.getName());
			}
		}
		
		return elements;
	}
	
	protected List<Tag> dedupeTagList(final List<Tag> inTagList){	
		
		if(inTagList==null){
			return null;
		}
		else
		if(inTagList.size()>0){
			
			Map<String,Integer> tagcountmap = new HashMap<String,Integer>();
			
			for(Tag inTag : inTagList){				
				if( inTag.isClean() ){					
					String tagname=inTag.getName();
					
					if(tagcountmap.get(tagname)==null){
						tagcountmap.put(tagname, Integer.valueOf(1));
					}
					else
					{
						int count = tagcountmap.get(inTag.getName()).intValue();
						
						++count;
						
						inTag.setName(tagname+" "+String.valueOf(count));
						
						tagcountmap.remove(tagname);
						tagcountmap.put(tagname, Integer.valueOf(count));
					}
				}
			}
		}
		
		return inTagList;
	}

	protected Tag getTag(final String name) throws PageException {
		
		try
		{
			if(name==null){
				String message="[ERR] Tag name cannot be null";
				error(message);
				throw new PageException(message);
				
			}
	
			Tag tag=null;
			
			if( (this.elements!=null)){
				for(Tag t : this.elements){
					if(t!=null){
						if( (t.getName()!=null) && t.getName().trim().equals(name.trim())){
							tag=t;
						}
					}
				}
				
				if(tag==null){
					String message="[ERR] Tag '"+name+"' does not exist in page file.";
					error(message);
					throw new PageException(message);
				}
			}
			

			return tag;
		}
		catch(Exception e){
			error(e.getMessage());
			throw new PageException("(getTag()): "+e.getMessage());
		}
	}
	
	protected String loadHtmlFromFile(final String filename) throws PageException {
	    
	    try {
			return FileUtil.readText(this.getFileValue());
		} catch (UtilsException e) {
			throw new PageException(e.getMessage());
		}	
	}
		
	protected String loadHtmlFromUrl (final URL url) throws PageConnectException {
		
		StringBuilder result = new StringBuilder();
	    
	    HttpURLConnection conn=null;
	    
	    info("Connecting ... ("+url.getHost()+")");
		
	    try {
			conn = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			throw new PageConnectException("[ERR] Loading page '"+getUrlValue()+":\n"+e.getMessage());
		}
	   
	    try {
			conn.setRequestMethod("GET");
		} catch (ProtocolException e) {
			throw new PageConnectException("[ERR] Loading page '"+getUrlValue()+":\n"+e.getMessage());
		}
	    
	    BufferedReader rd=null;
	    
		try {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} catch (IOException e) {
			throw new PageConnectException("[ERR] Opening input stream '"+getUrlValue()+":\n"+e.getMessage());
		}
	    
	    String line=null;
	    
	    try {
	    	
			while ((line = rd.readLine()) != null) {
				   result.append(line);
			}
		} catch (IOException e) {
			throw new PageConnectException("[ERR] Reading input stream '"+getUrlValue()+":\n"+e.getMessage());
		}
	    
	    try {
			rd.close();
		} catch (IOException e) {
			throw new PageConnectException("[ERR] Closing input stream '"+getUrlValue()+":\n"+e.getMessage());
		}
	    
	    try {
			dumpText(result.toString(),"responsecontent.txt");
		} catch (PageDumpTextException e) {
			throw new PageConnectException("[ERR] Writing response content:\n"+e.getMessage());
		}
	    
	    return result.toString();	
	}
	
	private void startCreate(String pageContent) throws PageLoadException {
		try
		{
			this.elements = this.compileElements(pageContent);
			this.serialise();
			this.createPageFieldsEnum();
			this.createPageClass();
		}
		catch(PageException e){
			throw new PageLoadException("[ERR] Building page '"+getUrl()+":\n"+e.getMessage());
		}
		catch(PageBuildException e){
			throw new PageLoadException("[ERR] Building page '"+getUrl()+":\n"+e.getMessage());
		}
		catch(PageSerialiseException e){
			throw new PageLoadException("[ERR] Serializing page '"+getUrl()+":\n"+e.getMessage());
		} catch (PageResponseContentException e) {
			throw new PageLoadException("[ERR] Page content error '"+getUrl()+":\n"+e.getMessage());
		} catch (PageElementParseException e) {
			throw new PageLoadException("[ERR] Parsing elements '"+getUrl()+":\n"+e.getMessage());
		}
	}
	
	public void buildFromUrl(final String url)throws PageLoadException {	
			try {
				this.setUrlValue(url);
				String pageContent = this.loadHtmlFromUrl(getUrl());
				this.startCreate(pageContent);
			} catch (PageException e) {
				throw new PageLoadException(e.getMessage());
			} catch (PageConnectException e) {
				throw new PageLoadException(e.getMessage());
			}
	}
	
	public void buildFromFile(final String file)throws PageLoadException {
		try {
			this.setFileValue(file);
			String pageContent = this.loadHtmlFromFile(getFileValue());
			this.startCreate(pageContent);
		} catch (PageException e) {
			throw new PageLoadException(e.getMessage());
		}
	}
	
	protected void createPageClass() throws PageBuildException {
		if(this.elements!=null){			
			StringBuffer buffer = new StringBuffer();
			
			String nameOfClass=FieldUtils.getNameFromUrl(this.getUrlValue()).replace("Field", "");

			if( (getPackageName()==null) || (getPackageName().length()==0) ){
				throw new PageBuildException("[ERR] Package name not given with -Dpackage argument");
			}
			
			 buffer.append("package "+getPackageName()+";\n\n");
			 buffer.append("import com.dmcc.pagegen.exceptions.PageException;\n");
			 buffer.append("import "+getPackageName()+"."+nameOfClass+"Field;\n");
			 buffer.append("import com.dmcc.pagegen.page.mccarterp.McCarterPage;\n");
			 buffer.append("\npublic class "+nameOfClass+"Page extends McCarterPage{\n");
			 buffer.append("\nprivate final String url=\""+this.getUrlValue()+"\";\n");
			 buffer.append("private final String rRoot=\""+this.getResourcesRoot()+"\";\n\n");
			 buffer.append("\tpublic "+nameOfClass+"Page navigate()throws PageException {\n");
			 buffer.append("\t\tthis.setResourcesRoot(rRoot);\n");
			 buffer.append("\t\tthis.navigate(url);\n");
			 buffer.append("\t\treturn this;\n");
			 buffer.append("\t}\n\n");
			
			for(Tag tag : this.elements){
				if( tag.isClean() ){
					String methodName=tag.getName().replace(" ", "").replace("	", "");
					
					if( InputTypeEnum.isInputTextField(tag.getHtmlType())){
						if( (tag.getOptions()!=null) && (tag.getOptions().size()>0) ){
							createSelectFieldEnum(methodName+"Enum",tag.getOptions());
							
							buffer.append("\tpublic void set"+methodName+"(final "+methodName+"Enum value) throws PageException{\n");
							buffer.append("\t\tthis.setValue("+nameOfClass+"Field."+getJavaFriendlyName(methodName)+", value.toString());\n");
							buffer.append("\t}\n");
							buffer.append("\n");
						}
						else {
							buffer.append("\tpublic void set"+methodName+"(final String value) throws PageException{\n");
							buffer.append("\t\tthis.setValue("+nameOfClass+"Field."+getJavaFriendlyName(methodName)+", value);\n");
							buffer.append("\t}\n");
							buffer.append("\n");
						}
					}
					else
					if( (tag.getOptions() != null) && (tag.getOptions().size()>0) )
					{
						createSelectFieldEnum(methodName+"Enum",tag.getOptions());
						
						buffer.append("\tpublic void set"+methodName+"(final "+methodName+"Enum value) throws PageException{\n");
						buffer.append("\t\tthis.setValue("+nameOfClass+"Field."+getJavaFriendlyName(methodName)+", value.toString());\n");
						buffer.append("\t}\n");
						buffer.append("\n");						
					}
					
					buffer.append("\tpublic void click"+methodName+"()throws PageException{\n");
					buffer.append("\t\tthis.click("+nameOfClass+"Field."+getJavaFriendlyName(methodName)+");\n");
					buffer.append("\t}\n");
					buffer.append("\n");
				}
			}
			
			buffer.append("}\n");
		
			try {
				createJavaClassFile(
						getPackageName(),
						nameOfClass+"Page", 
						buffer.toString(),
						getSrcRoot());
			} catch (PageException e) {
				throw new PageBuildException(e.getMessage());
			}
		}
	}
	
	private void createJavaClassFile(final String packageName, final String fileName,
			final String content, final String srcRoot) throws PageException {
		String outFolder=srcRoot+"/"+packageName.replace(".", "/");
		
		File file = new File(outFolder);
		
		if( !file.exists() )
		{
			if( !file.mkdirs() ){
				throw new PageException("[ERR] Failed to create folder "+outFolder);
			}
		}
		
		try {
			FileUtil.writeText(content, 
					outFolder+"/"+"/"+fileName+".java");
		} catch (UtilsException e) {
			throw new PageException(e.getMessage());
		}
	}
	
	private String getJavaFriendlyName(final String input){
		return getJavaFriendlyOption(input);
	}
	
	@Override
	protected void createPageFieldsEnum() throws PageBuildException {
		if(this.elements!=null){			
			StringBuffer buffer = new StringBuffer();
			
			String nameOfEnum=FieldUtils.getNameFromUrl(this.getUrlValue());
			
			buffer.append("package "+this.getPackageName()+";\n");
			buffer.append("\nimport com.dmcc.pagegen.fields.FieldUtils;\n");	
			buffer.append("\npublic enum "+nameOfEnum+" {\n");
			
			int count=0;
			
			Map<String,Integer> namemap = new HashMap<String,Integer>();
			
			for(Tag tag : this.elements){
				if( tag.isClean() ){			
					String name=getJavaFriendlyName(tag.getName());
					
					if(namemap.get(name)==null){
						namemap.put(name, Integer.valueOf(1));
							
						buffer.append("\t"+name+"("+count+")");
						
						if( (count+1)<this.elements.size()){
							buffer.append(",");
						}
						else
						{
							buffer.append(";");
						}
					
						buffer.append("\n");
					
						++count;
					}
				}
			}
			
			buffer.append("\n");
	
			buffer.append("\tprotected String[] actualValues = {\n");
			
			count=0;
			
			for(Tag tag : this.elements){
				if(tag.isClean()){
					buffer.append("\t\t\""+tag.getName()+"\"");
					
					if( (count+1)<this.elements.size()){
						buffer.append(",");
					}
					
					buffer.append("\n");
				}
			}
			
			buffer.append("\t};\n\n");
			
			buffer.append("\tprivate int intVal;\n");
			buffer.append("\n");
			buffer.append("\tpublic String toString(){\n");
			buffer.append("\t\treturn actualValues[intVal];\n");
			buffer.append("\t}\n");
			buffer.append("\n");
			buffer.append("\t"+nameOfEnum+"(final int intVal){\n");
			buffer.append("\t\tthis.intVal = intVal;\n");
			buffer.append("\t}\n");
			buffer.append("}\n");
			
			try {
				createJavaClassFile(
						getPackageName(),
						nameOfEnum, 
						buffer.toString(),
						getSrcRoot());
			} catch (PageException e) {
				throw new PageBuildException(e.getMessage());
			}
		}
	}
	
	protected String getJavaFriendlyOption(final String option){
		
		String newOption = Convert.removeNonAlphaNumericCharacters(option.replace(" ", ""));
		
		Pattern p = Pattern.compile("^[0-9]+");
		
		Matcher m = p.matcher(newOption);
		
		if( m.find() ){
			newOption="VALUE_OF_"+newOption;
		}
		
		return newOption;
	}
	

	protected void createSelectFieldEnum(final String nameOfEnum, final List<String> options) throws PageBuildException {
		if(this.elements!=null){			
			StringBuffer buffer = new StringBuffer();
			
			buffer.append("package "+this.getPackageName()+";\n");
			buffer.append("\npublic enum "+nameOfEnum+" {\n");
			
			int count=0;
			
			List<String> optionsadded = new ArrayList<String>();
			
			for(String option : options){
					if(!optionsadded.contains(option)){
						buffer.append("\t"+getJavaFriendlyOption(option)+"("+count+")");
						optionsadded.add(option);
					
						if( (count+1)<options.size()){
							buffer.append(",\n");
						}
					}
						
					++count;
			}
			
			if(optionsadded.size()>0){
				buffer.append(";\n");
			}
			
			buffer.append("\n");
			
			buffer.append("\tprotected String[] actualValues = {\n");
			
			count=0;
			
			for(String option : optionsadded){
				buffer.append("\t\t\""+option+"\"");
				
				if( (count+1)<options.size()){
					buffer.append(",");
				}
				
				buffer.append("\n");
			}
			
			buffer.append("\t};\n\n");
			
			buffer.append("\tprivate int intVal = -1;\n");
			buffer.append("\n");
			buffer.append("\tpublic String toString(){\n");
			buffer.append("\t\treturn actualValues[intVal];\n");
			buffer.append("\t}\n");
			buffer.append("\n");
			buffer.append("\t"+nameOfEnum+"(final int intVal){\n");
			buffer.append("\t\tthis.intVal = intVal;\n");
			buffer.append("\t}\n");
			buffer.append("}\n");
			
			try {
				createJavaClassFile(
						getPackageName(),
						nameOfEnum, 
						buffer.toString(),
						getSrcRoot());
			} catch (PageException e) {
				throw new PageBuildException(e.getMessage());
			}
		}
	}
	
	protected String getPackageName() {
		return packageName;
	}

	protected void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	protected String getSrcRoot() {
		return srcRoot;
	}

	protected void setSrcRoot(String srcRoot) {
		this.srcRoot = srcRoot;
	}

	protected String getResourcesRoot() {
		return resourcesRoot;
	}

	protected void setResourcesRoot(String resourcesRoot) {
		this.resourcesRoot = resourcesRoot;
	}
}