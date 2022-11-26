package project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases {
	
	 WebDriver driver=null;
	 Actions actions=null;
	 
	@BeforeMethod
	public void setUP() {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	driver= new ChromeDriver();
	
	driver.get("https://www.qa.jbktest.com/online-exam#Testing");  //for opening the url
	
	driver.manage().window().maximize(); //for maximizing the page
	  
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  // if we put below x path wrong then it will wait for the given time and then show error on the console and if we put correct x path then it will not wait
	actions= new Actions(driver);  //action class
		
}
	
//Pass
@Test
	public void checkLoginFunctionality() {
		
		    driver.findElement(By.xpath("//p[text()='Manual Testing(ISTQB)']")).click();
		    String val =  driver.findElement(By.name("count")).getAttribute("value"); //selecting the no. of que
	 	    System.out.println(val);
			driver.findElement(By.id("countbtn")).click(); 
			driver.findElement(By.id("signin-tab")).click();
			driver.findElement(By.id("loginmobile")).sendKeys("7414983630");
			//driver.findElement(By.id("loginbtn")).click();
			
			String expres="Enter your Mobile Number";
			String actres=driver.findElement(By.xpath("//*[@id=\"quizlogin\"]/div[1]/div[1]/label")).getText();
			Assert.assertEquals(actres, expres);

	}
@Test
  public void checkSignUpFunctionality() {
		
		  driver.findElement(By.xpath("//p[text()='Manual Testing(ISTQB)']")).click();  //for clicking the test
		  
		  driver.findElement(By.id("countbtn")).click();  // for clicking on the next button
		  
		  driver.findElement(By.id("signup-tab")).click(); //for clicking on the sign up button
		  
		  driver.findElement(By.id("name")).sendKeys("Pooja"); // for entering the name in the text box
		  
		  driver.findElement(By.id("emailid")).sendKeys("poojatayde7414@gmail.com"); //for entering the email id in the text box
		
		  driver.findElement(By.id("mobile")).sendKeys("7414983630"); //for entering the mobile number in the text box
		  
		  actions.sendKeys(Keys.TAB).perform();
		  driver.findElement(By.id("agree")).click();  //for clicking on the check box
		  
		  driver.findElement(By.id("emailbtn")).click();  //for clicking on the proceed button
		  
		  String expres="Please fill this form carefully.You will be receiving OTP on email and sms.";
		  String actres=driver.findElement(By.xpath("//*[@id=\"quizcontent\"]")).getText();
		  Assert.assertEquals(actres, expres);
		  

	}
 
@Test
  public void checkExamFunctionality() {
		
		driver.findElement(By.xpath("//p[text()='Manual Testing(ISTQB)']")).click();  
		String val =  driver.findElement(By.name("count")).getAttribute("value"); 
		System.out.println(val);
		driver.findElement(By.id("countbtn")).click();  
		driver.findElement(By.id("loginmobile")).sendKeys("7414983630");  
		driver.findElement(By.id("loginbtn")).click(); 

		int num=Integer.parseInt(val);
		for(int i=1;i<=num-1;i++)
		{
			WebElement n=driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div/div[5]/div[2]/a[1]"));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();",n);  
		}
		WebElement n=  driver.findElement(By.id("qsubmit")); 
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",n);
		driver.findElement(By.xpath("//*[@id=\"quizresult\"]/div[2]")).click();  


		String expres="Your Result";
		String actres=driver.findElement(By.xpath("//*[text()='Your Result']")).getText();
		Assert.assertEquals(actres, expres);

}
 
@Test
  public void checkLogOutFunctionality() {
	  
		  driver.findElement(By.xpath("//p[text()='Manual Testing(ISTQB)']")).click();  //for clicking the test
		  String val =  driver.findElement(By.name("count")).getAttribute("value"); //selecting the no. of que
		  System.out.println(val);
		  driver.findElement(By.id("countbtn")).click();  // for clicking on the next button
		  driver.findElement(By.id("loginmobile")).sendKeys("7414983630");  //for entering the mobile number
			  
		  driver.findElement(By.id("loginbtn")).click(); // for clicking on login button

		  driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div/div[1]/a[2]")).click();  // for logout
		  
		  String expres="Logout";
		  String actres=driver.findElement(By.xpath("//*[@id=\"myaccount\"]/a[2]")).getText();
		  		
		  Assert.assertEquals(actres,expres);

 }
 
//Pass
@Test
  public void checkUpdateFunctionality() {
	 

		driver.findElement(By.xpath("//p[text()='Manual Testing(ISTQB)']")).click();  //for clicking the test

		String val =  driver.findElement(By.name("count")).getAttribute("value"); //selecting the no. of que
		System.out.println(val);
		driver.findElement(By.id("countbtn")).click();  // for clicking on the next button
		driver.findElement(By.id("loginmobile")).sendKeys("7414983630");  //for entering the mobile number
		driver.findElement(By.id("loginbtn")).click(); // for clicking on login button
		driver.findElement(By.xpath("//*[@id=\"myaccount\"]/a[1]")).click(); //for clicking on my account
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div[2]/div[6]/div/div/div/div[1]/div/a")).click();   //for clicking on the profile
		driver.findElement(By.id("updatebtn")).click();  //for clicking on the update  

		String expres="Profile successfully updated";
		String actres= driver.findElement(By.xpath("//*[text()='Profile successfully updated']")).getText();
		Assert.assertEquals(expres,actres);

}
 
//Pass
@Test
  public void checkTestAttemptFunctionality() {
	  
			driver.findElement(By.xpath("//p[text()='Manual Testing(ISTQB)']")).click();  
			String val =  driver.findElement(By.name("count")).getAttribute("value"); 
			System.out.println(val);
			driver.findElement(By.id("countbtn")).click();  
			driver.findElement(By.id("loginmobile")).sendKeys("7414983630");  
			driver.findElement(By.id("loginbtn")).click(); 
			driver.findElement(By.xpath("//*[@id=\"myaccount\"]/a[1]")).click();

			driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div/div[1]/div/a")).click();  //for clicking on the View Details in the Test Attempts

			String expres="Test Attempted";
			String actres=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/h4")).getText();
			Assert.assertEquals(actres, expres);
}
	    
//Pass
@Test
	public void checkTestFailedFunctionality() {
	  
		driver.findElement(By.xpath("//p[text()='Manual Testing(ISTQB)']")).click();  
		String val =  driver.findElement(By.name("count")).getAttribute("value"); 
		System.out.println(val);
		driver.findElement(By.id("countbtn")).click();  
		driver.findElement(By.id("loginmobile")).sendKeys("7414983630");  
		driver.findElement(By.id("loginbtn")).click(); 
		driver.findElement(By.xpath("//*[@id=\"myaccount\"]/a[1]")).click();

		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div[2]/div[3]/div/div/div/div[1]/div/a")).click();  //for viewing the failed attempt

		String expres="Failed Attempt";
		String actres=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/h4")).getText();
		Assert.assertEquals(actres,expres);

}

//Pass
@Test
  public void checkGoodScoreFunctionality() {
	
	   driver.findElement(By.xpath("//p[text()='Manual Testing(ISTQB)']")).click();  
	   String val =  driver.findElement(By.name("count")).getAttribute("value"); 
	   System.out.println(val);
		
	   driver.findElement(By.id("countbtn")).click();  
	
       driver.findElement(By.id("loginmobile")).sendKeys("7414983630");  
		  
       driver.findElement(By.id("loginbtn")).click(); 
		  
       driver.findElement(By.xpath("//*[@id=\"myaccount\"]/a[1]")).click(); 
    
       driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div[2]/div[2]/div/div/div/div[1]/div/a")).click();  //for viewing the good score
    
       String ExpectedResult="Good Score";
       String ActualRsult= driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/h4")).getText();
       Assert.assertEquals(ActualRsult,ExpectedResult);
}

//Pass
@Test
public void checkTimeLineFunctionality() {

	driver.findElement(By.xpath("//p[text()='Manual Testing(ISTQB)']")).click();  //for clicking the test
	  
	String val =  driver.findElement(By.name("count")).getAttribute("value"); //selecting the no. of que
    System.out.println(val);
		
	driver.findElement(By.id("countbtn")).click();  // for clicking on the next button
	
    driver.findElement(By.id("loginmobile")).sendKeys("7414983630");  //for entering the mobile number
		  
    driver.findElement(By.id("loginbtn")).click(); // for clicking on login button
		  
    driver.findElement(By.xpath("//*[@id=\"myaccount\"]/a[1]")).click(); //for clicking on my account
    
    driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div[2]/div[4]/div/div/div/div[1]/div/a")).click();  //for viewing the timeline
    
    String Expected="";
    String Actual=driver.findElement(By.xpath("//*[@id=\"chartContainer\"]/div/canvas[2]")).getText();
    Assert.assertEquals(Actual, Expected);
}

//Pass
@Test
public void checkTestTopicCoveredFunctionality() {
	
	driver.findElement(By.xpath("//p[text()='Manual Testing(ISTQB)']")).click();  
	String val =  driver.findElement(By.name("count")).getAttribute("value"); 
	System.out.println(val);
	driver.findElement(By.id("countbtn")).click();  
	driver.findElement(By.id("loginmobile")).sendKeys("7414983630");  
	driver.findElement(By.id("loginbtn")).click(); 
	driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div/div[1]/a[2]")).click();  // for logout

	String expres="Our Test Topics";
	String actres=driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/div/h1")).getText();

	Assert.assertEquals(expres,expres);

}

@Test
public void checkExamHeadingFunctionality() {
		
		driver.findElement(By.xpath("//p[text()='Manual Testing(ISTQB)']")).click();  //for clicking the test
		  
		String val =  driver.findElement(By.name("count")).getAttribute("value"); //selecting the no. of que
		System.out.println(val);
		driver.findElement(By.id("countbtn")).click();  // for clicking on the next button
		  
		driver.findElement(By.id("loginmobile")).sendKeys("7414983630");  //for entering the mobile number
		  
		driver.findElement(By.id("loginbtn")).click(); // for clicking on login button

        String expres="Manual Testing(ISTQB) Quiz";
        String actres=driver.findElement(By.xpath("//*[@id=\"quizheading\"]")).getText();
        Assert.assertEquals(actres, expres);

}

//Pass
@Test
public void checkMyAccountPageHeadingFunctionality() {
	
	  driver.findElement(By.xpath("//p[text()='Manual Testing(ISTQB)']")).click();  //for clicking the test
	  String val =  driver.findElement(By.name("count")).getAttribute("value"); //selecting the no. of que
	  System.out.println(val);
		
	  driver.findElement(By.id("countbtn")).click();  // for clicking on the next button
	
      driver.findElement(By.id("loginmobile")).sendKeys("7414983630");  //for entering the mobile number
		  
      driver.findElement(By.id("loginbtn")).click(); // for clicking on login button
		  
      driver.findElement(By.xpath("//*[@id=\"myaccount\"]/a[1]")).click();

      String expres="Dashboard";
      String actres=driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div[1]/h4")).getText();
      Assert.assertEquals(actres, expres);
}
//Pass
@Test
public void checkMyAccountPageWelcomePoojaFunctionality(){
	
	  driver.findElement(By.xpath("//p[text()='Manual Testing(ISTQB)']")).click();  //for clicking the test
	  String val =  driver.findElement(By.name("count")).getAttribute("value"); //selecting the no. of que
	  System.out.println(val);
		
	  driver.findElement(By.id("countbtn")).click();  // for clicking on the next button
	
      driver.findElement(By.id("loginmobile")).sendKeys("7414983630");  //for entering the mobile number
		  
      driver.findElement(By.id("loginbtn")).click(); // for clicking on login button
		  
      driver.findElement(By.xpath("//*[@id=\"myaccount\"]/a[1]")).click();
      
      String expres="Welcome Pooja,";
      String actres=driver.findElement(By.xpath("/html/body/div/div/div[1]/div/span[1]")).getText();
      Assert.assertEquals(actres,expres);
      
}
//Pass
@Test
public void checkMyAccountPageCorrectGmailFunctionality() {
	
	  driver.findElement(By.xpath("//p[text()='Manual Testing(ISTQB)']")).click();  //for clicking the test
	  String val =  driver.findElement(By.name("count")).getAttribute("value"); //selecting the no. of que
	  System.out.println(val);
		
	  driver.findElement(By.id("countbtn")).click();  // for clicking on the next button
	
      driver.findElement(By.id("loginmobile")).sendKeys("7414983630");  //for entering the mobile number
		  
      driver.findElement(By.id("loginbtn")).click(); // for clicking on login button
		  
      driver.findElement(By.xpath("//*[@id=\"myaccount\"]/a[1]")).click();
    
      String expres="poojatayde7414@gmail.com";
      String actres=driver.findElement(By.xpath("/html/body/div/div/div[1]/div/span[2]")).getText();
      Assert.assertEquals(actres, expres);
	
}

//Pass
@Test
public void checkMyProfileHeadingFunctionality() {
	
	  driver.findElement(By.xpath("//p[text()='Manual Testing(ISTQB)']")).click();  //for clicking the test
	  String val =  driver.findElement(By.name("count")).getAttribute("value"); //selecting the no. of que
	  System.out.println(val);
		
	  driver.findElement(By.id("countbtn")).click();  // for clicking on the next button
	
      driver.findElement(By.id("loginmobile")).sendKeys("7414983630");  //for entering the mobile number
		  
      driver.findElement(By.id("loginbtn")).click(); // for clicking on login button
		  
      driver.findElement(By.xpath("//*[@id=\"myaccount\"]/a[1]")).click();
      
      driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div[2]/div[6]/div/div/div/div[1]/div/a")).click();   //for clicking on the profile
      
      String expres="My Profile";
      String actres=driver.findElement(By.id("quizheading")).getText();
      Assert.assertEquals(actres, expres);
}

@Test
public void checkDownloadYourCertificateLinkFunctionality() {
	
	driver.findElement(By.xpath("//p[text()='Manual Testing(ISTQB)']")).click();  
	String val =  driver.findElement(By.name("count")).getAttribute("value"); 
	System.out.println(val);
	driver.findElement(By.id("countbtn")).click();  
	driver.findElement(By.id("loginmobile")).sendKeys("7414983630");  
	driver.findElement(By.id("loginbtn")).click(); 

	int num=Integer.parseInt(val);
	for(int i=1;i<=num-1;i++)
	{
		WebElement n=driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div/div[5]/div[2]/a[1]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",n);  
	}
	WebElement n=  driver.findElement(By.id("qsubmit")); 
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();",n);
	driver.findElement(By.xpath("//*[@id=\"quizresult\"]/div[2]")).click(); 
	
	String expres="Download Your Certificate";
	String actres=driver.findElement(By.xpath("//*[@id=\"msg\"]/p[2]/a")).getTagName();
	Assert.assertEquals(actres, expres);
      
}

@Test
public void checkViewAnswerButtonFunctionality() {
	
	driver.findElement(By.xpath("//p[text()='Manual Testing(ISTQB)']")).click();  
	String val =  driver.findElement(By.name("count")).getAttribute("value"); 
	System.out.println(val);
	driver.findElement(By.id("countbtn")).click();  
	driver.findElement(By.id("loginmobile")).sendKeys("7414983630");  
	driver.findElement(By.id("loginbtn")).click(); 

	int num=Integer.parseInt(val);
	for(int i=1;i<=num-1;i++)
	{
		WebElement n=driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div/div[5]/div[2]/a[1]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",n);  
	}
	WebElement n=  driver.findElement(By.id("qsubmit")); 
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();",n);
	driver.findElement(By.xpath("//*[@id=\"quizresult\"]/div[2]")).click();
	
	String expres="View Answer";
	String actres=driver.findElement(By.xpath("//*[@id=\"quizresult\"]/div[2]")).getText();
	Assert.assertEquals(actres, expres);
	
}
@Test
public void checkMyAccountPageImageFunctionality() {
	
	  driver.findElement(By.xpath("//p[text()='Manual Testing(ISTQB)']")).click();  //for clicking the test
	  String val =  driver.findElement(By.name("count")).getAttribute("value"); //selecting the no. of que
	  System.out.println(val);
		
	  driver.findElement(By.id("countbtn")).click();  // for clicking on the next button
	
      driver.findElement(By.id("loginmobile")).sendKeys("7414983630");  //for entering the mobile number
		  
      driver.findElement(By.id("loginbtn")).click(); // for clicking on login button
		  
      driver.findElement(By.xpath("//*[@id=\"myaccount\"]/a[1]")).click();
      
      String expres="rounded-circleprofile-img";
      String actres=driver.findElement(By.xpath("/html/body/div/div/div[1]/div/img")).getAttribute("img");
      Assert.assertEquals(actres,expres);
}

@Test
public void checkYourResultAverageFunctionality() {
	
	driver.findElement(By.xpath("//p[text()='Manual Testing(ISTQB)']")).click();  
	String val =  driver.findElement(By.name("count")).getAttribute("value"); 
	System.out.println(val);
	driver.findElement(By.id("countbtn")).click();  
	driver.findElement(By.id("loginmobile")).sendKeys("7414983630");  
	driver.findElement(By.id("loginbtn")).click(); 

	int num=Integer.parseInt(val);
	for(int i=1;i<=num-1;i++)
	{
		WebElement n=driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div/div[5]/div[2]/a[1]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",n);  
	}
	WebElement n=  driver.findElement(By.id("qsubmit")); 
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();",n);
	driver.findElement(By.xpath("//*[@id=\"quizresult\"]/div[2]")).click(); 
	
	String expres="Average!!!";
	String actres=driver.findElement(By.xpath("//*[@id=\"msg\"]/h3")).getText();
	Assert.assertEquals(actres,expres);
	
	

}

@Test
public void checkYourResultSorryFunctionality() {
	
	driver.findElement(By.xpath("//p[text()='Manual Testing(ISTQB)']")).click();  
	String val =  driver.findElement(By.name("count")).getAttribute("value"); 
	System.out.println(val);
	driver.findElement(By.id("countbtn")).click();  
	driver.findElement(By.id("loginmobile")).sendKeys("7414983630");  
	driver.findElement(By.id("loginbtn")).click(); 

	int num=Integer.parseInt(val);
	for(int i=1;i<=num-1;i++)
	{
		WebElement n=driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div/div[5]/div[2]/a[1]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",n);  
	}
	WebElement n=  driver.findElement(By.id("qsubmit")); 
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();",n);
	driver.findElement(By.xpath("//*[@id=\"quizresult\"]/div[2]")).click(); 
	
	String expres="Sorry!!!";
	String actres=driver.findElement(By.xpath("//*[@id=\"msg\"]/h3")).getText();
	Assert.assertEquals(actres,expres);
	
}

@Test
public void checkYourResultShareOnFunctionality() {
	
	
	driver.findElement(By.xpath("//p[text()='Manual Testing(ISTQB)']")).click();  
	String val =  driver.findElement(By.name("count")).getAttribute("value"); 
	System.out.println(val);
	driver.findElement(By.id("countbtn")).click();  
	driver.findElement(By.id("loginmobile")).sendKeys("7414983630");  
	driver.findElement(By.id("loginbtn")).click(); 

	int num=Integer.parseInt(val);
	for(int i=1;i<=num-1;i++)
	{
		WebElement n=driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div/div[5]/div[2]/a[1]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",n);  
	}
	WebElement n=  driver.findElement(By.id("qsubmit")); 
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();",n);
	driver.findElement(By.xpath("//*[@id=\"quizresult\"]/div[2]")).click();
	
	
	String expres="Share on";
	String actres=driver.findElement(By.id("social-media")).getText();
	Assert.assertEquals(actres,expres);
	
}

//Pass
@Test
public void checkMyAccountPerformanceReportFunctionality() {
	
	  driver.findElement(By.xpath("//p[text()='Manual Testing(ISTQB)']")).click();  //for clicking the test
	  String val =  driver.findElement(By.name("count")).getAttribute("value"); //selecting the no. of que
	  System.out.println(val);
		
	  driver.findElement(By.id("countbtn")).click();  // for clicking on the next button
	
      driver.findElement(By.id("loginmobile")).sendKeys("7414983630");  //for entering the mobile number
		  
      driver.findElement(By.id("loginbtn")).click(); // for clicking on login button
		  
      driver.findElement(By.xpath("//*[@id=\"myaccount\"]/a[1]")).click();
      
     String expres="Performance Report";
     String actres=driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/h4")).getText();
     Assert.assertEquals(actres, expres);
    
	
}

//Pass
@Test
public void checkTestAttemptedPercentageFunctionality() {
	
	driver.findElement(By.xpath("//p[text()='Manual Testing(ISTQB)']")).click();  
	String val =  driver.findElement(By.name("count")).getAttribute("value"); 
	System.out.println(val);
	driver.findElement(By.id("countbtn")).click();  
	driver.findElement(By.id("loginmobile")).sendKeys("7414983630");  
	driver.findElement(By.id("loginbtn")).click(); 
	driver.findElement(By.xpath("//*[@id=\"myaccount\"]/a[1]")).click();

	driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div/div[1]/div/a")).click();  //for clicking on the View Details in the Test Attempts

	String expres="Percentage";
	String actres=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/table/thead/tr/th[5]")).getText();
	Assert.assertEquals(actres, expres);
}

//Pass
@Test
public void checkTestAttemptedScoreFunctionality() {
	
	driver.findElement(By.xpath("//p[text()='Manual Testing(ISTQB)']")).click();  
	String val =  driver.findElement(By.name("count")).getAttribute("value"); 
	System.out.println(val);
	driver.findElement(By.id("countbtn")).click();  
	driver.findElement(By.id("loginmobile")).sendKeys("7414983630");  
	driver.findElement(By.id("loginbtn")).click(); 
	driver.findElement(By.xpath("//*[@id=\"myaccount\"]/a[1]")).click();

	driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div/div[1]/div/a")).click();  //for clicking on the View Details in the Test Attempts

	String expres="Score";
	String actres=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/table/thead/tr/th[3]")).getText();
	Assert.assertEquals(actres, expres);
	
}

//Pass
@Test
public void checkTestAttemptedActionFunctionality() {
	
	driver.findElement(By.xpath("//p[text()='Manual Testing(ISTQB)']")).click();  
	String val =  driver.findElement(By.name("count")).getAttribute("value"); 
	System.out.println(val);
	driver.findElement(By.id("countbtn")).click();  
	driver.findElement(By.id("loginmobile")).sendKeys("7414983630");  
	driver.findElement(By.id("loginbtn")).click(); 
	driver.findElement(By.xpath("//*[@id=\"myaccount\"]/a[1]")).click();

	driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div/div[1]/div/a")).click();  //for clicking on the View Details in the Test Attempts

	String expres="Action";
	String actres=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/table/thead/tr/th[6]")).getText();
	Assert.assertEquals(actres, expres);
	
}

//Pass
@Test
public void checkTestAttemptedDateFunctionality() {
	
	driver.findElement(By.xpath("//p[text()='Manual Testing(ISTQB)']")).click();  
	String val =  driver.findElement(By.name("count")).getAttribute("value"); 
	System.out.println(val);
	driver.findElement(By.id("countbtn")).click();  
	driver.findElement(By.id("loginmobile")).sendKeys("7414983630");  
	driver.findElement(By.id("loginbtn")).click(); 
	driver.findElement(By.xpath("//*[@id=\"myaccount\"]/a[1]")).click();

	driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div/div[1]/div/a")).click();  //for clicking on the View Details in the Test Attempts

	String expres="Date";
	String actres=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/table/thead/tr/th[1]")).getText();
	Assert.assertEquals(actres,expres);
}
//Pass
@Test
public void checkHomePageTestingTopicHeadingFunctionality() {
	
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	driver= new ChromeDriver();
	
	driver.get("https://www.qa.jbktest.com/online-exam#Testing");  //for opening the url
	
	String expres="Testing";
	String actres=driver.findElement(By.xpath("//*[@id=\"Testing\"]/h3")).getText();
	Assert.assertEquals(actres, expres);
}

@Test
public void checkTakeAQuizPopUpHeadingFunctionality() {
	
	 driver.findElement(By.xpath("//p[text()='Manual Testing(ISTQB)']")).click();
	 
	 String expres="Take a Quiz";
	 String actres=driver.findElement(By.id("quizheading")).getText();
	 Assert.assertEquals(actres,expres);
	 
}

@Test
public void checkPopUpQuestionFuntionality() {
	
	 driver.findElement(By.xpath("//p[text()='Manual Testing(ISTQB)']")).click();
	 
	 String expres="How many questions you want to take";
	 String actres=driver.findElement(By.id("quizcontent")).getText();
	 Assert.assertEquals(actres, expres);
}

}













