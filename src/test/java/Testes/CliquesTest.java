package Testes;

import core.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import page.CliquesPage;
import page.MenuPage;

import static org.junit.Assert.assertEquals;

public class CliquesTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private CliquesPage cliquesPage = new CliquesPage();

    @Before
    public void setup(){
        menuPage.acessarCliques();
    }
    @Test
    public void deveRealizarCliqueLongo(){
        //clicar em clique longo
        cliquesPage.cliqueLongo(By.xpath("//*[@text='Clique Longo']"));

        //validar mensagem
        assertEquals("Clique Longo", cliquesPage.obterTextoCampo());

    }

    @Test
    public void deveRealizarCliqueDuplo(){
        //clicar em clique duplo
       cliquesPage.clicarDuasVezes();

        //validar mensagem
        assertEquals("Duplo Clique", cliquesPage.obterTextoCampo());
    }
}
