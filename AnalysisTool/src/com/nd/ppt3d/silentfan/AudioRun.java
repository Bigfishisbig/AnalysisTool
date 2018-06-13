package com.nd.ppt3d.silentfan;

import java.io.IOException;

public class AudioRun extends PublicMethod {

	public ScriptCaseAudio caseAudio = new ScriptCaseAudio();
	
	//“Ù∆µ£®“Ù∆µƒ⁄»›£©
	public String audioContentRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseAudio.audioContent(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
	//“Ù∆µ£®≥ﬂ¥Á£©
	public String audioSizeRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseAudio.audioSize(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
	//“Ù∆µ£®–˝◊™£©
	public String audioRotateRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseAudio.audioRotate(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
}
