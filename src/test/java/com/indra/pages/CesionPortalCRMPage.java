package com.indra.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class CesionPortalCRMPage extends PageObject {
    public CesionPortalCRMPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//a[@class='TabIcon DefaultPageIcon'][contains(.,'Postventa')]")
    WebElementFacade postSale;

    @FindBy(xpath = "//img[@id='pbGf5a1f4f3_2d5ecc_2d4e4a_2d8654_2d6459a01c3953:_viewRoot:j_id4:j_id10:j_id11:0::j_id12:handle:img:collapsed']" )
    WebElementFacade transaction;

    @FindBy(xpath = "//img[@id='pbGf5a1f4f3_2d5ecc_2d4e4a_2d8654_2d6459a01c3953:_viewRoot:j_id4:j_id10:j_id11:0:1::j_id14:handle:img:collapsed']" )
    WebElementFacade lineModification;

    @FindBy(xpath = "//*[@id='pbGf5a1f4f3_2d5ecc_2d4e4a_2d8654_2d6459a01c3953:_viewRoot:j_id4:j_id10:j_id11:0:1:7::j_id17']")
    WebElementFacade renoRepo;

    @FindBy(id ="imeiChangeNewForm:msisdnField:msisdn" )
    WebElementFacade phoneNumber;

    @FindBy(id ="imeiChangeNewForm:imeiField:imei\n" )
    WebElementFacade imei ;

    @FindBy(id ="imeiChangeNewForm:reasonField:reason" )
    WebElementFacade motivo;

    @FindBy(xpath = "//*[@id='cesionContratoForm:panelAns']")
    WebElementFacade mensajes;



    public WebElementFacade getMensajes() {
        return mensajes;
    }


    public WebElementFacade getPostSale() {
        return postSale;
    }

    public WebElementFacade getTransaction() {
        return transaction;
    }

    public WebElementFacade getLineModification() {
        return lineModification;
    }

    public WebElementFacade getRenoRepo() {
        return renoRepo;
    }

    public WebElementFacade getPhoneNumber() {
        return phoneNumber;
    }



    public WebElementFacade getImei() {
        return imei;
    }


    public WebElementFacade getMotivo() {
        return motivo;
    }


}