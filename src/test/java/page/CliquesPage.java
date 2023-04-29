package page;

import core.BasePage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static core.DriverFactory.getDriver;

public class CliquesPage extends BasePage {

    public void cliqueLongo(By by){
      new TouchAction(getDriver()).longPress(PointOption.point(getDriver().findElement(by).getCenter())).perform();
    }

    public String obterTextoCampo(){
        return getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
    }

    public void clicarDuasVezes(){
        WebElement clicar = getDriver().findElement(By.xpath("//*[@text='Clique duplo']"));
        TouchAction action = new TouchAction(getDriver());
        action
                .press(ElementOption.element(clicar))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(50)))
                .release()
                .press((ElementOption.element(clicar)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(50)))
                .release()
                .perform();
    }
}
