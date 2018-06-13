package com.nd.ppt3d.silentfan;

import java.io.IOException;

public class PictureRun extends PublicMethod {

	public ScriptCasePicture casePicture = new ScriptCasePicture();
	
	//ͼƬ���ߴ磩
	public String pictureSizeRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = casePicture.pictureSize(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
	//ͼƬ����ת��
	public String pictureRotateRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = casePicture.pictureRotate(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
	//ͼƬ���ü�Ϊ��״�����߿���ʽ��
	public String pictureCutShapeBorderStyleRun(String fileName) throws IOException{
		String results = "";	
		String line = casePicture.pictureCutShapeBorderStyle(fileName);
    	if(line != "") {
    		results = results + line;
    	}	
		return results;
	}
	
	//ͼƬ���ü�Ϊ��״�����߿���ɫ��
	public String pictureCutShapeBorderColorRun(String fileName) throws IOException{
		String results = "";	
		int[] lineNumber = findLineNumberStartEnd(fileName);
		if(lineNumber != null) {
			for(int i = lineNumber[0];i <= lineNumber[1];i++) {
	        	String line = casePicture.pictureCutShapeBorderColor(fileName, i);
	        	if(line != "") {
	        		results = results + line;
	        		results = results + "\n";
	        		break;
	        	}				        	
	        }
		}
		return results;
	}
}
