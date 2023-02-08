package pages.administrators;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Страница - Изменить Администратор аккаунта
 *
 * @link - http://178.154.246.238:58082/admin/core/accountadmin/21/change/
 */

@Name("ChangeAdministratorOfAccount")
public class ChangeAdministratorOfAccountPage extends WebPage {

    @Name("Поле: Сотрудник")
    private SelenideElement fieldEmployee = $(By.id("id_employee"));

    @Name("Поле: Аккаунт")
    private SelenideElement fieldAccount = $(By.id("id_account_name"));

    @Name("Поле: Дата начала")
    private SelenideElement dateOfStart = $(By.id("id_start_date"));

    @Name("Поле: Дата окончания")
    private SelenideElement dateOfEnd = $(By.id("id_end_date"));

    @Name("Сохранить и продолжить редактирование")
    private SelenideElement saveAndContinueEditing = $x("//*[@id=\"accountadmin_form\"]//input[3]");

    @Name("Сообщение об ошибке: Пожалуйста, исправьте ошибки ниже")
    private SelenideElement warningAboutError = $x("//*[@id=\"accountadmin_form\"]/div/p");

    @Name("Сотрудник: Это поле обязательно")
    private SelenideElement emptyFieldEmployee = $x("//*[@id=\"accountadmin_form\"]//div[1]/ul/li");

    @Name("Аккаунт: Это поле обязательно")
    private SelenideElement emptyFieldAccount = $x("//*[@id=\"accountadmin_form\"]//div[2]/ul/li");

    @Name("Дата начала: Это поле обязательно")
    private SelenideElement emptyFieldDateOfStart = $x("//*[@id=\"accountadmin_form\"]//div[3]/ul/li");

    @Name("Введите правильную дату: Дата начала")
    private SelenideElement wrongStartDate = $x("//*[@id=\"accountadmin_form\"]//div[3]/ul/li");

    @Name("Введите правильную дату: Дата окончания")
    private SelenideElement wrongEndDate = $x("//*[@id=\"accountadmin_form\"]//div[4]//li");
}
