package com.controller.spreadsheet;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.email.EmailData;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.BatchUpdateSpreadsheetRequest;
import com.google.api.services.sheets.v4.model.CellData;
import com.google.api.services.sheets.v4.model.ExtendedValue;
import com.google.api.services.sheets.v4.model.GridCoordinate;
import com.google.api.services.sheets.v4.model.Request;
import com.google.api.services.sheets.v4.model.RowData;
import com.google.api.services.sheets.v4.model.SheetProperties;
import com.google.api.services.sheets.v4.model.UpdateCellsRequest;
import com.google.api.services.sheets.v4.model.UpdateSheetPropertiesRequest;
import com.pojo.StudentInfo;

public class SheetsQuickstart {
	/** Application name. */
	private static final String APPLICATION_NAME =
			"Google Sheets API Java Quickstart";

	/** Directory to store user credentials for this application. */
	private static final java.io.File DATA_STORE_DIR = new java.io.File(
			System.getProperty("user.home"), ".credentials//sheets.googleapis.com-java-quickstart.json");

	/** Global instance of the {@link FileDataStoreFactory}. */
	private static FileDataStoreFactory DATA_STORE_FACTORY;

	/** Global instance of the JSON factory. */
	private static final JsonFactory JSON_FACTORY =
			JacksonFactory.getDefaultInstance();

	/** Global instance of the HTTP transport. */
	private static HttpTransport HTTP_TRANSPORT;

	/** Global instance of the scopes required by this quickstart.
	 *
	 * If modifying these scopes, delete your previously saved credentials
	 * at ~/.credentials/sheets.googleapis.com-java-quickstart.json
	 */
	private static final List<String> SCOPES =
			Arrays.asList( SheetsScopes.SPREADSHEETS );

	public SheetsQuickstart(){
		try {
			HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
			DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
		} catch (Throwable t) {
			t.printStackTrace();
			System.exit(1);
		}
	}

	static {
		try {
			HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
			DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
		} catch (Throwable t) {
			t.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * Creates an authorized Credential object.
	 * @return an authorized Credential object.
	 * @throws IOException
	 */
	public static Credential authorize() throws IOException {
		// Load client secrets.
		// InputStream in = new FileInputStream("C:\\Users\\doan\\Documents\\testing\\src\\main\\resources\\client_secret.json");
		InputStream in =
				SheetsQuickstart_g.class.getResourceAsStream("client_secret.json");
		// SheetsQuickstart.class.getResourceAsStream("/client_secret.json");
		GoogleClientSecrets clientSecrets =
				GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

		// Build flow and trigger user authorization request.
		GoogleAuthorizationCodeFlow flow =
				new GoogleAuthorizationCodeFlow.Builder(
						HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
				.setDataStoreFactory(DATA_STORE_FACTORY)
				.setAccessType("offline")
				.build();
		Credential credential = new AuthorizationCodeInstalledApp(
				flow, new LocalServerReceiver()).authorize("user");
		System.out.println(
				"Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
		return credential;
	}

	/**
	 * Build and return an authorized Sheets API client service.
	 * @return an authorized Sheets API client service
	 * @throws IOException
	 */
	public static Sheets getSheetsService() throws IOException {
		Credential credential = authorize();
		return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
				.setApplicationName(APPLICATION_NAME)
				.build();
	}

	/*public static void main(String[] args) throws IOException {
        // Build a new authorized API client service.
        Sheets service = getSheetsService();

        // Prints the names and majors of students in a sample spreadsheet:
        // https://docs.google.com/spreadsheets/d/1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms/edit
        String spreadsheetId = "1x5zVGM_r6uwY3UUa9HFo2Ew2PJxft9r4DTe0hCt1DP0";

        List<Request> requests = new ArrayList<>();

        HashMap datePointer=new HashMap();

       // Change the name of sheet ID '0' (the default first sheet on every
       // spreadsheet)
       requests.add(new Request()
             .setUpdateSheetProperties(new UpdateSheetPropertiesRequest()
                     .setProperties(new SheetProperties()
                             .setSheetId(1804025843)
                             .setTitle("Student Attendance"))
                     .setFields("title")));

       SheetsQuickstart_g spreadsheet=new SheetsQuickstart_g();
       List<List<Object>> valuesFetch = spreadsheet.fetchData();

       int i=1;
       if (valuesFetch == null || valuesFetch.size() == 0) {
			System.out.println("No data found.");
		} else {
			System.out.println("Name, Student Id");
			for (List row : valuesFetch) {
				// Print columns A and E, which correspond to indices 0 and 4.
				hash.put(row.get(3).toString(),i);
				i++;
				//System.out.printf("%s, %s\n", row.get(0), row.get(3));
			}
		}

       SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
       Date date = new Date();
       String time = sdf.format(date);

       List<CellData> values = new ArrayList<>();
       values.add(new CellData()
               .setUserEnteredValue(new ExtendedValue()
                       .setStringValue("Yes")));

       List<CellData> values1 = new ArrayList<>();
       values1.add(new CellData()
               .setUserEnteredValue(new ExtendedValue()

                       .setStringValue(time)));


       requests.add(new Request()
               .setUpdateCells(new UpdateCellsRequest()
                       .setStart(new GridCoordinate()
                               .setSheetId(1804025843)
                               .setRowIndex(0)
                               .setColumnIndex(6))
                       .setRows(Arrays.asList(
                               new RowData().setValues(values1)))
                       .setFields("userEnteredValue,userEnteredFormat.backgroundColor")));

       requests.add(new Request()
               .setUpdateCells(new UpdateCellsRequest()
                       .setStart(new GridCoordinate()
                               .setSheetId(1804025843)
                               .setRowIndex(1)
                               .setColumnIndex(6))
                       .setRows(Arrays.asList(
                               new RowData().setValues(values)))
                       .setFields("userEnteredValue,userEnteredFormat.backgroundColor")));


        BatchUpdateSpreadsheetRequest batchUpdateRequest = new BatchUpdateSpreadsheetRequest()
    	        .setRequests(requests);
    	service.spreadsheets().batchUpdate(spreadsheetId, batchUpdateRequest)
    	        .execute();

    }*/

	public void update(int stdid,int randNumber){
		try{
			System.out.println("I am in update method");
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
			Date date = new Date();
			String time = sdf.format(date);


			Sheets service = getSheetsService();
			String spreadsheetId = "1x5zVGM_r6uwY3UUa9HFo2Ew2PJxft9r4DTe0hCt1DP0";
			List<Request> requests = new ArrayList<>();
			requests.add(new Request()
					.setUpdateSheetProperties(new UpdateSheetPropertiesRequest()
							.setProperties(new SheetProperties()
									.setSheetId(1804025843)
									.setTitle("Student Attendance"))
							.setFields("title")));
			SheetsQuickstart_g spreadsheet=new SheetsQuickstart_g();
			List<List<Object>> valuesFetch = spreadsheet.fetchForUpdateData();
			HashMap<Integer,Integer> hash=new HashMap<Integer,Integer>();

			/*File file = new File("counter.txt");
			FileInputStream fis = null;
			OutputStream os =null;*/

			try {



				/*fis = new FileInputStream(file);
				os= new FileOutputStream(file);
				
				int content = fis.read();
				System.out.println("File content" + content);
				
				os.write(content);*/

				HashMap hashDate=new HashMap();
				HashMap hashEmailIdMapping=new HashMap();

				Integer currentPtr=6;
				if(hashDate.containsKey(time)){
					currentPtr=Integer.valueOf(hashDate.get(time).toString());
					// key 07/26/2016 6
				}
				else{
					// key 07/28/2016 7
					currentPtr=currentPtr+1;
					hashDate.put(time, currentPtr);
					//	out.write(currentPtr);
				}
				String emailId=null;
				int i=1;
				if (valuesFetch == null || valuesFetch.size() == 0) {
					System.out.println("No data found.");
				} else {
					for (List row : valuesFetch) {
						System.out.println("Data to find a string ::: "+row.get(3).toString());
						hash.put(Integer.valueOf(row.get(3).toString()),i);
						emailId=row.get(6).toString();
						hashEmailIdMapping.put(Integer.valueOf(row.get(3).toString()), emailId);
						i++;
					}
				}

				List<CellData> values = new ArrayList<>();
				values.add(new CellData()
						.setUserEnteredValue(new ExtendedValue()
								.setStringValue("Yes")));

				List<CellData> values1 = new ArrayList<>();
				values1.add(new CellData()
						.setUserEnteredValue(new ExtendedValue()

								.setStringValue(time))); //time change


				requests.add(new Request()
						.setUpdateCells(new UpdateCellsRequest()
								.setStart(new GridCoordinate()
										.setSheetId(1804025843)
										.setRowIndex(0)
										.setColumnIndex(currentPtr)) //change index
								.setRows(Arrays.asList(
										new RowData().setValues(values1)))
								.setFields("userEnteredValue,userEnteredFormat.backgroundColor")));

				requests.add(new Request()
						.setUpdateCells(new UpdateCellsRequest()
								.setStart(new GridCoordinate()
										.setSheetId(1804025843)
										.setRowIndex(hash.get(stdid).intValue())
										.setColumnIndex(currentPtr))
								.setRows(Arrays.asList(
										new RowData().setValues(values)))
								.setFields("userEnteredValue,userEnteredFormat.backgroundColor")));


				BatchUpdateSpreadsheetRequest batchUpdateRequest = new BatchUpdateSpreadsheetRequest()
						.setRequests(requests);
				service.spreadsheets().batchUpdate(spreadsheetId, batchUpdateRequest)
				.execute();

				//file creation and deletion code	

				String emailD=hashEmailIdMapping.get(stdid).toString();
				System.out.println("Email ID:::"+emailD);
				new EmailData().sentEmail(emailD,time);
			}finally {
				/*fis.close();
				os.close();*/
			} 

			//file creation and deletion code	

		}catch(Exception e){
			System.out.println(e);
		}


	}



}