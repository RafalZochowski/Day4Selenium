package Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class FormTest extends BaseTest{

    @Test
    public  void  shouldSendForm(){


        getDriver().get("https://seleniumui.moderntester.pl/form.php");

        WebElement firstName = getDriver().findElement(By.id("inputFirstName3"));
        firstName.sendKeys("Jan");

        WebElement lastName = getDriver().findElement(By.id("inputLastName3"));
        lastName.sendKeys("Kowalski");

        WebElement wiek = getDriver().findElement(By.id("inputAge3"));
        wiek.sendKeys("20");


        WebElement email = getDriver().findElement(By.id("inputEmail3"));
        email.sendKeys("jankowalski@wp.pl");

        WebElement sex = By.id("gridRadiosFemale").findElement(getDriver());
        sex.click();

        List<WebElement> yearsOfExperience= getDriver().findElements(By.cssSelector("input[name=gridRadiosExperience]"));
        yearsOfExperience.get(2).click();


        WebElement profesion = getDriver().findElement(By.id("gridCheckAutomationTester"));
        profesion.click();

        Select continents = new Select(getDriver().findElement(By.id("selectContinents")));
        continents.selectByIndex(1);
        continents.selectByValue("europe");
        continents.selectByVisibleText("Africa");

        Select  comands = new Select(getDriver().findElement(By.id("selectSeleniumCommands")));
        comands.selectByIndex(2);

        File file = new File("src/main/resources/file.txt");

        WebElement uploadFile = getDriver().findElement(By.id("chooseFile"));
        uploadFile.sendKeys(file.getAbsolutePath());

        WebElement seveButton = getDriver().findElement(By.cssSelector("[type='submit']"));
        seveButton.click();

        WebElement formMesage = getDriver().findElement(By.id("validator-message"));
        String testSuccess = "Form send with success";

        Assert.assertEquals(formMesage.getText(), testSuccess);



    }


}
