package com.cayan.transactions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Initiate Transaction :
 * Send the TransportKey to the Customer Engagement Device using the GET method 
 * and wait for the customer to complete the transaction.
 */
public class InitiateTransactionClient {
	
	/**
	 * main method which starts execution
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {
		
	String url ="http://205.219.72.106:8080/v1/pos?TransportKey=788278e9-7f8c-4aae-92dd-aa85ff17d7d1&Format=XML";
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
