package dice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.EmptyBorder;

public class dice
{

    private JFrame frame;

    public static void main(String[] args)
    {
	EventQueue.invokeLater(new Runnable()
	{
	    public void run()
	    {
		try
		{
		    dice window = new dice();
		    window.frame.setVisible(true);
		} catch (Exception e)
		{
		    e.printStackTrace();
		}
	    }
	});
    }


    public dice()
    {
	initialize();
    }


    private void initialize()
    {
	frame = new JFrame();
	frame.setBounds(100, 100, 381, 389);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	JLabel label = new JLabel("");
	label.setHorizontalAlignment(SwingConstants.CENTER);
	frame.getContentPane().add(label, BorderLayout.CENTER);

	JButton btnRollem = new JButton("Roll 'em");
	btnRollem.setFocusable(false);
	btnRollem.setBorder(new EmptyBorder(20, 0, 20, 0));
	btnRollem.setBackground(Color.BLACK);
	btnRollem.setFont(new Font("Stencil", Font.PLAIN, 23));
	btnRollem.setForeground(Color.RED);
	btnRollem.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent arg0)
	    {
		Random rand = new Random();
		int num = 0;
		num = rand.nextInt(6) + 1;
		label.setIcon(new ImageIcon(dice.class.getResource("/images/die-" + num + ".png")));
	    }
	});
	frame.getContentPane().add(btnRollem, BorderLayout.SOUTH);
	
	

    }

}
