/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arem.currency.controller;

import edu.eci.arem.currency.service.CurrencyServices;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author camilolopez
 */
@RestController
@RequestMapping(value = "/currency")
public class CurrencyAPIController {

    @Autowired
    CurrencyServices cServices;

    /**
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getCurrencyPrices() {
        try {
            return new ResponseEntity<>(cServices.getCurrenciPricesInUsd(), HttpStatus.ACCEPTED);
        } catch (IOException e) {
            Logger.getLogger(CurrencyAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("No se ha podido retornar los precios", HttpStatus.NOT_FOUND);
        }
    }

    /**
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "names")
    public ResponseEntity<?> getCurrenciesNames() {
        try {
            return new ResponseEntity<>(cServices.getAllCurrenciNames(), HttpStatus.ACCEPTED);
        } catch (IOException e) {
            Logger.getLogger(CurrencyAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("No se ha podido retornar los nombres", HttpStatus.NOT_FOUND);
        }
    }

}
