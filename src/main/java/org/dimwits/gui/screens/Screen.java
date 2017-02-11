package org.dimwits.gui.screens;

import com.sun.istack.internal.Nullable;

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

    @Nullable
    public static Screen goBack() {
        if (history.size() > 1) {
            history.pop();
            return history.peek();
        }
        return null;
    }
}
