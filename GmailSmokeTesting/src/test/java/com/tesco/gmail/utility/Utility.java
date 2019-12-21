package com.tesco.gmail.utility;

import java.awt.Robot;
import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	public static void screenShots(WebDriver gs,String screenshotname){
		try{
	TakesScreenshot ts=(TakesScreenshot)gs;
	File pic=ts.getScreenshotAs(OutputType.FILE);
	FileHandler.copy(pic, new File("./Screenshots/"+screenshotname+".jpg"));
		}catch(Exception e){
			System.out.println("The Uncaught Exception is=="+e.getMessage());
		}
	}
	public static void wait_Statement(long waitTime){
		try{
			Thread.sleep(waitTime);
		}catch(Exception e){
			System.out.println("The Uncaught Exception is=="+e.getMessage());
		}
	}
	public static void robot_Enter(){
		try{
			Robot r=new Robot();
			r.keyPress(java.awt.event.KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			r.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		}catch(Exception e){
			System.out.println("The Uncaught Exception is=="+e.getMessage());
		}
	}
}
