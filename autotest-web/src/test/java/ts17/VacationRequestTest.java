package ts17;

import hooks.WebHooks;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ru.lanit.at.api.testcontext.ContextHolder;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.WebCheckSteps;
import steps.WebSteps;

public class VacationRequestTest extends WebHooks {
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

    private void addVacationRequest() {
        webCheckSteps.checkAppearElement("Добавить запрос на отпуск");
        webSteps.clickOnElement("Добавить запрос на отпуск");
        webSteps.setPage("DjangoAddVacationRequest");
        webSteps.clickRandom("Сотрудник");
        webSteps.selectElementInDropDown("Статус запроса", "test");
        webSteps.fillField("Дата создания", "01.02.2022");
        webSteps.fillField("Дата начала", "05.02.2022");
        webSteps.fillField("Дата окончания", "20.02.2022");
        webSteps.clickOnElement("Сохранить");
        webSteps.setPage("DjangoVacationRequests");
    }

    private void deleteVacationRequest() {
        webSteps.clickRandom("Таблица чек-бокс");
        webCheckSteps.checkAppearElement("Выбрано 1 из");
        webSteps.setAnything("Выпадающий список: Действие", 1);
        webSteps.clickOnElement("Выполнить");
        webCheckSteps.textAppearOnThePage("Вы уверены?");
        webSteps.clickOnElement("Yes, I'm sure");
    }

    @Test
    @Description("17.1. Проверка работоспособности удаления \"Запрос на отпуск\" " +
            "через кнопку \"Действие\" под ролью hr")
    public void checkingPerformWithAction() {
        authorization("hr");
        addVacationRequest();
        deleteVacationRequest();
        webCheckSteps.textAppearOnThePage("Успешно удалены 1 Запрос на отпуск.");
    }

    @Test
    @Description("17.2. Проверка работоспособности кнопки добавления \"Запрос на отпуск\" под ролью hr")
    public void checkingAddVacation() {
        authorization("hr");

        webCheckSteps.checkAppearElement("Добавить запрос на отпуск");
        webSteps.clickOnElement("Добавить запрос на отпуск");
        webSteps.setPage("DjangoAddVacationRequest");
        webCheckSteps.checkAppearElement("Добавить Запрос на отпуск");
    }

    @Test
    @Description("17.3. Проверка работоспособности восстановления удаленных \"Запросы на отпуск\" под ролью hr")
    public void checkingRestoreVacation() {
        authorization("hr");
        addVacationRequest();
        deleteVacationRequest();

        webCheckSteps.checkAppearElement("Восстановить удаленный запросы на отпуск");
        webSteps.clickOnElement("Восстановить удаленный запросы на отпуск");
        webSteps.setPage("DjangoRecoverVacation");
        webCheckSteps.textAppearOnThePage("Восстановить удаленный Запросы на отпуск");
        webSteps.clickRandomAndSave("Таблица дата и время", "Таблица запрос на отпуск");
        webCheckSteps.textAppearOnThePage("Нажмите кнопку \"Сохранить\" далее, чтобы восстановить эту версию объекта.");
        webSteps.clickOnElement("Сохранить");
        webCheckSteps.textAppearOnThePage("The Запрос на отпуск “");
        webCheckSteps.textAppearOnThePage(ContextHolder.getValue("Таблица дата и время"));
        webCheckSteps.textAppearOnThePage("” was changed successfully.");
    }
}

