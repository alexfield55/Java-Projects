package labWrapperClassGUI;

public class DemoWrapperClass
{
    public String minMax()
    {

	return String.format(
		"Byte: %nMin: %d%nMax: %d%n%n" + "Short: %nMin: %d%nMax: %d%n%n" + "Integer: %nMin: %d%nMax: %d%n%n"
			+ "Long: %nMin: %d%nMax: %d%n%n",
		Byte.MIN_VALUE, Byte.MAX_VALUE, Short.MIN_VALUE, Short.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE,
		Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public String toBinary(int number)
    {
	return String.format("Binary: %s%nOctal : %s%nHex   : %s%n", Integer.toBinaryString(number),
		Integer.toOctalString(number), Integer.toHexString(number));

    }

    public String charProperties(char c)
    {
	String result;
	if (Character.isLetter(c))
	    if (Character.isUpperCase(c))
		result = c + "|" + Character.toLowerCase(c);
	    else
		result = c + "|" + Character.toUpperCase(c);
	else
	    result = "false";

	return String.format("White space: %s%nDigit: %s%nLetter: %s%n", Character.isWhitespace(c),
		Character.isDigit(c), result);
    }
}
