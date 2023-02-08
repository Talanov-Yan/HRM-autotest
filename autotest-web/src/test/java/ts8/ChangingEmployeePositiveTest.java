package ts8;

import hooks.WebHooks;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.*;

public class ChangingEmployeePositiveTest extends WebHooks {
    private final PageManager pageManager = new PageManager();

    private final WebCheckSteps webCheckSteps = new WebCheckSteps(pageManager);
    private final WebSteps webSteps = new WebSteps(pageManager);

    private void initialize() {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin("just_employee");
        webSteps.setPage("DjangoEmployeeChange");
    }

    @Test
    @Description("8.1. Проверка редактирования ключевых полей." +
            " Django Administration Роль just_employee")
    public void checkEditingUniqueFields() {
        initialize();

        webCheckSteps.checkFieldText("Фамилия", "Бородкин");
        webCheckSteps.checkFieldText("Имя", "Битард");
        webCheckSteps.listCheckedElement("Пол", "Male");
        webCheckSteps.checkElementIsReadOnly("Корпоративная почта");

        webSteps.fillField("Фамилия", "Бородкина");
        webSteps.fillField("Имя", "Анастасия");

        webSteps.setInDropDown("Пол", "Female");
        webSteps.clickOnElement("Сохранить и продолжить редактирование");

        webCheckSteps.matchText("Сообщение о успешном редактировании",
                "The Сотрудник “Бородкина Анастасия” was changed successfully. You may edit it again below.");

        webCheckSteps.checkFieldText("Фамилия", "Бородкина");
        webCheckSteps.checkFieldText("Имя", "Анастасия");
        webCheckSteps.listCheckedElement("Пол", "Female");

//        Возврат к первоначальному состоянию
        webSteps.fillField("Фамилия", "Бородкин");
        webSteps.fillField("Имя", "Битард");
        webSteps.setInDropDown("Пол", "Male");
        webSteps.clickOnElement("Сохранить и продолжить редактирование");
    }

    @Test
    @Description("8.2. Проверка редактирования второстепенных полей." +
            " Django Administration Роль just_employee")
    public void checkEditingSecondFields() {
        initialize();

        webSteps.fillField("Отчество","Валентиновна");
        webSteps.fillField("Дата приема на работу","20.08.2020");
        webSteps.fillField("Телефон","+79883456789");
        webSteps.fillField("День рождения","21.06.1988");
        webSteps.listSelectRandElement("Гражданство");
        webSteps.clickOnElement("Сохранить и продолжить редактирование");
        webCheckSteps.matchText("Сообщение о успешном редактировании",
                "The Сотрудник “Бородкин Битард” was changed successfully. You may edit it again below.");
    }

    @Test
    @Description("8.3. Проверка добавления фотографии." +
            " Django Administration Роль just_employee")
    public void checkAddingPhoto(){
        initialize();

        String nameOfImage = "test.jpg";
        webSteps.uploadFiles("Выберите фото", nameOfImage);
        webCheckSteps.checkNameOfUploadedImage("Выберите фото", nameOfImage);
        webSteps.clickOnElement("Сохранить и продолжить редактирование");
        webCheckSteps.curFieldsContainsThatElement("Name");
        webCheckSteps.curFieldsContainsThatElement("Загруженное фото");
        webSteps.clickOnElement("Очистить фото");
        webSteps.clickOnElement("Сохранить");
    }

    @Test
    @Description("8.4. Проверка замены загруженной фотографии." +
            " Django Administration Роль just_employee")
    public void checkChangingUploadPhoto(){
        initialize();

        String nameOfImage = "test.png";
        webSteps.uploadFiles("Выберите фото", "test.jpg");
        webSteps.clickOnElement("Сохранить и продолжить редактирование");
        webCheckSteps.curFieldsContainsThatElement("Загруженное фото");
        webSteps.uploadFiles("Выберите фото", "test.png");
        webCheckSteps.checkNameOfUploadedImage("Выберите фото", nameOfImage);
        webSteps.clickOnElement("Сохранить и продолжить редактирование");
        webCheckSteps.curFieldsContainsThatElement("Загруженное фото");
        webCheckSteps.curFieldsContainsThatElement("Name");
        webSteps.clickOnElement("Очистить фото");
        webSteps.clickOnElement("Сохранить");
    }

    @Test
    @Description("8.5. Проверка удаления загруженной фотографии." +
            " Django Administration Роль just_employee")
    public void checkRemovingUploadedPhoto(){
        initialize();

        webSteps.uploadFiles("Выберите фото", "test.jpg");
        webSteps.clickOnElement("Сохранить и продолжить редактирование");
        webCheckSteps.curFieldsContainsThatElement("Загруженное фото");
        webSteps.clickOnElement("Очистить фото");
        webSteps.clickOnElement("Сохранить и продолжить редактирование");
        webCheckSteps.curFieldsContainsThatElement("Name");
        webCheckSteps.matchText("Инфоблок фото", "Фотография отсутствует");
    }

    @Test
    @Description("8.6. Блок \"Квалификация\", проверка редактирования." +
            " Django Administration Роль just_employee")
    public void checkEditingQualityBlock(){
        initialize();

        webSteps.scrollToElement("Квалификация");
        webSteps.clickOnElement("Квалификация");
        webSteps.clickRandomN("Все квалификации", 5);
        webSteps.unClickRandomN("Все квалификации", 3);
        webSteps.clickOnElement("Сохранить и продолжить редактирование");
        webCheckSteps.matchText("Сообщение о успешном редактировании",
                "The Сотрудник “Бородкин Битард” was changed successfully. You may edit it again below.");
    }

    @Test
    @Description("8.7. Блок \"Навыки\", проверка редактирования." +
            " Django Administration Роль just_employee")
    public void checkEditingSkillsBlock(){
        initialize();

        webSteps.scrollToElement("Навыки");
        webSteps.clickOnElement("Навыки");
        webSteps.clickRandomN("Все навыки", 5);
        webSteps.unClickRandomN("Все навыки", 3);
        webSteps.clickOnElement("Сохранить и продолжить редактирование");
        webCheckSteps.matchText("Сообщение о успешном редактировании",
                "The Сотрудник “Бородкин Битард” was changed successfully. You may edit it again below.");
    }

    @Test
    @Description("8.8. Блок \"Сертификаты\", проверка редактирования." +
            " Django Administration Роль just_employee")
    public void checkEditingCertificatesBlock() {
        initialize();

        webSteps.scrollToElement("Сертификаты");
        webSteps.clickOnElement("Сертификаты");
        webSteps.generateFillTheField("Сертификаты:", "RRRRRRDDDDD");
        webSteps.generateFillTheField("Курсы:", "RRRRRRDDDDD");
        webSteps.clickOnElement("Сохранить и продолжить редактирование");
        webCheckSteps.matchText("Сообщение о успешном редактировании",
                "The Сотрудник “Бородкин Битард” was changed successfully. You may edit it again below.");
    }

    @Test
    @Description("8.9. Блок \"Проекты\", проверка редактирования." +
            " Django Administration Роль just_employee")
    public void checkEditingProjectsBlock() {
        initialize();

        webSteps.scrollToElement("Проект");
        webSteps.clickOnElement("Проект");
        webSteps.scrollToElement("Добавить проект");
        webSteps.clickOnElement("Добавить проект");
        webSteps.listSelectRandElement("Выбор проекта");
        webSteps.listSelectRandElement("Вид тестирования");
        webSteps.listSelectRandElement("Проектная роль");
        webSteps.generateFillTheField("Обратная связь", "RRRRRRDDDDD");
        webSteps.generateFillTheField("Дата начала", "20.08.2020");
        webSteps.clickOnElement("Дата окончания: Сегодня");
        webSteps.generateFillTheField("Обязанности", "RRRRRRDDDDD");
        webSteps.clickOnElement("Дата окончания: Сегодня");
        webSteps.clickOnElement("СТАЖЕР");
        webSteps.clickOnElement("Сохранить и продолжить редактирование");
        webCheckSteps.matchText("Сообщение о успешном редактировании",
                "The Сотрудник “Бородкин Битард” was changed successfully. You may edit it again below.");
    }

    @Test
    @Description("8.10. Проверка работоспособности кнопки \"СОХРАНИТЬ\"." +
            " Django Administration Роль just_employee")
    public void checkSaveButton() {
        initialize();

        webSteps.clickOnElement("Сохранить");

        webCheckSteps.matchText("Сообщение о успешном редактировании",
                "The Сотрудник “Бородкин Битард” was changed successfully.");
    }
}
