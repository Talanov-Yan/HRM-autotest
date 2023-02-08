package ts15;

import hooks.WebHooks;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.WebCheckSteps;
import steps.WebSteps;

public class ChangeAccountAdminTest extends WebHooks {

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
        webSteps.clickRandom("Сотрудник");
        webSteps.setPage("DjangoChangeAccountAdministrators");

    }

    @Test
    @Description("15.1. Проверка работоспособности удаления Администратора аккаунта под ролью hr")
    public void checkingDelete() {
        authorization("hr");

        webCheckSteps.checkAppearElement("Удалено");
        webSteps.clickOnElement("Удалено");
        webSteps.setPage("DjangoDeleteAccountAdministrators");
        webCheckSteps.textAppearOnThePage("Вы уверены?");
        webSteps.clickOnElement("Yes, I`m sure");
        webCheckSteps.checkAppearElement("Сообщение о успешном удалении");
    }

    @Test
    @Description("15.2. Проверка работоспособности кнопки " +
            "\"Сохранить и добавить другой объект\" под ролью hr")
    public void checkingSaveAdd() {
        authorization("hr");

        webCheckSteps.checkAppearElement("Сохранить и добавить другой объект");
        webSteps.clickOnElement("Сохранить и добавить другой объект");
        webSteps.setPage("DjangoAddAccountAdministrators");
        webCheckSteps.checkAppearElement("Сообщение о успешном редактировании");
        webCheckSteps.emptyDropDown("Сотрудник");
    }

    @Test
    @Description("15.3. Проверка работоспособности кнопки " +
            "\"Сохранить и продолжить редактирование\" под ролью hr")
    public void checkingSaveContinueEdit() {
        authorization("hr");

        webCheckSteps.checkAppearElement("Сохранить и продолжить редактирование");
        webSteps.clickOnElement("Сохранить и продолжить редактирование");
        webCheckSteps.checkAppearElement("Сообщение о успешном редактировании");
        webCheckSteps.checkFieldTextFromElement("Сотрудник", "'<link>'");
    }

    @Test
    @Description("15.4. Проверка работоспособности кнопки СОХРАНИТЬ под ролью hr")
    public void checkingSave() {
        authorization("hr");

        webCheckSteps.checkAppearElement("СОХРАНИТЬ");
        webSteps.clickOnElement("СОХРАНИТЬ");
        webCheckSteps.checkAppearElement("Сообщение о успешном редактировании");
        webSteps.setPage("DjangoAccountAdministratorsPage");
    }

}
