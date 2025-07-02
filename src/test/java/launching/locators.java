package launching;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class locators {

	public static WebDriver w;
	
	public void initialize() {
		// local variable --> scope limited to method/function
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--incognito");
		w = new ChromeDriver(op);
		w.manage().window().maximize();
		w.manage().deleteAllCookies();
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void terminate() throws Exception
	{
		Thread.sleep(5000);
		w.quit();
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		locators l = new locators();
		l.initialize();	
		w.get("https://demoqa.com/automation-practice-form");
		
		w.findElement(By.id("firstName")).sendKeys("ashish");
		w.findElement(By.id("lastName")).sendKeys("Yekhande");
		
		// relative xpath --> R -> start with //  
		// absolute spath --> A -> start with /
		
		w.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[2]/div[2]/input")).sendKeys("ashihs@gmail.com");
		Thread.sleep(2000);
		w.findElement(By.xpath("//label[@for='gender-radio-1']")).click();
		
		w.findElement(By.xpath("//input[@placeholder='Mobile Number']")).sendKeys("1236547892");
		
		Thread.sleep(2000);
		// //div[@id='hobbiesWrapper']/div[2]/div/label[1]/../../..    --> ex. for traversing back 
		w.findElement(By.xpath("//div[@id='hobbiesWrapper']/div[2]/div/label[1]")).click(); 
		
		l.terminate();
		
	}

}
