package org.dimwits.gui.screens;

import org.dimwits.data.dao.PrisonerDAO;
import org.dimwits.data.models.Prisoner;
import org.dimwits.gui.customized.CButton;
import org.dimwits.gui.screens.SearchScreen;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by farid on 2/11/17.
 */
@Service
public class LinkInitiator {
    private SearchScreen searchScreen1 = new SearchScreen(false);
    private SearchScreen searchScreen2 = new SearchScreen(false);

    private JFrame frame1;
    private JFrame frame2;

    public void createSearchWindows() {
        if (frame1 != null) frame1.dispose();
        if (frame2 != null) frame2.dispose();

        frame1 = createFrame(600, 600, 0, 0, "Первый");
        frame2 = createFrame(600, 600, 600, 0, "Второй");

        searchScreen1 = new SearchScreen();
        searchScreen2 = new SearchScreen();

        JPanel panel1 = new JPanel(new GridBagLayout());
        JPanel panel2 = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty = 1;
        constraints. weightx = 1;

        panel1.add(searchScreen1, constraints);
        panel2.add(searchScreen2, constraints);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weighty = 0;
        constraints.gridy = 1;

        CButton makeLinkButton = new CButton("Создать связь");
        panel2.add(makeLinkButton, constraints);

        makeLinkButton.addActionListener(this::makeLink);

        frame1.add(panel1);
        frame2.add(panel2);
    }

    private void makeLink(ActionEvent actionEvent) {
        Prisoner prisoner1 = searchScreen1.getSelectedPrisoner();
        Prisoner prisoner2 = searchScreen2.getSelectedPrisoner();

        if (prisoner1 != null && prisoner2 != null) {
            PrisonerDAO prisonerDAO = new PrisonerDAO();
            prisonerDAO.linkTwoPrisoners(prisoner1, prisoner2);
        }
    }

    private JFrame createFrame(int width, int height, int x, int y, String title) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        frame.setSize(width, height);//TODO: constants for window size and location
        frame.setLocation(x, y);

        return frame;
    }
}
