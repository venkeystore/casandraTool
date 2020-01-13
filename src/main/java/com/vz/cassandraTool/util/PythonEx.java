package com.vz.cassandraTool.util;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;

import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

public class PythonEx {
	public static void main(String... args) throws IOException, ScriptException {
		//Process p = Runtime.getRuntime().exec("python yourapp.py");
		
		
		/*try(PythonInterpreter pyInterp = new PythonInterpreter()) {
		      pyInterp.exec("print('Hello Python World!')");
		    }*/
		
		
		PythonInterpreter python = new PythonInterpreter();
		 
		int number1 = 10;
		int number2 = 32;
		 
		python.set("number1", new PyInteger(number1));
		python.set("number2", new PyInteger(number2));
		python.exec("number3 = number1+number2");
		PyObject number3 = python.get("number3");
		System.out.println("val : "+number3.toString());

	/*
		StringWriter writer = new StringWriter(); //ouput will be stored here

	    ScriptEngineManager manager = new ScriptEngineManager();
	    ScriptContext context = new SimpleScriptContext();

	    context.setWriter(writer); //configures output redirection
	    ScriptEngine engine = manager.getEngineByName("python");
	    engine.eval(new FileReader("D:\\python\\ML\\numbers.py"), context);
	    System.out.println(writer.toString()); */
	}

}
