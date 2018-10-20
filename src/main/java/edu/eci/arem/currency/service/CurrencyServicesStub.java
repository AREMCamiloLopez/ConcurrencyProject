/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arem.currency.service;

import edu.eci.arem.currency.persistence.CurrencyPersistence;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author camilolopez
 */
@Service
public class CurrencyServicesStub implements CurrencyServices {

    @Autowired
    CurrencyPersistence cPersistence;

    @Override
    public String getAllCurrenciNames() throws ProtocolException, MalformedURLException, IOException{
        return cPersistence.getAllCurrenciNames();
    }

    @Override
    public String getCurrenciPricesInUsd() throws ProtocolException, MalformedURLException, IOException{
        return cPersistence.getCurrenciPricesInUsd();
    }

}
