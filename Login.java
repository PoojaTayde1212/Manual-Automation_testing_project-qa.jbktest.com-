package project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Login {
public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");  //for opening the url
		
		  driver.manage().window().maximize(); //for maximizing the page
		  
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  // if we put below x path wrong then it will wait for the given time and then show error on the console and if we put correct x path then it will not wait
		  Actions actions = new Actions(driver);  //action class
		  
		  driver.findElement(By.xpath("//p[text()='Manual Testing(ISTQB)']")).click();
		  String val =  driver.findElement(By.name("count")).getAttribute("value"); //selecting the no. of que
			System.out.println(val);
			driver.findElement(By.id("countbtn")).click(); 
			driver.findElement(By.id("signin-tab")).click();
			driver.findElement(By.id("loginmobile")).sendKeys("7414983630");
			driver.findElement(By.id("loginbtn")).click();
}}
