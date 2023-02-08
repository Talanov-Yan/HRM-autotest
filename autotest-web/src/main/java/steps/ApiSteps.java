package steps;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import net.minidev.json.JSONObject;
import ru.lanit.at.api.testcontext.ContextHolder;

import static io.restassured.RestAssured.given;

public class ApiSteps {

    private static final String baseUrl = WebSteps.loadProperties().getProperty("base.url");
    private static final String username = WebSteps.loadProperties().getProperty("username");
    private static final String password = WebSteps.loadProperties().getProperty("password");

    /**
     * Метод для авторизации пользователя.
     */
    public static void authorization() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .addHeader("Authorization", getAuthToken(username, password))
                .setContentType(ContentType.JSON)
                .build();
    }

    /**
     * Метод для получения токена.
     *
     * @param username - имя пользователя
     * @param password - пароль
     */
    public static void getToken(String username, String password) {
        JSONObject innerBody = new JSONObject();
        innerBody.put("username", username);
        innerBody.put("password", password);
        JsonPath tokenJson = given()
                .baseUri(baseUrl)
                .contentType("application/json")
                .body(innerBody)
                .when().log().all()
                .post("api/otp_token/")
                .then().log().all()
                .statusCode(200)
                .extract()
                .jsonPath();
        ContextHolder.put("TOTP", tokenJson.get("otp_token").toString());
    }

    /**
     * Метод для получения auth токена
     *
     * @param username - имя пользователя
     * @param password - пароль
     * @return строковое представление токена
     */
    public static String getAuthToken(String username, String password) {

        JSONObject requestParams = new JSONObject();
        requestParams.put("username", username);
        requestParams.put("password", password);
        JsonPath authTokenJson = given()
                .baseUri(baseUrl)
                .contentType("application/json")
                .body(requestParams)
                .when().log().all()
                .post("api/login/")
                .then().log().all()
                .statusCode(200)
                .extract()
                .jsonPath();
        ContextHolder.put("LoginKey", authTokenJson.get("token").toString());
        return "Token " + ContextHolder.getValue("LoginKey").toString();
    }

    /**
     * GET - запрос. Получает список всех сущностей.
     *
     * @param endpoint - API эндпоинт
     * @param statusCode - статус-код
     */
    @Step("GET-запрос на эндпоинт - {endpoint}, ожидается статус-код - {status-code}")
    public static void get(String endpoint, Integer statusCode) {

        given()
                .when().log().all()
                .get(endpoint)
                .then().log().all()
                .statusCode(statusCode);
    }

    /**
     * GET - запрос. Получает сущность по ID.
     *
     * @param endpoint - API эндпоинт
     * @param id - порядковый номер сущности
     * @param statusCode - статус-код
     */
    @Step("GET-запрос на эндпоинт - {endpoint} с id = {id}, ожидается статус-код - {status-code}")
    public static void get(String endpoint, String id, Integer statusCode) {

        given()
                .when().log().all()
                .get(endpoint + id)
                .then().log().all()
                .statusCode(statusCode);
    }

    /**
     * GET - запрос. Получает значение поля сущности по ID и наимнованию столбца.
     *
     * @param endpoint - API эндпоинт
     * @param id - порядковый номер сущности
     * @param pickedField - наименование столбца
     * @param statusCode - статус-код
     */
    @Step("GET-запрос на эндпоинт - {endpoint} с id = {id}, с полем - {pickedField}, ожидается статус-код - {status-code}")
    public static void get(String endpoint, String id, String pickedField, Integer statusCode) {

        given()
                .when().log().all()
                .get(endpoint + id + "/" + pickedField)
                .then().log().all()
                .statusCode(statusCode);
    }

    /**
     * GET - запрос. Получает и сохраняет сущность по ID.
     *
     * @param endpoint - API эндпоинт
     * @param id - порядковый номер сущности
     * @param statusCode - статус-код
     */
    @Step("GET-запрос на эндпоинт - {endpoint} с id = {id}, ожидается статус-код - {statusCode}")
    public static void getAndSaveResponse(String endpoint, String id, Integer statusCode) {

        JsonPath jsonPath = given()
                .when().log().all()
                .get(endpoint + id)
                .then().log().all()
                .statusCode(statusCode)
                .extract()
                .jsonPath();
        ContextHolder.put("response", jsonPath);
    }

    /**
     * POST - запрос. Создает новую сущность.
     *
     * @param endpoint - API эндпоинт
     * @param statusCode - статус-код
     * @param requestBody - тело JSON-объекта
     */
    @Step("POST-запрос на эндпоинт - {endpoint}, ожидается статус-код - {status-code}")
    public static void post(String endpoint, Integer statusCode, JSONObject requestBody) {

        JsonPath jsonPath = given()
                .body(requestBody).log().all()
                .when()
                .post(endpoint)
                .then().log().all()
                .statusCode(statusCode)
                .extract()
                .jsonPath();
        ContextHolder.put("id", jsonPath.get("id").toString());
    }

    /**
     * PATCH-запрос. Изменение сущности.
     *
     * @param endpoint - API эндпоинт
     * @param id - порядковый номер сущности
     * @param statusCode - статус-код
     * @param requestBody - новое тело JSON-объекта
     */
    @Step("PATCH-запрос на эндпоинт - {endpoint} с id = {id}, ожидается статус-код - {status-code}")
    public static void patch(String endpoint, String id, Integer statusCode, JSONObject requestBody) {

        given()
                .body(requestBody).log().all()
                .when()
                .patch(endpoint + id)
                .then().log().all()
                .statusCode(statusCode);
    }

    /**
     * DELETE-запрос. Удаляет существующую сущность
     *
     * @param endpoint - API эндпоинт
     * @param id - порядковый номер сущности
     * @param statusCode - статус-код
     */
    @Step("DELETE-запрос на эндпоинт - {endpoint} с id = {id}, ожидается статус-код - {status-code}")
    public static void delete(String endpoint, String id, Integer statusCode) {

        given()
                .when().log().all()
                .delete(endpoint + id)
                .then().log().all()
                .statusCode(statusCode);
    }
}