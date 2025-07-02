package operations;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.google.common.io.Files;

public class links_tabel {

	public static WebDriver w; // instacne level

	public void initialize() {
		// TODO Auto-generated method stub

		ChromeOptions op = new ChromeOptions();
		op.addArguments("--incognito");
		w = new ChromeDriver(op);
		w.manage().window().maximize();
		w.manage().deleteAllCookies();
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	// create list of all element and click on one specific element
	public void listall(String prod) {
		// TODO Auto-generated method stub
		// steps 1. create list
		// 2.create loop and identify element
		// 3.click on elelment and checkout
		w.get("https://vinothqaacademy.com/ecommerce-demo/home.html");

		List<WebElement> list = w.findElements(By.xpath("//h3"));
		System.out.println(list);

		for (WebElement ele : list) {
			String productname = ele.getText();
			System.out.println(productname);
			//
			if (productname.equalsIgnoreCase(prod)) {
				ele.click();
				break;
			}
		}
		System.out.println("list over");

	}

	public void frame() {
		// TODO Auto-generated method stub
		w.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement frame1 = w.findElement(By.id("courses-iframe"));
		w.switchTo().frame(frame1);
		System.out.println(w.getTitle());
		List<WebElement> iframe_element = w.findElements(By.xpath("//ul[@class='navigation clearfix']/li/a"));

		for (WebElement ele : iframe_element) {
			String menu = ele.getText();
			System.out.println(menu);
		}
		System.out.println("list over");
		w.switchTo().frame(0);
		System.out.println(w.getTitle());

	}

	public void takescreenshot() throws Exception {
		// TODO Auto-generated method stub
		TakesScreenshot screenshot = (TakesScreenshot) w;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/basket.png");
		Files.copy(src, dest);

	}

	public void handletabel() {

		// Print price written against the specific course
		w.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> cousList = w.findElements(By.xpath("//table[@id='product'][1]/tbody/tr/td[2]"));

		for (WebElement ele : cousList) {
			String courseName = ele.getText();
			if (courseName.equalsIgnoreCase("WebServices / REST API Testing with SoapUI")) {
				String price = ele.findElement(By.xpath("following-sibling::td")).getText();
				System.out.println("Price of cource is " + price);
				break;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		links_tabel tb = new links_tabel();
		tb.initialize();
		Scanner sc = new Scanner(System.in);
		System.out.println("tell me product name");
		// String prod = sc.nextLine(); // Google Pixel 8 Pro
		// tb.listall("Google Pixel 8 Pro");
		// tb.takescreenshot();
		// tb.frame();
		tb.handletabel();

	}

}
