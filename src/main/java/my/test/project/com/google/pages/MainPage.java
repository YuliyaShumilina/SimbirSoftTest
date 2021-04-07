package my.test.project.com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public ResultPageWithCalculator findCalculator() {
        this.findText("Калькулятор");
        return new ResultPageWithCalculator(driver);
    }

    private void findText(String text) {
        WebElement inputElement = driver.findElement(By.xpath("//input[@name=\"q\"]"));
        inputElement.sendKeys(text);

        WebElement searchButton = driver.findElement(By.xpath("//input[@class=\"gNO89b\"]"));
        searchButton.submit();
    }
}
