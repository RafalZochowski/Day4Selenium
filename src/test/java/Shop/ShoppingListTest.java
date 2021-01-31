package Shop;

import Day4.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingListTest extends BaseTest {

    //random product z homepage
    //klikamy na jego quickview
    //w quickview wybieramy iloość (1-10)
    //dodajemy do koszyka
    //przechodzimy do koszyka
    //sprawdzamy nazwę, ilość i sumaryczną cenę produktu


    @Test
    public void itemsInTeheCartShoulHaveCorrectSummary(){
        HomePagePO homePagePO=new HomePagePO(getDriver());
        homePagePO.openMe();
        int n= getRandomNumber(homePagePO.getMiniaturesNumber()-1);
        String name1= homePagePO.getNameOfthMiniature(n);
        double price = homePagePO.getPriceOfNthMiniature(n);
        homePagePO.openQuicViewofNthMiniature(n);
        int quantity= getRandomNumber(10);
        QuickViewPO quickViewPO= new QuickViewPO(getDriver());
        quickViewPO.setQuantity(quantity);
        OrderSummaryPO orderSummaryPO=new OrderSummaryPO(getDriver());
        orderSummaryPO.clickProced();
        ShopiingCartPO shopiingCartPO=new ShopiingCartPO(getDriver());

        Assert.assertEquals(shopiingCartPO.getNthCartItemName(0), name1);
        Assert.assertEquals(price*quantity,shopiingCartPO.getSubtotal());
    }
}
