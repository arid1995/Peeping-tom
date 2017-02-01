package org.dimwits.controllers;

import org.dimwits.Main;
import org.dimwits.gui.MainWindow;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

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

    }
}
