package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.ComboBoxElement;
import com.vaadin.testbench.elements.FormLayoutElement;
import com.vaadin.testbench.elements.GridElement;
import com.vaadin.testbench.elements.TextFieldElement;

public class IntegrationTestSkill extends TestBenchTestCase {

    private static final String URL = "http://localhost:8080/test-vaadin8/#!region";

    //    @BeforeClass
    //    public static void setUpBeforeClass() throws Exception {
    //    }
    //
    //    @AfterClass
    //    public static void tearDownAfterClass() throws Exception {
    //    }

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Projets\\Git\\test-vaadin8\\lib\\chromedriver-2.27.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary(
                "C:\\ProgramData\\Microsoft\\AppV\\Client\\Integration\\4FAEA13D-E25D-4A1A-9881-47E9123774DB\\Root\\Application\\chrome.exe");
        setDriver(new ChromeDriver(chromeOptions));

        //        System.setProperty("webdriver.gecko.driver", "C:\\Projets\\Git\\test-vaadin8\\lib\\geckodriver.exe");
        //        FirefoxBinary binary = new FirefoxBinary(new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"));
        //        setDriver(new FirefoxDriver(binary, new FirefoxProfile()));

        getDriver().get(URL);
    }

    @After
    public void tearDown() throws Exception {
        if (getDriver() != null) {
            getDriver().quit();
        }

    }

    @Test
    public void test() {
        ButtonElement skillButton = $(ButtonElement.class).caption("Skill").first();
        skillButton.click();

        Assert.assertTrue($(GridElement.class).exists());

        // 1. Find the grid
        GridElement grid = $(GridElement.class).first();

        // 2. Store the name and ability values shown
        // in the first row of the grid for later comparison
        String name = grid.getCell(0, 0).getText();
        String ability = grid.getCell(0, 1).getText();

        // 3. Click on the first row
        grid.getCell(0, 0).click();

        // 4. Assert that the values in the name and ability fields are the same as in the grid
        Assert.assertEquals(name, $(FormLayoutElement.class).first().$(TextFieldElement.class).caption("Nom").first().getValue());
        Assert.assertEquals(ability, $(FormLayoutElement.class).first().$(ComboBoxElement.class).caption("Attribut clé").first().getValue());
    }

}
