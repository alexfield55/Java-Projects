package labBalloon;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;

public class BalloonApp
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
		    BalloonApp window = new BalloonApp();
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
    public BalloonApp()
    {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize()
    {
	frame = new JFrame();
	frame.setBackground(Color.LIGHT_GRAY);
	frame.setBounds(100, 100, 653, 586);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	JLabel lblLabBalloon = new JLabel("Lab Balloon");
	lblLabBalloon.setBorder(new EmptyBorder(20, 0, 20, 0));
	lblLabBalloon.setHorizontalAlignment(SwingConstants.CENTER);
	lblLabBalloon.setFont(new Font("Stencil", Font.PLAIN, 20));
	frame.getContentPane().add(lblLabBalloon, BorderLayout.NORTH);

	JPanel panel = new JPanel();
	frame.getContentPane().add(panel, BorderLayout.SOUTH);

	JButton btnGenerateBallons = new JButton("Generate Balloons");
	
	panel.add(btnGenerateBallons);

	JLabel lblComparison = new JLabel("Comparison");
	panel.add(lblComparison);

	JPanel panel_1 = new JPanel();
	frame.getContentPane().add(panel_1, BorderLayout.CENTER);
	panel_1.setLayout(new GridLayout(0, 2, 5, 0));

	JLabel lblBalloon1 = new JLabel("Balloon1");
	lblBalloon1.setVerticalTextPosition(SwingConstants.BOTTOM);
	lblBalloon1.setHorizontalTextPosition(SwingConstants.CENTER);
	lblBalloon1.setHorizontalAlignment(SwingConstants.CENTER);
	lblBalloon1.setFont(new Font("Stencil", Font.BOLD, 30));
	lblBalloon1.setIcon(new ImageIcon(BalloonApp.class.getResource("/images/balloon100.jpg")));
	lblBalloon1.setOpaque(true);
	lblBalloon1.setBackground(Color.WHITE);
	panel_1.add(lblBalloon1);

	JLabel lblBalloon2 = new JLabel("Balloon2");
	lblBalloon2.setVerticalTextPosition(SwingConstants.BOTTOM);
	lblBalloon2.setHorizontalTextPosition(SwingConstants.CENTER);
	lblBalloon2.setHorizontalAlignment(SwingConstants.CENTER);
	lblBalloon2.setFont(new Font("Stencil", Font.BOLD, 30));
	lblBalloon2.setIcon(new ImageIcon(BalloonApp.class.getResource("/images/balloon100.jpg")));
	lblBalloon2.setOpaque(true);
	lblBalloon2.setBackground(Color.WHITE);
	panel_1.add(lblBalloon2);
	
	btnGenerateBallons.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent arg0)
	    {
		Random rand = new Random();
		
		boolean hel1 = rand.nextBoolean();
		boolean hel2 = rand.nextBoolean();
		
		int size1 = rand.nextInt(5);
		int size2 = rand.nextInt(5);
		
		String output = "";
		
		Balloon b1 = new Balloon(Size.values()[size1], hel1);
		Balloon b2 = new Balloon(Size.values()[size2], hel2);
		
		lblBalloon1.setIcon(b1.getIcon());
		lblBalloon2.setIcon(b2.getIcon());
		
		lblBalloon1.setText(b1.toString());
		lblBalloon2.setText(b2.toString());
		
		if(b1.equals(b2)) output = "Match!";
		else output = "No Match!";
		
		lblComparison.setText(output);
		
	    }
	});
    }

}
