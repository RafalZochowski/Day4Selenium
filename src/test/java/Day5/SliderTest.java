package Day5;

import Day4.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class SliderTest extends BaseTest {

    @Test
    public void sliderTests(){

        getDriver().get("https://seleniumui.moderntester.pl/slider.php");
        moveTo(50);
        moveTo(80);
        moveTo(88);
        moveTo(20);


    }

    private int getSliderValue(){
        return Integer.parseInt(getDriver().findElement(By.id("custom-handle")).getText());

    }
    private void moveSlidr(int expectedValue, Keys key){
        while (getSliderValue() != expectedValue){
            getDriver().findElement(By.id("custom-handle")).sendKeys(key);
        }

    }

    private  void  moveTo(int expectedSliderValue){
        int actualSliderValue=getSliderValue();
        if (actualSliderValue>expectedSliderValue){
            moveSlidr(expectedSliderValue,Keys.ARROW_LEFT);
        } else if (actualSliderValue<expectedSliderValue){
            moveSlidr(expectedSliderValue,Keys.ARROW_RIGHT);
        }

    }
}
