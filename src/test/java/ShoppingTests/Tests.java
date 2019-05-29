package ShoppingTests;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tests {
	static WebDriver driver;

	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\Downloads\\chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

	@Test
	public void test2() {
		Actions action = new Actions(driver);
		driver.navigate().to("http://automationpractice.com/index.php");
		WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"search_query_top\"]"));
		searchBox.sendKeys("Printed Chiffon Dress");
		searchBox.submit();
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")).click();
		WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[starts-with(@id, 'fancybox-frame')]")));
		driver.switchTo().frame(myDynamicElement.getAttribute("id"));
		System.out.println("frame switched");

		WebElement myDynamicElement2 = (new WebDriverWait(driver, 10)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"short_description_content\"]/p")));

		System.out.println("success 2");
		System.out.println(myDynamicElement2.getText());
		assertTrue(driver.findElement(By.xpath("//*[@id=\"short_description_content\"]/p")).getText()
				.contains("Printed chiffon knee length dress with tank straps. Deep v-neckline."));
	}

	@Test
	@Ignore
	public void test1() {
		Actions action = new Actions(driver);
		driver.navigate().to("http://automationpractice.com/index.php");
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"))).perform();
		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("fancybox-frame1559146222294")));
		myDynamicElement.click();

//		("//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[3]/a")

		driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[3]/div/div[1]/div/a[1]/img")).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
