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
        formPO.openMe();
        formPO.fillName( "Bogdan", "Wiadro", "20","o2@o2");
        formPO.wgrajPlik();
        formPO.ustawPlec("inna");
        formPO.ustawLataDoswiadczenia();
        formPO.ustawZawod();
        formPO.ustawKontynent();
        formPO.komendySelenium();
        formPO.nacisnijPrzyciskSignIn();

     //  WebElement formMesage = getDriver().findElement(By.id("validator-message"));
      String testSuccess = "Form send with success";
      Assert.assertEquals(formPO.sprawdz(), testSuccess);

    }

    @Test
    public void szoulWaitproBar(){

    DatapickersPO datapickersPO= new DatapickersPO(getDriver());
    datapickersPO.openMe();
    Assert.assertTrue(datapickersPO.progresBarCoplete());
    }

    @Test
    public  void szouldPoczekajAller(){
        PoczekajAllert poczekajAllert = new PoczekajAllert(getDriver());
        poczekajAllert.openMe();
        poczekajAllert.nacisnijOpuznionyAlert();
        poczekajAllert.getDelayedAlertLabelText();

        Assert.assertEquals(poczekajAllert.getDelayedAlertLabelText(),"OK button pressed");
    }
}
