/****************************************************************
 * These are the jUnit tests to test the class Gps.
 * Feel free to write your own jUnit tests in a separate class.
 * However, there tests here should NOT be modified. 
 * They need to be used unchanged for the submission.
 ****************************************************************/
package gps;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class GpsTest {
	private final double deltaDistance = 0.1; // deviations up to 100m are acceptable  
	
	private final GpsPosition slc = new GpsPosition(40.760671, -111.891122, 1299.8 );
	private final GpsPosition moab = new GpsPosition(38.573645, -109.546389, 1227.1);
	private final GpsPosition denver = new GpsPosition(39.7392541, -104.9847129, 1606.296);
	private final GpsPosition sf = new GpsPosition(37.808715, -122.409821, 5);
	
	private Gps gps;
	
	@Before
	public void setUp() throws Exception {
		gps = new Gps(slc);
	}

	@Test
	public void testGps() {
		Gps gpsSF = new Gps(sf);
		assertEquals(sf, gpsSF.position());	
		assertEquals(0d, gpsSF.distanceTraveled(), deltaDistance);
	}

	@Test
	public void testGetRoute() {
		ArrayList<GpsPosition> expectedRoute = new ArrayList<>();
		expectedRoute.add(slc);
		
		assertTrue(expectedRoute.equals(gps.getRoute()));
	}

	@Test
	public void testUpdate() {
		gps.update(moab);
		
		assertEquals(moab, gps.position());	
	}
	
	@Test
	public void testUpdateMultipleTimes() {
		gps.update(moab);
		gps.update(denver);
		gps.update(sf);
		
		assertEquals(sf, gps.position());	
	}

	@Test
	public void testRandomUpdate() {
		// update Salt Lake City 100 times and ensure that each time 
		// the updated position is within the required range
		for (int i = 0; i < 100; i++) {
			gps = new Gps(slc);
			gps.randomUpdate();
			GpsPosition newPosition = gps.position();
			
			assertTrue(newPosition.getLatitude() <= 41.260671 &&	
					newPosition.getLatitude() >= 40.2606711 &&	
					newPosition.getLongitude() <= -111.391122 &&	
					newPosition.getLongitude() >= -112.391122 &&	
					newPosition.getElevation() == 1299.8 );
		}
	}

	@Test
	public void testPosition() {
		assertEquals(slc, gps.position());
	}

	@Test
	public void testPositionAfterUpdate() {
		gps.update(denver);
		gps.update(sf);
		
		assertEquals(sf, gps.position());
	}
	
	@Test
	public void testDistanceTraveledNoTravel() {
		double expected = 0d; // no distance has been traveled yet
		assertEquals(expected, gps.distanceTraveled(), deltaDistance);
	}
		
	@Test
	public void testDistanceTraveledSlcToMoab() {
		gps.update(moab);
		
		double expected = 315.279;
		assertEquals(expected, gps.distanceTraveled(), deltaDistance);
	}
	
	@Test
	public void testDistanceTraveledMoabToDenver() {
		Gps gpsMoab = new Gps(moab);
		gpsMoab.update(denver);
		
		double expected = 414.0689;
		assertEquals(expected, gpsMoab.distanceTraveled(), deltaDistance);
	}
	
	@Test
	public void testDistanceTraveledSlcToDenver() {
		gps.update(moab);
		gps.update(denver);
		
		double expected = 729.348;
		assertEquals(expected, gps.distanceTraveled(), deltaDistance);
	}
	
	@Test
	public void testReset() {
		gps.reset();
		
		ArrayList<GpsPosition> expectedRoute = new ArrayList<>();
		expectedRoute.add(slc);
		assertTrue(expectedRoute.equals(gps.getRoute()));
	}

	@Test
	public void testResetAfterUpdate() {
		gps.update(sf);
		gps.update(denver);
		gps.reset();
		
		ArrayList<GpsPosition> expectedRoute = new ArrayList<>();
		expectedRoute.add(denver);		
		assertTrue(expectedRoute.equals(gps.getRoute()));
	}
}
