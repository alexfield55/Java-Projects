package labGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class introToGUI
{

    private JFrame frmMyFirstGui;
    private JTextField textField;

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
		    introToGUI window = new introToGUI();
		    window.frmMyFirstGui.setVisible(true);
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
    public introToGUI()
    {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize()
    {
	frmMyFirstGui = new JFrame();
	frmMyFirstGui.setTitle("My First GUI");
	frmMyFirstGui.setBounds(100, 100, 605, 636);
	frmMyFirstGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	JLabel lblMyFirstGui = new JLabel("My First GUI");
	lblMyFirstGui.setHorizontalAlignment(SwingConstants.CENTER);
	lblMyFirstGui.setFont(new Font("Tahoma", Font.PLAIN, 33));
	lblMyFirstGui.setForeground(Color.GREEN);
	lblMyFirstGui.setOpaque(true);
	lblMyFirstGui.setBackground(Color.BLUE);
	frmMyFirstGui.getContentPane().add(lblMyFirstGui, BorderLayout.NORTH);

	JLabel lblHi = new JLabel("Hi");
	lblHi.setHorizontalAlignment(SwingConstants.CENTER);
	lblHi.setForeground(Color.ORANGE);
	lblHi.setOpaque(true);
	lblHi.setFont(new Font("Papyrus", Font.BOLD, 77));
	lblHi.setBackground(Color.RED);
	frmMyFirstGui.getContentPane().add(lblHi, BorderLayout.CENTER);

	JButton btnWest = new JButton("WEST");
	btnWest.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent arg0)
	    {
		if (lblHi.getBackground() == Color.RED)
		{
		    lblHi.setForeground(Color.RED);
		    lblHi.setBackground(Color.ORANGE);
		} 
		else
		{
		    lblHi.setForeground(Color.ORANGE);
		    lblHi.setBackground(Color.RED);
		}

	    }
	});
	frmMyFirstGui.getContentPane().add(btnWest, BorderLayout.WEST);

	JPanel panel = new JPanel();
	panel.setBackground(Color.GRAY);
	frmMyFirstGui.getContentPane().add(panel, BorderLayout.SOUTH);

	JLabel lblName = new JLabel("Name:");
	lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
	panel.add(lblName);

	textField = new JTextField();
	textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
	panel.add(textField);
	textField.setColumns(30);
    }

}
