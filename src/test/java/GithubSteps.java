import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class GithubSteps {

    @Step("Открыть главную страницу Github")
    public GithubSteps openMainPage() {
        open("https://github.com");
        return this;
    }

    @Step("Найти репозиторий [{repositoryName}]")
    public GithubSteps findRepository(String repositoryName) {
        $(".header-search-input").setValue(repositoryName).submit();
        return this;
    }

    @Step("Перейти в репозиторий [{repositoryName}]")
    public GithubSteps goToRepository(String repositoryName) {
        $(linkText(repositoryName)).click();
        return this;
    }

    @Step("Открыть раздел Issues")
    public GithubSteps openIssuesSection() {
        $(partialLinkText("Issues")).click();
        return this;
    }

    @Step("Проверить, что Issue c названием [{issueName}] существует")
    public GithubSteps checkIssueWithNameExists(String issueName) {
        $(byText(issueName)).should(Condition.visible);
        return this;
    }
}
