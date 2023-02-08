package pages.employee;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.*;

/**
 * /admin/core/employee/add
 */


@Name(value = "DjangoEmployeeAddPage")
public class DjangoEmployeeAddPage extends WebPage {


    @Name("Фамилия")
    private SelenideElement surnameField = $x("//input[@id='id_surname']");

    @Name("Имя")
    private SelenideElement nameField = $x("//input[@id='id_name']");

    @Name("Пол")
    private SelenideElement genderList = $x("//select[@id='id_gender']");

    @Name("Сохранить")
    private SelenideElement saveButtom = $x("//input[@name='_save']");

}

