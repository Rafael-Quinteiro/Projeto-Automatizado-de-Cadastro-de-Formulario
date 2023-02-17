package automatizadotesteweb.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.WebDriver;

/* Classe responsável pelo gerenciamento de janelas do projeto. */
public class GerenciadorJanelaUtil{
    
    /* Atributo correspondente ao identificador da janela principal. */
    private String identificadorJanelaPrincipal;

    /* Set responsável por armazenar os IDs de todas as janelas abertas pelo sistema. */
    private Set<String> identificadoresJanelasAbertas;

    /**
     * Método para obter todos os identificadores das janelas abertas.
     * @param driver : Driver da Página.
     * @param tempoMaximoEspera : Tempo máximo de espera para obter os identificadores.
     * @return : Retorna o Set de identificadores.
     */
    private Set<String> obterIdentificadoresJanelasAbertas(WebDriver driver, int tempoMaximoEspera) {
        identificadoresJanelasAbertas = new HashSet<String>();

        while (identificadoresJanelasAbertas.size() <= 1 && identificadoresJanelasAbertas != null) {
            identificadoresJanelasAbertas = driver.getWindowHandles();
        }

        return identificadoresJanelasAbertas;
    }
    
    /**
     * Retorna o identificador da primeira janela aberta no navegador.
     * @param driver : Driver da pagina.
     * @return : Retorna o identificador.
     * @throws InterruptedException
     */
    private String obterIdentificadorPrimeiraJanela(WebDriver driver) {
        Set<String> todasJanelas = obterIdentificadoresJanelasAbertas(driver, 5);
        identificadorJanelaPrincipal = todasJanelas.iterator().next();

        return identificadorJanelaPrincipal;
    }
    
    /**
     * Método para navegar entre janelas.
     * @param driver : Driver da Página.
     * @param identificadorJanela : Identificador da Janela.
     */
    public void navegarEntreJanelas(WebDriver driver, String identificadorJanela){
        driver.switchTo().window(identificadorJanela);
    }

    /**
     * Método para fechar a janela atual e mudar para a janela principal.
     * @param driver : Driver da Página.
     * @throws InterruptedException
     */
    public void fecharJanelaAtual(WebDriver driver) {
        String janelaPrincipal = obterIdentificadorPrimeiraJanela(driver);
        driver.close();

        navegarEntreJanelas(driver, janelaPrincipal);
    }

    /**
     * Método responsável por alternar para a última janela aberta.
     * @param driver : Driver da Página.
     */
    public void alternarParaUltimaJanelaAberta(WebDriver driver) {
        Set<String> setTodasHandles = obterIdentificadoresJanelasAbertas(driver, 5);
        
        Stream<String> stream = setTodasHandles.stream();
        
        List<String> listaIdentificadoresJanelas = stream
            .filter(identificadorJanelaAtual -> identificadorJanelaAtual != null)
            .filter(identificadorJanelaAtual -> !identificadorJanelaAtual.equals(identificadorJanelaPrincipal))
            .collect(Collectors.toList());
        
        try {
            int indexUltimaJanela = listaIdentificadoresJanelas.size() - 1;
            String identificadorUltimaJanelaAberta = listaIdentificadoresJanelas.get(indexUltimaJanela);
        
            navegarEntreJanelas(driver, identificadorUltimaJanelaAberta);
        } catch (Exception e) {
        }
    }
}
