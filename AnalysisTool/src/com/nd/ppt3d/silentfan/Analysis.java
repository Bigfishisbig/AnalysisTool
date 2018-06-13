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
	
	public String str1[] = {"�ı�","����","�ı���","ͼƬ","��Ƶ","��Ƶ","��״","���","������","����","Smartart","ͼ��","��ʽ","ҳüҳ��"};
	public String strText[] = {"����","����","�ֺ�","�Ӵ�","��б","�»���","��Ӱ","ɾ����","�ַ����","���±�","�ı�ͻ����ʾ��ɫ","�ı���䣨��ɫ��","�ı���䣨ͼƬ��","�ı���䣨���䣩","�ı���䣨����","�ı���������ɫ��","�ı���������ϸ��","�ı�������������ʽ��","����Ч������Ӱ��","����Ч����ӳ��","����Ч����ת����"};
	public String strPhase[] = {"�оࣨ��ǰ��","�оࣨ�оࣩ","�оࣨ�κ�","���뷽ʽ","�������ı�֮ǰ��","�����������ʽ������ֵ��","�ı����򣨴�������","������","��Ŀ���ţ�ͼ�꣩","��Ŀ���ű�ţ���С��","��Ŀ���ű�ţ���ɫ��","��ţ���ʼ��ţ�","�б�ȼ�"};
	public String strTextFrame[] = {"��ֱ���뷽ʽ","���ַ��򣨴�������","�߾�","�Զ�����","�ߴ�","��ת","���ţ������ۣ�"};
	public String strPicture[] = {"�ߴ�","��ת","����","�ü�����ȡ��߶ȣ�","�ü����ü�Ϊ��״-�߿���״��_������","�ü����ü�Ϊ��״-�߿���ʽ��","�ü����ü�Ϊ��״-�߿���ɫ��","�ü����ü����ͼƬ������Ⱦ���ɣ�_������","���У��㼶��ϵ��_������"};
	public String strAudio[] = {"��Ƶ����","��Ƶ����","��õ�Ƭ���š��ں�̨����","�ߴ�","��ת","����"};
	public String strVideo[] = {"��Ƶ����","��Ƶ����","��Ƶ����","��������","�ߴ�","��ת","����"};
	public String strShape[] = {"��״���ݣ���״�������ݣ�","��״��ʽ��������","��״��ʽ�����Σ�","��״��ʽ��������״��","��״��ʽ����ͷ���ܣ�","��״��ʽ����ʽ��״��","��״��ʽ������ͼ��","��״��ʽ���������ģ�","��״��ʽ����ע��","��״��������ɫ��","��״��������ϸ��","��״������������ʽ��","��״��������ͷ���ܣ�","�ߴ�","��ת","����","��״��䣨ͼƬ��","��״��䣨��ɫ��"};
	public String strTable[] = {"���ṹ����","��Ԫ���ı�����������-�ı�","��Ԫ���ı����������-��ʽ","��Ԫ���ı����������-�ߴ�","��Ԫ���ı����������-λ��"};
	public String strHyperlink[] = {"�Ƿ�����","��Ļ��ʾ�������ͣ����ʾ��","������ת���ݣ����ӵ��ĵ���ĳһҳ��","������ת���ݣ����ӵ��ļ���","������ת���ݣ����ӵ���ҳ��","���ǰ���������ɫ"};
	public String strCartoon[] = {"����Ч��","���붯���ٶ�","���붯������","ǿ��Ч��","�����ٶ�","��������","�˳�Ч��","�˳������ٶ�","�˳���������","�˳������ٶ�","·��"};
	public String strSmartart[] = {"ֱ��תΪͼƬ������Ҫ���α༭","����Ҫ����"};
	public String strPictureTable[] = {"ֱ��תΪͼƬ������Ҫ���α༭","����Ҫ����"};
	public String strFormula[] = {"ֱ��תΪͼƬ������Ҫ���α༭","����Ҫ����"};
	public String strHeaderFooter[] = {"����/ʱ�䡢�õ�Ƭ���"};
	
	public JFrame frame = new JFrame("���������Թ���");
	public JPanel upPanel = new JPanel();
	public JPanel centerPanel = new JPanel();
	public JPanel centerPanelLo = new JPanel();
	public JPanel downPanel = new JPanel();
	public JLabel itemLabel = new JLabel("������Ŀ��");	
	
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
	
	public JLabel fileLabel = new JLabel("ѡ���ļ���");
	public JFileChooser fileChooser = new JFileChooser();
	public JTextField textField = new JTextField(25);
	public JTextField textFieldLo = new JTextField(25);
	public JButton btn = new JButton("���");
	public JButton btnRun = new JButton("����");
	public JButton btnRunLo = new JButton("Lo����ִ��");
	public JButton btnRunLoSave = new JButton("����FODP�ļ���");
	public JLabel resultLable = new JLabel("����鿴��");
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
					if(itemJComboBox.getSelectedItem().equals("�ı�")) {
						if(itemJComboBoxNext.getSelectedItem().equals("����")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textContentRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("����")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textFontRun(fileName);
							resultsOutput(results);							
						}else if(itemJComboBoxNext.getSelectedItem().equals("�ֺ�")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textSizeRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("�Ӵ�")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textBoldRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("��б")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textItalicRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("�»���")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textUnderlineRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("��Ӱ")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textShadowRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("ɾ����")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textStrikeoutRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("�ַ����")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textCharacterSpacingRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("���±�")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textSuperSubScriptRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("�ı�ͻ����ʾ��ɫ")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textHighlightColorRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("�ı���䣨��ɫ��")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textFillColorRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("�ı���䣨ͼƬ��")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textFillImageRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("�ı���䣨���䣩")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textGradualChangeRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("�ı���䣨����")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textGrainRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("�ı���������ɫ��")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textOutlineColorRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("�ı���������ϸ��")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textOutlineThickThinRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("�ı�������������ʽ��")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textOutlineLineStyleRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("����Ч������Ӱ��")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textEffectShadowRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("����Ч����ӳ��")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textEffectReflectionRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("����Ч����ת����")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textRun.textEffectTransformRun(fileName);
							resultsOutput(results);
						}else {
							area.setText("");
							area.append("����");
						}
					}else if(itemJComboBox.getSelectedItem().equals("����")) {
						if(itemJComboBoxNext.getSelectedItem().equals("�оࣨ��ǰ��")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = paragraphRun.paragraphPreSegmentRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("�оࣨ�оࣩ")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = paragraphRun.paragraphRowSpacingRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("�оࣨ�κ�")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = paragraphRun.paragraphPostSegmentRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("���뷽ʽ")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = paragraphRun.paragraphAlignmentRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("�������ı�֮ǰ��")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = paragraphRun.paragraphIndentPreTextRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("�����������ʽ������ֵ��")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = paragraphRun.paragraphSpecialFormatMeasureRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("�ı����򣨴�������")) {
							area.setText("");
							String information = "��鿴ERROR.TXT�ļ���orientation��,��PPTEditor\\temp��";
							area.setText(information);
						}else if(itemJComboBoxNext.getSelectedItem().equals("������")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = paragraphRun.paragraphNumberOfColumnsRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("��Ŀ���ţ�ͼ�꣩")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = paragraphRun.paragraphBulletIconRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("��Ŀ���ű�ţ���С��")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = paragraphRun.paragraphBulletSizeRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("��Ŀ���ű�ţ���ɫ��")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = paragraphRun.paragraphBulletColorRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("��ţ���ʼ��ţ�")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = paragraphRun.paragraphNumberStartPositionRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("�б�ȼ�")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = paragraphRun.paragraphListLevelRun(fileName);
							resultsOutput(results);
						}else {
							area.setText("");
							area.append("����");
						}																														
					}else if(itemJComboBox.getSelectedItem().equals("�ı���")) {
						if(itemJComboBoxNext.getSelectedItem().equals("��ֱ���뷽ʽ")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textBoxRun.textBoxVerticalAlignmentRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("���ַ��򣨴�������")) {
							area.setText("");
							String information = "��鿴ERROR.TXT�ļ�,��PPTEditor\\temp��";
							area.setText(information);
						}else if(itemJComboBoxNext.getSelectedItem().equals("�߾�")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textBoxRun.textBoxPaddingRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("�Զ�����")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textBoxRun.textBoxAutoWrapRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("�ߴ�")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textBoxRun.textBoxSizeRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("��ת")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = textBoxRun.textBoxRotateRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("���ţ������ۣ�")) {
							area.setText("");
							String information = "OFFICE���������ű���ֵ�޸ĺ������ֻᵯ��100%��������ܵ���֤��û̫���Ҫ����Ϊ����ʵ�ʾ��Ǹ����ı���Ĵ�С�����ֵĴ�С�������ű���ֵû��һ��������ȥ�Ƚϡ�";
							area.setText(information);
						}else {
							area.setText("");
							area.append("����");
						}						
					}else if(itemJComboBox.getSelectedItem().equals("ͼƬ")) {
						if(itemJComboBoxNext.getSelectedItem().equals("�ߴ�")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = pictureRun.pictureSizeRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("��ת")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = pictureRun.pictureRotateRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("����")) {
							area.setText("");
							String information = "OFFICE���������ű���ֵ�޸ĺ������ֻᵯ��100%��������ܵ���֤��û̫���Ҫ����Ϊ����ʵ�ʾ��Ǹ����ı���Ĵ�С�����ֵĴ�С�������ű���ֵû��һ��������ȥ�Ƚϡ�";
							area.setText(information);
						}else if(itemJComboBoxNext.getSelectedItem().equals("�ü�����ȡ��߶ȣ�")) {
							area.setText("");
							String information = "ƫ������Ⱦ�Ƕ���֤��������ֻ�ܽ�����ߴ硣";
							area.setText(information);
						}else if(itemJComboBoxNext.getSelectedItem().equals("�ü����ü�Ϊ��״-�߿���״��_������")) {
							area.setText("");
							String information = "��鿴ERROR.TXT�ļ���prictrue_shape��,��PPTEditor\\temp��";
							area.setText(information);
						}else if(itemJComboBoxNext.getSelectedItem().equals("�ü����ü�Ϊ��״-�߿���ʽ��")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = pictureRun.pictureCutShapeBorderStyleRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("�ü����ü�Ϊ��״-�߿���ɫ��")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = pictureRun.pictureCutShapeBorderColorRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("�ü����ü����ͼƬ������Ⱦ���ɣ�_������")) {
							area.setText("");
							String information = "ͼƬ��״�ü�����Ⱦ������,QA:û�в������ݣ���Ҫ����";
							area.setText(information);
						}else if(itemJComboBoxNext.getSelectedItem().equals("���У��㼶��ϵ��_������")) {
							area.setText("");
							String information = "ƫ������Ⱦ�Ƕ���֤���������谴��fodp�ڵ�draw:frame������˳�������û�й̶�������ֵȥ���顣";
							area.setText(information);
						}else {
							area.setText("");
							area.append("����");
						}
					}else if(itemJComboBox.getSelectedItem().equals("��Ƶ")) {
						if(itemJComboBoxNext.getSelectedItem().equals("��Ƶ����")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = audioRun.audioContentRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("��Ƶ����")) {
							area.setText("");
							String information = "�����ĵ��У����������ԣ�������֤�����ǽ��������ݡ���֤�Ƿ������Ƶͬ��Ƶ���ݡ�";
							area.setText(information);
						}else if(itemJComboBoxNext.getSelectedItem().equals("��õ�Ƭ���š��ں�̨����")) {
							area.setText("");
							String information = "����δ����fodp����Ӧ���Կɲ鿴��ͨ��������Ⱦ����֤��";
							area.setText(information);
						}else if(itemJComboBoxNext.getSelectedItem().equals("�ߴ�")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = audioRun.audioSizeRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("��ת")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = audioRun.audioRotateRun(fileName);
							resultsOutput(results);
						}else if(itemJComboBoxNext.getSelectedItem().equals("����")) {
							area.setText("");
							String information = "OFFICE���������ű���ֵ�޸ĺ������ֻᵯ��100%��������ܵ���֤��û̫���Ҫ����Ϊ����ʵ�ʾ��Ǹ�����Ƶ�Ĵ�С�������ű���ֵû��һ��������ȥ�Ƚϡ�";
							area.setText(information);
						}else {
							area.setText("");
							area.append("����");
						}
					}else if(itemJComboBox.getSelectedItem().equals("��Ƶ")) {
						if(itemJComboBoxNext.getSelectedItem().equals("��Ƶ����")) {
							area.setText("");
							String information = "ͬ��Ƶ����";
							area.setText(information);
						}else if(itemJComboBoxNext.getSelectedItem().equals("��Ƶ����")) {
							area.setText("");
							String information = "ƫ������Ⱦ�Ƕ���֤";
							area.setText(information);
						}else if(itemJComboBoxNext.getSelectedItem().equals("��Ƶ����")) {
							area.setText("");
							String information = "ͬ��Ƶ����";
							area.setText(information);
						}else if(itemJComboBoxNext.getSelectedItem().equals("��������")) {
							area.setText("");
							String information = "ͬ��Ƶ��õ�Ƭ���š��ں�̨����";
							area.setText(information);
						}else if(itemJComboBoxNext.getSelectedItem().equals("�ߴ�")) {
							area.setText("");
							String information = "ͬ��Ƶ�ߴ�";
							area.setText(information);
						}else if(itemJComboBoxNext.getSelectedItem().equals("��ת")) {
							area.setText("");
							String information = "ͬ��Ƶ��ת";
							area.setText(information);
						}else if(itemJComboBoxNext.getSelectedItem().equals("����")) {
							area.setText("");
							String information = "ͬ��Ƶ����";
							area.setText(information);
						}else {
							area.setText("");
							area.append("����");
						}
					}else if(itemJComboBox.getSelectedItem().equals("��״")) {
						System.out.println(textField.getText());
					}else if(itemJComboBox.getSelectedItem().equals("���")) {
						
					}else if(itemJComboBox.getSelectedItem().equals("������")) {
						
					}else if(itemJComboBox.getSelectedItem().equals("����")) {
						
					}else if(itemJComboBox.getSelectedItem().equals("Smartart")) {
						
					}else if(itemJComboBox.getSelectedItem().equals("ͼ��")) {
						
					}else if(itemJComboBox.getSelectedItem().equals("��ʽ")) {
						
					}else if(itemJComboBox.getSelectedItem().equals("ҳüҳ��")) {
						if(itemJComboBoxNext.getSelectedItem().equals("����/ʱ�䡢�õ�Ƭ���")) {
							area.setText("");						
							String fileName = textField.getText();
							String results = headerFooterRun.headerFooterDateTimeRun(fileName);
							resultsOutput(results);
						}else {
							area.setText("");
							area.append("����");
						}
					}else {
						area.setText("");
						area.append("����");
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
						area.setText("��ѡ����Ӧ�ļ���������ӦLO·����");
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
	
	//ѡ����Ŀɸѡ�¼�����
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
	
	//���ѡ���ļ�����
	public void actionPerformed(ActionEvent e) {
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);  
		fileChooser.showDialog(new JLabel(), "ѡ��");  
        File file = fileChooser.getSelectedFile(); 
        if(file != null) {
        	textField.setText(file.getAbsoluteFile().toString());  
        }else {
        	area.setText("��ѡ���ļ���");
        }
	}
	
	//area�����ı����������ж����
	public void resultsOutput(String results) {
		if(results != "") {
			area.append(results);
		}else {
			area.append("��������");
		}
	}
	
	//���������
	public static void main(String[] args) throws IOException {
		new Analysis();	
	}
}
