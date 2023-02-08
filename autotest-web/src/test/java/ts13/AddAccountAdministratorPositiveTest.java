package ts13;

import hooks.WebHooks;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ru.lanit.at.api.testcontext.ContextHolder;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.WebCheckSteps;
import steps.WebSteps;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddAccountAdministratorPositiveTest extends WebHooks {

    private final PageManager pageManager = new PageManager();
    private final WebSteps webSteps = new WebSteps(pageManager);
    private final WebCheckSteps webCheckSteps = new WebCheckSteps(pageManager);

    private void authorization(String login){
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin(login);
        webCheckSteps.currentTextIsNotExist("Сообщение об ошибке");
        webSteps.setPage("DjangoAdministration");
        webCheckSteps.checkAppearElement("Администраторы аккаунта");
        webSteps.clickOnElement("Администраторы аккаунта");
        webSteps.setPage("DjangoAccountAdministratorsPage");
        webCheckSteps.checkAppearElement("Добавить Администратор аккаунта +");
        webSteps.clickOnElement("Добавить Администратор аккаунта +");
        webSteps.setPage("DjangoAddAccountAdministrators");
    }

    @Test
    @Description("13.1. Проверка заполняемости ключевых полей блока " +
            "и создания нового Администратора аккаунта под ролью hr")
    public void checkFillingAndCreatingNewAdmin(){
        authorization("hr");

        webSteps.listSelectRandElement("Сотрудник");
        webSteps.saveDropDownListContents("Сотрудник");
        webSteps.listSelectRandElement("Аккаунт");
        webSteps.fillField("Дата начала", "01.01.2021");
        webCheckSteps.checkAppearElement("Сохранить");
        webSteps.clickOnElement("Сохранить");
        webCheckSteps.textAppearOnThePage("The Администратор аккаунта “");
        webCheckSteps.textAppearOnThePage(ContextHolder.getValue("Сотрудник"));
        webCheckSteps.textAppearOnThePage("” was added successfully.");
    }

    @Test
    @Description("13.2. Проверка заполнения поля 'Дата начала' через виджет 'Календарь' под ролью hr")
    public void checkFillingStartDateWithCalendar(){
        authorization("hr");

        webSteps.clickOnElement("'Календарь' рядом с полем 'Дата начала'");
        webSteps.clickRandom("Все даты месяца из 'Календарь' рядом с полем 'Дата начала'");
        webCheckSteps.checkFieldTextMatchesRegex("Дата начала","\\d{2}.\\d{2}.\\d{4}");
    }

    @Test
    @Description("13.3. Проверка заполнения поля 'Дата начала' через нажатие кнопки 'Сегодня' под ролью hr")
    public void checkFillingStartDateWithToday(){
        authorization("hr");

        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String today = localDate.format(formatter);
        webSteps.clickOnElement("'Сегодня' рядом с полем 'Дата начала'");
        webCheckSteps.checkFieldTextByDateToday("Дата начала", today);
    }

    @Test
    @Description("13.4. Проверка заполнения поля 'Дата окончания' через виджет 'Календарь' под ролью hr")
    public void checkFillingEndDateWithCalendar(){
        authorization("hr");

        webSteps.clickOnElement("'Календарь' рядом с полем 'Дата окончания'");
        webSteps.clickRandom("Все даты месяца из 'Календарь' рядом с полем 'Дата окончания'");
        webCheckSteps.checkFieldTextMatchesRegex("Дата окончания","\\d{2}.\\d{2}.\\d{4}");
    }

    @Test
    @Description("13.5. Проверка заполнения поля 'Дата окончания' через ввод с клавиатуры под ролью hr")
    public void checkFillingEndDateWithKeyboard(){
        authorization("hr");

        webSteps.fillField("Дата начала", "01.01.2021");
        webCheckSteps.checkFieldText("Дата начала", "01.01.2021");
    }

    @Test
    @Description("13.6. Проверка заполнения поля 'Дата окончания' через нажатие кнопки 'Сегодня' под ролью hr")
    public void checkFillingEndDateWithToday(){
        authorization("hr");

        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String today = localDate.format(formatter);
        webSteps.clickOnElement("'Сегодня' рядом с полем 'Дата окончания'");
        webCheckSteps.checkFieldTextByDateToday("Дата окончания", today);
    }

    @Test
    @Description("13.7. Проверка заполнения поля 'Заметка' под ролью hr")
    public void checkFillingNote(){
        authorization("hr");

        webSteps.fillFieldRandomString("Заметка");
        webCheckSteps.checkFieldTextIsNotEmpty("Заметка");
    }

    @Test
    @Description("13.8. Проверка работоспособности кнопки 'Сохранить и добавить другой объект' под ролью hr")
    public void checkSaveAndAddAnotherObject(){
        authorization("hr");

        webSteps.listSelectRandElement("Сотрудник");
        webSteps.saveDropDownListContents("Сотрудник");
        webSteps.listSelectRandElement("Аккаунт");
        webSteps.fillField("Дата начала", "01.01.2021");
        webCheckSteps.checkAppearElement("Сохранить и добавить другой объект");
        webSteps.clickOnElement("Сохранить и добавить другой объект");
        webCheckSteps.textAppearOnThePage("The Администратор аккаунта “");
        webCheckSteps.textAppearOnThePage(ContextHolder.getValue("Сотрудник"));
        webCheckSteps
                .textAppearOnThePage("” was added successfully. You may add another Администратор аккаунта below.");
        webCheckSteps.emptyDropDown("Сотрудник");
    }

    @Test
    @Description("13.9. Проверка работоспособности кнопки 'Сохранить и продолжить редактирование' под ролью hr")
    public void checkSaveAndContinueEditing(){
        authorization("hr");

        webSteps.listSelectRandElement("Сотрудник");
        webSteps.saveDropDownListContents("Сотрудник");
        webSteps.listSelectRandElement("Аккаунт");
        webSteps.fillField("Дата начала", "01.01.2021");
        webCheckSteps.checkAppearElement("Сохранить и продолжить редактирование");
        webSteps.clickOnElement("Сохранить и продолжить редактирование");
        webCheckSteps.textAppearOnThePage("The Администратор аккаунта “");
        webCheckSteps.textAppearOnThePage(ContextHolder.getValue("Сотрудник"));
        webCheckSteps.textAppearOnThePage("” was added successfully. Вы можете снова изменить этот объект ниже.");
        webCheckSteps.listCheckedElement("Сотрудник", ContextHolder.getValue("Сотрудник"));
    }
}
