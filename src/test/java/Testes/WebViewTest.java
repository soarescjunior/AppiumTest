package Testes;

import core.BaseTest;
import org.junit.Test;
import page.MenuPage;
import page.WebViewPage;

import static org.junit.Assert.assertEquals;

public class WebViewTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private WebViewPage webViewPage = new WebViewPage();

    @Test
    public void deveFazerLogin(){
        //acessar o menu
        menuPage.acessarMenuHibrido();
//        webViewPage.entrarContextoWeb();
        //preencher email
        webViewPage.escreverEmail("soarescjunior1@gmail.com");
        //senha
        webViewPage.escreverSenha("Soares01");
        //entrar
        webViewPage.clicarPorTexto("Entrar");
        //verificar mensagem
        assertEquals("Bem vindo, Claudinho!", webViewPage.obterBoasVindas());
    }

}
