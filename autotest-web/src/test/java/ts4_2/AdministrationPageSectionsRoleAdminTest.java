package ts4_2;

import hooks.WebHooks;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.WebCheckSteps;
import steps.WebSteps;

public class AdministrationPageSectionsRoleAdminTest extends WebHooks {

    private PageManager pageManager = new PageManager();
    private final WebSteps webSteps = new WebSteps(pageManager);
    private final WebCheckSteps webCheckSteps = new WebCheckSteps(pageManager);

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {"Сотрудники с административным доступом", "DjangoAdminAccess", "Выберите Сотрудник с административным доступом для изменения"},
                {"Добавить поле Сотрудники с административным доступом", "DjangoAdminAccessAddEmployee", "Добавить Сотрудник с административным доступом"},
                {"Изменить поле Сотрудники с административным доступом", "DjangoAdminAccessChangeEmployee", "Выберите Сотрудник с административным доступом для изменения"},
                {"Группы", "DjangoGroup", "Выберите группа для изменения"},
                {"Добавить поле Группы", "DjangoAddGroup", "Добавить группа"},
                {"Изменить поле Группы", "DjangoChangeGroup", "Выберите группа для изменения"},
                {"Пользователи", "DjangoUser", "Выберите пользователь для изменения"},
                {"Добавить поле Пользователи", "DjangoAddUser", "Добавить пользователь"},
                {"Изменить поле Пользователи", "DjangoChangeUser", "Выберите пользователь для изменения"},
                {"TOTP devices", "DjangoTotp", "Выберите TOTP device для изменения"},
                {"Добавить поле TOTP devices", "DjangoAddTotp", "Добавить TOTP device"},
                {"Изменить поле TOTP devices", "DjangoChangeTotp", "Выберите TOTP device для изменения"}
        };
    }

    private void initialize() {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin("admin");
        webSteps.setPage("DjangoAdministration");
    }

    @Test(dataProvider = "data")
    @Description("4.2.1-4.2.12 Проверка работоспособности элемента {button}. под ролью 'admin'")
    public void administrationAccessUserGroupTotpTest(String button, String page, String infotext) {
        initialize();
        webCheckSteps.checkAppearElement(button);
        webSteps.clickOnElement(button);
        webSteps.setPage(page);
        webCheckSteps.matchText("Инфоблок", infotext);
    }
}
