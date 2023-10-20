package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class Steps {

    @Step("Открыть глвную страницу ")
    public void openMainPage(String baseUrl) {
        open(baseUrl);
    }

    @Step("Ввести в строку поиска {searchValue}, нажать Enter")
    public void search(String searchValue, String locator, String search) {
        $(locator).click();
        $(search).setValue(searchValue).pressEnter();
    }

    @Step("Перейти в репозиторий {searchValue}")
    public void openRepositories(String searchValue) {
        $(linkText(searchValue)).click();
    }

    @Step("Открыть вкладку Issue")
    public void openIssue() {
        $("#issues-tab").click();
    }

    @Step("На странице имеется Issue, заголовок которой =  {issuesTitle}")
    public void checkTitleIssue(String issuesTitle) {
        $(withText(issuesTitle)).should(Condition.exist);
    }

}

