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

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		links_tabel tb = new links_tabel();
		tb.initialize();
		Scanner sc = new Scanner(System.in);
		System.out.println("tell me product name");
		//String prod = sc.nextLine(); // Google Pixel 8 Pro
		tb.listall("Google Pixel 8 Pro");
		tb.takescreenshot();
		

	}

	public void takescreenshot() throws Exception {
		// TODO Auto-generated method stub
		TakesScreenshot screenshot = (TakesScreenshot )w;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/basket.png");
		Files.copy(src, dest);
		
	}

}
