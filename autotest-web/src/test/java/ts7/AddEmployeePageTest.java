package ts7;

import hooks.WebHooks;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.*;

public class AddEmployeePageTest extends WebHooks {

    private final PageManager pageManager = new PageManager();
    private final WebSteps webSteps = new WebSteps(pageManager);
    private final WebCheckSteps webCheckSteps = new WebCheckSteps(pageManager);


    @DataProvider
    public Object[][] testDataAddEmployeePositiveHrBlocks() {
        return new Object[][]{
                {"Грейды", "Грейд", "Заметка Грейды"},
                {"Проектные ставки", "Проектная ставка", "Проект Проектные ставки"},
                {"Договоры", "Договор", "Договоры Должность"},
        };
    }

    @DataProvider
    public Object[][] testDataAddEmployeePositiveHrBlocks2() {
        return new Object[][]{
                {"Города", "Город", "Город"},
                {"Иностранные языки", "Иностранный язык", "Иностранный язык"},
                {"Предыдущий опыт работы", "Предыдущий опыт работы", "Название организации опыта"},
                {"Достижения", "Достижение", "Достижение"},
                {"Запросы на отпуск", "Запрос на отпуск", "Статус запроса"},
        };
    }


    private void initialize() {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin("hr");
        webSteps.setPage("DjangoAdministration");
        webSteps.clickOnElement("Сотрудники");
        webSteps.setPage("DjangoEmployee");
        webSteps.clickOnElement("Добавить сотрудник");
        webSteps.setPage("DjangoEmployeeChange");
    }

    @Test
    @Description("7.1. Блок \"Общая информация\", проверка заполняемости ключевых полей")
    public void checkAddingNewEmployee() {
        initialize();

        webSteps.fillField("Фамилия", "Иванов");
        webSteps.fillField("Имя", "Иван");
        webSteps.fillField("Отчество", "Иванович");
        webSteps.selectElementInDropDown("Пол", "Male");
        webSteps.clickOnElement("Сохранить");
        webSteps.setPage("DjangoEmployee");
        webCheckSteps.matchText("Сообщение об успешном редактирование", "The Сотрудник “Иванов Иван” was added successfully.");
    }

    @Test
    @Description("7.2. Блок \"Общая информация\", проверка работоспособности загрузки файла изображения")
    public void checkPerformanceUploadingFIleImage() {
        initialize();

        String nameOfImage = "test.jpg";
        webSteps.uploadFiles("Выберите фото", nameOfImage);
        webCheckSteps.checkNameOfUploadedImage("Выберите фото", nameOfImage);
    }

    @Test
    @Description("7.3. Блок \"Общая информация\", проверка заполнения поля" +
            " \"Дата приема на работу\" через виджет \"Календарь\"")
    public void checkEmploymentDateByCalendar() {
        initialize();

        webSteps.clickOnElement("Выберите дату");
        webSteps.clickOnElement("Случайное число для выборки календаря - Дата приема на работу");
        webCheckSteps.checkFieldTextIsNotEmpty("Дата приема на работу");
    }

    @Test
    @Description("7.4. Блок \"Общая информация\", проверка заполнения поля" +
            " \"Дата приема на работу\" через ввод с клавиатуры")
    public void checkEmploymentDateByKeyboard() {
        initialize();

        webSteps.clearField("Дата приема на работу");
        webSteps.fillField("Дата приема на работу", "18.11.2021");
        webCheckSteps.matchTextByValue("Дата приема на работу", "18.11.2021");
    }

    @Test
    @Description("7.5. Блок \"Общая информация\", проверка заполнения поля" +
            " \"Дата приема на работу\" через нажатие кнопки \"Сегодня\"")
    public void checkEmploymentDateByClickToday() {
        initialize();

        webSteps.clearField("Дата приема на работу");
        webSteps.clickOnElement("Сегодня рядом 'Дата приема на работу'");
        webCheckSteps.checkFieldTextIsNotEmpty("Дата приема на работу");
        webCheckSteps.checkFieldTextByDateToday("Дата приема на работу",
                webSteps.initializeTodayDate());
    }

    @Test
    @Description("7.6. Блок \"Общая информация\", проверка заполняемости поля \"Телефон\"")
    public void checkTelephone() {
        initialize();

        webSteps.fillField("Телефон", "+79123456789");
        webCheckSteps.matchTextByValue("Телефон", "+79123456789");
    }


    @Test
    @Description("7.7. Блок \"Общая информация\", проверка заполнения поля" +
            " \"Дата рождения\" через виджет \"Календарь\"")
    public void checkBirthdayByCalendar() {
        initialize();

        webSteps.clickOnElement("Выберите дату в поле 'День рождения'");
        webSteps.clickOnElement("Случайное число для выборки календаря - День рождения");
        webCheckSteps.checkFieldTextIsNotEmpty("День рождения");
    }

    @Test
    @Description("7.8. Блок \"Общая информация\", проверка заполнения поля" +
            " \"Дата рождения\" через ввод с клавиатуры")
    public void checkBirthdayByKeyboard() {
        initialize();

        webSteps.clearField("День рождения");
        webCheckSteps.matchText("День рождения", "");
        webSteps.fillField("День рождения", "18.11.2021");
    }

    @Test
    @Description("7.9. Блок \"Общая информация\", проверка заполнения поля" +
            " \"Дата рождения\" через нажатие кнопки \"Сегодня\"")
    public void checkBirthdayByClickToday() {
        initialize();

        webSteps.clearField("День рождения");
        webSteps.clickOnElement("Сегодня рядом с полем 'День рождения'");
        webCheckSteps.checkFieldTextIsNotEmpty("День рождения");
        webCheckSteps.checkFieldTextByDateToday("День рождения",
                webSteps.initializeTodayDate());
    }

    @Test
    @Description("7.10. Блок \"Общая информация\", проверка заполняемости поля \"Гражданство\"")
    public void checkCitizenship() {
        initialize();

        webCheckSteps.checkReadOnly("Изменить выбранный объект типа Гражданство", "<href>");
        webCheckSteps.checkReadOnly("Удалить выбранный объект типа Гражданство", "<href>");
        webSteps.listSelectRandElement("Гражданство");
        webCheckSteps.checkElementIsRead("Изменить выбранный объект типа Гражданство");
        webCheckSteps.checkElementIsRead("Удалить выбранный объект типа Гражданство");
    }

    @Test
    @Description("7.16. Блок \"Навыки\", проверка заполняемости")
    public void checkFillingOfSkills() {
        initialize();

        webSteps.clickOnElement("Показать Навыки");
        webSteps.activeCheckbox("Список навыков", "Языки программирования: Golang");
        webSteps.activeCheckbox("Список навыков", "Языки программирования: PHP");
        webSteps.activeCheckbox("Список навыков", "Фреймворки АТ: TestNG");
        webSteps.clickOnElement("Скрыть Навыки");
        webCheckSteps.elementAbsentOnPage("Языки программирования: C# 5.0");
    }

    // TODO: 20.12.2021 (7.17) Ожидаем появления кнопки
    //    Проверка работоспособности кнопки
    //    "Добавить ещё один объект типа" --- Отложить до появления кнопки
    /*@Test
    @Description("EMPTY TEST (expect developer's button) " +
            "7.17. Блок \"Квалификация\", проверка работоспособности кнопки")
    public void checkButtonOfQualification() {
        initialize();

        webSteps.clickOnElement("Показать Навыки");
        webSteps.clickOnElement(Future xpath of the button(+ Добавить еще один объект типа));
    }*/

    @Test
    @Description("7.18. Блок \"Сертификаты\", проверка заполняемости")
    public void checkFillingOfCertificates() {
        initialize();

        webSteps.clickOnElement("Показать Сертификаты");
        webSteps.fillFieldRandomString("Сертификаты:");
        webSteps.fillFieldRandomString("Курсы");
        webSteps.clickOnElement("Скрыть Сертификаты");
        webCheckSteps.elementAbsentOnPage("Сертификаты:");
    }

    @Test
    @Description("7.19. блок \"Статус сотрудника\", проверка заполняемости")
    public void checkFillingOfStatusOfEmployee() {
        initialize();

        webSteps.clickOnElement("Показать Статус сотрудника");
        webSteps.activeCheckbox("Список статусов сотрудников", "В декретном отпуске");
        webSteps.activeCheckbox("Список статусов сотрудников", "Внешний совместитель");
        webSteps.clickOnElement("Скрыть Статус сотрудника");
        webCheckSteps.elementAbsentOnPage("Работает");
    }

    @Test
    @Description("7.20. Блок \"ОБРАЗОВАНИЯ\", проверка заполняемости")
    public void checkFillingOfEducation() {
        initialize();

        webSteps.clickOnElement("Показать ОБРАЗОВАНИЯ");
        webSteps.clickOnElement("Добавить еще один Образование");
        webCheckSteps.checkReadOnly("Изменить выбранный объект типа ВУЗ", "<href>");
        webSteps.listSelectRandElement("ВУЗ");
        webCheckSteps.checkElementIsNotReadOnly("Изменить выбранный объект типа ВУЗ", "<href>");
        webSteps.listSelectRandElement("УРОВЕНЬ ОБРАЗОВАНИЯ");
        webCheckSteps.checkElementIsNotReadOnly("Изменить выбранный объект типа УРОВЕНЬ ОБРАЗОВАНИЯ",
                "<href>");
        webSteps.listSelectRandElement("СПЕЦИАЛЬНОСТЬ");
        webCheckSteps.checkElementIsNotReadOnly("Изменить выбранный объект типа СПЕЦИАЛЬНОСТЬ", "<href>");
        webSteps.fillField("ДАТА НАЧАЛА", "01.01.2001");
        webSteps.fillField("ДАТА ОКОНЧАНИЯ", "01.01.2021");
        webSteps.clickOnElement("Скрыть ОБРАЗОВАНИЯ");
        webCheckSteps.elementAbsentOnPage("ВУЗ");
    }

    @Test
    @Description(value = "7.21 Заполнение блока Должности под ролью HR")
    public void addEmployeePositiveHrFillingPositionBlock() {
        initialize();
        webSteps.scrollToElement("Должности");
        webSteps.clickOnElement("Должности");
        webCheckSteps.checkAppearElement("Добавить еще один Должность");
        webSteps.clickOnElement("Добавить еще один Должность");
        webCheckSteps.checkReadOnly("Изменить выбранный объект типа Должность", "href");
        webSteps.clickRandom("Должность");
        webCheckSteps.checkElementIsRead("Изменить выбранный объект типа Должность");
        webSteps.clickRandom("Название организации");
        webCheckSteps.checkElementIsRead("Изменить выбранный объект типа Должность");
        webSteps.setRandomInt("Ставка", -5, 5);
        webSteps.setRandomInt("Грейд", -5, 5);
        webSteps.fillField("Дата начала должности", "01.01.2001");
        webSteps.fillField("Дата окончания должности", "01.01.2021");
        webSteps.fillFieldRandomString("Заметка Должности");
        webSteps.clickOnElement("Скрыть");
        webCheckSteps.currentTextIsNotExist("Должность");
    }

    @Test(dataProvider = "testDataAddEmployeePositiveHrBlocks")
    @Description(value = "7.22/7.24/7.25.1 Работа блока Грейды/Проектные ставки/Договоры/ под ролью HR")
    public void addEmployeePositiveHrCheckBlocksWork(String blocks, String block, String checkbox) {
        initialize();
        webSteps.scrollToElement(blocks);
        webSteps.clickOnElement(blocks);
        webCheckSteps.checkAppearElement("Добавить еще один " + block);
        webSteps.clickOnElement("Добавить еще один " + block);
        webCheckSteps.checkNoSelectedCheckbox(checkbox);
        webSteps.clickOnElement("Скрыть");
        webCheckSteps.elementAbsentOnPage(checkbox);
    }

    @Test
    @Description(value = "7.23 Заполнения блока Проекты под ролью HR")
    public void addEmployeePositiveHrFillingProjectsBlock() {
        initialize();
        webSteps.scrollToElement("Проекты");
        webSteps.clickOnElement("Проекты");
        webCheckSteps.checkAppearElement("Добавить еще один Проект");
        webSteps.clickOnElement("Добавить еще один Проект");
        webCheckSteps.checkReadOnly("Изменить выбранный объект типа Проект", "href");
        webSteps.clickRandom("Проекты Проект");
        webCheckSteps.checkElementIsRead("Изменить выбранный объект типа Проект");
        webSteps.clickRandom("Тип тестирования");
        webCheckSteps.checkElementIsRead("Изменить выбранный объект типа Проект");
        webSteps.fillField("Дата начала проекты", "01.01.2001");
        webSteps.fillField("Дата окончания проекты", "01.01.2021");
        webSteps.fillFieldRandomString("Обязанности проекты");
        webSteps.clickOnElement("Чекбокс Стажер");
        webSteps.clickOnElement("Скрыть");
        webCheckSteps.currentTextIsNotExist("Проекты Проект");
    }

    @Test
    @Description(value = "7.25.2 Работа блока Договоры ГПХ под ролью HR")
    public void addEmployeePositiveHrCheckContractsGPHBlockWork() {
        initialize();
        webSteps.scrollToElement("Договоры ГПХ");
        webSteps.clickOnElement("Договоры ГПХ");
        webCheckSteps.checkAppearElement("Добавить еще один Договор ГПХ");
        webSteps.clickOnElement("Добавить еще один Договор ГПХ");
        webCheckSteps.checkEmptyField("Номер договора");
        webSteps.clickOnElement("Скрыть");
        webCheckSteps.elementAbsentOnPage("Номер договора");
    }

    @Test(dataProvider = "testDataAddEmployeePositiveHrBlocks2")
    @Description(value = "7.26/7.27/7.28/7.29/7.30 Работа блока Города/Иностранные языки/Предыдущий опыт работы/Достижения/Запросы на отпуск под ролью HR")
    public void addEmployeePositiveHrCheckBlock2(String blocks, String block, String checkbox) {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin("hr");
        webCheckSteps.currentTextIsNotExist("Сообщение об ошибке");
        webSteps.setPage("DjangoAdministration");
        webCheckSteps.checkAppearElement("Сотрудники");
        webSteps.clickOnElement("Сотрудники");
        webSteps.setPage("DjangoEmployee");
        webSteps.clickRandom("ФИО");
        webSteps.setPage("DjangoEmployeeChange");
        webSteps.scrollToElement(blocks);
        webSteps.clickOnElement(blocks);
        webCheckSteps.checkAppearElement("Добавить еще один " + block);
        webSteps.clickOnElement("Добавить еще один " + block);
        webCheckSteps.checkNoSelectedCheckbox(checkbox);
        webSteps.clickOnElement("Скрыть");
        webCheckSteps.elementAbsentOnPage(checkbox);
    }

    @Test
    @Description("7.31 страница Сотрудники, проверка блока 'Фактические отпуска'. Роль Hr")
    public void employeeHrSearchTest() {
        initialize();
        webSteps.clickOnElement("Фактические отпуска");
        webCheckSteps.checkFieldWithoutText("Заметка поле");
        webSteps.clickOnElement("Скрыть отпуска");
        webCheckSteps.checkElementNotVisible("Заметка");
    }

    @Test
    @Description("7.32 страница Сотрудники, проверка блока 'Больничные'. Роль Hr")
    public void employeeHrSickLeaveTest() {
        initialize();
        webSteps.clickOnElement("Больничные");
        webSteps.clickOnElement("Добавить больничный");
        webCheckSteps.checkFieldWithoutText("Номер больничного листа");
        webSteps.clickOnElement("Скрыть больничный");
        webCheckSteps.checkElementNotVisible("Номер больничного листа");
    }

    @Test
    @Description("7.33 страница Сотрудники, проверка блока 'Бюллетени без больничного листа'. Роль Hr")
    public void employeeHrBulletinWithoutLeaveTest() {
        initialize();
        webSteps.clickOnElement("Бюллетени без больничного листа");
        webSteps.clickOnElement("Добавить бюллетень");
        webCheckSteps.checkFieldWithoutText("Дата бюллетеня");
        webSteps.clickOnElement("Скрыть бюллетень");
        webCheckSteps.checkElementNotVisible("Дата бюллетеня");
    }

    @Test
    @Description("7.34 страница Сотрудники, проверка блока 'Семья'. Роль Hr")
    public void employeeHrFamilyTest() {
        initialize();
        webSteps.clickOnElement("Семья");
        webSteps.clickOnElement("Добавить семья");
        webCheckSteps.emptyDropDown("Родственная связь");
        webSteps.clickOnElement("Скрыть семья");
        webCheckSteps.checkElementNotVisible("Родственная связь");
    }
}
