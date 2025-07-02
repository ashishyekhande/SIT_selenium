package launching;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class alert_select_action {

	public static WebDriver w;   // instance

	public void initialize() {
		// local variable --> scope limited to method/function
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--incognito");
		w = new ChromeDriver(op);
		w.manage().window().maximize();
		w.manage().deleteAllCookies();
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	
	
	public void selectexample() {

		
		// absolute  --> /  
		//relative --> //
		w.get("https://rahulshettyacademy.com/AutomationPractice/");
		// Select
		WebElement ele = w.findElement(By.id("dropdown-class-example"));
		
		Select s = new Select(ele); // select is class  // select need element 
		
		s.selectByIndex(1);
		s.selectByValue("option2");
		s.selectByVisibleText("Option3");
		

	}

	public void alertexample() {
		// TODO Auto-generated method stub

		//tagname[@attribute='value']
		
		w.get("https://rahulshettyacademy.com/AutomationPractice/");
		w.findElement(By.xpath("//input[@class ='inputs']")).sendKeys("ashish ");
		w.findElement(By.xpath("//input[@id='alertbtn']")).click();
		Alert a1 = w.switchTo().alert(); // to shift focus on alert popup // alert ia an interface
		String alerttext = a1.getText();
		System.out.println(alerttext);
		a1.accept();   // to click ok 
		
		
		w.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		a1=w.switchTo().alert();
		alerttext = a1.getText();
		System.out.println(alerttext);
		a1.dismiss();  // to click cancel
	}

	public void actionexample() {
		// TODO Auto-generated method stub
		w.get("https://rahulshettyacademy.com/AutomationPractice/");
		Actions a = new Actions(w);   // action need webdrive
		
		WebElement ele =w.findElement(By.xpath("//button[@id='mousehover']"));  //main button
		
		a.moveToElement(ele).build().perform();  // moving mouse to button
		
		WebElement top =w.findElement(By.xpath("//a[contains(text(),'Top')]"));
		a.moveToElement(top).click().build().perform();
		System.out.println(w.getCurrentUrl());
		
		a.moveToElement(ele).build().perform();  // moving mouse to button
		
		WebElement reload =w.findElement(By.xpath("//a[contains(text(),'Reload')]"));
		a.moveToElement(reload).click().build().perform();
		System.out.println(w.getCurrentUrl());
		
		
	}
	
	public void terminate() throws Exception {
		Thread.sleep(5000);
		w.quit();
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		alert_select_action a = new alert_select_action();
		a.initialize();
		a.selectexample();
	//	a.alertexample();
		a.actionexample();

		// a.terminate();
	}

	

	
}
