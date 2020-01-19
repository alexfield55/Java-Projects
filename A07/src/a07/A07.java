package a07;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.EmptyBorder;

/**
 * Creates GUI thats swaps through animal parts as well as barn colors depending on check boxes clicked/unclicked
 * @author alexf
 *
 */
public class A07
{

    private JFrame frame;
    private Picture picture;

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
		    A07 window = new A07();
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
    public A07()
    {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize()
    {

	createJFrame();
	JPanel panel = createJPanel();
	createLblChoose(panel);
	JCheckBox chckbxOption = createChckBxTail(panel);
	JCheckBox chckbxOption_1 = createChckBxBody(panel);
	JCheckBox chckbxOption_2 = createChckBxHead(panel);
	createPicturePanel();
	createBtn(panel, chckbxOption, chckbxOption_1, chckbxOption_2);
	createHeaderLbl();

    }

    /**
     * creates Labal at top of Frame
     */
    private void createHeaderLbl()
    {
	JLabel lblFarmAnimalGenerator = new JLabel("Farm Animal Generator");
	lblFarmAnimalGenerator.setBorder(new EmptyBorder(10, 0, 10, 0));
	lblFarmAnimalGenerator.setFont(new Font("Stencil", Font.PLAIN, 20));
	lblFarmAnimalGenerator.setHorizontalAlignment(SwingConstants.CENTER);
	frame.getContentPane().add(lblFarmAnimalGenerator, BorderLayout.NORTH);
    }

    /**
     * Creates a button that uses inputs from chckBx's to call methods from Picture class
     * also when no chckBx's are selected it rotates the background barn color
     * @param panel
     * @param chckbxOption
     * @param chckbxOption_1
     * @param chckbxOption_2
     */
    private void createBtn(JPanel panel, JCheckBox chckbxOption, JCheckBox chckbxOption_1, JCheckBox chckbxOption_2)
    {
	JButton btnClickHere = new JButton("Click Here");
	btnClickHere.setFont(new Font("Stencil", Font.PLAIN, 14));
	btnClickHere.setFocusable(false);
	btnClickHere.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent arg0)
	    {

		if (chckbxOption.isSelected())
		{
		    picture.swapTails();
		}
		if (chckbxOption_1.isSelected())
		{
		    picture.swapBody();
		}
		if (chckbxOption_2.isSelected())
		{
		    picture.swapHead();
		}
		if (!(chckbxOption.isSelected() || chckbxOption_2.isSelected() || chckbxOption_1.isSelected()))
		{
		    picture.swapBarn();
		}

	    }
	});
	panel.add(btnClickHere);
    }

    /**
     * Creates instance of Picture class which is an extended JPanel
     */
    private void createPicturePanel()
    {
	picture = new Picture();
	frame.getContentPane().add(picture, BorderLayout.CENTER);
    }

    /**
     * Creates and instance of a JCheckBox
     * @param panel
     * @return JCheckBox
     */
    private JCheckBox createChckBxHead(JPanel panel)
    {
	JCheckBox chckbxOption_2 = new JCheckBox("Swap Head");
	chckbxOption_2.setFont(new Font("Stencil", Font.PLAIN, 14));
	chckbxOption_2.setFocusable(false);
	panel.add(chckbxOption_2);
	return chckbxOption_2;
    }

    /**
     * Creates and instance of a JCheckBox
     * @param panel
     * @return JCheckBox
     */
    private JCheckBox createChckBxBody(JPanel panel)
    {
	JCheckBox chckbxOption_1 = new JCheckBox("Swap Body");
	chckbxOption_1.setFont(new Font("Stencil", Font.PLAIN, 14));
	chckbxOption_1.setFocusable(false);
	panel.add(chckbxOption_1);
	return chckbxOption_1;
    }

    /**
     * Creates and instance of a JCheckBox
     * @param panel
     * @return JCheckBox
     */
    private JCheckBox createChckBxTail(JPanel panel)
    {
	JCheckBox chckbxOption = new JCheckBox("Swap Tail");
	chckbxOption.setFont(new Font("Stencil", Font.PLAIN, 14));
	chckbxOption.setFocusable(false);
	panel.add(chckbxOption);
	return chckbxOption;
    }
    /**
     * creates a label above chckBx's to indicate that the user can choose one
     * @param panel
     */
    private void createLblChoose(JPanel panel)
    {
	JLabel lblChoose = new JLabel("choose:");
	lblChoose.setHorizontalAlignment(SwingConstants.CENTER);
	lblChoose.setFont(new Font("Stencil", Font.PLAIN, 14));
	lblChoose.setFocusable(false);
	panel.add(lblChoose);
    }

    /**
     *  Creates JPanel
     * @return JPanel
     */
    private JPanel createJPanel()
    {
	JPanel panel = new JPanel();
	frame.getContentPane().add(panel, BorderLayout.WEST);
	panel.setLayout(new GridLayout(0, 1, 0, 0));
	return panel;
    }

    /**
     * creates JFrame
     */
    private void createJFrame()
    {
	frame = new JFrame();
	frame.setBounds(100, 100, 720, 600);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
