package api;

import io.qameta.allure.Description;
import net.minidev.json.JSONObject;
import org.testng.annotations.Test;

import static dictionaries.ApiEndpointsConst.ADMINISTRATORS;
import static dictionaries.TablesNameConst.ADMINISTRATORS_DB;
import static dictionaries.TablesNameConst.EMPLOYEES_DB;
import static ru.lanit.at.api.testcontext.ContextHolder.getValue;
import static steps.ApiSteps.*;
import static utils.api.fixtures.FixtureDB.*;
import static utils.api.fixtures.FixtureDB.getRandomField;
import static utils.api.fixtures.FixtureDB.getRandomInteger;

public class AdministratorsTest extends BaseApiTest {

    @Test
    @Description("13. GET /administrators/")
    public static void getListOfAdministrators() {
        get(ADMINISTRATORS,200);
    }

    @Test
    @Description("14. POST /administrators/")
    public static void createSomeAdministrator() {
        JSONObject newAdministrator = new JSONObject();
        newAdministrator.put("employee", getRandomInteger(EMPLOYEES_DB));

        post(ADMINISTRATORS,201, newAdministrator);
        get(ADMINISTRATORS,  getValue("id"),200);
        delete(ADMINISTRATORS, getValue("id"),204);
        get(ADMINISTRATORS, getValue("id"),404);
    }

    @Test
    @Description("15. GET /administrators/{id}/")
    public static void getAdministratorById() {
        get(ADMINISTRATORS, getRandomInteger(ADMINISTRATORS_DB),200);
    }

    @Test
    @Description("16. PATCH /administrators/{id}/")
    public static void changeCreatedAdministrator() {
        JSONObject newAdministrator = new JSONObject();
        newAdministrator.put("employee", getRandomInteger(EMPLOYEES_DB));

        JSONObject patchedAdministrator = new JSONObject();
        patchedAdministrator.put("employee", getRandomInteger(EMPLOYEES_DB));

        post(ADMINISTRATORS,201, newAdministrator);
        get(ADMINISTRATORS, getValue("id"),200);
        patch(ADMINISTRATORS, getValue("id"),200, patchedAdministrator);
        delete(ADMINISTRATORS, getValue("id"),204);
        get(ADMINISTRATORS, getValue("id"),404);
    }

    @Test
    @Description("17. DELETE /administrators/{id}/")
    public static void deleteCreatedAdministrator() {
        JSONObject newAdministrator = new JSONObject();
        newAdministrator.put("employee", getRandomInteger(EMPLOYEES_DB));

        post(ADMINISTRATORS,201,newAdministrator);
        get(ADMINISTRATORS, getValue("id"),200);
        delete(ADMINISTRATORS, getValue("id"),204);
        get(ADMINISTRATORS, getValue("id"),404);
    }

    @Test
    @Description(value = "18. GET /administrators/{id}/{picked_field}")
    public static void getAdministratorByField() {
        String id = getRandomInteger(ADMINISTRATORS_DB);
        get(ADMINISTRATORS, id, getRandomField(ADMINISTRATORS_DB, id),200);
    }

}
