package ru.yandex.practikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.practikum.pages.MakingOrder;

import static org.junit.Assert.assertEquals;

public class MakingOrderTest {
    private WebDriver driver;

    public WebDriver createDriver(String browser) {
        WebDriver webdriver = null;

        if (browser.equalsIgnoreCase("chrome")) {
            // Создаем экземпляр ChromeDriver
            webdriver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            // Создаем экземпляр FirefoxDriver
            webdriver = new FirefoxDriver();
        } else {
            System.out.println("Неподдерживаемый браузер: " + browser);
        }
        return webdriver;
    }

    @Before
    public void initialization() {
        driver = createDriver("chrome");
    }

    @Test
    public void createOrderOneTestSet(){
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MakingOrder order = new MakingOrder(driver);


        boolean actualResult = order.createOrderAfterClick("Никита", "Кордин", "Артельная 10А", "Бульвар Рокоссовского", "89101470050","1-е марта 2024 г.", "сутки", "black", "Нижняя");
        assertEquals(true, actualResult);
    }
    @Test
    public void createOrderTwoTestSet(){
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MakingOrder order = new MakingOrder(driver);
        boolean actualResult = order.createOrderAfterClick("Екатерина", "Первая", "Артельная 100А", "Черкизовская", "89101470050","2-е марта 2024 г.", "сутки", "black", "верхняя");
        assertEquals(true, actualResult);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}