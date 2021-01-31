package Shop;

import Day5.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ShopiingCartPO extends BasePO {

    @FindBy(css = ".cart-item")
    List<WebElement> cartItem;

    @FindBy (css = "js-subtotal")
    private WebElement totalNumerOfItems;

    @FindBy (css = "#cart-subtotal-products .value")
    private WebElement subtotal;

    public int getTotalNumberOfItemsInTheCart(){
        return Integer.parseInt(totalNumerOfItems.getText().replaceAll("items",""));

    }

    private List<CartItemPO> getCartItems(){
        List<CartItemPO> catItems = new ArrayList<>();
        for (WebElement e: cartItem){
            catItems.add(new CartItemPO(e));
        }
        return  catItems;
    }

    public String getNthCartItemName(int n){
        return getCartItems().get(n).getCartIemName();
    }

    public double getSubtotal(){
       return Double.valueOf(subtotal.getText().replaceFirst("$",""));
    }
    public ShopiingCartPO(WebDriver driver) {
        super(driver);
        ownUrl="http://5.196.7.235/cart?action=show";
    }
}
