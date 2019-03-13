package com.maveric.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtilis {

	public static void takeScreenShot(WebDriver driver, String fileName)
	{
		TakesScreenshot ts = (TakesScreenshot) driver; 
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		String date = new Date().toString().replace(":", "-");
				System.out.println(date);
		try {
			FileUtils.copyFile(srcFile, new File("screenshots/"+fileName+" "+date+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
