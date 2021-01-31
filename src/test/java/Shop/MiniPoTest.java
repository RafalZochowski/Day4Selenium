package Shop;

import Day4.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MiniPoTest extends BaseTest {
    HomePagePO homePagePO;

    @BeforeMethod
    public void setUp(){
        homePagePO = new HomePagePO(getDriver());
        homePagePO.openMe();
    }

    @Test
    public void shouldListAllProdukt(){
        homePagePO.printAllProductPrices();
    }

    @Test
    public void nameInQuickViewShouldBeTheSameAsOnMiniatureText(){
        int n = getRandomNumber(homePagePO.getMiniaturesNumber() -1);
        String name1 = homePagePO.getNameOfthMiniature(n);;
        homePagePO.openQuicViewofNthMiniature(n);
        QuickViewPO quickVeiwPO = new QuickViewPO(getDriver());
        Assert.assertEquals(quickVeiwPO.getTitle(),name1);


    }
}
