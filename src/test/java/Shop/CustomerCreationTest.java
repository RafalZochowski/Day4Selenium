package Shop;

import Day4.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerCreationTest extends BaseTest {

    @Test(invocationCount =1)
    public void shouldCreateCustomerAndLogin(){

        //Open shop Home PAge
        //Select sign in
        //Open registerionform
        //register user
        // verify if cotrrect username is diplayed

        //given
        String firstName = "Bogdan";
        String lastName = "Wiadro";
        String email = "test" + System.currentTimeMillis() + "@test.com";
        MenuPO menuPo = new MenuPO(getDriver());
        LoginPO loginPO = new LoginPO(getDriver());
        RegistrationPO registrationPO = new RegistrationPO(getDriver());
        HomePagePO homepagePO = new HomePagePO(getDriver());
        homepagePO.openMe();
        //when
        menuPo.clickSignInOutButton();
        loginPO.clickRegistrationLink();
        registrationPO.fillFormAndSubmit(true,
                firstName,
                lastName,
                email,
                "AAABBB",
                "05/09/2020");
        //then
        Assert.assertTrue(menuPo.isLoggedIn());
        Assert.assertEquals(menuPo.getUserName(), firstName+" "+lastName);

    }
}
