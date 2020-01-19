package labCoin;

public class CoinApp
{

    public static void main(String[] args)
    {
	for (Coin c: Coin.values())
	{
	   System.out.println(c.toString());
	}
    }

}
