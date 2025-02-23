package exam1GraphicsPkg;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 * Class: MouseComponent extends JComponent Purpose: To implement the
 * paintComponent callback operation for drawing a Mouse Restrictions: none
 * 
 * @author Steven Johnson
 * 
 *************************************************************************************** 
 *         REQUIRED HELP CITATION
 * 
 *         only used CSSE220 materials
 *************************************************************************************** 
 */
public class MouseComponent extends JComponent {
	private static final long serialVersionUID = 1L;

	/**
	 * Creates and draws the Mouse.
	 * 
	 * @param g - the graphics object for drawing
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		// -----
		// TODO Part 0
		//
		// Run the program and see the drawn rectangle.
		// This is where the middle of the Mouse's body
		// should appear.
		// -----
//		drawOutlineRectangle(g2);
		
		
		// -----
		// TODO Part 1
		//
		// For the Mouse class, make a default 0-argument constructor
		//
		// Use the constants in Mouse.java to define the location and size.
		//
		// After getting the Mouse to show up properly, you should comment out the
		// Rectangle drawing code above
		// -----
		g2.drawString("Part 1", 10, 20);
		// draws part 1
		Mouse mouse = new Mouse();
		mouse.drawOn(g2);
		

		// -----
		// TODO Part 2 - Size and Location
		//
		// For the Mouse class, make a 3-argument constructor that specifies
		// centerX, centerY, width
		//
		// Create and draw three Mouses (Mice)
		// Mouse1: center at (300,200), with width 50
		// Mouse2: center at (450,200), with width 100
		// Mouse3: center at (700,200), with width 150
		// -----
		g2.drawString("Part 2", 250, 20);
		// draws part 2
		Mouse m1 = new Mouse(300, 200, 50);
		Mouse m2 = new Mouse(450, 200, 100);
		Mouse m3 = new Mouse(700, 200, 150);
		m1.drawOn(g2);
		m2.drawOn(g2);
		m3.drawOn(g2);
		
		
		// -----
		// TODO Part 3 - Spinning Mouse
		//
		// Add a new method to the Mouse class.
		// * It should allow the rotation of the Mouse to be set
		//
		// Using this methods create and draw 7 Mouses starting with:
		// Mouse1: center at (120,450), with width 50, and rotation of 30 degrees
		// 
		// You can make a loop to make these Mouses (Mice)
		// 
		// Each new Mouse should:
		//   1. increase its rotation by +30 degrees compared to the previous
		//   2. adjusts the center x position by +120
		//
		// For full credit the image should match the one in the provided instructions
		// document.
		// -----
		g2.drawString("Part 3", 20, 400);
		// draws part 3
		for (int mouseIndex = 0; mouseIndex < 7; mouseIndex++) {
			Mouse Mouse1 = new Mouse(120 + mouseIndex * 120, 450, 50);
			Mouse1.rotate(g2, Math.PI/6 * (1 + mouseIndex));
			Mouse1.drawOn(g2);
			Mouse1.derotate(g2, Math.PI/6 * (1 + mouseIndex));
		}

	}

	/**
	 * 	This method uses constants from Mouse.java to determine the
	 *	rectangular outline of the triangle part of the default Mouse
	 *  you should not call this method in your final program
	 * @param g2
	 */
	private void drawOutlineRectangle(Graphics2D g2) {
		// It uses constants from Mouse.java to determine a
		// bounding rectangle of the default Mouse triangle face
		int width = Mouse.DEFAULT_WIDTH;
		int height = (int)(Mouse.DEFAULT_WIDTH * Mouse.HEIGHT_TO_WIDTH_RATIO);
		int topLeftX = Mouse.DEFAULT_X_CENTER - Mouse.DEFAULT_WIDTH/2;
		int topLeftY = Mouse.DEFAULT_Y_CENTER - height/2;
		g2.drawRect(topLeftX, topLeftY, width, height);
	}
}
