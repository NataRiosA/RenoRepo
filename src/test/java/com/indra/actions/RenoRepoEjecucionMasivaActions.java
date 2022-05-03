package com.indra.actions;

import com.jcraft.jsch.JSchException;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class RenoRepoEjecucionMasivaActions extends PagoEquiposActions{

    public RenoRepoEjecucionMasivaActions(WebDriver driver) {
        super(driver);
    }

    ReadFileXLSXActions readExcelFile = new ReadFileXLSXActions();
    PagoEquiposActions pagoEquipos = new PagoEquiposActions(getDriver());
    ConsultarLineaActions consultarLinea = new ConsultarLineaActions(getDriver());
    RenoRepoControlPreciosActions renoRepoControlPreciosActions = new RenoRepoControlPreciosActions(getDriver());

    public void ciclo() throws JSchException, InterruptedException, AWTException {
        readExcelFile.readFileExcel();

        String identificacion = readExcelFile.excelArray.get(3).get(0);
        String msisdn = readExcelFile.excelArray.get(3).get(1);
        String imei = readExcelFile.excelArray.get(3).get(2);

        //System.out.println(readExcelFile.excelArray.size());

        renoRepoControlPreciosActions.initialRute();
        renoRepoControlPreciosActions.ejecutaLaRenoRepo(msisdn,imei);
        consultarLinea.consultarEnPantallaUnica(msisdn,"");

        pagoEquipos.rutaInicial();
        pagoEquipos.pagarEquipo(identificacion,msisdn,renoRepoControlPreciosActions.idItem);
        consultarLinea.consultarEnPantallaUnica(msisdn,imei);

       for (int i= 4; i<readExcelFile.excelArray.size();i++) {
           identificacion = readExcelFile.excelArray.get(i).get(0);
           msisdn = readExcelFile.excelArray.get(i).get(1);
           imei = readExcelFile.excelArray.get(i).get(2);
           //System.out.println(identificacion+"  "+msisdn+"  "+imei);

            renoRepoControlPreciosActions.secondRute();
            renoRepoControlPreciosActions.ejecutaLaRenoRepo(msisdn,imei);
            consultarLinea.consultarEnPantallaUnicaResultadoFinal(msisdn,"");

            pagoEquipos.rutaInicial();
            pagoEquipos.pagarEquipo(identificacion,msisdn,renoRepoControlPreciosActions.idItem);
            consultarLinea.consultarEnPantallaUnicaResultadoFinal(msisdn,imei);

        }
    }
}
