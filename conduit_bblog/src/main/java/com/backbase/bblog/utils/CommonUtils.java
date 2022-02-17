package com.backbase.bblog.utils;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import java.util.Random;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonUtils {
	
	public static WebDriver driver = null;
	
//	public static WebDriver openBrowser() throws Exception
//	{
//		try {
//			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "Downloads\\chromedriver.exe");  
//			driver = new ChromeDriver();
//			driver.manage().window().maximize();
//		}
//		catch(Exception e)
//		{
//			System.out.println("Unable to open browser");
//		}
//		return driver;
//	}
//	
//	public static void windowMaximize() throws Exception
//	{
//		try {
//			
//			driver.manage().window().maximize();
//		}
//		catch(Exception e)
//		{
//			System.out.println("Unable to maximize window");
//		}
//		
//	}
	
//	public static void openURL() throws Exception
//	{
//		try {
//				
//			driver.get(Constant.URL);
//		}
//		catch(Exception e)
//		{
//			System.out.println("Unable to open URL");
//		}
//		
//	}
	
	public static void takeScreenshot(WebDriver driver, String sTestCaseName) throws Exception
	{
		try
		{ 
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(Constant.Path_ScreenShot + sTestCaseName +".jpg"));
		}
		catch(Exception e)
		{
			System.out.println("Error occured while capturing screenshot: "+e.getMessage());
		}
	}
	
	public static void waitfor_clickable_element(WebElement element)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 6);	
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		catch(Exception e) 
		{
			
		}
	}
	
	public static void waitfor_Visibility_of_Element(WebElement element)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 6);//			
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch(Exception e) 
		{
			
		}
	}
	
	public static int random_num(int n)
	{
		Random rn = new Random();
		int x = rn.nextInt(n);		
		return x;
	}
	
	public static String random_string(int n)
	{
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();	
	} 
	
	public static void jsClick(WebElement element) throws Exception
	{
		try
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		}
		catch(Exception e)
		{
			System.out.println("Error occured while clicking the element:" +e.getMessage());
		}
	}
	
	public static String readTestData(String property) throws Exception
	{
		String prop = null;
		try
		{
			FileReader reader = new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\Testdata.properties");  
		    Properties p = new Properties();  
		    p.load(reader);  		      
		    prop =  p.getProperty(property);
		   
		}
		catch(Exception e)
		{
			System.out.println("Unable to read property:" +e.getMessage());
		}
		 return prop;
		
	}
}


