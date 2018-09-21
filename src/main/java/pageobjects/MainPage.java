package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
        PAGE_URL = "https://www.tinkoff.ru";
        PAGE_TITLE = "Оплата ЖКХ без комиссии. Коммунальные платежи онлайн";
    }

    public static MainPage getInstance(WebDriver driver){
        MainPage mainPage = PageFactory.initElements(driver,MainPage.class);
        return mainPage;
    }

}

