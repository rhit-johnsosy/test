package exam1GraphicsPkg;

import javax.swing.JFrame;
import javax.swing.JComponent;

/**
 * Class: MouseViewer
 * Purpose: Create and set visible a Java Swing app to display a Mouse
 * Restrictions: none
 * 
 * @author Steven Johnson
 * 
 *************************************************************************************** 
 *         REQUIRED HELP CITATION
 * 
 *         only used CSSE220 materials
 *************************************************************************************** 
 */
public class MouseViewer {

    /**
     * Creates, initializes, and sets visible the Viewer's frame and component.
     */
    private void driverMain() {
        final String frameTitle = "Graphics Display";
        final int frameWidth = 1000;
        final int frameHeight = 600;
        final int frameXLoc = 100;
        final int frameYLoc = 100;

        // Creating the JFrame
        JFrame frame = new JFrame();
        frame.setTitle(frameTitle);
        frame.setSize(frameWidth, frameHeight);
        frame.setLocation(frameXLoc, frameYLoc);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creating and adding the component to draw the Mouse
        JComponent MouseComponent = new MouseComponent();
        frame.add(MouseComponent);
        frame.setVisible(true);
    }

    /**
     * The main entry point for the application.
     * @param args - Command line arguments (ignored)
     */
    public static void main(String[] args) {
        MouseViewer MouseViewer = new MouseViewer();
        MouseViewer.driverMain();
    }
}
