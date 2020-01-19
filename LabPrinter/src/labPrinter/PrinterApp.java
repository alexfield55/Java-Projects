package labPrinter;

import java.util.ArrayList;

public class PrinterApp
{

    public static void main(String[] args)
    {
	InkjetPrinter myIJ = new InkjetPrinter(1234567);
	System.out.println(myIJ.toString());
	System.out.println("Remaining Cartridge: " + myIJ.getRemainingCartridge());
	System.out.println();

	LaserPrinter myLP = new LaserPrinter(2345678);
	System.out.println(myIJ.toString());
	System.out.println("Remaining Toner: " + myLP.getRemainingToner());
	System.out.println();

	ArrayList<Printer> printers = new ArrayList<>();
	printers.add(myIJ);
	printers.add(myLP);

	System.out.println("List of Printers:");
	for (Printer el : printers)
	{
	    System.out.println(el.toString());
	    for (int i = 0; i < 11; i++)
	    {
		el.print();
		System.out.println();
	    }

	    System.out.println();
	}

    }

}
