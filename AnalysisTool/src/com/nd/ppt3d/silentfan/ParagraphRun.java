package com.nd.ppt3d.silentfan;

import java.io.IOException;

public class ParagraphRun extends PublicMethod {
	
	public ScriptCaseParagraph caseParagraph = new ScriptCaseParagraph();
	
	//段落——行距段前
	public String paragraphPreSegmentRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseParagraph.paragraphPreSegment(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
	//段落——行距行距
	public String paragraphRowSpacingRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseParagraph.paragraphRowSpacing(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
	//段落——行距段后
	public String paragraphPostSegmentRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseParagraph.paragraphPostSegment(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
	//段落——对齐方式
	public String paragraphAlignmentRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseParagraph.paragraphAlignment(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
	//段落——缩进（文本之前）
	public String paragraphIndentPreTextRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseParagraph.paragraphIndentPreText(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
	//段落——缩进（特殊格式、度量值）
	public String paragraphSpecialFormatMeasureRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseParagraph.paragraphSpecialFormatMeasure(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
	//段落——分栏数
	public String paragraphNumberOfColumnsRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseParagraph.paragraphNumberOfColumns(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
	//段落——项目符号（图标）
	public String paragraphBulletIconRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseParagraph.paragraphBulletIcon(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
	//段落——项目符号编号（大小）
	public String paragraphBulletSizeRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseParagraph.paragraphBulletSize(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
	//段落——项目符号编号（颜色）
	public String paragraphBulletColorRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseParagraph.paragraphBulletColor(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
	//段落——编号（起始编号）
	public String paragraphNumberStartPositionRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseParagraph.paragraphNumberStartPosition(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}
	
	//段落——列表等级
	public String paragraphListLevelRun(String fileName) throws IOException{
		String results = "";
		int[] lineNumber = findLineNumberStartEnd(fileName);
		for(int i = lineNumber[0];i <= lineNumber[1];i++) {
        	String line = caseParagraph.paragraphListLevel(fileName, i);
        	if(line != "") {
        		results = results + line;
        		results = results + "\n";
        	}				        	
        }
		return results;
	}

}
