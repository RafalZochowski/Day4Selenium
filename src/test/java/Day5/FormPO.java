package Day5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FormPO {

    @FindBy(id = "inputFirstName3" )
    private WebElement inputFirstName3;

    @FindBy(id = "inputLastName3")
    private  WebElement inputLastName3;

    public void  fillName(String name, String lastName){
        inputFirstName3.sendKeys(name);
        inputLastName3.sendKeys(lastName);
    }




    public FormPO(WebDriver driver){
        PageFactory.initElements(driver,this);
        driver.get("https://seleniumui.moderntester.pl/form.php");
    }
}
