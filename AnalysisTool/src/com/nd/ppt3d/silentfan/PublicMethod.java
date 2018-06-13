package com.nd.ppt3d.silentfan;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class PublicMethod {
   
    //取文件内容——起始和结束位置行数信息
    public int[] findLineNumberStartEnd(String fileName) throws IOException {
    	BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
    	LineNumberReader reader = new LineNumberReader(in);
    	String s = reader.readLine();
    	int lineStart = 0;
    	int lineEnd = 0;
    	int[] lineResult = new int[2]; 
    	while (s != null) {        
            lineStart++;
            lineEnd++;
            if (s.equals(" <office:body>")) {
            	lineResult[0] = lineStart;
            }else if(s.equals(" </office:body>")) {
            	lineResult[1] = lineEnd;
            }
            s = reader.readLine();
        }
        reader.close();
        in.close();
    	return lineResult;
    }
}
