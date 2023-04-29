package BarrigaPage;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.DriverFactory.getDriver;

public class SeuBarrigaMenuPage extends BasePage {

    public void acessarContas(){
        WebDriverWait wait = new  WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Contas']")));
        clicarPorTexto("Contas");
    }

    public void acessarMovimentacao(){
        clicarPorTexto("Mov...");
    }

    public void acessarResumo(){
        clicarPorTexto("Resumo");
    }

    public void acessarHome(){
        WebDriverWait wait = new  WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Home']")));
        clicarPorTexto("Home");
    }
}
