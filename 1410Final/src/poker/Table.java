package poker;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * class to create table object to paint to main frame
 * @author alexf
 *
 */
public class Table extends JPanel
{

    private static final long serialVersionUID = -8024118876818326599L;
    private ImageIcon card1 = new ImageIcon(Table.class.getResource("/images/gray_back.png"));
    private ImageIcon card2 = new ImageIcon(Table.class.getResource("/images/gray_back.png"));
    private ImageIcon card3 = new ImageIcon(Table.class.getResource("/images/gray_back.png"));
    private ImageIcon card4 = new ImageIcon(Table.class.getResource("/images/gray_back.png"));
    private ImageIcon card5 = new ImageIcon(Table.class.getResource("/images/gray_back.png"));
    private ImageIcon background = new ImageIcon(Table.class.getResource("/images/poker-table-png-5.png"));

    /**
     * Overridden paintComponent method to paint all starting icons on label
     */
    @Override
    protected void paintComponent(Graphics g)
    {
	super.paintComponent(g);

	background.paintIcon(this, g, 0, 0);
	card1.paintIcon(this, g, 150, 125);
	card2.paintIcon(this, g, 225, 125);
	card3.paintIcon(this, g, 300, 125);
	card4.paintIcon(this, g, 375, 125);
	card5.paintIcon(this, g, 450, 125);
    }


    //generic getters and setters
    
    public ImageIcon getCard1()
    {
        return card1;
    }

    public void setCard1(ImageIcon card1)
    {
        this.card1 = card1;
        repaint();
    }

    public ImageIcon getCard2()
    {
        return card2;
    }

    public void setCard2(ImageIcon card2)
    {
        this.card2 = card2;
    }

    public ImageIcon getCard3()
    {
        return card3;
    }

    public void setCard3(ImageIcon card3)
    {
        this.card3 = card3;
    }

    public ImageIcon getCard4()
    {
        return card4;
    }

    public void setCard4(ImageIcon card4)
    {
        this.card4 = card4;
    }

    public ImageIcon getCard5()
    {
        return card5;
    }

    public void setCard5(ImageIcon card5)
    {
        this.card5 = card5;
    }



}
