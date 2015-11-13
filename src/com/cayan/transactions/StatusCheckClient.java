package com.cayan.transactions;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Status Check :
 * There are two versions of the Status request available. 
 * Version 1 sends a request to the CED to check which screen the device is on. 
 * Version 2 is analogous with version 1 but also includes any AdditionalParameters fields
 */
public class StatusCheckClient {
	
	/**
	 * main method which starts execution
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {
		BufferedReader br = null;
		String url ="http://205.219.72.106:8080/v1/pos?Action=Status&Format=XML";
		URL obj = new URL(url);
		/*
		 * HTTP Connection is opened.
		 */
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "text/xml");
		String urlParameters;
		/*
		 * Soap Request is kept in SoapRequest.txt
		 * and this request is read from SoapRequest.txt file
		 */
		br = new BufferedReader(new FileReader("SoapRequestStatusCheck.txt"));
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		while ((urlParameters = br.readLine()) != null) {
			System.out.println(urlParameters);
			wr.writeBytes(urlParameters);
		}
		br.close();
		wr.flush();
		wr.close();
		
		
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
