package ru.yandex.practikum.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ImportantQuestions {
    private final WebDriver driver;
    //Конструктор класса
    public ImportantQuestions(WebDriver browser){
        driver = browser;
    }

    //Нажать на вопрос
    public String checkAnswerOnTheQuestion(String question, String expectedAnswer){
        WebElement element = driver.findElement(By.xpath(".//div[text()='" + question + "']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.xpath(".//div[text()='" + question + "']")).click();
        return driver.findElement(By.xpath(".//p[text()='" + expectedAnswer + "']")).getText();
    }

}