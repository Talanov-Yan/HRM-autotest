package ts11;

import hooks.WebHooks;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.*;

public class DjangoAccountAdministratorsPageTest extends WebHooks {

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
    @Description("11.1. Проверка работоспособности удаления Администратора аккаунта " +
            "через кнопку 'Действия' под ролью hr")
    public void checkingHealthDelete() {
        authorization("hr");

        webSteps.clickRandom("Таблица чек-бокс");
        webCheckSteps.checkAppearElement("Выбрано 1 из");
        webSteps.setAnything("Действие", 1);
        webCheckSteps.checkAppearElement("Выполнить");
        webSteps.clickOnElement("Выполнить");
        webSteps.setPage("DjangoDeleteAccountAdministrators");
        webCheckSteps.textAppearOnThePage("Вы уверены?");
        webSteps.clickOnElement("Yes, I`m sure");
        webCheckSteps.textAppearOnThePage("Успешно удалены 1 Администратор аккаунта.");
    }



    @Test
    @Description("11.2. Проверка работоспособности кнопки добавления Администратор аккаунта под ролью hr")
    public void checkingHealthAdd() {
        authorization("hr");

        webCheckSteps.checkAppearElement("Добавить Администратор аккаунта +");
        webSteps.clickOnElement("Добавить Администратор аккаунта +");
        webSteps.setPage("DjangoAddAccountAdministrators");
        webCheckSteps.textAppearOnThePage("Добавить Администратор аккаунта");
    }

    @Test
    @Description("11.3. Проверка работоспособности восстановления удаленных Администраторов аккаунта под ролью hr")
    public void checkingHealthRecovery() {
        authorization("hr");

        webCheckSteps.checkAppearElement("Восстановить удаленный Администраторы аккаунта");
        webSteps.clickOnElement("Восстановить удаленный Администраторы аккаунта");
        webSteps.setPage("DjangoRestoreAccountAdministrators");
        webCheckSteps.textAppearOnThePage("Восстановить удаленный Администраторы аккаунта");
        webSteps.clickRandom("Дата и время");
        webSteps.setPage("DjangoReturnAccountAdministrators");
        webCheckSteps.textAppearOnThePage("Нажмите кнопку \"Сохранить\" далее, чтобы восстановить эту версию объекта.");
        webSteps.clickOnElement("Сохранить");
        webCheckSteps.checkAppearElement("Сообщение об успешном изменении");
    }

}