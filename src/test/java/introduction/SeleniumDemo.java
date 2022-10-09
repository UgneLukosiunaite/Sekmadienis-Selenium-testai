package introduction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class SeleniumDemo {

    @Test
    public void testDemoWebDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.vilniuscoding.lt/");

        try {
            driver.manage().window().fullscreen();
            Thread.sleep(3000);

            driver.manage().window().maximize();
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    @Test
    public void testClickKontaktaiOfVcsWebPage(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.vilniuscoding.lt/");
        driver.manage().window().maximize();

        WebElement linkKontaktai = driver.findElement(By.id ("menu-item-3969"));
        linkKontaktai.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    @Test
    public void testClickKontaktaiOfVcsWebWithSmallWindow(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=600,1000");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.vilniuscoding.lt/");


        WebElement buttonBurger = driver.findElement(By.id ("burger"));
        buttonBurger.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement btnKontaktai = driver.findElement(By.id("menu-item-3969"));
        btnKontaktai.click();
        driver.quit();

    }

    }


