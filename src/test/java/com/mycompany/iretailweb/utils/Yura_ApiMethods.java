/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iretailweb.utils;

import static com.google.common.net.HttpHeaders.USER_AGENT;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;
//import static myretail.MyRetail.client_secret;
//import static myretail.MyRetail.server;
import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.simple.JSONObject;

/**
 *
 * @author Zver
 */
public class Yura_ApiMethods {
    
    public static String parseKassaId(String response) throws JSONException
{
    JSONObject obj = new JSONObject(response);
//String pageName = obj.getJSONObject("value").getString("mainActivity");
    System.out.println(response);
String kassa_id = obj.getString("result");
return kassa_id;
}
    public static String CreateNewKassa(Yura_TestDeviceInfo testDevice) throws MalformedURLException, IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, JSONException, Exception 
{
   String urlParameters =  "name="+DataGeneration.generateRandomString(7)+"&shift_number=1&type_slug=workplace_cashier&trade_point_id="+testDevice.trade_point_id+Const.client_secret+"&profile_id="+testDevice.profile_id+"&access_token="+testDevice.token;
   
   
   String response = sendPOST("/api/device/create", urlParameters);
return parseKassaId(response);     
 }
    
    public static String sendPOST(String url, String urlParameters) throws Exception {
        
         url = Const.server + url;
        URL obj = new URL(url);           
        Yura_TrustAllCertificates.install();            
        String string = null;
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

//		String urlParameters =  "device_id=241&trade_point_id=142&client_id=PIPO_WEBAPP&client_secret=DJF22HS%5E%23Khdsfj325ruh)_%23&access_token=c0b76828f77eb468eacd4c7e2b99bb8e962c7066";
//                String urlParameters =  "client_id=PIPO_WEBAPP&client_secret=DJF22HS%5E%23Khdsfj325ruh)_%23&access_token="+access_token;

		// Send post request
		con.setDoOutput(true);
        try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
            wr.writeBytes(urlParameters);
            wr.flush();
        }

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

                StringBuilder response;
                try (BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
        }
		System.out.println(response.toString());
                return response.toString();
    }
    


public static String parseMyToken(String response) throws JSONException
{
    JSONObject obj = new JSONObject(response);
//String pageName = obj.getJSONObject("value").getString("mainActivity");
String token = obj.getJSONObject("result").getString("access_token");
    System.out.println("token="+token);
return token;
}

public static String parseMyProfileId(String response) throws JSONException
{
    JSONObject obj = new JSONObject(response);
//String pageName = obj.getJSONObject("value").getString("mainActivity");
String app_id = null;
JSONArray arr = obj.getJSONArray("result");
for (int i = 0; i < arr.length(); i++)
{
     app_id = arr.getJSONObject(i).getString("id");
    }
return app_id;
}

public static String parseMyTradePointId(String response) throws JSONException
{
    JSONObject obj = new JSONObject(response);
//String pageName = obj.getJSONObject("value").getString("mainActivity");
String app_id = null;
    System.out.println(response);
JSONArray arr = obj.getJSONObject("result").getJSONArray("tradePoints");
for (int i = 0; i < arr.length(); i++)
{
     app_id = arr.getJSONObject(i).getString("related_id");
    }
return app_id;
}

public static String parseDeviceId(String response) throws JSONException
{
    JSONObject obj = new JSONObject(response);
//String pageName = obj.getJSONObject("value").getString("mainActivity");
String app_id = null;
JSONArray arr = obj.getJSONObject("result").getJSONArray("devices");
for (int i = 0; i < arr.length(); i++)
{
     app_id = arr.getJSONObject(i).getString("id");
    }
return app_id;
}

public static String parseDeviceCode2(String response) throws JSONException
{
    JSONObject obj = new JSONObject(response);
//String pageName = obj.getJSONObject("value").getString("mainActivity");
String app_id = null;
JSONArray arr = obj.getJSONObject("result").getJSONArray("devices");
for (int i = 0; i < arr.length(); i++)
{
     app_id = arr.getJSONObject(i).getString("code");
    }
return app_id;
}

public static String parseDeviceCode(String response) throws JSONException
{
    JSONObject obj = new JSONObject(response);
//String pageName = obj.getJSONObject("value").getString("mainActivity");
    System.out.println(response);
String app_id = obj.getJSONObject("result").getString("code");
System.out.println("device_code="+app_id);
return app_id;
}



public static String getToken() throws MalformedURLException, IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, JSONException, Exception 
{
   String urlParameters = "username=%2B79039106754&password=123456&remember_me=false"+Const.client_secret;
   String response = sendPOST("/api/user/authentication", urlParameters);
return parseMyToken(response);
}


public static String getProfileInfo(String access_token) throws MalformedURLException, IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, JSONException, Exception 
{
   String urlParameters = "access_token="+access_token+Const.client_secret;
   String response = sendPOST("/api/user/get-profile-list", urlParameters);
return parseMyProfileId(response);
  
     
 }

public static String getTradePoint(String profile_id, String access_token) throws MalformedURLException, IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, JSONException, Exception 
{
  String urlParameters ="profile_id="+profile_id+"&access_token="+access_token+Const.client_secret;
  String response = sendPOST("/api/trade-point/get", urlParameters);
return parseMyTradePointId(response);
}

public static String getDeviceId(String profile_id, String access_token, String trade_point) throws MalformedURLException, IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, JSONException, Exception 
{
   String urlParameters = "name=&device_id=&code_device=&trade_point_id_array%5B0%5D="+trade_point+"&page_size=10&page_number=0&profile_id="+profile_id+"&access_token="+access_token+Const.client_secret;
   String response = sendPOST("/api/device/find", urlParameters);
return parseDeviceId(response);
}
public static String getDeviceCode(Yura_TestDeviceInfo testDevice) throws MalformedURLException, IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, JSONException, Exception 
{
   String urlParameters =  "name=&device_id=&code_device=&trade_point_id_array%5B0%5D="+testDevice.trade_point_id+"&page_size=10&page_number=0&profile_id="+testDevice.profile_id+"&access_token="+testDevice.token+Const.client_secret;
   String response = sendPOST("/api/device/find", urlParameters);
return parseDeviceCode2(response);
}

public static void repeatActivation(String access_token, String trade_point, String device_id) throws MalformedURLException, IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, JSONException, Exception 
{
   String urlParameters =  "device_id="+device_id+"&trade_point_id="+trade_point+Const.client_secret+"&access_token="+access_token;
   String response = sendPOST("/api/device/repeat-activation", urlParameters);
 }
@Deprecated
public static String getDeviceCode(String profile_id, String access_token, String trade_point, String device_id) throws MalformedURLException, IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, JSONException, Exception 
{
   String urlParameters =  "device_id="+device_id+"&trade_point_id="+trade_point+Const.client_secret+"&profile_id="+profile_id+"&access_token="+access_token;
   String response = sendPOST("/api/device/get-device-info", urlParameters);
return parseDeviceCode(response);     
 }


public static String CreateNewTradePoint(Yura_TestDeviceInfo testDevice) throws MalformedURLException, IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, JSONException, Exception 
{
   String urlParameters =  "title="+DataGeneration.generateRandomString(7)+"&address=Россия, "+DataGeneration.generateRandomString(6)+", "+DataGeneration.generateRandomString(7)+", "+DataGeneration.generateRandomNumber(2)+"&tcpuntry_id=171&trade_point_id="+Const.client_secret+"&profile_id="+testDevice.profile_id+"&access_token="+testDevice.token;
   
   
   String response = sendPOST("/api/trade-point/create-trade-point", urlParameters);
return parseKassaId(response);     
 }
}
