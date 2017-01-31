package org.dimwits;

import org.dimwits.gui.MainWindow;
import org.springframework.boot.SpringApplication;

/**
 * Created by farid on 1/31/17.
 */
public class Launcher {
    public static void launch(String... args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainWindow("Peeping tom");
            }
        });

        SpringApplication.run(Main.class, args);

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
