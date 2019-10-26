package selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Selenium01Assertion {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nebiy\\OneDrive\\Desktop\\ChromeDrive\\chromedriver.exe");

		// Create WebDriver Object
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.spicejet.com/");
		
		driver.manage().window().maximize();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected(), false);
		
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected(), true);
		
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		
		
		Select s = new Select(driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_DropDownListCurrency\"]")));
		
		// We can select the drop down by value
		s.selectByValue("USD");
		
		WebElement option = s.getFirstSelectedOption();
		
		String selectedOPtion = option.getText();
		
		Assert.assertEquals(selectedOPtion, "USD");
		
		driver.findElement(By.id("divpaxinfo")).click();
		
		Thread.sleep(1000L);
		
		Select s1 = new Select(driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_Adult\"]")));
		
		s1.selectByValue("5");
		
		driver.findElement(By.id("divpaxinfo")).click();
		
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		System.out.println("TEST COMPLETED!!");
		
		
		
	
		
		
		

	}

}
