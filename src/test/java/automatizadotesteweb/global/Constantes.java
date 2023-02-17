package automatizadotesteweb.global;

/*Classe responsável por armazenar variáveis utilizadas por todo o projeto. */
public class Constantes {

    /*Versão do Chrome Driver */
    public static final String VERSAO_CHROME_DRIVER = "110";
    
    /*Tempo máximo de espera de elementos. */
    public final static int TEMPO_MAXIMO_ESPERA = 20;

    /*Constante da página inicial do Grocerycrud. */
    public static final String URL_BASE = "https://www.grocerycrud.com/demo/bootstrap_theme"; 

    /*Constante da página inicial do cadastro customer V4 */
    public static final String URL_CADASTRO_CUSTOMER_V4 = "https://www.grocerycrud.com/v1.x/demo/bootstrap_theme_v4"; 

    /*Constante da página inicial do Customer. */
    public static final String URL_INICIAL_CUSTOMER = "https://www.grocerycrud.com/v1.x/demo/bootstrap_theme";

    /*Constante do caminho do chromedriver. */
    public static final String PATH_CHROME_DRIVER = "src/test/java/automatizadotesteweb/resource/chromedriver-" + VERSAO_CHROME_DRIVER +".exe";

    /*Versão do navegador usado para testes. */
    public static final String NAVEGADOR = "Google Chrome" + VERSAO_CHROME_DRIVER;

    /*Sistema operacional do ambiente de testes. */
    public static final String SISTEMA_OPERACIONAL = System.getProperty("os.name");
}
