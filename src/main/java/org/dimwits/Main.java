package org.dimwits;

import org.dimwits.gui.MainWindow;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by farid on 1/30/17.
 * Main class
 */
@SpringBootApplication
public class Main {
    public static void main(String... args) {
        Launcher.launch(args);
    }
}
