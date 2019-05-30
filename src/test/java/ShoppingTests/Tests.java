package ShoppingTests;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constants.Constant;

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
		driver.navigate().to(Constant.URL1);
		WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"search_query_top\"]"));
		searchBox.sendKeys("Printed Chiffon Dress");
		searchBox.submit();
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")).click();
		WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[starts-with(@id, 'fancybox-frame')]")));
		driver.switchTo().frame(myDynamicElement.getAttribute("id"));

		WebElement myDynamicElement2 = (new WebDriverWait(driver, 10)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"short_description_content\"]/p")));

		System.out.println(myDynamicElement2.getText());
//		assertTrue(driver.findElement(By.xpath("//*[@id=\"short_description_content\"]/p")).getText()
//				.contains("Printed chiffon knee length dress with tank straps. Deep v-neckline."));

		WebElement buyNow = driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span"));
		buyNow.click();

		WebElement checkout = (new WebDriverWait(driver, 10)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")));

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		checkout.click();
		System.out.println("checkout clicked");
		WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span"));
		continueButton.click();

		WebElement emailBox = driver.findElement(By.xpath("//*[@id=\"email_create\"]"));
		emailBox.sendKeys(Constant.EMAIL);
		emailBox.submit();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		boolean elementExists;
		try {
			driver.findElement(By.xpath("//*[@id=\"create_account_error\"]/ol/li"));
			elementExists = true;
		} catch (NoSuchElementException e) {
			elementExists = false;
		}

		if (elementExists) {
			emailBox = driver.findElement(By.xpath("//*[@id=\"email\"]"));
			emailBox.sendKeys(Constant.EMAIL);
			WebElement passwordBox = driver.findElement(By.xpath("//*[@id=\"passwd\"]"));
			passwordBox.sendKeys(Constant.PASSWORD);
			WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span"));
			submitButton.click();

		} else {
			System.out.println("Account creation started");
			WebElement fNameBox = (new WebDriverWait(driver, 10))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"customer_firstname\"]")));
			System.out.println("first box found");
			fNameBox.sendKeys(Constant.FIRSTNAME);
			System.out.println("fName");
			WebElement lNameBox = driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]"));
			lNameBox.sendKeys(Constant.LASTNAME);
			System.out.println("lName");
			WebElement passwordBox = driver.findElement(By.xpath("//*[@id=\"passwd\"]"));
			passwordBox.sendKeys(Constant.PASSWORD);
			System.out.println("password");
			WebElement addressBox = driver.findElement(By.xpath("//*[@id=\"address1\"]"));
			addressBox.sendKeys(Constant.ADDRESS);
			System.out.println("address");
			WebElement cityBox = driver.findElement(By.xpath("//*[@id=\"city\"]"));
			cityBox.sendKeys(Constant.CITY);
			System.out.println("city");
			WebElement stateBox = driver.findElement(By.xpath("//*[@id=\"id_state\"]"));
			stateBox.click();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			stateBox.sendKeys(Constant.STATE);
			System.out.println("state");
			WebElement zipBox = driver.findElement(By.xpath("//*[@id=\"postcode\"]"));
			zipBox.sendKeys(Constant.ZIPCODE);
			WebElement phoneBox = driver.findElement(By.xpath("//*[@id=\"phone_mobile\"]"));
			phoneBox.sendKeys(Constant.MOBILENUM);
			WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span"));
			submitButton.click();
		}
		WebElement proceed = driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span"));
		proceed.click();
		WebElement agreeTAndCs = driver.findElement(By.xpath("//*[@id=\"cgv\"]"));
		agreeTAndCs.click();
		proceed = driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span"));
		proceed.click();
		WebElement paymentButton = driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a"));
		paymentButton.click();
		proceed = driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span"));
		proceed.click();

		WebElement orderConfirmed = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p/strong"));

		assertTrue(orderConfirmed.isDisplayed());
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

		driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[3]/div/div[1]/div/a[1]/img")).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
