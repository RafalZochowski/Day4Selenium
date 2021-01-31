package Shop;

import Day5.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class QuickViewPO extends BasePO {

    @FindBy (css= "h1.h1")
    private WebElement title;

    @FindBy(css = ".add-to-cart")
    private WebElement addToCartButton;

    @FindBy (name = "qty")
    private WebElement quantity;

    @FindBy(css = ".cart-content-btn.a")
    private WebElement addedTocartProceedButton;


    public String getTitle() { return title.getText();}

    public void addToCart(){
        addToCartButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(addedTocartProceedButton));
    }

    public void setQuantity(int n){
        quantity.clear();
        quantity.sendKeys(Integer.toString(n));
    }

    public QuickViewPO(WebDriver driver) {
        super(driver);
    }
}
