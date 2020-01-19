package layoutExercise;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Exercise2
{

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;

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
		    Exercise2 window = new Exercise2();
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
    public Exercise2()
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
	frame.getContentPane().setLayout(new BorderLayout(0, 0));
	
	JPanel panel = new JPanel();
	frame.getContentPane().add(panel, BorderLayout.NORTH);
	panel.setLayout(new GridLayout(0, 2, 0, 0));
	
	JLabel lblNewLabel = new JLabel("New label");
	panel.add(lblNewLabel);
	
	textField = new JTextField();
	panel.add(textField);
	textField.setColumns(10);
	
	JLabel lblNewLabel_1 = new JLabel("New label");
	panel.add(lblNewLabel_1);
	
	textField_1 = new JTextField();
	panel.add(textField_1);
	textField_1.setColumns(10);
    }

}
