package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class TitleIssuesTest extends  TestBase {

    private static final String searchValue = "microsoft/Microsoft365DSC";
    private static final String baseUrl = "https://github.com/";
    private static final String locator = ".search-input-container";
    private static final String search = "#query-builder-test";
    private static final String issuesTitle = "AADUser: Add support for MemberOf";

    @Test
    @Feature("Поиск в репозитории")
    @Story("Поиск в репозитории allure")
    @Owner("Meschikowa")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "github", url = "https://github.com/microsoft/Microsoft365DSC/issues")
    @DisplayName("Проверка Issue в репозитории microsoft/Microsoft365DSC")
    void titleIssuesSelenidTest (){
        open(baseUrl);
        $(locator).click();
        $(search).setValue(searchValue).pressEnter();
        $(linkText(searchValue)).click();
        $("#issues-tab").click();
        $(withText(issuesTitle)).should(Condition.exist);

    }

    @Test
    @Feature("Поиск в репозитории")
    @Story("Поиск в репозитории allure")
    @Owner("Meschikowa")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "github", url = "https://github.com/microsoft/Microsoft365DSC/issues")
    @DisplayName("Проверка Issue в репозитории microsoft/Microsoft365DSC")
    void titleIssuesLambdaTest (){
        step("Открыть глвную страницу " + baseUrl, () ->
        {
            open(baseUrl);
        });

        step("Ввести в строку поиска " + searchValue + " нажать Enter", () ->
        {
            $(locator).click();
            $(search).setValue(searchValue).pressEnter();
        });

        step("Перейти в репозиторий "+ searchValue, () ->
        {
            $(linkText(searchValue)).click();
        });

        step("Открыть вкладку Issue", () ->
        {
            $("#issues-tab").click();
        });

        step("На странице имеется Issue, заголовок которой равен " + issuesTitle, () ->
        {
            $(withText(issuesTitle)).should(Condition.exist);
        });
    }

    @Test
    @Feature("Поиск в репозитории")
    @Story("Поиск в репозитории allure")
    @Owner("Meschikowa")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "github", url = "https://github.com/microsoft/Microsoft365DSC/issues")
    @DisplayName("Проверка Issue в репозитории microsoft/Microsoft365DSC")
    void titleIssuesStepsTest (){
        Steps st = new Steps();
        st.openMainPage(baseUrl);
        st.search(searchValue, locator, search);
        st.openRepositories(searchValue);
        st.openIssue();
        st.checkTitleIssue(issuesTitle);

    }

}
