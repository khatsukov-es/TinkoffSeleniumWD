package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileReader;
import java.util.Properties;

public class BasePage {
    @FindBy(xpath = "//*[@id=\"firstMenu\"]//a[.='Платежи']")
    WebElement payments;

    @FindBy(xpath = "//span/a/span[.='Войти']")
    WebElement login;

    @FindBy(xpath = "//*[@id=\"firstMenu\"]//a[.='События']")
    WebElement actions;

    @FindBy(xpath = "//*[@id=\"firstMenu\"]//span[.='Бонусы']")
    WebElement bonuses;

    @FindBy(xpath = "//*[@id=\"firstMenu\"]//a[.='Друзья']")
    WebElement friends;

    @FindBy(xpath = "//*[@id=\"firstMenu\"]//span[.='все продукты']")
    WebElement allproducts;


    protected WebDriver driver;
    protected String PAGE_URL;
    protected String PAGE_TITLE;


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void setTextToElement(WebElement element, String text) {
        element.click();
        element.sendKeys(text);
    }

    public String getPageUrl() {
        return PAGE_URL;
    }

    public String getPageTitle() {
        return PAGE_TITLE;
    }

    public BasePage loadPage() {
        driver.get(getPageUrl());
        return this;
    }

    public PaymentsPage goToPaymentsPage() {
        payments.click();
        return PaymentsPage.getInstance(driver);
    }

    public LoginPage goToLoginPage(){
        login.click();
        return LoginPage.getInstance(driver);
    }
}
