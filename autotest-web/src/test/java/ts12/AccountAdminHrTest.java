package ts12;

import hooks.WebHooks;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.WebCheckSteps;
import steps.WebSteps;

public class AccountAdminHrTest extends WebHooks {

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
    }

    @Test
    @Description("12.1. Проверка поведения системы при нажатии на кнопку \"Выполнить\" " +
            "без выбора Администратора и незаполненном поле \"Действие\" под ролью hr")
    public void checkingClickPerformBlankField() {
        authorization("hr");

        webCheckSteps.checkAppearElement("Выполнить");
        webSteps.clickOnElement("Выполнить");
        webCheckSteps.textAppearOnThePage("Чтобы произвести действия над объектами, необходимо их выбрать. " +
                "Объекты не были изменены.");
    }

    @Test
    @Description("12.2. Проверка поведения системы при нажатии на кнопку \"Выполнить\" " +
            "без выбора Администратора и заполненном поле \"Действие\" под ролью hr")
    public void checkingClickPerformFilledField() {
        authorization("hr");

        webCheckSteps.checkAppearElement("Действие меню");
        webSteps.setAnything("Действие", 1);
        webSteps.clickOnElement("Выполнить");
        webCheckSteps.textAppearOnThePage("Чтобы произвести действия над объектами, необходимо их выбрать. " +
                "Объекты не были изменены.");
    }

    @Test
    @Description("12.3. Проверка поведения системы при нажатии на кнопку \"Выполнить\" " +
            "при выбранных Администраторах и не заполненном поле \"Действие\"  под ролью hr")
    public void checkingClickPerformWithAdmin() {
        authorization("hr");

        webSteps.clickRandom("Таблица чек-бокс");
        webCheckSteps.checkAppearElement("Выбрано 1 из");
        webSteps.clickOnElement("Выполнить");
        webCheckSteps.textAppearOnThePage("Действие не выбрано.");
    }
}
