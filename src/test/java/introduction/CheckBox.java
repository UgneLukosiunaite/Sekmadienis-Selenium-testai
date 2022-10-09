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

public class CheckBox {

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
    private void testSingleCheckBoxChecked(){
        driver.get("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
        WebElement btnsingleCheckBox = driver.findElement(By.xpath("//*[@id='isAgeSelected']"));
        btnsingleCheckBox.click();

        WebElement success = driver.findElement(By.xpath("//*[@id='txtAge']"));
        String style = success.getCssValue("display");

        Assert.assertEquals(style, "block");

    }
    @Test
    private void testSingleCheckBoxUnchecked(){
        driver.get("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
        WebElement success = driver.findElement(By.xpath("//*[@id='txtAge']"));
        String style = success.getCssValue("display");

        Assert.assertEquals(style, "none");
    }
    @Test
    private void testingMultipleCheckBox(){
        driver.get("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
        WebElement btnCheckAll = driver.findElement(By.xpath("//*[@id='check1']"));
        btnCheckAll.click();

        Assert.assertEquals(btnCheckAll.getAttribute("value"),"Uncheck All");

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

