package com.nd.ppt3d.silentfan.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class BatFilePath {

	//������bat�ļ�
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
	
	//ִ��.bat�ļ�
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
	
	//�ж��Ƿ�����ļ������ڽ���ɾ��
	public void checkFileExist(String filePath) throws Exception {
		File file = new File(filePath);
		if(file.exists()) {
			file.delete();
		}
		
	}
	
	//ִ��lo��exe
	public void loExe(String loPath,String filePath) throws Exception {
		//String loPath = "D:\\����\\�ݷ�\\PPTEditor";
		//String filePath = "D:\\����\\�ݷ�\\Test.pptx";
		BatFilePath bat = new BatFilePath();
		String batFilePath = "D:\\batFilePath.bat" ;
		bat.checkFileExist(batFilePath);
		bat.writeFile(batFilePath,loPath,filePath);
		bat.execute("cmd /c "+batFilePath);
	}
}
