import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class IssueNameTest {

    @Test
    public void checkIssueNameTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $(".header-search-input").setValue(Constants.REPOSITORY).submit();
        $(linkText(Constants.REPOSITORY)).click();
        $(partialLinkText("Issues")).click();
        $(byText(Constants.ISSUE_NAME)).should(Condition.visible);
    }
}
