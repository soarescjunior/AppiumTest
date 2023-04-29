package Testes;

import core.BaseTest;
import org.junit.Before;
import org.junit.Test;
import page.AlertaPage;
import page.MenuPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class AlertasTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private AlertaPage alertaPage = new AlertaPage();

    @Before
    public void setup(){
        //acessar menu alerta
        menuPage.acessarAlertas();
    }
    @Test
    public void deveConfirmarAlerta(){
        //clicar em alerta confirme
        alertaPage.clicarAlertaConfirm();

        //deve verificar os textos
        assertEquals("Info", alertaPage.obterTituloAlerta());
        assertEquals("Confirma a operação?", alertaPage.obterMensagemAlerta());

        // confirmar o alerta
        alertaPage.confirmar();

        //verificar mensagem
        assertEquals("Info", alertaPage.obterTituloAlerta());
        assertEquals("Confirmado", alertaPage.obterMensagemAlerta());

        //clicar em sair
        alertaPage.sair();
    }

    @Test
    public void deveClicarForaAlerta(){
        //Clicar alerta simples
        alertaPage.clicarAlertaSimples();
        //clicar fora da caixa.
        alertaPage.clicarForaDaCaixa();
        //verificar que a mensagem não esta presente
        assertFalse(alertaPage.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));
    }

}
