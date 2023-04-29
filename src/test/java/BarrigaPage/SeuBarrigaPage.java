package BarrigaPage;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.DriverFactory.getDriver;

public class SeuBarrigaPage extends BasePage {

    public void campoNomeDaConta(String nomeConta){
        WebDriverWait wait = new  WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Conta']")));
        escrever(By.xpath("//*[@text='Conta']"), nomeConta);
    }

    public String obterTextoContaAdicionada(){
        WebDriverWait wait = new  WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Conta adicionada com sucesso']")));
        return obterTexto(By.xpath("//*[(@text='Conta adicionada com sucesso')]"));
    }

    public void clicarEmSalvar(){
        WebDriverWait wait = new  WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='SALVAR']")));
        clicarPorTexto("SALVAR");
    }

    public void selecionarContaParaExclusao(){
        clicarLongo(By.xpath("//*[@text='Conta Quatro']"));
    }

    public void excluirContaSelecionada(){
        clicarPorTexto("EXCLUIR");
    }

    public void descricao(String descricao){
        escrever(By.className("android.widget.EditText"), descricao);
    }

    public void interessado(String interessado){
        escrever(By.xpath("//*[@text='Interessado']"), interessado);
    }

    public void valor(String valor){
        escrever(By.xpath("//*[@text='Valor']"), valor);
    }

    public void selecionarUmaConta(){
        clicarPorTexto("Selecione uma conta...");
    }

    public void contaParaAlterar(){
        clicarPorTexto("Conta para alterar");
    }



}
