package com.controller.spreadsheet;
import java.io.BufferedReader;
import java.io.BufferedWriter;
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
import java.util.Properties;

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
	static HashMap hashDate=new HashMap(); //check the date 
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


	public void update(int stdid,int randNumber){
		try{
			System.out.println("I am in update method");
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
			Date date = new Date();
			String time = sdf.format(date);


			Sheets service = getSheetsService();
			InputStream inputStream = this.getClass().getClassLoader()
					.getResourceAsStream("ApplicationResource.properties");

			Properties properties = new Properties();
			System.out.println("InputStream is: " + inputStream);
			properties.load(inputStream);
			String propValue = properties.getProperty("spreadsheetId");
			Integer id = Integer.parseInt(properties.getProperty("sheetId"));
			String spreadsheetId = propValue;
			List<Request> requests = new ArrayList<>();
			requests.add(new Request()
					.setUpdateSheetProperties(new UpdateSheetPropertiesRequest()
							.setProperties(new SheetProperties()
									.setSheetId(id)
									.setTitle("Student Attendance"))
							.setFields("title")));
			SheetsQuickstart_g spreadsheet=new SheetsQuickstart_g();
			List<List<Object>> valuesFetch = spreadsheet.fetchForUpdateData();
			HashMap<Integer,Integer> hash=new HashMap<Integer,Integer>();

			BufferedReader in = null;
			BufferedWriter out = null;
			System.out.println("Before try block");
			try {
				//String pathAppend="F:\\CSU-Sacramento\\Bhushan\\CSC131\\Github_clone\\Andrew_Work\\csc131\\Java_Project\\CSC131_Project\\src\\com\\controller\\spreadsheet\\"+"counter.txt";
				String path = properties.getProperty("path");
				String pathAppend=path;
				System.out.println("Path is : "+pathAppend);
				in =  new BufferedReader(new FileReader(pathAppend));
				//
				System.out.println("Before call in objects.....");
				int content =0;
				String line=in.readLine();
				System.out.println("value reading  file:::::"+line);
				content=Integer.parseInt(line);

				System.out.println("File content" + content);


				HashMap hashEmailIdMapping=new HashMap();

				Integer currentPtr=content;
				if(hashDate.containsKey(time)){
					currentPtr=Integer.valueOf(hashDate.get(time).toString());
					// key 07/26/2016 6
				}
				else{
					// key 07/28/2016 7
					currentPtr=currentPtr+1;
					hashDate.put(time, currentPtr);
					out = new BufferedWriter(new FileWriter(pathAppend));
					out.write(currentPtr.toString());
					out.close();
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
										.setSheetId(id)
										.setRowIndex(0)
										.setColumnIndex(currentPtr)) //change index
								.setRows(Arrays.asList(
										new RowData().setValues(values1)))
								.setFields("userEnteredValue,userEnteredFormat.backgroundColor")));

				requests.add(new Request()
						.setUpdateCells(new UpdateCellsRequest()
								.setStart(new GridCoordinate()
										.setSheetId(id)
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
				new EmailData().sentEmail(emailD,time,"Attendance Mark For Today Date -","Attendance Mark For Today Date -");

			}finally {
				in.close();

			} 

			//file creation and deletion code	

		}catch(Exception e){
			System.out.println(e);
		}


	}




	public boolean updateEmail(int stdid,String emailID){
		try{
			System.out.println("I am in update email method");
			Sheets service = getSheetsService();
			
			InputStream inputStream = this.getClass().getClassLoader()
					.getResourceAsStream("ApplicationResource.properties");

			Properties properties = new Properties();
			System.out.println("InputStream is: " + inputStream);
			properties.load(inputStream);
			String propValue = properties.getProperty("spreadsheetId");
			Integer id = Integer.parseInt(properties.getProperty("sheetId"));
			
			String spreadsheetId = propValue;
			List<Request> requests = new ArrayList<>();
			requests.add(new Request()
					.setUpdateSheetProperties(new UpdateSheetPropertiesRequest()
							.setProperties(new SheetProperties()
									.setSheetId(id)
									.setTitle("Student Attendance"))
							.setFields("title")));
			SheetsQuickstart_g spreadsheet=new SheetsQuickstart_g();
			List<List<Object>> valuesFetch = spreadsheet.fetchForUpdateData();
			HashMap<Integer,Integer> hash=new HashMap<Integer,Integer>();

			System.out.println("Before try block");
			try {

				int i=1;
				if (valuesFetch == null || valuesFetch.size() == 0) {
					System.out.println("No data found.");
				} else {
					for (List row : valuesFetch) {
						System.out.println("Data to find a string ::: "+row.get(3).toString());
						hash.put(Integer.valueOf(row.get(3).toString()),i);

						i++;
					}
				}

				List<CellData> values = new ArrayList<>();
				values.add(new CellData()
						.setUserEnteredValue(new ExtendedValue()
								.setStringValue(emailID)));




				requests.add(new Request()
						.setUpdateCells(new UpdateCellsRequest()
								.setStart(new GridCoordinate()
										.setSheetId(id)
										.setRowIndex(hash.get(stdid).intValue())
										.setColumnIndex(6))
								.setRows(Arrays.asList(
										new RowData().setValues(values)))
								.setFields("userEnteredValue,userEnteredFormat.backgroundColor")));


				BatchUpdateSpreadsheetRequest batchUpdateRequest = new BatchUpdateSpreadsheetRequest()
						.setRequests(requests);
				service.spreadsheets().batchUpdate(spreadsheetId, batchUpdateRequest)
				.execute();


				return true;
			}finally {
				
			} 


		}catch(Exception e){
			System.out.println(e);
			return false;
		}


	}




}