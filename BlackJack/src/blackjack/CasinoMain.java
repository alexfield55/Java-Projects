package blackjack;

import java.util.ArrayList;
import java.util.Scanner;

public class CasinoMain

{
    private ArrayList<Player> p = new ArrayList<Player>();

    public CasinoMain()
    {
        setPlayers();
    }

    private void setPlayers()
    {
        Scanner input = new Scanner(System.in);
        int numPlayers = 0;

        do{
        System.out.println("How many players would like to play this round?(Players 1-6)"); //set a max player amoount
            while (!input.hasNextInt())
            {
                System.out.println("Please enter a number between 1 and 6.");
                input.next();
            }
            numPlayers = input.nextInt();
            input.nextLine();
            System.out.println("");
            if(numPlayers>6||numPlayers<1)
                System.out.println("Please enter 1-6 players.");
        }while(numPlayers>6||numPlayers<1);
        
        for (int i = 0; i < numPlayers; i++)
        {
            String name;
            int wallet;

            System.out.printf("Player %d name?\n", i + 1);
            name = input.nextLine();
            System.out.println("");
            System.out.printf("%s starting amount? ", name);
            while (!input.hasNextInt()) {
                System.out.println("Please enter a number without decimals.");
                input.next();
            }
            wallet = input.nextInt();
            input.nextLine();
            System.out.println("");
            Player newPlayer = new Player(name, wallet);
            this.p.add(newPlayer);
            System.out.println("");
        }

        System.out.println("");

    }

    public static void main(String[] args)

    {
        CasinoMain c = new CasinoMain();
        
        System.out.println("Welcome to....\n");

        System.out.println(".------..------..------..------..------..------..------..------..------.        \n"
                         + "|B.--. ||L.--. ||A.--. ||C.--. ||K.--. ||J.--. ||A.--. ||C.--. ||K.--. | .-.    \n"
                         + "| :(): || :/\\: || (\\/) || :/\\: || :/\\: || :(): || (\\/) || :/\\: || :/\\: |((5))   \n"
                         + "| ()() || (__) || :\\/: || :\\/: || :\\/: || ()() || :\\/: || :\\/: || :\\/: | '-.-.  \n"
                         + "| '--'B|| '--'L|| '--'A|| '--'C|| '--'K|| '--'J|| '--'A|| '--'C|| '--'K|  ((1)) \n"
                         + "`------'`------'`------'`------'`------'`------'`------'`------'`------'   '-'  ");

        System.out.println("\n");
             Scanner input = new Scanner(System.in);
            String cont;
        do{
        BlackJack b = new BlackJack(c.p);
            System.out.println("Press y to continue press any other key to exit");
       
            cont = input.nextLine();
        }while(cont.equalsIgnoreCase("y"));

    }
}
