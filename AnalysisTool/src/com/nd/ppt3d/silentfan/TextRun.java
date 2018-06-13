package com.nd.ppt3d.silentfan;

import java.io.IOException;

public class TextRun extends PublicMethod {
	
	public ScriptCaseText caseText = new ScriptCaseText();	
	
	//文本内容
	public String textContentRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseText.textContent(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
	//文本字体
	public String textFontRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseText.textFont(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
	//文本字号
	public String textSizeRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseText.textSize(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
	//文本加粗
	public String textBoldRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseText.textBold(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
	//文本倾斜
	public String textItalicRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseText.textItalic(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
	//文本下划线
	public String textUnderlineRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseText.textUnderline(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
	//文本阴影
	public String textShadowRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseText.textShadow(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
	//文本删除线
	public String textStrikeoutRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseText.textStrikeout(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
	//文本字符间距
	public String textCharacterSpacingRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseText.textCharacterSpacing(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
	//文本上下标
	public String textSuperSubScriptRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseText.textSuperSubScript(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
	//文本突出显示颜色
	public String textHighlightColorRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseText.textHighlightColor(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
	//文本填充（颜色）
	public String textFillColorRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseText.textFillColor(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
	//文本填充（图片）
	public String textFillImageRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseText.textFillImage(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
	//文本填充（渐变）
	public String textGradualChangeRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseText.textGradualChange(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
	//文本填充（纹理）
	public String textGrainRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseText.textGrain(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
	//文本轮廓（颜色）
	public String textOutlineColorRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseText.textOutlineColor(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
	//文本轮廓（粗细）
	public String textOutlineThickThinRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseText.textOutlineThickThin(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
	//文本轮廓（线条样式）
	public String textOutlineLineStyleRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseText.textOutlineLineStyle(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
	//文字效果（阴影）
	public String textEffectShadowRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseText.textEffectShadow(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
	//文字效果（映像）
	public String textEffectReflectionRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseText.textEffectReflection(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
	//文字效果（转换）
	public String textEffectTransformRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseText.textEffectTransform(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
}
