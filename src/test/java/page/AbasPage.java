package page;

import core.BasePage;
import org.openqa.selenium.By;

public class AbasPage extends BasePage {

    public String obterTextoAba1(){
        return obterTexto(By.xpath("//*[@text='Este é o conteúdo da Aba 1']"));
    }
    public void clicarNaAba2(){
        clicarPorTexto("Aba 2");
    }

    public String obterTextoAba2(){
        return obterTexto(By.xpath("//*[@text='Este é o conteúdo da Aba 2']"));
    }
}
