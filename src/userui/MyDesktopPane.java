/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userui;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 *
 * @author Pavneet
 */
public class MyDesktopPane extends JDesktopPane {

    private Image img;

    public MyDesktopPane() {
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/userui/airplane.jpg"));
            img = icon.getImage();
        } catch (Exception ex) {
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (img != null) {
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        } else {
            super.paintComponent(g);
        }
    }

}