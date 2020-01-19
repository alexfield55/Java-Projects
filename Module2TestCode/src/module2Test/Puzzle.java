package module2Test;

/**
 * Class to create type Puzzle while implementing Solvable interface
 * @author alexf
 *
 */
public class Puzzle implements Solvable
{

    /**
     * Overridden solve interface that prints to console that it is solving 
     * a puzzle with the given classtype returned
     */
    @Override
    public void solve()
    {
	System.out.println("Sovling " + getClass().getSimpleName() + " puzzle");
	
    }

}
