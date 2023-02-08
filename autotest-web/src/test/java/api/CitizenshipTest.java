package api;

import io.qameta.allure.Description;
import net.minidev.json.JSONObject;
import org.testng.annotations.Test;

import static dictionaries.ApiEndpointsConst.CITIZENSHIP;
import static dictionaries.TablesNameConst.CITIZENSHIP_DB;
import static ru.lanit.at.api.testcontext.ContextHolder.getValue;
import static ru.lanit.at.utils.DataGenerator.generateValueByMask;
import static steps.ApiSteps.*;
import static steps.ApiSteps.get;
import static utils.api.fixtures.FixtureDB.*;
import static utils.api.fixtures.FixtureDB.getSelectedFields;

public class CitizenshipTest extends BaseApiTest {

    @Test
    @Description(value = "25. GET /citizenship/")
    public static void getListOfCitizenship() {
        get(CITIZENSHIP,200);
    }

    @Test
    @Description(value = "26. POST /citizenship/")
    public static void createCitizenship() {
        JSONObject newCitizenship = new JSONObject();
        newCitizenship.put("name", generateValueByMask("RRRRRRRRRRR"));

        post(CITIZENSHIP,201,newCitizenship);
        get(CITIZENSHIP,  getValue("id"),200);
        delete(CITIZENSHIP, getValue("id"),204);
        get(CITIZENSHIP, getValue("id"),404);
    }

    @Test
    @Description(value = "27. GET /citizenship/{id}")
    public static void getCitizenshipById() {
        get(CITIZENSHIP, getRandomInteger(CITIZENSHIP_DB),200);
    }

    @Test
    @Description(value = "28. PATCH /citizenship/{id}")
    public static void changeCreatedCitizenship() {
        JSONObject newCitizenship = new JSONObject();
        newCitizenship.put("name", generateValueByMask("RRRRRRRRRRR"));

        JSONObject patchedCitizenship = new JSONObject();
        patchedCitizenship.put("name", generateValueByMask("RRRRRRRRRRR"));

        post(CITIZENSHIP,201,newCitizenship);
        get(CITIZENSHIP, getValue("id"),200);
        patch(CITIZENSHIP, getValue("id"),200, patchedCitizenship);
        delete(CITIZENSHIP, getValue("id"),204);
        get(CITIZENSHIP, getValue("id"),404);
    }

    @Test
    @Description(value = "29. DELETE /citizenship/{id}")
    public static void deleteCreatedCitizenship() {
        JSONObject newCitizenship = new JSONObject();
        newCitizenship.put("name", generateValueByMask("RRRRRRRRRRR"));

        post(CITIZENSHIP,201, newCitizenship);
        get(CITIZENSHIP, getValue("id"),200);
        delete(CITIZENSHIP, getValue("id"),204);
        get(CITIZENSHIP, getValue("id"),404);
    }

    @Test
    @Description(value = "30. GET /citizenship/{id}/{picked_field}")
    public static void getCitizenshipFields() {
        String id = getRandomInteger(CITIZENSHIP_DB);
        get(CITIZENSHIP, id, getRandomField(CITIZENSHIP_DB, id),200);
        get(CITIZENSHIP, id, getSelectedFields(CITIZENSHIP_DB, id,
                "id", "name"),200);
    }
}
