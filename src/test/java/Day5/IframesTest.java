package Day5;

import Day4.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class IframesTest extends BaseTest {

    @Test
    public void iFrameTest(){
        getDriver().get("https://seleniumui.moderntester.pl/iframes.php");

        getDriver().switchTo().frame("iframe1"); // wejście do iframe
        WebElement imie= getDriver().findElement(By.id("inputFirstName3"));
        imie.sendKeys("Rafal");

        WebElement drugieImie= getDriver().findElement(By.id("inputSurname3"));
        drugieImie.sendKeys("Rafal2");


        getDriver().switchTo().defaultContent();  //wyjście z iframe

        getDriver().switchTo().frame("iframe2"); //wejscie do iframe
        WebElement login=getDriver().findElement(By.id("inputLogin"));
        login.sendKeys("Login22");

        WebElement haslo=getDriver().findElement(By.id("inputPassword"));
        haslo.sendKeys("tajneBardzohaslo");

        Select kontynenty = new Select(getDriver().findElement(By.id("inlineFormCustomSelectPref")));
        kontynenty.selectByVisibleText("Antarctica");

        WebElement lataDoswiadczenia=getDriver().findElement(By.id("gridRadios5"));
        lataDoswiadczenia.click();
        getDriver().switchTo().parentFrame();  //wyjście z iframe

        getDriver().findElement(By.xpath("//a[contains(text(),'Basic')]")).click();


    }


}
