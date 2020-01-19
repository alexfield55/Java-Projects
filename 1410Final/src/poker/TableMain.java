package poker;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.JTextField;

/**
 * 1410 Final Assignment
 * @author alexf
 *
 */
public class TableMain extends JFrame
{

    private static final long serialVersionUID = -1028836553365326181L;
    private JPanel contentPane;
    private JLabel UserLabel;

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
		    TableMain frame = new TableMain();
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
    Stats stats = new Stats();
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JPanel header_1;
    Player user = new Player("p1");
    Player player1 = new Player("p2");
    Player player2 = new Player("p3");

    /**
     * creates the main frame for the simulator
     */
    public TableMain()
    {
	setFocusable(false);

	String filename = "playerInfo.ser";
	stats = deserialize(filename);

	createsFrame();
	JPanel header = createHeaderPnl();
	createNamesLbl();
	createTextFields(header);
	
	JButton btnSetPlayers = createSetPlayersBtn();
	
	//Player 1 GUI panels and labels
	JPanel Player1 = createPlayer1Pnl();
	JPanel Player1Cards = createPlayer1CardsPnl(Player1);
	JLabel p1card1 = createPlayer1FirstCard(Player1Cards);
	JLabel p1card2 = createPlayer1SecondCard(Player1Cards);
	JLabel player1NameLbl = createPlayer1NameLbl(Player1);

	//Player 2 GUI panels and labels
	JPanel Player2 = createPlayer2Pnl();
	JPanel Player2Cards = createPlayer2CardsPnl(Player2);
	JLabel p2card1 = createPlayer2FirstCard(Player2Cards);
	JLabel p2card2 = createPlayer2SecondCard(Player2Cards);
	JLabel player2NameLbl = createPlayer2NameLbl(Player2);

	//Player 3/ User GUI panels and labels
	JPanel User = createUserPnl();
	JPanel UserCards = createUserCardsPnl(User);
	JLabel userCard1 = createUserFirstCard(UserCards);
	JLabel userCard2 = createUserSecondCard(UserCards);
	createUserLbl(user, User);

	//create Table panel
	Table table = createTable();
	JPanel tablePnl = createTablePnl(table);
	JLabel outcome = createOutcomeLbl(tablePnl);

	//create Stats page
	JPanel statsPanel = new JPanel();
	JTextArea statsTxt = new JTextArea();
	statsPanel.add(statsTxt, BorderLayout.SOUTH);
	
	//action listeners
	createDealBtn(p2card1, p2card2, player2, header, p1card1, p1card2, player1, userCard1, userCard2, user, table,
		outcome);
	createResetBtn(filename, statsPanel, statsTxt);
	createBackBtn(statsPanel);
	createStatsBtn(filename, header, statsPanel, statsTxt);
	createSaveAndExitBtn(filename, header);
	createSetPlayersBtn(btnSetPlayers, player1NameLbl, player2NameLbl);

    }

    /**
     * Creates a second card label to display a card icon for the User/Player3
     * @param UserCards
     * @return
     */
    private JLabel createUserSecondCard(JPanel UserCards)
    {
	JLabel userCard2 = new JLabel("");
	UserCards.add(userCard2);
	userCard2.setIcon(new ImageIcon(TableMain.class.getResource("/images/gray_back.png")));
	return userCard2;
    }

    /**
     * Creates the first card label to display a card icon for the User/Player
     * @param UserCards
     * @return
     */
    private JLabel createUserFirstCard(JPanel UserCards)
    {
	JLabel userCard1 = new JLabel("");
	UserCards.add(userCard1);
	userCard1.setIcon(new ImageIcon(TableMain.class.getResource("/images/gray_back.png")));
	return userCard1;
    }

    /**
     * Creates panel to hold user/player3 card icons
     * @param User
     * @return
     */
    private JPanel createUserCardsPnl(JPanel User)

    {
	JPanel UserCards = new JPanel();
	UserCards.setBackground(Color.YELLOW);
	User.add(UserCards, BorderLayout.CENTER);
	return UserCards;
    }
    
    /**
     * creates User/Player 3 panel to hold name label and card panel
     * @return
     */
    private JPanel createUserPnl()
    {
	JPanel User = new JPanel();
	User.setBackground(Color.YELLOW);
	User.setFocusable(false);
	contentPane.add(User, BorderLayout.SOUTH);
	User.setLayout(new BorderLayout(0, 0));
	return User;
    }

    /**
     * Creates name label for player2
     * @param Player2
     * @return
     */
    private JLabel createPlayer2NameLbl(JPanel Player2)
    {
	JLabel player2NameLbl = new JLabel(player2.getName());
	player2NameLbl.setBackground(Color.YELLOW);
	player2NameLbl.setOpaque(true);
	player2NameLbl.setHorizontalAlignment(SwingConstants.CENTER);
	player2NameLbl.setBorder(new EmptyBorder(10, 10, 10, 10));
	player2NameLbl.setFont(new Font("Stencil", Font.PLAIN, 18));
	Player2.add(player2NameLbl, BorderLayout.NORTH);
	return player2NameLbl;
    }

    /**
     * creates the second card label to hold card icon for Player2
     * @param Player2Cards
     * @return
     */
    private JLabel createPlayer2SecondCard(JPanel Player2Cards)
    {
	JLabel p2card2 = new JLabel("");
	Player2Cards.add(p2card2);
	p2card2.setIcon(new ImageIcon(TableMain.class.getResource("/images/gray_back.png")));
	return p2card2;
    }

    /**
     * creates the first card label to hold card icon for Player2
     * @param Player2Cards
     * @return
     */
    private JLabel createPlayer2FirstCard(JPanel Player2Cards)
    {
	JLabel p2card1 = new JLabel("");
	Player2Cards.add(p2card1);
	p2card1.setIcon(new ImageIcon(TableMain.class.getResource("/images/gray_back.png")));
	return p2card1;
    }

    /**
     * Creates panel for player2 to hold card icons
     * @param Player2
     * @return
     */
    private JPanel createPlayer2CardsPnl(JPanel Player2)
    {
	JPanel Player2Cards = new JPanel();
	Player2Cards.setBackground(Color.YELLOW);
	Player2.add(Player2Cards, BorderLayout.CENTER);
	return Player2Cards;
    }

    /**
     * Create player2 panel to hold cards panel and name label
     * @return
     */
    private JPanel createPlayer2Pnl()
    {
	JPanel Player2 = new JPanel();
	Player2.setBackground(Color.YELLOW);
	Player2.setFocusable(false);
	contentPane.add(Player2, BorderLayout.EAST);
	Player2.setLayout(new BorderLayout(0, 0));
	return Player2;
    }

    /**
     * creates player1 name label
     * @param Player1
     * @return
     */
    private JLabel createPlayer1NameLbl(JPanel Player1)
    {
	JLabel player1NameLbl = new JLabel(player1.getName());
	player1NameLbl.setOpaque(true);
	player1NameLbl.setBackground(Color.YELLOW);
	player1NameLbl.setHorizontalAlignment(SwingConstants.CENTER);
	player1NameLbl.setBorder(new EmptyBorder(10, 10, 10, 10));
	player1NameLbl.setFont(new Font("Stencil", Font.PLAIN, 18));
	Player1.add(player1NameLbl, BorderLayout.NORTH);
	return player1NameLbl;
    }

    /**
     * creates the second card label for image icon for player1
     * @param Player1Cards
     * @return
     */
    private JLabel createPlayer1SecondCard(JPanel Player1Cards)
    {
	JLabel p1card2 = new JLabel("");
	Player1Cards.add(p1card2);
	p1card2.setHorizontalAlignment(SwingConstants.LEFT);
	p1card2.setIcon(new ImageIcon(TableMain.class.getResource("/images/gray_back.png")));
	return p1card2;
    }

    /**
     * creates the first card label image icon for player2
     * @param Player1Cards
     * @return
     */
    private JLabel createPlayer1FirstCard(JPanel Player1Cards)
    {
	JLabel p1card1 = new JLabel("");
	Player1Cards.add(p1card1);
	p1card1.setHorizontalAlignment(SwingConstants.LEFT);
	p1card1.setIcon(new ImageIcon(TableMain.class.getResource("/images/gray_back.png")));
	return p1card1;
    }

    /**
     * creates cards panel to hold two image icons for Player1
     * @param Player1
     * @return
     */
    private JPanel createPlayer1CardsPnl(JPanel Player1)
    {
	JPanel Player1Cards = new JPanel();
	Player1Cards.setBackground(Color.YELLOW);
	Player1.add(Player1Cards, BorderLayout.CENTER);
	return Player1Cards;
    }

    /**
     * creates panel to hold player1 information, lbls, pnls
     * @return
     */
    private JPanel createPlayer1Pnl()
    {
	JPanel Player1 = new JPanel();
	Player1.setFocusable(false);
	contentPane.add(Player1, BorderLayout.WEST);
	Player1.setLayout(new BorderLayout(0, 0));
	return Player1;
    }

    /**
     * makes a button that allows you to intiate player name changes
     * @return
     */
    private JButton createSetPlayersBtn()
    {
	JButton btnSetPlayers = new JButton("Set Players");
	btnSetPlayers.setFont(new Font("Stencil", Font.PLAIN, 20));
	header_1.add(btnSetPlayers);
	return btnSetPlayers;
    }

    /**
     * creates text fields to input names for players
     * @param header
     */
    private void createTextFields(JPanel header)
    {
	textField_1 = new JTextField();
	textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
	header.add(textField_1);
	textField_1.setColumns(10);

	textField_3 = new JTextField();
	textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
	header.add(textField_3);
	textField_3.setColumns(10);

	textField_2 = new JTextField();
	textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
	header.add(textField_2);
	textField_2.setColumns(10);
    }

    /**
     * creates a label to tell you what the text fields are for
     */
    private void createNamesLbl()
    {
	JLabel lblNames = new JLabel("Names:");
	lblNames.setHorizontalAlignment(SwingConstants.CENTER);
	lblNames.setFont(new Font("Stencil", Font.PLAIN, 20));
	header_1.add(lblNames);
    }

    /**
     * Action listener for set players button
     * @param btnSetPlayers
     * @param player1NameLbl
     * @param player2NameLbl
     */
    private void createSetPlayersBtn(JButton btnSetPlayers, JLabel player1NameLbl, JLabel player2NameLbl)
    {
	btnSetPlayers.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent arg0)
	    {
		player1.setName(textField_1.getText());
		player1NameLbl.setText(textField_1.getText());
		player2.setName(textField_2.getText());
		player2NameLbl.setText(textField_2.getText());
		user.setName(textField_3.getText());
		UserLabel.setText(textField_3.getText());
	    }
	});
    }

    /**
     * creates user/player3 lbl
     * @param user
     * @param User
     */
    private void createUserLbl(Player user, JPanel User)
    {
	UserLabel = new JLabel(user.getName());
	UserLabel.setOpaque(true);
	UserLabel.setBackground(Color.YELLOW);
	UserLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
	UserLabel.setHorizontalAlignment(SwingConstants.CENTER);
	UserLabel.setFont(new Font("Stencil", Font.PLAIN, 18));
	User.add(UserLabel, BorderLayout.NORTH);
    }

    /**
     * creates button to switch back from stats page to main table
     * @param statsPanel
     */
    private void createBackBtn(JPanel statsPanel)
    {
	JButton btnBack = new JButton("Back");
	statsPanel.add(btnBack, BorderLayout.NORTH);
	btnBack.setFocusable(false);
	btnBack.setBorder(new EmptyBorder(20, 20, 20, 20));
	btnBack.setFont(new Font("Stencil", Font.PLAIN, 25));
	btnBack.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		try
		{
		    TableMain frame = new TableMain();
		    frame.setVisible(true);
		} catch (Exception d)
		{
		    d.printStackTrace();
		}
	    }
	});
    }

    /**
     * creates button to reset stats by serializing data with new object of stats that is empty
     * @param filename
     * @param statsPanel
     * @param statsTxt
     */
    private void createResetBtn(String filename, JPanel statsPanel, JTextArea statsTxt)
    {
	JButton btnReset = new JButton("Reset Stats");
	btnReset.setFocusable(false);
	btnReset.setBorder(new EmptyBorder(20, 20, 20, 20));
	btnReset.setFont(new Font("Stencil", Font.PLAIN, 25));
	statsPanel.add(btnReset);

	btnReset.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		stats = new Stats();
		serialize(stats, filename);
		statsTxt.setText(stats.printStats());
		repaint();
	    }
	});
    }

    /**
     * creates Table with cards on it
     * @return
     */
    private Table createTable()
    {
	Table table = new Table();
	table.setBackground(Color.YELLOW);
	table.setFocusable(false);
	return table;
    }

    /**
     * creates panel to hold the poker table and outcome 
     * @param table
     * @return
     */
    private JPanel createTablePnl(Table table)
    {
	JPanel tablePnl = new JPanel();
	tablePnl.setBackground(Color.YELLOW);
	contentPane.add(tablePnl, BorderLayout.CENTER);
	tablePnl.setLayout(new BorderLayout(0, 0));
	tablePnl.add(table, BorderLayout.CENTER);
	return tablePnl;
    }

    /**
     * Creates a button that brings you to a page showing stats
     * @param filename
     * @param header
     * @param statsPanel
     * @param statsTxt
     */
    private void createStatsBtn(String filename, JPanel header, JPanel statsPanel, JTextArea statsTxt)
    {

	JButton btnStats = new JButton("Stats");
	btnStats.setFocusable(false);
	btnStats.setFont(new Font("Stencil", Font.PLAIN, 20));
	header.add(btnStats);
	btnStats.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		serialize(stats, filename);
		contentPane.removeAll();
		contentPane.add(statsPanel);
		statsTxt.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		statsTxt.setMargin(new Insets(25, 25, 25, 25));
		stats = deserialize("playerinfo.ser");
		statsTxt.setText(stats.printStats());
	    }
	});
    }

    /**
     * creates lbl that displays who won the hand
     * @param tablePnl
     * @return
     */
    private JLabel createOutcomeLbl(JPanel tablePnl)
    {
	JLabel outcome = new JLabel("");
	outcome.setOpaque(true);
	outcome.setBackground(Color.YELLOW);
	tablePnl.add(outcome, BorderLayout.SOUTH);
	outcome.setFocusable(false);
	outcome.setHorizontalAlignment(SwingConstants.CENTER);
	outcome.setBorder(new EmptyBorder(20, 20, 20, 20));
	outcome.setFont(new Font("Stencil", Font.PLAIN, 30));
	return outcome;
    }

    /**
     * creates a button that handles the dealing of a game
     * 
     * @param p2card1
     * @param p2card2
     * @param player2
     * @param header
     * @param p1card1
     * @param p1card2
     * @param player1
     * @param userCard1
     * @param userCard2
     * @param user
     * @param table
     * @param outcome
     */
    private void createDealBtn(JLabel p2card1, JLabel p2card2, Player player2, JPanel header, JLabel p1card1,
	    JLabel p1card2, Player player1, JLabel userCard1, JLabel userCard2, Player user, Table table,
	    JLabel outcome)
    {
	JButton deal = new JButton("deal");
	deal.setFocusable(false);
	deal.setBorder(new EmptyBorder(20, 20, 20, 20));
	deal.setFont(new Font("Stencil", Font.PLAIN, 20));
	header.add(deal);
	deal.addActionListener(new ActionListener()

	{
	    public void actionPerformed(ActionEvent arg0)
	    {
		Deck d = new Deck();

		Hand p1 = new Hand();
		p1.addToHand(d.draw(), d.draw());
		player1.setHand(p1);

		p1card1.setIcon(new ImageIcon(TableMain.class.getResource(
			"/images/" + p1.getHand().get(0).getRank().abb() + p1.getHand().get(0).getSuit() + ".png")));
		p1card2.setIcon(new ImageIcon(TableMain.class.getResource(
			"/images/" + p1.getHand().get(1).getRank().abb() + p1.getHand().get(1).getSuit() + ".png")));

		Hand p2 = new Hand();
		p2.addToHand(d.draw(), d.draw());
		player2.setHand(p2);

		p2card2.setIcon(new ImageIcon(TableMain.class.getResource(
			"/images/" + p2.getHand().get(0).getRank().abb() + p2.getHand().get(0).getSuit() + ".png")));
		p2card1.setIcon(new ImageIcon(TableMain.class.getResource(
			"/images/" + p2.getHand().get(1).getRank().abb() + p2.getHand().get(1).getSuit() + ".png")));

		Hand h3 = new Hand();
		h3.addToHand(d.draw(), d.draw());

		userCard1.setIcon(new ImageIcon(TableMain.class.getResource(
			"/images/" + h3.getHand().get(0).getRank().abb() + h3.getHand().get(0).getSuit() + ".png")));
		userCard2.setIcon(new ImageIcon(TableMain.class.getResource(
			"/images/" + h3.getHand().get(1).getRank().abb() + h3.getHand().get(1).getSuit() + ".png")));

		Hand tableCards = new Hand();
		tableCards.tableCards(d.draw(), d.draw(), d.draw(), d.draw(), d.draw());

		table.setCard1(new ImageIcon(
			TableMain.class.getResource("/images/" + tableCards.getHand().get(0).getRank().abb()
				+ tableCards.getHand().get(0).getSuit() + ".png")));
		table.setCard2(new ImageIcon(
			TableMain.class.getResource("/images/" + tableCards.getHand().get(1).getRank().abb()
				+ tableCards.getHand().get(1).getSuit() + ".png")));
		table.setCard3(new ImageIcon(
			TableMain.class.getResource("/images/" + tableCards.getHand().get(2).getRank().abb()
				+ tableCards.getHand().get(2).getSuit() + ".png")));
		table.setCard4(new ImageIcon(
			TableMain.class.getResource("/images/" + tableCards.getHand().get(3).getRank().abb()
				+ tableCards.getHand().get(3).getSuit() + ".png")));
		table.setCard5(new ImageIcon(
			TableMain.class.getResource("/images/" + tableCards.getHand().get(4).getRank().abb()
				+ tableCards.getHand().get(4).getSuit() + ".png")));

		Compare compare = new Compare();
		// System.out.println(player1.getName());
		player1.setHandStrength(compare.comparison(p1, tableCards));
		// System.out.println();

		// System.out.println(player2.getName());
		player2.setHandStrength(compare.comparison(p2, tableCards));
		// System.out.println();

		// System.out.println(user.getName());
		user.setHandStrength(compare.comparison(h3, tableCards));
		// System.out.println();

		if (user.getHandStrength() > player1.getHandStrength()
			&& user.getHandStrength() > player2.getHandStrength())
		{
		    // System.out.println("User wins with " +
		    // compare.nameOfHand(user.getHandStrength()));
		    outcome.setText(user.getName() + " wins with " + compare.nameOfHand(user.getHandStrength()));
		    stats.addWin(user.getHandStrength());
		}

		if (player1.getHandStrength() > user.getHandStrength()
			&& player1.getHandStrength() > player2.getHandStrength())
		{
//		    System.out
//			    .println(player1.getName() + " wins with " + compare.nameOfHand(player1.getHandStrength()));
		    outcome.setText(player1.getName() + " wins with " + compare.nameOfHand(player1.getHandStrength()));
		    stats.addWin(player1.getHandStrength());
		}

		if (player2.getHandStrength() > user.getHandStrength()
			&& player2.getHandStrength() > player1.getHandStrength())
		{
//		    System.out
//			    .println(player2.getName() + " wins with " + compare.nameOfHand(player2.getHandStrength()));
		    outcome.setText(player2.getName() + " wins with " + compare.nameOfHand(player2.getHandStrength()));
		    stats.addWin(player2.getHandStrength());
		}

		if (user.getHandStrength() == player1.getHandStrength()
			&& user.getHandStrength() > player2.getHandStrength())
		{
//		    System.out.println(user.getName() + " ties with " + player1.getName() + " with "
//			    + compare.nameOfHand(user.getHandStrength()));
		    outcome.setText(user.getName() + " ties with " + player1.getName() + " with "
			    + compare.nameOfHand(user.getHandStrength()));
		    stats.addWin(user.getHandStrength());
		}

		if (player1.getHandStrength() > user.getHandStrength()
			&& player1.getHandStrength() == player2.getHandStrength())
		{
		    // System.out.println(player2.getName() + " ties with " + player1.getName() + "
		    // with "
		    // + compare.nameOfHand(user.getHandStrength()));
		    outcome.setText(player2.getName() + " ties with " + player1.getName() + " with "
			    + compare.nameOfHand(user.getHandStrength()));
		    stats.addWin(player1.getHandStrength());
		}

		if (player2.getHandStrength() == user.getHandStrength()
			&& player2.getHandStrength() > player1.getHandStrength())
		{
		    // System.out.println(user.getName() + " ties with " + player2.getName() + "
		    // with "
		    // + compare.nameOfHand(user.getHandStrength()));
		    outcome.setText(user.getName() + " ties with " + player2.getName() + " with "
			    + compare.nameOfHand(user.getHandStrength()));
		    stats.addWin(player2.getHandStrength());
		}

		if (player2.getHandStrength() == user.getHandStrength()
			&& player2.getHandStrength() == player1.getHandStrength())
		{
		    // System.out.println("All players tie with " +
		    // compare.nameOfHand(user.getHandStrength()));
		    outcome.setText("All players tie with " + compare.nameOfHand(user.getHandStrength()));
		    stats.addWin(user.getHandStrength());
		}

		stats.gameCounter();
	    }

	});
    }

    /**
     * creates a button that saves the game by serializing the data to a file and exits the frame;
     * @param filename
     * @param header
     */
    private void createSaveAndExitBtn(String filename, JPanel header)
    {
	JButton btnSaveAndExit = new JButton("Save/Exit");
	btnSaveAndExit.setFocusable(false);
	btnSaveAndExit.setFont(new Font("Stencil", Font.PLAIN, 20));
	header.add(btnSaveAndExit);

	btnSaveAndExit.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent arg0)
	    {
		serialize(stats, filename);
		System.exit(0);
	    }
	});

    }

    /**
     * creates panel to store objects at top of the frame
     * @return
     */
    private JPanel createHeaderPnl()
    {
	header_1 = new JPanel();
	header_1.setFocusable(false);
	contentPane.add(header_1, BorderLayout.NORTH);
	header_1.setLayout(new GridLayout(0, 4, 0, 0));
	return header_1;
    }

    /**
     * creates the frame
     */
    private void createsFrame()

    {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 924, 699);
	contentPane = new JPanel();
	contentPane.setFocusable(false);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(new BorderLayout(0, 0));
	setContentPane(contentPane);
    }

    /**
     * static method to serialize data to a file
     * @param stats
     * @param filename
     */
    private static void serialize(Stats stats, String filename)
    {
	try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));)
	{
	    oos.writeObject(stats);
	    // System.out.println("Object was Serialized");

	} catch (IOException e)
	{

	    e.printStackTrace();

	}

    }

    /**
     * creates a method to read data from serialized file
     * @param filename
     * @return
     */
    private static Stats deserialize(String filename)
    {
	Stats s = null;

	try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));)
	{
	    s = (Stats) ois.readObject();
	} catch (IOException | ClassNotFoundException e)
	{
	    e.printStackTrace();
	}
	return s;
    }
}
