package com.kitapyurdu.test;

import com.kitapyurdu.driver.BaseTest;
import com.kitapyurdu.page.HomePage;
import com.kitapyurdu.page.LoginPage;
import com.kitapyurdu.page.ProductPage;
import org.junit.Test;

public class ExampleTest extends BaseTest {

    @Test
    public void exampleTest() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage(driver);

        homePage.home();
        loginPage.login();
        productPage.selectProduct();
        productPage.addFavorite();
        homePage.home();
        productPage.pointsCatalog();
        productPage.selectTurkishClassic();
        productPage.filtering();
        productPage.allBook();
        productPage.randomProduct();
        productPage.addToBasket();
        productPage.myLists();
        productPage.removeElement();
        productPage.basket();
        productPage.productNumber();
        productPage.buy();
        productPage.addAddress();
        productPage.cartPay();
        homePage.home();
        productPage.logOut();
    }


}
