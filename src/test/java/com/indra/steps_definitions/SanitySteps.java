package com.indra.steps_definitions;

import com.indra.actions.*;
import com.indra.models.DataExcelModels;
import com.jcraft.jsch.JSchException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.awt.*;

import static org.hamcrest.MatcherAssert.assertThat;

public class SanitySteps{
    @Managed
    WebDriver driver;

    DataExcelModels dataExcelModels = new DataExcelModels();
    LoginPortalCRMActions loginPortalCRMActions = new LoginPortalCRMActions(driver);
    PrepaidActivationActions prepaidActivationActions = new PrepaidActivationActions(driver);
    RenoRepoContolPreciosActions renoRepoContolPreciosActions = new RenoRepoContolPreciosActions(driver);

//-----------<Primer escenario>----------------

    @Given("^Se ingresa al portal CRM para activacion$")
    public void seIngresaAlPortalCRMParaActivacion() {
        driver.get(dataExcelModels.getUrlCRM());
        loginPortalCRMActions.clickOnLogin(dataExcelModels);
    }

    @When("^Se hace la cesion de contrato de una linea pre a pos$")
    public void seHaceLaCesionDeContratoDeUnaLineaPreAPos() throws InterruptedException, AWTException, JSchException {
        renoRepoContolPreciosActions.initialRute();
        renoRepoContolPreciosActions.executeContractAssignment(dataExcelModels.getMsisdnPrepago(),dataExcelModels.getCedulaClientePrepago());
    }

    @Then("^Se deberia ver en pantalla unica la linea cedida pre$")
    public void seDeberiaVerEnPantallaUnicaLaLineaCedidaPre() {
        prepaidActivationActions.consultSingleScreen2(dataExcelModels.getMsisdnPrepago());
    }

}



