package automatizadotesteweb.test;

import java.io.IOException;
import java.util.logging.Level;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import automatizadotesteweb.global.Constantes;

    /*Classe base utilizada para todos os testes do projeto. Ao criar um novo teste, deve ser feito a herança dessa classe. */
    public abstract class BaseTest {

    /*Driver que será utilizado por todos os testes do sistema. */
    protected static WebDriver driver;

    /*Options do navegador do Google Chrome. */
    protected static ChromeOptions options;

    /*Instância do ExtentReports. */
    protected static ExtentReports extent;
    
    /*Instância de ExtentSparkReporter. */
    protected static ExtentSparkReporter spark;

    /*Instância de DesiredCapabilities. */
    protected static DesiredCapabilities caps;

    /*Instância de LogginPreferences. */
    protected static LoggingPreferences logPrefs;

    /*Instância de SparkReporterUtil. */
    private static SparkReporterUtil sparkReporterUtil;
    
    /**
     * Método responsável por iniciar todos os pontos necessários antes de executar qualquer teste do sistema. *
     * @throws IOException Indica uma exceção I/O.
     */
    @BeforeClass
    public static void abrirGrocerycrud() throws IOException {
        sparkReporterUtil = new SparkReporterUtil(driver); 

        System.setProperty("webdriver.chrome.driver", Constantes.PATH_CHROME_DRIVER);

        String[] argumentosOptions = {"start-maximized", "--incognito"};
        
        options = new ChromeOptions();
        
        caps = new DesiredCapabilities();
        options.addArguments(argumentosOptions);
        options.setAcceptInsecureCerts(true);
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        caps.setCapability(ChromeOptions.CAPABILITY, options);
	    options.merge(caps);

        driver = new ChromeDriver(options);
        driver.get(Constantes.URL_BASE);

        extent = new ExtentReports();
        spark = new ExtentSparkReporter(sparkReporterUtil.nomeRelatorioHtml);
        spark.config().setTheme(Theme.DARK);
        extent.attachReporter(spark);
        sparkReporterUtil.criarPastaScreenshot();

        logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.BROWSER, Level.ALL);
		caps.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, logPrefs);

        driver.manage().deleteAllCookies();
    }

    /* Método responsável por fechar o navegador após a execução de todos os testes de uma classe. */
    @AfterClass
    public static void encerrarTestes() {
        driver.quit();
    }

    /* Método responsável por salvar o relatório pelo ExtentReports. */
    @After
    public void salvarExtentReports() {
        extent.flush();
    }

    /**
     * Método responsável por nomear o título de uma aba do relatório de teste.
     * @param descricaoRotina Descrição da rotina.
     */
    protected static void nomearTituloRelatorio(String descricaoRotina) {
        spark.config().setDocumentTitle(descricaoRotina);
    }

    /**
     * Método responsável por ir para a página inicial de cadastro de customer.
     * @param driver Driver da página.
     */
    protected void irParaPaginaDeCadastroCustomerV4(WebDriver driver) {
        driver.get(Constantes.URL_CADASTRO_CUSTOMER_V4);
    }
}
