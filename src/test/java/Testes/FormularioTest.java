package Testes;

import core.BaseTest;
import core.DriverFactory;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.FormularioPage;
import page.MenuPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class FormularioTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private FormularioPage formularioPage = new FormularioPage();

    @Before
    public void inicializarAppium(){
        menuPage.acessarFormulario();
    }

    @Test
    public void devePreencherCampoTexto() {
        formularioPage.escreverNome("Claudio");

        //validar nome escrito
        assertEquals("Claudio", formularioPage.obterNome());
    }

    @Test
    public void deveInteragirComCombo() {

        //Clicar no combo.
        formularioPage.selecionarCombo("PS4");


        //validar a opção selecionada
        assertEquals("PS4", formularioPage.obterValorDoCombo());

    }

    @Test
    public void deveInteragirComSwitchCheckBox() {
        //verificar o status dos elemento.
        assertFalse(formularioPage.isCheckMarcado());
        assertTrue(formularioPage.isSwitchMarcado());


        //clicar nos elementos
        formularioPage.clicarCheck();
        formularioPage.clicarSwitch();

        //verificar elementos alterados.
        assertTrue(formularioPage.isCheckMarcado());
        assertFalse(formularioPage.isSwitchMarcado());

    }

    @Test
    public void deveRealizarCadastro() {

        //Preencher campo nome
        formularioPage.escreverNome("Claudinho");

        //Seleciona switch e checkbox
        formularioPage.clicarCheck();
        formularioPage.clicarSwitch();


        //Clicar no combo.
        formularioPage.selecionarCombo("Nintendo Switch");

        //Clicar em Salvar
        formularioPage.clicarPorTexto("SALVAR");

        //verificar elementos

        assertEquals("Nome: Claudinho",formularioPage.obterNomeCadastrado());
        assertEquals("Console: switch",formularioPage.obterConsoleCadastrado());
        assertTrue(formularioPage.obterSwitchCadastrado().endsWith("Off"));
        assertTrue(formularioPage.obterSituaçãoDoCheck().endsWith("Marcado"));

    }

    @Test
    public void deveRealizarCadastroDemorado() {

        //Preencher campo nome
        formularioPage.escreverNome("Claudinho");
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        //Clicar em Salvar DEMORADO
        formularioPage.salvarDemorado();
       // esperar(3000); explicito

        //implicito
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Claudinho']")));


        //verificar elementos
        assertEquals("Nome: Claudinho",formularioPage.obterNomeCadastrado());
    }

    @Test
    public void deveAlterarData() {
        //Clicar na data
        formularioPage.clicarNoTexto("01/01/2000");
        //clicar no dia
        formularioPage.clicarNoTexto("20");
        //clicar no OK
        formularioPage.clicarNoTexto("OK");
        //validar data alterada
        assertEquals("20/2/2000",formularioPage.dataAlterada());
    }

    @Test
    public void deveAlterarHorario() {
        //Clicar na hora
        formularioPage.clicarNoTexto("06:00");
        //alterar hora
        formularioPage.clicar(By.id("4"));
        //alterar minuto
        formularioPage.clicar(By.id("10"));
        //clicar no OK
        formularioPage.clicarNoTexto("OK");
        //validar data alterada
        assertEquals("4:10",formularioPage.horarioAlterado());
    }

    @Test
    public void deveInteragirComSeekbar(){
        //clicar no seekbar
        formularioPage.clicarSeekBar(0.67);
        //salvar
        formularioPage.clicarEmSalvar();
        //obter o valor

    }



}
