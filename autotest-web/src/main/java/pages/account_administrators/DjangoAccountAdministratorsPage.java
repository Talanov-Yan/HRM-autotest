package pages.account_administrators;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

/**
 * PageObject, описывающий страницу 'Администраторы аккаунта'
 * http://178.154.246.238:58082/admin/core/accountadmin/
 */
@Name(value = "DjangoAccountAdministratorsPage")
public class DjangoAccountAdministratorsPage extends WebPage {

    @Name("Сотрудник")
    private ElementsCollection employeeNames = $$x("//th[@class='field-employee nowrap']/a");
    @Name("Аккаунт")
    private ElementsCollection accountNames = $$x("//td[@class='field-account_name nowrap']");
    @Name("Восстановить удаленный Администраторы аккаунта")
    private SelenideElement recoverLink = $x("//a[@class='recoverlink']");
    @Name("Импорт")
    private SelenideElement importLink = $x("//a[@class='import_link']");
    @Name("Экспорт")
    private SelenideElement exportLink = $x("//a[@class='export_link']");
    @Name("Добавить Администратор аккаунта +")
    private SelenideElement addEmployeeLink = $x("//a[@class='addlink']");
    @Name("Выполнить")
    private SelenideElement executeButton = $x("//button[@type='submit']");
    @Name("Действие")
    private ElementsCollection dropDownAction = $$x("//select[@name='action']/option");
    @Name("Действие меню")
    private SelenideElement action = $x("//select[@name='action']");
    @Name("Количество найденных записей")
    private SelenideElement numberRecords = $x("//p[@class='paginator']");
    @Name("Таблица чек-бокс")
    private ElementsCollection tableCheckboxes = $$x("//input[@class='action-select']");
    @Name("Инфоблок")
    private SelenideElement tableHeader = $x("//div[@id='content']/h1");
    @Name("Выбрано 1 из")
    private SelenideElement howMuchSearch = $x("//span[@class='action-counter']");
    @Name("Договор")
    private SelenideElement contractCheckbox = $x("//input[@value='contract']");
    @Name("Формат")
    private SelenideElement formatField = $x("//select[@name='file_format']");
}