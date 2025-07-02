package operations;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class operations {
	public static WebDriver w; // instance

	public void initialize() {
		// local variable --> scope limited to method/function
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--incognito");
		w = new ChromeDriver(op);
		w.manage().window().maximize();
		w.manage().deleteAllCookies();
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void fileupload() throws Exception {

		w.get("https://demoqa.com/automation-practice-form");
		WebElement choosefile = w.findElement(By.xpath("//input[@id='uploadPicture']"));
		choosefile.sendKeys("C:\\Users\\koush\\OneDrive\\Desktop\\temp.txt");
		Thread.sleep(3000);

	}

	public void robotclass() throws Exception {

		w.get("https://www.foundit.in/create_account.html");

		w.findElement(By.xpath("//div[@class='heroSection-buttonContainer_secondaryBtn__text']")).click();

		// scroll to reach upload button
		// scroll to reach upload button
		JavascriptExecutor j = (JavascriptExecutor) w;
		j.executeScript("scroll(0,500)");

		// Click on 'Choose File' button
		WebElement filebutton = w.findElement(By.xpath("//input[@id='file-upload']"));
		j.executeScript("arguments[0].click();", filebutton);

		// Copy file path to clipboard
		StringSelection filePath = new StringSelection("C:\\Users\\koush\\OneDrive\\Desktop\\temp.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

		// Use Robot to paste path and press Enter
		Robot robot = new Robot();
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		Thread.sleep(500);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("fileupload done");

	}

	public void robotclassdemo() throws Exception {
		// TODO Auto-generated method stub
		w.get("https://demoqa.com/automation-practice-form");
		
				
		JavascriptExecutor j = (JavascriptExecutor) w;
		j.executeScript("scroll(0,500)");
		
		// Click on 'Choose File' button
		WebElement choosefile = w.findElement(By.xpath("//input[@id='uploadPicture']"));
		Actions a = new Actions(w);
		a.moveToElement(choosefile).click().build().perform();
		
		// Copy file path to clipboard
		StringSelection filePath = new StringSelection("C:\\Users\\koush\\OneDrive\\Desktop\\temp.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

		// Use Robot to paste path and press Enter
		Robot robot = new Robot();
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		Thread.sleep(500);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(2000);
	}

	public void drag_n_drop() throws Exception {
		w.get("https://demoqa.com/droppable");
		WebElement dragg = w.findElement(By.xpath("//div[@id='draggable']"));
		WebElement drop = w.findElement(By.xpath("//div[@id='droppable']"));

		Actions a = new Actions(w);
		a.dragAndDrop(dragg, drop).build().perform();

		Thread.sleep(3000);
	}

	public void multipletabs_windows() {
		// TODO Auto-generated method stub

		w.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Store the original tab's handle
		String originalTab = w.getWindowHandle();
		System.out.println("Original Tab Handle: " + originalTab);

		// Click the link that opens a new tab
		// w.findElement(By.xpath("//a[@id='opentab']")).click(); // tab
		w.findElement(By.xpath("//button[@id='openwindow']")).click(); // window

		// Get all window handles. It will now be a set of two handles.
		Set<String> allTabs = w.getWindowHandles();
		System.out.println("Number of tabs open: " + allTabs.size());
		System.out.println(allTabs);

		// Iterate through the handles to find the new tab
		Iterator<String> iterator = allTabs.iterator();
		String newTab = "";
		while (iterator.hasNext()) {
			String currentTab = iterator.next();
			if (!currentTab.equalsIgnoreCase(originalTab)) {
				newTab = currentTab;
			}
		}

		// Switch to the new tab
		w.switchTo().window(newTab);
		System.out.println("Title of the new tab: " + w.getTitle());
		w.switchTo().window(originalTab);
		System.out.println("Title of the original tab: " + w.getTitle());
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		operations f = new operations();
		f.initialize();
		 //f.fileupload();
		// f.robotclass();
		//f.robotclassdemo();
		//f.drag_n_drop();
		f.multipletabs_windows();

	}

	
}
