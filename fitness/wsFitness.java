package fitness;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class wsFitness {
	
	public static void main(String[] args) {

		try {

			/*URL url = new URL(
					"http://localhost:8080/RESTfulExample/json/product/get");*/
			URL url = new URL(
					"https://api.validic.com/v1/organizations/59a5b22eff9d93000c000169/fitness/latest.json?access_token=8a6e4f00721aac1b37d57aa899d85b98fc7ad1b390c21578138c2daccd9fcc13&start_date=2017-09-01T08:44:29Z&end_date=2017-09-03T08:54:27Z&limit=3");
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
			System.out.println("Output from Server .... \n");
			/*
			while ((output = br.readLine()) != null) {

				System.out.println(output);
				output1=output1+output;
				
			}
			*/
			
			//System.out.println(output1);
			
			JSONParser parser = new JSONParser();
			Object obj = null;
			try {
				obj = parser.parse(br);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			JSONObject jsonObject = (JSONObject) obj;
			System.out.println(jsonObject);
		
			//JSONArray msg1 = (JSONArray) jsonObject.get("summary");
			
		//	JSONArray msg1 = (JSONArray) jsonObject.get("summary");
		
			
		//	Iterator iterator1 = msg1.iterator();
			
	/*		
while (iterator1.hasNext()) {
            	
            	try {
					obj = parser.parse(iterator1.next().toString());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	JSONObject jsonObject1 = (JSONObject) obj;
    
            	System.out.println(jsonObject1.get("status"));
            
            }
			
			*/
			
			System.out.println(" ");
			
			
			
			
			
			
			JSONArray msg = (JSONArray) jsonObject.get("fitness");
			
			System.out.println(msg);
			
			
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
    
            	System.out.println(jsonObject1.get("calories"));
            	System.out.println(jsonObject1.get("activity_category"));
            	System.out.println(jsonObject1.get("last_updated"));
            }
			
			
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
			
		}

	}

}
