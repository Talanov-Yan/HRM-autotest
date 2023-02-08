package api;

import io.qameta.allure.Description;
import net.minidev.json.JSONObject;
import org.testng.annotations.Test;

import static dictionaries.ApiEndpointsConst.DEPARTMENTS;
import static dictionaries.TablesNameConst.DEPARTMENTS_DB;
import static ru.lanit.at.api.testcontext.ContextHolder.getValue;
import static ru.lanit.at.utils.DataGenerator.generateValueByMask;
import static steps.ApiSteps.*;
import static utils.api.fixtures.FixtureDB.getRandomField;
import static utils.api.fixtures.FixtureDB.getRandomInteger;

public class DepartmentsTest extends BaseApiTest {

    @Test
    @Description("31. GET /departments/")
    public static void getListOfDepartments() {
        get(DEPARTMENTS,200);
    }

    @Test
    @Description("32. POST /departments/")
    public static void createSomeDepartments() {
        JSONObject newDepartment = new JSONObject();
        newDepartment.put("name", generateValueByMask("RRRRR"));

        post(DEPARTMENTS,201,newDepartment);
        get(DEPARTMENTS,  getValue("id"),200);
        delete(DEPARTMENTS, getValue("id"),204);
        get(DEPARTMENTS, getValue("id"),404);
    }

    @Test
    @Description("33. GET /departments/{id}/")
    public static void getDepartmentById() {
        get(DEPARTMENTS, getRandomInteger(DEPARTMENTS_DB),200);
    }

    @Test
    @Description("34. PATCH /departments/{id}/")
    public static void changeCreatedDepartment() {
        JSONObject newDepartment = new JSONObject();
        newDepartment.put("name", generateValueByMask("RRRRR"));

        JSONObject patchedDepartment = new JSONObject();
        patchedDepartment.put("name", generateValueByMask("RRRRR"));

        post(DEPARTMENTS,201,newDepartment);
        get(DEPARTMENTS, getValue("id"),200);
        patch(DEPARTMENTS, getValue("id"),200, patchedDepartment);
        delete(DEPARTMENTS, getValue("id"),204);
        get(DEPARTMENTS, getValue("id"),404);
    }

    @Test
    @Description("35. DELETE /departments/{id}/")
    public static void deleteCreatedDepartment() {
        JSONObject newDepartment = new JSONObject();
        newDepartment.put("name", generateValueByMask("RRRRR"));

        post(DEPARTMENTS,201,newDepartment);
        get(DEPARTMENTS, getValue("id"),200);
        delete(DEPARTMENTS, getValue("id"),204);
        get(DEPARTMENTS, getValue("id"),404);
    }

    @Test
    @Description(value = "36. GET /departments/{id}/{picked_field}")
    public static void getDepartmentByField() {
        String id = getRandomInteger(DEPARTMENTS_DB);
        get(DEPARTMENTS, id, getRandomField(DEPARTMENTS_DB, id),200);
    }
}
