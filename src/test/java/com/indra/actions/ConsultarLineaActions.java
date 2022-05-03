package com.indra.actions;

import com.indra.pages.ConsultarLineaPages;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConsultarLineaActions extends ConsultarLineaPages {

    public ConsultarLineaActions(WebDriver driver) {
        super(driver);
    }

    public void consultarEnPantallaUnica(String msisdn,String imei){
        switchToDefaultContent();
        clickConsultar();
        clickConsultarPos();
        clickConsultaIntegral();
        clickConsultaPantallaUnica();
        switchToFrame();
        ingresaElMsisdn(msisdn);
        clickEnElBotonBuscar();
        matcherIMEI(imei);
    }

    public void consultarEnPantallaUnicaResultadoFinal(String msisdn,String imei){
        switchToDefaultContent();
        clickConsultar();
        clickConsultaPantallaUnica();
        switchToFrame();
        ingresaElMsisdn(msisdn);
        clickEnElBotonBuscar();
        matcherIMEI(imei);
    }

    public void clickConsultar(){
        getConsult().click();
    }

    public void clickConsultarPos(){
        getConsultPos().click();
    }

    public void clickConsultaIntegral() {
        getConsultIntegral().click();
    }

    public void clickConsultaPantallaUnica(){
        getCosultaPantallaUnica().click();
    }

    public void ingresaElMsisdn(String msisdn){
        enter(msisdn).into(getMsisdn2());
    }

    public void clickEnElBotonBuscar(){
        getSearchButton().click();
    }

    public void matcherIMEI(String imei){
        getGeneralCustomerInformation().waitUntilVisible();
        scrollDown("820");
        waitABit(1200);
       // WebElement etiquetaImei = getDriver().findElement(By.id("j_id135:j_id206")); //j_id135:j_id190

        MatcherAssert.assertThat("la linea no tiene imei",
                getEtiquetaImei().getText(), Matchers.containsString(imei));
        switchToDefaultContent();
    }


    public void switchToFrame(){
        WebElement iframe = getDriver().findElement(By.id("iframe"));
        getDriver().switchTo().frame(iframe);
    }
    public void switchToDefaultContent(){
        getDriver().switchTo().defaultContent();
    }
    public void scrollDown(String cantidadPixeles){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,"+cantidadPixeles+")");
        js.executeScript("window.scrollBy(0,"+cantidadPixeles+")");
    }

}
