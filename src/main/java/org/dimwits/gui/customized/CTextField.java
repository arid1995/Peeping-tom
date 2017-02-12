package org.dimwits.gui.customized;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by farid on 2/3/17.
 */
public class CTextField extends JTextField {
    private boolean required;

    protected final static Border errorBorder = BorderFactory.createLineBorder(Color.RED);
    protected final static Border normalBorder = BorderFactory.createLineBorder(Color.GRAY);

    public CTextField() {
        this.setBorder(normalBorder);
    }

    public CTextField(boolean required) {
        this.required = required;
        this.setBorder(normalBorder);
    }

    @Override
    public String getText() {
        String text = super.getText();

        if (required && text.equals("")) {
            this.setBorder(errorBorder);
            return null;
        }

        this.setBorder(normalBorder);
        return text;
    }
}
