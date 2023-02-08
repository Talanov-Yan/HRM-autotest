package api;

import io.qameta.allure.Description;
import net.minidev.json.JSONObject;
import org.testng.annotations.Test;

import static dictionaries.ApiEndpointsConst.ACHIEVEMENTS;
import static dictionaries.TablesNameConst.ACHIEVEMENTS_DB;
import static ru.lanit.at.api.testcontext.ContextHolder.getValue;
import static ru.lanit.at.utils.DataGenerator.generateValueByMask;
import static steps.ApiSteps.*;
import static utils.api.fixtures.FixtureDB.*;

public class AchievementsTest extends BaseApiTest {

    @Test
    @Description(value = "7. GET /achievements/")
    public static void getListOfAchievements() {
        get(ACHIEVEMENTS,200);
    }

    @Test
    @Description(value = "8. POST /achievements/")
    public static void createAchievement() {
        JSONObject newAchievement = new JSONObject();
        newAchievement.put("name", generateValueByMask("RRRRRRRRRRR"));

        post(ACHIEVEMENTS,201,newAchievement);
        get(ACHIEVEMENTS,  getValue("id"),200);
        delete(ACHIEVEMENTS, getValue("id"),204);
        get(ACHIEVEMENTS, getValue("id"),404);
    }

    @Test
    @Description(value = "9. GET /achievements/{id}")
    public static void getAchievementById() {
        get(ACHIEVEMENTS, getRandomInteger(ACHIEVEMENTS_DB),200);
    }

    @Test
    @Description(value = "10. PATCH /achievements/{id}")
    public static void changeCreatedAchievement() {
        JSONObject newAchievement = new JSONObject();
        newAchievement.put("name", generateValueByMask("RRRRRRRRRRR"));

        JSONObject patchedAchievement = new JSONObject();
        patchedAchievement.put("name", generateValueByMask("RRRRRRRRRRR"));

        post(ACHIEVEMENTS,201,newAchievement);
        get(ACHIEVEMENTS, getValue("id"),200);
        patch(ACHIEVEMENTS, getValue("id"),200, patchedAchievement);
        delete(ACHIEVEMENTS, getValue("id"),204);
        get(ACHIEVEMENTS, getValue("id"),404);
    }

    @Test
    @Description(value = "11. DELETE /achievements/{id}")
    public static void deleteCreatedAchievement() {
        JSONObject newAchievement = new JSONObject();
        newAchievement.put("name", generateValueByMask("RRRRRRRRRRR"));

        post(ACHIEVEMENTS,201,newAchievement);
        get(ACHIEVEMENTS, getValue("id"),200);
        delete(ACHIEVEMENTS, getValue("id"),204);
        get(ACHIEVEMENTS, getValue("id"),404);
    }

    @Test
    @Description(value = "12. GET /achievements/{id}/{picked_field}")
    public static void getAchievementByField() {
        String id = getRandomInteger(ACHIEVEMENTS_DB);
        get(ACHIEVEMENTS, id, getRandomField(ACHIEVEMENTS_DB, id),200);
        get(ACHIEVEMENTS, id, getSelectedFields(ACHIEVEMENTS_DB, id,
                "id", "name"),200);
    }
}
