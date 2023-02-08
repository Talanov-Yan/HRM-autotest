package pages.account_administrators;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.*;

/**
 * PageObject, описывающий страницу 'Добавить Администраторы аккаунта'
 * http://178.154.246.238:58082/admin/core/accountadmin/add/
 */
@Name(value = "DjangoAddAccountAdministrators")
public class DjangoAddAccountAdministratorsPage extends WebPage {

    @Name("Добавить Администратор аккаунта")
    private SelenideElement title = $x("//div[@id = 'content']/h1");
    @Name("Сохранить и продолжить редактирование")
    private SelenideElement saveContinueEditing = $x("//input[@name = '_continue']");
    @Name("Пожалуйста, исправьте ошибки ниже.")
    private SelenideElement pleaseFixErrors = $x("//p[@class = 'errornote']");

    @Name("Инфоблок сотрудник")
    private SelenideElement employeeInfo = $x("//label[@for = 'id_employee']/../../ul");
    @Name("Инфоблок аккаунт")
    private SelenideElement accountInfo = $x("//label[@for = 'id_account_name']/../../ul");
    @Name("Инфоблок дата начала")
    private SelenideElement startDateInfo = $x("//label[@for = 'id_start_date']/../../ul");
    @Name("Инфоблок дата окончания")
    private SelenideElement endDateInfo = $x("//input[@id = 'id_end_date']/../../ul");


    @Name("Сотрудник")
    private SelenideElement selectEmployee = $x("//select[@id= 'id_employee']");

    @Name("Аккаунт")
    private SelenideElement selectAccount = $x("//select[@id= 'id_account_name']");

    @Name("Дата начала")
    private SelenideElement startDate = $x("//input[@id = 'id_start_date']");
    @Name("'Сегодня' рядом с полем 'Дата начала'")
    private SelenideElement startDateToday =
            $x("//div[@class = 'form-row field-start_date']//a[text()='Сегодня']");
    @Name("'Календарь' рядом с полем 'Дата начала'")
    private SelenideElement startDateCalendar = $x("//a[@id = 'calendarlink0']");
    @Name("Все даты месяца из 'Календарь' рядом с полем 'Дата начала'")
    private ElementsCollection randomStartDateByCalendar = $$x("//div[@id='calendarin0']//a[@href='#']");

    @Name("Дата окончания")
    private SelenideElement endDate = $x("//input[@id = 'id_end_date']");
    @Name("'Сегодня' рядом с полем 'Дата окончания'")
    private SelenideElement endDateToday =
            $x("//div[@class = 'form-row field-end_date']//a[text()='Сегодня']");
    @Name("'Календарь' рядом с полем 'Дата окончания'")
    private SelenideElement endDateCalendar = $x("//a[@id = 'calendarlink1']");
    @Name("Все даты месяца из 'Календарь' рядом с полем 'Дата окончания'")
    private ElementsCollection endStartDateByCalendar = $$x("//div[@id='calendarin1']//a[@href='#']");

    @Name("Заметка")
    private SelenideElement note = $x("//textarea[@name='memo']");

    @Name("Сохранить и добавить другой объект")
    private SelenideElement saveAndAddAnotherObj = $x("//input[@name='_addanother']");
    @Name("Сохранить")
    private SelenideElement save = $x("//input[@name= '_save']");

    @Name("Сообщение о успешном редактировании")
    private static final SelenideElement deletedSuccess = $x("//li[@class = 'success']");
}
