package Testes;

import core.BaseTest;
import org.junit.Test;
import page.DragAndDropPage;
import page.MenuPage;

import static org.junit.Assert.assertEquals;

public class DragAndDropTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private DragAndDropPage dragAndDropPage = new DragAndDropPage();
    private String[] estadoInicial = new  String[]{"Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "qualquer local desejado."};
    private String[] estadoIntermediario = new  String[]{"é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "Esta", "qualquer local desejado."};

    private String[] estadoFinal = new  String[]{"Faça um clique longo", "é uma lista", "Drag em Drop!", "e arraste para", "Esta", "qualquer local desejado."};
    @Test
    public void deveEfetuarDragAndDrop() {
        //acessar menu
        menuPage.acessarDragAndDrop();

        //verificar estado inicial
        assertEquals(estadoInicial,dragAndDropPage.obterLista());

        //arrastar "Esta" para "e arrasta para"
        dragAndDropPage.arrastar("Esta", "e arraste para");

        //verificar estado intermidiario
        assertEquals(estadoIntermediario,dragAndDropPage.obterLista());

        //arrastar "Faça um clique longo", para "é uma lista"
        dragAndDropPage.arrastar("Faça um clique longo", "é uma lista");

        //verificar estado final
        assertEquals(estadoFinal,dragAndDropPage.obterLista());

    }

}
