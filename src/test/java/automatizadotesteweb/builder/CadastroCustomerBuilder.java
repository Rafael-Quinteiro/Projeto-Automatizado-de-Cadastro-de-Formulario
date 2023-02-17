package automatizadotesteweb.builder;

import org.openqa.selenium.WebDriver;

import automatizadotesteweb.page.CustomerPO;
import automatizadotesteweb.util.MetodoUtil;

/*Classe Builder para preenchimento de formulário de customer. */
public class CadastroCustomerBuilder {

    /*Driver utilizado no sistema. */
    private WebDriver driver;

    /*Instância de MétodoUtil. */ 
    private static MetodoUtil metodoUtil;

    /*Instância de CustomerPO. */ 
    private CustomerPO customerPO;

    /*Input de input name. */
    private String textoInputName = "Teste Sicredi";

    /*Input de input lastname. */
    private String textoInputLastName = "Teste";

    /*Input de input ContactFirstName. */
    private String textoInputContactFirstName = "Rafael de Oliveira Quinteiro";

    /*Input de input Phone. */
    private String textoInputPhone = "51 9999-9999";

    /*Input de input AddressLine1. */
    private String textoInputAddressLine1 = "Av Assis Brasil, 3970";

    /*Input de input AddressLine2. */
    private String textoInputAddressLine2 = "Torre D";

    /*Input de input City. */
    private String textoInputCity = "Porto Alegre";

    /*Input de input State. */
    private String textoInputState = "RS";

    /*Input de input PostalCode. */
    private String textoInputPostalCode = "91000-000";

    /*Input de input Country. */
    private String textoInputCountry = "Brasil";

    /*Input de input FromEmployeer. */
    private String textoInputFromEmployeer = "Fixter";

    /*Input de input CreditLimit. */
    private String textoInputCreditLimit = "200";

    /**
     * Construtor da classe.
     * @param customerPO : Instância de CustomerPO para utilizar no cadastro de customer.
    */
    public CadastroCustomerBuilder(CustomerPO customerPO){
        this.customerPO = customerPO;
    }

    /** 
     * Método responsável por preencher formulário de customer. 
     * @param tempoMaximoEspera : Tempo máximo que o sistema irá aguardar até que o elemento escolhido esteja visível.
     */
    public void cadastrarCustomer(){
        metodoUtil = new MetodoUtil(driver);

            metodoUtil.escreverCampoInput(customerPO.inputName, textoInputName, driver);

            metodoUtil.escreverCampoInput(customerPO.inputLastName, textoInputLastName, driver);

            metodoUtil.escreverCampoInput(customerPO.inputContactFirstName, textoInputContactFirstName, driver);

            metodoUtil.escreverCampoInput(customerPO.inputPhone, textoInputPhone, driver);

            metodoUtil.escreverCampoInput(customerPO.inputAddressLine1, textoInputAddressLine1, driver);

            metodoUtil.escreverCampoInput(customerPO.inputAddressLine2, textoInputAddressLine2, driver);

            metodoUtil.escreverCampoInput(customerPO.inputCity, textoInputCity, driver);

            metodoUtil.escreverCampoInput(customerPO.inputState, textoInputState, driver);

            metodoUtil.escreverCampoInput(customerPO.inputPostalCode, textoInputPostalCode, driver);

            metodoUtil.escreverCampoInput(customerPO.inputCountry, textoInputCountry, driver);

            customerPO.spanFromEmployeer.click();

            metodoUtil.escreverCampoInput(customerPO.inputFromEmployeer, textoInputFromEmployeer, driver);

            metodoUtil.escreverCampoInput(customerPO.inputCreditLimit, textoInputCreditLimit, driver);
    }
}
