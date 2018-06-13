package com.nd.ppt3d.silentfan;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScriptCasePicture {

	//²âÊÔ¡ª¡ªÍ¼Æ¬ÑÕÉ«sstep1
  	public String testPicture(String fileName, int lineNumber) throws IOException {
  		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));	      
        String line = reader.readLine().toString();
        String lineResult = "";     
        String regexOne = "presentation:style-name=\"(.*?)\" ";
        String regexTwo = "draw:style-name=\"(.*?)\" ";
        int num = 0;        
        while (line != null) {
            if (lineNumber == ++num) {
            	if(line.indexOf("<draw:frame") != -1 | line.indexOf("</draw:frame>") != -1) {   
            		if(line.indexOf("draw:style-name") != -1) {
            			Pattern pattern = Pattern.compile(regexTwo);
                    	Matcher matcher = pattern.matcher(line);
                    	while(matcher.find()) {
                    		lineResult = matcher.group(1);
                    	}
                    	break;
            		}                	           		
            	} else {
            		lineResult = null;
            	}
            }
            line = reader.readLine();              
        }
        reader.close();
        return lineResult;
  	}
	
  	//²âÊÔ¡ª¡ªÍ¼Æ¬£¨³ß´ç£©
  	public String pictureSize(String fileName, int lineNumber) throws IOException {        
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));	      
        String line = reader.readLine().toString();
        String lineResult = "";     
        int num = 0;        
        while (line != null) {
            if (lineNumber == ++num) {
            	if(line.indexOf("<draw:frame") != -1 | line.indexOf("</draw:frame>") != -1) {   
            		if(line.indexOf("presentation:style-name") != -1 | line.indexOf("draw:style-name") != -1) {
            			String arrays[] = line.split(" ");
                    	for(int j=0;j<arrays.length;j++) {
                    		if(arrays[j].indexOf("svg:height=") != -1 | arrays[j].indexOf("svg:width=") != -1) {
                    			line = arrays[j];
                    			lineResult = line + lineResult;                    			                    			
                    		}                    		
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
  	
  	//²âÊÔ¡ª¡ªÍ¼Æ¬£¨Ðý×ª£©
  	public String pictureRotate(String fileName, int lineNumber) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));	      
        String line = reader.readLine().toString();
        String lineResult = "";     
        int num = 0;        
        while (line != null) {
            if (lineNumber == ++num) {
            	if(line.indexOf("<draw:frame") != -1 | line.indexOf("</draw:frame>") != -1) {   
            		if(line.indexOf("rotate") != -1) {
            			Pattern pattern = Pattern.compile("draw:transform=(.*?)>");
                    	Matcher matcher = pattern.matcher(line);
                    	while(matcher.find()) {
                    		lineResult = lineResult + matcher.group(1);
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

  	//²âÊÔ¡ª¡ªÍ¼Æ¬£¨²Ã¼ôÎªÐÎ×´¡ª¡ª±ß¿òÑùÊ½£©
  	public String pictureCutShapeBorderStyle(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));	      
        String line = reader.readLine().toString();
        String lineResult = "";            
        while (line != null) {
        	if(line.indexOf("<draw:frame") != -1 | line.indexOf("</draw:frame>") != -1) {   
        		if(line.indexOf("<a:prstDash") != -1) {
        			Pattern pattern = Pattern.compile("<a:prstDash (.*?)/>");
                	Matcher matcher = pattern.matcher(line);
                	while(matcher.find()) {
                		lineResult = lineResult + matcher.group(1);
                	}  
                	break;
        		}
        	} else {
        		lineResult = "";
        	}
            line = reader.readLine();              
        }
        reader.close();
        return lineResult;
  	}
  	
  	//²âÊÔ¡ª¡ªÍ¼Æ¬£¨²Ã¼ôÎªÐÎ×´¡ª¡ª±ß¿òÑÕÉ«£©
  	public String pictureCutShapeBorderColor(String fileName,int lineNumber) throws IOException {
  		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
    	LineNumberReader reader = new LineNumberReader(in);
    	String line = reader.readLine();
    	String lineResult = "";  
    	String temp = testPicture(fileName,lineNumber);
    	while (line != null) {
    		if(temp != null) {
    			if(line.indexOf("<style:style style:name=\""+temp+"\" ") != -1) {
    				line = reader.readLine();
    				String arrays[] = line.split(" ");
                	for(int j=0;j<arrays.length;j++) {
                		if(arrays[j].indexOf("svg:stroke-color") != -1) {
                			line = arrays[j];
                			lineResult = line + lineResult;                    			                    			
                		}                    		
                	}
                	break;
    			}
    		}
    		line = reader.readLine();
        }         			
        reader.close();
        in.close();  
        return lineResult;  
  	}


}
