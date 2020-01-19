package labPrinter;

public class LaserPrinter extends Printer
{

    private int remainingToner = 0;

    LaserPrinter(int sNumber)
    {
	super(sNumber);
	remainingToner = 100;
    }

    public int getRemainingToner()
    {
	return remainingToner;
    }

    public void setRemainingToner(int remainingToner)
    {
	this.remainingToner = remainingToner;
    }

    @Override
    public void print()
    {
	if (getRemainingToner() > 0)
	{
	    setRemainingToner(getRemainingToner() - 10);
	    System.out.println(
		    getClass().getSimpleName() + " is printing. Remainaing toner: " + getRemainingToner() + "%");
	}
	else System.out.println(getClass().getSimpleName() + " toner is empty!");
    }

}
