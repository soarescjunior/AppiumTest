package Testes;

import core.BaseTest;
import org.junit.Test;
import page.AccordionPage;
import page.MenuPage;

import static org.junit.Assert.assertEquals;

public class AccordionTest extends BaseTest {
    private MenuPage menuPage = new MenuPage();
    private AccordionPage accordionPage = new AccordionPage();

    @Test
    public void deveInteragirComAccordion(){
        //Acessar menu accordion
        menuPage.acessarAccordion();

        //clicar na primeira opção do accordion
        accordionPage.selecionarOpcaoUm();

        //validar mensagem accordion um
        assertEquals("Esta é a descrição da opção 1",accordionPage.obterPrimeiraMensagem());
    }
}
