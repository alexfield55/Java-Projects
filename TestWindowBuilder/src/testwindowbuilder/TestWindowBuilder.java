package testwindowbuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TestWindowBuilder extends JFrame
{

    private JPanel contentPane;
    private JTextField txtName;

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
		    TestWindowBuilder frame = new TestWindowBuilder();
		    frame.setVisible(true);
		} catch (Exception e)
		{
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    public TestWindowBuilder()
    {
    	setBackground(Color.BLACK);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(new BorderLayout(0, 0));
	setContentPane(contentPane);
	
	JButton west = new JButton("west");
	west.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		}
	});
	contentPane.add(west, BorderLayout.WEST);
	
	JPanel panel = new JPanel();
	contentPane.add(panel, BorderLayout.SOUTH);
	
	txtName = new JTextField();
	txtName.setFont(new Font("Tahoma", Font.PLAIN, 16));
	txtName.setText("Name:");
	panel.add(txtName);
	txtName.setColumns(10);
	
	JLabel lblMyFirstGui = new JLabel("My First GUI");
	lblMyFirstGui.setHorizontalAlignment(SwingConstants.CENTER);
	lblMyFirstGui.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblMyFirstGui.setForeground(Color.GREEN);
	lblMyFirstGui.setBackground(Color.BLUE);
	contentPane.add(lblMyFirstGui, BorderLayout.NORTH);
	
	JLabel lblHi = new JLabel("Hi");
	lblHi.setForeground(Color.ORANGE);
	lblHi.setFont(new Font("Tahoma", Font.PLAIN, 77));
	lblHi.setBackground(Color.RED);
	contentPane.add(lblHi, BorderLayout.CENTER);
    }

}
