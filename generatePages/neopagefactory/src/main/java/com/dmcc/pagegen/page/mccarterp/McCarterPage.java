package com.dmcc.pagegen.page.mccarterp;

import com.dmcc.pagegen.page.Page;
import com.dmcc.pagegen.tags.parent.Tag;

public class McCarterPage extends Page {
	
	@Override
	public String toString() {
		
		StringBuffer buffer = new StringBuffer();
		
		for(Tag tag : getElements()){
			if( tag.isClean() ){
				if(buffer.length()==0){
					buffer.append("{\n\t\"elements\":\n\t\t[\n");
				}
				else {
					buffer.append("\t\t,\n");
				}
				
				buffer.append(tag);
			}
		}

		if(buffer.length()>0){
			buffer.append("\t\t]\n}\n");
		}
		
		return buffer.toString();
	}
}
