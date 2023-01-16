import config.WebDriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebDriverTest {

    private WebDriver driver;

    @BeforeEach
    public void startDriver(){
        driver=new WebDriverProvider().get();
    }

    @Test
    public void testGitHub(){
        String title = driver.getTitle();
        assertEquals("GitHub: Let’s build from here · GitHub", title);
    }

    @AfterEach
    public void stopDriver(){
        driver.quit();
    }



    @Test
    public void gitHubTest(){
        open("https://github.com/");
        $x("//button[contains(text(),'Solution')]").hover();
        $x("//a[contains(@class, 'HeaderMenu-dropdown-link')][contains(text(),'Enterprise')]").click();
        $x("//div[contains(@class,'col-9-max')]/h1[contains(text(),'Build like the best')]").shouldBe(visible);
    }

    @Test
    public void drugAndDropTest(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo($("#column-b"));
        $x("//div[@id='column-a']/header[normalize-space()='B']").shouldBe(visible);
    }
}
