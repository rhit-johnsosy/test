package exam1GraphicsPkg;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;

/**
 * Class: Mouse
 * Purpose: To store Mouse information and to draw the Mouse
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
public class Mouse {
	
    // Constants for Mouse
    public static final Color NOSE_COLOR = Color.BLACK;
    public static final Color HEAD_COLOR = Color.GRAY;
	public static final Color EYE_COLOR = Color.BLACK;
	public static final Color EAR_COLOR = Color.BLACK;
    
    ///////////////////////////////////////////////////
    //DEFAULT PARAMETERS (may vary for Parts 2-3)    //
    ///////////////////////////////////////////////////

    // Default values
    public static final int DEFAULT_X_CENTER = 100;
    public static final int DEFAULT_Y_CENTER = 100;
    public static final int DEFAULT_WIDTH = 100;

    /** This defines the ratio from the height to width
     *  the height is slightly smaller than the width
     */
    public static final double HEIGHT_TO_WIDTH_RATIO = Math.sqrt(3)/2;
        

    //adds instance variables as needed
    private int x;
    private int y;
    private int width;
    private double height;
    private double eyeRadius;
    private double earRadius;
    private double noseRadius;


    
	/**
	 * Sets the instance variables required for making a mouse without arguments provided
	 */
    public Mouse() {
    	this.x = DEFAULT_X_CENTER;
    	this.y = DEFAULT_Y_CENTER;
    	this.width = DEFAULT_WIDTH;
    	this.height = this.width * HEIGHT_TO_WIDTH_RATIO;
    	this.earRadius = this.width / 4;
    	this.eyeRadius = this.width / 16;
    	this.noseRadius = this.width / 8;
        

    }
	
    /**
     * Sets the instance variables required for making a mouse with arguments provided
     * 
     * @param xCenter  the x-position of the center of the mouse
     * @param yCenter  the y-position of the center of the mouse
     * @param width    the width of the mouse head
     */
	public Mouse(int xCenter, int yCenter, int width) {
		this.x = xCenter;
		this.y = yCenter;
		this.width = width;
		this.height = this.width * HEIGHT_TO_WIDTH_RATIO;
    	this.earRadius = this.width / 4;
    	this.eyeRadius = this.width / 16;
    	this.noseRadius = this.width / 8;
	}
	
	

	/**
	 * Draws the desired mouse.
	 * 
	 * @param g2 imports graphics into the method
	 */
	public void drawOn(Graphics2D g2) {
		// draws the mouse head
		int[] xList = new int[]{x - width/2, x + width/2, x};
		int[] yList = new int[]{y -  (int) height/2, y - (int) height/2, 
				y + (int) height/2};
		Polygon head = new Polygon(xList, yList, 3);
		g2.setColor(HEAD_COLOR);
		g2.fill(head);
		g2.draw(head);
		
		// draws ears
		Ellipse2D earLeft = new Ellipse2D.Double(x - 3 * width/4, y - 3 * height/4, 
				2 * earRadius, 2 * earRadius);
		Ellipse2D earRight = new Ellipse2D.Double(x + width/4, y - 3 * height/4, 
				2 * earRadius, 2 * earRadius);
		g2.setColor(EAR_COLOR);
		g2.fill(earLeft);
		g2.fill(earRight);
		g2.draw(earLeft);
		g2.draw(earRight);
		
		// draws eyes
		Ellipse2D eyeLeft = new Ellipse2D.Double(x - 3 * eyeRadius, y - eyeRadius, 
				2 * eyeRadius, 2 * eyeRadius);
		Ellipse2D eyeRight = new Ellipse2D.Double(x + eyeRadius, y - eyeRadius, 
				2 * eyeRadius, 2 * eyeRadius);
		g2.setColor(EYE_COLOR);
		g2.fill(eyeLeft);
		g2.fill(eyeRight);
		g2.draw(eyeLeft);
		g2.draw(eyeRight);
		
		// draws nose
		Ellipse2D nose = new Ellipse2D.Double(x - noseRadius, y + height/2 - noseRadius, 
				noseRadius * 2, noseRadius * 2);
		g2.setColor(NOSE_COLOR);
		g2.fill(nose);
		g2.draw(nose);
    }
	
  
    /**
     * Rotates the mouse.
     * 
     * @param g2         imports graphics into the method
     * @param rotation   the rotation (in radians) of the mouse
     */
	public void rotate(Graphics2D g2, double rotation) {
		g2.translate(x, y);
		g2.rotate(rotation);
		g2.translate(-x, -y);
	}
	
	/**
	 * Used to reverse a rotation on the mouse to allow for a new rotation.
	 * 
	 * @param g2        imports graphics into the method
	 * @param rotation  the rotation (in radians) of the mouse
	 */
	public void derotate(Graphics2D g2, double rotation) {
		g2.translate(x, y);
		g2.rotate(-rotation);
		g2.translate(-x, -y);
	}
}

