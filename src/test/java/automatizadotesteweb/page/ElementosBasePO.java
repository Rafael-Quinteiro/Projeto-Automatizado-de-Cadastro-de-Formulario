package automatizadotesteweb.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*Page object da página do Grocerycrud. */
public class ElementosBasePO extends BasePO {

    /*Elemento de botão de Okay, referente a mensagem de cookie. */
    @FindBy(id = "cookie-accept")
    public WebElement btnCookieOkay;

    /*Elemento de botão da opção de Bootstrap Theme. */
    @FindBy(css = "div.sitemap > ul:nth-child(1) > li:nth-child(5) > a")
    public WebElement btnBootstrapTheme;

    /*Elemento de botão da opção de Live Demo. */
    @FindBy(css = "a.btn.btn-info")
    public WebElement btnLiveDemo;

    /**
     * Construtor da classe.
     * @param driver Driver da página.
     */
    public ElementosBasePO(WebDriver driver) {
        super(driver);
    }
}
