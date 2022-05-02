package com.indra.actions;

import com.indra.models.DataExcelModels;
import com.indra.pages.CesionPortalCRMPage;
import com.jcraft.jsch.JSchException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
public class RenoRepoContolPreciosActions extends CesionPortalCRMPage {
    public RenoRepoContolPreciosActions(WebDriver driver) {
        super(driver);
    }

    public void initialRute(){
        postSaleClick();
        transactionClick();
        lineModificationClick();
        renoRepoClick();
    }

    public void executeContractAssignment(String phonenumber, String imei) throws InterruptedException, AWTException, JSchException {
        switchToIframe();
        writePhoneNumber(phonenumber);
        waitABit(2000);
        writeReasonForChange();
        selectBillingDepartment();
        selectBillingCity();
        writeImei(imei);
        waitABit(2000);
        selectTienda();
        btnChangeContractClick();
        alertAcept();
        waitABit(10000);
        getMensajes().waitUntilPresent();
        System.out.println(getMensajes().getText());
    }

    public void postSaleClick(){
        getPostSale().click();
    }

    public void transactionClick(){
        getTransaction().click();
    }

    public void lineModificationClick(){
        getLineModification().click();
    }

    public void renoRepoClick(){
        getRenoRepo().click();
    }

    public void writePhoneNumber(String phonumber){
        enter(phonumber).into(getPhoneNumber());
        getPhoneNumber().sendKeys(Keys.TAB);
    }

    public void switchToIframe(){
        WebElement iframe = getDriver().findElement(By.id("iframe"));
        getDriver().switchTo().frame(iframe);
    }


    public void writeImei(String imei){
        enter(imei).into(getImei());
    }


    public void writeReasonForChange(){
        enter("Prueba reno-repo").into(getMotivo());
    }


    public void selectBillingDepartment(){
        Select dropDownBillingDepartment= new Select(getDriver().findElement(By.id("imeiChangeNewForm:deptoField:j_id400")));
        dropDownBillingDepartment.selectByValue("28");
    }

    public void selectBillingCity(){
        waitABit(1000);
        Select dropDownBillingDepartment= new Select(getDriver().findElement(By.id("imeiChangeNewForm:ciudadField:j_id414")));
        dropDownBillingDepartment.selectByValue("1");
    }

    public void selectTienda(){
        Select dropDownVia= new Select(getDriver().findElement(By.id("imeiChangeNewForm:tiendaField:j_id428")));
        dropDownVia.selectByValue("949");
    }


    public void btnChangeContractClick(){
        waitABit(1000);
        Actions actions = new Actions(getDriver());

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,420)"); //Scroll vertically down by 1000 pixels

        WebElement inventoryAllocation = getDriver().findElement(By.id("imeiChangeNewForm:j_id342"));
        actions.moveToElement(inventoryAllocation).click().build().perform();
    }

    public void alertAcept() {
        Alert alert = getDriver().switchTo().alert();
        alert.accept();

    }
}
