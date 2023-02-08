package pages.administrators;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.*;

/**
 * Страница - Администраторы аккаунта
 *
 * @link - http://178.154.246.238:58082/admin/core/accountadmin/
 */

@Name("AdministratorsOfAccount")
public class AdministratorsOfAccountPage extends WebPage {

    @Name("Рандомный сотрудник из списка")
    private ElementsCollection randomEmployeeByList = $$x("//*[@id=\"result_list\"]/tbody/tr/th/a");
}
