package org.dimwits.data.utils;

import com.mchange.v2.c3p0.DataSources;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.*;

/**
 * Created by farid on 2/4/17.
 */
@SuppressWarnings("Duplicates")
public class Database {
    private static DataSource pool;
    static
    {
        SQLiteDataSource unpooled = new SQLiteDataSource();
        unpooled.setUrl("jdbc:sqlite:convicts.db");
        try {
            pool = DataSources.pooledDataSource( unpooled );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void select(String query, Executor executor) throws SQLException {
        try (Connection connection = pool.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet result = statement.executeQuery(query)) {
                    executor.execute(result);
                }
            }
        }
    }

    public static <T> T select(String query, TExecutor<T> executor) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:convicts.db")) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet result = statement.executeQuery(query)) {
                    return executor.execute(result);
                }
            }
        }
    }

    public static int update(String query) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:convicts.db")) {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(query);
                try(ResultSet result = statement.getGeneratedKeys()) {
                    return 0;
                }
            }
        }
    }
}
