package page;

import core.BasePage;
import org.openqa.selenium.By;

public class OpcaoEscondidaPage extends BasePage {

    public String validarMensagemEscondida(){
        return obterTexto(By.id("android:id/message"));
    }
}
