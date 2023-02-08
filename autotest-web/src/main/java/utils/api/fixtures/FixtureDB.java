package utils.api.fixtures;

import java.sql.*;
import java.util.ArrayList;
import steps.WebSteps;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FixtureDB implements Fixturable {
    private static final String DB_URL = WebSteps.loadProperties().getProperty("DB_URL");
    private static final String USER = WebSteps.loadProperties().getProperty("USER");
    private static final String PASS = WebSteps.loadProperties().getProperty("PASS");
    private static final String DRIVER = WebSteps.loadProperties().getProperty("DRIVER");

    /**
     * Получение рандомного ID для фикстуры из выбранной таблицы
     *
     * @param tableName - название таблицы
     * @return - возвращает id строки в БД
     */
    public static String getRandomInteger(String tableName) {

        List<Integer> result = new ArrayList<>();
        try (Connection connection = connectToDatabase();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName);
            while (resultSet.next()) {
                result.add(Integer.valueOf(resultSet.getString(1)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int random = new Random().nextInt(result.size());
        return String.valueOf(result.get(random));
    }

    /**
     * Метод получающий рандомное поле из базы данных
     *
     * @param tableName - название таблицы
     * @param id - id строки
     * @return - возвращает рандомное поле из выбранной строки в БД
     */
    public static String getRandomField(String tableName, String id) {

        List<String> result = new ArrayList<>();
        int columnCount;
        int random = 0;
        try (Connection connection = connectToDatabase();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName +
                                                             " WHERE id = " + id);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            columnCount = rsmd.getColumnCount();
            for (int i = 1; i < columnCount + 1; i++) {
                result.add(rsmd.getColumnName(i));
            }
            random = new Random().nextInt(columnCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result.get(random);
    }

    /**
     * Получение выбранных полей по названию колонок, выбранному ID и таблице
     *
     * @param tableName - название таблицы
     * @param id - id строки
     * @param columnName - название колонки
     * @param moreColumnNames - еще названия колонок
     * @return - query-запрос /{picked_fields}/
     */
    public static String getSelectedFields(String tableName, String id,
                                           String columnName, String... moreColumnNames) {

        List<String> listOfColumns = new ArrayList<>();
        listOfColumns.add(columnName);
        listOfColumns.addAll(Arrays.asList(moreColumnNames));
        StringBuilder pickedFields = new StringBuilder();
        try (Connection connection = connectToDatabase();
             Statement statement = connection.createStatement()) {
            for (String column : listOfColumns) {
                ResultSet resultSet = statement.executeQuery("SELECT " + column + " FROM " + tableName +
                                                                " WHERE id = " + id);
                if (resultSet.next()) {
                    pickedFields.append(column).append(",");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (pickedFields.length() != 0)
            pickedFields.deleteCharAt(pickedFields.length() - 1);
        return String.valueOf(pickedFields);
    }

    /**
     * Коннектор к базе данных
     *
     * @return - возвращает установленное соединение к базе данных
     */
    public static Connection connectToDatabase() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
