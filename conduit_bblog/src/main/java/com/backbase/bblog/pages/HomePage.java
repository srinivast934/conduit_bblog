package com.backbase.bblog.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.backbase.bblog.utils.CommonUtils;

import java.util.List;

public class HomePage {
	
	WebDriver driver;     
    
	@FindBy(xpath="//a[text()=' Home ']")
    WebElement lnk_home;
	
    @FindBy(xpath="//a[@routerlink='/editor']")
    WebElement lnk_new_article;
    
    @FindBy(xpath="//a[text()=' Your Feed ']")
    WebElement lnk_yourFeed;
    
    @FindBy(xpath="(//a[text()=' Your Feed ']/descendant::h1)[1]")
    WebElement lbl_new_article;
    
    @FindBy(xpath="//a[text()=' Global Feed ']")
    WebElement lnk_globalFeed;
    
    @FindBy(xpath="//p[text()='Popular Tags']")
    WebElement lbl_popularTags;
    
    @FindBy(xpath="//p[text()='Popular Tags']/following::a")
    List<WebElement> lnk_tags;
    
	@FindBy(xpath="(//a[text()='conduit'])[1]")
	WebElement lnk_title;
	
	@FindBy(xpath="//a[@routerlink='/settings']")
	WebElement lnk_settings;
	
	 @FindBy(xpath="//ul[@class='nav navbar-nav pull-xs-right']/descendant::a[4]")
	 WebElement lnk_profile;

    @FindBy(xpath="//button[text()=' Or click here to logout. ']")
    WebElement btn_logout;
    
    ArticlePage articlePage = new ArticlePage(driver);
	
	
    public HomePage(WebDriver driver){

        this.driver = driver;  
        PageFactory.initElements(driver, this);
    }    
    
    
	public void logout() {
		
		lnk_settings.click();		
		CommonUtils.waitfor_Visibility_of_Element(btn_logout);
		btn_logout.click();		
		driver.quit();
	}
	
	public void click_new_article()
	{
		lnk_new_article.click();		
		CommonUtils.waitfor_Visibility_of_Element(articlePage.txt_title);
	}
	
	public void click_profile()
	{
		lnk_profile.click();
		CommonUtils.waitfor_Visibility_of_Element(articlePage.lnk_myPosts);
	}
	
	   
    public void click_home()
    {
    	lnk_home.click();
    	CommonUtils.waitfor_Visibility_of_Element(lnk_yourFeed);
    			
    }
	  
    public void verify_artilce_in_your_feed(String article)   
    {
    	String recent_post = lbl_new_article.getText();  
    	
    	if(recent_post == article)
    	{
    		System.out.println("Published article displaying in Your Feed");
    	}
    	else
    	{
    		System.out.println("Published article not displaying in Your Feed");
    	}    	
    } 
    
    public void verify_tag_in_popular_tags(String tag)   
    {
    	List<WebElement> tags = lnk_tags;
    	List<String> tag_names = null;
    	for(int i=0;i <= tags.size()-1;i++)
    	{    		
    		tag_names.add(tags.get(i).getText());    		
    	}    	
    	
    	if(tag_names.contains(tag))
    	{
    		System.out.println("Published article displaying in Your Feed");
    	}
    	else
    	{
    		System.out.println("Published article not displaying in Your Feed");
    	}
    } 

}
