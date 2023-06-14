package main.java.com.localised.localised;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class LocalisedUtility {

	/**
	 * Get TimeZone by time zone name
	 * @param _timeZone
	 * @return
	 */
	public static TimeZone getTimeZone(String _timeZone) {
		TimeZone timeZone = null;
		if (_timeZone == null) {
			timeZone = TimeZone.getDefault();
		} else {
			timeZone = TimeZone.getTimeZone(_timeZone);
		}
		return timeZone;
	}


	/**
	 * Tranfer UTC time to specified time zone
	 * @param gpsUTCDateString
	 * @param timeZoneString
	 * @return
	 * @throws ParseException
	 */
	public static String utc2Local(String gpsUTCDateString,String timeZoneString) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date parse = dateFormat.parse(gpsUTCDateString);

        DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        dateFormat2.setTimeZone(getTimeZone(timeZoneString));
        return dateFormat2.format(parse);
	}
}
