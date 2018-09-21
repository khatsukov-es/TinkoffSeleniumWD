package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZkuMoscowPaymentPage extends  BasePage {

    @FindBy(xpath = "//li/div/a/span[.='Оплатить ЖКУ в Москве']")
    WebElement payZHKUinMoscow;
    @FindBy(xpath = "//li/div/a/span[.='Узнать задолженность за ЖКУ в Москве']")
    WebElement knowArrears;
    @FindBy(xpath = "//li/div/a/span[.='Счета']")
    WebElement accounts;
    @FindBy(xpath = "//li/div/a/span[.='История']")
    WebElement history;

    //Попробовать через id.
    @FindBy(xpath = "//div[contains(@class,'Grid')]//input[@id=\"payerCode\"]")
    WebElement payerCodeInput;


    @FindBy(xpath = "//form/div[1]/div/div[2]")
    WebElement payerCodeNotValidError;


    //Попробовать через id.
    @FindBy(xpath = "//*[@id=\"period\"]")
    WebElement period;

    @FindBy(xpath = "//form/div[2]/div/div[2]")
    WebElement periodNotValidError;


    @FindBy(xpath = "//div/label[span[contains(text(),'Сумма добровольного страхования')]]")
    WebElement sumOfInsuranceInput;


    @FindBy(xpath = "//div[2]/div/div[1]/div/div/div[1]/div/div/label/div/input")
    WebElement cardNumberInput;

    @FindBy(xpath = "//form/div[4]/div/div[1]/div/div/div[2]/div/div[2]")
    WebElement cardNumberNotValidError;



    @FindBy(xpath = "//form/div[5]/div/div/div/div/div/div/label/div/input")
    WebElement sumOfPaymentInput;


    @FindBy(xpath = "//form/div[5]/div/div/div/div/div/div[2]")
    WebElement sumOfPaymentIsNotValidError;



    @FindBy(xpath = "//div/button[.='Оплатить ЖКУ в Москве']")
    WebElement payButton;


    public static ZkuMoscowPaymentPage getInstance(WebDriver driver){
        ZkuMoscowPaymentPage zkuMoscowPaymentPage = PageFactory.initElements(driver,ZkuMoscowPaymentPage.class);
        return zkuMoscowPaymentPage;
    }

    public ZkuMoscowPaymentPage(WebDriver driver) {
        super(driver);
    }

    public void payZHKUinMoscowClick(){
        payZHKUinMoscow.click();
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'Grid')]//input[@id=\"payerCode\"]")));
    }

    public void enterPayerCode(String text){
        setTextToElement(payerCodeInput,text);
    }


    public void enterPeriod(String text){
       setTextToElement(period,text);
    }

    public void enterCardNumber(String text) throws InterruptedException {
        setTextToElement(cardNumberInput,text);
        Thread.sleep(2000);
    }

    public void enterSumOfPayment(String text){
        setTextToElement(sumOfPaymentInput,text);
    }


    public String getCodeNotValidError(){
        return payerCodeNotValidError.getText();
    }

    public String getPeriodNotValidError(){
        return periodNotValidError.getText();
    }


    public String getCardNumberNotValidError(){
        return cardNumberNotValidError.getText();
    }

    public String getSumOfPaymentIsNotValidError(){
        return sumOfPaymentIsNotValidError.getText();
    }

    public void clickPayButton(){
        payButton.click();
    }
}
