package labPrinter;

public class InkjetPrinter extends Printer
{
    private int remainingCartridge= 0;

    InkjetPrinter(int sNumber)
    {
	super(sNumber);
	remainingCartridge = 100;
    }

    public int getRemainingCartridge()
    {
	return remainingCartridge;
    }

    public void setRemainingCartridge(int remainingCartridge)
    {
	this.remainingCartridge = remainingCartridge;
    }

    @Override
    public void print()
    {
	if (getRemainingCartridge() > 0)
	{
	    setRemainingCartridge(getRemainingCartridge() - 10);
	    System.out.println(
		    getClass().getSimpleName() + " is printing. Remainaing cartridge: " + getRemainingCartridge() + "%");
	}
	else System.out.println(getClass().getSimpleName() + " cartridge is empty!");
    }
}
