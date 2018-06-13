package com.nd.ppt3d.silentfan;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.nd.ppt3d.silentfan.util.BatFilePath;
import com.nd.ppt3d.silentfan.util.FileCopy;

public class Analysis extends JFrame implements ActionListener,ItemListener {
	
	public String str1[] = {"文本","段落","文本框","图片","音频","视频","形状","表格","超链接","动画","Smartart","图表","公式","页眉页脚"};
	public String strText[] = {"内容","字体","字号","加粗","倾斜","下划线","阴影","删除线","字符间距","上下标","文本突出显示颜色","文本填充（颜色）","文本填充（图片）","文本填充（渐变）","文本填充（纹理）","文本轮廓（颜色）","文本轮廓（粗细）","文本轮廓（线条样式）","文字效果（阴影）","文字效果（映像）","文字效果（转换）"};
	public String strPhase[] = {"行距（段前）","行距（行距）","行距（段后）","对齐方式","缩进（文本之前）","缩进（特殊格式、度量值）","文本方向（待开发）","分栏数","项目符号（图标）","项目符号编号（大小）","项目符号编号（颜色）","编号（起始编号）","列表等级"};
	public String strTextFrame[] = {"垂直对齐方式","文字方向（待开发）","边距","自动换行","尺寸","旋转","缩放（待讨论）"};
	public String strPicture[] = {"尺寸","旋转","缩放","裁剪（宽度、高度）","裁剪（裁剪为形状-边框形状）_待开发","裁剪（裁剪为形状-边框样式）","裁剪（裁剪为形状-边框颜色）","裁剪（裁剪后的图片纹理渲染生成）_待开发","排列（层级关系）_待开发"};
	public String strAudio[] = {"音频内容","音频长度","跨幻灯片播放、在后台播放","尺寸","旋转","缩放"};
	public String strVideo[] = {"视频内容","视频声音","视频长度","播放设置","尺寸","旋转","缩放"};
	public String strShape[] = {"形状数据（形状顶点数据）","形状样式（线条）","形状样式（矩形）","形状样式（基本形状）","形状样式（箭头汇总）","形状样式（公式形状）","形状样式（流程图）","形状样式（星与旗帜）","形状样式（标注）","形状轮廓（颜色）","形状轮廓（粗细）","形状轮廓（线条样式）","形状轮廓（箭头汇总）","尺寸","旋转","缩放","形状填充（图片）","形状填充（颜色）"};
	public String strTable[] = {"表格结构数据","单元格（文本框）内容数据-文本","单元格（文本框对象）数据-样式","单元格（文本框对象）数据-尺寸","单元格（文本框对象）数据-位置"};
	public String strHyperlink[] = {"是否超链接","屏幕提示（鼠标悬停的提示）","链接跳转内容（链接到文档内某一页）","链接跳转内容（链接到文件）","链接跳转内容（链接到网页）","点击前、点击后颜色"};
	public String strCartoon[] = {"进入效果","进入动画速度","进入动画声音","强调效果","动画速度","动画声音","退出效果","退出动画速度","退出动画声音","退出动画速度","路径"};
	public String strSmartart[] = {"直接转为图片，不需要二次编辑","缩放要清晰"};
	public String strPictureTable[] = {"直接转为图片，不需要二次编辑","缩放要清晰"};
	public String strFormula[] = {"直接转为图片，不需要二次编辑","缩放要清晰"};
	public String strHeaderFooter[] = {"日期/时间、幻灯片编号"};
	
	public JFrame frame = new JFrame("解析器测试工具");
	public JPanel upPanel = new JPanel();
	public JPanel centerPanel = new JPanel();
	public JPanel centerPanelLo = new JPanel();
	public JPanel downPanel = new JPanel();
	public JLabel itemLabel = new JLabel("测试项目：");	
	
	public JComboBox itemJComboBox;
	public JComboBox itemJComboBoxNext;
	public DefaultComboBoxModel itemParent = new DefaultComboBoxModel(str1);
	public DefaultComboBoxModel itemChildText = new DefaultComboBoxModel(strText);
	public DefaultComboBoxModel itemChildPhase = new DefaultComboBoxModel(strPhase);	
	public DefaultComboBoxModel itemChildTextFrame = new DefaultComboBoxModel(strTextFrame);
	public DefaultComboBoxModel itemChildPicture = new DefaultComboBoxModel(strPicture);
	public DefaultComboBoxModel itemChildAudio = new DefaultComboBoxModel(strAudio);
	public DefaultComboBoxModel itemChildVideo = new DefaultComboBoxModel(strVideo);
	public DefaultComboBoxModel itemChildShape = new DefaultComboBoxModel(strShape);
	public DefaultComboBoxModel itemChildTable = new DefaultComboBoxModel(strTable);
	public DefaultComboBoxModel itemChildHyperlink = new DefaultComboBoxModel(strHyperlink);
	public DefaultComboBoxModel itemChildCartoon = new DefaultComboBoxModel(strCartoon);
	public DefaultComboBoxModel itemChildSmartart = new DefaultComboBoxModel(strSmartart);
	public DefaultComboBoxModel itemChildPictureTable = new DefaultComboBoxModel(strPictureTable);
	public DefaultComboBoxModel itemChildFormula = new DefaultComboBoxModel(strFormula);
	public DefaultComboBoxModel itemChildHeaderFooter = new DefaultComboBoxModel(strHeaderFooter);
	
	public JLabel fileLabel = new JLabel("选择文件：");
	public JFileChooser fileChooser = new JFileChooser();
	public JTextField textField = new JTextField(25);
	public JTextField textFieldLo = new JTextField(25);
	public JButton btn = new JButton("浏览");
	public JButton btnRun = new JButton("运行");
	public JButton btnRunLo = new JButton("Lo解析执行");
	public JButton btnRunLoSave = new JButton("复制FODP文件到");
	public JLabel resultLable = new JLabel("结果查看：");
	public JTextArea area = new JTextArea(18,60);
	public JScrollPane pane = new JScrollPane(area,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	public TextRun textRun = new TextRun();
	public ParagraphRun paragraphRun = new ParagraphRun();
	public TextBoxRun textBoxRun = new TextBoxRun();
	public PictureRun pictureRun = new PictureRun();
	public AudioRun audioRun = new AudioRun();
	
	public HeaderFooterRun headerFooterRun = new HeaderFooterRun();
		
	public Analysis() {
		itemJComboBox = new JComboBox(itemParent);
		itemJComboBoxNext = new JComboBox(itemChildText);
		itemJComboBox.addItemListener(this);
		
		frame.setSize(880, 730);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		upPanel.setBackground(Color.white);
		upPanel.setLocation(60, 30);
		upPanel.setSize(740, 60);
		upPanel.add(itemLabel);
		upPanel.add(itemJComboBox);
		upPanel.add(itemJComboBoxNext);		
		
		centerPanel.setBackground(Color.gray);
		centerPanel.setLocation(60, 110);
		centerPanel.setSize(740,60);
		centerPanel.add(fileLabel);
		centerPanel.add(textField);
		centerPanel.add(btn);		
		centerPanel.add(btnRun);
		btn.addActionListener(this);
		btnRun.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					if(itemJComboBox.getSelectedItem().equals("文本")) {
						if(itemJComboBoxNext.getSelectedItem().equals("内容")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textContentRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("字体")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textFontRun(fileName);
							resultsOutput(results);							
						}else if(itemJComboBoxNext.getSelectedItem().equals("字号")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textSizeRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("加粗")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textBoldRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("倾斜")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textItalicRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("下划线")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textUnderlineRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("阴影")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textShadowRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("删除线")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textStrikeoutRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("字符间距")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textCharacterSpacingRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("上下标")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textSuperSubScriptRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("文本突出显示颜色")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textHighlightColorRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("文本填充（颜色）")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textFillColorRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("文本填充（图片）")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textFillImageRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("文本填充（渐变）")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textGradualChangeRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("文本填充（纹理）")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textGrainRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("文本轮廓（颜色）")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textOutlineColorRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("文本轮廓（粗细）")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textOutlineThickThinRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("文本轮廓（线条样式）")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textOutlineLineStyleRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("文字效果（阴影）")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textEffectShadowRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("文字效果（映像）")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textEffectReflectionRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("文字效果（转换）")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textEffectTransformRun(fileName);
							resultsOutput(results);
						}else {
							area.setText("");
							area.append("错误");
						}
					}else if(itemJComboBox.getSelectedItem().equals("段落")) {
						if(itemJComboBoxNext.getSelectedItem().equals("行距（段前）")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = paragraphRun.paragraphPreSegmentRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("行距（行距）")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = paragraphRun.paragraphRowSpacingRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("行距（段后）")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = paragraphRun.paragraphPostSegmentRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("对齐方式")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = paragraphRun.paragraphAlignmentRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("缩进（文本之前）")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = paragraphRun.paragraphIndentPreTextRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("缩进（特殊格式、度量值）")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = paragraphRun.paragraphSpecialFormatMeasureRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("文本方向（待开发）")) {
							area.setText("");
							String information = "需查看ERROR.TXT文件（orientation）,在PPTEditor\\temp下";
							area.setText(information);
						}else if(itemJComboBoxNext.getSelectedItem().equals("分栏数")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = paragraphRun.paragraphNumberOfColumnsRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("项目符号（图标）")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = paragraphRun.paragraphBulletIconRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("项目符号编号（大小）")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = paragraphRun.paragraphBulletSizeRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("项目符号编号（颜色）")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = paragraphRun.paragraphBulletColorRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("编号（起始编号）")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = paragraphRun.paragraphNumberStartPositionRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("列表等级")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = paragraphRun.paragraphListLevelRun(fileName);
							resultsOutput(results);
						}else {
							area.setText("");
							area.append("错误");
						}																														
					}else if(itemJComboBox.getSelectedItem().equals("文本框")) {
						if(itemJComboBoxNext.getSelectedItem().equals("垂直对齐方式")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textBoxRun.textBoxVerticalAlignmentRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("文字方向（待开发）")) {
							area.setText("");
							String information = "需查看ERROR.TXT文件,在PPTEditor\\temp下";
							area.setText(information);
						}else if(itemJComboBoxNext.getSelectedItem().equals("边距")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textBoxRun.textBoxPaddingRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("自动换行")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textBoxRun.textBoxAutoWrapRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("尺寸")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textBoxRun.textBoxSizeRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("旋转")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textBoxRun.textBoxRotateRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("缩放（待讨论）")) {
							area.setText("");
							String information = "OFFICE的设置缩放比例值修改后，最终又会弹回100%。这个功能的验证，没太大必要。因为缩放实质就是更改文本框的大小和文字的大小，对缩放比例值没有一定的数据去比较。";
							area.setText(information);
						}else {
							area.setText("");
							area.append("错误");
						}						
					}else if(itemJComboBox.getSelectedItem().equals("图片")) {
						if(itemJComboBoxNext.getSelectedItem().equals("尺寸")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = pictureRun.pictureSizeRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("旋转")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = pictureRun.pictureRotateRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("缩放")) {
							area.setText("");
							String information = "OFFICE的设置缩放比例值修改后，最终又会弹回100%。这个功能的验证，没太大必要。因为缩放实质就是更改文本框的大小和文字的大小，对缩放比例值没有一定的数据去比较。";
							area.setText(information);
						}else if(itemJComboBoxNext.getSelectedItem().equals("裁剪（宽度、高度）")) {
							area.setText("");
							String information = "偏解析渲染角度验证，解析器只能解析其尺寸。";
							area.setText(information);
						}else if(itemJComboBoxNext.getSelectedItem().equals("裁剪（裁剪为形状-边框形状）_待开发")) {
							area.setText("");
							String information = "需查看ERROR.TXT文件（prictrue_shape）,在PPTEditor\\temp下";
							area.setText(information);
						}else if(itemJComboBoxNext.getSelectedItem().equals("裁剪（裁剪为形状-边框样式）")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = pictureRun.pictureCutShapeBorderStyleRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("裁剪（裁剪为形状-边框颜色）")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = pictureRun.pictureCutShapeBorderColorRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("裁剪（裁剪后的图片纹理渲染生成）_待开发")) {
							area.setText("");
							String information = "图片形状裁剪的渲染待开发,QA:没有测试数据，需要再造";
							area.setText(information);
						}else if(itemJComboBoxNext.getSelectedItem().equals("排列（层级关系）_待开发")) {
							area.setText("");
							String information = "偏解析渲染角度验证，解析器需按照fodp内的draw:frame的排列顺序决定。没有固定的属性值去较验。";
							area.setText(information);
						}else {
							area.setText("");
							area.append("错误");
						}
					}else if(itemJComboBox.getSelectedItem().equals("音频")) {
						if(itemJComboBoxNext.getSelectedItem().equals("音频内容")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = audioRun.audioContentRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("音频长度")) {
							area.setText("");
							String information = "不在文档中，是内在属性，不用验证，不是解析器内容。验证是否存在音频同音频内容。";
							area.setText(information);
						}else if(itemJComboBoxNext.getSelectedItem().equals("跨幻灯片播放、在后台播放")) {
							area.setText("");
							String information = "开发未做，fodp无相应属性可查看。通过解析渲染可验证。";
							area.setText(information);
						}else if(itemJComboBoxNext.getSelectedItem().equals("尺寸")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = audioRun.audioSizeRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("旋转")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = audioRun.audioRotateRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("缩放")) {
							area.setText("");
							String information = "OFFICE的设置缩放比例值修改后，最终又会弹回100%。这个功能的验证，没太大必要。因为缩放实质就是更改音频的大小，对缩放比例值没有一定的数据去比较。";
							area.setText(information);
						}else {
							area.setText("");
							area.append("错误");
						}
					}else if(itemJComboBox.getSelectedItem().equals("视频")) {
						if(itemJComboBoxNext.getSelectedItem().equals("视频内容")) {
							area.setText("");
							String information = "同音频内容";
							area.setText(information);
						}else if(itemJComboBoxNext.getSelectedItem().equals("视频声音")) {
							area.setText("");
							String information = "偏解析渲染角度验证";
							area.setText(information);
						}else if(itemJComboBoxNext.getSelectedItem().equals("视频长度")) {
							area.setText("");
							String information = "同音频长度";
							area.setText(information);
						}else if(itemJComboBoxNext.getSelectedItem().equals("播放设置")) {
							area.setText("");
							String information = "同音频跨幻灯片播放、在后台播放";
							area.setText(information);
						}else if(itemJComboBoxNext.getSelectedItem().equals("尺寸")) {
							area.setText("");
							String information = "同音频尺寸";
							area.setText(information);
						}else if(itemJComboBoxNext.getSelectedItem().equals("旋转")) {
							area.setText("");
							String information = "同音频旋转";
							area.setText(information);
						}else if(itemJComboBoxNext.getSelectedItem().equals("缩放")) {
							area.setText("");
							String information = "同音频缩放";
							area.setText(information);
						}else {
							area.setText("");
							area.append("错误");
						}
					}else if(itemJComboBox.getSelectedItem().equals("形状")) {
						System.out.println(textField.getText());
					}else if(itemJComboBox.getSelectedItem().equals("表格")) {
						
					}else if(itemJComboBox.getSelectedItem().equals("超链接")) {
						
					}else if(itemJComboBox.getSelectedItem().equals("动画")) {
						
					}else if(itemJComboBox.getSelectedItem().equals("Smartart")) {
						
					}else if(itemJComboBox.getSelectedItem().equals("图表")) {
						
					}else if(itemJComboBox.getSelectedItem().equals("公式")) {
						
					}else if(itemJComboBox.getSelectedItem().equals("页眉页脚")) {
						if(itemJComboBoxNext.getSelectedItem().equals("日期/时间、幻灯片编号")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = headerFooterRun.headerFooterDateTimeRun(fileName);
							resultsOutput(results);
						}else {
							area.setText("");
							area.append("错误");
						}
					}else {
						area.setText("");
						area.append("错误");
					}					
				}catch(Exception eIO) {
					eIO.printStackTrace();
				}			
			}
		});
		
		centerPanelLo.setBackground(Color.white);
		centerPanelLo.setLocation(60,190);
		centerPanelLo.setSize(740,60);
		
		JLabel Label_lo_path = new JLabel("lo.exe\u8DEF\u5F84");
		centerPanelLo.add(Label_lo_path);
		centerPanelLo.add(textFieldLo);
		centerPanelLo.add(btnRunLo);
		btnRunLo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(textField.getText().equals(null) | textField.getText().equals("") | textFieldLo.getText().equals(null) | textFieldLo.getText().equals("")) {						
						area.setText("请选择相应文件和填入相应LO路径！");
					}else {						
						BatFilePath batFilePath = new BatFilePath();
						String loPath = textFieldLo.getText();
						String filePath = textField.getText(); 
						batFilePath.loExe(loPath, filePath);		
					}
				}catch(Exception eI) {
					eI.printStackTrace();
				}
			}
		});
		centerPanelLo.add(btnRunLoSave);
		btnRunLoSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileCopy fileCopy = new FileCopy();
				String temp1 = itemJComboBox.getSelectedItem().toString();
				String temp2 = itemJComboBoxNext.getSelectedItem().toString();
				fileCopy.fodpCopySave(temp1, temp2);
			}
		});
		
		downPanel.setBackground(Color.gray);
		downPanel.setLocation(60, 270);
		downPanel.setSize(740, 400);
		area.setLineWrap(true);
		downPanel.add(resultLable);	
		downPanel.add(pane);
		
		frame.getContentPane().add(upPanel);
		frame.getContentPane().add(centerPanel);
		frame.getContentPane().add(centerPanelLo);
		frame.getContentPane().add(downPanel);
	}
	
	//选择项目筛选事件监听
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == itemJComboBox) {
			if(itemJComboBox.getSelectedIndex() == 0) {
				itemJComboBoxNext.setModel(itemChildText);
			}else if(itemJComboBox.getSelectedIndex() == 1) {
				itemJComboBoxNext.setModel(itemChildPhase);
			}else if(itemJComboBox.getSelectedIndex() == 2) {
				itemJComboBoxNext.setModel(itemChildTextFrame);
			}else if(itemJComboBox.getSelectedIndex() == 3) {
				itemJComboBoxNext.setModel(itemChildPicture);
			}else if(itemJComboBox.getSelectedIndex() == 4) {
				itemJComboBoxNext.setModel(itemChildAudio);
			}else if(itemJComboBox.getSelectedIndex() == 5) {
				itemJComboBoxNext.setModel(itemChildVideo);
			}else if(itemJComboBox.getSelectedIndex() == 6) {
				itemJComboBoxNext.setModel(itemChildShape);
			}else if(itemJComboBox.getSelectedIndex() == 7) {
				itemJComboBoxNext.setModel(itemChildTable);
			}else if(itemJComboBox.getSelectedIndex() == 8) {
				itemJComboBoxNext.setModel(itemChildHyperlink);
			}else if(itemJComboBox.getSelectedIndex() == 9) {
				itemJComboBoxNext.setModel(itemChildCartoon);
			}else if(itemJComboBox.getSelectedIndex() == 10) {
				itemJComboBoxNext.setModel(itemChildSmartart);
			}else if(itemJComboBox.getSelectedIndex() == 11) {
				itemJComboBoxNext.setModel(itemChildPictureTable);
			}else if(itemJComboBox.getSelectedIndex() == 12) {
				itemJComboBoxNext.setModel(itemChildFormula);
			}else if(itemJComboBox.getSelectedIndex() == 13) {
				itemJComboBoxNext.setModel(itemChildHeaderFooter);
			}
		}
	}
	
	//浏览选择文件弹窗
	public void actionPerformed(ActionEvent e) {
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);  
		fileChooser.showDialog(new JLabel(), "选择");  
        File file = fileChooser.getSelectedFile(); 
        if(file != null) {
        	textField.setText(file.getAbsoluteFile().toString());  
        }else {
        	area.setText("请选择文件！");
        }
	}
	
	//area多行文本框结果数据判断输出
	public void resultsOutput(String results) {
		if(results != "") {
			area.append(results);
		}else {
			area.append("查无数据");
		}
	}
	
	//主程序入口
	public static void main(String[] args) throws IOException {
		new Analysis();	
	}
}
