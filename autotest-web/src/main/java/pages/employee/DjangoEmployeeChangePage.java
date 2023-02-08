package pages.employee;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.*;
/**
 * PageObject, описывающий страницу 'Изменить сотрудника'
 * http://178.154.246.238:58082/admin/core/employee/
 */
@Name(value = "DjangoEmployeeChange")
public class DjangoEmployeeChangePage extends WebPage {

    //HEADER
    @Name("История")
    private SelenideElement history = $x("//a[@href='/admin/core/employee/805/history/']");
    @Name("Summary")
    private SelenideElement summary = $x("//a[@href='/summary_doc/805']");
    @Name("Сообщение об успешном редактировании")
    private SelenideElement successMessage = $x("//ul[@class='messagelist']//li[@class='success']/a");

    @Name("Инфоблок")
    private SelenideElement tableHeader = $x("//div[@id='content']/h1");
// ДАННЫЙ РО БУДЕТ УДАЛЕН -> БУДЕТ ИСПОЛЬЗОВАТЬСЯ: Инфоблок
    @Name("Заголовок таблицы")
    private SelenideElement header = $x("//div[@id='content']/h1");

    @Name("Сообщение об ошибке в заголовке")
    private SelenideElement headerError = $x("//p[@class='errornote']");
    //HEADER
    @Name("Администрирование Django")
    private SelenideElement backToMainPage = $x("//h1[@id='site-name']/a");
    //ОБЩАЯ ИНФОРМАЦИЯ
    @Name("Фамилия")
    private SelenideElement lastName = $x("//input[@id='id_surname']");
    @Name("Имя")
    private SelenideElement firstName = $x("//input[@id='id_name']");
    @Name("Отчество")
    private SelenideElement patronymic = $x("//input[@id='id_patronymic']");
    @Name("Фамилия Public")
    private SelenideElement surnamePublic = $x("//div[@class='fieldBox field-surname']/label/following-sibling::div");
    @Name("Пол")
    private SelenideElement dropdownGender = $x("//select[@id='id_gender']");
    @Name("Выберите фото")
    private SelenideElement photo = $x("//input[@id='id_photo']");
    @Name("Загруженное фото")
    private SelenideElement uploadedPhoto = $x("//div[contains(@class, 'field-photo_tag')]//div[@class='readonly']/img");

    @Name("Дата приема на работу")
    private SelenideElement joiningDate = $x("//input[@id='id_joining_date']");
    @Name("Сегодня рядом 'Дата приема на работу'")
    private SelenideElement todayNextJoiningDate = $x("//a[@id='calendarlink0']/preceding-sibling::a");
    @Name("Выберите дату")
    private SelenideElement calendarLink = $x("//a[@id='calendarlink0']");
    @Name("Календарь")
    private SelenideElement calendar = $x("//div[@id='calendarbox0']");
    @Name("Случайное число для выборки календаря - Дата приема на работу")
    private SelenideElement randomDate = $x("//td[4]/a");
    @Name("Случайное число для выборки календаря - День рождения")
    private SelenideElement randomBirthdayDate = $x("//*[@id=\"calendarin1\"]//a");
    @Name("Сегодня в виджете 'Календарь'")
    private SelenideElement todayInCalendarWidget = $x("//div[@id='calendarin0']/following-sibling::div/a[text()='Сегодня']");

    @Name("Текущий город")
    private SelenideElement currentCity2 = $x("//div[contains(@class, 'field-joining_date')]/following-sibling::div/div");
    @Name("Телефон")
    private SelenideElement phone = $x("//input[@id='id_phone']");

    @Name("День рождения")
    private SelenideElement birthday = $x("//input[@id='id_birth']");
    @Name("Сегодня рядом с полем 'День рождения'")
    private SelenideElement todayNextBirthday = $x("//a[@id='calendarlink1']/preceding-sibling::a");
    @Name("Выберите дату в поле 'День рождения'")
    private SelenideElement calendarLink1 = $(By.id("calendarlink1"));
    @Name("Календарь в поле 'День рождения'")
    private SelenideElement calendar1 = $(By.id("calendarbox1"));
    @Name("Сегодня в виджете 'Календарь' поля 'День рождения'")
    private SelenideElement todayInCalendarWidget1 = $x("//div[@id='calendarin1']/following-sibling::div/a[text()='Сегодня']");

    @Name("Гражданство")
    private SelenideElement dropdownCitizenship = $x("//select[@id='id_citizenship']");
    @Name("Изменить выбранный объект типа Гражданство")
    private SelenideElement changeCitizenship = $x("//a[@id='change_id_citizenship']");
    @Name("Добавить еще один объект типа Гражданство")
    private SelenideElement addCitizenship = $x("//a[@id='add_id_citizenship']");
    @Name("Удалить выбранный объект типа Гражданство")
    private SelenideElement deleteCitizenship = $x("//a[@id='delete_id_citizenship']");

    @Name("Корпоративная почта")
    private SelenideElement corpEmail = $x("//div[contains(@class, 'field-internal_email')]/div[@class='readonly']");
    @Name("Email")
    private SelenideElement email = $x("//input[@id='id_internal_email']");

    @Name("Название организации основное")
    private SelenideElement orgName = $x("//div[contains(@class, 'field-organisation_names')]/div/div");

    //РАЗДЕЛЫ
    @Name("Показать Квалификация")
    private SelenideElement showQualification = $x("//a[@id='fieldsetcollapser0']");
    @Name("Скрыть Квалификация")
    private SelenideElement hideQualification = $x("//a[@id='fieldsetcollapser0']");
// ДАННЫЙ РО БУДЕТ УДАЛЕН -> БУДЕТ ИСПОЛЬЗОВАТЬСЯ: Показать Квалификация
    @Name("Квалификация")
    private SelenideElement qualification = $x("//div[contains(@id, 'content')]/div/form/div/fieldset/h2[text()=\"Квалификация\"]/a");
    @Name("Список квалификаций")
    private ElementsCollection keyQualification = $$x("//ul[@id='id_qualification_skill']/li");
    @Name("Добавить еще один объект типа Квалификация")
    private SelenideElement addQualificationSkill = $x("//a[@id='add_id_qualification_skill']");
// КТО ИСПОЛЬЗУЕТ ЭТОТ РО, ПЕРЕПИШИТЕ СВОЙ ТЕСТ НА КОЛЛЕКЦИЮ, СМ. ЭЛЕМЕНТ НИЖЕ
    @Name("Общие квалификации: Автоматизированное тестирование")
    private SelenideElement qualificationSkill0 = $x("//input[@id='id_qualification_skill_0']");
    @Name("Все квалификации")
    private ElementsCollection AllQualifications = $$x("//ul[@id='id_qualification_skill']/li/label/input");

    @Name("Показать Навыки")
    private SelenideElement showSkills = $x("//a[@id='fieldsetcollapser1']");
    @Name("Скрыть Навыки")
    private SelenideElement hideSkills = $x("//a[@id='fieldsetcollapser1']");
// ДАННЫЙ РО БУДЕТ УДАЛЕН -> БУДЕТ ИСПОЛЬЗОВАТЬСЯ: Показать Навыки
    @Name("Навыки")
    private SelenideElement skills = $x("//div[contains(@id, 'content')]/div/form/div/fieldset/h2[text()=\"Навыки\"]/a");
    @Name("Список навыков")
    private ElementsCollection keySkill = $$x("//ul[@id='id_key_skill']/li");
// КТО ИСПОЛЬЗУЕТ ЭТОТ РО, ПЕРЕПИШИТЕ СВОЙ ТЕСТ НА КОЛЛЕКЦИЮ, СМ. ЭЛЕМЕНТ НИЖЕ
    @Name("Языки программирования: C# 5.0")
    private SelenideElement keySkill0 = $x("//input[@id='id_key_skill_0']");
    @Name("Все навыки")
    private ElementsCollection allSkills = $$x("//ul[@id='id_key_skill']/li/label/input");

    @Name("Показать Сертификаты")
    private SelenideElement showCertificates = $x("//a[@id='fieldsetcollapser2']");
    @Name("Скрыть Сертификаты")
    private SelenideElement hideCertificates = $x("//a[@id='fieldsetcollapser2']");
// ДАННЫЙ РО БУДЕТ УДАЛЕН -> БУДЕТ ИСПОЛЬЗОВАТЬСЯ: Показать Сертификаты
    @Name("Сертификаты")
    private SelenideElement certification = $x("//div[contains(@id, 'content')]/div/form/div/fieldset/h2[text()=\"Сертификаты\"]/a");
    @Name("Сертификаты:")
    private SelenideElement AllCertification = $x("//textarea[@id='id_certificates']");
    @Name("Курсы")
    private SelenideElement courses = $x("//textarea[@id='id_courses']");
// ДАННЫЙ РО БУДЕТ УДАЛЕН -> БУДЕТ ИСПОЛЬЗОВАТЬСЯ: Курсы
    @Name("Курсы:")
    private SelenideElement AllCourses = $x("//textarea[@id='id_courses']");

    @Name("Показать Статус сотрудника")
    private SelenideElement showEmployeeStatus = $x("//a[@id='fieldsetcollapser3']");
    @Name("Скрыть Статус сотрудника")
    private SelenideElement hideEmployeeStatus = $x("//a[@id='fieldsetcollapser3']");
    @Name("Список статусов сотрудников")
    private ElementsCollection keyEmployeeStatus = $$x("//div/input[@type='checkbox']/parent::div");
    @Name("Работает")
    private SelenideElement isActive = $x("//input[@id='id_is_active']");

    @Name("Показать ОБРАЗОВАНИЯ")
    private SelenideElement showEducation = $x("//a[@id='fieldsetcollapser4']");
    @Name("Скрыть ОБРАЗОВАНИЯ")
    private SelenideElement hideEducation = $x("//a[@id='fieldsetcollapser4']");
    @Name("Добавить еще один Образование")
    private SelenideElement addEducation = $x("//a[text()='Добавить еще один Образование']");
    @Name("Изменить выбранный объект типа ВУЗ")
    private SelenideElement editEducation = $x("//a[@id='change_id_employeeeducation_set-0-institution']");
    @Name("ВУЗ")
    private SelenideElement institution = $x("//select[@id='id_employeeeducation_set-0-institution']");
    @Name("УРОВЕНЬ ОБРАЗОВАНИЯ")
    private SelenideElement degree = $x("//select[@id='id_employeeeducation_set-0-degree']");
    @Name("Изменить выбранный объект типа УРОВЕНЬ ОБРАЗОВАНИЯ")
    private SelenideElement editDegree = $x("//a[@id='change_id_employeeeducation_set-0-degree']");
    @Name("СПЕЦИАЛЬНОСТЬ")
    private SelenideElement specialty = $x("//select[@id='id_employeeeducation_set-0-specialty']");
    @Name("Изменить выбранный объект типа СПЕЦИАЛЬНОСТЬ")
    private SelenideElement editSpecialty = $x("//a[@id='change_id_employeeeducation_set-0-specialty']");
    @Name("ДАТА НАЧАЛА")
    private SelenideElement startDateOfEducation = $x("//input[@id='id_employeeeducation_set-0-start_date']");
    @Name("ДАТА ОКОНЧАНИЯ")
    private SelenideElement endDateOfEducation = $x("//input[@id='id_employeeeducation_set-0-end_date']");

    @Name("Должности")
    private SelenideElement employerPost = $x("//a[@id='fieldsetcollapser5']");
    @Name("Добавить еще один Должность")
    private SelenideElement addPost = $x("//tr[@id='employeeposition_set-empty']/following-sibling::tr//a");
    @Name("Изменить выбранный объект типа Должность")
    private SelenideElement changeObjectPost = $x("//a[@id='change_id_employeeposition_set-0-position']");
    @Name("Должность")
    private ElementsCollection postOfEmployer = $$x("//select[@id='id_employeeposition_set-0-position']/option");
    @Name("Название организации")
    private ElementsCollection nameOfOrganization = $$x("//select[@name='employeeposition_set-0-organisation']/option");
    @Name("Ставка")
    private SelenideElement rateOfEmployer = $x("//input[@name='employeeposition_set-0-rate']");
    @Name("Грейд")
    private SelenideElement gradeOfEmployer = $x("//input[@name='employeeposition_set-0-grade']");
    @Name("Дата начала должности")
    private SelenideElement dateOfStart = $x("//input[@name='employeeposition_set-0-start_date']");
    @Name("Дата окончания должности")
    private SelenideElement dateOfFinish = $x("//input[@name='employeeposition_set-0-end_date']");
    @Name("Заметка Должности")
    private SelenideElement pointOfPosts = $x("//textarea[@name='employeeposition_set-0-memo']");

    @Name("Грейды")
    private SelenideElement grades = $x("//a[@id='fieldsetcollapser6']");
    @Name("Добавить еще один Грейд")
    private SelenideElement addAnotherGrade = $x("//tr[@id='employeepositiongrade_set-empty']/following-sibling::tr//a");
    @Name("Заметка Грейды")
    private SelenideElement pointOfGrades = $x("//textarea[@name='employeepositiongrade_set-0-memo']");

// ДАННЫЙ РО БУДЕТ УДАЛЕН -> БУДЕТ ИСПОЛЬЗОВАТЬСЯ: Проекты
    @Name("Проект")
    private SelenideElement project = $x("//a[@id='fieldsetcollapser7']");
    @Name("Проекты")
    private SelenideElement projects = $x("//a[@id='fieldsetcollapser7']");
// ДАННЫЙ РО БУДЕТ УДАЛЕН -> БУДЕТ ИСПОЛЬЗОВАТЬСЯ: Добавить еще один проект
    @Name("Добавить проект")
    private SelenideElement addProject = $x("//a[text()='Добавить еще один Проект']");
    @Name("Добавить еще один Проект")
    private SelenideElement newProject = $x("//tr[@id='employeeproject_set-empty']/following-sibling::tr/td/a");
    @Name("Новый проект")
    private SelenideElement lastProject = $x("//div[@id='employeeproject_set-group']//fieldset/table/tbody/tr[@id = 'employeeproject_set-1']");
    @Name("Выбор проекта")
    private SelenideElement projectName = lastProject.find(By.xpath("./td[@class = 'field-project']/div/select"));
    @Name("Вид тестирования")
    private SelenideElement testingType = lastProject.find(By.xpath("./td[@class = 'field-testing_type']/div/select"));
    @Name("Проектная роль")
    private SelenideElement projectRole = lastProject.find(By.xpath("./td[@class = 'field-project_role']/div/select"));
    @Name("Обратная связь")
    private SelenideElement feedBack = lastProject.find(By.xpath("./td[@class = 'field-feedback']/textarea"));
    @Name("Дата начала проекты")
    private SelenideElement dateOfStartProject = $x("//input[@name='employeeproject_set-0-start_date']");
    @Name("Дата окончания проекты")
    private SelenideElement dateOfFinishProject = $x("//input[@name='employeeproject_set-0-end_date']");
    @Name("Дата окончания: Сегодня")
    private SelenideElement endDateToday = lastProject.find(By.xpath("./td[@class = 'field-end_date']/span/a"));
    @Name("Обязанности")
    private SelenideElement responsibilities = lastProject.find(By.xpath("./td[@class = 'field-responsibilities']/textarea"));
// ДАННЫЙ РО БУДЕТ УДАЛЕН -> БУДЕТ ИСПОЛЬЗОВАТЬСЯ: Обязанности
    @Name("Обязанности проекты")
    private SelenideElement duties = $x("//textarea[@name='employeeproject_set-0-responsibilities']");
    @Name("СТАЖЕР")
    private SelenideElement trainee = lastProject.find(By.xpath("./td[@class = 'field-is_trainee']/input"));
// ДАННЫЙ РО БУДЕТ УДАЛЕН -> БУДЕТ ИСПОЛЬЗОВАТЬСЯ: СТАЖЕР
    @Name("Чекбокс Стажер")
    private SelenideElement checkBoxJun = $x("//input[@name='employeeproject_set-0-is_trainee']");
    @Name("Изменить выбранный объект типа Проект")
    private SelenideElement changeObjectProject = $x("//a[@id='change_id_employeeproject_set-0-project']");
    @Name("Проекты Проект")
    private ElementsCollection projectOfEmployer = $$x("//select[@id='id_employeeproject_set-0-project']/option");
    @Name("Тип тестирования")
    private ElementsCollection typeOfTests = $$x("//select[@name='employeeproject_set-0-testing_type']/option");
    @Name("Проектная роль проекты")
    private ElementsCollection projectPostEmp = $$x("//select[@name='employeeproject_set-0-project_role']/option");

    @Name("Проектные ставки")
    private SelenideElement projectBids = $x("//a[@id='fieldsetcollapser8']");
    @Name("Добавить еще один Проектная ставка")
    private SelenideElement addProjectBid = $x("//tr[@id='employeeprojectsalaryrate_set-empty']/following-sibling::tr//a");
    @Name("Проект Проектные ставки")
    private SelenideElement fieldProjectP = $x("//select[@name='employeeprojectsalaryrate_set-0-employee_project']");
    @Name("Скрыть")
    private SelenideElement hideProjectBids = $x("//fieldset[@class='module collapse']/h2/a[@class='collapse-toggle']");

    @Name("Договоры")
    private SelenideElement contracts = $x("//a[@id='fieldsetcollapser9']");
    @Name("Добавить еще один Договор")
    private SelenideElement addAnotherContract = $x("//tr[@id='contract-empty']/following-sibling::tr//a");
    @Name("Договоры Должность")
    private SelenideElement fieldPost = $x("//select[@name='contract-0-position']");

    @Name("Договоры ГПХ")
    private SelenideElement contractsGpx = $x("//a[@id='fieldsetcollapser10']");
    @Name("Добавить еще один Договор ГПХ")
    private SelenideElement addAnotherContractGpx = $x("//tr[@id='employeecivilcontract_set-empty']/following-sibling::tr//a");
    @Name("Номер договора")
    private SelenideElement numberOfContract = $x("//input[@name='employeecivilcontract_set-0-number']");

    @Name("Города")
    private SelenideElement cities = $x("//a[@id='fieldsetcollapser11']");
// ДАННЫЙ РО БУДЕТ УДАЛЕН -> БУДЕТ ИСПОЛЬЗОВАТЬСЯ: Список городов
    @Name("Город")
    private SelenideElement fieldCity = $x("//select[@name='employeecity_set-0-city']");
    @Name("Список городов")
    private SelenideElement listOfcities = $x("//select[@name='employeecity_set-0-city']");
    @Name("Дата изменения")
    private SelenideElement dateOfChange = $x("//th[@class='column-change_date required'][1]");
    @Name("Сегодня")
    private ElementsCollection todayCity = $$x("//span[@class='datetimeshortcuts']/a[text()='Сегодня']");
    @Name("Сегодня2")
    private SelenideElement todayCity2 = $x("//input[@name='employeecity_set-0-change_date']/following-sibling::span/a[text()='Сегодня']");
    @Name("Добавить еще один Город")
    private SelenideElement addAnotherCity = $x("//tr[@id='employeecity_set-empty']/following-sibling::tr//a");

    @Name("Иностранные языки")
    private SelenideElement foreignLanguages = $x("//a[@id='fieldsetcollapser12']");
    @Name("Добавить еще один Иностранный язык")
    private SelenideElement addAnotherLanguage = $x("//tr[@id='employeelanguage_set-empty']/following-sibling::tr//a");
    @Name("Иностранный язык")
    private SelenideElement forLanguage = $x("//select[@name='employeelanguage_set-0-language']");

    @Name("Предыдущий опыт работы")
    private SelenideElement previousExperience = $x("//a[@id='fieldsetcollapser13']");
    @Name("Добавить еще один Предыдущий опыт работы")
    private SelenideElement addAnotherExperience = $x("//tr[@id='employeepreviousexperience_set-empty']/following-sibling::tr//a");
    @Name("Название организации опыта")
    private SelenideElement nameOrganizExp = $x("//select[@name='employeepreviousexperience_set-0-organisation']");

    @Name("Достижения")
    private SelenideElement achievements = $x("//a[@id='fieldsetcollapser14']");
    @Name("Добавить еще один Достижение")
    private SelenideElement addAnotherAchievement = $x("//tr[@id='employeeachievement_set-empty']/following-sibling::tr//a");
    @Name("Достижение")
    private SelenideElement achievement = $x("//select[@name='employeeachievement_set-0-achievement']");

    @Name("Запросы на отпуск")
    private SelenideElement vacationRequests = $x("//a[@id='fieldsetcollapser15']");
    @Name("Добавить еще один Запрос на отпуск")
    private SelenideElement addAnotherVacRequest = $x("//tr[@id='employeevacationrequest_set-empty']/following-sibling::tr//a");
    @Name("Статус запроса")
    private SelenideElement vacRequestStatus = $x("//select[@name='employeevacationrequest_set-0-request_status']");

    @Name("Фактические отпуска")
    private SelenideElement actualVacationsShow = $x("//div[@id='employeeactualvacation_set-group']/div//fieldset/h2/a");
    @Name("Заметка")
    private SelenideElement fieldActualVacations = $x("//th[@class='column-vacation_request']/preceding-sibling::th[@class='column-memo']");
    @Name("Заметка поле")
    private SelenideElement getActualVacations = $x("//a[@id='fieldsetcollapser16']/../following-sibling::table//tbody");
    @Name("Скрыть отпуска")
    private SelenideElement hideActualVacations = $x("//a[@id='fieldsetcollapser16']");

    @Name("Больничные")
    private SelenideElement sickLeaveShow = $x("//a[@id='fieldsetcollapser17']");
    @Name("Добавить больничный")
    private SelenideElement addSickLeave = $x("//tr[@id='employeesickleaveofficial_set-empty']/following-sibling::tr//a");
    @Name("Номер больничного листа")
    private SelenideElement numberSickLeave = $x("//input[@id='id_employeesickleaveofficial_set-0-notes_number']");
    @Name("Скрыть больничный")
    private SelenideElement hideSickLeave = $x("//a[@id='fieldsetcollapser17']");

    @Name("Бюллетени без больничного листа")
    private SelenideElement bulletinWithoutLeaveShow = $x("//a[@id='fieldsetcollapser18']");
    @Name("Добавить бюллетень")
    private SelenideElement addBulletinWithoutLeave = $x("//tr[@id='employeesickleaveunofficial_set-empty']/following-sibling::tr//a");
    @Name("Дата бюллетеня")
    private SelenideElement dateBulletinWithoutLeave = $x("//input[@id='id_employeesickleaveunofficial_set-0-date']");
    @Name("Скрыть бюллетень")
    private SelenideElement hideBulletinWithoutLeave = $x("//a[@id='fieldsetcollapser18']");

    @Name("Семья")
    private SelenideElement familyShow = $x("//a[@id='fieldsetcollapser19']");
    @Name("Добавить семья")
    private SelenideElement addFamily = $x("//tr[@id='Family-empty']/following-sibling::tr//a");
    @Name("Родственная связь")
    private SelenideElement kinship = $x("//select[contains(@id, 'relationship')]");
    @Name("Скрыть семья")
    private SelenideElement hideFamily = $x("//h2[contains(text(), 'Семья')]/a");

    //СООБЩЕНИЯ ОБ ОШИБКАХ ВВОДА
    @Name("Сообщение об ошибке Имя")
    private SelenideElement errorFirstName = $x("//div[contains(@class, 'field-name')]/ul/li");
    @Name("Сообщение об ошибке Фамилия")
    private SelenideElement errorSurname = $x("//div[contains(@class, 'field-surname')]/ul/li");
    @Name("Сообщение об ошибке Фото")
    private SelenideElement errorPhoto = $x("//div[contains(@class, 'field-photo')]/ul/li");
    @Name("Сообщение об ошибке Пол")
    private SelenideElement errorGender = $x("//div[contains(@class, 'field-gender')]/ul/li");
    @Name("Сообщение об ошибке Дата приема на работу")
    private SelenideElement errorJoiningDate = $x("//div[contains(@class, 'field-joining_date')]/ul/li");
    @Name("Сообщение об ошибке Телефон")
    private SelenideElement errorPhone = $x("//div[contains(@class, 'field-phone')]/ul/li");
    @Name("Сообщение об ошибке Email")
    private SelenideElement errorEmail = $x("//div[contains(@class, 'field-internal_email')]/ul/li");

    //КНОПКИ В НИЗУ
    @Name("Удалено")
    private SelenideElement delete = $(By.className("deletelink"));
    @Name("Сохранить и добавать другой объект")
    private SelenideElement saveAndAddAnother = $x("//input[@name='_addanother']");
    @Name("Сохранить и продолжить редактирование")
    private SelenideElement saveAndContinue = $x("//input[@name='_continue']");
    @Name("Сохранить")
    private SelenideElement save = $x("//input[@name='_save']");
}
