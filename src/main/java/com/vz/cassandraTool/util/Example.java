package com.vz.cassandraTool.util;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;

public class Example {
	public static void main(String[] args) {
		String serverName = "my.zos.mainframe";
		String userName = "userId";
		String password = "******";
		FTPClient ftp = new FTPClient();
		try {
			
			ftp.connect(serverName);
			String replyString = ftp.getReplyString();
			System.out.println(replyString);
		} catch (Exception e) {
			e.printStackTrace();

		}
		try {
			ftp.login(userName, password);
			String replyString = ftp.getReplyString();
			System.out.println(replyString);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ftp.site("filetype=jes");
			String replyText = ftp.getReplyString();
			System.out.println(replyText);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			FileInputStream inputStream = new FileInputStream("D:\\job.txt");
			int sendCommand = ftp.sendCommand("");
			ftp.storeFile(serverName, inputStream);
			String replyText = ftp.getReplyString();
			System.out.println(replyText);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
