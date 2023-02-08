package ts4_1;

import hooks.WebHooks;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.lanit.at.api.testcontext.ContextHolder;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.WebCheckSteps;
import steps.WebSteps;


public class AdministrationHrRolePositiveTest extends WebHooks {
    private final PageManager pageManager = new PageManager();

    private final WebCheckSteps webCheckSteps = new WebCheckSteps(pageManager);
    private final WebSteps webSteps = new WebSteps(pageManager);

    private void initialize() {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin("hr");
        webSteps.setPage("DjangoAdministration");
    }

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
              /*4.1.2*/  {"Изменить поле Сотрудники","DjangoAdministration","Выберите Сотрудник для изменения" },
              /*4.1.3*/  {"Администраторы аккаунта", "DjangoAdministration", "Выберите Администратор аккаунта для изменения"},
              /*4.1.4*/  {"Добавить поле Администраторы аккаунта", "DjangoAdministration", "Добавить Администратор аккаунта"},
              /*4.1.5 */ {"Изменить поле Администраторы аккаунта", "DjangoAdministration", "Выберите Администратор аккаунта для изменения"},
              /*4.1.6 */ {"Запросы на отпуск", "DjangoAdministration", "Выберите Запрос на отпуск для изменения"},
              /*4.1.7 */ {"Добавить поле Запросы на отпуск", "DjangoAdministration", "Добавить Запрос на отпуск"},
              /*4.1.8 */ {"Изменить поле Запросы на отпуск", "DjangoAdministration", "Выберите Запрос на отпуск для изменения"},
              /*4.1.9 */ {"Фактические отпуска", "DjangoAdministration", "Выберите Фактический отпуск для изменения"},
              /*4.1.10*/ {"Добавить поле Фактические отпуска", "DjangoAdministration", "Добавить Фактический отпуск"},
              /*4.1.11*/ {"Изменить поле Фактические отпуска", "DjangoAdministration", "Выберите Фактический отпуск для изменения"},
              /*4.1.12*/ {"Больничные", "DjangoAdministration", "Выберите Больничный для изменения"},
              /*4.1.13*/ {"Добавить поле Больничные", "DjangoAdministration", "Добавить Больничный"},
              /*4.1.14*/ {"Изменить поле Больничные", "DjangoAdministration", "Выберите Больничный для изменения"},
              /*4.1.15*/ {"Бюллютени без больничного листа", "DjangoAdministration", "Выберите Бюллютень без больничного листа для изменения"},
              /*4.1.16*/ {"Добавить поле Бюллютени без больничного листа", "DjangoAdministration", "Добавить Бюллютень без больничного листа"},
              /*4.1.17*/ {"Изменить поле Бюллютени без больничного листа", "DjangoAdministration", "Выберите Бюллютень без больничного листа для изменения"},
              /*4.1.18*/ {"Проектные ставки", "DjangoAdministration", "Выберите Проектная ставка для изменения"},
              /*4.1.19*/ {"Изменить поле Проектные ставки", "DjangoAdministration", "Выберите Проектная ставка для изменения"},
              /*4.1.20*/ {"Аккаунты", "DjangoAdministration", "Выберите Аккаунт для изменения"},
              /*4.1.21*/ {"Добавить поле Аккаунты", "DjangoAdministration", "Добавить Аккаунт"},
              /*4.1.22*/ {"Изменить поле Аккаунты", "DjangoAdministration", "Выберите Аккаунт для изменения"},
              /*4.1.23*/ {"Проекты", "DjangoAdministration", "Выберите Проект для изменения"},
              /*4.1.24*/ {"Добавить поле Проекты", "DjangoAdministration", "Добавить Проект"},
              /*4.1.25*/ {"Изменить поле Проекты", "DjangoAdministration", "Выберите Проект для изменения"},
              /*4.1.26*/ {"Департаменты","DjangoAdministration" ,"Выберите Департамент для изменения" },
              /*4.1.27*/ {"Добавить поле Департаменты","DjangoAdministration" , "Добавить Департамент"},
              /*4.1.28*/ {"Изменить поле Департаменты","DjangoAdministration" ,"Выберите Департамент для изменения" },
              /*4.1.29*/ {"Должности","DjangoAdministration", "Выберите Должность для изменения"},
              /*4.1.30*/ {"Добавить поле Должности", "DjangoAdministration", "Добавить Должность"},
              /*4.1.31*/ {"Изменить поле Должности", "DjangoAdministration", "Выберите Должность для изменения"},
              /*4.1.32*/ {"Проектные роли","DjangoAdministration","Выберите Проектная роль для изменения"},
              /*4.1.33*/ {"Добавить поле Проектные роли","DjangoAdministration","Добавить Проектная роль"},
              /*4.1.34*/ {"Изменить поле Проектные роли","DjangoAdministration","Выберите Проектная роль для изменения"},
              /*4.1.35*/ {"Типы тестирования","DjangoAdministration" ,"Выберите Тип тестирования для изменения"},
              /*4.1.36*/ {"Добавить поле Типы тестирования","DjangoAdministration" ,"Добавить Тип тестирования"},
              /*4.1.37*/ {"Изменить поле Типы тестирования","DjangoAdministration" ,"Выберите Тип тестирования для изменения"},
              /*4.1.38*/ {"Города","DjangoAdministration","Выберите Город для изменения"},
              /*4.1.39*/ {"Добавить поле Города","DjangoAdministration","Добавить Город"},
              /*4.1.40*/ {"Изменить поле Города","DjangoAdministration","Выберите Город для изменения"},
              /*4.1.41*/ {"Гражданства","DjangoAdministration","Выберите Гражданство для изменения"},
              /*4.1.42*/ {"Добавить поле Гражданства","DjangoAdministration","Добавить Гражданство"},
              /*4.1.43*/ {"Изменить поле Гражданства","DjangoAdministration","Выберите Гражданство для изменения"},
              /*4.1.44*/ {"ВУЗы","DjangoAdministration","Выберите ВУЗ для изменения"},
              /*4.1.45*/ {"Добавить поле ВУЗы","DjangoAdministration","Добавить ВУЗ"},
              /*4.1.46*/ {"Изменить поле ВУЗы","DjangoAdministration","Выберите ВУЗ для изменения"},
              /*4.1.47*/ {"Достижения","DjangoAdministration","Выберите Достижение для изменения"},
              /*4.1.48*/ {"Добавить поле Достижения","DjangoAdministration","Добавить Достижение"},
              /*4.1.49*/ {"Изменить поле Достижения","DjangoAdministration","Выберите Достижение для изменения"},
              /*4.1.50*/ {"Должности в сторонних организациях","DjangoAdministration","Выберите Проектная роль для изменения"},
              /*4.1.51*/ {"Добавить поле Должности в сторонних организациях","DjangoAdministration","Добавить Проектная роль"},
              /*4.1.52*/ {"Изменить поле Должности в сторонних организациях","DjangoAdministration","Выберите Проектная роль для изменения"},
              /*4.1.53*/ {"Иностранные языки","DjangoAdministration","Выберите Иностранный язык для изменения"},
              /*4.1.54*/ {"Добавить поле Иностранные языки","DjangoAdministration","Добавить Иностранный язык"},
              /*4.1.55*/ {"Изменить поле Иностранные языки","DjangoAdministration","Выберите Иностранный язык для изменения"},
              /*4.1.56*/ {"Названия организации","DjangoAdministration","Выберите Название организации для изменения"},
              /*4.1.57*/ {"Добавить поле Названия организации","DjangoAdministration","Добавить Название организации"},
              /*4.1.58*/ {"Изменить поле Названия организации","DjangoAdministration","Выберите Название организации для изменения"},
              /*4.1.59*/ {"Образования","DjangoAdministration","Выберите Образование для изменения"},
              /*4.1.60*/ {"Добавить поле Образования","DjangoAdministration","Добавить Образование"},
              /*4.1.61*/ {"Изменить поле Образования","DjangoAdministration","Выберите Образование для изменения"},
              /*4.1.62*/ {"Показатели квалификации","DjangoAdministration","Выберите Показатель квалификации для изменения"},
              /*4.1.63*/ {"Добавить поле Показатели квалификации","DjangoAdministration","Добавить Показатель квалификации"},
              /*4.1.64*/ {"Изменить поле Показатели квалификации","DjangoAdministration","Выберите Показатель квалификации для изменения"},
              /*4.1.65*/ {"Специальности (ВУЗ)","DjangoAdministration","Выберите Специальность для изменения"},
              /*4.1.66*/ {"Добавить поле Специальности (ВУЗ)","DjangoAdministration","Добавить Специальность"},
              /*4.1.67*/ {"Изменить поле Специальности (ВУЗ)","DjangoAdministration","Выберите Специальность для изменения"},
              /*4.1.68*/ {"Сторонние организации","DjangoAdministration","Выберите Название организации для изменения"},
              /*4.1.69*/ {"Добавить поле Сторонние организации","DjangoAdministration","Добавить Название организации"},
              /*4.1.70*/ {"Изменить поле Сторонние организации","DjangoAdministration","Выберите Название организации для изменения"},
              /*4.1.71*/ {"Типы навыков","DjangoAdministration","Выберите Тип навыков для изменения"},
              /*4.1.72*/ {"Добавить поле Типы навыков","DjangoAdministration","Добавить Тип навыков"},
              /*4.1.73*/ {"Изменить поле Типы навыков","DjangoAdministration","Выберите Тип навыков для изменения"},
              /*4.1.74*/ {"Типы квалификации","DjangoAdministration","Выберите Тип квалификации для изменения"},
              /*4.1.75*/ {"Добавить поле Типы квалификации","DjangoAdministration","Добавить Тип квалификации"},
              /*4.1.76*/ {"Изменить поле Типы квалификации","DjangoAdministration","Выберите Тип квалификации для изменения"},
              /*4.1.77*/ {"Уровни знания иностранного языка","DjangoAdministration","Выберите Уровень знания иностранного языка для изменения"},
              /*4.1.78*/ {"Добавить поле Уровни знания иностранного языка","DjangoAdministration","Добавить Уровень знания иностранного языка"},
              /*4.1.79*/ {"Изменить поле Уровни знания иностранного языка","DjangoAdministration","Выберите Уровень знания иностранного языка для изменения"},
              /*4.1.80*/ {"Статусы запроса на отпуск","DjangoAdministration","Выберите Статус запроса на отпуск для изменения"},
              /*4.1.81*/ {"Добавить поле Статусы запроса на отпуск","DjangoAdministration","Добавить Статус запроса на отпуск"},
              /*4.1.82*/ {"Изменить поле Статусы запроса на отпуск","DjangoAdministration","Выберите Статус запроса на отпуск для изменения"},
              /*4.1.83*/ {"Тип родства","DjangoAdministration","Выберите Тип родства для изменения"},
              /*4.1.84*/ {"Добавить поле Тип родства","DjangoAdministration","Добавить Тип родства"},
              /*4.1.85*/ {"Изменить поле Тип родства","DjangoAdministration","Выберите Тип родства для изменения"},
              /*4.1.86*/ {"Добавить поле Сотрудники с административным доступом","DjangoAdministration","Добавить Сотрудник с административным доступом"},
        };
    }

    @Test()
    @Description("4.1.1 Проверка отображения недоступного функционала под ролью hr")
    public void checkExistsAdminFunctionalityUnderHrRole() {

        initialize();

        webCheckSteps.checkElementIsNotExistsOnPage("Добавить поле Проектные ставки");
        webCheckSteps.checkElementIsNotExistsOnPage("Изменить поле Сотрудники с административным доступом");

        webCheckSteps.checkElementIsNotExistsOnPage("Модели в приложении Пользователи и группы");
        webCheckSteps.checkElementIsNotExistsOnPage("Модели в приложении Otp_Totp");


    }

    @Test(dataProvider = "data")
    @Description("4.1.2-4.1.86, роль hr,Работоспособность элемента")
    public void checkHrRole(String link, String page, String checkedText) {
        initialize();
        webSteps.clickOnElement(link);
        webSteps.setPage(page);
        webCheckSteps.textAppearOnThePage(checkedText);
    }

    @Test()
    @Description("4.1.87 Проверка отображения Моих последних действий под ролью hr")
    public void checkMyLastActionsDisplayUnderHrRole() {
        String checkedText="";

        initialize();
        webSteps.clickOnElement("Сотрудники");
        webSteps.setPage("DjangoEmployee");
        webSteps.clickOnElement("Добавить сотрудник");
        webSteps.setPage("DjangoEmployeeAddPage");

        webSteps.fillFieldRandomString("Фамилия");
        webSteps.fillFieldRandomString("Имя");
        webSteps.listSelectRandElement("Пол");

        webSteps.clickOnElement("Сохранить");
        webSteps.setPage("DjangoEmployeeChange");
        webCheckSteps.checkElementIsExistsOnPage("Сообщение об успешном редактировании");
        webSteps.clickOnElement( "Администрирование Django");
        webSteps.setPage("DjangoAdministration");

        checkedText=ContextHolder.getValue("Фамилия")+" "+ContextHolder.getValue("Имя");

        webCheckSteps.matchText("Первый элемент блока Мои действия",checkedText);





    }


}
