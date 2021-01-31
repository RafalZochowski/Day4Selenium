package Shop;

import Day5.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class ProductMiniaturePO {

    @FindBy(css=".product-title")
    private WebElement productName;

    @FindBy(css=".price")
    private WebElement productPrice;


    private WebDriver driver;

    public double getProductPrice() {
        String price = productPrice.getText().replace("$","");
        return Double.valueOf(price);
    }

    public ProductMiniaturePO(WebDriver driver, WebElement productMiniature) {
        PageFactory.initElements(new DefaultElementLocatorFactory(productMiniature), this);
        this.driver=driver;
    }
}
