package test.java.com.localised.localised;

import java.util.TimeZone;

import static org.junit.Assert.*;

/**
 * Created by YGao on 4/13/2016.
 */
public class LocalisedUtilityTest {

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void testGetTimeZone() throws Exception {
        TimeZone defaultZone = LocalisedUtility.getTimeZone(null);
        assertEquals("Pacific/Auckland",defaultZone.getID());

        TimeZone zone = LocalisedUtility.getTimeZone("GMT-8");
        assertEquals("GMT-08:00",zone.getID());
    }

    @org.junit.Test
    public void testUtc2Local() throws Exception {
        String localTime1 = LocalisedUtility.utc2Local("2016-04-13 09:02:00", null);
        assertEquals("2016-04-13T21:02:00",localTime1);
        String localTime2 = LocalisedUtility.utc2Local("2016-04-13 09:02:00", "GMT-8");
        assertEquals("2016-04-13T01:02:00",localTime2);
        String localTimeUTC= LocalisedUtility.utc2Local("2016-04-13 09:02:00", "UTC");
        assertEquals("2016-04-13T09:02:00",localTimeUTC);

    }
}