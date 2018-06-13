package com.nd.ppt3d.silentfan;

import java.io.IOException;

public class HeaderFooterRun extends PublicMethod {

	public ScriptCaseHeaderFooter caseHeaderFooter = new ScriptCaseHeaderFooter();
	
	//“Ù∆µ£®“Ù∆µƒ⁄»›£©
	public String headerFooterDateTimeRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseHeaderFooter.headerFooterDateTime(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
}
