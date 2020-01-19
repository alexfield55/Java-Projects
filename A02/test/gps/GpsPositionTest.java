/****************************************************************
 * These are the jUnit tests to test the class GpsPosition.
 * Feel free to write your own jUnit tests in a separate class.
 * However, there tests here should NOT be modified. 
 * They need to be used unchanged for the submission.
 ****************************************************************/
package gps;

import static org.junit.Assert.*;

import org.junit.Test;

public class GpsPositionTest {
	private final double delta = 0.000001; // specifies the required precision
	private final GpsPosition slc = new GpsPosition(40.760671, -111.891122, 1299.8 );

	@Test
	public void testGpsPosition() {
		GpsPosition moab = new GpsPosition(38.573645, -109.546389, 1227.1);
		assertEquals("38.573645, -109.546389 (1227.1)", moab.toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGpsPositionInvalidLatitude() {
		new GpsPosition(91, -104.9847132, 1606.296);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGpsPositionInvalidLongitude() {
		new GpsPosition(39.7392541, -180.01, 1606.296);
	}
	
	@Test
	public void testGetLatitude() {		
		assertEquals(40.760671, slc.getLatitude(), delta);
	}

	@Test
	public void testGetLongitude() {
		assertEquals(-111.891122, slc.getLongitude(), delta);
	}

	@Test
	public void testGetElevation() {
		assertEquals(1299.8, slc.getElevation(), delta);
	}

	@Test
	public void testToString() {
		assertEquals("40.760671, -111.891122 (1299.8)", slc.toString());
	}

	@Test
	public void testToStringRounding() {
		GpsPosition denver = new GpsPosition(39.7392541, -104.9847129, 1606.296);
		assertEquals("39.739254, -104.984713 (1606.3)", denver.toString());
	}
}
