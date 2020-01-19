package randomJokeGenerator;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Module Test 5
 * App that generates random jokes and serializes them and deserializes them from a file
 * @author alexf
 *
 */
public class JokeApp
{

    public static void main(String[] args)
    {
	List<Joke> jokes = new ArrayList<>();
	
	String filename = "Jokes-ALEX-FIELD.ser";
	
	Collections.addAll(jokes, new Joke('A', "Why did the programmer quit his job? Because he didn't get arrays.", JokeCategory.PROGRAMMING),
			new Joke('B', "There are 10 kinds of people in the world: those who know binary & those who don't", JokeCategory.CODE),
			new Joke('C', "Knock, Knock . . . \n\n . . . Who's there?'\n\n a super long pause . . .\n\nJava.", JokeCategory.JAVA),
			new Joke('D', "Whats the object oriented way to become wealthy? Inheritance!", JokeCategory.CODE),
			new Joke('E', "Hardware: The part of the computer that you can kick.", JokeCategory.DEFINITION),
			new Joke('F', "If Java is the answer, it must have been a super verbose question.", JokeCategory.DEFINITION),
			new Joke('G', "Java is user friendly. It’s just very picky about who its friends are.", JokeCategory.JAVA)
			);
			
		Joke randJoke1 = randomJoke(jokes);
		serialize(randJoke1, filename);
		Joke randJoke2 = deserialize(filename);
			
		System.out.println(randJoke2);
    }
    
    /**
     * Method that takes in a list of Joke objects and returns a random Joke from the list after shuffling the arrayList
     * @param j
     * @return Joke
     */
    public static Joke randomJoke(List<Joke> j)
    {
	Collections.shuffle(j);
	return j.get(0);
    }
    
    /**
     * Takes in a joke object and serializes it and writes it to a file specified by the String parameter file passed in
     * @param j
     * @param s
     */
    public static void serialize(Joke j, String s)
    {
	try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(s));)
	{
	    oos.writeObject(j);
	    System.out.println("Object was Serialized!");

	} 
	catch (IOException e)
	{

	    e.printStackTrace();

	}
    }
    
    /**
     * Deserialize Joke object from file specified by parameter passed in
     * @param s
     * @return Joke
     */
    private static Joke deserialize(String s)
    {
	Joke  j = null;
	
	try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(s));)
	{
	    	j = (Joke) ois.readObject();  
	    	System.out.println("Object was Deserialized!");
	} 
	catch (IOException | ClassNotFoundException e)
	{
	    e.printStackTrace();
	}
	return j;
    }

}
