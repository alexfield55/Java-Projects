package layoutExercise;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;

public class ChessBuilder
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
		    ChessBuilder window = new ChessBuilder();
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
    public ChessBuilder()
    {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize()
    {
	frame = new JFrame();
	frame.setBounds(100, 100, 500, 500);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(new GridLayout(0, 8, 0, 0));

	ArrayList<JLabel> squares = new ArrayList<>();

	int col = 0;
	int row = 0;

	for (int i = 0; i < 64; i++)
	{
	    squares.add(new JLabel());
	}

	for (JLabel el : squares)
	{
	    el.setOpaque(true);

	    if (row % 2 == 0)
	    {
		if (col % 2 == 0)
		    el.setBackground(Color.WHITE);
		else
		    el.setBackground(Color.BLACK);
	    }

	    else
	    {
		if (col % 2 == 0)
		    el.setBackground(Color.BLACK);
		else
		    el.setBackground(Color.WHITE);
	    }
	    
	    if (++col%8==0) row++;

	    frame.add(el);
	}

    }

}
