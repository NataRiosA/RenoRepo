package com.indra.models;

import com.indra.actions.ReadFileXLSXActions;

public class DataExcelModels {

    ReadFileXLSXActions fileXLSX = new ReadFileXLSXActions();

    String imei;
    String urlCRM;
    String cedulaClientePrepago;
    String msisdnPrepago;

    String user;
    String password;


    public String getCedulaClientePrepago() {
        fileXLSX.readFileExcel();
        cedulaClientePrepago = fileXLSX.excelArray.get(8).get(1);
        return cedulaClientePrepago;
    }

    public String getMsisdnPrepago() {
        fileXLSX.readFileExcel();
        msisdnPrepago = fileXLSX.excelArray.get(8).get(2);
        return msisdnPrepago;
    }


    public String getUrlCRM() {
        fileXLSX.readFileExcel();
        urlCRM = fileXLSX.excelArray.get(0).get(1);
        return urlCRM;
    }


    public String getUser() {
        fileXLSX.readFileExcel();
        user = fileXLSX.excelArray.get(1).get(5);
        return user;
    }

    public String getPassword() {
        fileXLSX.readFileExcel();
        password = fileXLSX.excelArray.get(1).get(6);
        return password;
    }
}
