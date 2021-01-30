package Day5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PoczekajAllert extends BasePO{

    @FindBy (id = "delayed-alert")
    private WebElement delayedAlert;

    @FindBy (id= "delayed-alert-label")
    private WebElement delayedAlertLabel;

    public void nacisnijOpuznionyAlert(){
        delayedAlert.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public String getDelayedAlertLabelText(){ return  delayedAlertLabel.getText();}



    public PoczekajAllert(WebDriver driver) {
        super(driver);
        ownUrl="https://seleniumui.moderntester.pl/alerts.php";
    }
}
