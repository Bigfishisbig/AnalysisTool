package com.nd.ppt3d.silentfan;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ScriptCaseHeaderFooter {
	
  	//测试——页眉页脚（日期/时间）
  	public String headerFooterDateTime(String fileName, int lineNumber) throws IOException {        
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));	      
        String line = reader.readLine().toString();
        String lineResult = "";     
        int num = 0;        
        while (line != null) {
            if (lineNumber == ++num) {
            	if(line.indexOf("<text:p nd:afld") != -1) {   
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
}
