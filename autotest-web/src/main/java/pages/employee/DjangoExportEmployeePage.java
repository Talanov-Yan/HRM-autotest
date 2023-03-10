package pages.employee;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.*;
/**
 * PageObject, описывающий страницу 'Сотрудники Экспорт'
 * http://178.154.246.238:58082/admin/core/employee/export/?
 */
@Name(value = "DjangoExportEmployee")
public class DjangoExportEmployeePage extends WebPage {

    @Name("Инфоблок")
    private SelenideElement tableHeader = $x("//div[@id='content']/h1");

    @Name("Формат")
    private SelenideElement fieldFormat = $x("//select[@id='id_file_format']");

    @Name("Чекбокс")
    private ElementsCollection checkboxes = $$x("//label[contains(@for, 'id_employee_fields_')]");

    @Name("Отправить")
    private SelenideElement buttonSend = $x("//input[@type='submit']");

// КТО ИСПОЛЬЗУЕТ ЭТОТ РО, ПЕРЕПИШИТЕ СВОЙ ТЕСТ НА КОЛЛЕКЦИЮ, ЭЛЕМЕНТ: Чекбокс
    @Name("Договор")
    private SelenideElement contractCheckbox = $x("//input[@value='contract']");
}
