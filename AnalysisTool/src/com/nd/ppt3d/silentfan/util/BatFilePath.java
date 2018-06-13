package com.nd.ppt3d.silentfan.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class BatFilePath {

	//创建。bat文件
	public void writeFile(String path,String loPath,String filePath) {		
		try {
			FileWriter thisFile = new FileWriter(path,true);
			PrintWriter out = new PrintWriter(thisFile);
			out.println("start cmd /k \"cd/d " + loPath + "  &&lo.exe " + filePath + " &&taskkill /f /t /im cmd.exe\"");
			out.close();
			thisFile.close();
		}catch(IOException e) {
			
		}
	}
	
	//执行.bat文件
	public void execute(String cmdLine) {
		try {
			String line = "";
			Process pro = Runtime.getRuntime().exec(cmdLine);
			BufferedReader buf = new BufferedReader(new InputStreamReader(pro.getInputStream()));
			line = buf.readLine();
			while(line != null) {
				line = buf.readLine();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//判断是否存在文件，存在将其删除
	public void checkFileExist(String filePath) throws Exception {
		File file = new File(filePath);
		if(file.exists()) {
			file.delete();
		}
		
	}
	
	//执行lo。exe
	public void loExe(String loPath,String filePath) throws Exception {
		//String loPath = "D:\\桌面\\暂放\\PPTEditor";
		//String filePath = "D:\\桌面\\暂放\\Test.pptx";
		BatFilePath bat = new BatFilePath();
		String batFilePath = "D:\\batFilePath.bat" ;
		bat.checkFileExist(batFilePath);
		bat.writeFile(batFilePath,loPath,filePath);
		bat.execute("cmd /c "+batFilePath);
	}
}
