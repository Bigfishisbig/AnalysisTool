package com.nd.ppt3d.silentfan;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScriptCaseTextBox {
	
	//测试——文本框step1
  	public String testTextBox(String fileName, int lineNumber) throws IOException {
  		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));	      
        String line = reader.readLine().toString();
        String lineResult = "";     
        String regexOne = "presentation:style-name=\"(.*?)\" ";
        String regexTwo = "draw:style-name=\"(.*?)\" ";
        int num = 0;        
        while (line != null) {
            if (lineNumber == ++num) {
            	if(line.indexOf("<draw:frame") != -1 | line.indexOf("</draw:frame>") != -1) {   
            		if(line.indexOf("presentation:style-name") != -1) {
            			Pattern pattern = Pattern.compile(regexOne);
                    	Matcher matcher = pattern.matcher(line);
                    	while(matcher.find()) {
                    		lineResult = matcher.group(1);
                    	}
            		}else if(line.indexOf("draw:style-name") != -1) {
            			Pattern pattern = Pattern.compile(regexTwo);
                    	Matcher matcher = pattern.matcher(line);
                    	while(matcher.find()) {
                    		lineResult = matcher.group(1);
                    	}
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

	//测试——文本框（垂直对齐方式）
  	public String textBoxVerticalAlignment(String fileName, int lineNumber) throws IOException {
  		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
    	LineNumberReader reader = new LineNumberReader(in);
    	String line = reader.readLine();
    	String lineResult = "";  
    	String temp = testTextBox(fileName,lineNumber);
    	while (line != null) {
    		if(temp != null) {
    			if(line.indexOf("<style:style style:name=\""+temp+"\" ") != -1) {
    				line = reader.readLine();
    				String arrays[] = line.split(" ");
                	for(int j=0;j<arrays.length;j++) {
                		if(arrays[j].indexOf("draw:textarea-vertical-align") != -1 | arrays[j].indexOf("draw:textarea-horizontal-align=") != -1) {
                			line = arrays[j];
                			lineResult = line + lineResult;                    			                    			
                		}                    		
                	}
    			}
    		}
    		line = reader.readLine();
        }         			
        reader.close();
        in.close();  
        return lineResult;                               
  	}
	
	//测试——文本框（边距）
  	public String textBoxPadding(String fileName, int lineNumber) throws IOException {
  		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
    	LineNumberReader reader = new LineNumberReader(in);
    	String line = reader.readLine();
    	String lineResult = "";  
    	String temp = testTextBox(fileName,lineNumber);
    	while (line != null) {
    		if(temp != null) {
    			if(line.indexOf("<style:style style:name=\""+temp+"\" ") != -1) {
    				line = reader.readLine();
    				String arrays[] = line.split(" ");
                	for(int j=0;j<arrays.length;j++) {
                		if(arrays[j].indexOf("fo:padding-left=") != -1 | arrays[j].indexOf("fo:padding-right=") != -1 | arrays[j].indexOf("fo:padding-top=") != -1 | arrays[j].indexOf("fo:padding-bottom=") != -1) {
                			line = arrays[j];
                			lineResult = line + lineResult;                    			                    			
                		}                    		
                	}
    			}
    		}
    		line = reader.readLine();
        }         			
        reader.close();
        in.close();  
        return lineResult;                               
  	}
	
	//测试——文本框（自动换行）
  	public String textBoxAutoWrap(String fileName, int lineNumber) throws IOException {
  		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
    	LineNumberReader reader = new LineNumberReader(in);
    	String line = reader.readLine();
    	String lineResult = "";  
    	String temp = testTextBox(fileName,lineNumber);
    	while (line != null) {
    		if(temp != null) {
    			if(line.indexOf("<style:style style:name=\""+temp+"\" ") != -1) {
    				line = reader.readLine();
    				String arrays[] = line.split(" ");
                	for(int j=0;j<arrays.length;j++) {
                		if(arrays[j].indexOf("fo:wrap-option=") != -1) {
                			line = arrays[j];
                			lineResult = line + lineResult;                    			                    			
                		}                    		
                	}
    			}
    		}
    		line = reader.readLine();
        }         			
        reader.close();
        in.close();  
        return lineResult;                               
  	}
  	
  	//测试——文本框（尺寸）
  	public String textBoxSize(String fileName, int lineNumber) throws IOException {        
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
  	
  	//测试——文本框（旋转）
  	public String textBoxRotate(String fileName, int lineNumber) throws IOException {
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
  	
}
