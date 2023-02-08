package pages.user_group_totp;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;
/**
 * PageObject, описывающий страницу 'Добавить поле Группы'
 * http://178.154.246.238:58082/admin/auth/group/add/
 */
@Name(value = "DjangoAddGroup")
public class DjangoAddGroupPage extends WebPage {
    /**
     * PageObject, описывающий страницу 'Сотрудники с административным доступом'
     * http://178.154.246.238:58082/admin/core/administrator/
     */
    @Name("Инфоблок")
    private SelenideElement infoblock = $x("//div[@id='content']/h1");
}
