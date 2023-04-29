package BarrigaPage;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.DriverFactory.getDriver;

public class SeuBarrigaHome extends BasePage {

    public String obterSaldoConta(String conta){
        WebDriverWait wait = new  WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='"+conta+"']/following-sibling::android.widget.TextView")));
        return obterTexto(By.xpath("//*[@text='"+conta+"']/following-sibling::android.widget.TextView"));
    }

    public void clicarEmReset(){
        WebDriverWait wait = new  WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='RESET']")));
        clicarPorTexto("RESET");
    }

    public String dadosResetados(){
        WebDriverWait wait = new  WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Dados resetados com sucesso!']")));
        return obterTexto(By.xpath("//*[@text='Dados resetados com sucesso!']"));
    }
}
