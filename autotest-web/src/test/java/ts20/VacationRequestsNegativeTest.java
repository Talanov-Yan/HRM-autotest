package ts20;

import hooks.WebHooks;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.WebCheckSteps;
import steps.WebSteps;

public class VacationRequestsNegativeTest extends WebHooks {

    private static PageManager pageManager = new PageManager();
    private static WebSteps webSteps = new WebSteps(pageManager);
    private static WebCheckSteps webCheck = new WebCheckSteps(pageManager);

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
    @Description(value = "20.1 проверка поведения системы при незаполнении полей")
    public static void checkFields() {

        hrAuthorizationAndRequestForVacation();
        webSteps.scrollToElement("Сохранить и продолжить редактирование");
        webSteps.clickOnElement("Сохранить и продолжить редактирование");
        webCheck.checkAppearElement("Пожалуйста, исправьте ошибки ниже.");
        webCheck.checkAppearElement("Сотрудник: Это поле обязательно");
        webCheck.checkAppearElement("Статус запроса: Это поле обязательно");
        webCheck.checkAppearElement("Дата создания: Это поле обязательно");
        webCheck.checkAppearElement("Дата начала: Это поле обязательно");
        webCheck.checkAppearElement("Дата окончания: Это поле обязательно");
    }

    @Test
    @Description(value = "20.2 проверка поведения системы при невалидном заполнении поля 'Дата создания'")
    public static void checkFieldCreateDate() {

        hrAuthorizationAndRequestForVacation();
        webSteps.fillField("Дата создания", "123qweфыв!");
        webSteps.scrollToElement("Сохранить и продолжить редактирование");
        webSteps.clickOnElement("Сохранить и продолжить редактирование");
        webCheck.checkAppearElement("Пожалуйста, исправьте ошибки ниже.");
        webCheck.checkAppearElement("Дата создания: Введите правильную дату");
    }

    @Test
    @Description(value = "20.3 проверка поведения системы при невалидном заполнении поля 'Дата начала'")
    public static void checkFieldStartDate() {

        hrAuthorizationAndRequestForVacation();
        webSteps.fillField("Дата начала", "123qweфыв!");
        webSteps.scrollToElement("Сохранить и продолжить редактирование");
        webSteps.clickOnElement("Сохранить и продолжить редактирование");
        webCheck.checkAppearElement("Пожалуйста, исправьте ошибки ниже.");
        webCheck.checkAppearElement("Дата начала: Введите правильную дату");
    }

    @Test
    @Description(value = "20.4 проверка поведения системы при невалидном заполнении поля 'Дата окончания'")
    public static void checkFieldEnfDate() {

        hrAuthorizationAndRequestForVacation();
        webSteps.fillField("Дата окончания", "123qweфыв!");
        webSteps.scrollToElement("Сохранить и продолжить редактирование");
        webSteps.clickOnElement("Сохранить и продолжить редактирование");
        webCheck.checkAppearElement("Пожалуйста, исправьте ошибки ниже.");
        webCheck.checkAppearElement("Дата окончания: Введите правильную дату");
    }
}
