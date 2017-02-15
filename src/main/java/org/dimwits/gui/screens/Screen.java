package org.dimwits.gui.screens;

import javax.swing.*;
import java.util.Stack;

/**
 * Created by farid on 2/11/17.
 */
public abstract class Screen extends JPanel {
    private static Stack<Screen> history = new Stack<>();

    public void pushHistory() {
        history.push(this);
    }

    public static Screen goBack() {
        if (history.size() > 1) {
            Screen current = history.peek();
            history.pop();
            return current;
        }

        if (history.size() == 1) {
            return history.peek();
        }

        return null;
    }
}
