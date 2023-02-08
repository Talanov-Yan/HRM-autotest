package ts19;

import hooks.WebHooks;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.WebCheckSteps;
import steps.WebSteps;

public class VacationRequestsTest extends WebHooks {

    private static PageManager pageManager = new PageManager();
    private static WebSteps webSteps = new WebSteps(pageManager);
    private static WebCheckSteps webCheck = new WebCheckSteps(pageManager);

    @DataProvider
    public Object[][] forCalendarWidget() {
        return new Object[][]{
            {"Календарь Даты создания", "Даты в календаре Даты создания", 1, "Дата создания"},
            {"Календарь Даты начала", "Даты в календаре Даты начала", 1, "Дата начала"},
            {"Календарь Даты окончания", "Даты в календаре Даты окончания", 1, "Дата окончания"}
        };
    }

    @DataProvider
    public Object[][] forTodayCalendar() {
        return new Object[][] {
                {"Сегодня Даты создания", "Дата создания"},
                {"Сегодня Даты начала", "Дата начала"},
                {"Сегодня Даты окончания", "Дата окончания"}
        };
    }

    private static void hrAuthorizationAndRequestForVacation() {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin("hr");
        webCheck.currentTextIsNotExist("Сообщение об ошибке");
        webSteps.setPage("DjangoAdministration");
        webCheck.checkAppearElement("Запросы на отпуск");
        webSteps.clickOnElement("Запросы на отпуск");
        webSteps.setPage("DjangoVacationRequests");
        webCheck.checkAppearElement("Добавить запрос на отпуск");
        webSteps.clickOnElement("Добавить запрос на отпуск");
        webSteps.setPage("DjangoAddVacationRequest");
    }

    @Test
    @Description(value = "19.1 создание запроса на отпуск и нажатие кнопки 'Сохранить'")
    public static void addVacationRequest() {

        hrAuthorizationAndRequestForVacation();
        webSteps.clickRandom("Сотрудник");
        webSteps.selectElementInDropDown("Статус запроса", "test");
        webSteps.fillField("Дата создания", "01.01.2021");
        webSteps.fillField("Дата начала", "05.01.2021");
        webSteps.fillField("Дата окончания", "20.01.2021");
        webSteps.scrollToElement("Сохранить");
        webSteps.clickOnElement("Сохранить");
        webCheck.checkAppearElement("Сообщение об успешном создании запроса");

    }

    @Test(dataProvider = "forCalendarWidget")
    @Description(value = "19.2, 19.4, 19.6 проверка корректности работы виджета 'Календарь' полей " +
            "'Дата Создания', 'Дата начала', 'Дата окончания'")
    public static void checkCalendarWidget(String calendar, String dates, int num, String field) {

        hrAuthorizationAndRequestForVacation();
        webSteps.clickOnElement(calendar);
        webSteps.clickRandomN(dates, num);
        webSteps.saveFieldContents(field);
        webCheck.checkField(field);

            }

    @Test (dataProvider = "forTodayCalendar")
    @Description(value = "19.3, 19.5, 19.7 проверка корректности работы кнопки 'Сегодня' виджета 'Календарь' полей" +
            "'Дата Создания', 'Дата начала', 'Дата окончания'")
    public static void checkTodayCalendarWidget(String today, String field) {

        hrAuthorizationAndRequestForVacation();
        webSteps.clickOnElement(today);
        webSteps.saveFieldContents(field);
        webCheck.checkField(field);
    }

    @Test
    @Description (value = "19.9 проверка корректности заполнения поля 'Заметки'")
    public static void checkNotesField() {

        hrAuthorizationAndRequestForVacation();
        webSteps.fillFieldRandomString("Заметки");
        webSteps.saveFieldContents("Заметки");
        webCheck.checkField("Заметки");

            }

    @Test
    @Description(value = "19.10 создание запроса на отпуск и нажатие кнопки 'Сохранить и добавить другой объект'")
    public static void addRequestAndAddObject() {

        hrAuthorizationAndRequestForVacation();
        webSteps.saveFieldContents("Поле Сотрудник");
        webSteps.clickRandom("Сотрудник");
        webSteps.selectElementInDropDown("Статус запроса", "test");
        webSteps.fillField("Дата создания", "01.01.2021");
        webSteps.fillField("Дата начала", "05.01.2021");
        webSteps.fillField("Дата окончания", "20.01.2021");
        webSteps.scrollToElement("Сохранить и добавить другой объект");
        webSteps.clickOnElement("Сохранить и добавить другой объект");
        webCheck.checkAppearElement("Сообщение об успешном создании запроса");
        webCheck.checkField("Поле Сотрудник");

    }

    @Test
    @Description(value = "19.11 создание запроса на отпуск и нажатие кнопки 'Сохранить и продолжить редактирование'")
    public static void addRequestAndContinue() {

        hrAuthorizationAndRequestForVacation();
        webSteps.clickRandom("Сотрудник");
        webSteps.saveFieldContents("Поле Сотрудник");
        webSteps.selectElementInDropDown("Статус запроса", "test");
        webSteps.fillField("Дата создания", "01.01.2021");
        webSteps.fillField("Дата начала", "05.01.2021");
        webSteps.fillField("Дата окончания", "20.01.2021");
        webSteps.scrollToElement("Сохранить и продолжить редактирование");
        webSteps.clickOnElement("Сохранить и продолжить редактирование");
        webCheck.checkAppearElement("Сообщение об успешном создании запроса");
        webCheck.checkField("Поле Сотрудник");

    }

}
