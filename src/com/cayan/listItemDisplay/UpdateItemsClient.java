package com.cayan.listItemDisplay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UpdateItemsClient {

	/**
	 * main method which starts execution
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {
		
	String url ="http://205.219.72.106:8080/v1/pos?Action=UpdateItem&Order=30&TargetItemID=22&OrderTotal=111&OrderTax=1111&Format=XML";
	URL obj = new URL(url);
	/*
	 * HTTP Connection is opened.
	 */
	HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	con.setRequestMethod("GET");
	con.setRequestProperty("Content-Type", "text/xml");
	
	int responseCode = con.getResponseCode();
	System.out.println("******************************************************************************************************************");
	System.out.println("Response Code: "+ responseCode);
	/*
	 * Response is received.
	 */
	BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
	String input;
	StringBuffer response = new StringBuffer();
	while((input = rd.readLine())!= null){
		response.append(input);
	}
	rd.close();
	System.out.println("******************************************************************************************************************");
	System.out.println("Response From API :");
	System.out.println(response.toString());
}
}
