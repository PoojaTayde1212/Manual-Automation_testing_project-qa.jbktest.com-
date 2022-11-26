package project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TakeExam_10Que {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");  //for opening the url
		
		  driver.manage().window().maximize(); //for maximizing the page
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  // if we put below x path wrong then it will wait for the given time and then show error on the console and if we put correct x path then it will not wait
		  Actions actions = new Actions(driver);  //action class
		  
		  driver.findElement(By.xpath("//p[text()='Manual Testing(ISTQB)']")).click();  //for clicking the test
		  
		String val =  driver.findElement(By.name("count")).getAttribute("value"); //selecting the no. of que
		System.out.println(val);
		  driver.findElement(By.id("countbtn")).click();  // for clicking on the next button
		  
		  driver.findElement(By.id("loginmobile")).sendKeys("7414983630");  //for entering the mobile number
		  
		  driver.findElement(By.id("loginbtn")).click(); // for clicking on login button

		  int num=Integer.parseInt(val);
		  for(int i=1;i<=num-1;i++)
		  {
			 WebElement n=driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div/div[5]/div[2]/a[1]"));
			  JavascriptExecutor js = (JavascriptExecutor)driver;
			  
		        // Javascript executor
			  js.executeScript("arguments[0].click();",n); // for scrolling down 
		 }
		 
		 
		WebElement n=  driver.findElement(By.id("qsubmit")); //for clicking submit
		JavascriptExecutor js = (JavascriptExecutor)driver;
		  
        // Javascript executor
	  js.executeScript("arguments[0].click();",n);
		 
		 driver.findElement(By.xpath("//*[@id=\"quizresult\"]/div[2]")).click();  //for viewing answer
		 }}
				  
	


