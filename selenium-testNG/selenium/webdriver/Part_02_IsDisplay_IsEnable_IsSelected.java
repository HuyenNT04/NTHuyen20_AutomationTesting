package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Part_02_IsDisplay_IsEnable_IsSelected {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser(){
        driver = new ChromeDriver();
    }

    @Test
    public void TC_01_IsDisplay(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        //Email
        WebElement emailTextbox = driver.findElement(By.cssSelector("#mail"));
        if (emailTextbox.isDisplayed()) {
            System.out.println("Email textbox is displayed");
            emailTextbox.sendKeys("Automation Testing");
        } else {
            System.out.println("Email textbox is not displayed");
        }
    }
    @Test
    public void TC_02_IsEnable(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        //Email
        WebElement emailTextbox = driver.findElement(By.cssSelector("#mail"));
        if (emailTextbox.isEnabled()) {
            System.out.println("Email textbox is enable");
        } else {
            System.out.println("Email textbox is not enable");
        }
    }
    @Test
    public void TC_03_IsSelected(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement AgeUnder18 = driver.findElement(By.xpath("//input[@id='under_18']"));
        if (AgeUnder18.isSelected()) {
            System.out.println("Age is under 18");
        } else {
            System.out.println("Age is not under 18");
        }
        AgeUnder18.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }





















}
