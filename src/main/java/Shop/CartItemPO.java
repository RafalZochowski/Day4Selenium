package Shop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class CartItemPO {

    @FindBy(css = ".label")
    private WebElement productName;

    public String getCartIemName(){
        return productName.getText();
    }

    public CartItemPO(WebElement productMiniature){
        PageFactory.initElements(new DefaultElementLocatorFactory(productMiniature), this);
    }
}
