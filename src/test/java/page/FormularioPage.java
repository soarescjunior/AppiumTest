package page;

import core.BasePage;
import core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static core.DriverFactory.getDriver;

public class FormularioPage extends BasePage {

    public void escreverNome(String nome){
        escrever(MobileBy.AccessibilityId("nome"), nome);
    }
    public String obterNome(){
        return obterTexto(MobileBy.AccessibilityId("nome"));
    }

    public void selecionarCombo(String valor){
        selecionarCombo(MobileBy.AccessibilityId("console"), valor);
    }
    public String obterValorDoCombo(){
        return obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
    }

    public void clicarCheck() {
        clicar(By.className("android.widget.CheckBox"));
    }

    public void clicarSwitch() {
        clicar(MobileBy.AccessibilityId("switch"));
    }

    public void clicarNoTexto(String Texto) {
        clicarPorTexto(Texto);
    }

    public void clicarEmSalvar() {
        clicarPorTexto("SALVAR");
    }

    public void clicarSeekBar(double posicao){
        int detla = 50;
        MobileElement seek =  getDriver().findElement(MobileBy.AccessibilityId("slid"));
        int y = seek.getLocation().y + (seek.getSize().height / 2);
        System.out.println(y);

        int xinicial = seek.getLocation().x + detla;
        int x = (int) (xinicial + ((seek.getSize().width - 2*detla) * posicao));
        System.out.println(x);

       tap(x,y);
    }
    public void salvarDemorado() {
        clicarPorTexto("SALVAR DEMORADO");
    }

    public boolean isCheckMarcado() {
        return isCheckMarcado(By.className("android.widget.CheckBox"));
    }

    public boolean isSwitchMarcado() {
        return isCheckMarcado(MobileBy.AccessibilityId("switch"));
    }

    public String obterNomeCadastrado(){
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Nome:')]"));
    }

    public String obterConsoleCadastrado(){
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Console:')]"));
    }

    public String obterSwitchCadastrado(){
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Switch:')]"));
    }

    public String obterSituaçãoDoCheck(){
        return obterTexto(By.xpath("//android.widget.TextView[@text='Checkbox: Marcado']"));
    }

    public String obterTexto(){
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Nome:')]"));
    }

    public String dataAlterada(){
        return obterTexto(By.xpath("//*[@text='20/2/2000']"));
    }

    public String horarioAlterado(){
        return obterTexto(By.xpath("//*[@text='4:10']"));
    }



}
