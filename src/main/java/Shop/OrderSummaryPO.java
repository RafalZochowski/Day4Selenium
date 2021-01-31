package Shop;

import Day5.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderSummaryPO extends BasePO {

    @FindBy(css = ".cart-content-btn.a")
    private WebElement addedTocartProceedButton;

    public void clickProced(){addedTocartProceedButton.click();}

    public OrderSummaryPO(WebDriver driver) {
        super(driver);
    }
}
