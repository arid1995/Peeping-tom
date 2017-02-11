package org.dimwits.gui.customized;

import javax.swing.*;

/**
 * Created by farid on 2/11/17.
 */
public class CFileChooser extends JFileChooser {
    public String getPath() {
        return this.getCurrentDirectory().getPath() + this.getSelectedFile().getName();
    }
}
