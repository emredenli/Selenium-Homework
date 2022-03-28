package com.kitapyurdu.page;

import com.kitapyurdu.methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage {

    Methods methods;

    public LoginPage() {
        methods = new Methods();
    }

    public void login() {
        methods.waitBySeconds(2);
        methods.click(By.cssSelector(".menu-top-button.login>a"));
        methods.waitBySeconds(2);
        methods.sendKeys(By.id("login-email"), "emre.denli@testinium.com");
        methods.sendKeys(By.id("login-password"), "1q2w3e4r5t");
        methods.waitBySeconds(2);
        methods.click(By.cssSelector(".ky-btn.ky-btn-orange.w-100.ky-login-btn"));
        Assert.assertTrue(methods.isElementVisible(By.cssSelector(".attention")));
        methods.waitBySeconds(2);
    }

}
