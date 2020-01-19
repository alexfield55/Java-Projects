package labJUnit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyLabJUnitTest
{

    @Test
    public void testMultiply()
    {
	LabJUnit tester = new LabJUnit();

	assertEquals("Result", 90, tester.multiply(5, 10));
    }

}
