package Shop;

import Day5.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class HomePagePO extends BasePO {

    @FindBy(css=".product-miniature")
    private List<WebElement> allProductMiniatures;

    @FindBy(css = ".add-to-cart")
    private WebElement addToCartButton;

    private List<ProductMiniaturePO> getProductMiniatures() {
        List<ProductMiniaturePO> miniatures = new ArrayList<>();
        for (WebElement e : allProductMiniatures) {
            miniatures.add(new ProductMiniaturePO(driver, e));
        }
        return miniatures;
    }

    public HomePagePO(WebDriver driver) {
        super(driver);
        ownUrl ="http://5.196.7.235/";
    }

    public void printAllProductPrices() {
        List<ProductMiniaturePO> allMiniatures = getProductMiniatures();
        for (ProductMiniaturePO pm: allMiniatures) {
            System.out.println(pm.getProductPrice());
        }

    }

    public int getMiniaturesNumber(){ return  allProductMiniatures.size(); }

    public String getNameOfthMiniature(int n) { return  getProductMiniatures().get(n).getProductTitle();}

    public  double getPriceOfNthMiniature(int n){ return getProductMiniatures().get(n).getProductPrice();}

    public void openQuicViewofNthMiniature(int n) {
        getProductMiniatures().get(n).clickQuickView();
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
    }


}
