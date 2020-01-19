package a03;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;


class TestCodingBat
{
    @Test
    public void testZipZap1()
    {
	CodingBat tester = new CodingBat();
	assertEquals("zpXzp", tester.zipZap("zipXzap"));
    }
    
    @Test
    public void testZipZap2()
    {
	CodingBat tester = new CodingBat();
	assertEquals("zpzp", tester.zipZap("zopzop"));
    }
    
    @Test
    public void testZipZap3()
    {
	CodingBat tester = new CodingBat();
	assertEquals("zzzpzp", tester.zipZap("zzzopzop"));
    }
    
    @Test
    public void testZipZap4()
    {
	CodingBat tester = new CodingBat();
	assertEquals("zibzp", tester.zipZap("zibzap"));
    }
    
    @Test
    public void testZipZap5()
    {
	CodingBat tester = new CodingBat();
	assertEquals("zp", tester.zipZap("zip"));
    }
    
    @Test
    public void testZipZap6()
    {
	CodingBat tester = new CodingBat();
	assertEquals("z", tester.zipZap("z"));
    }
    
    @Test
    public void testZipZap7()
    {
	CodingBat tester = new CodingBat();
	assertEquals("", tester.zipZap(""));
    }
    
    @Test
    public void testZipZap8()
    {
	CodingBat tester = new CodingBat();
	assertEquals("zp", tester.zipZap("zzp"));
    }
    
    @Test
    public void testZipZap9()
    {
	CodingBat tester = new CodingBat();
	assertEquals("abcppp", tester.zipZap("abcppp"));
    }
    
    @Test
    public void testZipZap10()
    {
	CodingBat tester = new CodingBat();
	assertEquals("zpxzp", tester.zipZap("zipxzop"));
    }
    
    @Test
    public void testZipZap11()
    {
	CodingBat tester = new CodingBat();
	assertEquals("azbcppp", tester.zipZap("azbcppp"));
    }
    
    @Test
    public void testZipZap12()
    {
	CodingBat tester = new CodingBat();
	assertEquals("azbcpzp", tester.zipZap("azbcpzpp"));
    }
    
    
    
}