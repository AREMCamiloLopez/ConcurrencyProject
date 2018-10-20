/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arem.currency.persistence.impl;

import edu.eci.arem.currency.persistence.CurrencyPersistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import org.springframework.stereotype.Service;

/**
 *
 * @author camilolopez
 */
@Service
public class InMemoryCurrencyPersistence implements CurrencyPersistence {

    private final String USER_AGENT = "Mozilla/5.0";

    @Override
    public String getAllCurrenciNames() throws ProtocolException, MalformedURLException, IOException {
        String GET_URL = "https://openexchangerates.org/api/currencies.json?app_id=ada1e8cac2164d1fbea78c5f2559657e";
        return httpRequest(GET_URL);
    }

    @Override
    public String getCurrenciPricesInUsd() throws ProtocolException, MalformedURLException, IOException {
        String GET_URL = "https://openexchangerates.org/api/latest.json?app_id=ada1e8cac2164d1fbea78c5f2559657e";
        return httpRequest(GET_URL);
    }

    /**
     *
     * @param GET_URL
     * @return
     * @throws ProtocolException
     * @throws MalformedURLException
     * @throws IOException
     */
    public String httpRequest(String GET_URL) throws ProtocolException, MalformedURLException, IOException {
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } else {
            System.out.println("GET request not worked");
            return "No se ha podido obtener la peticion";
        }
    }
}
