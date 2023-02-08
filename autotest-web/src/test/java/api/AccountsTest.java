package api;

import io.qameta.allure.Description;
import net.minidev.json.JSONObject;
import org.testng.annotations.Test;
import utils.api.fixtures.FixtureDB;

import static dictionaries.ApiEndpointsConst.ACCOUNTS;
import static dictionaries.TablesNameConst.ACCOUNTS_DB;
import static ru.lanit.at.api.testcontext.ContextHolder.getValue;
import static ru.lanit.at.utils.DataGenerator.generateValueByMask;
import static steps.ApiSteps.*;
import static utils.api.fixtures.FixtureDB.getRandomField;
import static utils.api.fixtures.FixtureDB.getRandomInteger;

public class AccountsTest extends BaseApiTest {

    @Test
    @Description("1. GET /accounts/")
    public static void getListOfAccounts() {
        get(ACCOUNTS,200);
    }

    @Test
    @Description("2. POST /accounts/")
    public static void createSomeAccount() {
        JSONObject newAccount = new JSONObject();
        newAccount.put("name", generateValueByMask("RRRRRRRRRRR"));

        post(ACCOUNTS,201,newAccount);
        get(ACCOUNTS,  getValue("id"),200);
        delete(ACCOUNTS, getValue("id"),204);
        get(ACCOUNTS, getValue("id"),404);
    }

    @Test
    @Description("3. GET /accounts/{id}/")
    public static void getAccountById() {
        get(ACCOUNTS, FixtureDB.getRandomInteger(ACCOUNTS_DB),200);
    }

    @Test
    @Description("4. PATCH /accounts/{id}/")
    public static void changeCreatedAccount() {
        JSONObject newAccount = new JSONObject();
        newAccount.put("name", generateValueByMask("RRRRRRRRRRR"));

        JSONObject patchedAccount = new JSONObject();
        patchedAccount.put("name", generateValueByMask("RRRRRRRRRRR"));

        post(ACCOUNTS,201,newAccount);
        get(ACCOUNTS, getValue("id"),200);
        patch(ACCOUNTS, getValue("id"),200,patchedAccount);
        delete(ACCOUNTS, getValue("id"),204);
        get(ACCOUNTS, getValue("id"),404);

    }

    @Test
    @Description("5. DELETE /accounts/{id}/")
    public static void deleteCreatedAccount() {
        JSONObject newAccount = new JSONObject();
        newAccount.put("name", generateValueByMask("RRRRRRRRRRR"));

        post(ACCOUNTS,201,newAccount);
        get(ACCOUNTS, getValue("id"),200);
        delete(ACCOUNTS, getValue("id"),204);
        get(ACCOUNTS, getValue("id"),404);
    }

    @Test
    @Description("6. GET /accounts/{id}/{picked_field}")
    public static void getAccountByField() {
        String id = getRandomInteger(ACCOUNTS_DB);
        get(ACCOUNTS, id, getRandomField(ACCOUNTS_DB, id),200);
    }
}
