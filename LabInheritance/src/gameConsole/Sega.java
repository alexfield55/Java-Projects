package gameConsole;

public class Sega extends GameConsole
{
    private String gameName;

    Sega(String g, String n)
    {
	super(g);
	gameName = n;
    }
    
    @Override
    public String playStartUpMusic()
    {
       return "SSEEEEGGGGAAAAAA";
    }

    public String getGameName()
    {
        return gameName;
    }

    public void setGameName(String gameName)
    {
        this.gameName = gameName;
    }
    
    @Override
    public String toString()
    {
        return getClass().getSimpleName() + " is playing the " + super.getGameType() + " " + getGameName();
    }
}
