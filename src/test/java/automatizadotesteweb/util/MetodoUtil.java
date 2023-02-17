package automatizadotesteweb.util;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/* Classe responsável por armazenar métodos úteis ao projeto. */
public class MetodoUtil {

    /*Driver que será utilizado por todos os testes do sistema. */
    public WebDriver driver;

    /**
     * Construtor da classe.
     * @param driver : Driver utilizado pelo sistema.
     */
    public MetodoUtil(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Método responsável por escrever em um campo input.
     * @param input Texto que será escrito no campo input informado.
     * @param texto Campo input que será utilizado.
     * @param driver Drive utilizado pelo sistema.
     */
    public void escreverCampoInput(WebElement input, String texto, WebDriver driver) {
        input.sendKeys(texto);
        input.sendKeys(Keys.ENTER);
    }

    /**
     * Método responsável por rolar o scroll até o elemento de acordo com o que for desejado.
     * @param elemento Elemento a ser utilizado.
     */
    public void rolarAteOElementoDesejado(WebElement elemento) {
        int deltaY = elemento.getRect().y;
        new Actions(driver)
                .scrollByAmount(200, deltaY)
                .perform();
    }

    /**
     * Metodo que retorna um texto de um elemento.
     * @param elemento Elemento que será utilizado para obter o texto.
     * @return Retorna o elemento consultado.
     */
    public String obterTexto(WebElement elemento){
        return elemento.getText();
    }

    /**
     * M~etodo que retorna o título da pagina atual.
     * @return : Retorna título da página.
    */
    public String obterURLDaPagina(){
        return driver.getCurrentUrl();
    }

    /**
     * Método para selecionar opções em qualquer Combobox.
     * @param elemento : Elemento do Combobox utilizado.
     * @param texto : Texto do Combobox que será selecionado.
     */
    public void selecionarOpcaoCombobox(WebElement elemento, String texto) {
        Select opcaoSelecionada = new Select(elemento);
        opcaoSelecionada.selectByVisibleText(texto);
    }

    /**
     * Método para aguardar o carregamento de um elemento específico.
     * @param elemento : Elemento a ser carregado.
     * @param tempoMaximoEspera : Segundos para o carregamento do elemento.
    */
    public void aguardarElementoFicarVisivel(WebElement elemento, int tempoMaximoEspera) {
        WebDriverWait esperar = new WebDriverWait(driver, Duration.ofSeconds(tempoMaximoEspera));
	    elemento = esperar.until(ExpectedConditions.visibilityOf(elemento));
    }

    /**
     * Método para aguardar a invisibilidade de um elemento específico.
     * @param elemento : Elemento a ser aguardado.
     * @param tempoMaximoEspera : Tempo máximo em segundos para aguardar a visibilidade do elemento.
     * @param driver : Driver da página.
    */
    public void aguardaElementoNaoEstarVisivel(final WebElement elemento, Integer tempoMaximoEspera, WebDriver driver){
        WebDriverWait esperar = new WebDriverWait(driver, Duration.ofSeconds(tempoMaximoEspera));
	    esperar.until(ExpectedConditions.invisibilityOf(elemento));
    }

    /**
     * Método responsável por aguardar um tempo pré-determinado.
     * @param tempoMaximoEspera : Tempo de espera explícito que deverá ser definido no método.
     * @throws InterruptedException
     */
    public void esperaExplicita(long tempoMaximoEspera) throws InterruptedException {
        Thread.sleep(tempoMaximoEspera);
    }

    /**
     * Método responsável por salvar o print na pasta de prints.
     * @param file : Diretório da pasta dos prints.
     * @param descricaoTeste : Descrição dos testes.
     */
    public String salvarCapturaDeTela(String file, String descricaoTeste) {
        File Destinationfile = new File("src/screenshots/" + descricaoTeste + ".png");
        File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String absolutepath_screen = Destinationfile.getAbsolutePath();

        try {
            FileHandler.copy(scrfile, Destinationfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return absolutepath_screen;
    }
}
