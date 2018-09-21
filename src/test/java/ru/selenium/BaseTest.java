package ru.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import pageobjects.MainPage;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
   private WebDriver driver;
   protected Properties testProperties = new Properties();
    @Before
    public void setup() throws IOException {
        testProperties.load(new FileReader("src/test/resources/testProperties.properties"));
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public WebDriver getDriver(){
        return this.driver;
    }

    public MainPage getMainPage(){
        return MainPage.getInstance(driver);
    }

    @After
    public void close() {
        driver.quit();
    }
}
