package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegionsPage extends  BasePage {

    @FindBy(xpath = "//span/div/div[.='Назад']")
    WebElement back;

    @FindBy(xpath = "//div[2]/div/div[1]/div/label/div[1]/input")
    WebElement searchRegion;

    public static RegionsPage getInstance(WebDriver driver){
        RegionsPage regionsPage = PageFactory.initElements(driver,RegionsPage.class);
        return regionsPage;
    }

    public RegionsPage(WebDriver driver) {
        super(driver);
    }

    public ServiceProvidersPage pickRegion(String region){
        driver.findElement(By.xpath("//div/span/a/span[contains(.,'"+region+"')]")).click();
        return ServiceProvidersPage.getInstance(driver);
    }

    public void searchRegion(String text){
        searchRegion.click();
        searchRegion.sendKeys(text);
    }
    public void back(){
        back.click();
    }
}
