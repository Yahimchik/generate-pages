package com.dmcc.pagegen.page.mccarterp;

import com.dmcc.pagegen.page.Page;
import com.dmcc.pagegen.tags.parent.Tag;

public class McCarterDotNetPage extends Page {
	
	@Override
	public String toString() {
		
		StringBuffer buffer = new StringBuffer();
		
		for(Tag tag : getElements()){
			if( tag.isClean() ){
				if(buffer.length()==0){
					
					String startjson=
							"[\n"+
							"\t{\n"+
							"\t\t\"VersionControl\": {\n"+
							"\t\t\"Release\": 1,\n"+
							"\t\t\"ChangeDescription\": \"initial release\"\n"+
							"\t\t},\n"+
							"\t\t\"Pages\": [\n"+	
							"\t\t\t{\n"+
							"\t\t\t\t\"Name\": \""+getPageName()+"\",\n"+
							"\t\t\t\t\"Element\": [\n";
					
					buffer.append(startjson);
				}
				else {
					buffer.append("\t\t\t,\n");
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
