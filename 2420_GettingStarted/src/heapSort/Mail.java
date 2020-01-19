package heapSort;

import edu.princeton.cs.algs4.Alphabet;
import edu.princeton.cs.algs4.StdRandom;

public class Mail implements Comparable<Mail>
{

    DeliveryType type;
    String mailCode = "";

    public Mail(DeliveryType type, String mailCode)
    {
	this.type = type;
	this.mailCode = mailCode;
    }

    public Mail()
    {
	this.type = randomType();
	this.mailCode = randomMailCode();
    }

    private String randomMailCode()
    {
	Alphabet alphabet = new Alphabet();
	String ret = "";
	for (int i = 0; i < 5; i++)
	{
	    ret += alphabet.UPPERCASE.toChar(StdRandom.uniform(0, 26));
	}
	return ret;
    }

    private DeliveryType randomType()
    {
	DeliveryType[] types =
	{ type.AIR, type.GROUND, type.ONE_DAY, type.PRIORITY, type.TWO_DAY };
	return types[StdRandom.uniform(0, 5)];
    }

    @Override
    public String toString()
    {
	return "{" + this.mailCode + "}({" + this.type + "})";
    }

    @Override
    public int compareTo(Mail that)
    {
	int ret = this.type.compareTo(that.type);
	if (ret != 0)
	    return ret;
	return this.mailCode.compareTo(that.mailCode);

    }

}
