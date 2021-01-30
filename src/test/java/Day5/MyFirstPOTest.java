package Day5;

import Day4.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstPOTest extends BaseTest {

    @Test
    public void shuldFillForm(){
        FormPO formPO= new FormPO(getDriver());
       formPO.wypelnijFormularz();

       WebElement formMesage = getDriver().findElement(By.id("validator-message"));
      String testSuccess = "Form send with success";
      Assert.assertEquals(formMesage.getText(), testSuccess);

    }
}
