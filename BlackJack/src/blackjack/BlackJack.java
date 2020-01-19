/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alexf
 */
public class BlackJack
{

    private Player dealer = new Player("Dealer", 0); //passing 0 for dealer wallet assuming he has unlimited money so its irrelevant
    private Deck d = new Deck();

    public BlackJack(ArrayList<Player> p)
    //purpose of constructor is to pass in ArrayList of players, 
    //create a "dealer" player, set everyones hands, and print the board
    {

        for (Player player : p)
        {
            int b = 0;
            Scanner input = new Scanner(System.in);

            do
            {
                System.out.printf("%s your wallet amount is %d, how much do you wish to bet? ", player.getName(), player.getWallet());
                while (!input.hasNextInt())
                {
                    System.out.println("You have to bet a number...!");
                    input.next();
                }
                b = input.nextInt();
                input.nextLine();
                if (b < 1 || b > player.getWallet())
                {
                    System.out.println("You must bet a postive amount and it must be less than your wallet.\n");
                }
            } while (b < 1 || b > player.getWallet());

            player.placeBet(b);

            System.out.println("");
        }
        dealer.setHands(new Hand());

        for (Player player : p)
        {
            player.setHands(new Hand());
        }

        for (int i = 0; i < 2; i++) //loop to deal two cards to each player/dealer in order
        {
            dealer.getHands().get(0).addToHand(d.draw());

            for (Player player : p)
            {
                player.getHands().get(0).addToHand(d.draw());
            }

        }

        printBoard(dealer, p);

        if (dealerBlackJackCheck(dealer))//checks for dealer blackjack and ends game right away if true
        {
            System.out.println(dealer.getHands().get(0).handToString());
            System.out.println("Dealer has BlackJack, Dealer Wins!");
        }
        else
        {

            for (Player player : p)
            {
                boolean again = false;
                do
                {
                    for (Hand h : player.getHands())
                    {
                        again = playerTurn(h, player);
                        if (again)
                        {
                            break;
                        }
                    }
                } while (again);
            }

            dealerTurn(dealer);
        }
        gameEnd(p);
    }

    public void printBoard(Player d, ArrayList<Player> p)
    {
        char block = '\u25ae';
        System.out.printf("%20s\n %16s%c \n\n", d.getName(), d.getHands().get(0).getHand().get(0).toString(), block);     //displays dealers first card while obscuring the second
        //loops for printing the board
        for (Player player : p)
        {
            System.out.printf("%-10s", player.getName());
        }
        System.out.println("");
        for (Player player : p)
        {
            System.out.printf("%-9s", player.getHands().get(0).handToString());
        }
        System.out.println("\n\n");

    }

    public Boolean dealerBlackJackCheck(Player d)
    {
        return d.getHands().get(0).getScore() == 21;
    }

    public void dealerTurn(Player d)
    {
        System.out.println("Dealer's turn, dealer shows:");
        System.out.println(dealer.getHands().get(0).handToString());

        int s = 0;
        s = d.getHands().get(0).getScore();

        if (s == 17 && (d.getHands().get(0).getHand().get(0).rank == Rank.ACE || d.getHands().get(0).getHand().get(1).rank == Rank.ACE))
        {
            System.out.println("Dealer hits soft 17: ");
            d.getHands().get(0).addToHand(this.d.draw());
            System.out.println(d.getHands().get(0).handToString());
        }

        while (s < 17)
        {
            System.out.printf("Dealer hits %d: ", dealer.getHands().get(0).getScore());
            d.getHands().get(0).addToHand(this.d.draw());
            s = d.getHands().get(0).getScore();
            System.out.println(d.getHands().get(0).handToString());

        }

        if (s > 21)
        {
            System.out.println("Dealer Busts!");
        }
        else
        {
            System.out.println("Dealer Stands at " + dealer.getHands().get(0).getScore());
        }
        System.out.println("");
    }

    public boolean playerTurn(Hand h, Player p) // need to figure out split betting
    {

        Scanner input = new Scanner(System.in);
        String choice;

        if (h.getScore() == 21)
        {
            System.out.println(p.getName() + " has BlackJack!");
            p.placeBet(2 * p.getBet()); //increases bet to payout double for hitting Black Jack
        }
        else
        {
            System.out.print(p.getName() + " your hand " + h.handToString() + " is " + h.scoreToString()+ " would you like to");

            if (h.getHand().get(0).rank.value() == h.getHand().get(1).rank.value())
            {
                System.out.print(" split(p),");
            }
            
            System.out.println(" hit(h), double down(d) or stand(s)?");
            
            choice = input.nextLine();

            while (!(choice.equalsIgnoreCase("h") || choice.equalsIgnoreCase("p") || choice.equalsIgnoreCase("s") || choice.equalsIgnoreCase("d")))
            {
                System.out.println("Please enter a valid option.");
                choice = input.nextLine();
            }

            if (choice.equalsIgnoreCase("p") && (h.getHand().get(0).rank.value() == h.getHand().get(1).rank.value())&&(2 * p.getBet()) < p.getWallet())
            {

                Hand h1 = new Hand();
                Hand h2 = new Hand();

                h1.addToHand(h.getHand().get(0));
                h1.addToHand(d.draw());
                p.setHands(h1);

                h2.addToHand(h.getHand().get(1));
                h2.addToHand(d.draw());
                p.setHands(h2);

                p.getHands().remove(0);

                System.out.printf("%s your hands are now: \n", p.getName());
                System.out.printf("%s      %s\n\n", p.getHands().get(0).handToString(), p.getHands().get(1).handToString());
                return true;

            }
            else if (choice.equalsIgnoreCase("p") && (h.getHand().get(0).rank.value() == h.getHand().get(1).rank.value())&& !((2 * p.getBet()) < p.getWallet())) //error checking for split
            {
                System.out.println("You do not have enough in your wallet to split this hand, please select hit(h) or stand(s)");

                choice = input.nextLine();

                while (!(choice.equalsIgnoreCase("h") || choice.equalsIgnoreCase("s")))
                {
                    System.out.println("Please enter a valid option.");
                    choice = input.nextLine();
                }

            }
            else if (choice.equalsIgnoreCase("p") && !(h.getHand().get(0).rank.value() == h.getHand().get(1).rank.value())) //error checking for split
            {
                System.out.println("You cannot split this hand! Please select double down(d), please select hit(h) or stand(s)");

                choice = input.nextLine();

                while (!(choice.equalsIgnoreCase("h") || choice.equalsIgnoreCase("s") || choice.equalsIgnoreCase("d")))
                {
                    System.out.println("Please enter a valid option.");
                    choice = input.nextLine();
                }

            }

            if (choice.equalsIgnoreCase("d") && (2 * p.getBet()) < p.getWallet()) //double down bet, for 1 card
            {
                h.addToHand(d.draw());
                System.out.println(h.handToString());
                p.placeBet(2 * p.getBet());
                if (h.getScore() <= 21)
                {
                    System.out.println(h.getScore() + "!");
                }

                else
                {
                    System.out.println("You Busted!");
                }
            }
            else if (choice.equalsIgnoreCase("d") && !((2 * p.getBet()) < p.getWallet())) // error checking for double down
            {
                System.out.println("You do not have enough in your wallet to double down, please select hit(h) or stand(s)");
                choice = input.nextLine();

                while (!(choice.equalsIgnoreCase("h") || choice.equalsIgnoreCase("s")))
                {
                    System.out.println("Please enter a valid option.");
                    choice = input.nextLine();
                }
            }

            while (choice.equalsIgnoreCase("h"))
            {

                if (choice.equalsIgnoreCase("h"))
                {
                    h.addToHand(d.draw());
                    System.out.println(h.handToString());

                }
                if (h.getScore() > 21)
                {
                    System.out.println("You have BUSTED!");
                    break;
                }

                System.out.println(p.getName() + " your hand " + h.handToString() + " is " + h.scoreToString() + " Would you like to hit(h) or stand(s)?");
                choice = input.nextLine();

                while (!(choice.equalsIgnoreCase("h") || choice.equalsIgnoreCase("s")))
                {
                    System.out.println("Please enter a valid option.");
                    choice = input.nextLine();
                }
            }

            System.out.println("");
        }
        return false;
    }

    public void gameEnd(ArrayList<Player> p)//needs to iterate through each players hand and compare it to dealers hand
    {

        for (Player player : p)
        {
            for (Hand h : player.getHands())
            {
                if (h.getScore() > 21)
                {
                    System.out.printf("%s busted and loss!\n\n", player.getName());
                    player.addToWallet(-player.getBet());

                }
                else if (dealer.getHands().get(0).getScore() > 21)
                {
                    System.out.printf("Dealer Busts, %s wins!\n\n", player.getName());
                    player.addToWallet(player.getBet());

                }
                else if (dealer.getHands().get(0).getScore() > h.getScore())
                {
                    System.out.printf("Dealer beats %s\n\n", player.getName());
                    player.addToWallet(-player.getBet());

                }
                else if (dealer.getHands().get(0).getScore() == h.getScore())
                {
                    System.out.printf("%s draws with Dealer, result is a draw!\n\n", player.getName());

                }
                else
                {
                    System.out.printf("%s wins!\n\n", player.getName());
                    player.addToWallet(player.getBet());
                }

                System.out.printf("%s has %d in thier wallet.\n\n", player.getName(), player.getWallet());

            }
            player.getHands().clear();
            player.placeBet(0);
        }

    }

}
