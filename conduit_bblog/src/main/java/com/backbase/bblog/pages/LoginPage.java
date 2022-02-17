package com.backbase.bblog.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.backbase.bblog.utils.CommonUtils;	
	
public class LoginPage {	

	WebDriver driver;
	
	@FindBy(xpath="//a[text()=' Sign in ']")
	WebElement lnk_signin;

    @FindBy(xpath="//input[@placeholder='Email']")
    WebElement txt_email;

    @FindBy(xpath="//input[@placeholder='Password']")
    WebElement txt_password;    

    @FindBy(xpath="//button[text()=' Sign in ']")
    WebElement btn_signin;  
	
	
    public LoginPage(WebDriver driver){

        this.driver = driver;  
        PageFactory.initElements(driver, this);
    }
    

	public void login(String user_name, String password) throws InterruptedException {

//		CommonUtils.waitfor_Visibility_of_Element(lnk_signin);
		Thread.sleep(3);
		lnk_signin.click();		
		CommonUtils.waitfor_clickable_element(txt_email);
		txt_email.click();		
		txt_email.sendKeys(user_name);
		txt_password.click();
		txt_password.sendKeys(password);		
		btn_signin.click();
		
	}
	
}
