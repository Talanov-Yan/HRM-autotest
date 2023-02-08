package pages.employee;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.*;
/**
 * PageObject, описывающий страницу 'Сотрудники'
 * http://178.154.246.238:58082/admin/core/employee/
 */
@Name(value = "DjangoEmployee")
public class DjangoEmployeePage extends WebPage {
    //HEADER
    @Name("Администрирование Django")
    private SelenideElement backToMainPage = $x("//h1[@id='site-name']/a");

    @Name("Выберите Сотрудник для изменения")
    private SelenideElement pageContent = $x("//div[@id='content']/h1");
    //КНОПКИ В HEADER
    @Name("Восстановить удаленный сотрудники")
    private SelenideElement recoverLink = $x("//a[@class='recoverlink']");
    @Name("Импорт")
    private SelenideElement importLink = $x("//a[@class='import_link']");
    @Name("Экспорт")
    private SelenideElement exportLink = $x("//a[@class='export_link']");
    @Name("Добавить сотрудник")
    private SelenideElement addEmployeeLink = $x("//a[@class='addlink']");
    @Name("Предупреждение в заголовке")
    private SelenideElement headerWarning = $(By.className("warning"));
    @Name("Сообщение об успешном редактирование")
    private SelenideElement headerSuccess = $(By.className("success"));

    //ПОИСК
    @Name("Поиск")
    private SelenideElement search = $x("//input[@id='searchbar']");
    @Name("Найти")
    private SelenideElement searchButton = $x("//input[@type='submit']");

    //ДЕЙСТВИЕ
    @Name("Выполнить")
    private SelenideElement executeButton = $x("//button[@type='submit']");
    @Name("Действие")
    private ElementsCollection dropDownAction = $$x("//select[@name='action']/option");
    @Name("Действие меню")
    private SelenideElement action = $x("//select[@name='action']");
    @Name("Выбрано 1 из 100")
    private SelenideElement howMuchSearch = $x("//span[@class='action-counter']");

    //ОСНОВНОЙ БЛОК
    @Name("Таблица чек-бокс")
    private ElementsCollection tableCheckboxes = $$x("//input[@class='action-select']");
    @Name("ФИО")
    private ElementsCollection fio = $$x("//th[@class='field-full_name']/a");
    @Name("Текущий город")
    private ElementsCollection currentCity = $$x("//td[@class='field-current_city nowrap']");

    //ПАГИНАЦИЯ
    @Name("Пагинация текущая страница")
    private SelenideElement currentPaginator = $x("//span[@class='this-page']");
    @Name("Количество найденных записей")
    private SelenideElement numberRecords = $x("//p[@class='paginator']");
    @Name("Пагинация")
    private ElementsCollection paginator = $$x("//p[@class='paginator']/a");

    //ФИЛЬТРЫ
    @Name("Категории фильтров")
    private ElementsCollection filtersCategory = $$x("//div[@id='changelist-filter']/h3");
    @Name("Фильтр")
    private ElementsCollection filters = $$x("//div[@id='changelist-filter']/ul/li");

//БУДУТ ПЕРЕНЕСЕНЫ В DjangoExportEmployeePage НЕ ЗАБУДЬТЕ ПРОИНИЦИАЛИЗИРОВАТЬ ТУ СТРАНИЦУ
    @Name("Договор")
    private SelenideElement contractCheckbox = $x("//input[@value='contract']");
    @Name("Формат")
    private SelenideElement formatField = $x("//select[@name='file_format']");
}
