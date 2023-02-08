package api;

import org.testng.annotations.BeforeTest;

import static steps.ApiSteps.authorization;

public class BaseApiTest {
    @BeforeTest
    public void prepare() {
        authorization();
    }
}
