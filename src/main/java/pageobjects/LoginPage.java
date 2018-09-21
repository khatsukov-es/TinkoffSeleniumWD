package pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//div/div/label/div[1]/input")
    WebElement loginInput;

    @FindBy(xpath = "//div/div/noindex/button[.='Войти'")
    WebElement confirmLoginButton;

    @FindBy(xpath = "//a/div/div/div/div/div/svg")
    WebElement userPicture;


    public static LoginPage getInstance(WebDriver driver){
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        return loginPage;
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterLogin(String login) {
        setTextToElement(loginInput, login);
    }

    public MainPage confirmLogin() {
        confirmLoginButton.click();
        return MainPage.getInstance(driver);
    }

    public boolean isAuthorised() {
        try {
            if (userPicture.isDisplayed()) {
                return true;
            } else {
                return false;
            }
        } catch(NoSuchElementException exception){
            return false;
        }
    }

}
