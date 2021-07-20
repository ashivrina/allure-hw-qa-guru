import org.junit.jupiter.api.Test;

public class IssueNameTestWithAnnotatedSteps {

    private final GithubSteps githubSteps = new GithubSteps();

    @Test
    void checkIssueNameWithAnnotated() {
        githubSteps
                .openMainPage()
                .findRepository(Constants.REPOSITORY)
                .goToRepository(Constants.REPOSITORY)
                .openIssuesSection()
                .checkIssueWithNameExists(Constants.ISSUE_NAME);
    }
}
