package main.java.com.localised.localised;

import java.io.IOException;
import java.util.TimeZone;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 *  This is another way, using Webservice to locate a point with latitude and longitude
 *  But need being registered and get a key
 *
 */

public class TimeZoneWebserviceUtility {
	static  String TIME_ZONE_API = "http://api.timezonedb.com/?lat=%s&lng=%s&key=P0V9QHT4CWJ8";

    static TimeZone getTimeZoneFromGeoPoint(String lat, String lng) throws IOException {
        if(isEmpty(lat) || isEmpty(lng)){
            throw new IllegalArgumentException("emp");
        }

        try (CloseableHttpClient httpclient = HttpClients.createDefault()){
            HttpGet httpGet = new HttpGet(String.format(TIME_ZONE_API,lat,lng));
            try(CloseableHttpResponse response = httpclient.execute(httpGet)){
                StatusLine statusLine = response.getStatusLine();
                if(200 != statusLine.getStatusCode() ){
                    throw new RuntimeException("Cannot query the timezone");
                }

                HttpEntity entity = response.getEntity();
                if(null == entity) {
                    throw new RuntimeException("Cannot query the timezone");
                }
                String repString = EntityUtils.toString(entity);
                String timeZoneStr = repString.substring(repString.indexOf("zoneName>") + 9, repString.indexOf("</zoneName>"));
               return TimeZone.getTimeZone(timeZoneStr);
            }
        }

    }

    private static boolean isEmpty(String string) {
        return null == string || "".equals(string.trim());
    }
}
