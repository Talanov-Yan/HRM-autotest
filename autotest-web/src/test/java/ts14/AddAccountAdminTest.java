package ts14;

import hooks.WebHooks;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.WebCheckSteps;
import steps.WebSteps;

public class AddAccountAdminTest extends WebHooks {

    private final PageManager pageManager = new PageManager();
    private final WebSteps webSteps = new WebSteps(pageManager);
    private final WebCheckSteps webCheckSteps = new WebCheckSteps(pageManager);


    private void authorization(String login) {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin(login);
        webCheckSteps.currentTextIsNotExist("Сообщение об ошибке");
        webSteps.setPage("DjangoAdministration");
        webCheckSteps.checkAppearElement("Администраторы аккаунта");
        webSteps.clickOnElement("Администраторы аккаунта");
        webSteps.setPage("DjangoAccountAdministratorsPage");
        webCheckSteps.checkAppearElement("Добавить Администратор аккаунта +");
        webSteps.clickOnElement("Добавить Администратор аккаунта +");
        webSteps.setPage("DjangoAddAccountAdministrators");

    }

    @Test
    @Description("14.1. Проверка поведения системы при не заполнении ключевых полей под ролью hr")
    public void checkingFieldsNotFilled() {
        authorization("hr");

        webCheckSteps.checkAppearElement("Сохранить и продолжить редактирование");
        webSteps.clickOnElement("Сохранить и продолжить редактирование");
        webCheckSteps.checkAppearElement("Пожалуйста, исправьте ошибки ниже.");
        webCheckSteps.matchText("Инфоблок сотрудник", "Это поле обязательно.");
        webCheckSteps.matchText("Инфоблок аккаунт", "Это поле обязательно.");
        webCheckSteps.matchText("Инфоблок дата начала", "Это поле обязательно.");
    }

    @Test
    @Description("14.2. Проверка поведения системы при невалидном " +
            "заполнении поля Дата начала под ролью hr")
    public void checkingInvalidFieldStartDate() {
        authorization("hr");

        webSteps.fillField("Дата начала", "123qweфыв");
        webSteps.clickOnElement("Сохранить и продолжить редактирование");
        webCheckSteps.checkAppearElement("Пожалуйста, исправьте ошибки ниже.");
        webCheckSteps.matchText("Инфоблок дата начала", "Введите правильную дату.");

    }

    @Test
    @Description("14.3. Проверка поведения системы при невалидном заполнении поля " +
            "Дата окончания под ролью hr")
    public void checkingInvalidFieldEndDate() {
        authorization("hr");

        webSteps.fillField("Дата окончания", "123qweфыв!");
        webSteps.clickOnElement("Сохранить и продолжить редактирование");
        webCheckSteps.checkAppearElement("Пожалуйста, исправьте ошибки ниже.");
        webCheckSteps.matchText("Инфоблок дата окончания", "Введите правильную дату.");
    }
}