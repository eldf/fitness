package fitness;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class wsfit {
	
	public List<fitness> procesar(String limite, String startdate, String enddate) {
		List<fitness> result = new LinkedList<fitness>();
		
		try {

			URL url = new URL(
					"https://api.validic.com/v1/organizations/59a5b22eff9d93000c000169/fitness/latest.json?access_token=8a6e4f00721aac1b37d57aa899d85b98fc7ad1b390c21578138c2daccd9fcc13&start_date="+startdate+"&end_date="+enddate+"&limit="+limite+"");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			
			

			String output;
			String output1="";

			
			
			
			
			JSONParser parser = new JSONParser();
			Object obj = null;
			try {
				obj = parser.parse(br);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			JSONObject jsonObject = (JSONObject) obj;

		
			
			
			
			
			
			JSONArray msg = (JSONArray) jsonObject.get("fitness");
			

			
			
            Iterator iterator = msg.iterator();
            while (iterator.hasNext()) {
            	
            	try {
					obj = parser.parse(iterator.next().toString());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	JSONObject jsonObject1 = (JSONObject) obj;
            	
            	System.out.println(jsonObject1.get("utc_offset"));
            	System.out.println(jsonObject1.get("last_updated"));
            	System.out.println(jsonObject1.get("start_time"));
            	System.out.println(jsonObject1.get("start_time"));
            	System.out.println(jsonObject1.get("last_updated"));
    
            	System.out.println(jsonObject1.get("calories"));
            	System.out.println(jsonObject1.get("activity_category"));
            	System.out.println(jsonObject1.get("last_updated"));
            	System.out.println(jsonObject1.get("distance"));
            	fitness fit = new fitness();
            	fit.setLast_updated((String)jsonObject1.get("last_updated"));
            	fit.setStart_time((String)jsonObject1.get("start_time"));
            	fit.setCalories((Double)jsonObject1.get("calories"));
            	fit.setActivity_category((String)jsonObject1.get("activity_category"));
            	fit.setDistance((Double)jsonObject1.get("distance"));
            	result.add(fit);
            }
			
            System.out.println( result.size());
           
			
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
			
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		List<fitness> result = new LinkedList<fitness>();
		wsfit ws = new wsfit();
		result=ws.procesar("3","2017-09-01T08:44:29Z","2017-09-03T08:54:27Z");
	}

}
