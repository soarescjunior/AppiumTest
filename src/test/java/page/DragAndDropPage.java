package page;

import core.BasePage;
import core.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.util.List;

import static core.DriverFactory.getDriver;

public class DragAndDropPage extends BasePage {

    public void arrastar(String origem, String destino) {
        MobileElement inicio = getDriver().findElement(By.xpath("//*[@text='"+origem+"']"));
        MobileElement fim = getDriver().findElement(By.xpath("//*[@text='"+destino+"']"));

        new TouchAction<>(getDriver()).longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(inicio))).moveTo(PointOption.point(fim.getCenter())).release().perform();

    }

    public String[] obterLista(){
        List<MobileElement> elementos = getDriver().findElements(By.className("android.widget.TextView"));
        String[] retorno = new String[elementos.size()];
        for (int i = 0; i < elementos.size(); i++) {
            retorno[i] = elementos.get(i).getText();
        }
        return retorno;
    }
}
