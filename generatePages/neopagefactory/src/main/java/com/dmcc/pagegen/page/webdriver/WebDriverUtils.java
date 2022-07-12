package com.dmcc.pagegen.page.webdriver;

import com.dmcc.pagegen.exceptions.PageBuildException;
import com.dmcc.pagegen.exceptions.PageException;
import com.dmcc.pagegen.exceptions.PageSerialiseException;
import com.dmcc.utils.property.Property;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static com.dmcc.utils.io.Io.debug;
import static com.dmcc.utils.io.Io.error;

public abstract class WebDriverUtils {
	
	protected static Map<WebDriverUtils,WebDriver> allWebDriverInstances
		= new HashMap<WebDriverUtils,WebDriver>();
	
	private URL url=null;
	
	private WebDriver webdriver;
	
	private String urlValue=null;	
	private String fileValue=null;
	
	protected abstract void createPageFieldsEnum() throws PageBuildException;
	protected abstract void createPageClass() throws PageBuildException;
	protected abstract void serialise() throws PageSerialiseException;
	protected abstract void deserialise() throws PageSerialiseException;
	
	protected static Map<WebDriverUtils,WebDriver> getAllWebDriverInstances() throws PageException {
		return allWebDriverInstances;
	}
	
	protected void addToWebDriverInstances(WebDriver webdriver) throws PageException {
		allWebDriverInstances.put(this, webdriver);
	}
	
	protected void errorAndFail(final String message) throws PageException {
		error(message);
		throw new PageException(message);
	}
	
	protected void initialiseDriver() throws PageException{
		
		String browser=null;
		
		if( (browser=Property.get("browser"))!=null )
		{
			if(browser.trim().toLowerCase().equals("chrome")){
				if( Property.get("webdriver.chrome.driver") == null ){
					errorAndFail("browser property set to 'chrome' but 'webdriver.chrome.driver' property not set. Please set 'webdriver.chrome.driver' property");
				}
				
				try
				{
					webdriver = new ChromeDriver();
					
					addToWebDriverInstances(webdriver);
				}
				catch(Exception e){
					errorAndFail(e.getMessage());
				}
			}
		}
		else
		{
			errorAndFail("'browser' property not set. Please set this property to either 'chrome' or 'ie'.");
		}			
	}
	
	protected boolean driverIsInitialised(){
		return webdriver!=null;
	}
	
	public WebDriver getWebDriver() throws PageException {
		if(!driverIsInitialised()){
			debug("Initialising web driver ...");
			initialiseDriver();
			debug("Web driver initialised.");
			webdriver.get(getUrlValue());
		}
		
		return webdriver;
	}

	public static void closeAllWebDrivers(){
		Iterator<WebDriverUtils> iterator = 
				allWebDriverInstances.keySet().iterator();
		
	    while (iterator.hasNext()) {
	        Map.Entry pair = (Map.Entry)iterator.next();
	        
	        WebDriver webDriver = (WebDriver)pair.getValue();
	        
	        closeWebDriver(webDriver);
	    }
	}
	
	public void closeWebDriver(){
		closeWebDriver(this.webdriver);
	}
	
	protected static void closeWebDriver(WebDriver webdriver){
		if(webdriver!=null){
			if(!Property.getBoolean("webdriver.leaveopen")){			
				debug("(closeWebDriver): Closing webdriver ...");
				webdriver.quit();
				webdriver=null;
				debug("(closeWebDriver): Web driver closed");
			}
		}
	}
	
	public String getUrlValue(){
		return this.urlValue;
	}
	
	public void setUrlValue(final String urlValue) throws PageException {
		try {
			this.urlValue = urlValue;
			this.setUrl(new URL(urlValue));
		} catch (MalformedURLException e) {
			throw new PageException(e.getMessage());
		}
	}
	public String getFileValue() {
		return fileValue;
	}
	public void setFileValue(String fileValue) {
		this.fileValue = fileValue;
	}
	protected URL getUrl() {
		return url;
	}
	protected void setUrl(URL url) {
		this.url = url;
	}
}
