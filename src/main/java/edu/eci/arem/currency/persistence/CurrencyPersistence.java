/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arem.currency.persistence;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

/**
 *
 * @author camilolopez
 */
public interface CurrencyPersistence {

    /**
     *
     * @return @throws java.net.ProtocolException
     * @throws java.net.MalformedURLException
     */
    public String getAllCurrenciNames() throws ProtocolException, MalformedURLException, IOException;

    /**
     *
     * @return @throws ProtocolException
     * @throws MalformedURLException
     * @throws IOException
     */
    public String getCurrenciPricesInUsd() throws ProtocolException, MalformedURLException, IOException;

}
