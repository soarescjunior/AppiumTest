package page;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.DriverFactory.getDriver;

public class MenuPage extends BasePage {

    public void acessarFormulario(){
       clicarPorTexto("Formulário");
    }

    public void acessarSplash(){
        clicarPorTexto("Splash");
    }

    public void acessarAlertas(){
        clicarPorTexto("Alertas");
    }

    public void acessarAbas(){
        clicarPorTexto("Abas");
    }
    public void acessarAccordion(){
        clicarPorTexto("Accordion");
    }

    public void acessarCliques(){
        clicarPorTexto("Cliques");
    }

    public void acessarOpçaoBemEscondida(){
        clicarPorTexto("Opção bem escondida");
    }

    public void acessarSwipe(){
        clicarPorTexto("Swipe");
    }

    public void acessarSwipeList(){
        WebDriverWait wait = new  WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
        scrollDown();
        clicarPorTexto("Swipe List");
    }

    public void acessarDragAndDrop(){
        WebDriverWait wait = new  WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
        scrollDown();
        clicarPorTexto("Drag and drop");
    }

    public void acessarMenuHibrido(){
        WebDriverWait wait = new  WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
        scrollDown();
        clicarPorTexto("SeuBarriga Híbrido");
    }

    public void acessarMenuSeuBarrigaNativo(){
        WebDriverWait wait = new  WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
        clicarPorTexto("SeuBarriga Nativo");
    }



}
