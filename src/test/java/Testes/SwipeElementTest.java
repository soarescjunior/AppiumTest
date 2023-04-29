package Testes;

import core.BaseTest;
import org.junit.Test;
import page.MenuPage;
import page.SwipeListPage;

import static org.junit.Assert.assertTrue;

public class SwipeElementTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private SwipeListPage swipeListPage = new SwipeListPage();

    @Test
    public void deveResolverDesafio(){
        //Clicar swipe list
        menuPage.acessarSwipeList();

        //opção 1 para direita
        swipeListPage.swipeElementRight("Opção 1");

        //opção 1 +
        swipeListPage.clicarBotaoMais();

        //verificar opção1+
        assertTrue(menuPage.existeElementoPorTexto("Opção 1 (+)"));

        //opção 4 para direita
        swipeListPage.swipeElementRight("Opção 4");

        //opção 4 -
        menuPage.clicarPorTexto("(-)");

        //veirificar opção 4
        assertTrue(menuPage.existeElementoPorTexto("Opção 4 (-)"));

        //opção 5 para esquerda
        swipeListPage.swipeElementLeft("Opção 5 (-)");

        //verificar opção 5
        assertTrue(menuPage.existeElementoPorTexto("Opção 5"));

    }
}
