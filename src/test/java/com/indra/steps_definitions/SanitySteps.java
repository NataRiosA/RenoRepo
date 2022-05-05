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
    ReadFileXLSXActions readExcelFile = new ReadFileXLSXActions();

    @Given("^Se ingresa al portal CRM$")
    public void seIngresaAlPortalCRM() {
        driver.get(dataExcelModels.getUrlCRM());
        loginPortalCRMActions.clickOnLogin(dataExcelModels);
    }

    @When("^se hace la posventa reno repo$")
    public void seHaceLaPosventaRenoRepo() throws JSchException, InterruptedException, AWTException {
        int lineasOK=0;
        readExcelFile.readFileExcel();

        String identificacion = readExcelFile.excelArray.get(3).get(0);
        String msisdn = readExcelFile.excelArray.get(3).get(1);
        String imei = readExcelFile.excelArray.get(3).get(2);

        renoRepoControlPreciosActions.initialRute();
        renoRepoControlPreciosActions.ejecutaLaRenoRepo(msisdn,imei);
        consultarLineaActions.consultarEnPantallaUnica(msisdn,"");

        pagoEquiposActions.rutaInicial();
        pagoEquiposActions.pagarEquipo(identificacion,msisdn,renoRepoControlPreciosActions.idItem);
        consultarLineaActions.consultarEnPantallaUnicaResultadoFinal(msisdn,imei);
        lineasOK++;
        System.out.println("linea ok = "+ String.valueOf(lineasOK));

        for (int i= 4; i<readExcelFile.excelArray.size();i++){

            identificacion = readExcelFile.excelArray.get(i).get(0);
            msisdn = readExcelFile.excelArray.get(i).get(1);
            imei = readExcelFile.excelArray.get(i).get(2);

            renoRepoControlPreciosActions.secondRute();
            renoRepoControlPreciosActions.ejecutaLaRenoRepo(msisdn,imei);
            consultarLineaActions.consultarEnPantallaUnicaResultadoFinal(msisdn,"");

            pagoEquiposActions.rutaSecundaria();
            pagoEquiposActions.pagarEquipo(identificacion,msisdn,renoRepoControlPreciosActions.idItem);
            consultarLineaActions.consultarEnPantallaUnicaResultadoFinal(msisdn,imei);
            System.out.println("linea ok = "+ String.valueOf(lineasOK));
            lineasOK++;
        }

    }

    @When("^se hace el pago del equipo$")
    public void seHaceElPagoDelEquipo() {

/*        renoRepoControlPreciosActions.initialRute();
        renoRepoControlPreciosActions.ejecutaLaRenoRepo(dataExcelModels.getMsisdnPost(),dataExcelModels.getImei());
        consultarLineaActions.consultarEnPantallaUnica(dataExcelModels.getMsisdnPost(),"");
        pagoEquiposActions.rutaInicial();
        pagoEquiposActions.pagarEquipo(dataExcelModels.getIdentificacion(),dataExcelModels.getMsisdnPost(),renoRepoControlPreciosActions.idItem);
        consultarLineaActions.consultarEnPantallaUnicaResultadoFinal(dataExcelModels.getMsisdnPost(),dataExcelModels.getImei());*/


//       pagoEquiposActions.rutaInicial();
//       pagoEquiposActions.pagarEquipo(dataExcelModels.getIdentificacion(),dataExcelModels.getMsisdnPost(),renoRepoControlPreciosActions.idItem);
    }

    @Then("^se deberia ver el resultado de la consulta$")
    public void seDeberiaVerElResultadoDeLaConsulta() throws JSchException, InterruptedException, AWTException {
       //consultarLineaActions.consultarEnPantallaUnicaResultadoFinal(dataExcelModels.getMsisdnPost(),dataExcelModels.getImei());
    }


}



