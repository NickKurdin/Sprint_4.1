package ru.yandex.practikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakingOrder {
    private final WebDriver driver;

    public MakingOrder(WebDriver browser){
        driver = browser;
    }

    //Поле ввода "Имя"
    By firstNameUserForOrder = By.xpath(".//input[@placeholder='* Имя']");
    //Поле ввода "Фамилия"
    By lastNameUserForOrder = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле ввода "Адрес"
    By addressUserForOrder = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле ввода "Станция метро"
    By subwayStationUserForOrder = By.xpath(".//div[@class='select-search']/div[@class='select-search__value']/input[@placeholder='* Станция метро']");
    //Поле ввода "Телефон"
    By phoneNumberUserForOrder = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка "Далее"
    By buttonNext = By.xpath(".//button[text()='Далее']");
    //Кнопка "Заказать"
    By buttonForOrder = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    //Кнопка "Да"
    By buttonConfirmForOrder = By.xpath(".//button[text()='Да']");
    //Заголовок "Заказ оформлен"
    By headerCreatedOrder = By.xpath(".//div[text()='Заказ оформлен']");
    //Кнопка "Принять куки"
    By buttonAcceptCookie = By.cssSelector(".App_CookieButton__3cvqF");
    //Поле "Когда привезти заказ"
    By whenBringOrder = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    public boolean createOrderAfterClick(String firstName, String lastName, String address, String subwayStation, String phoneNumber, String deliveryDate, String termRent, String colourScooter, String button) {
        if (button.equals("Нижняя")) {
            WebElement element = driver.findElement(By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            driver.findElement(By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']")).click();
        }

        if (!button.equals("Нижняя")){
            driver.findElement(By.xpath(".//button[@class='Button_Button__ra12g']")).click();
        }
        driver.findElement(buttonAcceptCookie).click();
        driver.findElement(firstNameUserForOrder).sendKeys(firstName);
        driver.findElement(lastNameUserForOrder).sendKeys(lastName);
        driver.findElement(addressUserForOrder).sendKeys(address);
        driver.findElement(subwayStationUserForOrder).click();
        new WebDriverWait(driver, 3).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[text()='" + subwayStation + "']")));
        driver.findElement(By.xpath(".//div[text()='" + subwayStation + "']")).click();
        driver.findElement(phoneNumberUserForOrder).sendKeys(phoneNumber);
        driver.findElement(buttonNext).click();
        driver.findElement(whenBringOrder).click();
        driver.findElement(By.xpath(".//div[contains(@aria-label,'" + deliveryDate + "')]")).click();
        driver.findElement(By.xpath(".//div[text()='* Срок аренды']")).click();
        driver.findElement(By.xpath(".//div[@class='Dropdown-option' and text()='" + termRent + "']")).click();
        driver.findElement(By.xpath(".//input[@id='" + colourScooter + "']")).click();
        driver.findElement(buttonForOrder).click();
        driver.findElement(buttonConfirmForOrder).click();
        return driver.findElement(headerCreatedOrder).isDisplayed();
    }

}