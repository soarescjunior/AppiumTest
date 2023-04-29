package BarrigaPage;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.DriverFactory.getDriver;

public class SeuBarrigaResumo extends BasePage {

    public void arrastar(){
        arrasteParaEsquerda("Movimentacao 3, calculo saldo");
    }

    public void deletar(){
        WebDriverWait wait = new  WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Del']")));
        clicarPorTexto("Del");
    }
    public String mensagemMovimentacaoRemovida(){
        return obterTexto(By.xpath("//*[@text='Movimentação removida com sucesso!']"));
    }

    public void atualizar(){
        clicarPorTexto("ATUALIZAR");
    }
}
