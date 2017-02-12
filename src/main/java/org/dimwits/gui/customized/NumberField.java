package org.dimwits.gui.customized;

/**
 * Created by farid on 2/12/17.
 */
public class NumberField extends CTextField {
    public NumberField() {

    }

    public NumberField(boolean required) {
        super(required);
    }

    @Deprecated
    @Override
    public String getText() {
        return null;
    }

    public Integer getNumber() {
        Integer number;
        try {
            number = Integer.parseInt(super.getText());
        } catch (NumberFormatException ex) {
            this.setBorder(errorBorder);
            return null;
        }

        this.setBorder(normalBorder);
        return number;
    }
}
