package pages.employee;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

@Name(value = "DjangoQualificationSkills")
public class DjangoQualificationSkillsPage extends WebPage {

// ДАННЫЙ РО БУДЕТ УДАЛЕН -> БУДЕТ ИСПОЛЬЗОВАТЬСЯ: "Инфоблок" из родительского класса
    @Name("Добавить Показатель квалификации")
    private SelenideElement addSkillScore = $x("//div[@id='content']/h1");
}
