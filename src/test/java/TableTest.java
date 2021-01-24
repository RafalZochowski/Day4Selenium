import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TableTest extends BaseTest{

    @Test
    public void shouldShowMountainsHighterThan4200(){

getDriver().get("https://seleniumui.moderntester.pl/table.php");
        List<WebElement> mountainRows = getDriver().findElements(By.cssSelector("tbody>tr"));
        List<Mountain> mountains = new ArrayList<>();
        List<String> mhijerthen4200 = new ArrayList<>();

        for(WebElement mountainRow: mountainRows){
            mountains.add(new Mountain(mountainRow));
        }

        for (Mountain mountain:mountains){
            if(Integer.parseInt(mountain.getHeight())>4200){
                mhijerthen4200.add(mountain.getPeak());
            }
        }

        Assert.assertEquals(mhijerthen4200.toString(), "[Mont Blanc, Dufourspitze, Dom, Weisshorn, Matterhorn, Finsteaarhorn]");

    }
}
