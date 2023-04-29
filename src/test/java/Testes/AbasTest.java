package Testes;

import core.BaseTest;
import org.junit.Test;
import page.AbasPage;
import page.MenuPage;

import static org.junit.Assert.assertEquals;

public class AbasTest  extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private AbasPage abasPage = new AbasPage();
    @Test
    public void deveInteragirComAbas(){
        //acessar menu abas
        menuPage.acessarAbas();
        //verificar que esta na aba1
        assertEquals("Este é o conteúdo da Aba 1", abasPage.obterTextoAba1());
        // acessa aba 2
        abasPage.clicarNaAba2();
        //verificar que esta na aba 2.
        assertEquals("Este é o conteúdo da Aba 2", abasPage.obterTextoAba2());
    }
}
