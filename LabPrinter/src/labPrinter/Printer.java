package labPrinter;

public abstract class Printer
{

    private int serialNumber = 0;

    Printer(int number)
    {
	serialNumber = number;
    }

    public abstract void print();

    public int getSerialNumber()
    {
	return serialNumber;
    }

    @Override
    public String toString()
    {
	return getClass().getSimpleName() + " #" + getSerialNumber();
    }

}
