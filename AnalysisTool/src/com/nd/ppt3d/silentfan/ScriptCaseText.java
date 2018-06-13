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

public class ScriptCaseText {
	   
    //�����ı�����step1
    public ArrayList testText(String fileName, int lineNumber)throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));	      
        String line = reader.readLine().toString();
        ArrayList textNumber = new ArrayList();
        String regex = "<text:span text:style-name=\"T(.*?)\">";
        int num = 0;
        while (line != null) {
            if (lineNumber == ++num) {
            	if(line.indexOf("<text:p") != -1) {
            		Pattern pattern = Pattern.compile(regex);
        		    Matcher matcher = pattern.matcher(line);
        		    while(matcher.find()) {
        		    	textNumber.add(Integer.parseInt(matcher.group(1))); 
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
    
    //���ԡ����ı����ı����ݣ�
  	public String textContent(String fileName, int lineNumber)throws IOException {
  		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));	      
        String line = reader.readLine().toString();
        String lineResult = "";     
        List<String> list = new ArrayList<String>();
        int num = 0;        
        while (line != null) {
            if (lineNumber == ++num) {
            	if(line.indexOf("<text:p") != -1) {                			
            		Pattern pattern = Pattern.compile("<text:span text:style-name=\"T"+"[0-9]{1,}"+"\">"+"(.*?)"+"</text:span>");
                	Matcher matcher = pattern.matcher(line);  
                	while(matcher.find()) {
                		boolean flag = true;
                		String temp = matcher.group(1);
                		Pattern p = Pattern.compile("<"+"(.*?)"+"/>");
                    	Matcher m = p.matcher(temp); 
                    	while(m.find()) {
                    		flag = false;
                    	}
                    	if(flag) {
                    		list.add(matcher.group(1));
                    	}
                	} 
                	for(int i = 0;i<list.size();i++) {
            			lineResult = lineResult + list.get(i);
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
    
    //���ԡ����ı������壩step2
    public String textFont(String fileName, int lineNumber) throws IOException {
    	BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
    	LineNumberReader reader = new LineNumberReader(in);
    	String s = reader.readLine();
    	String lineResult = "";
    	ArrayList list = testText(fileName,lineNumber);    
    	if(list != null) {
    		while (s != null) {      			
        		for(int i = 0;i<list.size();i++) {  
        			if (s.equals("  <style:style style:name=\"T"+list.get(i).toString()+"\" style:family=\"text\">")) {
                    	s = reader.readLine();
                    	String arrays[] = s.split(" ");
                    	for(int j=0;j<arrays.length;j++) {
                    		if(arrays[j].indexOf("style:font-name=") != -1) {
                    			s = arrays[j];
                    			lineResult = s + lineResult;                    			                    			
                    			break;
                    		}                    		
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
    
    //���ԡ����ı����ֺţ�step2
    public String textSize(String fileName, int lineNumber) throws IOException {
    	BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
    	LineNumberReader reader = new LineNumberReader(in);
    	String s = reader.readLine();
    	String lineResult = "";
    	ArrayList list = testText(fileName,lineNumber);    
    	if(list != null) {
    		while (s != null) {      			
        		for(int i = 0;i<list.size();i++) {  
        			if (s.equals("  <style:style style:name=\"T"+list.get(i).toString()+"\" style:family=\"text\">")) {
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
    	}
    	else {
    		lineResult = "";
    	}    	    	    	
        reader.close();
        in.close();  
        return lineResult;
    }
    
    //���ԡ����ı����Ӵ֣�step2
    public String textBold(String fileName, int lineNumber) throws IOException {
    	BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
    	LineNumberReader reader = new LineNumberReader(in);
    	String s = reader.readLine();
    	String lineResult = "";
    	ArrayList list = testText(fileName,lineNumber);    
    	if(list != null) {
    		while (s != null) {      			
        		for(int i = 0;i<list.size();i++) {  
        			if (s.equals("  <style:style style:name=\"T"+list.get(i).toString()+"\" style:family=\"text\">")) {
                    	s = reader.readLine();
                    	String arrays[] = s.split(" ");
                    	for(int j=0;j<arrays.length;j++) {
                    		if(arrays[j].indexOf("fo:font-weight=") != -1) {
                    			s = arrays[j];
                    			lineResult = s + lineResult;                    			                    			
                    			break;
                    		}                    		
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
    
    //���ԡ����ı�����б��step2
    public String textItalic(String fileName, int lineNumber) throws IOException {
    	BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
    	LineNumberReader reader = new LineNumberReader(in);
    	String s = reader.readLine();
    	String lineResult = "";
    	ArrayList list = testText(fileName,lineNumber);    
    	if(list != null) {
    		while (s != null) {      			
        		for(int i = 0;i<list.size();i++) {  
        			if (s.equals("  <style:style style:name=\"T"+list.get(i).toString()+"\" style:family=\"text\">")) {
                    	s = reader.readLine();
                    	String arrays[] = s.split(" ");
                    	for(int j=0;j<arrays.length;j++) {
                    		if(arrays[j].indexOf("fo:font-style=") != -1) {
                    			s = arrays[j];
                    			lineResult = s + lineResult;                    			                    			
                    			break;
                    		}                    		
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
    
    //���ԡ����ı����»��ߣ�step2
    public String textUnderline(String fileName, int lineNumber) throws IOException {
    	BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
    	LineNumberReader reader = new LineNumberReader(in);
    	String s = reader.readLine();
    	String lineResult = "";
    	ArrayList list = testText(fileName,lineNumber);    
    	if(list != null) {
    		while (s != null) {      			
        		for(int i = 0;i<list.size();i++) {  
        			if (s.equals("  <style:style style:name=\"T"+list.get(i).toString()+"\" style:family=\"text\">")) {
                    	s = reader.readLine();
                    	String arrays[] = s.split(" ");
                    	for(int j=0;j<arrays.length;j++) {
                    		if(arrays[j].indexOf("style:text-underline-style=") != -1) {
                    			s = arrays[j];
                    			lineResult = s + lineResult;                    			                    			
                    			break;
                    		}                    		
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
    
    //���ԡ����ı�����Ӱ��step2
    public String textShadow(String fileName, int lineNumber) throws IOException {
    	BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
    	LineNumberReader reader = new LineNumberReader(in);
    	String s = reader.readLine();
    	String lineResult = "";
    	ArrayList list = testText(fileName,lineNumber);    
    	if(list != null) {
    		while (s != null) {      			
        		for(int i = 0;i<list.size();i++) {  
        			if (s.equals("  <style:style style:name=\"T"+list.get(i).toString()+"\" style:family=\"text\">")) {
                    	s = reader.readLine();
                    	String arrays[] = s.split(" ");
                    	for(int j=0;j<arrays.length;j++) {
                    		if(arrays[j].indexOf("fo:text-shadow=") != -1) {
                    			s = arrays[j];
                    			lineResult = s + lineResult;                    			                    			
                    			break;
                    		}                    		
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
    
    //���ԡ����ı���ɾ���ߣ�step2
    public String textStrikeout(String fileName, int lineNumber) throws IOException {
    	BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
    	LineNumberReader reader = new LineNumberReader(in);
    	String s = reader.readLine();
    	String lineResult = "";
    	ArrayList list = testText(fileName,lineNumber);    
    	if(list != null) {
    		while (s != null) {      			
        		for(int i = 0;i<list.size();i++) {  
        			if (s.equals("  <style:style style:name=\"T"+list.get(i).toString()+"\" style:family=\"text\">")) {
                    	s = reader.readLine();
                    	String arrays[] = s.split(" ");
                    	for(int j=0;j<arrays.length;j++) {
                    		if(arrays[j].indexOf("style:text-line-through-style=") != -1 | arrays[j].indexOf("style:text-line-through-type=") != -1) {
                    			s = arrays[j];
                    			lineResult = s + lineResult;                    			                    			
                    		}                    		
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
    
    //���ԡ����ı����ַ���ࣩstep2
    public String textCharacterSpacing(String fileName, int lineNumber) throws IOException {
    	BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
    	LineNumberReader reader = new LineNumberReader(in);
    	String s = reader.readLine();
    	String lineResult = "";
    	ArrayList list = testText(fileName,lineNumber);    
    	if(list != null) {
    		while (s != null) {      			
        		for(int i = 0;i<list.size();i++) {  
        			if (s.equals("  <style:style style:name=\"T"+list.get(i).toString()+"\" style:family=\"text\">")) {
                    	s = reader.readLine();
                    	String arrays[] = s.split(" ");
                    	for(int j=0;j<arrays.length;j++) {
                    		if(arrays[j].indexOf("fo:letter-spacing=") != -1) {
                    			s = arrays[j];
                    			lineResult = s + lineResult;                    			                    			
                    			break;
                    		}                    		
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
    
    //���ԡ����ı������±꣩step2
    public String textSuperSubScript(String fileName, int lineNumber) throws IOException {
    	BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
    	LineNumberReader reader = new LineNumberReader(in);
    	String s = reader.readLine();
    	String lineResult = "";
    	ArrayList list = testText(fileName,lineNumber);    
    	if(list != null) {
    		while (s != null) {      			
        		for(int i = 0;i<list.size();i++) {  
        			if (s.equals("  <style:style style:name=\"T"+list.get(i).toString()+"\" style:family=\"text\">")) {
                    	s = reader.readLine();
                    	String arrays[] = s.split(" ");
                    	for(int j=0;j<arrays.length;j++) {
                    		if(arrays[j].indexOf("style:text-position=") != -1) {
                    			s = arrays[j];
                    			lineResult = s + lineResult;                    			                    			
                    			break;
                    		}                    		
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
    
    //���ԡ����ı����ı�ͻ����ʾ��ɫ��step2
    public String textHighlightColor(String fileName, int lineNumber) throws IOException {
    	BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
    	LineNumberReader reader = new LineNumberReader(in);
    	String s = reader.readLine();
    	String lineResult = "";
    	ArrayList list = testText(fileName,lineNumber);    
    	if(list != null) {
    		while (s != null) {      			
        		for(int i = 0;i<list.size();i++) {  
        			if (s.equals("  <style:style style:name=\"T"+list.get(i).toString()+"\" style:family=\"text\">")) {
                    	s = reader.readLine();
                    	String arrays[] = s.split(" ");
                    	for(int j=0;j<arrays.length;j++) {
                    		if(arrays[j].indexOf("fo:background-color=") != -1) {
                    			s = arrays[j];
                    			lineResult = s + lineResult;                    			                    			
                    			break;
                    		}                    		
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
    
    //���ԡ����ı���䣨��ɫ��step2
    public String textFillColor(String fileName, int lineNumber) throws IOException {
    	BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
    	LineNumberReader reader = new LineNumberReader(in);
    	String s = reader.readLine();
    	String lineResult = "";
    	ArrayList list = testText(fileName,lineNumber);    
    	if(list != null) {
    		while (s != null) {      			
        		for(int i = 0;i<list.size();i++) {  
        			if (s.equals("  <style:style style:name=\"T"+list.get(i).toString()+"\" style:family=\"text\">")) {
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
    	}
    	else {
    		lineResult = "";
    	}    	    	    	
        reader.close();
        in.close();  
        return lineResult;
    }
    
    //���ԡ����ı���䣨ͼƬ��step2
    public String textFillImage(String fileName, int lineNumber) throws IOException {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));	      
        String line = reader.readLine().toString();
        String lineResult = "";     
        List<String> list = new ArrayList<String>();
        int num = 0;          
        while (line != null) {
            if (lineNumber == ++num) {
            	if(line.indexOf("<text:p") != -1) {                			
            		Pattern pattern = Pattern.compile("r:embed=\""+"(.*?)"+"\"><a:extLst>");
                	Matcher matcher = pattern.matcher(line);  
                	while(matcher.find()) {
                		list.add(matcher.group(1));
                	} 
                	for(int i = 0;i<list.size();i++) {
            			lineResult = lineResult + list.get(i);
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
    
    //���ԡ����ı���䣨���䣩step2
    public String textGradualChange(String fileName, int lineNumber) throws IOException {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));	      
        String line = reader.readLine().toString();
        String lineResult = "";     
        List<String> list = new ArrayList<String>();
        int num = 0;       
        String regexOne = "<a:path path=\"circle\">(.*?)</a:gradFill>";
        String regexTwo = "<a:lin ang=(.*?)/>";
        while (line != null) {
            if (lineNumber == ++num) {
            	if(line.indexOf("<text:p") != -1) {     
            		if(line.indexOf("<a:path path=\"circle\">") != -1) {
            			Pattern patternOne = Pattern.compile(regexOne);
            			Matcher matcher = patternOne.matcher(line);
            			while(matcher.find()) {
                    		list.add(matcher.group(1));
                    	} 
            		}else if(line.indexOf("<a:lin ang") != -1){
            			Pattern patternTwo = Pattern.compile(regexTwo);
            			Matcher matcher = patternTwo.matcher(line);
            			while(matcher.find()) {
                    		list.add(matcher.group(1));
                    	} 
            		}               	                  	
                	for(int i = 0;i<list.size();i++) {
            			lineResult = lineResult + list.get(i);
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
    
    //���ԡ����ı���䣨����step2
    public String textGrain(String fileName, int lineNumber) throws IOException {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));	      
        String line = reader.readLine().toString();
        String lineResult = "";     
        List<String> list = new ArrayList<String>();
        int num = 0;          
        while (line != null) {
            if (lineNumber == ++num) {
            	if(line.indexOf("<text:p") != -1) {                			
            		Pattern pattern = Pattern.compile("r:embed=\""+"(.*?)"+"/>");
                	Matcher matcher = pattern.matcher(line);  
                	while(matcher.find()) {
                		list.add(matcher.group(1));
                	} 
                	for(int i = 0;i<list.size();i++) {
            			lineResult = lineResult + list.get(i);
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
    
    //���ԡ����ı���������ɫ��step2
    public String textOutlineColor(String fileName, int lineNumber) throws IOException {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));	      
        String line = reader.readLine().toString();
        String lineResult = "";     
        List<String> list = new ArrayList<String>();
        int num = 0;          
        while (line != null) {
            if (lineNumber == ++num) {
            	if(line.indexOf("<text:p") != -1) {                			
            		Pattern pattern = Pattern.compile("<a:srgbClr "+"(.*?)"+"/>");
                	Matcher matcher = pattern.matcher(line);  
                	while(matcher.find()) {
                		list.add(matcher.group(1));
                	} 
                	for(int i = 0;i<list.size();i++) {
            			lineResult = lineResult + list.get(i);
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
    
    //���ԡ����ı���������ϸ��step2
    public String textOutlineThickThin(String fileName, int lineNumber) throws IOException {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));	      
        String line = reader.readLine().toString();
        String lineResult = "";     
        List<String> list = new ArrayList<String>();
        int num = 0;          
        while (line != null) {
            if (lineNumber == ++num) {
            	if(line.indexOf("<text:p") != -1) {                			
            		Pattern pattern = Pattern.compile("<a:ln "+"(.*?)"+">");
                	Matcher matcher = pattern.matcher(line);  
                	while(matcher.find()) {
                		list.add(matcher.group(1));
                	} 
                	for(int i = 0;i<list.size();i++) {
            			lineResult = lineResult + list.get(i);
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
    
    //���ԡ����ı�������������ʽ��step2
    public String textOutlineLineStyle(String fileName, int lineNumber) throws IOException {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));	      
        String line = reader.readLine().toString();
        String lineResult = "";     
        List<String> list = new ArrayList<String>();
        int num = 0;          
        while (line != null) {
            if (lineNumber == ++num) {
            	if(line.indexOf("<text:p") != -1) {                			
            		Pattern pattern = Pattern.compile("<a:prstDash "+"(.*?)"+"/>");
                	Matcher matcher = pattern.matcher(line);  
                	while(matcher.find()) {
                		list.add(matcher.group(1));
                	} 
                	for(int i = 0;i<list.size();i++) {
            			lineResult = lineResult + list.get(i);
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
    
    //���ԡ�������Ч������Ӱ��step2
    public String textEffectShadow(String fileName, int lineNumber) throws IOException {
    	BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
    	LineNumberReader reader = new LineNumberReader(in);
    	String s = reader.readLine();
    	String lineResult = "";
    	ArrayList list = testText(fileName,lineNumber);    
    	if(list != null) {
    		while (s != null) {      			
        		for(int i = 0;i<list.size();i++) {  
        			if (s.equals("  <style:style style:name=\"T"+list.get(i).toString()+"\" style:family=\"text\">")) {
                    	s = reader.readLine();
                    	String arrays[] = s.split(" ");
                    	for(int j=0;j<arrays.length;j++) {
                    		if(arrays[j].indexOf("fo:text-shadow=") != -1) {
                    			s = arrays[j];
                    			lineResult = s + lineResult;                    			                    			
                    			break;
                    		}                    		
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
    
    //���ԡ�������Ч����ӳ��step2
    public String textEffectReflection(String fileName, int lineNumber) throws IOException {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));	      
        String line = reader.readLine().toString();
        String lineResult = "";     
        List<String> list = new ArrayList<String>();
        int num = 0;          
        while (line != null) {
            if (lineNumber == ++num) {
            	if(line.indexOf("<text:p") != -1) {                			
            		Pattern pattern = Pattern.compile("<a:effectLst>"+"(.*?)"+"</a:effectLst>");
                	Matcher matcher = pattern.matcher(line);  
                	while(matcher.find()) {
                		list.add(matcher.group(1));
                	} 
                	for(int i = 0;i<list.size();i++) {
            			lineResult = lineResult + list.get(i);
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
    
    //���ԡ�������Ч����ת����step2
    public String textEffectTransform(String fileName, int lineNumber) throws IOException {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));	      
        String line = reader.readLine().toString();
        String lineResult = "";     
        List<String> list = new ArrayList<String>();
        int num = 0;          
        while (line != null) {
            if (lineNumber == ++num) {
            	if(line.indexOf("<text:p") != -1) {                			
            		Pattern pattern = Pattern.compile("<a:prstTxWarp "+"(.*?)"+">");
                	Matcher matcher = pattern.matcher(line);  
                	while(matcher.find()) {
                		list.add(matcher.group(1));
                	} 
                	for(int i = 0;i<list.size();i++) {
            			lineResult = lineResult + list.get(i);
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
