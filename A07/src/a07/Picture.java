package a07;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * class to extend JPanel functionality for rotating image icons
 * it displays the head, body, and tail of an animal in three different icons and can rotate through
 * three different animals. Also there are there different barn colors
 * @author alexf
 *
 */
@SuppressWarnings("serial")
public class Picture extends JPanel
{
    private ImageIcon icon2 = new ImageIcon(A07.class.getResource("/images/tail1.png"));
    private ImageIcon icon = new ImageIcon(A07.class.getResource("/images/head1.png"));
    private ImageIcon icon1 = new ImageIcon(A07.class.getResource("/images/body1.png"));
    private ImageIcon background = new ImageIcon(A07.class.getResource("/images/barn1.jpg"));
    int counterTail = 1;
    int counterBody = 1;
    int counterHead = 1;
    int counterBarn=1;

    /**
     * Overridden paintComponent method to paint all starting icons on label
     */
    @Override
    protected void paintComponent(Graphics g)
    {
	super.paintComponent(g);

	background.paintIcon(this, g, 0, 0);
	icon2.paintIcon(this, g, 75, 250);
	icon1.paintIcon(this, g, 225, 250);
	icon.paintIcon(this, g, 375, 250);
    }

    /**
     * Method to rotate through tail icons
     */
    public void swapTails()
    {
	counterTail++;
	icon2 = new ImageIcon(A07.class.getResource("/images/tail" + counterTail + ".png"));
	if (counterTail == 3)
	    counterTail = 0;
	repaint();
    }

    /**
     * method to rotate through body icons
     */
    public void swapBody()
    {
	counterBody++;
	icon1 = new ImageIcon(A07.class.getResource("/images/body" + counterBody + ".png"));
	if (counterBody == 3)
	    counterBody = 0;
	repaint();
    }

    /**
     * method to rotate through head icons
     */
    public void swapHead()
    {
	counterHead++;
	icon = new ImageIcon(A07.class.getResource("/images/head" + counterHead + ".png"));
	if (counterHead == 3)
	    counterHead = 0;
	repaint();
    }
    
    /**
     * method to rotate barn colors
     */
    public void swapBarn()
    {
	counterBarn++;
	background = new ImageIcon(A07.class.getResource("/images/barn"+counterBarn+".jpg"));
	if(counterBarn ==3)
	    counterBarn=0;
	repaint();
	
    }

}
