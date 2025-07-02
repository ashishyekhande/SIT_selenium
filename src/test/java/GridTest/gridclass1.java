package GridTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class gridclass1 {

	@Test
	public void gridtest1() throws Exception {
		// TODO Auto-generated method stub
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
				
		WebDriver w = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		w.get("https://www.google.com");
		System.out.println(w.getTitle() +" --grid test 1 chrome");
		w.findElement(By.name("q")).sendKeys("ashish yekhande running in chrome browser ");
		//w.findElement(By.name("btnI")).click();
		w.quit();
	}

}
