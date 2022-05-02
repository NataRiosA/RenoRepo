package com.indra.actions;

import com.indra.models.DataExcelModels;
import com.indra.pages.PrepaidActivationPage;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrepaidActivationActions extends PrepaidActivationPage {

    public PrepaidActivationActions(WebDriver driver) {
        super(driver);
    }

    public void consultSingleScreen2(String msisdn){
        getDriver().switchTo().defaultContent();
        getConsult().click();
        getConsultPos().click();
        getConsultIntegral().click();
        getCosultaPantallaUnica().click();
        WebElement iframe = getDriver().findElement(By.id("iframe"));
        getDriver().switchTo().frame(iframe);
        enter(msisdn).into(getMsisdn2());
        getSearchButton().click();
        getGeneralCustomerInformation().waitUntilPresent();
        WebElement plan = getDriver().findElement(By.id("j_id135:j_id161"));

        MatcherAssert.assertThat("el plan es Postpago",
                plan.getText(),Matchers.containsString("Pospago 5.") );
    }

}
