package automatizadotesteweb.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**Page object do cadastro de Customer. */
public class CustomerPO extends BasePO {

    /*Elemento de botão de Select version. */
    @FindBy(id = "switch-version-select")
    public WebElement comboSelectVersion;

    /*Elemento de div de Add Customer. */
    @FindBy(css = "div.floatL.t5 > a")
    public WebElement divAddCustomer;

    /*Elemento de input de Name. */
    @FindBy(id = "field-customerName")
    public WebElement inputName;

    /*Elemento de input de Last Name. */
    @FindBy(id = "field-contactLastName")
    public WebElement inputLastName;

    /*Elemento de input de ContactFirstName. */
    @FindBy(id = "field-contactFirstName")
    public WebElement inputContactFirstName;

    /*Elemento de input de Phone. */
    @FindBy(id = "field-phone")
    public WebElement inputPhone;

    /*Elemento de input de AddressLine1. */
    @FindBy(id = "field-addressLine1")
    public WebElement inputAddressLine1;

    /*Elemento de input de AddressLine2. */
    @FindBy(id = "field-addressLine2")
    public WebElement inputAddressLine2;

    /*Elemento de input de City. */
    @FindBy(id = "field-city")
    public WebElement inputCity;

    /*Elemento de input de State. */
    @FindBy(id = "field-state")
    public WebElement inputState;

    /*Elemento de input de PostalCode. */
    @FindBy(id = "field-postalCode")
    public WebElement inputPostalCode;

    /*Elemento de input de Country. */
    @FindBy(id = "field-country")
    public WebElement inputCountry;

    /*Elemento de span de from Employeer. */
    @FindBy(css = "#field_salesRepEmployeeNumber_chosen > a > span")
    public WebElement spanFromEmployeer;

    /*Elemento de input de from Employeer. */
    @FindBy(css = "#field_salesRepEmployeeNumber_chosen > div > div > input[type=text]")
    public WebElement inputFromEmployeer;

    /*Elemento de input de CreditLimit. */
    @FindBy(id = "field-creditLimit")
    public WebElement inputCreditLimit;

    /*Elemento de botão Save. */
    @FindBy(id = "form-button-save")
    public WebElement btnSave;

    /*Elemento de texto de mensagem de sucesso. */
    @FindBy(css = "#report-success > p")
    public WebElement divMensagemDeSucesso;

    /*Elemento de texto de mensagem para retornar para a lista customer. */
    @FindBy(css = "#report-success > p > a:nth-child(2)")
    public WebElement divMensagemDeRetornarParaListaCustomer;

    /*Elemento de input de Search Name. */
    @FindBy(css = "td:nth-child(3) > input")
    public WebElement inputSearchName;

    /*Elemento de ckeckbox da coluna Actions. */
    @FindBy(css = "tr:nth-child(1) > td:nth-child(1) > input")
    public WebElement checkActions;

    /*Elemento de botão de delete do item 1 da página. */
    @FindBy(css = "td.no-border-left > div.floatL > a")
    public WebElement btnDeleteItem;

    /*Elemento de div da coluna Name. */
    @FindBy(css = "tr:nth-child(1) > td:nth-child(3)")
    public WebElement divColunaName;

    /*Elemento de div de Loading. */
    @FindBy(css = "body > div.container-fluid.gc-container.loading-opacity")
    public WebElement divLoading;

    /*Elemento de div de mensagem de delete. */
    @FindBy(css = "p.alert-delete-multiple-one")
    public WebElement divMensagemDelete;

    /*Elemento de botão de Delete. */
    @FindBy(css = "button.btn.btn-danger.delete-multiple-confirmation-button")
    public WebElement btnDelete;

    /*Elemento de div de mensagem informando sucesso após deletar um item. */
    @FindBy(css = "body > div.alert.alert-success.growl-animated.animated.bounceInDown > span:nth-child(4)")
    public WebElement divMensagemDeSucessoDeDelete;

    /**
     * Construtor da classe.
     * @param driver Driver da página.
     */
    public CustomerPO(WebDriver driver) {
        super(driver);
    } 
}
