package pages.account_administrators;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

/**
 * PageObject, описывающий страницу 'Подтверждения удаления (Администратор аккаунта)'
 * http://178.154.246.238:58082/admin/core/accountadmin/{id Администратор Аккаунта}/delete/
 * {id Администратор Аккаунта} - id выбранного объекта(Администратор Аккаунта)
 */
@Name(value = "DjangoDeleteAccountAdministrators")
public class DjangoDeleteAccountAdministratorsPage extends WebPage {

    @Name("Вы уверены?")
    private SelenideElement areYouSure = $x("//h1[text()='Вы уверены?']");

    @Name("Yes, I`m sure")
    private SelenideElement sureYes = $x("//input[@value='Yes, I’m sure']");

    @Name("Успешно удалены 1 Сотрудник.")
    private SelenideElement message = $x("//ul[@class='messagelist']/li");

    @Name("Сообщение о успешном удалении")
    private SelenideElement deletedSuccess = $x("//li[@class = 'success']");
}
