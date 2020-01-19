package labGUILayoutManager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LabGUILayoutManager
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
		    LabGUILayoutManager window = new LabGUILayoutManager();
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
    public LabGUILayoutManager()
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

	JLabel lblDemoLayout = new JLabel("Demo Layout");
	lblDemoLayout.setBorder(new EmptyBorder(20, 0, 20, 0));
	lblDemoLayout.setHorizontalAlignment(SwingConstants.CENTER);
	lblDemoLayout.setFont(new Font("Tahoma", Font.PLAIN, 25));
	frame.getContentPane().add(lblDemoLayout, BorderLayout.NORTH);

	JPanel panel = new JPanel();
	frame.getContentPane().add(panel, BorderLayout.WEST);
	panel.setLayout(new GridLayout(0, 1, 0, 0));

	JButton shiftRight = new JButton("==>");
	shiftRight.setBorder(new EmptyBorder(20, 20, 20, 20));
	panel.add(shiftRight);

	JButton shiftLeft = new JButton("<==");
	panel.add(shiftLeft);

	JLabel label = new JLabel("");
	panel.add(label);

	JPanel panel_1 = new JPanel();
	frame.getContentPane().add(panel_1, BorderLayout.CENTER);
	panel_1.setLayout(new GridLayout(0, 4, 10, 10));

	JLabel lbl1 = new JLabel("1");
	lbl1.setFont(new Font("Tahoma", Font.BOLD, 30));
	lbl1.setForeground(Color.BLACK);
	lbl1.setOpaque(true);
	lbl1.setBackground(Color.YELLOW);
	lbl1.setHorizontalAlignment(SwingConstants.CENTER);
	panel_1.add(lbl1);

	JLabel lbl2 = new JLabel("2");
	lbl2.setFont(new Font("Tahoma", Font.BOLD, 30));
	lbl2.setForeground(Color.BLACK);
	lbl2.setOpaque(true);
	lbl2.setBackground(Color.BLUE);
	lbl2.setHorizontalAlignment(SwingConstants.CENTER);
	panel_1.add(lbl2);

	JLabel lbl3 = new JLabel("3");
	lbl3.setFont(new Font("Tahoma", Font.BOLD, 30));
	lbl3.setForeground(Color.BLACK);
	lbl3.setOpaque(true);
	lbl3.setBackground(Color.YELLOW);
	lbl3.setHorizontalAlignment(SwingConstants.CENTER);
	panel_1.add(lbl3);

	JLabel lbl4 = new JLabel("4");
	lbl4.setFont(new Font("Tahoma", Font.BOLD, 30));
	lbl4.setForeground(Color.BLACK);
	lbl4.setOpaque(true);
	lbl4.setBackground(Color.YELLOW);
	lbl4.setHorizontalAlignment(SwingConstants.CENTER);
	panel_1.add(lbl4);

	JLabel[] lbls =
	{ lbl1, lbl2, lbl3, lbl4 };

	shiftRight.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {

		for (int i = 0; i < 4; i++)
		{
		    if (lbls[i].getBackground() == Color.BLUE && i < 3)
		    {
			lbls[i].setBackground(Color.YELLOW);
			lbls[i + 1].setBackground(Color.BLUE);
			break;
		    } else if (i == 3)
		    {
			lbls[i].setBackground(Color.YELLOW);
			lbls[0].setBackground(Color.BLUE);
		    }

		}

	    }
	});

	shiftLeft.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {

		for (int i = 3; i >=0; i--)
		{
		    if (lbls[i].getBackground() == Color.BLUE && i > 0)
		    {
			lbls[i].setBackground(Color.YELLOW);
			lbls[i - 1].setBackground(Color.BLUE);
			break;
		    } else if (i == 0)
		    {
			lbls[i].setBackground(Color.YELLOW);
			lbls[3].setBackground(Color.BLUE);
		    }
		}
	    }
	});

    }

}
