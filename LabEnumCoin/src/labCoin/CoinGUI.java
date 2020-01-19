package labCoin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class CoinGUI extends JFrame
{

    private JPanel contentPane;

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
		    CoinGUI frame = new CoinGUI();
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
    public CoinGUI()
    {
	createJFrame();
	JPanel pnlCoins = createTopPanel();
	JLabel lblPenny = createPennyLabel(pnlCoins);
	JLabel lblNickel = createNickelLabel(pnlCoins);
	JLabel lblDime = createDimeLabel(pnlCoins);
	JLabel lblQuarter = createQuarterLabel(pnlCoins);
	JLabel lblKennedy = createKennedyLabel(pnlCoins);
	JLabel lblOutput = createOutputLabel();
	createActionListeners(lblPenny, lblNickel, lblDime, lblQuarter, lblKennedy, lblOutput);
    }

    private void createActionListeners(JLabel lblPenny, JLabel lblNickel, JLabel lblDime, JLabel lblQuarter,
	    JLabel lblKennedy, JLabel lblOutput)
    {
	lblPenny.addMouseListener(new MouseAdapter()
	{
	    @Override
	    public void mouseClicked(MouseEvent arg0)
	    {
		lblOutput.setText(Coin.PENNY.toString());
	    }
	});

	lblNickel.addMouseListener(new MouseAdapter()
	{
	    @Override
	    public void mouseClicked(MouseEvent arg0)
	    {
		lblOutput.setText(Coin.NICKEL.toString());
	    }
	});

	lblDime.addMouseListener(new MouseAdapter()
	{
	    @Override
	    public void mouseClicked(MouseEvent arg0)
	    {
		lblOutput.setText(Coin.DIME.toString());
	    }
	});

	lblQuarter.addMouseListener(new MouseAdapter()
	{
	    @Override
	    public void mouseClicked(MouseEvent arg0)
	    {
		lblOutput.setText(Coin.QUARTER.toString());
	    }
	});

	lblKennedy.addMouseListener(new MouseAdapter()
	{
	    @Override
	    public void mouseClicked(MouseEvent arg0)
	    {
		lblOutput.setText(Coin.KENNEDY.toString());
	    }
	});
    }

    private JLabel createOutputLabel()
    {
	JLabel lblOutput = new JLabel("");
	lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
	lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 30));
	contentPane.add(lblOutput, BorderLayout.CENTER);
	return lblOutput;
    }

    private JLabel createKennedyLabel(JPanel pnlCoins)
    {
	JLabel lblKennedy = new JLabel("");
	lblKennedy.setIcon(new ImageIcon(CoinGUI.class.getResource("/images/kennedy.png")));
	pnlCoins.add(lblKennedy);
	return lblKennedy;
    }

    private JLabel createQuarterLabel(JPanel pnlCoins)
    {
	JLabel lblQuarter = new JLabel("");
	lblQuarter.setIcon(new ImageIcon(CoinGUI.class.getResource("/images/UsQuarter.png")));
	pnlCoins.add(lblQuarter);
	return lblQuarter;
    }

    private JLabel createDimeLabel(JPanel pnlCoins)
    {
	JLabel lblDime = new JLabel("");
	lblDime.setIcon(new ImageIcon(CoinGUI.class.getResource("/images/UsDime.png")));
	pnlCoins.add(lblDime);
	return lblDime;
    }

    private JLabel createNickelLabel(JPanel pnlCoins)
    {
	JLabel lblNickel = new JLabel("");
	lblNickel.setIcon(new ImageIcon(CoinGUI.class.getResource("/images/UsNickel.png")));
	pnlCoins.add(lblNickel);
	return lblNickel;
    }

    private JLabel createPennyLabel(JPanel pnlCoins)
    {
	JLabel lblPenny = new JLabel("");
	lblPenny.setIcon(new ImageIcon(CoinGUI.class.getResource("/images/UsCent.png")));
	pnlCoins.add(lblPenny);
	return lblPenny;
    }

    private JPanel createTopPanel()
    {
	JPanel pnlCoins = new JPanel();
	contentPane.add(pnlCoins, BorderLayout.NORTH);
	return pnlCoins;
    }

    private void createJFrame()
    {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 588, 388);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(new BorderLayout(0, 0));
	setContentPane(contentPane);
    }

}
