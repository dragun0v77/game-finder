package com.gamefinder.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection; // интерфейс для соединения с базой
import java.sql.DriverManager; // драйвер, который управляет драйверами и создаёт соединения
import java.sql.SQLException; // ошибка, которая может возникнуть при работе с базой.

public class DatabaseConnection {
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseConnection.class);
    private static DatabaseConnection instance; // класс-подключатель
    private Connection connection; // Соединение с базой данных

    public boolean testConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                LOGGER.info("Подключение к базе данных успешно!");
                return true;
            }
        } catch (SQLException e) {
            LOGGER.error("Ошибка проверки подключения: ", e);
        }
        return false;
    }

    // Приватный конструктор — никто не может создать объект снаружи
    private DatabaseConnection() {
        try {
            String url = System.getenv("DB_URL");
            String user = System.getenv("DB_USER");
            String password = System.getenv("DB_PASSWORD");
            this.connection = DriverManager.getConnection(url, user, password);
            LOGGER.info("Подключение к базе данных установлено");
        } catch (SQLException e) {
            LOGGER.error("Ошибка подключения к базе данных: ", e);
            throw new RuntimeException("Ошибка подключения к базе данных", e);
        }
    }

    // 3. Публичный метод для получения единственного экземпляра
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    // 4. Метод для получения соединения
    public Connection getConnection() {
        return connection;
    }
}
