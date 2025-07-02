package demolaunching;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class openBasic {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("which browser name");
		Scanner sc = new Scanner(System.in);
		String browsername = sc.next();
		// instance

		WebDriver w = null;

		if (browsername.equalsIgnoreCase("chrome")) { // local
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--incognito");
			w = new ChromeDriver(op);

		} else if (browsername.equalsIgnoreCase("edge")) {
			EdgeOptions op = new EdgeOptions();
			op.addArguments("-inprivate");
			w = new EdgeDriver(op);

		}

		else if (browsername.equalsIgnoreCase("firefox")) {
			w = new FirefoxDriver();

		}

		w.manage().deleteAllCookies();
		w.manage().window().maximize();
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		w.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		String title = w.getTitle();
		System.out.println(title);

		Thread.sleep(3000);
		// w.close();
		w.quit();

	}

}
