package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestotomasyonuPage {

    public TestotomasyonuPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//*[@class='e-cart'])[1]")
    public WebElement accountButonu;

    @FindBy(id = "email")
    public WebElement emailKutusu;

    @FindBy(id = "password")
    public WebElement passwordKutusu;

    @FindBy(id = "submitlogin")
    public WebElement signInButonu;

    @FindBy(xpath = "(//*[text()='Logout'])[2]")
    public WebElement logoutButonu;

    @FindBy(id = "global-search")
    public WebElement aramaKutusu;

    @FindBy(xpath = "//*[@*='product-count-text']")
    public WebElement aramaSonucu;

}
