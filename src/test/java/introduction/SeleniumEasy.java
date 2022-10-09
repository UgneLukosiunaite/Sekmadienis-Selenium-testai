package introduction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumEasy {

    WebDriver driver;

    @BeforeMethod
    private void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1200,3000");
        options.addArguments("--force -device-scale-factor =0.50");
        options.addArguments("headless");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
    }

    @Test
    private void testSingleInputField(){

        // 1. open web page
        driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");

        // 2. find enterMessage input field
        WebElement inputMessage = driver.findElement(By.xpath("//*[@id='user-message']"));

        // 3. enter value
        inputMessage.sendKeys("labas");
        WebElement btnShowMessage = driver.findElement(By.xpath("//*[@id='get-input']/button"));
        btnShowMessage.click();

        // 4. find "your message" element by id
        WebElement fieldYourMessage = driver.findElement(By.xpath("//*[@id='display']"));

        Assert.assertEquals(fieldYourMessage.getText(), "labas");
    }

    @Test
    private void testSumOfTwoNumbers(){

        driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");

        WebElement enterValueA = driver.findElement(By.xpath("//*[@id='sum1']"));

        enterValueA.sendKeys("2");

        WebElement enterValueB = driver.findElement(By.xpath("//*[@id='sum2']"));

        enterValueB.sendKeys("8");

        WebElement btnGetTotal = driver. findElement(By.xpath("//*[@id='gettotal']/button"));
        btnGetTotal.click();

        WebElement fieldTotal = driver.findElement(By.xpath("//*[@id='displayvalue']"));

        Assert.assertEquals(fieldTotal.getText(),"10");
    }



    @AfterMethod
    private void close() throws InterruptedException {
        try {
            Thread.sleep(1000);
            driver.quit();
        } catch (InterruptedException e) {

        }
    }
}
