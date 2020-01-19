package labBuilding;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Building extends JPanel
{

    @Override
    protected void paintComponent(Graphics g)
    {
	super.paintComponent(g);
	Random r = new Random();

	//setting new color using Random
	g.setColor(new Color(255,r.nextInt(256),r.nextInt(256)));
	
	//sizing the rectangle (building)
	g.fillRect(100, 100, 225, 275);

	//setting new color
	g.setColor(new Color(r.nextInt(256),255,r.nextInt(256)));

	//loop for distributing windows onto building
	for (int j = 1; j <= 5; j++)
	{
	    for (int i = 1; i <= 4; i++)
	    {
		g.setColor(new Color(r.nextInt(256),255,r.nextInt(256)));
		g.fillRect(75 + (50 * i), 75 + (50 * j), 25, 25);

	    }
	}
    }

}
