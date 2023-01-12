import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {
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
