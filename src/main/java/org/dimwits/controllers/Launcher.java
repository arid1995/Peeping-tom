package org.dimwits.controllers;

import org.dimwits.Main;
import org.dimwits.data.utils.Database;
import org.dimwits.gui.MainWindow;
import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.sql.SQLException;

/**
 * Created by farid on 1/31/17.
 * Project launcher
 */
public class Launcher {
    public static void launch(String... args) {
        new SpringApplicationBuilder(Main.class).headless(false).web(false).run(args);

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        makeMigrations();
    }

    private static void makeMigrations() {
        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:sqlite:convicts.db", null, null);
        flyway.migrate();
    }
}
