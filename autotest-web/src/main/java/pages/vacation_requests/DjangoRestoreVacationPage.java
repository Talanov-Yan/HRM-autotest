package pages.vacation_requests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

/**
 * PageObject, описывающий страницу 'Восстановить удаленный запросы на отпуск'
 * http://178.154.246.238:58082/admin/core/employeevacationrequest/recover/
 */
@Name(value = "DjangoRecoverVacation")
public class DjangoRestoreVacationPage extends WebPage {
    @Name("Таблица дата и время")
    private ElementsCollection tableDateTime = $$x("//th[@scope='row']");
    @Name("Таблица запрос на отпуск")
    private ElementsCollection tableRequestVacation = $$x("//td");
    @Name("Сохранить")
    private SelenideElement saveButton = $x("//input[@type='submit']");
}
