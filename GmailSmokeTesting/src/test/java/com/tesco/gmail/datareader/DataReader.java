package com.tesco.gmail.datareader;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {
	Properties pro;
	public DataReader() {
		try {
			File file=new File("./DataRepository/DataRepository.properties");
			FileInputStream fis=new FileInputStream(file);
			pro=new Properties();
			pro.load(fis);
			
		}catch(Exception e) {
			System.out.println("The Uncaught Exception is == "+e.getMessage());
		}
	}
	public String userName(){
		return pro.getProperty("userName");
	}
	public String userPassword(){
		return pro.getProperty("userPassword");
	}
}
