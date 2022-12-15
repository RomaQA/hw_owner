import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {
    @Test
    public void searchJUnit5(){
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $(".Box-row.wiki-more-pages-link button").click();
        $x("//a[contains(text(),'SoftAssertions')]").shouldBe(visible).click();
        $x("//h4[contains(text(),'3. Using JUnit5 extend test class:')]").shouldBe(visible);
        $x("//span[contains(text(),'ExtendWith')]").shouldBe(visible);
        $x("//span[contains(text(),'RegisterExtension')]").shouldBe(visible);
    }

}
