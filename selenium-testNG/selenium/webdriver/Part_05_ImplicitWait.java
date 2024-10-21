package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Part_05_ImplicitWait {
    WebDriver driver;
    WebElement startButton;

    @BeforeClass
    public void initialBrowser(){
        driver = new ChromeDriver();
        startButton = driver.findElement(By.cssSelector("div#start button"));
    }

    @Test
    public void TC_01_DontSet(){
        driver.get("https://automationfc.github.io/dynamic-loading/");
        startButton.click();
        String finalText = driver.findElement(By.cssSelector("div#finish h4")).getText();
        Assert.assertEquals(finalText, "Hello World!");
    }
    @Test
    public void TC_02_Less_than(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        startButton.click();
        String finalText = driver.findElement(By.cssSelector("div#finish h4")).getText();
        Assert.assertEquals(finalText, "Hello World!");
    }
    @Test
    public void TC_03_Equal(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement startButton = driver.findElement(By.cssSelector("div#start button"));
        startButton.click();
        String finalText = driver.findElement(By.cssSelector("div#finish h4")).getText();
        Assert.assertEquals(finalText, "Hello World!");
    }

    @Test
    public void TC_04_Greater_than(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement startButton = driver.findElement(By.cssSelector("div#start button"));
        startButton.click();
        String finalText = driver.findElement(By.cssSelector("div#finish h4")).getText();
        Assert.assertEquals(finalText, "Hello World!");
    }

    @Test
    public void TC_05_Other_cases(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement startButton = driver.findElement(By.cssSelector("div#start button"));
        startButton.click();
        String finalText = driver.findElement(By.cssSelector("div#finish h4")).getText();
        Assert.assertEquals(finalText, "Hello World!");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        //TCs nay pass do apply doi 10s --> doi duoc element
    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }





















}
