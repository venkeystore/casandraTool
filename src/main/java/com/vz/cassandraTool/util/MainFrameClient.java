package com.vz.cassandraTool.util;

import java.io.FileInputStream;

import org.apache.commons.net.ftp.FTPClient;

public class MainFrameClient {
	public static void main(String[] args) {
		String serverName = "my.zos.mainframe";
		int port = 9009;
		String userName = "userId";
		String password = "******";
		FTPClient ftp = new FTPClient();
		try {
			// here we are connecting to mainframe by using connect method of FTPclient
			ftp.connect(serverName, port);
			String replyString = ftp.getReplyString();
			System.out.println(replyString);

			// here we are trying to login by passing userName and password
			ftp.login(userName, password);
			String loginStatus = ftp.getReplyString();
			System.out.println(loginStatus);

			// here in job file consists of mainframe script
			FileInputStream inputStream = new FileInputStream("D:\\job.txt");
			ftp.sendCommand("here we can pass our mainframe commands");
			ftp.storeFile(serverName, inputStream);
			String replyText = ftp.getReplyString();
			System.out.println(replyText);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
