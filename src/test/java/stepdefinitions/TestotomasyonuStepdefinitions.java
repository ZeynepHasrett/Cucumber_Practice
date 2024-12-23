package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

import javax.swing.*;

public class TestotomasyonuStepdefinitions {

    TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

    @Given("kullanici testotomasyonu ana sayfasina gider")
    public void kullanici_testotomasyonu_ana_sayfasina_gider() {
        Driver.getDriver().get("https://www.testotomasyonu.com");
    }
    @When("account butonuna tiklar")
    public void account_butonuna_tiklar() {
        testotomasyonuPage.accountButonu.click();
    }
    @And("gecerli email ve gecerli sifre girer")
    public void gecerli_email_ve_gecerli_sifre_girer() {
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
    }
    @And("sign in butonuna tiklar")
    public void sign_in_butonuna_tiklar() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        testotomasyonuPage.signInButonu.click();
    }
    @Then("basarili bir sekilde giris yapildigini test eder")
    public void basarili_bir_sekilde_giris_yapildigini_test_eder() {
        Assertions.assertTrue(testotomasyonuPage.logoutButonu.isDisplayed());
    }

    @And("gecersiz email ve gecersiz sifre girer")
    public void gecersizEmailVeGecersizSifreGirer() {
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
    }

    @Then("giris yapilamadigini test eder")
    public void girisYapilamadiginiTestEder() {
        Assertions.assertTrue(testotomasyonuPage.emailKutusu.isDisplayed());
    }

    @And("logout butonuna basarak cikis yapar")
    public void logoutButonunaBasarakCikisYapar() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        testotomasyonuPage.logoutButonu.click();
    }

    @And("sayfayi kapatir")
    public void sayfayiKapatir() {
        Driver.quitDriver();
    }

    @When("arama kutusuna {string} yazip aratir")
    public void aramaKutusunaYazipAratir(String aranacakKelime) {
        testotomasyonuPage.aramaKutusu.sendKeys(aranacakKelime + Keys.ENTER);
    }

    @Then("arama sonucunda urun bulunabildigini test eder")
    public void aramaSonucundaUrunBulunabildiginiTestEder() {
        String unexpectedSonuc = ConfigReader.getProperty("toUnexpectedSonuc");
        String actualSonuc = testotomasyonuPage.aramaSonucu.getText();

        Assertions.assertNotEquals(unexpectedSonuc, actualSonuc);
    }
}
