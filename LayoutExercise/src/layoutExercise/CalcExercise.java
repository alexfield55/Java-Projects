package layoutExercise;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class CalcExercise
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
		    CalcExercise window = new CalcExercise();
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
    public CalcExercise()
    {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize()
    {
	frame = new JFrame();
	frame.setBounds(100, 100, 435, 497);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	JLabel lblNewLabel = new JLabel("");
	lblNewLabel.setOpaque(true);
	lblNewLabel.setBorder(new EmptyBorder(35, 0, 35, 0));
	lblNewLabel.setBackground(Color.WHITE);
	frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
	
	JPanel panel = new JPanel();
	frame.getContentPane().add(panel, BorderLayout.CENTER);
	panel.setLayout(new GridLayout(0, 4, 0, 0));
	
	JButton btnNewButton = new JButton("7");
	btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
	panel.add(btnNewButton);
	
	JButton btnNewButton_1 = new JButton("8");
	btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
	panel.add(btnNewButton_1);
	
	JButton btnNewButton_2 = new JButton("9");
	btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
	panel.add(btnNewButton_2);
	
	JButton btnNewButton_3 = new JButton("=\r\n");
	btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
	panel.add(btnNewButton_3);
	
	JButton btnNewButton_4 = new JButton("6");
	btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
	panel.add(btnNewButton_4);
	
	JButton btnNewButton_7 = new JButton("5");
	btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
	panel.add(btnNewButton_7);
	
	JButton btnNewButton_5 = new JButton("4");
	btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
	panel.add(btnNewButton_5);
	
	JButton btnNewButton_6 = new JButton("New button");
	btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
	panel.add(btnNewButton_6);
	
	JButton button = new JButton("3");
	button.setFont(new Font("Tahoma", Font.PLAIN, 20));
	panel.add(button);
	
	JButton btnNewButton_11 = new JButton("2");
	btnNewButton_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
	panel.add(btnNewButton_11);
	
	JButton btnNewButton_8 = new JButton("1");
	btnNewButton_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
	panel.add(btnNewButton_8);
	
	JButton btnNewButton_9 = new JButton("New button");
	btnNewButton_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
	panel.add(btnNewButton_9);
	
	JButton btnNewButton_10 = new JButton("0");
	btnNewButton_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
	panel.add(btnNewButton_10);
	
	JButton btnNewButton_12 = new JButton(".");
	btnNewButton_12.setFont(new Font("Tahoma", Font.PLAIN, 20));
	panel.add(btnNewButton_12);
	
	JButton btnNewButton_13 = new JButton("/");
	btnNewButton_13.setFont(new Font("Tahoma", Font.PLAIN, 20));
	panel.add(btnNewButton_13);
	
	JButton btnNewButton_14 = new JButton("New button");
	btnNewButton_14.setFont(new Font("Tahoma", Font.PLAIN, 20));
	panel.add(btnNewButton_14);
    }

}
