package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Part_06_ExplicitWait {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void initialBrowser(){
        driver = new ChromeDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));//Cach 1
    }

    @Test
    public void TC_01_Less_Than(){
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#star button")).click();

        //C1: Cho den khi element Hello World xuat hien
        //NOTE: Thuong trong ham wwai until da co find element va tra ve roi --> dat bien de reuse trong muc Assert
        WebElement helloText = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish h4")));
        Assert.assertEquals(helloText.getText(), "Hello World!");

        //C2: Cho den khi text xuat hien va co gia tri la Hello World
        Boolean helloText2 = explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("div#finish h4"), "Hello World"));
        Assert.assertTrue(helloText2);

        //C3: Cho den khi invisible - Danh cho 1 element sap bien mat
        Boolean iconLoading = explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("loading")));
        Assert.assertFalse(iconLoading);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish h4")).getText(), "Hello World!");
    }
    @Test
    public void TC_02_Equal(){
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#star button")).click();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish h4")));
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish h4")).getText(), "Hello World!");
    }
    @Test
    public void TC_03_Greater_than(){
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#star button")).click();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish h4")));
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish h4")).getText(), "Hello World!");
    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }





















}
