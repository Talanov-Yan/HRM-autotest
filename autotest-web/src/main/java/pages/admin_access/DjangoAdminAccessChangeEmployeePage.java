package pages.admin_access;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;
/**
 * PageObject, описывающий страницу 'Изменить поле Сотрудники с административным доступом'
 * http://178.154.246.238:58082/admin/core/administrator/
 */
@Name(value = "DjangoAdminAccessChangeEmployee")
public class DjangoAdminAccessChangeEmployeePage extends WebPage {

    @Name("Инфоблок")
    private SelenideElement infoblock = $x("//div[@id='content']/h1");
}
