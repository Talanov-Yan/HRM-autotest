package pages.account_administrators;

import com.codeborne.selenide.ElementsCollection;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.*;

/**
 * PageObject, описывающий страницу 'Восстановить удаленный Администраторы аккаунта(выбор из списка удаленных)'
 * http://178.154.246.238:58082/admin/core/accountadmin/recover/
 */
@Name(value = "DjangoRestoreAccountAdministrators")
public class DjangoRestoreAccountAdministratorsPage extends WebPage {

    @Name("Дата и время")
    private ElementsCollection dateAndTime = $$x("//th[@scope='row']/a");

    @Name("Сотрудник")
    private ElementsCollection employee = $$("//table[@id='change-history']/tbody/tr/td");
}
