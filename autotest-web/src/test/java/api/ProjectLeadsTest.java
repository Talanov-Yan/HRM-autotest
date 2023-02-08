package api;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static dictionaries.TablesNameConst.PROJECT_LEADS_DB;
import static steps.ApiSteps.*;
import static dictionaries.ApiEndpointsConst.PROJECT_LEADS;
import static utils.api.fixtures.FixtureDB.getRandomField;
import static utils.api.fixtures.FixtureDB.getRandomInteger;

public class ProjectLeadsTest extends BaseApiTest {

    @Test
    @Description("70. GET /project_leads/")
    public static void getProjectLeads() {
        get(PROJECT_LEADS, 200);
    }

    @Test
    @Description("72. GET /project_roles/{id}/")
    public static void getProjectLeadById(){
        get(PROJECT_LEADS, getRandomInteger("core_projectleads"), 200);
    }

    @Test
    @Description("75. GET /project_leads/{id}/{picked_fields}/")
    public static void getFieldsFromProjectLead(){
        String id = getRandomInteger(PROJECT_LEADS_DB);
        get(PROJECT_LEADS, id, getRandomField(PROJECT_LEADS_DB, id), 200);
    }

}
