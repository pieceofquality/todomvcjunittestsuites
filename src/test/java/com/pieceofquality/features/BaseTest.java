package com.pieceofquality.features;

import com.codeborne.selenide.Configuration;
import org.junit.After;

import static com.codeborne.selenide.Selenide.executeJavaScript;


public class BaseTest {

    static {
        Configuration.browser = System.getProperty("driver.browser");
    }

    @After
    public void clearData(){
        executeJavaScript("localStorage.clear()");
    }


}
