package pages.account_administrators;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.*;

/**
 * PageObject, описывающий страницу 'Восстановить экземпляр (Администраторы Аккаунта)'
 * http://178.154.246.238:58082/admin/core/accountadmin/recover/{id Администратор Аккаунта}
 * {id Администратор Аккаунта} - id выбранного объекта(Администратор Аккаунта)
 */
@Name("DjangoRestoreAccountAdministrators")
public class DjangoReturnAccountAdministratorsPage extends WebPage {

    @Name("Сохранить")
    private SelenideElement save = $x("//input[@name='_save']");

    @Name("Вернуть")
    private SelenideElement returnContent = $x("//div[@id='content']/h1");

    @Name("Сотрудник")
    private ElementsCollection employee = $$("//select[@name = 'employee']");

    @Name("Сообщение об успешном изменении")
    private SelenideElement successMessage = $x("//li[@class = 'success']");
}
