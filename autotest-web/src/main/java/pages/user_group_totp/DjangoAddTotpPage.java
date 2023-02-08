package pages.user_group_totp;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;
/**
 * PageObject, описывающий страницу 'Добавить поле TOTP devices'
 * http://178.154.246.238:58082/admin/otp_totp/totpdevice/add/
 */
@Name(value = "DjangoAddTotp")
public class DjangoAddTotpPage extends WebPage {

    @Name("Инфоблок")
    private SelenideElement infoblock = $x("//div[@id='content']/h1");
}
