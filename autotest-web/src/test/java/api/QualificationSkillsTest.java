package api;

import io.qameta.allure.Description;
import io.restassured.path.json.JsonPath;
import net.minidev.json.JSONObject;
import org.testng.annotations.Test;
import utils.api.fixtures.FixtureDB;

import static dictionaries.ApiEndpointsConst.QUALIFICATION_SKILLS;
import static dictionaries.TablesNameConst.QUALIFICATION_SKILLS_DB;
import static org.testng.AssertJUnit.assertEquals;
import static ru.lanit.at.api.testcontext.ContextHolder.getValue;
import static ru.lanit.at.utils.DataGenerator.generateValueByMask;
import static steps.ApiSteps.*;
import static utils.api.fixtures.FixtureDB.getRandomField;
import static utils.api.fixtures.FixtureDB.getRandomInteger;

public class QualificationSkillsTest extends BaseApiTest {

    private static JSONObject createJsonObject() {
        JSONObject newQualificationSkills = new JSONObject();
        newQualificationSkills.put("name", generateValueByMask("RRRRRRRRRRR"));
        return newQualificationSkills;
    }

    @Test
    @Description("94. GET /qualification_skills/")
    public static void getListOfQualificationSkills() {
        get(QUALIFICATION_SKILLS, 200);
    }

    @Test
    @Description("95. POST /qualification_skills/")
    public static void createQualificationSkills() {
        JSONObject newQualificationSkills = createJsonObject();

        post(QUALIFICATION_SKILLS, 201, newQualificationSkills);
        getAndSaveResponse(QUALIFICATION_SKILLS, getValue("id"), 200);
        JsonPath jsonPath = getValue("response");
        assertEquals(jsonPath.get("name"), newQualificationSkills.get("name"));
        delete(QUALIFICATION_SKILLS, getValue("id"), 204);
        get(QUALIFICATION_SKILLS, getValue("id"), 404);
    }

    @Test
    @Description("96. GET /qualification_skills/{id}/")
    public static void getQualificationSkillsById() {
        get(QUALIFICATION_SKILLS, FixtureDB.getRandomInteger(QUALIFICATION_SKILLS_DB), 200);
    }

    @Test
    @Description("97. PATCH /qualification_skills/{id}/")
    public static void changeCreatedQualificationSkills() {
        JSONObject newQualificationSkills = createJsonObject();
        JSONObject patchedQualificationSkills = createJsonObject();

        post(QUALIFICATION_SKILLS, 201, newQualificationSkills);
        getAndSaveResponse(QUALIFICATION_SKILLS, getValue("id"), 200);
        JsonPath jsonPath = getValue("response");
        assertEquals(jsonPath.get("name"), newQualificationSkills.get("name"));

        patch(QUALIFICATION_SKILLS, getValue("id"), 200, patchedQualificationSkills);
        getAndSaveResponse(QUALIFICATION_SKILLS, getValue("id"), 200);
        JsonPath jsonPathAfterChange = getValue("response");
        assertEquals(jsonPathAfterChange.get("name"), patchedQualificationSkills.get("name"));

        delete(QUALIFICATION_SKILLS, getValue("id"), 204);
        get(QUALIFICATION_SKILLS, getValue("id"), 404);
    }

    @Test
    @Description("98. DELETE /qualification_skills/{id}/")
    public static void deleteCreatedQualificationSkills() {
        JSONObject newQualificationSkills = createJsonObject();

        post(QUALIFICATION_SKILLS, 201, newQualificationSkills);
        get(QUALIFICATION_SKILLS, getValue("id"), 200);
        delete(QUALIFICATION_SKILLS, getValue("id"), 204);
        get(QUALIFICATION_SKILLS, getValue("id"), 404);
    }

    @Test
    @Description("99. GET /qualification_skills/{id}/{picked_fields}/")
    public static void getQualificationSkillsByField() {
        String id = getRandomInteger(QUALIFICATION_SKILLS_DB);
        get(QUALIFICATION_SKILLS, id, getRandomField(QUALIFICATION_SKILLS_DB, id), 200);
    }
}