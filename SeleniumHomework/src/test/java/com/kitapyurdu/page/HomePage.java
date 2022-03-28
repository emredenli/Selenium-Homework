package com.kitapyurdu.page;

import com.kitapyurdu.methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    Methods methods;

    public HomePage() {
        methods = new Methods();
    }

    public void home(){

        methods.click(By.cssSelector(".logo-icon"));
        methods.waitBySeconds(3);
        /*
        methods.waitBySeconds(3);
        Assert.assertTrue(methods.isElementVisible(By.xpath("//div[@class='logo-icon']")));

         */
    }

}
