package utils.api.fixtures;

import io.restassured.path.json.JsonPath;
import ru.lanit.at.utils.DataGenerator;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static io.restassured.RestAssured.given;
import static steps.ApiSteps.getAuthToken;

// TODO: 26.01.2022 Класс находится на стадии доработки
//                  Пока-что является сырым
public class Fixture implements Fixturable {

    /**
     * Вспомогательные методы для создания сотрудника
     */

    public static int getRandom(int range) {
        return (int)(Math.random() * range);
    }

    public static int getRandom(int start, int range) {
        return start + (int)(Math.random() * range);
    }

    public static List<String> newFixture(String endPoint) {
        JsonPath listOfAccounts = given()
                .baseUri("http://178.154.246.238:58082/api")
                .contentType("application/json")
                .header("Authorization", getAuthToken("admin", "asdf"))
                .when().log().all()
                .get(endPoint)
                .then().log().all()
                .statusCode(200)
                .extract()
                .jsonPath();
        List<String> list = listOfAccounts.getList("id");
        System.out.println(list);
        return list;
    }

    public static void main(String[] args) {
        newFixture("/accounts/");
    }

    public static List<String> newFixtureGetIdInWrapArray(String endPoint) {
        JsonPath listOfAccounts = given()
                .baseUri("http://178.154.246.238:58082/api")
                .contentType("application/json")
                .header("Authorization", getAuthToken("admin", "asdf"))
                .when().log().all()
                .get(endPoint)
                .then().log().all()
                .statusCode(200)
                .extract()
                .jsonPath();
        List<String> list = listOfAccounts.getList("key_skills.id");
        System.out.println(list.get(1));
        System.out.println(list);
        return list;
    }

    public static LocalDate getBirthday() {
        LocalDate start = LocalDate.of(1964, Month.JANUARY, 01);
        long startOfEp = start.toEpochDay();
        LocalDate end = LocalDate.now();
        long endOfEp = end.toEpochDay();
        long birth = ThreadLocalRandom
                .current()
                .nextLong(startOfEp, endOfEp);
        return LocalDate.ofEpochDay(birth);
    }

    public static LocalDate getJoinDate() {
        LocalDate start = LocalDate.of(2018, Month.DECEMBER, 04);
        long startOfEp = start.toEpochDay();
        LocalDate end = LocalDate.of(2021, Month.JANUARY, 01);
        long endOfEp = end.toEpochDay();
        long joinDate = ThreadLocalRandom
                .current()
                .nextLong(startOfEp, endOfEp);
        return LocalDate.ofEpochDay(joinDate);
    }

    public static LocalDate getChangeCityDate(LocalDate joinDate) {
        long startOfEp = joinDate.toEpochDay();
        LocalDate end = LocalDate.now();
        long endOfEp = end.toEpochDay();
        long changeDate = ThreadLocalRandom
                .current()
                .nextLong(startOfEp, endOfEp);
        return LocalDate.ofEpochDay(changeDate);
    }

    public static String getNumber() {
        return DataGenerator.generateValueByMask("DDDDDDDDDD");
    }

    public static String getMail() {
        return DataGenerator.generateValueByMask("EEEEEDD"+"@"+"test.ru");
    }

    private Map<String, Object> getParameters() {

        Map<String, Object> params = new HashMap<>();

        return params;
    }

    /**
     * Метод меняет переменные, описанные как ${var} на соотвествующие значения из Map,
     где ключ соотвествует имени переменной.
     *
     * @param parameters = Map с параметрами.
     * @param template   = строка, в которой необходимо заменить знаечние.
     * @param <T>
     * @return = строка, в которой выполнена замена.
     */
    public static <T> String replaceVariables(Map<String, Object> parameters, String template) {
        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            String parameter = entry.getKey();
            //       String value = entry.getValue().replace("\"", "\\\"");
            //       template = template.replace("${" + parameter + "}", value);
        }
        return template;
    }
}
