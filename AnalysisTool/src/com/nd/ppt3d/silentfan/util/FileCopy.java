package com.nd.ppt3d.silentfan.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.filechooser.FileSystemView;

public class FileCopy {
	FileSystemView fsv = FileSystemView.getFileSystemView();
	File deskPath = fsv.getHomeDirectory();    //��ȡ����·���ķ���
	//�����ļ��ķ���
	public void copyFile(String oldPath,String newPath) {
		try {  
            int bytesum = 0;  
            int byteread = 0;  
            File oldfile = new File(oldPath);  
            if (oldfile.exists()) { //�ļ�����ʱ  
                InputStream inStream = new FileInputStream(oldPath); //����ԭ�ļ�  
                FileOutputStream fs = new FileOutputStream(newPath);  
                byte[] buffer = new byte[1444];  
                while ( (byteread = inStream.read(buffer)) != -1) {  
                    bytesum += byteread; //�ֽ��� �ļ���С  
                    fs.write(buffer, 0, byteread);  
                }  
                inStream.close();  
                fs.close();  
            }  
        }  
        catch (Exception e) {  
            System.out.println("���Ƶ����ļ���������");  
            e.printStackTrace();  
        }
	}
	
	//Ѱ�����ɵ�����fodp.debug�ļ�
	public ArrayList findFiles(String baseDirName,String targetFileName) {
		File baseDir = new File(baseDirName);
		if(!baseDir.exists() || !baseDir.isDirectory()) {
			System.out.println("�ļ�����ʧ�ܣ�" + baseDirName + "����һ��Ŀ¼��");
		}
		String tempName = null;
		File tempFile;
		File[] files = baseDir.listFiles();
		ArrayList tempFileName = new ArrayList();
		if(files.length == 0) {
			System.out.println("Ϊ���ļ���");
			return null;
		}
		for(int i = 0;i<files.length;i++) {
			tempFile = files[i];
			tempName = tempFile.getName();
			if(tempName.indexOf(targetFileName) != -1) {
				tempFileName.add(tempFile.getAbsoluteFile().toString());
			}
		}
		return tempFileName;
	}
	
	//��ȡ���ɵ�����fodp.debug�ļ�
	public ArrayList getllFodpDebugName() {
		String temp = System.getProperty("user.name");
		String baseDir = "C:\\Users\\" + temp + "\\AppData\\Local\\Temp";
		String fileName = ".debug";
		FileCopy fileCopy = new FileCopy();
		ArrayList fileFodp = fileCopy.findFiles(baseDir,fileName);
		return fileFodp;
	}
	
	//�ж��Ƿ�����ļ��У��������򴴽���������ɾ�����ٴ���
	public String fileExist(String temp1,String temp2) {
		File file = new File(deskPath.getPath() + "\\" + temp1 + temp2);
		if(!file.exists() && !file.isDirectory()) {
			file.mkdir();
		}else {
			file.delete();
		}
		System.out.println(file.getName());
		return file.getName();
	}
	
	public void fodpCopySave(String temp1,String temp2) {
		System.out.println(deskPath.getPath());
		String newPath;
		String oldPath;
		FileCopy fileCopy = new FileCopy();
		ArrayList temp = fileCopy.getllFodpDebugName();
		String newPathTemp = fileCopy.fileExist(temp1,temp2);  //�����ļ���
		for(int i=0;i<temp.size();i++) {
			oldPath = temp.get(i).toString();
			String arrays[] = oldPath.split("\\\\");
        	for(int j=0;j<arrays.length;j++) {
        		if(arrays[j].indexOf(".debug") != -1) {        			
        			newPath = deskPath.getPath() + "\\" + newPathTemp + "\\" + arrays[j];   
        			fileCopy.copyFile(oldPath, newPath);
        			break;
        		}                    		
        	}	
		}
	}
}
