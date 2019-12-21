package com.tesco.gmail.objectreader;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ObjectReader {
	Properties pro;
	public ObjectReader() {
		try {
			File file=new File("./ObjectRepository/ObjectRepository.properties");
			FileInputStream fis=new FileInputStream(file);
			pro=new Properties();
			pro.load(fis);
			
		}catch(Exception e) {
			System.out.println("The Uncaught Exception is == "+e.getMessage());
		}
	}
	public String chromePath() {
		return pro.getProperty("chromePath");
	}
	public String loginbutton(){
		return pro.getProperty("loginbutton");
	}
	public String baseURL(){
		return pro.getProperty("baseURL");
	}
	public String email(){
		return pro.getProperty("email");
	}
	public String next(){
		return pro.getProperty("next");
	}
	public String password(){
		return pro.getProperty("password");
	}
	public String loginURL(){
		return pro.getProperty("loginURL");
	}
	public String profilebutton(){
		return pro.getProperty("profilebutton");
	}
	public String logout(){
		return pro.getProperty("logout");
	}
	public String logout1(){
		return pro.getProperty("logout1");
	}
}
