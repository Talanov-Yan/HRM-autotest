package pages.vacation_requests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.eo.Se;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
/**
 * PageObject, описывающий страницу 'Добавить запрос на отпуск'
 * http://178.154.246.238:58082/admin/core/employeevacationrequest/add/
 */
@Name(value = "DjangoAddVacationRequest")
public class DjangoAddVacationRequestPage extends WebPage {

    @Name("Добавить Запрос на отпуск")
    private SelenideElement headerAddRequest  = $x("//div[@id='content']/h1");

    @Name("Сотрудник")
    private ElementsCollection employee = $$x("//select[@name='employee']/option");

    @Name("Поле Сотрудник")
    private SelenideElement fieldOfEmployee = $x("//select[@name='employee']");

    @Name("Статус запроса")
    private SelenideElement requestStatus = $x("//select[@name='request_status']");

    @Name("Дата создания")
    private SelenideElement createDate = $x("//input[@name='create_date']");

    @Name("Календарь Даты создания")
    private SelenideElement createCalendar = $x("//a[@id='calendarlink0']");

    @Name("Даты в календаре Даты создания")
    private ElementsCollection datesOfCreateDates = $$x("//div[@id=\"calendarin0\"]/table/tbody/tr/td");

    @Name("Сегодня Даты создания")
    private SelenideElement todayCreateDate = $x("//label[@for='id_create_date']/following-sibling::span/a[text()='Сегодня']");

    @Name("Дата начала")
    private SelenideElement startDate = $x("//input[@name='start_date']");

    @Name("Календарь Даты начала")
    private SelenideElement startCalendar = $x("//a[@id='calendarlink1']");

    @Name("Даты в календаре Даты начала")
    private ElementsCollection datesOfStartDates = $$x("//div[@id=\"calendarin1\"]/table/tbody/tr/td");

    @Name("Сегодня Даты начала")
    private SelenideElement todayStartDate = $x("//label[@for='id_start_date']/following-sibling::span/a[text()='Сегодня']");

    @Name("Дата окончания")
    private SelenideElement endDate = $x("//input[@name='end_date']");

    @Name("Календарь Даты окончания")
    private SelenideElement endCalendar = $x("//a[@id='calendarlink2']");

    @Name("Даты в календаре Даты окончания")
    private ElementsCollection datesOfEndDates = $$x("//div[@id=\"calendarin2\"]/table/tbody/tr/td");

    @Name("Сегодня Даты окончания")
    private SelenideElement todayEndDate = $x("//label[@for='id_end_date']/following-sibling::span/a[text()='Сегодня']");

    @Name("Сохранить")
    private SelenideElement saveElem = $x("//input[@value='Сохранить']");

    @Name("Сохранить и добавить другой объект")
    private SelenideElement saveAndAddButton = $x("//input[@name='_addanother']");

    @Name("Сохранить и продолжить редактирование")
    private SelenideElement saveContinueButton = $x("//input[@name='_continue']");

    @Name("Сообщение об успешном создании запроса")
    private SelenideElement successMessage = $x("//li[@class='success']");

    @Name("Заметки")
    private SelenideElement notes = $x("//textarea");

    @Name("Оплачиваемый")
    private SelenideElement payedVacation = $x("//div/input[@id='id_paid']");

    @Name("Пожалуйста, исправьте ошибки ниже.")
    private SelenideElement errorMessage = $x("//p[@class='errornote']");

    @Name("Сотрудник: Это поле обязательно")
    private SelenideElement errorEmployee = $x("//div[@class='form-row errors field-employee']/ul");

    @Name("Статус запроса: Это поле обязательно")
    private SelenideElement errorRequestStatus = $x("//div[@class='form-row errors field-request_status']/ul");

    @Name("Дата создания: Это поле обязательно")
    private SelenideElement errorCreateDate = $x("//div[@class='form-row errors field-create_date']/ul");

    @Name("Дата начала: Это поле обязательно")
    private SelenideElement errorStartDate = $x("//div[@class='form-row errors field-start_date']/ul");

    @Name("Дата окончания: Это поле обязательно")
    private SelenideElement errorEndDate = $x("//div[@class='form-row errors field-end_date']/ul");

    @Name("Дата создания: Введите правильную дату")
    private SelenideElement writeCreateDate = $x("//div[@class='form-row errors field-create_date']/ul");

    @Name("Дата начала: Введите правильную дату")
    private SelenideElement writeStartDate = $x("//div[@class='form-row errors field-start_date']/ul");

    @Name("Дата окончания: Введите правильную дату")
    private SelenideElement writeEndDate = $x("//div[@class='form-row errors field-end_date']/ul");
}
