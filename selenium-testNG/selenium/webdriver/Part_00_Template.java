package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Part_00_Template {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser(){
        driver = new ChromeDriver();
    }

    @Test
    public void TC_01_(){

    }
    @Test
    public void TC_02_(){

    }
    @Test
    public void TC_03_(){

    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }





















}
