package project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SighUp {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");  //for opening the url
		
		  driver.manage().window().maximize(); //for maximizing the page
		  
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  // if we put below x path wrong then it will wait for the given time and then show error on the console and if we put correct x path then it will not wait
		  Actions actions = new Actions(driver);  //action class
		  
		  driver.findElement(By.xpath("//p[text()='Manual Testing(ISTQB)']")).click();  //for clicking the test
		  
		  driver.findElement(By.id("countbtn")).click();  // for clicking on the next button
		  
		  driver.findElement(By.id("loginmobile")).sendKeys("7414983630");  //for entering the mobile number
		  
		  driver.findElement(By.id("loginbtn")).click(); // for clicking on login button
		  
		  driver.findElement(By.id("signup-tab")).click(); //for clicking on the sign up button
		  
		  driver.findElement(By.id("name")).sendKeys("Pooja"); // for entering the name in the text box
		  
		  driver.findElement(By.id("emailid")).sendKeys("poojatayde7414@gmail.com"); //for entering the email id in the text box
		
		  driver.findElement(By.id("mobile")).sendKeys("7414983630"); //for entering the mobile number in the text box
		  
		  actions.sendKeys(Keys.TAB).perform();
		  driver.findElement(By.id("agree")).click();  //for clicking on the check box
		  
		  driver.findElement(By.id("emailbtn")).click();  //for clicking on the proceed button
		  
		  

}
}