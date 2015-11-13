package com.cayan.transactions;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GiftActivate {
	
	/**
	 * main starts here
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {

		BufferedReader br = null;
		DataOutputStream wr = null;
		BufferedReader rd = null;
		HttpURLConnection con = null;

		/**
		 * url which is to be hit
		 */
		String url = "https://ps1.merchantware.net/Merchantware/ws/ExtensionServices/v4/Giftcard.asmx";
		URL obj = new URL(url);

		/*
		 * Http Connection is opened.
		 */
		con = (HttpURLConnection) obj.openConnection();

		/**
		 * setting headers
		 */
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "text/xml");
		String urlParameters;

		/*
		 * Soap Request is kept in SoapRequestGiftActivate.txt and this request
		 * is read from file
		 */
		br = new BufferedReader(new FileReader("SoapRequestGiftActivate"));
		con.setDoOutput(true);

		try {
			wr = new DataOutputStream(con.getOutputStream());

			while ((urlParameters = br.readLine()) != null) {
				System.out.println(urlParameters);
				wr.writeBytes(urlParameters);
			}
			br.close();
			wr.flush();
			wr.close();

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
			System.out.println(response.toString());
		}

		catch (Exception exception) {
			System.out.println("error in making connection");
			exception.printStackTrace();
		}
	}
}
