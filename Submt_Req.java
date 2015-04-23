package Linde_Pack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Submt_Req {
	
	 String text;
	WebDriver driver = new FirefoxDriver ();
	WebDriver driver1 = new FirefoxDriver ();
  @Test  
  public  void submitreq() throws IOException 
  {
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://10.10.10.181/RSP/ACE.nsf/Home.xsp");
	  driver.findElement(By.partialLinkText("Home")).click();
	  driver.findElement(By.partialLinkText("New Service Request")).click();
	  Select functionalarea = new Select (driver.findElement(By.id("view:_id1:_id2:txt_ServiceCat")));
	  functionalarea.selectByVisibleText("Procurement");
	  Select Category = new Select (driver.findElement(By.id("view:_id1:_id2:txt_ServiceType")));
	  Category.selectByVisibleText("ExpDeli");
	  Select Request = new Select (driver.findElement(By.id("view:_id1:_id2:txt_RequestType")));
	  Request.selectByVisibleText("Delivery");
	  WebDriverWait Wait = new WebDriverWait (driver,40);
	  Wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("view:_id1:_id9:callback1:_id236:txt_ACEDocScreenShot"))));
	  driver.findElement(By.id("view:_id1:_id9:callback1:txt_VendorName")).sendKeys("Test");
	  driver.findElement(By.id("view:_id1:_id9:callback1:txt_PONumber")).sendKeys("Test");
	  driver.findElement(By.id("view:_id1:_id9:callback1:txt_DeliveryDate")).sendKeys("12/03/2015");
	  driver.findElement(By.id("view:_id1:_id9:callback1:_id236:txt_ACEDocScreenShot")).sendKeys("C:\\Users\\satheesh_v\\Desktop\\Test_Document.odt");
	 
	  WebDriverWait Wait1 = new WebDriverWait (driver,50);
	  Wait1.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("view:_id1:_id9:callback1:_id236:button3"))));
	  driver.findElement(By.id("view:_id1:_id9:callback1:button4")).click();
	  Wait1.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("view:_id1:_id2:callback1:button1"))));
	  driver.navigate().back();	 
	  driver.get(driver.getCurrentUrl());	
  	  WebElement ele = driver.findElement(By.id("view:_id1:_id9:callback1:_id172:txt_ReqRefNumber"));
  	  String text = ele.getAttribute("value");
  	  System.out.println(text);
  	  
  	  System.out.println("Running Approval Level");
  	  driver1.get("http://10.10.10.181/RSP/ACE.nsf/Home.xsp");
  	  driver1.findElement(By.partialLinkText("My Tasks")).click();
  	 // driver1.findElement(By.partialLinkText(text)).click();
  	  WebElement ele1 =  	driver1.findElement(By.partialLinkText(text));
  	  String id = ele1.getTagName();
  	  System.out.println(id);  	  
  	  //driver1.findElement(By.partialLinkText(text)).click();
  	  }
}
  

  

