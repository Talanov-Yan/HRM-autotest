package api;

import io.qameta.allure.Description;
import net.minidev.json.JSONObject;
import org.testng.annotations.Test;

import static dictionaries.ApiEndpointsConst.EMPLOYEES;
import static dictionaries.TablesNameConst.EMPLOYEES_DB;
import static ru.lanit.at.api.testcontext.ContextHolder.getValue;
import static ru.lanit.at.utils.DataGenerator.generateValueByMask;
import static steps.ApiSteps.*;
import static utils.api.fixtures.FixtureDB.getRandomField;
import static utils.api.fixtures.FixtureDB.getRandomInteger;

public class EmployeesTest extends BaseApiTest {

    @Test
    @Description("44. GET /employees/")
    public static void getListOfEmployees() {
        get(EMPLOYEES,200);
    }

    @Test
    @Description("45. POST /employees/")
    public static void createSomeEmployee() {
        JSONObject newEmployee = new JSONObject();
        newEmployee.put("name", generateValueByMask("RRRRRRRRRRR"));
        newEmployee.put("surname", generateValueByMask("RRRRRRRRRRR"));

        post(EMPLOYEES,201,newEmployee);
        get(EMPLOYEES,  getValue("id"),200);
        delete(EMPLOYEES, getValue("id"),204);
        get(EMPLOYEES, getValue("id"),404);
    }

    @Test
    @Description("46. GET /employees/{id}/")
    public static void getEmployeeById() {
        get(EMPLOYEES, getRandomInteger(EMPLOYEES_DB),200);
    }

    @Test
    @Description("47. PATCH /employees/{id}/")
    public static void changeCreatedEmployee() {
        JSONObject newEmployee = new JSONObject();
        newEmployee.put("name", generateValueByMask("RRRRRRRRRRR"));
        newEmployee.put("surname", generateValueByMask("RRRRRRRRRRR"));

        JSONObject patchedEmployee = new JSONObject();
        patchedEmployee.put("name", generateValueByMask("RRRRRRRRRRR"));
        patchedEmployee.put("surname", generateValueByMask("RRRRRRRRRRR"));

        post(EMPLOYEES,201,newEmployee);
        get(EMPLOYEES, getValue("id"),200);
        patch(EMPLOYEES, getValue("id"),200, patchedEmployee);
        delete(EMPLOYEES, getValue("id"),204);
        get(EMPLOYEES, getValue("id"),404);

    }

    @Test
    @Description("48. DELETE /employees/{id}/")
    public static void deleteCreatedEmployee() {
        JSONObject newEmployee = new JSONObject();
        newEmployee.put("name", generateValueByMask("RRRRRRRRRRR"));
        newEmployee.put("surname", generateValueByMask("RRRRRRRRRRR"));

        post(EMPLOYEES,201,newEmployee);
        get(EMPLOYEES, getValue("id"),200);
        delete(EMPLOYEES, getValue("id"),204);
        get(EMPLOYEES, getValue("id"),404);
    }

    @Test
    @Description("49. GET /employees/{id}/{picked_field}")
    public static void getEmployeeByField() {
        String id = getRandomInteger(EMPLOYEES_DB);
        get(EMPLOYEES, id, getRandomField(EMPLOYEES_DB, id),200);
    }

}
