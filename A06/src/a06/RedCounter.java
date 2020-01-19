package a06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * AO6
 * GUI that has a button that starts blue and cycles randomly 
 * through 5 colors when clicked, never returning the same color twice
 * every time the button appears red it increments a counter on a JLabel
 * @author alexf
 *
 */
public class RedCounter
{

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
	EventQueue.invokeLater(new Runnable()
	{
	    public void run()
	    {
		try
		{
		    RedCounter window = new RedCounter();
		    window.frame.setVisible(true);
		} catch (Exception e)
		{
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the application.
     */
    public RedCounter()
    {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize()

    {
	createJFrame();
	ArrayList<Color> colors = createArrayOfColors();
	JLabel lblRedCounter = createRedCounter();
	JButton btnClickHere = createClickMeButton();
	createActionListener(colors, lblRedCounter, btnClickHere);
	createSouthLbl();
    }
    
    /**
     * Extracted method that creates JFrame to specific size of 500x200
     */
    private void createJFrame()
    {
	frame = new JFrame();
	frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 30));
	frame.setBounds(100, 100, 500, 200);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * creates ArrayList of constant color values
     * @return ArrayList
     */
    private ArrayList<Color> createArrayOfColors()
    {
	ArrayList<Color> colors = new ArrayList<>();
	colors.add(Color.BLUE);
	colors.add(Color.RED);
	colors.add(Color.GREEN);
	colors.add(Color.ORANGE);
	colors.add(Color.MAGENTA);
	return colors;
    }

    /**
     * Creates a JLabel that displays the count of the time the color red has
     * showed up on the corresponding button
     * @return
     */
    private JLabel createRedCounter()
    {
	JLabel lblRedCounter = new JLabel("Red Counter: 00");
	lblRedCounter.setBorder(new EmptyBorder(0, 20, 0, 20));
	lblRedCounter.setOpaque(true);
	lblRedCounter.setBackground(Color.GRAY);
	lblRedCounter.setHorizontalAlignment(SwingConstants.CENTER);
	lblRedCounter.setFont(new Font("Courier New", Font.PLAIN, 30));
	frame.getContentPane().add(lblRedCounter, BorderLayout.WEST);
	return lblRedCounter;
    }
    
    /**
     * Creates a JLabel that displays the amount of times the color red
     * has come up on the corresponding button
     * @return
     */
    private JButton createClickMeButton()
    {
	JButton btnClickHere = new JButton("Click Me");
	btnClickHere.setFocusable(false);
	btnClickHere.setFont(new Font("Courier New", Font.PLAIN, 30));
	btnClickHere.setForeground(Color.WHITE);
	btnClickHere.setBackground(Color.BLUE);
	frame.getContentPane().add(btnClickHere, BorderLayout.EAST);
	return btnClickHere;
    }

    /**
     * 
     * Creates a button that displays a new color every time its clicked, 
     * and never the same color twice
     */	
    private void createSouthLbl()
    {
	JLabel lblAlexsGui = new JLabel("Alex's GUI");
	lblAlexsGui.setBorder(new EmptyBorder(20, 0, 20, 0));
	lblAlexsGui.setHorizontalAlignment(SwingConstants.CENTER);
	lblAlexsGui.setFont(new Font("Courier New", Font.PLAIN, 20));
	frame.getContentPane().add(lblAlexsGui, BorderLayout.SOUTH);
    }

    /**
     * 
     * Action listener for JButton "click me"
     * Shuffles ArrayList of constant colors and returns a color
     * as long as its not the same as the previous color
     * 
     * @param colors
     * @param lblRedCounter
     * @param btnClickHere
     */
    private void createActionListener(ArrayList<Color> colors, JLabel lblRedCounter, JButton btnClickHere)
    {
	btnClickHere.addActionListener(new ActionListener()
	{
	    int reds = 1;

	    public void actionPerformed(ActionEvent arg0)
	    {

		while (btnClickHere.getBackground() == colors.get(0))
		{
		    Collections.shuffle(colors);
		}

		btnClickHere.setBackground(colors.get(0));

		if (colors.get(0) == Color.RED)
		{
		    lblRedCounter.setText(String.format("Red Counter: %02d", reds++));
		}

	    }
	});
    }

}
