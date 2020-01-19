package layoutExercise;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;

public class GirdLayoutExercise
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
		    GirdLayoutExercise window = new GirdLayoutExercise();
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
    public GirdLayoutExercise()
    {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize()
    {
	frame = new JFrame();
	frame.setBounds(100, 100, 450, 300);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
	
	JButton btnFirst = new JButton("first");
	frame.getContentPane().add(btnFirst);
	
	JButton btnSecondWithA = new JButton("Second with a long name");
	frame.getContentPane().add(btnSecondWithA);
	
	JButton btnJimton = new JButton("jimton");
	frame.getContentPane().add(btnJimton);
	
	JButton btnThere = new JButton("there");
	frame.getContentPane().add(btnThere);
    }

}
