package circles;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Circle extends JPanel
{

    @Override
    protected void paintComponent(Graphics g)
    {
	super.paintComponent(g);

	g.setColor(Color.BLUE);
	for (int j = 1; j <= 5; j++)
	{
	    for (int i = 1; i <= 5; i++)
	    {
		g.drawOval(75 * i, 75*j, 100, 100);

	    }
	}
    }

}
