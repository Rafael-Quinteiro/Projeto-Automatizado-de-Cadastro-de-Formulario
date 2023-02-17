package automatizadotesteweb.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.aventstack.extentreports.ExtentTest;

import automatizadotesteweb.builder.CadastroCustomerBuilder;
import automatizadotesteweb.global.Constantes;
import automatizadotesteweb.page.CustomerPO;
import automatizadotesteweb.page.ElementosBasePO;
import automatizadotesteweb.util.GerenciadorJanelaUtil;
import automatizadotesteweb.util.MetodoUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
/* Classe de testes de Preencher Formulário Customer. */
public class PreencherFormularioCustomerTest extends BaseTest {

    /*Instância de MétodoUtil. */ 
    private static MetodoUtil metodoUtil;

    /*Instância de GerenciadorJanelaUtil. */ 
    private static GerenciadorJanelaUtil gerenciadorJanelaUtil;

    /*Instância de ElementosBasePO. */ 
    private static ElementosBasePO elementosBasePO;

    /*Instância de CustomerPO. */ 
    private static CustomerPO customerPO;

    /*Instância de CadastroCustomerBuilder. */ 
    private static CadastroCustomerBuilder cadastroCustomerBuilder;

    /*Instancia de SparkReporterUtil. */
    public static SparkReporterUtil sparkReporterUtil;

    /*Nome da classe de teste. */
    private static final String descricaoRotina = "Preencher Formulário Customer";

    /* Método responsável por iniciar as instâncias das classes necessárias para executar os testes. */
    @BeforeClass
    public static void iniciarTestes() {
        sparkReporterUtil = new SparkReporterUtil(driver);
        metodoUtil = new MetodoUtil(driver);
        gerenciadorJanelaUtil = new GerenciadorJanelaUtil();
        elementosBasePO = new ElementosBasePO(driver);
        customerPO = new CustomerPO(driver);
        cadastroCustomerBuilder = new CadastroCustomerBuilder(customerPO);

        nomearTituloRelatorio(descricaoRotina);
    }

    /**
     * @throws IOException Indica uma exceção I/O.
     */
    /*Metodo responsável por mover arquivo de relatório gerado para a devida pasta. */
    @AfterClass
    public static void MoveArquivoDeRelatorio() throws IOException {
        Path temp = Files.move
        (Paths.get("Q:/automatizado-testeweb/reports/Reports-Automation.html"),
        Paths.get("Q:/automatizado-testeweb/reports/Preencher Formulário Customer/" + descricaoRotina + ".html"));
  
        if(temp != null) {
            System.out.println("");
        } else {
            System.out.println("Falha ao mover o arquivo para a pasta de relatório.");
        }
    }

    /* Método de builder responsável por criar o cadastro de um customer. */
    private void cadastrarCustomerBuilderPadrao(){
        cadastroCustomerBuilder
            .cadastrarCustomer();
    }

    /*Teste responsável por preencher formulário e cadastrar um customer. */
    @Test
    public void TC001_deve_Preencher_Formulario_E_Cadastrar_Um_Customer() {
        String descricaoTeste = "TC001_deve_Preencher_Formulario_E_Cadastrar_Um_Customer";
        String nomeScreenshot = this.getClass().getSimpleName() + descricaoTeste.substring(0, 5);
        ExtentTest teste = extent.createTest(descricaoTeste).assignDevice(Constantes.NAVEGADOR).assignDevice(Constantes.SISTEMA_OPERACIONAL);
        String textoComboSelectVersion = "Bootstrap V4 Theme";
        String textoDivMensagemDeSucesso = "Your data has been successfully stored into the database. Edit Customer or Go back to list";

        try {
            metodoUtil.aguardarElementoFicarVisivel(elementosBasePO.btnCookieOkay, Constantes.TEMPO_MAXIMO_ESPERA);
            elementosBasePO.btnCookieOkay.click();

            metodoUtil.rolarAteOElementoDesejado(elementosBasePO.btnBootstrapTheme);
            elementosBasePO.btnBootstrapTheme.click();

            metodoUtil.aguardarElementoFicarVisivel(elementosBasePO.btnLiveDemo, Constantes.TEMPO_MAXIMO_ESPERA);
            elementosBasePO.btnLiveDemo.click();

            gerenciadorJanelaUtil.alternarParaUltimaJanelaAberta(driver);

            Assert.assertTrue(metodoUtil.obterURLDaPagina().equals(Constantes.URL_INICIAL_CUSTOMER));

            metodoUtil.aguardarElementoFicarVisivel(customerPO.comboSelectVersion, Constantes.TEMPO_MAXIMO_ESPERA);
            metodoUtil.selecionarOpcaoCombobox(customerPO.comboSelectVersion, textoComboSelectVersion);

            metodoUtil.aguardarElementoFicarVisivel(customerPO.divAddCustomer, Constantes.TEMPO_MAXIMO_ESPERA);
            customerPO.divAddCustomer.click();

            metodoUtil.aguardarElementoFicarVisivel(customerPO.btnSave, Constantes.TEMPO_MAXIMO_ESPERA);

            cadastrarCustomerBuilderPadrao();

            customerPO.btnSave.click();

            metodoUtil.aguardarElementoFicarVisivel(customerPO.divMensagemDeSucesso, Constantes.TEMPO_MAXIMO_ESPERA);
            Assert.assertEquals(textoDivMensagemDeSucesso, metodoUtil.obterTexto(customerPO.divMensagemDeSucesso));

            irParaPaginaDeCadastroCustomerV4(driver);

            sparkReporterUtil.rotularTesteSucesso(teste);
        } catch (Throwable t) {
            sparkReporterUtil.encerrarTesteFalha(teste, nomeScreenshot, t);
            irParaPaginaDeCadastroCustomerV4(driver);        
        }
    }

    /*Teste responsável por preencher formulário cadastrando um customer e, em seguida, retornar a lista de cadastros e deletá-lo. */
    @Test
    public void TC002_deve_Preencher_Formulario_Cadastrando_Um_Customer_Em_Seguida_Retornar_A_Lista_E_Deleta_lo() {
        String descricaoTeste = "TC002_deve_Preencher_Formulario_Cadastrando_Um_Customer_Em_Seguida_Retornar_A_Lista_E_Deleta_lo";
        String nomeScreenshot = this.getClass().getSimpleName() + descricaoTeste.substring(0, 5);
        ExtentTest teste = extent.createTest(descricaoTeste).assignDevice(Constantes.NAVEGADOR).assignDevice(Constantes.SISTEMA_OPERACIONAL);
        String textoInputSearchName = "Teste Sicredi";
        String textoDivMensagemDeSucesso = "Your data has been successfully stored into the database. Edit Customer or Go back to list";
        String textoDivMensagemDelete = "Are you sure that you want to delete this 1 item?";
        String textoDivMensagemDeSucessoDeDelete = "Your data has been successfully deleted from the database.";

        try {
            metodoUtil.aguardarElementoFicarVisivel(customerPO.divAddCustomer, Constantes.TEMPO_MAXIMO_ESPERA);
            customerPO.divAddCustomer.click();

            metodoUtil.aguardarElementoFicarVisivel(customerPO.btnSave, Constantes.TEMPO_MAXIMO_ESPERA);

            cadastrarCustomerBuilderPadrao();

            customerPO.btnSave.click();

            metodoUtil.aguardarElementoFicarVisivel(customerPO.divMensagemDeSucesso, Constantes.TEMPO_MAXIMO_ESPERA);
            Assert.assertEquals(textoDivMensagemDeSucesso, metodoUtil.obterTexto(customerPO.divMensagemDeSucesso));

            metodoUtil.esperaExplicita(12000);

            customerPO.divMensagemDeRetornarParaListaCustomer.click();

            metodoUtil.aguardarElementoFicarVisivel(customerPO.inputSearchName, Constantes.TEMPO_MAXIMO_ESPERA);
            metodoUtil.escreverCampoInput(customerPO.inputSearchName, textoInputSearchName, driver);

            metodoUtil.aguardaElementoNaoEstarVisivel(customerPO.divLoading, Constantes.TEMPO_MAXIMO_ESPERA, driver);

            metodoUtil.aguardarElementoFicarVisivel(customerPO.checkActions, Constantes.TEMPO_MAXIMO_ESPERA);
            customerPO.checkActions.click();

            metodoUtil.aguardarElementoFicarVisivel(customerPO.btnDeleteItem, Constantes.TEMPO_MAXIMO_ESPERA);
            customerPO.btnDeleteItem.click();

            metodoUtil.aguardarElementoFicarVisivel(customerPO.divMensagemDelete, Constantes.TEMPO_MAXIMO_ESPERA);
            Assert.assertEquals(textoDivMensagemDelete, metodoUtil.obterTexto(customerPO.divMensagemDelete));

            customerPO.btnDelete.click();

            metodoUtil.aguardarElementoFicarVisivel(customerPO.divMensagemDeSucessoDeDelete, Constantes.TEMPO_MAXIMO_ESPERA);
            Assert.assertEquals(textoDivMensagemDeSucessoDeDelete, metodoUtil.obterTexto(customerPO.divMensagemDeSucessoDeDelete));

            sparkReporterUtil.rotularTesteSucesso(teste);
        } catch (Throwable t) {
            sparkReporterUtil.encerrarTesteFalha(teste, nomeScreenshot, t);
            irParaPaginaDeCadastroCustomerV4(driver);        
        }
    }
}