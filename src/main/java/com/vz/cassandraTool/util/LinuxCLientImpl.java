package com.vz.cassandraTool.util;

import java.io.InputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class LinuxCLientImpl  {

	public static void main(String[] agrs) {

		String host = "18.196.25.48";
		String user = "hari";
		String pwd = "hari";
		//String command1 = "echo \"Some text here.\" > file5.txt; cat file5.txt";
		String command2 = "sh init.sh hari@172.31.43.5 EAST T1";
		try {
			java.util.Properties config = new java.util.Properties(); 
	    	config.put("StrictHostKeyChecking", "no");
	    	JSch jsch = new JSch();
	    	Session session=jsch.getSession(user, "3.17.178.117", 22);
	    	session.setPassword(pwd);
	    	session.setConfig(config);
	    	session.connect();
	    	System.out.println("Connected");
	    	
	    	Channel channel=session.openChannel("exec");
	     //   ((ChannelExec)channel).setCommand(command1);
	        ((ChannelExec)channel).setCommand(command2);
	        channel.setInputStream(null);
	        ((ChannelExec)channel).setErrStream(System.err);
	        
	        InputStream in=channel.getInputStream();
	        channel.connect();
	        byte[] tmp=new byte[1024];
	        while(true){
	          while(in.available()>0){
	            int i=in.read(tmp, 0, 1024);
	            if(i<0)break;
	            System.out.print(new String(tmp, 0, i));
	          }
	          if(channel.isClosed()){
	            System.out.println("exit-status: "+channel.getExitStatus());
	            break;
	          }
	          try{
	        	  Thread.sleep(1000);
	        	  }catch(Exception ee){
	        		  
	        	  }
	        }
	        channel.disconnect();
	        session.disconnect();
	        System.out.println("DONE");
	    }catch(Exception e){
	    	e.printStackTrace();
	    }

	}
		
	}


