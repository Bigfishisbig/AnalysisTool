package com.nd.ppt3d.silentfan;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScriptCaseAudio {

  	//≤‚ ‘°™°™“Ù∆µ£®“Ù∆µƒ⁄»›£©
  	public String audioContent(String fileName, int lineNumber) throws IOException {        
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));	      
        String line = reader.readLine().toString();
        String lineResult = "";     
        int num = 0;        
        while (line != null) {
            if (lineNumber == ++num) {
            	if(line.indexOf("<svg:desc>") != -1) {   
            		lineResult = line;             	           		
            	} else {
            		lineResult = "";
            	}
            }
            line = reader.readLine();              
        }
        reader.close();
        return lineResult;
  	}
  	
  	//≤‚ ‘°™°™“Ù∆µ£®≥ﬂ¥Á£©
  	public String audioSize(String fileName, int lineNumber) throws IOException {        
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));	      
        String line = reader.readLine().toString();
        String lineResult = "";     
        int num = 0;        
        while (line != null) {
            if (lineNumber == ++num) {
            	if(line.indexOf("nd:pcNvPr=\"<p:cNvPr") != -1) {   
            		String arrays[] = line.split(" ");
                	for(int j=0;j<arrays.length;j++) {
                		if(arrays[j].indexOf("svg:width=") != -1 | arrays[j].indexOf("svg:height=") != -1) {
                			line = arrays[j];
                			lineResult = line + lineResult;                    			                    			
                		}                    		
                	}           	           		
            	} else {
            		lineResult = "";
            	}
            }
            line = reader.readLine();              
        }
        reader.close();
        return lineResult;
  	}
  	
  	//≤‚ ‘°™°™“Ù∆µ£®–˝◊™£©
  	public String audioRotate(String fileName, int lineNumber) throws IOException {        
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));	      
        String line = reader.readLine().toString();
        String lineResult = "";     
        int num = 0;        
        while (line != null) {
            if (lineNumber == ++num) {
            	if(line.indexOf("nd:pcNvPr=\"<p:cNvPr") != -1) {   
            		Pattern pattern = Pattern.compile("draw:transform=(.*?)>");
                	Matcher matcher = pattern.matcher(line);
                	while(matcher.find()) {
                		lineResult = lineResult + matcher.group(1);
                	}           	           		
            	} else {
            		lineResult = "";
            	}
            }
            line = reader.readLine();              
        }
        reader.close();
        return lineResult;
  	}
}
