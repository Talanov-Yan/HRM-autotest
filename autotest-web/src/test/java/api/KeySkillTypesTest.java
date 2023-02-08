package api;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static dictionaries.ApiEndpointsConst.KEY_SKILL_TYPES;
import static dictionaries.TablesNameConst.KEY_SKILL_TYPES_DB;
import static steps.ApiSteps.get;
import static utils.api.fixtures.FixtureDB.getRandomField;
import static utils.api.fixtures.FixtureDB.getRandomInteger;

public class KeySkillTypesTest extends BaseApiTest {

    @Test
    @Description("50. GET /key_skill_types/")
    public static void getListOfKeySkillTypes() {
        get(KEY_SKILL_TYPES,200);
    }

    @Test
    @Description("52. GET /key_skill_types/{id}/")
    public static void getKeySkillTypeById() {
        get(KEY_SKILL_TYPES, getRandomInteger(KEY_SKILL_TYPES_DB),200);
    }

    @Test
    @Description(value = "55. GET /key_skill_types/{id}/{picked_field}")
    public static void getKeySkillTypeByField() {
        String id = getRandomInteger(KEY_SKILL_TYPES_DB);
        get(KEY_SKILL_TYPES, id, getRandomField(KEY_SKILL_TYPES_DB, id),200);
    }
}
