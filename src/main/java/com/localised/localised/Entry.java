package main.java.com.localised.localised;

import java.text.ParseException;

public class Entry {
	private String orginalUTCDateString;

	public String getOrginalUTCDateString() {
		return orginalUTCDateString;
	}

	public void setOrginalUTCDateString(String orginalUTCDateString) {
		this.orginalUTCDateString = orginalUTCDateString;
	}

	private String latitude;
	private String longitude;

	private String timeZone;

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public Entry(String orginalUTCDateString, String latitude, String longitude) {
		this.orginalUTCDateString = orginalUTCDateString;
		this.latitude = latitude;
		this.longitude = longitude;
	}


	/**
	 * Two way to get time zone by latitude/longitude, webservice or local code.
	 */
	public String toString() {
		String utcTimeZoneString = TimeZoneLocalStoredMapper.latLngToTimezoneString(
				Double.parseDouble(latitude), Double.parseDouble(longitude));
		
		/*String utcTimeZoneString = "";
		try {
			utcTimeZoneString = (TimeZoneWebserviceUtility.getTimeZoneFromGeoPoint(
					Double.toString(latitude), Double.toString(longitude)).getID());
		} catch (IOException e1) {
			e1.printStackTrace();
		}*/
		
		String localTimeZoneString = "";
		try {
			localTimeZoneString = LocalisedUtility.utc2Local(
					orginalUTCDateString, utcTimeZoneString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return orginalUTCDateString + ", " + latitude + ", " + longitude + ", "
				+ utcTimeZoneString + "," + localTimeZoneString;
	}
}
