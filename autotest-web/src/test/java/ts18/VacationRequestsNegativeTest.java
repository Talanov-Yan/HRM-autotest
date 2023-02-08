package ts18;

import hooks.WebHooks;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.WebCheckSteps;
import steps.WebSteps;

public class VacationRequestsNegativeTest extends WebHooks {

    private final PageManager pageManager = new PageManager();
    private final WebSteps webSteps = new WebSteps(pageManager);
    private final WebCheckSteps webCheckSteps = new WebCheckSteps(pageManager);


    private void authorization(String login) {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin(login);
        webCheckSteps.currentTextIsNotExist("Сообщение об ошибке");
        webSteps.setPage("DjangoAdministration");
        webCheckSteps.checkAppearElement("Запросы на отпуск");
        webSteps.clickOnElement("Запросы на отпуск");
        webSteps.setPage("DjangoVacationRequests");

    }

    @Test
    @Description("18.1. Проверка поведения системы при нажатии на кнопку \"Выполнить\" " +
            "без выбора Запроса на отпуск и незаполненном поле \"Действие\" под ролью hr")
    public void checkingPerform() {
        authorization("hr");

        webCheckSteps.checkAppearElement("Выполнить");
        webSteps.clickOnElement("Выполнить");
        webCheckSteps.textAppearOnThePage("Чтобы произвести действия над объектами, " +
                "необходимо их выбрать. Объекты не были изменены.");
    }

    @Test
    @Description("18.2. Проверка поведения системы при нажатии на кнопку \"Выполнить\" " +
            "без выбора Запроса на отпуск и заполненном поле \"Действие\" под ролью hr")
    public void checkingPerformWithVacation() {
        authorization("hr");

        webCheckSteps.checkAppearElement("Действие");
        webSteps.setAnything("Выпадающий список: Действие", 1);
        webSteps.clickOnElement("Выполнить");
        webCheckSteps.textAppearOnThePage("Чтобы произвести действия над объектами, " +
                "необходимо их выбрать. Объекты не были изменены.");
    }

    @Test
    @Description("18.3. Проверка поведения системы при нажатии на кнопку \"Выполнить\" " +
            "при выбранных Запросах на отпуск и не заполненном поле \"Действие\"  под ролью hr")
    public void checkingPerformWithAction() {
        authorization("hr");

        webSteps.clickRandom("Таблица чек-бокс");
        webCheckSteps.checkAppearElement("Выбрано 1 из");
        webSteps.clickOnElement("Выполнить");
        webCheckSteps.textAppearOnThePage("Действие не выбрано.");
    }

}
