package launching;

import java.sql.Driver;
import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class basicSeleniumOperation {


public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

/*	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");  //   ./ --> current directory		
	WebDriver w = new ChromeDriver(); // creating object of chromedriver 
	w.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");  
	String title =	w.getTitle();
	System.out.println(title);
	
	String url =w.getCurrentUrl();
	System.out.println(url);
	
	String page =w.getPageSource();
	System.out.println(page);
	
	*/
	
	
	// write a program to open browser which is specified by user
	// 1. user input
	// 2 create codition for browser (if else) 
	
	System.out.println("which browser you want?");
	Scanner sc = new Scanner(System.in);
	String browsename = sc.next();
	
	WebDriver driver = null;  // null   here driver is instance variable for all it functions
	// if else 
	if(browsename.equalsIgnoreCase("chrome"))
	{// here op is local variable to if fuction
		ChromeOptions op = new ChromeOptions();// creating object of chrome option
		op.addArguments("--incognito"); //ss
		driver = new ChromeDriver(op);   // passing property at the time of creation
			
	}
	else if(browsename.equalsIgnoreCase("edge"))
	{
		EdgeOptions op = new EdgeOptions();
		op.addArguments("-inprivate");
		driver = new EdgeDriver(op);
		
	}
	else if(browsename.equalsIgnoreCase("firefox")) 
	{
		FirefoxOptions op = new FirefoxOptions();
		op.addArguments("-private");
		driver = new FirefoxDriver(op);
		
	}
	
	driver.manage().window().maximize();   // maximize window
	driver.manage().deleteAllCookies();  // to delete all cookies
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// An implicit wait in Selenium WebDriver tells the driver to wait
																	  //for a certain amount of time before throwing an exception when 
																	//trying to find an element. It's a global setting applied to the entire 
																	//WebDriver instance,meaning it affects all element location calls throughout the script.
	
	Thread.sleep(3000);  // it will halt stop the execution for specific time
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); 
	Thread.sleep(3000);
	String titlenew =driver.getTitle();
	System.out.println(titlenew);
	driver.close();	
	driver.quit();
	
		
	
	
	}
	
	


}
