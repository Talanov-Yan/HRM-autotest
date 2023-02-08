package pages;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.*;

/**
 * PageObject, описывающий страницу 'Администрирование'
 * http://178.154.246.238:58082/admin/
 */
@Name(value = "DjangoAdministration")
public class DjangoAdministrationPage extends WebPage {

    //HEADER
    @Name("Первый элемент блока Мои действия")
    private SelenideElement blockMyActionsFirstElement = $x("//div[@id='recent-actions-module']//li//a");
    @Name("Изменить пароль")
    SelenideElement changePassword = $x("//a[@href='/admin/password_change/']");
    @Name("Выйти")
    SelenideElement logout = $x("//a[@href='/admin/logout/']");

    @Name("Администрирование Django")
    private SelenideElement headerPage = $x("//a[@href='/admin/']");

    @Name("Инфоблок")
    private SelenideElement tableHeader = $x("//div[@id='content']/h1");

    //MAIN
    @Name("Сотрудники")
    private SelenideElement employee = $x("//tr[@class='model-employee']/th/a");
    @Name("Добавить поле Сотрудники")
    private SelenideElement addEmployee = $x("//tr[@class='model-employee']//a[@class='addlink']");
    @Name("Изменить поле Сотрудники")
    private SelenideElement changeEmployee = $x("//tr[@class='model-employee']//a[@class='changelink']");

    @Name("Администраторы аккаунта")
    private SelenideElement accountAdmin = $x("//tr[@class='model-accountadmin']/th/a");
    @Name("Добавить поле Администраторы аккаунта")
    private SelenideElement addAccountAdmin = $x("//tr[@class='model-accountadmin']//a[@class='addlink']");
    @Name("Изменить поле Администраторы аккаунта")
    private SelenideElement changeAccountAdmin = $x("//tr[@class='model-accountadmin']//a[@class='changelink']");

    @Name("Запросы на отпуск")
    private SelenideElement vacationRequest = $x("//tr[@class='model-employeevacationrequest']/th/a");
    @Name("Добавить поле Запросы на отпуск")
    private SelenideElement addVacationRequest = $x("//tr[@class='model-employeevacationrequest']//a[@class='addlink']");
    @Name("Изменить поле Запросы на отпуск")
    private SelenideElement changeVacationRequest = $x("//tr[@class='model-employeevacationrequest']//a[@class='changelink']");

    @Name("Фактические отпуска")
    private SelenideElement actualVacation = $x("//tr[@class='model-employeeactualvacation']/th/a");
    @Name("Добавить поле Фактические отпуска")
    private SelenideElement addActualVacation = $x("//tr[@class='model-employeeactualvacation']//a[@class='addlink']");
    @Name("Изменить поле Фактические отпуска")
    private SelenideElement changeActualVacation = $x("//tr[@class='model-employeeactualvacation']//a[@class='changelink']");

    @Name("Больничные")
    private SelenideElement sickLeaveOfficial = $x("//tr[@class='model-employeesickleaveofficial']/th/a");
    @Name("Добавить поле Больничные")
    private SelenideElement addSickLeaveOfficial = $x("//tr[@class='model-employeesickleaveofficial']//a[@class='addlink']");
    @Name("Изменить поле Больничные")
    private SelenideElement changeSickLeaveOfficial = $x("//tr[@class='model-employeesickleaveofficial']//a[@class='changelink']");

    @Name("Бюллютени без больничного листа")
    private SelenideElement sickLeaveUnofficial = $x("//tr[@class='model-employeesickleaveunofficial']/th/a");
    @Name("Добавить поле Бюллютени без больничного листа")
    private SelenideElement addSickLeaveUnofficial = $x("//tr[@class='model-employeesickleaveunofficial']//a[@class='addlink']");
    @Name("Изменить поле Бюллютени без больничного листа")
    private SelenideElement changeSickLeaveUnofficial = $x("//tr[@class='model-employeesickleaveunofficial']//a[@class='changelink']");

    @Name("Проектные ставки")
    private SelenideElement projectSalaryRate = $x("//tr[@class='model-employeeprojectsalaryrate']/th/a");
    @Name("Добавить поле Проектные ставки")
    private SelenideElement addProjectSalaryRate = $x("//tr[@class='model-employeeprojectsalaryrate']//a[@class='addlink']");
    @Name("Изменить поле Проектные ставки")
    private SelenideElement changeProjectSalaryRate = $x("//tr[@class='model-employeeprojectsalaryrate']//a[@class='changelink']");

    //ACCOUNTS
    @Name("Аккаунты")
    private SelenideElement account = $x("//tr[@class='model-account']/th/a");
    @Name("Добавить поле Аккаунты")
    private SelenideElement addAccount = $x("//tr[@class='model-account']//a[@class='addlink']");
    @Name("Изменить поле Аккаунты")
    private SelenideElement changeAccount = $x("//tr[@class='model-account']//a[@class='changelink']");

    @Name("Проекты")
    private SelenideElement project = $x("//tr[@class='model-project']/th/a");
    @Name("Добавить поле Проекты")
    private SelenideElement addProject = $x("//tr[@class='model-project']//a[@class='addlink']");
    @Name("Изменить поле Проекты")
    private SelenideElement changeProject = $x("//tr[@class='model-project']//a[@class='changelink']");

    //STRUCTURE
    @Name("Департаменты")
    private SelenideElement department = $x("//tr[@class='model-department']/th/a");
    @Name("Добавить поле Департаменты")
    private SelenideElement addDepartment = $x("//tr[@class='model-department']//a[@class='addlink']");
    @Name("Изменить поле Департаменты")
    private SelenideElement changeDepartment = $x("//tr[@class='model-department']//a[@class='changelink']");

    @Name("Должности")
    private SelenideElement position = $x("//tr[@class='model-position']/th/a");
    @Name("Добавить поле Должности")
    private SelenideElement addPosition = $x("//tr[@class='model-position']//a[@class='addlink']");
    @Name("Изменить поле Должности")
    private SelenideElement changePosition = $x("//tr[@class='model-position']//a[@class='changelink']");

    @Name("Проектные роли")
    private SelenideElement projectRole = $x("//tr[@class='model-projectrole']/th/a");
    @Name("Добавить поле Проектные роли")
    private SelenideElement addProjectRole = $x("//tr[@class='model-projectrole']//a[@class='addlink']");
    @Name("Изменить поле Проектные роли")
    private SelenideElement changeProjectRole = $x("//tr[@class='model-projectrole']//a[@class='changelink']");

    @Name("Типы тестирования")
    private SelenideElement testingType = $x("//tr[@class='model-testingtype']/th/a");
    @Name("Добавить поле Типы тестирования")
    private SelenideElement addTestingType = $x("//tr[@class='model-testingtype']//a[@class='addlink']");
    @Name("Изменить поле Типы тестирования")
    private SelenideElement changeTestingType = $x("//tr[@class='model-testingtype']//a[@class='changelink']");

    //DICTIONARY
    @Name("Города")
    private SelenideElement city = $x("//tr[@class='model-city']/th/a");
    @Name("Добавить поле Города")
    private SelenideElement addCity = $x("//tr[@class='model-city']//a[@class='addlink']");
    @Name("Изменить поле Города")
    private SelenideElement changeCity = $x("//tr[@class='model-city']//a[@class='changelink']");

    @Name("Гражданства")
    private SelenideElement citizenship = $x("//tr[@class='model-citizenship']/th/a");
    @Name("Добавить поле Гражданства")
    private SelenideElement addCitizenship = $x("//tr[@class='model-citizenship']//a[@class='addlink']");
    @Name("Изменить поле Гражданства")
    private SelenideElement changeCitizenship = $x("//tr[@class='model-citizenship']//a[@class='changelink']");

    @Name("ВУЗы")
    private SelenideElement educationInstitution = $x("//tr[@class='model-educationinstitution']/th/a");
    @Name("Добавить поле ВУЗы")
    private SelenideElement addEducationInstitution = $x("//tr[@class='model-educationinstitution']//a[@class='addlink']");
    @Name("Изменить поле ВУЗы")
    private SelenideElement changeEducationInstitution = $x("//tr[@class='model-educationinstitution']//a[@class='changelink']");

    @Name("Достижения")
    private SelenideElement achievement = $x("//tr[@class='model-achievement']/th/a");
    @Name("Добавить поле Достижения")
    private SelenideElement addAchievement = $x("//tr[@class='model-achievement']//a[@class='addlink']");
    @Name("Изменить поле Достижения")
    private SelenideElement changeAchievement = $x("//tr[@class='model-achievement']//a[@class='changelink']");

    @Name("Должности в сторонних организациях")
    private SelenideElement outsideRole = $x("//tr[@class='model-outsiderole']/th/a");
    @Name("Добавить поле Должности в сторонних организациях")
    private SelenideElement addOutsideRole = $x("//tr[@class='model-outsiderole']//a[@class='addlink']");
    @Name("Изменить поле Должности в сторонних организациях")
    private SelenideElement changeOutsideRole = $x("//tr[@class='model-outsiderole']//a[@class='changelink']");

    @Name("Иностранные языки")
    private SelenideElement language = $x("//tr[@class='model-language']/th/a");
    @Name("Добавить поле Иностранные языки")
    private SelenideElement addLanguage = $x("//tr[@class='model-language']//a[@class='addlink']");
    @Name("Изменить поле Иностранные языки")
    private SelenideElement changeLanguage = $x("//tr[@class='model-language']//a[@class='changelink']");

    @Name("Названия организации")
    private SelenideElement organisation = $x("//tr[@class='model-organisation']/th/a");
    @Name("Добавить поле Названия организации")
    private SelenideElement addOrganisation = $x("//tr[@class='model-organisation']//a[@class='addlink']");
    @Name("Изменить поле Названия организации")
    private SelenideElement changeOrganisation = $x("//tr[@class='model-organisation']//a[@class='changelink']");

    @Name("Образования")
    private SelenideElement education = $x("//tr[@class='model-education']/th/a");
    @Name("Добавить поле Образования")
    private SelenideElement addEducation = $x("//tr[@class='model-education']//a[@class='addlink']");
    @Name("Изменить поле Образования")
    private SelenideElement changeEducation = $x("//tr[@class='model-education']//a[@class='changelink']");

    @Name("Специальности (ВУЗ)")
    private SelenideElement educationSpecialty = $x("//tr[@class='model-educationspecialty']/th/a");
    @Name("Добавить поле Специальности (ВУЗ)")
    private SelenideElement addEducationSpecialty = $x("//tr[@class='model-educationspecialty']//a[@class='addlink']");
    @Name("Изменить поле Специальности (ВУЗ)")
    private SelenideElement changeEducationSpecialty = $x("//tr[@class='model-educationspecialty']//a[@class='changelink']");

    @Name("Сторонние организации")
    private SelenideElement outsideOrganisation = $x("//tr[@class='model-outsideorganisation']/th/a");
    @Name("Добавить поле Сторонние организации")
    private SelenideElement addOutsideOrganisation = $x("//tr[@class='model-outsideorganisation']//a[@class='addlink']");
    @Name("Изменить поле Сторонние организации")
    private SelenideElement changeOutsideOrganisation = $x("//tr[@class='model-outsideorganisation']//a[@class='changelink']");

    @Name("Типы навыков")
    private SelenideElement keySkillType = $x("//tr[@class='model-keyskilltype']/th/a");
    @Name("Добавить поле Типы навыков")
    private SelenideElement addKeySkillType = $x("//tr[@class='model-keyskilltype']//a[@class='addlink']");
    @Name("Изменить поле Типы навыков")
    private SelenideElement changeKeySkillType = $x("//tr[@class='model-keyskilltype']//a[@class='changelink']");

    @Name("Типы квалификации")
    private SelenideElement qualificationSkillType = $x("//tr[@class='model-qualificationskilltype']/th/a");
    @Name("Добавить поле Типы квалификации")
    private SelenideElement addQualificationSkillType = $x("//tr[@class='model-qualificationskilltype']//a[@class='addlink']");
    @Name("Изменить поле Типы квалификации")
    private SelenideElement changeQualificationSkillType = $x("//tr[@class='model-qualificationskilltype']//a[@class='changelink']");

    @Name("Показатели квалификации")
    private SelenideElement qualificationSkills = $x("//tr[@class='model-qualificationskills']/th/a");
    @Name("Добавить поле Показатели квалификации")
    private SelenideElement addQualificationSkills = $x("//tr[@class='model-qualificationskills']//a[@class='addlink']");
    @Name("Изменить поле Показатели квалификации")
    private SelenideElement changeQualificationSkills = $x("//tr[@class='model-qualificationskills']//a[@class='changelink']");

    @Name("Уровни знания иностранного языка")
    private SelenideElement languageKnowledgeLevel = $x("//tr[@class='model-languageknowledgelevel']/th/a");
    @Name("Добавить поле Уровни знания иностранного языка")
    private SelenideElement addLanguageKnowledgeLevel = $x("//tr[@class='model-languageknowledgelevel']//a[@class='addlink']");
    @Name("Изменить поле Уровни знания иностранного языка")
    private SelenideElement changeLanguageKnowledgeLevel = $x("//tr[@class='model-languageknowledgelevel']//a[@class='changelink']");

    @Name("Статусы запроса на отпуск")
    private SelenideElement vacationRequestStatus = $x("//tr[@class='model-vacationrequeststatus']/th/a");
    @Name("Добавить поле Статусы запроса на отпуск")
    private SelenideElement addVacationRequestStatus = $x("//tr[@class='model-vacationrequeststatus']//a[@class='addlink']");
    @Name("Изменить поле Статусы запроса на отпуск")
    private SelenideElement changeVacationRequestStatus = $x("//tr[@class='model-vacationrequeststatus']//a[@class='changelink']");

    @Name("Тип родства")
    private SelenideElement familyType = $x("//tr[@class='model-familytype']/th/a");
    @Name("Добавить поле Тип родства")
    private SelenideElement addFamilyType = $x("//tr[@class='model-familytype']//a[@class='addlink']");
    @Name("Изменить поле Тип родства")
    private SelenideElement changeFamilyType = $x("//tr[@class='model-familytype']//a[@class='changelink']");

    //ADMINISTRATIVE ACCESS
    @Name("Сотрудники с административным доступом")
    private SelenideElement adminEmployee = $x("//tr[@class='model-administrator']/th/a");
    @Name("Добавить поле Сотрудники с административным доступом")
    private SelenideElement addAdminEmployee = $x("//tr[@class='model-administrator']//a[@class='addlink']");
    @Name("Изменить поле Сотрудники с административным доступом")
    private SelenideElement changeAdminEmployee = $x("//tr[@class='model-administrator']//a[@class='changelink']");

    //USERS AND GROUP
    @Name("Группы")
    private SelenideElement group = $x("//tr[@class='model-group']/th/a");
    @Name("Добавить поле Группы")
    private SelenideElement addGroup = $x("//tr[@class='model-group']//a[@class='addlink']");
    @Name("Изменить поле Группы")
    private SelenideElement changeGroup = $x("//tr[@class='model-group']//a[@class='changelink']");

    @Name("Пользователи")
    private SelenideElement user = $x("//tr[@class='model-user']/th/a");
    @Name("Добавить поле Пользователи")
    private SelenideElement addUser = $x("//tr[@class='model-user']//a[@class='addlink']");
    @Name("Изменить поле Пользователи")
    private SelenideElement changeUser = $x("//tr[@class='model-user']//a[@class='changelink']");

    //OTP_TOTP
    @Name("TOTP devices")
    private SelenideElement totp = $x("//tr[@class='model-totpdevice']/th/a");
    @Name("Добавить поле TOTP devices")
    private SelenideElement addTotp = $x("//tr[@class='model-totpdevice']//a[@class='addlink']");
    @Name("Изменить поле TOTP devices")
    private SelenideElement changeTotp = $x("//tr[@class='model-totpdevice']//a[@class='changelink']");

    @Name("Войти снова")
    SelenideElement loginAgain = $x("//div[@id='content']/p/a[@href='/admin/']");
    //Пользователи и группы
    @Name("Модели в приложении Пользователи и группы")
    private SelenideElement enployeesAndGroupes = $x("//tr[@class='model-group']");

    //Otp_Totp
    @Name("Модели в приложении Otp_Totp")
    private SelenideElement otpTotr = $x("//tr[@class='model-totpdevice']");
}
