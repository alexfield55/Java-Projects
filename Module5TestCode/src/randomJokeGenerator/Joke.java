package randomJokeGenerator;

import java.io.Serializable;

/**
 * Class that creates an object called Joke with a count, a String, and an emum
 * @author alexf
 *
 */
public class Joke implements Serializable
{

    private static final long serialVersionUID = -2124336338607841076L;
    char count;
    String joke;
    JokeCategory category;
    
    /**
     * takes in char, String, and enum JokeCatergory as params and creates a Joke object
     * @param c
     * @param j
     * @param d
     */
    public Joke (char c, String j, JokeCategory d)
    {
	this.count = c;
	this.joke = j;
	this.category = d;
    }

    /**
     * gets count
     * @return char
     */
    public char getCount()
    {
        return count;
    }
    
    
    /**
     * sets count
     * @param count
     */
    public void setCount(char count)
    {
        this.count = count;
    }

    /**
     * gets joke string
     * @return String
     */
    public String getJoke()
    {
        return joke;
    }

    /**
     * sets Joke
     */
    public void setJoke(String joke)
    {
        this.joke = joke;
    }

    /**
     * gets joke category enum
     * @return
     */
    public JokeCategory getCategory()
    {
        return category;
    }

    /**
     * sets joke category enum
     * @param category
     */
    public void setCategory(JokeCategory category)
    {
        this.category = category;
    }
    
    /**
     * overridden string method that returns formatted String
     */
    @Override
    public String toString()
    {
	return "Joke " + getCount() + ":\n"
		+ "Here's a " + getCategory() + " Joke:\n"
		+ getJoke();
	
    }
    
    
}
