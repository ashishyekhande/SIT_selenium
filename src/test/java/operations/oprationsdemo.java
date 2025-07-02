package operations;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class oprationsdemo {

	public static WebDriver w; // instance // class level

	public void initialize() // local varible
	{
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--incognito");
		w = new ChromeDriver(op);
		w.manage().window().maximize();
		w.manage().deleteAllCookies();
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	public void fileupload() {

		w.get("https://demoqa.com/automation-practice-form");
		WebElement choose = w.findElement(By.xpath("//input[@id='uploadPicture']"));
		choose.sendKeys("C:\\Users\\koush\\OneDrive\\Desktop\\temp123.txt");
		System.out.println("file uploaded");

		// what are the ways to file upload,
		// 1. send keys
		// 2. Robot class

	}

	public void dragdrop() {
		// TODO Auto-generated method stub
		w.get("https://demoqa.com/droppable");
		WebElement dragg = w.findElement(By.xpath("//div[@id='draggable']"));
		WebElement drop = w.findElement(By.xpath("//div[@id='droppable']"));

		Actions a = new Actions(w);
		a.dragAndDrop(dragg, drop).build().perform();

	}

	public void multiple_tab_window() {
		// TODO Auto-generated method stub
		w.get("https://rahulshettyacademy.com/AutomationPractice/");

		// 1. site open
		// 2. original window save
		// 3. itrate
		// 4. check if it orignal then skip then go to next window
		// 5. jump to new window and perform opration

		// Store the original tab's handle
		String originalTab = w.getWindowHandle(); // return single string
		System.out.println("Original Tab Handle: " + originalTab);

		// Click the link that opens a new tab
		w.findElement(By.xpath("//a[@id='opentab']")).click(); // tab
		// w.findElement(By.xpath("//button[@id='openwindow']")).click(); // window

		// Get all window handles. It will now be a set of two handles.
		Set<String> allTabs = w.getWindowHandles(); // multiple
		System.out.println("Number of tabs open: " + allTabs.size());

		// Iterate through the handles to find the new tab
		Iterator<String> iterator = allTabs.iterator();
		String newTab = "";
		while (iterator.hasNext()) 
		{
			String currentTab = iterator.next();
			if (!currentTab.equalsIgnoreCase(originalTab)) {
				newTab = currentTab;
			}
		}

		// Switch to the new tab
		w.switchTo().window(newTab);
		System.out.println("Title of the new tab: " + w.getTitle());

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		oprationsdemo demo = new oprationsdemo();
		demo.initialize();
		// demo.fileupload();
		// demo.dragdrop();
		demo.multiple_tab_window();

	}

}
