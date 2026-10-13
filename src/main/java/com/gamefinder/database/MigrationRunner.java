package com.gamefinder.database;

import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.Statement;

public class MigrationRunner {
    public static void main(String[] args) throws IOException, SQLException {
        String sql = Files.readString(Path.of("src/main/resources/db/migration/V3__Create_favorites_table.sql"));

        Connection testConnection = DatabaseConnection.getInstance().getConnection();

        try (Statement statement = testConnection.createStatement()) {
            statement.execute(sql);
        }

        System.out.println("Миграция выполнена");
    }
}
