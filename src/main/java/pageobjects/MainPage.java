package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MainPage extends BasePage {
    protected Properties testProperties = new Properties();
    public MainPage(WebDriver driver) throws IOException {
        super(driver);
        testProperties.load(new FileReader("src/test/resources/testProperties.properties"));
        PAGE_URL = testProperties.getProperty("baseUrl");
        PAGE_TITLE = "Оплата ЖКХ без комиссии. Коммунальные платежи онлайн";
    }

    public static MainPage getInstance(WebDriver driver){
        MainPage mainPage = PageFactory.initElements(driver,MainPage.class);
        return mainPage;
    }

}

