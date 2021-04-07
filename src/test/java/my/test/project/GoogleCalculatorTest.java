package my.test.project;

import my.test.project.com.google.pages.MainPage;
import my.test.project.com.google.pages.ResultPageWithCalculator;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GoogleCalculatorTest {
    private static WebDriver driver;
    private static MainPage mainPage;
    private ResultPageWithCalculator resultPageWithCalculator;

    @BeforeClass
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        mainPage = new MainPage(driver);
    }

    @Before
    public void setUp() {
        driver.get("http://google.com");
        resultPageWithCalculator = mainPage.findCalculator();
    }

    @Test
    public void testCorrectCalculation() {
        resultPageWithCalculator.inputCalcText("(1 + 2) * 3 - 40 / 5");
        Assert.assertEquals("(1 + 2) × 3 - 40 ÷ 5 =", resultPageWithCalculator.getMemoryText());
        Assert.assertEquals("1", resultPageWithCalculator.getResultText());
    }

    @Test
    public void testZeroDevide() {
        resultPageWithCalculator.inputCalcText("6 / 0");
        Assert.assertEquals("6 ÷ 0 =", resultPageWithCalculator.getMemoryText());
        Assert.assertEquals("Infinity", resultPageWithCalculator.getResultText());
    }

    @Test
    public void testIncorrectSin() {
        resultPageWithCalculator.inputCalcText("sin");
        Assert.assertEquals("sin() =", resultPageWithCalculator.getMemoryText());
        Assert.assertEquals("Error", resultPageWithCalculator.getResultText());
    }

    @AfterClass
    public static void finish() {
        driver.close();
    }
}
