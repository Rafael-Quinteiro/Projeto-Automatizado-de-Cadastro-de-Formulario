package automatizadotesteweb.test;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import automatizadotesteweb.util.MetodoUtil;

/* Classe responsável por armazenar métodos pertinentes ao relatório que será gerado após os testes. */
public class SparkReporterUtil {
    
    /*Driver que será utilizado por todos os testes do sistema. */
    public WebDriver driver;
    
    /*Instância de ExtentSparkReporter. */
    public static ExtentSparkReporter spark;
    
    /* Classe que cria relatório com nome padrão. */
    public String nomeRelatorioHtml = "reports/Reports-Automation.html";

    /**
     * Construtor da classe.
     * @param driver : Driver utilizado pelo sistema.
     */
    public SparkReporterUtil(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Método responsável por gerar log da falha no relatório.
     * @param teste : Elemento de extent para inserir informações no relatório.
     * @param t : Classe de expeption.
     */
    public void gerarLogFalha(ExtentTest teste, Throwable t) {
        teste.log(Status.FAIL, t); 
    }
    
    /**
     * Método responsável por rotular o sucesso do teste no relatório.
     * @param teste : Elemento de extent para inserir informações no relatório.
     */
    public void rotularTesteSucesso(ExtentTest teste) {
        String rotularTesteSucesso = "Teste executado com sucesso!";

        teste.log(Status.PASS, MarkupHelper.createLabel(rotularTesteSucesso, ExtentColor.GREEN));
    }

    /**
     * Método responsável por rotular a falha do teste no relatório.
     * @param teste : Elemento de extent para inserir informações no relatório.
     */
    public void rotularTesteFalha(ExtentTest teste) {
        String rotularTesteFalha = "Ocorreu uma falha ao executar o teste!";

        teste.log(Status.FAIL, MarkupHelper.createLabel(rotularTesteFalha, ExtentColor.RED));
    }   
    
    /* Método responsável por criar a pasta de screenshots.  */
    public void criarPastaScreenshot() {
        File file = new File("src/screenshots/");  

        if (!file.exists()) {
        file.mkdirs();
        }
    }

    /**
     * Método responsável por encerrar os testes caso ocorra uma falha e tirar um print da tela.
     * @param teste : Elemento de extent para inserir informações no relatório.
     * @param descricaoTeste : String que recebe a descrição do teste no relatório.
     * @param t : Classe de expeption.
     */
    public void encerrarTesteFalha(ExtentTest teste, String descricaoTeste, Throwable t) {
        MetodoUtil metodoUtil = new MetodoUtil(driver);
        String file = "src/screenshots/";

        metodoUtil.salvarCapturaDeTela(file, descricaoTeste);

        rotularTesteFalha(teste);

        gerarLogFalha(teste, t);

        teste.fail(MediaEntityBuilder.createScreenCaptureFromPath(metodoUtil.salvarCapturaDeTela(file, descricaoTeste)).build());
    }
}
