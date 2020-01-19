package poker;

/**
 * enum to assign different constants to each of the ranks of cards so that can be accessed for comparison data
 * @author alexf
 *
 */
public enum Rank
{
    ACE(1, 14, "A"), TWO(2, 2, "2"), THREE(3, 3, "3"), FOUR(4, 4, "4"), FIVE(5, 5, "5"), SIX(6, 6, "6"),
    SEVEN(7, 7, "7"), EIGHT(8, 8, "8"), NINE(9, 9, "9"), TEN(10, 10, "10"), JACK(11, 11, "J"), QUEEN(12, 12, "Q"),
    KING(13, 13, "K");

    private final int order;
    private final int value;
    private final String abb;

    Rank(int o, int v, String a)
    {
	order = o;
	value = v;
	abb = a;
    }

    public int order()
    {
	return order;
    }

    public int value()
    {
	return value;
    }

    public String abb()
    {
	return abb;
    }
}
