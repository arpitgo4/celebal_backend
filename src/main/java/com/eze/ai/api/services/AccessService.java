package com.eze.ai.api.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eze.ai.api.dao.ICalendarDAO;
import com.eze.ai.api.models.Access;
import com.eze.ai.api.models.EventCalendarData;
import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.auth.oauth2.ClientParametersAuthentication;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleOAuthConstants;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventAttendee;
import com.google.api.services.calendar.model.Events;

import javassist.compiler.ast.ASTList;
@Service
public class AccessService implements IAccessService{
	@Autowired
	ICalendarDAO iCalendarDAO;
	
	    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	    private static final String client_id="39831796327-41kcov9dbcjddbqbtvk54iootruoucoi.apps.googleusercontent.com";
	    private static final String client_secret="qv4NkhYvBfuua_AaOJObs9bS";
	    private static final String REFRESH_TOKEN="1/d3NA00o7TXxjAq5Ct-LY22nKjg_1YTaYycOiAfhwt47";
		private static final String EXPIRY_TIME_IN_MILLIS= "1498733487817";
		private static final String EXPIRY_TIME_IN_SECONDS="3543";
		private static final String APPLICATION_NAME="EZE";
		private static HttpTransport HTTP_TRANSPORT;
		private static final List<String> SCOPES =Arrays.asList(CalendarScopes.CALENDAR_READONLY);

		    static {
		        try {
		            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		        } catch (Throwable t) {
		            t.printStackTrace();
		            System.exit(1);
		        }
		    }

	@Override
	public void GoogleCalendarDetail(Access access) throws IOException {
		
		Credential.Builder builder = new Credential.Builder(BearerToken.authorizationHeaderAccessMethod());
		builder.setJsonFactory(JSON_FACTORY).setTransport(HTTP_TRANSPORT);
		ClientParametersAuthentication auth = new ClientParametersAuthentication(client_id,client_secret);
		builder.setRequestInitializer(auth);
		builder.setClientAuthentication(auth);
		builder.setTokenServerUrl(new GenericUrl(
				GoogleOAuthConstants.TOKEN_SERVER_URL));
		builder.setTokenServerEncodedUrl(GoogleOAuthConstants.TOKEN_SERVER_URL);
		
		Credential cr = builder.build();
		cr.setAccessToken(access.getAccessToken());
		//cr.setRefreshToken(REF_TOKEN);
		cr.setExpirationTimeMilliseconds(new Long(EXPIRY_TIME_IN_MILLIS));
		cr.setExpiresInSeconds(new Long(EXPIRY_TIME_IN_SECONDS));
	      
		com.google.api.services.calendar.Calendar service= new com.google.api.services.calendar.Calendar.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, cr)
                .setApplicationName(APPLICATION_NAME)
                .build();
		
		 DateTime now = new DateTime(System.currentTimeMillis());
	        Events events = service.events().list("primary")
	            .setTimeMin(now)
	            .setOrderBy("startTime")
	            .setSingleEvents(true)
	            .execute();
	        List<Event> items = events.getItems();
	   
	        System.out.println("item:"+ items.size());
	        if (items.size() == 0) {
	            System.out.println("No upcoming events found.");
	        } else {
	            System.out.println("Upcoming events");
	            for (Event event : items) {
	            	 EventCalendarData eventdata=new EventCalendarData();
	                DateTime start = event.getStart().getDateTime();
	                DateTime end=event.getEnd().getDateTime();
	                if (start == null && end==null) {
	                    start = event.getStart().getDate();
	                    end=event.getEnd().getDate();
	                }
	                String StartTime=start.toString();
	                String EndTime=end.toString();
	                eventdata.setStartTime(StartTime);
	                eventdata.setEventLocation(event.getLocation());
	                eventdata.setEventName(event.getSummary());
	                eventdata.setEndTime(EndTime);
	                eventdata.setEvntDescription(event.getDescription());
	                eventdata.setEventId(event.getId());
	               // eventdata.setAttendee(event.getAttendees().toArray(new String[event.getAttendees().size()]));
	                event.setAttendees(event.getAttendees());
	               // eventdata.setAttendee(event.getAttendees());
	                System.out.println(event.getDescription());
	               if(event.isAttendeesOmitted()){
	               for(EventAttendee attendees:event.getAttendees()){
	            	   eventdata.setAttendee(attendees.toString());
	                System.out.println("email: "+ attendees.getEmail());
	                System.out.println("status: "+attendees.getResponseStatus());
	                }
	               }
	               iCalendarDAO.AddCalendarDetails(eventdata);  
	            }
	        }
	        
	}

	@Override
	public void OutlookCalendarDetail(Access access) throws ClientProtocolException, IOException {
		HttpClient client = new DefaultHttpClient();
		  HttpGet request_url = new HttpGet("https://graph.microsoft.com/v1.0/me/events");
		  request_url.addHeader("Authorization","Bearer "+access.getAccessToken());
		  HttpResponse response = client.execute(request_url);
		  System.out.println("mohan pyare"+response);
		  BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
		  StringBuffer result=new StringBuffer();
		String line;
		while ((line = rd.readLine()) != null) {
			  result.append(line);
			  
  	}
		String data=result.toString();
		JSONParser parser=new JSONParser();
		JSONArray array=null;
		JSONObject obj=null;
		String[] attendeeArray;
		try{
			JSONObject jsonObj=(JSONObject)parser.parse(result.toString());
			JSONArray arr=(JSONArray)jsonObj.get("value");
			//System.out.println("Size="+arr.size());
			for(int i=0;i<arr.size();i++){
				EventCalendarData eventdata=new EventCalendarData();
				JSONObject jsonOb=(JSONObject)arr.get(i);
				String subject=(String)jsonOb.get("subject");
				String id=(String)jsonOb.get("id");
				String description=(String)jsonOb.get("bodyPreview");
				JSONArray attendeeArr=(JSONArray)jsonOb.get("attendees");
				attendeeArray=new String[attendeeArr.size()];
			//	System.out.println("attendeeArraySize="+attendeeArr.size());
				for(int j=0;j<attendeeArr.size();j++){
				JSONObject attendeeObj=(JSONObject)attendeeArr.get(j);
				JSONObject attendeeEmail=(JSONObject)attendeeObj.get("emailAddress");
				String emailId=(String)attendeeEmail.get("address");
				attendeeArray[j]=emailId;
				eventdata.setAttendee(emailId);
			
				}
				JSONObject locationobj=(JSONObject)jsonOb.get("location");
				String location=(String)locationobj.get("displayName");
				JSONObject addressOb=(JSONObject)locationobj.get("address");
				JSONObject startOb=(JSONObject)jsonOb.get("start");
		
				JSONObject endOb=(JSONObject)jsonOb.get("end");
				String startTime=(String)startOb.get("dateTime");
				String endTime=(String)endOb.get("dateTime");
				//String city=(String)addressOb.get("city");
				System.out.println("subject="+subject);
				System.out.println("location="+location);
				System.out.println("startTime="+startTime);
				System.out.println("endTime="+endTime);
				
				eventdata.setEventName(subject);
				eventdata.setEvntDescription(description);
				eventdata.setStartTime(startTime);
				eventdata.setEventLocation(location);
				eventdata.setEventId(id);
				eventdata.setEndTime(endTime);
				
			}
				 
			
		//	jsonObj.getJSONArray("attendees");
			//JSONArray arr=(JSONArray)obj.get("attendees");
			//System.out.println(arr.get());
		}catch(ParseException e){
			e.printStackTrace();
		}
	}

}
