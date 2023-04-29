package BarrigaPage;

import core.BasePage;
import org.openqa.selenium.By;

public class SeuBarrigaLoginPage extends BasePage {

    public void campoNome(String nome){
        escrever(By.xpath("//*[@text='Nome']"), nome);
    }
    public void campoSenha(String senha){
        escrever(By.xpath("//*[@text='Senha']"), senha);
    }

}
