package com.indra.actions;

import com.indra.pages.RenoRepoControlPreciosPage;
import com.jcraft.jsch.JSchException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
public class RenoRepoControlPreciosActions extends RenoRepoControlPreciosPage {
    public String idItem="";
    public RenoRepoControlPreciosActions(WebDriver driver) {
        super(driver);
    }


    public void initialRute(){
        postSaleClick();
        transactionClick();
        lineModificationClick();
        renoRepoClick();
    }

    public void secondRute(){
        postSaleClick();
        renoRepoClick();
    }


    public void ejecutaLaRenoRepo(String phonenumber, String imei) throws InterruptedException, AWTException, JSchException {
        switchToIframe();
        writePhoneNumber(phonenumber);
        writeReasonForChange();
        waitABit(2000);
        selectBillingDepartment();
        waitABit(2000);
        selectBillingCity();
        selectTienda();
        waitABit(2000);
        writeImei(imei);
        waitABit(10000);
        btnChangeContractClick();
        alertAcept();
        waitABit(5000);

       /* WebElement idItemLabel = getDriver().findElement(By.xpath("(//span[@id='imeiChangeNewForm:panelActionButtons']//table)[2]/tbody[1]/tr[4]/td[1]"));
        System.out.println("---->  "+idItemLabel.getText());
        idItem = idItemLabel.getText();*/
        getMensajes().waitUntilPresent();
        idItem = getMensajes().getText();
        System.out.println(getMensajes().getText());
        waitABit(2000);
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

    public void writeImei(String imei){
        enter(imei).into(getImei());
        getImei().sendKeys(Keys.TAB);
    }

    public void switchToIframe(){
        WebElement iframe = getDriver().findElement(By.id("iframe"));
        getDriver().switchTo().frame(iframe);
    }

    public void writeReasonForChange(){
        enter("Prueba reno-repo").into(getMotivo());
    }


    public void selectBillingDepartment(){
        Select dropDownBillingDepartment= new Select(getDriver().findElement(By.name("imeiChangeNewForm:deptoField:j_id400")));
        dropDownBillingDepartment.selectByValue("28");
    }

    public void selectBillingCity(){
        waitABit(1000);
        Select dropDownBillingDepartment= new Select(getDriver().findElement(By.name("imeiChangeNewForm:ciudadField:j_id414")));
        dropDownBillingDepartment.selectByValue("1");
    }

    public void selectTienda(){
        Select dropDownVia= new Select(getDriver().findElement(By.name("imeiChangeNewForm:tiendaField:j_id428")));
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
