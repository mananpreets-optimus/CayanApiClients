package com.cayan.listItemDisplay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class StartTransaction {

	/**
	 * main starts here
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {

		BufferedReader rd = null;
		HttpURLConnection con = null;

		/**
		 * url which is to be hit
		 */
		String url = "http://205.219.72.106:8080/v1/pos?Action=StartOrder&Order=1000&Format=JSON";
		URL obj = new URL(url);

		/*
		 * Http Connection is opened.
		 */
		con = (HttpURLConnection) obj.openConnection();

		/**
		 * setting headers
		 */
		con.setRequestMethod("GET");
	
		try {
		
			int responseCode = con.getResponseCode();
			System.out.println("Response Code: " + responseCode);

			/*
			 * Response is received.
			 */
			rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String input;
			StringBuffer response = new StringBuffer();

			/**
			 * reading the response
			 */
			while ((input = rd.readLine()) != null) {
				response.append(input);
			}
			rd.close();
			if(response.toString().isEmpty()){
				System.out.println("response:No response data received");
			}
			else{
				System.out.println("response:"+response.toString());
			}
		}
		catch (Exception exception) {
			System.out.println("error in making connection");
			exception.printStackTrace();
		}
	}
}
