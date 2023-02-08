package api;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utils.api.fixtures.FixtureDB;

import static dictionaries.ApiEndpointsConst.POSITIONS;
import static dictionaries.TablesNameConst.*;
import static steps.ApiSteps.get;
import static utils.api.fixtures.FixtureDB.getRandomField;
import static utils.api.fixtures.FixtureDB.getRandomInteger;

public class PositionsTest extends BaseApiTest{
    @Test
    @Description("64. GET /positions/")
    public static void getListOfPositions() {
        get(POSITIONS,200);
    }


    @Test
    @Description("66. GET /positions/{id}/")
    public static void getPositionsById() {
        get(POSITIONS, getRandomInteger(POSITIONS_DB),200);
    }


    @Test
    @Description("69. GET /positions/{id}/{picked_field}")
    public static void getPositionByField() {
        String id = getRandomInteger(POSITIONS_DB);
        get(POSITIONS, id, getRandomField(POSITIONS_DB, id),200);
    }
}
