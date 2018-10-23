package utility;

import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class AllCommonOperations {
    public static void openInternalFrames(JDesktopPane deskpane, JInternalFrame jif) {
        jif.setVisible(true);
        deskpane.add(jif);
        try {
            jif.setSelected(true);
        } catch (PropertyVetoException ex) {
        }
    }
}
