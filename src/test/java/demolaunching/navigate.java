package demolaunching;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class navigate {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--incognito");
		WebDriver  w = new ChromeDriver(op);
		w.manage().deleteAllCookies();
		w.manage().window().maximize();
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		w.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		w.findElement(By.name("username")).sendKeys("Admin");
		w.findElement(By.name("password")).sendKeys("admin123");
		w.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/form/div[3]/button")).click();
		//w.findElement(By.xpath("//button[@type='submit']")).click(); // IMP VVVVV

		Thread.sleep(2000);
		String title = w.getTitle();
		System.out.println(title);
		
		w.findElement(By.xpath("//ul[@class='oxd-main-menu']/li[3]/a")).click();
		
		w.navigate().back();
		
		w.navigate().forward();
		
		w.navigate().refresh();
		
		w.navigate().to("https://www.amazon.in/");
		w.navigate().back();
		
	}

}
