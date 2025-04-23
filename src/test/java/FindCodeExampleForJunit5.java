import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FindCodeExampleForJunit5 {
    @BeforeAll
    static void setupEnvironment() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = "chrome";

    }
    @Test
    void shouldFindCodeExample() {
        open("https://github.com/");
        $("[placeholder='Search or jump to...']").click();
        $( "#query-builder-test").setValue("selenide").pressEnter();
        $(".Box-sc-g0xbh4-0.JcuiZ h3 a").shouldHave(text("selenide/selenide")).click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
        $("#wiki-tab").shouldBe(visible).click();
        $("#wiki-body").shouldHave(text("Soft assertions"));
        $("#wiki-body").$(byText("Soft assertions")) .click();
        $("#wiki-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
}
}
