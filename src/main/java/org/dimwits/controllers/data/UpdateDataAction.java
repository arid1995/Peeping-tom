package org.dimwits.controllers.data;

import org.dimwits.gui.utils.Collectable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by farid on 2/9/17.
 */
public class UpdateDataAction implements ActionListener {
    private Collectable form;

    public UpdateDataAction(Collectable form) {
        this.form = form;
    }

    public void actionPerformed(ActionEvent e) {
            form.collectData().update();
    }
}
