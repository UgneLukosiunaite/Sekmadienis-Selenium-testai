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

public class TestSelenium {

    WebDriver driver;

    @BeforeMethod
    private void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1200,3000");
        options.addArguments("--force -device-scale-factor =0.50");
        options.addArguments("headless");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver = new ChromeDriver();
        driver.get("http://demoqa.com/text-box");
    }

    @Test
    private void testInputFullName() {
        String expectedFullName = " Ugne lukosiunaite";
        String asctualFullName;

        WebElement inputFullName =
                driver.findElement(By.xpath("//intup[@id='userName']"));

        inputFullName.sendKeys(expectedFullName);

        WebElement buttonSubmit = driver.findElement(By.xpath("//*[@id='submit']"));
        buttonSubmit.click();

        WebElement textName = driver.findElement(By.xpath("//*[@id='name']"));
        asctualFullName = textName.getText();


        Assert.assertTrue(asctualFullName.contains(expectedFullName));
        String.format("Actual result[%s] contains expected rusult [%s]",
                asctualFullName,
                expectedFullName);

    }

    @AfterMethod
    private void close() throws InterruptedException {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

            driver.quit();
        }

    }


    @Test
    private void testInputEmail() {
        String expectedEmail = "u.lukosiunaite@gmail.com";
        String asctualEmail;

        WebElement inputEmail = driver.findElement(By.xpath("//*[@id='userEmail']"));

        inputEmail.sendKeys(expectedEmail);

        WebElement buttonSubmit = driver.findElement(By.xpath("//*[@id='submit']"));
        buttonSubmit.click();

        WebElement textName = driver.findElement(By.xpath("*[@id='email']"));
        asctualEmail = textName.getText();


        Assert.assertTrue(asctualEmail.contains(expectedEmail));
        String.format("Actual result[%s] contains expected rusult [%s]",
                asctualEmail,
                expectedEmail);
    }

    @Test
    private void testInputCurrentAdress() {
        String expectedAdress = "Smolensko g.73";
        String actualAdress ;

        WebElement inputFullName =
                driver.findElement(By.xpath("//[@id='currentAddress']"));

        inputFullName.sendKeys(expectedAdress);

        WebElement buttonSubmit = driver.findElement(By.xpath("//*[@id='submit']"));
        buttonSubmit.click();

        WebElement textName = driver.findElement(By.xpath("//*[@id='Address']"));
        expectedAdress = textName.getText();


        Assert.assertTrue(expectedAdress.contains(expectedAdress));
        String.format("Actual result[%s] contains expected rusult [%s]",
                expectedAdress);

    }
}

