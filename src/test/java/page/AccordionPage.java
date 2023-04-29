package page;

import core.BasePage;
import org.openqa.selenium.By;

public class AccordionPage extends BasePage {

    public void selecionarOpcaoUm(){
        clicarPorTexto("Opção 1");
    }

    public String obterPrimeiraMensagem(){
        return obterTexto(By.xpath("//*[@text='Opção 1']/../..//following-sibling::android.view.ViewGroup//android.widget.TextView"));
    }


}
