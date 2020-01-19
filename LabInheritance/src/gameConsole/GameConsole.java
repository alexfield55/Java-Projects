package gameConsole;

public class GameConsole
{
    /**
     * Asking for disc, digital download, etc
     */
    private String gameType;
 

    GameConsole(String g)
    {
	gameType = g;
    }

    public String getGameType()
    {
	return gameType;
    }
 
    public String playStartUpMusic()
    {
	return "Playing startup music";
    }
    
    
    @Override
    public String toString()
    {
	return getClass().getSimpleName() + " playing a " + gameType;
    }
    
    
}

