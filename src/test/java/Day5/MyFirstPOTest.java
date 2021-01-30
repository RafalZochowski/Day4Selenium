package Day5;

import Day4.BaseTest;
import org.testng.annotations.Test;

public class MyFirstPOTest extends BaseTest {

    @Test
    public void shuldFillForm(){
        FormPO formPO= new FormPO(getDriver());
        formPO.fillName( "Bogdan", "Wiadro");
    }
}
