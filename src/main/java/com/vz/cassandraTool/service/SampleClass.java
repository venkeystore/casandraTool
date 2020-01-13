/*package com.vz.cassandraTool.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.vz.cassandraTool.pojo.JobRun;

@Component
public class SampleClass {
	@Autowired
	static Environment env;
	@Autowired
	JobRun jobrun;

	public static void main(String[] args) throws IOException {
		
		 * try (InputStream input = new
		 * FileInputStream("/resources/static/config.properties")) {
		 * 
		 * Properties prop = new Properties();
		 * 
		 * // load a properties file prop.load(input);
		 * 
		 * // get the property value and print it out
		 * System.out.println(prop.getProperty("hostName1"));
		 * System.out.println(prop.getProperty("username1"));
		 * System.out.println(prop.getProperty("password1"));
		 * 
		 * } catch (IOException ex) { ex.printStackTrace(); }
		 * 
		 * try (InputStream input =
		 * SampleClass.class.getClassLoader().getResourceAsStream("config.properties"))
		 * { Properties prop = new Properties(); if (input == null) {
		 * System.out.println("Sorry, unable to find config.properties"); return; }
		 * 
		 * //load a properties file from class path, inside static method
		 * prop.load(input); //get the property value and print it out
		 * System.out.println(prop.getProperty("hostName1"));
		 * System.out.println(prop.getProperty("userName1"));
		 * System.out.println(prop.getProperty("password1"));
		 * 
		 * } catch (IOException ex) { ex.printStackTrace(); }
		 
		System.out.println(System.getProperty("user.dir"));
		Properties config = new Properties();
		InputStream input = SampleClass.class.getClassLoader().getResourceAsStream("config.properties");
		config.load(input);
	//FileInputStream fis = new FileInputStream ("/resources/Config.properties");
	System.out.println(config.getProperty("hostName1"));
	 System.out.println(config.getProperty("userName1"));
	 System.out.println(config.getProperty("password1"));
		
		 * String environment = "T1";
		 * 
		 * System.out.println(env.getProperty(environment + ".userName"));
		 
	}
}
*/