package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentsPage extends BasePage {
    @FindBy(xpath = "//div/a/span/div[.='Мобильная связь'")
    WebElement mobileNetwork;

    @FindBy(xpath = "//div/a/span/div[.='ЖКХ']")
    WebElement utilitiesZKH;

    @FindBy(xpath = "//form/div[3]/div/div/div/div/label/div/input")
    WebElement fastSearchProviderInput;

    @FindBy(xpath = "//form/div[3]/div/div/div/div[2]/div/div[1]/div/div/div[1]/div/div[1]/div[1]")
    WebElement searchedProvider;



    public static PaymentsPage getInstance(WebDriver driver) {
        PaymentsPage paymentsPage = PageFactory.initElements(driver, PaymentsPage.class);
        return paymentsPage;
    }

    public PaymentsPage(WebDriver driver) {
        super(driver);
    }

    public void searchProviderByName(String text){
        setTextToElement(fastSearchProviderInput,text);
    }

    //TODO сделать прокидывание названия категории и поиск элемента по ней
    public ServiceProvidersPage chooseServiceProviders() {
        utilitiesZKH.click();
        return ServiceProvidersPage.getInstance(driver);
    }

    public void chooseSearchedProviderByNumber(int n){
       WebElement element= driver.findElement(By.xpath("//form/div[3]/div/div/div/div[2]/div/div[1]/div/div/div["+n+"]/div/div[1]/div[1]"));
       element.click();
    }

    public String getProviderNameFromSearchedByNumber(int n){
       WebElement element = driver.findElement(By.xpath("//form/div[3]/div/div/div/div[2]/div/div[1]/div/div/div["+n+"]/div/div[1]/div[1]"));
        return element.getText();
    }

}

