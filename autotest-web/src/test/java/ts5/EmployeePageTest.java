package ts5;

import hooks.WebHooks;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ru.lanit.at.web.pagecontext.PageManager;
import steps.*;

public class EmployeePageTest extends WebHooks {

    private final PageManager pageManager = new PageManager();
    private final WebSteps webSteps = new WebSteps(pageManager);
    private final WebCheckSteps webCheckSteps = new WebCheckSteps(pageManager);

    private void authorization(String login) {
        webSteps.openUrl();
        webSteps.setPage("DjangoAuthorization");
        webSteps.authWithLogin(login);
        webCheckSteps.currentTextIsNotExist("Сообщение об ошибке");
        webSteps.setPage("DjangoAdministration");
        webCheckSteps.checkAppearElement("Сотрудники");
        webSteps.clickOnElement("Сотрудники");
        webSteps.setPage("DjangoEmployee");
    }

    @Test
    @Description("5.1. Проверка отображения недоступного функционала на странице 'Сотрудники' " +
            "под ролью 'public'")
    public void checkingDisplayUnavailableFunctionality() {
        authorization("public");
        webCheckSteps.elementAbsentOnPage("Добавить сотрудник");
    }

    @Test
    @Description("5.2. Проверка отсутствия активности элемента на странице 'Сотрудники' под ролью 'public'")
    public void checkingElementIsInactive() {
        authorization("public");
        webSteps.clickRandom("ФИО");
        webSteps.setPage("DjangoEmployeeChange");
        webCheckSteps.checkElementIsReadOnly("Фамилия Public");

    }

    @Test
    @Description("5.3. Проверка работоспособности поискового блока под ролью 'hr'")
    public void checkingHealthSearchBlock() {
        authorization("hr");
        webSteps.fillField("Поиск", "Бородкин");
        webCheckSteps.checkAppearElement("Найти");
        webSteps.clickOnElement("Найти");
        webCheckSteps.elementContainsText("ФИО", "Бородкин");

    }

    @Test
    @Description("5.4. Проверка работоспособности удаления сотрудников под ролью 'hr'")
    public void checkingHealthDeleting() {
        authorization("hr");
        webSteps.clickRandom("Таблица чек-бокс");
        webCheckSteps.checkAppearElement("Выбрано 1 из 100");
        webSteps.setAnything("Действие", 1);
        webCheckSteps.checkAppearElement("Выполнить");
        webSteps.clickOnElement("Выполнить");
        webSteps.setPage("DjangoDeleteEmployee");
        webCheckSteps.textAppearOnThePage("Вы уверены?");
        webSteps.scrollToElement("Yes, I`m sure");
        webSteps.clickOnElement("Yes, I`m sure");
        webCheckSteps.textAppearOnThePage("Успешно удалены 1 Сотрудник.");
    }

    @Test
    @Description("5.5. Проверка работоспособности экспорта списка сотрудников под ролью 'hr'")
    public void checkingHealthListExport() {
        authorization("hr");
        webSteps.clickRandom("Таблица чек-бокс");
        webCheckSteps.checkAppearElement("Выбрано 1 из 100");
        webSteps.setAnything("Действие", 2);
        webCheckSteps.checkAppearElement("Формат");
        webCheckSteps.checkNoSelectedCheckbox("Договор");
        webCheckSteps.checkAppearElement("Выполнить");
    }

    @Test
    @Description("5.6 страница Сотрудники, проверка работоспособности кнопок пагинации. Роль Hr")
    public void employeeHrPaginationTest() {
        authorization("hr");
        webSteps.getElementText("ФИО", 1);
        webSteps.clickOnElementWithText("Пагинация", "2");
        webCheckSteps.checkCurrentNumber("Пагинация текущая страница", "2");
        webCheckSteps.checkElementNoEquals(1, "ФИО");
    }

    @Test
    @Description("5.7 страница Сотрудники, проверка работоспособности восстановления удаленных сотрудников. Роль Hr")
    public void employeeHrRestoreTest() {
        authorization("hr");
        webSteps.getElementText("ФИО", 1);
        webSteps.clickOnElementWithText("Пагинация", "2");
        webCheckSteps.checkCurrentNumber("Пагинация текущая страница", "2");
        webCheckSteps.checkElementNoEquals(1, "ФИО");
    }

    @Test
    @Description("5.9 страница Сотрудники, проверка работоспособности экспорта списка сотрудников через кнопку интерфейса. Роль Hr")
    public void employeeHrExportTest() {
        authorization("hr");
        webCheckSteps.checkAppearElement("Экспорт");
        webSteps.clickOnElement("Экспорт");
        webSteps.setPage("DjangoExportEmployee");
        webCheckSteps.matchText("Инфоблок", "Экспорт");
        webCheckSteps.checkAppearElement("Формат");
        webCheckSteps.checkElementVisibleCollection("Чекбокс", "Договор");
        webCheckSteps.checkAppearElement("Отправить");
    }

    @Test
    @Description("5.10 страница Сотрудники, проверка работоспособности кнопки добавления нового сотрудника. Роль Hr")
    public void employeeHrAddNewEmployeeTest() {
        authorization("hr");
        webCheckSteps.checkAppearElement("Добавить сотрудник");
        webSteps.clickOnElement("Добавить сотрудник");
        webSteps.setPage("DjangoExportEmployee");
        webCheckSteps.matchText("Инфоблок", "Добавить Сотрудник");
    }

    @Test
    @Description("5.11 страница Сотрудники, проверка работоспособности фильтров. Роль Hr")
    public void employeeHrFiltersTest() {
        authorization("hr");
        webSteps.clickOnElementWithText("Категории фильтров", "Офис");
        webSteps.clickOnElementWithText("Фильтр", "Пенза");
        webCheckSteps.checkCurrentNumberCity("Текущий город", "Пенза");
    }
}
