package gameConsole;

public class GameConsoleApp
{

    public static void main(String[] args)
    {
	GameConsole myConsole = new GameConsole("disc");
	System.out.println(myConsole.toString());
	System.out.println(myConsole.playStartUpMusic());
	System.out.println();
	
	Sega genesis = new Sega("cartridge", "Sonic");
	System.out.println(genesis.toString());
	System.out.println(genesis.playStartUpMusic());
    }

}
