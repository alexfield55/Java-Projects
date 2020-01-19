package swap;

public class Swap
{

    public static void main(String[] args)
    {
	Character[] charArray =
	{ 'A', 'E', 'I', 'O', 'U' };

	Double[] doubleArray =
	{ 1.1, 2.2, 3.3, 4.4 };

	swap(charArray, 0, 4);
	System.out.println();

	swap(doubleArray, 0, 3);
    }

    public static <T> void swap(T[] x, int index1, int index2)
    {
	for (T el : x)
	    System.out.print(el + " ");
	System.out.println();
	T temp = x[index1];
	x[index1] = x[index2];
	x[index2] = temp;
	for (T el : x)
	    System.out.print(el + " ");
	System.out.println();

    }

}
