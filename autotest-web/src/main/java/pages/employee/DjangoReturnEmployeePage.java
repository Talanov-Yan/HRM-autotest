package pages.employee;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

@Name(value = "DjangoReturnEmployee")
public class DjangoReturnEmployeePage extends WebPage {

    @Name("Инфоблок")
    private SelenideElement infoblock = $x("//form[@id='employee_form']/p");

// ДАННЫЙ РО БУДЕТ УДАЛЕН -> БУДЕТ ИСПОЛЬЗОВАТЬСЯ: "Инфоблок" из родительского класса
    @Name("Вернуть Бородкинов Битард")
    private SelenideElement returnBorodkinov = $x("//div[@id='content']/h1");

    @Name("Фамилия")
    private SelenideElement surname = $x("//input[@name='surname']");
// ДАННЫЙ РО БУДЕТ УДАЛЕН -> БУДЕТ ИСПОЛЬЗОВАТЬСЯ: Фамилия
    @Name("поле Фамилии")
    private SelenideElement surname2 = $x("//input[@name='surname']");

    @Name("Сохранить")
    private SelenideElement save = $x("//input[@name='_save']");
}
