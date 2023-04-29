package page;

import core.BasePage;
import core.DriverFactory;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

import java.util.Set;

import static core.DriverFactory.getDriver;

public class WebViewPage extends BasePage {

    public void entrarContextoWeb(){
        Set<String> contextHandles = getDriver().getContextHandles();
        for (String valor: contextHandles){
            System.out.println(valor);
        }
        getDriver().context((String) contextHandles.toArray()[1]);
    }
    public void escreverEmail(String email){
            escrever(By.id("email"), email);
    }

    public void escreverSenha(String senha){
        escrever(By.id("senha"), senha);
    }

    public String obterBoasVindas(){
        return obterTexto(By.xpath("//*[starts-with(@text,'Bem vindo, ')]"));
    }
}
