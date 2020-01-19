package lottery;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;

public class lotto
{

    private JFrame frame;
    private ArrayList<JLabel> lottoBalls;

    public static void main(String[] args)
    {
	EventQueue.invokeLater(new Runnable()
	{
	    public void run()
	    {
		try
		{
		    lotto window = new lotto();
		    window.frame.setVisible(true);
		} catch (Exception e)
		{
		    e.printStackTrace();
		}
	    }
	});
    }

    public lotto()
    {
	initialize();
    }

    private void initialize()
    {
	createWindow();
	createLottoBalls(7);
	JButton btnGenerateNumbers = createButton();
	createLabel();
	createActionListener(btnGenerateNumbers);
    }

    private void createActionListener(JButton btnGenerateNumbers)
    {
	btnGenerateNumbers.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent arg0)
	    {
		Random rand = new Random();
		int num = 0;
		for (JLabel el : lottoBalls)
		{
		    num = rand.nextInt(9) + 1;
		    el.setIcon(new ImageIcon(lotto.class.getResource("/images/lotto-" + num + ".png")));
		}
	    }
	});
    }

    private void createLabel()
    {
	JLabel lblLotteryNumberGame = new JLabel("Lottery Number Game");
	lblLotteryNumberGame.setBorder(new EmptyBorder(20, 0, 20, 0));
	lblLotteryNumberGame.setFocusable(false);
	lblLotteryNumberGame.setFont(new Font("Stencil", Font.PLAIN, 25));
	lblLotteryNumberGame.setForeground(Color.RED);
	lblLotteryNumberGame.setHorizontalAlignment(SwingConstants.CENTER);
	lblLotteryNumberGame.setOpaque(true);
	lblLotteryNumberGame.setBackground(Color.BLACK);
	frame.getContentPane().add(lblLotteryNumberGame, BorderLayout.NORTH);
    }

    private JButton createButton()
    {
	JButton btnGenerateNumbers = new JButton("Generate Numbers");

	btnGenerateNumbers.setBorder(new EmptyBorder(20, 0, 20, 0));
	btnGenerateNumbers.setFocusable(false);
	btnGenerateNumbers.setFont(new Font("Stencil", Font.BOLD, 25));
	btnGenerateNumbers.setForeground(Color.RED);
	btnGenerateNumbers.setBackground(Color.BLACK);
	frame.getContentPane().add(btnGenerateNumbers, BorderLayout.SOUTH);
	return btnGenerateNumbers;
    }

    private void createLottoBalls(int numOfBalls)
    {
	JPanel panelLottoBalls = new JPanel();
	frame.getContentPane().add(panelLottoBalls, BorderLayout.CENTER);

	lottoBalls = new ArrayList<>();
	for (int i = 0; i < numOfBalls; i++)
	{
	    lottoBalls.add(new JLabel(""));
	}
	for (JLabel el : lottoBalls)
	{
	    el.setIcon(new ImageIcon(lotto.class.getResource("/images/lotto-0.png")));
	    panelLottoBalls.add(el);
	}
    }

    private void createWindow()
    {
	frame = new JFrame();
	frame.setBounds(100, 100, 1200, 310);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
