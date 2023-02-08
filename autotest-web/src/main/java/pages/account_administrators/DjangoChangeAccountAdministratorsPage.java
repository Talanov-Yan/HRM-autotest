package pages.account_administrators;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

/**
 * PageObject, описывающий страницу 'Изменить Администратор аккаунта'
 * http://178.154.246.238:58082/admin/core/accountadmin/2/change/
 */
@Name(value = "DjangoChangeAccountAdministrators")
public class DjangoChangeAccountAdministratorsPage extends WebPage {
    @Name("Удалено")
    private final SelenideElement deleted = $x("//a[@class = 'deletelink']");

    @Name("Сохранить и добавить другой объект")
    private final SelenideElement saveAdd = $x("//input[@name = '_addanother']");

    @Name("Сохранить и продолжить редактирование")
    private final SelenideElement saveContinueEditing = $x("//input[@name = '_continue']");

    @Name("СОХРАНИТЬ")
    private SelenideElement save = $x("//input[@name = '_save']");

    @Name("Сообщение о успешном редактировании")
    private static final SelenideElement changedSuccess = $x("//li[@class = 'success']");

    @Name("Сотрудник")
    private SelenideElement selectEmployee = $x("//select[@id= 'id_employee']");

    @Name("'<link>'")
    private SelenideElement link = $x("//li[@class = 'success']/a");
}
