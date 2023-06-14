package test.java.com.localised.localised;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by YGao on 4/13/2016.
 */
public class EntryTest {
    @Test
    public void testToString() throws Exception {
        Entry entry = new Entry("2013-07-10 02:52:49","-44.490947","171.220966");
        assertEquals("2013-07-10 02:52:49, -44.490947, 171.220966, Pacific/Auckland,2013-07-10T14:52:49",entry.toString());

        Entry entry1 = new Entry("2013-07-10 02:52:49","-33.912167","151.215820");
        assertEquals("2013-07-10 02:52:49, -33.912167, 151.215820, Australia/Sydney,2013-07-10T12:52:49",entry1.toString());
    }
}