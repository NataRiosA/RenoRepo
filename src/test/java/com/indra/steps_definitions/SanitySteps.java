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
    RenoRepoControlPreciosActions renoRepoControlPreciosActions = new RenoRepoControlPreciosActions(driver);
    PagoEquiposActions pagoEquiposActions = new PagoEquiposActions(driver);
    ConsultarLineaActions consultarLineaActions = new ConsultarLineaActions(driver);

//-----------<Primer escenario>----------------

/*    @Given("^Se ingresa al portal CRM para activacion$")
    public void seIngresaAlPortalCRMParaActivacion() {
        driver.get(dataExcelModels.getUrlCRM());
        loginPortalCRMActions.clickOnLogin(dataExcelModels);
    }

    @When("^Se hace la cesion de contrato de una linea pre a pos$")
    public void seHaceLaCesionDeContratoDeUnaLineaPreAPos() throws InterruptedException, AWTException, JSchException {
        renoRepoControlPreciosActions.initialRute();
        renoRepoControlPreciosActions.executeContractAssignment(dataExcelModels.getMsisdnPost(),dataExcelModels.getImei());
    }

    @Then("^Se deberia ver en pantalla unica la linea cedida pre$")
    public void seDeberiaVerEnPantallaUnicaLaLineaCedidaPre() {
        prepaidActivationActions.consultSingleScreen2(dataExcelModels.getMsisdnPost());
    }*/



    @Given("^Se ingresa al portal CRM$")
    public void seIngresaAlPortalCRM() {
        //driver.get(dataExcelModels.getUrlCRM());
        //loginPortalCRMActions.clickOnLogin(dataExcelModels);
    }

    @When("^se hace la posventa reno repo$")
    public void seHaceLaPosventaRenoRepo() throws JSchException, InterruptedException, AWTException {
//        renoRepoControlPreciosActions.initialRute();
//        renoRepoControlPreciosActions.ejecutaLaRenoRepo(dataExcelModels.getMsisdnPost(),dataExcelModels.getImei());
//        consultarLineaActions.consultarEnPantallaUnica(dataExcelModels.getMsisdnPost(),"");
    }

    @When("^se hace el pago del equipo$")
    public void seHaceElPagoDelEquipo() {
//       pagoEquiposActions.rutaInicial();
//       pagoEquiposActions.pagarEquipo(dataExcelModels.getIdentificacion(),dataExcelModels.getMsisdnPost(),renoRepoControlPreciosActions.idItem);
    }

    @Then("^se deberia ver el resultado de la consulta$")
    public void seDeberiaVerElResultadoDeLaConsulta() throws JSchException, InterruptedException, AWTException {
       //consultarLineaActions.consultarEnPantallaUnicaResultadoFinal(dataExcelModels.getMsisdnPost(),dataExcelModels.getImei());
        RenoRepoEjecucionMasivaActions masivaActions = new RenoRepoEjecucionMasivaActions();
        masivaActions.ciclo();
    }


}



