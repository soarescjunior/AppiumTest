package Testes;

import core.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.MenuPage;
import page.OpcaoEscondidaPage;

import static core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

public class OpcaoEscondidaTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private OpcaoEscondidaPage opcaoEscondidaPage = new OpcaoEscondidaPage();
    @Test

    public void deveEncontrarOpcaoEscondida(){
        //Espera explicita
        WebDriverWait wait = new  WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
        //scroll down
        menuPage.scrollDown();
        //clicar no menu
        menuPage.acessarOpçaoBemEscondida();
        //validar mensagem
        assertEquals("Você achou essa opção", opcaoEscondidaPage.validarMensagemEscondida());
        //sair
        opcaoEscondidaPage.clicarPorTexto("OK");
    }
}
