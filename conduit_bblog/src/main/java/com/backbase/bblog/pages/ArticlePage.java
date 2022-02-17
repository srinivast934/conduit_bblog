package com.backbase.bblog.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.backbase.bblog.utils.CommonUtils;

public class ArticlePage {
	WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='Article Title']")
	WebElement txt_title;

    @FindBy(xpath="//input[@formcontrolname='description']")
    WebElement txt_about;

    @FindBy(xpath="//input[@placeholder='Enter tags']")
    WebElement txt_tags;    

    @FindBy(xpath="//button[text()=' Publish Article ']")
    WebElement btn_publish_article;
    
    @FindBy(xpath="(//a[@class='btn btn-sm btn-outline-secondary'])[1]")
    WebElement lnk_edit_article;
    
    @FindBy(xpath="//button[text()='(//button[@class='btn btn-sm btn-outline-danger'])[1]']")
    WebElement btn_delete_article;      
    
    @FindBy(xpath="//textarea[@placeholder='Write a comment...']")
    WebElement txt_write_comment; 
    
    @FindBy(xpath="//button[text()=' Post Comment ']")
    WebElement btn_post_comment;	
    
    @FindBy(xpath="(//div[@class='article-preview'])[1]/descendant::p")
    WebElement lbl_recent_comment;     
	
    @FindBy(xpath="//a[text()=' My Posts ']")
    WebElement lnk_myPosts;
    
    @FindBy(xpath="//a[text()=' My Posts ']/following::h1[1]")
    WebElement lbl_recent_post;
    
    @FindBy(xpath="//a[text()=' Favorited Posts ']")
    WebElement lnk_favPosts;
    
    @FindBy(xpath="(//button[@class='btn btn-sm btn-outline-primary'])[1]")
    WebElement btn_favourite;      
    
    @FindBy(xpath="//a[text()=' Favorited Posts ']/following::h1[1]")
    WebElement lnk_recent_favourite;   
  
    
    public ArticlePage(WebDriver driver) {

        this.driver = driver;  
        PageFactory.initElements(driver, this);
    }
 
    
    public List<String> publish_article()
    {
    	List<String> article_values = null;
    	String title = CommonUtils.random_string(10);
    	txt_title.sendKeys(title);
    	article_values.add(title);    	
    	txt_about.sendKeys(CommonUtils.random_string(20));
    	String tag = CommonUtils.random_string(5);
    	txt_tags.sendKeys(tag); 
    	article_values.add(tag);
    	btn_publish_article.click();
    	return article_values;
    }
    
    public void edit_article() {
    	lnk_edit_article.click();
    	CommonUtils.waitfor_Visibility_of_Element(txt_title);
    	txt_about.clear();
    	txt_about.sendKeys(CommonUtils.random_string(20)); 
    	btn_publish_article.click();
    }
    
    public void click_delete_article() {
    	btn_delete_article.click();    	
    }
    
    public void verify_artilce_in_my_posts(String article)
    {
    	String recent_post = lbl_recent_post.getText();
    	
    	if(article == recent_post)
    	{
    		System.out.println("Published article displaying in my posts");
    	}
    	else
    	{
    		System.out.println("Published article not displaying in myposts");
    	}
    }    
    
    
    public String post_comment()
    {
    	String comment = CommonUtils.random_string(20);
    	txt_write_comment.sendKeys(comment);
    	return comment;
    }
    
   
    
    public void verify_comment_in_my_posts(String comment)
    {
    	String recent_comment = lbl_recent_comment.getText();
    	
    	if(comment == recent_comment)
    	{
    		System.out.println("Comment is displaying correctly");
    	}
    	else
    	{
    		System.out.println("Comment is not displaying correctly");
    	}
    }
    	
    public void click_favourite_button()
    {
    	 btn_favourite.click();
    } 
    
    public void verify_favourite_in_favourited_posts(String article)
    {
    	lnk_favPosts.click();
    	String favPost = lnk_recent_favourite.getText();
    	if(article==favPost)
    	{
    		System.out.println("Favourite article displaying under favourite posts");
    	}
    	else
    	{
    		System.out.println("Favourite article not displaying under favourite posts");
    	}
    }
    
     
}
