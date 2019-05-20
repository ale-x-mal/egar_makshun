package org.egar.makshun.jdbc.jdbc;


import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MySqlQuery {

    private static MySqlQuery instance;
    private static Map<String, String> queries;

    /**
     * метод для соединения с БД по параметрам, читаемые из файла connection.properties
     */
    private MySqlQuery() {
        Properties properties = PropertyUtils.getProperties("mysql_query.properties");
        Map<String, String> map = new HashMap<>();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            map.put((String) entry.getKey(), (String) entry.getValue());
        }
        queries = map;
    }

    /**
     * статический метод, возвращает единственный экземпляр класса (Singleton),
     * проверяя перед этим не создан ли он
     */
    public static MySqlQuery getInstance() {
        if (instance == null) {
            instance = new MySqlQuery();
        }
        return instance;
    }

    /**
     * получение запроса по ключу
     */
    public String getQuery(String key) {
        return queries.get(key);
    }
}