package samples;

public class SampleCode
{
    public static void main(String[] args)
    {

	Integer[] numbers =
	{ 3, 6, 9, 12 };

	printArray(numbers);
    }

    public static <T> void printArray(T[] numbers)
    {
	System.out.println("worked");
    }

}