import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllertTest extends BaseTest{



    @Test
    public void simpleAlert(){
        getDriver().get("https://seleniumui.moderntester.pl/alerts.php");

        getDriver().findElement(By.id("simple-alert")).click();

        getDriver().switchTo().alert().accept();

        Assert.assertEquals(getDriver().findElement(By.id("simple-alert-label")).getText(), "OK button pressed");



    }

    @Test
    public void promptAlert(){
        getDriver().get("https://seleniumui.moderntester.pl/alerts.php");
        getDriver().findElement(By.id("prompt-label")).click();
        String name = "Rafal Zochowski";
        getDriver().switchTo().alert().sendKeys(name);
        getDriver().switchTo().alert().accept();

        Assert.assertEquals(getDriver().findElement(By.id("prompt-label")).getText(),"Hello Rafal Zochowski! How are you today?");
    }
}
