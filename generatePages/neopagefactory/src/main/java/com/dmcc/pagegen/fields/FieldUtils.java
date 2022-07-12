package com.dmcc.pagegen.fields;


import static com.dmcc.utils.io.Io.debug;
import static com.dmcc.utils.io.Io.error;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dmcc.utils.text.Convert;

public class FieldUtils {

	public static String toString(String value){
		String name=value;
		
		if(name!=null){
			debug("(FieldUtils.toString()) instring :"+name);
			
			Pattern p = Pattern.compile("([a-z])([A-Z])");
			Matcher m = p.matcher(name);
			
			while(m.find()){
				String s1=m.group(1);
				String s2=m.group(2);
				
				name=name.replace(s1+s2, s1+" "+s2);
			}
			
			boolean keepLooking=true;
			
			try
			{
				while(keepLooking){
					p = Pattern.compile("([A-Z])([A-Z])");		
					m = p.matcher(name);
				
					if(!m.find()){
							keepLooking=false;
							break;
					}
	
					String s1=m.group(1);
					String s2=m.group(2);
					
					name=name.replace(s1+s2, s1+" "+s2);
				}
			}
			catch(Exception e){
				error(e.getMessage());
			}
			
			debug("(FieldUtils.toString()) outstring :"+name);
		}
		else
		{
			debug("(FieldUtils.toString()) name is null");
		}
		
		return name;
	}

	
	public static String getNameFromUrl(final String url){
		String value="Page";
		
		if(url!=null){
			Pattern p = Pattern.compile("^[^:]*[:]*[\\/]*[w]*[\\.]([^\\.]*).*$");
			
			Matcher m = p.matcher(url);
			
			if( m.find() ){
				value=Convert.toCamelCase(m.group(1))+"Field";
			}
		}
		
		return value;
	}
	
	public static String getPageNameFromUrl(final String url){
		String value="Page";
		
		if(url!=null){
			Pattern p = Pattern.compile("^[^:]*[:]*[\\/]*[w]*[\\.]([^\\.]*).*$");
			
			Matcher m = p.matcher(url);
			
			if( m.find() ){
				value=Convert.toCamelCase(m.group(1))+"Page";
			}
		}
		
		return value;
	}
}
