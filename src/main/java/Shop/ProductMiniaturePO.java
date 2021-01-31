package Shop;

import Day5.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.security.PublicKey;

public class ProductMiniaturePO {

    @FindBy(css=".product-title")
    private WebElement productName;

    @FindBy(css=".price")
    private WebElement productPrice;

    @FindBy (css= ".thumbnail")
    private WebElement thumbnail;

    @FindBy(css = ".quick-view")
    private WebElement quickview;


    private WebDriver driver;

    public double getProductPrice() {
        String price = productPrice.getText().replace("$","");
        return Double.valueOf(price);
    }

    public ProductMiniaturePO(WebDriver driver, WebElement productMiniature) {
        PageFactory.initElements(new DefaultElementLocatorFactory(productMiniature), this);
        this.driver=driver;
    }

    public String getProductTitle(){
        return productName.getText();
    }

    public void clickQuickView(){
        Actions actions= new Actions(driver);
        actions.moveToElement(thumbnail).perform();
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(quickview));
        quickview.click();
    }
}
