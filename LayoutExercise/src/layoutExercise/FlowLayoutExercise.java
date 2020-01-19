package layoutExercise;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class FlowLayoutExercise
{

    private JFrame frame;
    private final ButtonGroup btnLR = new ButtonGroup();

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
		    FlowLayoutExercise window = new FlowLayoutExercise();
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
    public FlowLayoutExercise()
    {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize()
    {
	frame = new JFrame();
	frame.setBounds(100, 100, 487, 195);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	
	JButton btnButton = new JButton("Button 1");
	frame.getContentPane().add(btnButton);
	
	JButton btnButton_1 = new JButton("Button 2");
	frame.getContentPane().add(btnButton_1);
	
	JButton btnButton_2 = new JButton("Button 3");
	frame.getContentPane().add(btnButton_2);
	
	JButton btnLongnamedButton = new JButton("Long-Named Button 4");
	frame.getContentPane().add(btnLongnamedButton);
	
	JButton button = new JButton("5");
	frame.getContentPane().add(button);
	
	JRadioButton rdbtnLeftToRight = new JRadioButton("Left to Right");
	btnLR.add(rdbtnLeftToRight);
	frame.getContentPane().add(rdbtnLeftToRight);
	
	JRadioButton rdbtnRightToLeft = new JRadioButton("Right to Left");
	btnLR.add(rdbtnRightToLeft);
	frame.getContentPane().add(rdbtnRightToLeft);
	
	JButton btnApplyOrientation = new JButton("Apply Orientation");
	frame.getContentPane().add(btnApplyOrientation);
    }

}
