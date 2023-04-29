package Testes;

import core.BaseTest;

import org.junit.Test;
import page.MenuPage;

import static org.junit.Assert.assertTrue;

public class SwipeTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();

    @Test
    public void deveRealizarSwipe(){
        //acessar menu

        menuPage.acessarSwipe();

        //verificar testo a esquerda

        assertTrue(menuPage.existeElementoPorTexto("a esquerda"));

        // swipe para direita

        menuPage.swipeRight();

        // verificar texto 'E veja se'

        assertTrue(menuPage.existeElementoPorTexto("E veja se"));

        // clicar botao direita

        menuPage.clicarPorTexto("›");

        //verificar o texto ' Chegar até o fim'

        assertTrue(menuPage.existeElementoPorTexto("Chegar até o fim!"));

        //swipe esquerda

        menuPage.swipeLeft();

        //clicar no botao a esquerda

        menuPage.clicarPorTexto("‹");

        //verificar o texto

        assertTrue(menuPage.existeElementoPorTexto("a esquerda"));
    }
}
