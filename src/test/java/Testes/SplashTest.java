package Testes;

import core.BaseTest;
import org.junit.Test;
import page.MenuPage;
import page.SplashPage;

import static org.junit.Assert.assertTrue;

public class SplashTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private SplashPage splashPage = new SplashPage();
    @Test
    public void deveAguardarSplashSumir(){
        //Acessar menu Splash
        menuPage.acessarSplash();

        //verificar que o spalsh é exibido
        splashPage.isTelaSplashVisivel();

        //aguardar saida do splash
        splashPage.aguardarSplashSumir();

        //verificar formulario.
        assertTrue(splashPage.existeElementoPorTexto("Formulário"));
    }
}
