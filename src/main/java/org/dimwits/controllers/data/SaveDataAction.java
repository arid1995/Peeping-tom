package org.dimwits.controllers.data;

import org.dimwits.data.Persistable;
import org.dimwits.gui.utils.Collectable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by farid on 2/3/17.
 */
public class SaveDataAction implements ActionListener {
    Collectable form;

    public SaveDataAction(Collectable form) {
        this.form = form;
    }

    public void actionPerformed(ActionEvent e) {
        form.collectData().persist();
    }
}
