package com.kitapyurdu.page;

import com.kitapyurdu.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.*;


public class ProductPage {
    Methods methods;
    WebDriver driver;
    Logger logger = LogManager.getLogger(ProductPage.class);

    public ProductPage(WebDriver driver) {
        this.methods = new Methods();
        this.driver = driver;
    }

    public void selectProduct() {

        methods.sendKeys(By.xpath("//input[@id='search-input']"), "Oyuncak");
        methods.waitBySeconds(3);
        methods.click(By.cssSelector(".common-sprite.button-search"));

        List<WebElement> items = driver.findElements(By.cssSelector(".product-list>.product-cr"));
        long listCount = items.stream().count();
        if (listCount >= 7) {
            String currentItemId = items.get(6).getAttribute("id");
            String navigationItemId = ".product-list>#" + currentItemId;
            methods.scrollWithAction(By.cssSelector(navigationItemId));
        } else if (listCount > 0 && listCount < 7) {
            String currentItemId = items.get(0).getAttribute("id");
            String navigationItemId = ".product-list>#" + currentItemId;
            methods.scrollWithAction(By.cssSelector(navigationItemId));
        }

        methods.waitBySeconds(3);

    }

    public void addFavorite() {

        List<WebElement> items = driver.findElements(By.cssSelector(".product-list>.product-cr>.grid_2>.hover-menu>.add-to-favorites"));

        for (int i = 0; i < 4; i++) {
            items.get(i).click();
            methods.waitBySeconds(2);
        }
    }

    public void pointsCatalog() {
        methods.click(By.cssSelector(".lvl1catalog"));
        methods.waitBySeconds(3);
    }

    public void selectTurkishClassic() {
        List<WebElement> items = driver.findElements(By.cssSelector("img.landing-button"));
        items.get(1).click();
        methods.waitBySeconds(3);
    }

    public void filtering() {
        methods.selectByText(By.cssSelector(".product-filter-header>.sort>select"), "Yüksek Oylama");
        methods.waitBySeconds(3);
    }

    public void allBook() {

        List<WebElement> items = driver.findElements(By.cssSelector(".book.has-menu.active>.lvl2.js-bookCr>.js-ajaxCt.js-bookCt>li"));
        items.get(2).click();
        methods.waitBySeconds(2);
        List<WebElement> itm = driver.findElements(By.cssSelector(".open-menu-ct.bookAllCategories>.subCategories>ul>li>.mn-icon.icon-angleRight"));
        itm.get(22).click();

    }

    public void randomProduct() {
        Random random = new Random();
        List<WebElement> items = driver.findElements(By.cssSelector(".pr-img-link"));
        int value = items.size();
        items.get(random.nextInt(value)).click();
        methods.waitBySeconds(2);
    }

    public void addToBasket() {
        methods.click(By.cssSelector("#button-cart"));
        methods.waitBySeconds(2);
    }

    public void myLists() {
        methods.click(By.cssSelector(".menu.top.my-list>ul>li>a"));
        methods.waitBySeconds(2);

        methods.click(By.cssSelector(".menu.top.my-list>ul>li>div>ul>li>a"));
        methods.waitBySeconds(2);
    }

    public void removeElement() {
        List<WebElement> items = driver.findElements(By.cssSelector(".product-grid>.product-cr"));
        items.get(2).click();
        methods.waitBySeconds(2);
        methods.click(By.id("product-detail-favorite-product-div"));
        methods.waitBySeconds(2);
    }

    public void basket() {
        methods.click(By.cssSelector(".heading"));
        methods.waitBySeconds(2);
        methods.click(By.cssSelector((".checkout.fl>.mg-b-5")));
        methods.waitBySeconds(2);
    }

    public void productNumber() {
        methods.click(By.cssSelector(".quantity>.js-cart-update-product"));
        methods.waitBySeconds(2);

        /*
        WebElement change = methods.findElement(By.cssSelector(".quantity>.js-cart-update-product"));
        change.sendKeys("2");
        methods.waitBySeconds(2);

         */
    }

    public void buy() {
        methods.click(By.cssSelector(".to-wishlist"));
        methods.waitBySeconds(2);
    }

    public void addAddress() {

        methods.click(By.xpath("//*[@id=\"shipping-tabs\"]/a[2]"));
        methods.waitBySeconds(2);

        //methods.click(By.xpath("//*[@id=\"shipping-new\"]/table/tbody/tr[1]/td[2]/input[2]"));
        methods.click(By.xpath("//*[@id=\"shipping-new\"]/table/tbody/tr[1]/td[2]/input[1]"));
        WebElement name = methods.findElement(By.id("address-firstname-companyname"));
        name.sendKeys("Emre");
        methods.waitBySeconds(1);
        WebElement surname = methods.findElement(By.id("address-lastname-title"));
        surname.sendKeys("Denli");
        methods.waitBySeconds(1);
        Select drpCountry = new Select(methods.findElement(By.id("address-country-id")));
        drpCountry.selectByVisibleText("Türkiye");
        methods.waitBySeconds(1);
        Select drpCity = new Select(methods.findElement(By.id("address-zone-id")));
        drpCity.selectByVisibleText("Manisa");
        methods.waitBySeconds(2);
        Select drpTown = new Select(methods.findElement(By.xpath("//*[@id=\"address-county-id\"]")));
        drpTown.selectByVisibleText("YUNUSEMRE");
        methods.waitBySeconds(2);
        WebElement neighborhood = methods.findElement(By.id("district"));
        neighborhood.sendKeys("Merkezefendi Mah.");
        methods.waitBySeconds(1);
        WebElement detailAddress = methods.findElement(By.id("address-address-text"));
        detailAddress.sendKeys("Merkezefendi Mah. 3916 Sk.");
        methods.waitBySeconds(1);
        WebElement postCode = methods.findElement(By.id("address-postcode"));
        postCode.sendKeys("45125");
        methods.waitBySeconds(1);
        WebElement landTelephone = methods.findElement(By.id("address-telephone"));
        landTelephone.sendKeys("5548657092");
        methods.waitBySeconds(1);
        WebElement mobilePhone = methods.findElement(By.id("address-mobile-telephone"));
        mobilePhone.sendKeys("5548657092");
        //WebElement taxAdministration = methods.findElement(By.id("address-company-id"));
        //taxAdministration.sendKeys("abcVergi");
        WebElement tcId = methods.findElement(By.id("address-tax-id"));
        tcId.sendKeys("25364301532");
        methods.waitBySeconds(1);

        methods.click(By.cssSelector("div>#button-checkout-continue"));
        methods.waitBySeconds(1);

        methods.click(By.xpath("//*[@id=\"button-checkout-continue\"]"));
        methods.waitBySeconds(1);
    }

    public void cartPay() {

        methods.click(By.xpath("//*[@id=\"credit-card-owner\"]"));
        WebElement name = methods.findElement(By.id("credit-card-owner"));
        name.sendKeys("Emre Denli");
        methods.waitBySeconds(1);

        methods.click(By.xpath("//*[@id=\"credit_card_number_1\"]"));
        WebElement n1 = methods.findElement(By.id("credit_card_number_1"));
        n1.sendKeys("4230");
        methods.click(By.xpath("//*[@id=\"credit_card_number_2\"]"));
        WebElement n2 = methods.findElement(By.id("credit_card_number_2"));
        n2.sendKeys("9142");
        methods.click(By.xpath("//*[@id=\"credit_card_number_3\"]"));
        WebElement n3 = methods.findElement(By.id("credit_card_number_3"));
        n3.sendKeys("1486");
        methods.click(By.xpath("//*[@id=\"credit_card_number_4\"]"));
        WebElement n4 = methods.findElement(By.id("credit_card_number_4"));
        n4.sendKeys("7216");
        methods.waitBySeconds(1);

        Select month = new Select(methods.findElement(By.xpath("//*[@id=\"credit-card-expire-date-month\"]")));
        month.selectByVisibleText("07");

        Select year = new Select(methods.findElement(By.xpath("//*[@id=\"credit-card-expire-date-year\"]")));
        year.selectByVisibleText("2024");
        methods.waitBySeconds(1);

        WebElement safe = methods.findElement(By.cssSelector("input#credit-card-security-code"));
        safe.sendKeys("121");
        methods.waitBySeconds(1);

        methods.click(By.xpath("//*[@id=\"button-checkout-continue\"]"));
        methods.waitBySeconds(1);

    }

    public void logOut() {
        methods.mouse(By.cssSelector(".welcome.fl>.menu.top.login"));

        List<WebElement> items = driver.findElements(By.cssSelector(".welcome.fl>.menu.top.login>ul>li>div>ul>li"));
        items.get(3).click();
        methods.waitBySeconds(1);
    }

}
