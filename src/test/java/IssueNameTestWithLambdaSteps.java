import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class IssueNameTestWithLambdaSteps {

   @Test
    public void checkIssueNameWithLambda() {
       step("Открыть главную страницу Github",
               () -> open("https://github.com"));
       step("Найти репозиторий " + Constants.REPOSITORY,
               () -> $(".header-search-input").setValue(Constants.REPOSITORY).submit());
       step("Перейти в репозиторий " + Constants.REPOSITORY,
               () -> $(linkText(Constants.REPOSITORY)).click());
       step("Открыть раздел Issues",
               () -> $(partialLinkText("Issues")).click());
       step(String.format("Проверить, что Issue c названием %s существует", Constants.ISSUE_NAME),
               () -> $(byText(Constants.ISSUE_NAME)).should(Condition.visible));
   }
}
