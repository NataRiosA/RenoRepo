package com.indra.models;

import com.indra.actions.ReadFileXLSXActions;

public class DataExcelModels {

    ReadFileXLSXActions fileXLSX = new ReadFileXLSXActions();

    String urlCRM;
    String user;
    String password;

    String identificacion;
    String imei;
    String msisdnPost;


    public String getImei() {
        fileXLSX.readFileExcel();
        imei = fileXLSX.excelArray.get(3).get(2);
        return imei;
    }

    public String getMsisdnPost() {
        fileXLSX.readFileExcel();
        msisdnPost = fileXLSX.excelArray.get(3).get(1);
        return msisdnPost;
    }


    public String getUrlCRM() {
        fileXLSX.readFileExcel();
        urlCRM = fileXLSX.excelArray.get(1).get(0);
        return urlCRM;
    }


    public String getUser() {
        fileXLSX.readFileExcel();
        user = fileXLSX.excelArray.get(1).get(1);
        return user;
    }

    public String getPassword() {
        fileXLSX.readFileExcel();
        password = fileXLSX.excelArray.get(1).get(2);
        return password;
    }

    public String getIdentificacion() {
        fileXLSX.readFileExcel();
        identificacion = fileXLSX.excelArray.get(3).get(0);
        return identificacion;
    }
}
