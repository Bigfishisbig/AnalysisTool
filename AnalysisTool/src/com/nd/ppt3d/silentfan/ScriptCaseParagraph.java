package com.nd.ppt3d.silentfan;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScriptCaseParagraph {
	
	//���Զ��䡪��step1
    public String testParagraph(String fileName, int lineNumber)throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));	      
        String line = reader.readLine().toString();
        String textNumber = null;
        String regex = "<text:p text:style-name=\"P(.*?)\">";
        int num = 0;
        while (line != null) {
            if (lineNumber == ++num) {
            	if(line.indexOf("<text:p") != -1) {
            		Pattern pattern = Pattern.compile(regex);
        		    Matcher matcher = pattern.matcher(line);
        		    while(matcher.find()) {
        		    	textNumber = matcher.group(1); 
        		    }        		            		          		     		    
            	} else {
            		textNumber = null;
            	}
            }
            line = reader.readLine();
        }
        reader.close();               
        return textNumber;
    }
    
    //���Զ�����Ŀ���ű�š���step1
    public ArrayList testParagraphBullet(String fileName, int lineNumber)throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));	      
        String line = reader.readLine().toString();
        ArrayList textNumber = new ArrayList();
        String regexOne = "text:list text:style-name=\"L(.*?)\">";
        String regexTwo = "<text:list text:continue-numbering=\"true\" text:style-name=\"L(.*?)\">";
        int num = 0;
        while (line != null) {
            if (lineNumber == ++num) {
            	if(line.indexOf("<text:list ") != -1) {
            		if(line.indexOf("text:continue-numbering") != -1) {
            			Pattern pattern = Pattern.compile(regexTwo);
            		    Matcher matcher = pattern.matcher(line);
            		    while(matcher.find()) {
            		    	textNumber.add(Integer.parseInt(matcher.group(1))); 
            		    } 
            		}else {
            			Pattern pattern = Pattern.compile(regexOne);
            		    Matcher matcher = pattern.matcher(line);
            		    while(matcher.find()) {
            		    	textNumber.add(Integer.parseInt(matcher.group(1))); 
            		    } 
            		}
            	} else {
            		textNumber = null;
            	}
            }
            line = reader.readLine();
        }
        reader.close();  
        if(textNumber != null) {
        	HashSet h = new HashSet(textNumber);
            textNumber.clear();
            textNumber.addAll(h);
            Collections.sort(textNumber);
        }
        return textNumber;
    }
       
    //���Զ��䡪���о��ǰstep2
    public String paragraphPreSegment(String fileName, int lineNumber) throws IOException {
    	BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
    	LineNumberReader reader = new LineNumberReader(in);
    	String s = reader.readLine();
    	String lineResult = "";
    	String paragraph = testParagraph(fileName,lineNumber);    
    	if(paragraph != null) {
    		while (s != null) {   
    			if (s.equals("  <style:style style:name=\"P"+paragraph+"\" style:family=\"paragraph\">")) {
                	s = reader.readLine();
                	String arrays[] = s.split(" ");
                	for(int j=0;j<arrays.length;j++) {
                		if(arrays[j].indexOf("fo:margin-top=") != -1) {
                			s = arrays[j];
                			lineResult = s + lineResult;                    			                    			
                			break;
                		}                    		
                	}                      	
                }
        		s = reader.readLine();
            }
    	}
    	else {
    		lineResult = "";
    	}    	    	    	
        reader.close();
        in.close();  
        return lineResult;
    }
    
    //���Զ��䡪���о��о�step2
    public String paragraphRowSpacing(String fileName, int lineNumber) throws IOException {
    	BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
    	LineNumberReader reader = new LineNumberReader(in);
    	String s = reader.readLine();
    	String lineResult = "";
    	String paragraph = testParagraph(fileName,lineNumber);    
    	if(paragraph != null) {
    		while (s != null) {   
    			if (s.equals("  <style:style style:name=\"P"+paragraph+"\" style:family=\"paragraph\">")) {
                	s = reader.readLine();
                	String arrays[] = s.split(" ");
                	for(int j=0;j<arrays.length;j++) {
                		if(arrays[j].indexOf("fo:line-height=") != -1) {
                			s = arrays[j];
                			lineResult = s + lineResult;                    			                    			
                			break;
                		}                    		
                	}                      	
                }
        		s = reader.readLine();
            }
    	}
    	else {
    		lineResult = "";
    	}    	    	    	
        reader.close();
        in.close();  
        return lineResult;
    }
    
    //���Զ��䡪���о�κ�step2
    public String paragraphPostSegment(String fileName, int lineNumber) throws IOException {
    	BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
    	LineNumberReader reader = new LineNumberReader(in);
    	String s = reader.readLine();
    	String lineResult = "";
    	String paragraph = testParagraph(fileName,lineNumber);    
    	if(paragraph != null) {
    		while (s != null) {   
    			if (s.equals("  <style:style style:name=\"P"+paragraph+"\" style:family=\"paragraph\">")) {
                	s = reader.readLine();
                	String arrays[] = s.split(" ");
                	for(int j=0;j<arrays.length;j++) {
                		if(arrays[j].indexOf("fo:margin-bottom=") != -1) {
                			s = arrays[j];
                			lineResult = s + lineResult;                    			                    			
                			break;
                		}                    		
                	}                      	
                }
        		s = reader.readLine();
            }
    	}
    	else {
    		lineResult = "";
    	}    	    	    	
        reader.close();
        in.close();  
        return lineResult;
    }
    
    //���Զ��䡪�����뷽ʽstep2
    public String paragraphAlignment(String fileName, int lineNumber) throws IOException {
    	BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
    	LineNumberReader reader = new LineNumberReader(in);
    	String s = reader.readLine();
    	String lineResult = "";
    	String paragraph = testParagraph(fileName,lineNumber);    
    	if(paragraph != null) {
    		while (s != null) {   
    			if (s.equals("  <style:style style:name=\"P"+paragraph+"\" style:family=\"paragraph\">")) {
                	s = reader.readLine();
                	String arrays[] = s.split(" ");
                	for(int j=0;j<arrays.length;j++) {
                		if(arrays[j].indexOf("fo:text-align=") != -1) {
                			s = arrays[j];
                			lineResult = s + lineResult;                    			                    			
                			break;
                		}                    		
                	}                      	
                }
        		s = reader.readLine();
            }
    	}
    	else {
    		lineResult = "";
    	}    	    	    	
        reader.close();
        in.close();  
        return lineResult;
    }
    
    //���Զ��䡪���������ı�֮ǰ��step2
    public String paragraphIndentPreText(String fileName, int lineNumber) throws IOException {
    	BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
    	LineNumberReader reader = new LineNumberReader(in);
    	String s = reader.readLine();
    	String lineResult = "";
    	String paragraph = testParagraph(fileName,lineNumber);    
    	if(paragraph != null) {
    		while (s != null) {   
    			if (s.equals("  <style:style style:name=\"P"+paragraph+"\" style:family=\"paragraph\">")) {
                	s = reader.readLine();
                	String arrays[] = s.split(" ");
                	for(int j=0;j<arrays.length;j++) {
                		if(arrays[j].indexOf("fo:margin-left=") != -1) {
                			s = arrays[j];
                			lineResult = s + lineResult;                    			                    			
                			break;
                		}                    		
                	}                      	
                }
        		s = reader.readLine();
            }
    	}
    	else {
    		lineResult = "";
    	}    	    	    	
        reader.close();
        in.close();  
        return lineResult;
    }
    
    //���Զ��䡪�������������ʽ������ֵ��step2
    public String paragraphSpecialFormatMeasure(String fileName, int lineNumber) throws IOException {
    	BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
    	LineNumberReader reader = new LineNumberReader(in);
    	String s = reader.readLine();
    	String lineResult = "";
    	String paragraph = testParagraph(fileName,lineNumber);    
    	if(paragraph != null) {
    		while (s != null) {   
    			if (s.equals("  <style:style style:name=\"P"+paragraph+"\" style:family=\"paragraph\">")) {
                	s = reader.readLine();
                	String arrays[] = s.split(" ");
                	for(int j=0;j<arrays.length;j++) {
                		if(arrays[j].indexOf("fo:text-indent=") != -1) {
                			s = arrays[j];
                			lineResult = s + lineResult;                    			                    			
                			break;
                		}                    		
                	}                      	
                }
        		s = reader.readLine();
            }
    	}
    	else {
    		lineResult = "";
    	}    	    	    	
        reader.close();
        in.close();  
        return lineResult;
    }
    
    //���Զ��䡪��������step2
    public String paragraphNumberOfColumns(String fileName, int lineNumber) throws IOException {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));	      
        String line = reader.readLine().toString();
        String lineResult = "";     
        int num = 0;          
        while (line != null) {
            if (lineNumber == ++num) {
            	if(line.indexOf("<draw:text-box ") != -1) {                			
            		Pattern pattern = Pattern.compile("<draw:text-box "+"(.*?)"+">");
                	Matcher matcher = pattern.matcher(line);  
                	while(matcher.find()) {
                		lineResult = matcher.group(1);
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
    
    //���Զ��䡪����Ŀ���� ��ͼ�꣩step2
    public String paragraphBulletIcon(String fileName, int lineNumber) throws IOException {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));	      
        String line = reader.readLine().toString();
        String lineResult = "";     
        int num = 0;          
        while (line != null) {
            if (lineNumber == ++num) {
            	if(line.indexOf("<text:p ") != -1) {                			
            		Pattern pattern = Pattern.compile("<a:buChar "+"(.*?)"+"/>");
                	Matcher matcher = pattern.matcher(line);  
                	while(matcher.find()) {
                		lineResult = matcher.group(1);
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
    
    //���Զ��䡪����Ŀ���ű�ţ���С��step2
    public String paragraphBulletSize(String fileName, int lineNumber) throws IOException {
    	BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
    	LineNumberReader reader = new LineNumberReader(in);
    	String s = reader.readLine();
    	String lineResult = "";
    	ArrayList list = testParagraphBullet(fileName,lineNumber);     	
        if(list != null) {   
        	while (s != null) {      			
        		for(int i = 0;i<list.size();i++) {          			
        			if (s.equals("  <text:list-style style:name=\"L"+list.get(i).toString()+"\">")) {
                    	s = reader.readLine();
                    	s = reader.readLine();
                    	s = reader.readLine();
                    	String arrays[] = s.split(" ");
                    	for(int j=0;j<arrays.length;j++) {
                    		if(arrays[j].indexOf("fo:font-size=") != -1) {
                    			s = arrays[j];
                    			lineResult = s + lineResult;                    			                    			
                    			break;
                    		}                    		
                    	}                      	
                    }
        		}  
        		s = reader.readLine();
            }
        }else {
        	lineResult = "";
        }
        reader.close();
        return lineResult;
    }
    
    //���Զ��䡪����Ŀ���ű�ţ���ɫ��step2
    public String paragraphBulletColor(String fileName, int lineNumber) throws IOException {
    	BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
    	LineNumberReader reader = new LineNumberReader(in);
    	String s = reader.readLine();
    	String lineResult = "";
    	ArrayList list = testParagraphBullet(fileName,lineNumber);     	
        if(list != null) {   
        	while (s != null) {      			
        		for(int i = 0;i<list.size();i++) {          			
        			if (s.equals("  <text:list-style style:name=\"L"+list.get(i).toString()+"\">")) {
                    	s = reader.readLine();
                    	s = reader.readLine();
                    	s = reader.readLine();
                    	String arrays[] = s.split(" ");
                    	for(int j=0;j<arrays.length;j++) {
                    		if(arrays[j].indexOf("fo:color=") != -1) {
                    			s = arrays[j];
                    			lineResult = s + lineResult;                    			                    			
                    			break;
                    		}                    		
                    	}                      	
                    }
        		}  
        		s = reader.readLine();
            }
        }else {
        	lineResult = "";
        }
        reader.close();
        return lineResult;
    }
    
    //���Զ��䡪����ţ���ʼ��ţ�step2
    public String paragraphNumberStartPosition(String fileName, int lineNumber) throws IOException {
    	BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
    	LineNumberReader reader = new LineNumberReader(in);
    	String s = reader.readLine();
    	String lineResult = "";
    	ArrayList list = testParagraphBullet(fileName,lineNumber);     	
        if(list != null) {   
        	while (s != null) {      			
        		for(int i = 0;i<list.size();i++) {    
        			boolean flag = false;
        			if (s.equals("  <text:list-style style:name=\"L"+list.get(i).toString()+"\">")) {
                    	s = reader.readLine();
                    	String arrays[] = s.split(" ");
                    	for(int j=0;j<arrays.length;j++) {
                    		if(arrays[j].indexOf("text:start-value=") != -1) {
                    			flag = true;
                    			s = arrays[j];
                    			lineResult = s + lineResult;                    			                    			
                    			break;
                    		}
                    		flag = false;
                    	}
                    	if(flag = false) {
                    		lineResult = "��ʼ��ţ�1";
                    	}
                    }
        		}
        		s = reader.readLine();
            }
        }else {
        	lineResult = "";
        }
        reader.close();
        return lineResult;
    }
    
    //���Զ��䡪���б�ȼ�
    public String paragraphListLevel(String fileName, int lineNumber) throws IOException {
    	BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
    	LineNumberReader reader = new LineNumberReader(in);
    	String s = reader.readLine();
    	String lineResult = "";
    	String paragraph = testParagraph(fileName,lineNumber);    
    	if(paragraph != null) {
    		while (s != null) {   
    			if (s.equals("  <style:style style:name=\"P"+paragraph+"\" style:family=\"paragraph\">")) {
                	s = reader.readLine();
                	String arrays[] = s.split(" ");
                	for(int j=0;j<arrays.length;j++) {
                		if(arrays[j].indexOf("fo:margin-left=") != -1) {
                			s = arrays[j];
                			lineResult = s + lineResult;                    			                    			
                			break;
                		}                    		
                	}                      	
                }
        		s = reader.readLine();
            }
    	}
    	else {
    		lineResult = "";
    	}    	    	    	
        reader.close();
        in.close();  
        return lineResult;
    }
    
}
