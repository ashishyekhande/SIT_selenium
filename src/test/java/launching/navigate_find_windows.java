package launching;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class navigate_find_windows {

	public static WebDriver w; // instance level declaration , instance variable scope--> entire class

	public void initialize() {
		// local variable --> scope limited to method/function
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--incognito");
		w = new ChromeDriver(op);
		w.manage().window().maximize();
		w.manage().deleteAllCookies();
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void main(String args[]) throws Exception {
		// IV --> can we attach non static variable to static method --> NO

		navigate_find_windows a = new navigate_find_windows();
		a.initialize();
		w.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		w.findElement(By.name("username")).sendKeys("Admin");
		w.findElement(By.name("password")).sendKeys("admin123");
		w.findElement(By.xpath("//button[@type='submit']")).click(); // IMP VVVVV

		Thread.sleep(2000);
		String title = w.getTitle();
		System.out.println(title);

		w.findElement(By.xpath("//li[6]/a")).click();

		w.navigate().back(); // go to back page

		w.navigate().forward(); // go to next page

		w.navigate().refresh(); // refresh the page

		w.navigate().to("https://rahulshettyacademy.com/seleniumPractise/#/"); // takes to new site

		w.quit();

	}

}
