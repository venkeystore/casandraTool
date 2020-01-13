package com.vz.cassandraTool.util;

import java.io.IOException;
import java.io.InputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class ConnectLinux {

	public static void main(String[] args) throws IOException, InterruptedException {
		String host = "3.14.252.116" ; //3.133.159.208    18.188.76.65    
		String user = "hari";
		String pwd = "hari";
		String command1 = "echo \"Some text here.\" > file5.txt; cat file5.txt";
		String command2 = "ls -ltr";
		try {
			java.util.Properties config = new java.util.Properties(); 
	    	config.put("StrictHostKeyChecking", "no");
	    	JSch jsch = new JSch();
	    	Session session=jsch.getSession(user, host, 22);
	    	session.setPassword(pwd);
	    	session.setConfig(config);
	    	session.connect();
	    	System.out.println("Connected");
	    	
	    	Channel channelExec=session.openChannel("exec");
	        ((ChannelExec)channelExec).setCommand(command1);
	        ((ChannelExec)channelExec).setCommand(command2);
	        channelExec.setInputStream(null);
	        ((ChannelExec)channelExec).setErrStream(System.err);
	    	
	        InputStream ins=channelExec.getInputStream();
	        channelExec.connect();
	        byte[] tmp=new byte[1024];
	        while(true){
	          while(ins.available()>0){
	            int i=ins.read(tmp, 0, 1024);
	            if(i<0)break;
	            System.out.print(new String(tmp, 0, i));
	          }
	          if(channelExec.isClosed()){
	            System.out.println("exit-status: "+channelExec.getExitStatus());
	            break;
	          }
	          try{
	        	  Thread.sleep(1000);
	        	  }catch(Exception ee){
	        		  
	        	  }
	        }
	        channelExec.disconnect();
	        session.disconnect();
	        System.out.println("DONE");
	    }catch(Exception e){
	    	e.printStackTrace();
	    }

	}
}
