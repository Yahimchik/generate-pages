/**
 * 
 */
package com.dmcc.pagegen;

import com.dmcc.pagegen.exceptions.PageConnectException;
import com.dmcc.pagegen.exceptions.PageElementParseException;
import com.dmcc.pagegen.exceptions.PageException;
import com.dmcc.pagegen.exceptions.PageLoadException;
import com.dmcc.pagegen.exceptions.PageResponseContentException;
import com.dmcc.pagegen.exceptions.PageSerialiseException;
import com.dmcc.pagegen.exceptions.PageUrlNotSpecifiedException;
import com.dmcc.pagegen.page.Page;
import com.dmcc.utils.property.Property;

public class Main {

	public static void main(String[] args) throws PageLoadException, PageConnectException, PageResponseContentException, PageElementParseException, PageSerialiseException, PageUrlNotSpecifiedException, PageException {
		
		if( getUseFile() !=null ){
			if( getFile() != null ){
				Page.generatePageClassFromFile(
					getFile(), getUrl(), getPackage(), getSrcRoot(), getResourcesRoot());
			}
		}
		else
		if(getUrl()!=null){
			Page.generatePageClassFromUrl(
				getUrl(), getPackage(), getSrcRoot(), getResourcesRoot());
		}
	}
	
	private static String getUrl() throws PageUrlNotSpecifiedException {
		return Property.get("url");
	}
	
	private static String getFile() throws PageUrlNotSpecifiedException {
		return Property.get("file");
	}
	
	private static String getPackage() throws PageUrlNotSpecifiedException {
		return Property.get("package");
	}
	
	private static String getSrcRoot() throws PageUrlNotSpecifiedException {
		return Property.get("src.root");
	}
	
	private static String getResourcesRoot() throws PageUrlNotSpecifiedException {
		return Property.get("resources.root");
	}
	
	private static String getUseFile() throws PageUrlNotSpecifiedException {
		return Property.get("use.file");
	}
}
