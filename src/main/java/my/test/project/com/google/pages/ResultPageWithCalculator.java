package my.test.project.com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultPageWithCalculator {
    private WebDriver driver;

    public ResultPageWithCalculator(WebDriver driver) {
        this.driver = driver;
    }

    public void inputCalcText(String text) {
        WebElement calcInputElement = driver.findElement(By.xpath("//div[@class=\"jlkklc\"]"));
        calcInputElement.sendKeys(text);
        calcInputElement.sendKeys(Keys.ENTER);
    }

    public String getMemoryText() {
        WebElement memoryElement = driver.findElement(By.xpath("//span[@jsname=\"ubtiRe\"]"));
        return memoryElement.getText();
    }

    public String getResultText() {
        WebElement resultElement = driver.findElement(By.xpath("//span[@jsname=\"VssY5c\"]"));
        return resultElement.getText();
    }
}
