package org.dimwits.data.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
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


    public static void select(String query, Executor executor) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:convicts.db")) {
            try (Statement statement = connection.createStatement()) {
                statement.executeQuery(query);
                try (ResultSet result = statement.getResultSet()) {
                    executor.execute(result);
                }
            }
        }
    }

    public static <T> T select(String query, TExecutor<T> executor) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:convicts.db")) {
            try (Statement statement = connection.createStatement()) {
                statement.executeQuery(query);
                try (ResultSet result = statement.getResultSet()) {
                    return executor.execute(result);
                }
            }
        }
    }

    public static int update(String query) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:convicts.db")) {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(query/*, Statement.RETURN_GENERATED_KEYS*/);
                try(ResultSet result = statement.getGeneratedKeys()) {
                    //if(result.next()) return result.getInt(1);
                    return 0;
                }
            }
        }
    }
}
