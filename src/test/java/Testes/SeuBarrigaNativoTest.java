package Testes;

import BarrigaPage.*;
import core.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import page.MenuPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SeuBarrigaNativoTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private SeuBarrigaLoginPage seuBarrigaLoginPage = new SeuBarrigaLoginPage();

    private SeuBarrigaMenuPage seuBarrigaMenuPage = new SeuBarrigaMenuPage();

    private SeuBarrigaPage seuBarrigaPage = new SeuBarrigaPage();

    private SeuBarrigaHome seuBarrigaHome = new SeuBarrigaHome();

    private SeuBarrigaResumo seuBarrigaResumo = new SeuBarrigaResumo();


    @Before
    public void deveRealizarLogin(){
        //Acessar menu Seu Barriga Nativo
        menuPage.acessarMenuSeuBarrigaNativo();
        //Digitar usuario
        seuBarrigaLoginPage.campoNome("soares@teste.com");
        //Digitar Senha//
        seuBarrigaLoginPage.campoSenha("Soares01");
        //Clicar em Entrar
        seuBarrigaLoginPage.clicarPorTexto("ENTRAR");
    }

    @Test
    public void deveInserirConta(){
        //clicar em contas
        seuBarrigaMenuPage.acessarContas();
        //Inserir Conta
        seuBarrigaPage.campoNomeDaConta("Conta Quatro");
        //Clicar em Salvar
        seuBarrigaPage.clicarEmSalvar();
        //Validar Mensagem
        assertEquals("Conta adicionada com sucesso", seuBarrigaPage.obterTextoContaAdicionada());
    }

    @Test
    public void deveExcluirConta(){
        //clicar em contas
        seuBarrigaMenuPage.acessarContas();
        //seleciona conta para exlução
        seuBarrigaPage.selecionarContaParaExclusao();
        //clicar em excluir.
        seuBarrigaPage.excluirContaSelecionada();
        //validar mensagem
        assertTrue(seuBarrigaPage.existeElementoPorTexto("Conta excluída com sucesso"));
    }

    @Test
    public void deveIncluirMov(){
        //clicar em movimentacao
        seuBarrigaMenuPage.acessarMovimentacao();
        //clicar em salvar
        seuBarrigaPage.clicarEmSalvar();
        //validar mensagem
        assertTrue(seuBarrigaPage.existeElementoPorTexto("Descrição é um campo obrigatório"));
        //validar interssado
        seuBarrigaPage.descricao("Desc");
        seuBarrigaPage.clicarEmSalvar();
        assertTrue(seuBarrigaPage.existeElementoPorTexto("Interessado é um campo obrigatório"));
        //validar valor
        seuBarrigaPage.interessado("Interessado");
        seuBarrigaPage.clicarEmSalvar();
        assertTrue(seuBarrigaPage.existeElementoPorTexto("Valor é um campo obrigatório"));
        //validar conta
        seuBarrigaPage.valor("123");
        seuBarrigaPage.clicarEmSalvar();
        assertTrue(seuBarrigaPage.existeElementoPorTexto("Conta é um campo obrigatório"));
        //Inserir com Sucesso
        seuBarrigaPage.selecionarUmaConta();
        seuBarrigaPage.contaParaAlterar();
        seuBarrigaPage.clicarEmSalvar();
        assertTrue(seuBarrigaPage.existeElementoPorTexto("Movimentação cadastrada com sucesso"));
    }

    @Test
    public void deveAtualizarSaldoAoExcluirMovimentacao(){
        //verificar Saldo "conta para saldo" = 534.00
        assertEquals("534.00", seuBarrigaHome.obterSaldoConta("Conta para saldo"));
        //ir para resumo
        seuBarrigaMenuPage.acessarResumo();
        seuBarrigaResumo.atualizar();
        //excluir Movimentacao 3
        seuBarrigaResumo.arrastar();
        seuBarrigaResumo.deletar();
        //validar mensagem 'Movimentação removida com sucesso'
        assertEquals("Movimentação removida com sucesso!", seuBarrigaResumo.mensagemMovimentacaoRemovida());
        //voltar home
        seuBarrigaMenuPage.acessarHome();
        //atualizar Saldo = -1000.00
        assertEquals("534.00", seuBarrigaHome.obterSaldoConta("Conta para saldo"));
        seuBarrigaPage.scroll(0.3,0.9);
        assertEquals("-1000.00", seuBarrigaHome.obterSaldoConta("Conta para saldo"));
        //clicar em reset
        seuBarrigaHome.clicarEmReset();
        assertEquals("Dados resetados com sucesso!", seuBarrigaHome.dadosResetados());
    }
}
