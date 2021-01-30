package Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Mountain {
    String peak;
    String height;

    public String getPeak() {
        return peak;
    }

    public void setPeak(String peak) {
        this.peak = peak;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Day4.Mountain{" +
                "peak='" + peak + '\'' +
                ", height='" + height + '\'' +
                '}';

    }

    Mountain (WebElement row){

        peak= row.findElements(By.cssSelector("td")).get(0).getText();
        height = row.findElements(By.cssSelector("td")).get(3).getText();





    }
}
