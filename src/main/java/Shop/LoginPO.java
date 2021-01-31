package Shop;

import Day5.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO  extends BasePO {

    @FindBy(xpath = "//a[@data-link-action='display-register-form']")
    private WebElement registrationLink;

    public void clickRegistrationLink(){
        registrationLink.click();
    }

    public LoginPO(WebDriver driver) {
        super(driver);
        ownUrl = "http://5.196.7.235/login?back=my-account";
    }
}
