package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServiceProvidersPage extends BasePage {

    @FindBy(xpath = "//div/span/span/span")
    WebElement region;

    @FindBy(xpath = "//section/ul/li[1]/span[1]/a/span/div/div")
    WebElement firstProvider;


    public static ServiceProvidersPage getInstance(WebDriver driver) {
        ServiceProvidersPage serviceProvidersPage = PageFactory.initElements(driver, ServiceProvidersPage.class);
        return serviceProvidersPage;
    }

    public ServiceProvidersPage(WebDriver driver) {
        super(driver);
    }

    public RegionsPage goToRegionsPage() {
        region.click();
        return RegionsPage.getInstance(driver);
    }


    public ZkuMoscowPaymentPage clickToFirstProvider(){
        firstProvider.click();
        return ZkuMoscowPaymentPage.getInstance(driver);
    }

    public String getRegion() {
        return region.getText();
    }

    public String getProviderNamebyNumber(int i) {
       WebElement element= driver.findElement(By.xpath("//section/ul/li["+i+"]/span[2]/a/span/div"));
       return element.getText();
    }

    public WebElement getProviderElementByName(String name){
      WebElement element = driver.findElement(By.xpath("//section/ul/li/span[2]/a/span/div[.='"+name+"']"));
      return element;
    }
}
