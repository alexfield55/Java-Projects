/*
 * Alex Field
 * Module 3 test
 * 10/25/2018
 * 
 */

package superman;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Superman
{

    /**
     * creates Jframe object
     */
    private JFrame frame;
    
    /**
     * Defines button group
     */
    private final ButtonGroup buttonGroup = new ButtonGroup();

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
		    Superman window = new Superman();
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
    public Superman()
    {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize()
    {
	createJframe();
	createTopLabel();
	JLabel lblImage = createImageLabel();
	JPanel panel = createBottomPanel();
	createColorRdBtn(lblImage, panel);
	createBwRdBtwn(lblImage, panel);
	createNegRdBtn(lblImage, panel);

    }

    /**
     * creates radio button to switch to negative picture when selected
     * @param lblImage
     * @param panel
     */
    private void createNegRdBtn(JLabel lblImage, JPanel panel)
    {
	JRadioButton rdbtnNeg = new JRadioButton("Neg");
	rdbtnNeg.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		lblImage.setIcon(new ImageIcon(Superman.class.getResource("/images/neg-superman.jpg")));
	    }
	});
	rdbtnNeg.setFocusable(false);
	rdbtnNeg.setBackground(Color.YELLOW);
	buttonGroup.add(rdbtnNeg);
	panel.add(rdbtnNeg);
    }

    /**
     * Creates radio button to switch to black and white image when selected
     * @param lblImage
     * @param panel
     */
    private void createBwRdBtwn(JLabel lblImage, JPanel panel)
    {
	JRadioButton rdbtnBw = new JRadioButton("B&W");
	rdbtnBw.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent arg0)
	    {
		lblImage.setIcon(new ImageIcon(Superman.class.getResource("/images/bw-superman.jpg")));
	    }
	});
	rdbtnBw.setFocusable(false);
	rdbtnBw.setBackground(Color.YELLOW);
	buttonGroup.add(rdbtnBw);
	panel.add(rdbtnBw);
    }

    /**
     * Creates radio button to switch to Color picture when selected
     * @param lblImage
     * @param panel
     */
    private void createColorRdBtn(JLabel lblImage, JPanel panel)
    {
	JRadioButton rdbtnColor = new JRadioButton("Color");
	rdbtnColor.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		lblImage.setIcon(new ImageIcon(Superman.class.getResource("/images/color-superman.jpg")));
	    }
	});
	rdbtnColor.setSelected(true);
	rdbtnColor.setFocusable(false);
	rdbtnColor.setBackground(Color.YELLOW);
	buttonGroup.add(rdbtnColor);
	panel.add(rdbtnColor);
    }

    /**
     * Creates a JPanel in the south to hold radio buttons
     * @return JPanel
     */
    private JPanel createBottomPanel()

    {
	JPanel panel = new JPanel();
	panel.setBackground(Color.YELLOW);
	frame.getContentPane().add(panel, BorderLayout.SOUTH);
	return panel;
    }
    
    /**
     * Creates JLabel to hold ImageIcon in center of the frame
     * @return JLabel
     */
    private JLabel createImageLabel()
    {
	JLabel lblImage = new JLabel("");
	lblImage.setHorizontalAlignment(SwingConstants.CENTER);
	lblImage.setIcon(new ImageIcon(Superman.class.getResource("/images/color-superman.jpg")));
	lblImage.setBackground(Color.YELLOW);
	frame.getContentPane().add(lblImage, BorderLayout.CENTER);
	return lblImage;
    }

    /**
     * creates top label thats says "Superman" on north border to JFrame
     */
    private void createTopLabel()
    {
	JLabel lblSuperman = new JLabel("Superman");
	lblSuperman.setBorder(new EmptyBorder(10, 0, 10, 0));
	lblSuperman.setHorizontalAlignment(SwingConstants.CENTER);
	lblSuperman.setForeground(Color.RED);
	lblSuperman.setOpaque(true);
	lblSuperman.setBackground(Color.BLUE);
	lblSuperman.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 30));
	frame.getContentPane().add(lblSuperman, BorderLayout.NORTH);
    }

    /**
     * creates JFrame to 500x500 size with yellow background
     */
    private void createJframe()
    {
	frame = new JFrame();
	frame.getContentPane().setBackground(Color.YELLOW);
	frame.setBounds(100, 100, 500, 500);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
