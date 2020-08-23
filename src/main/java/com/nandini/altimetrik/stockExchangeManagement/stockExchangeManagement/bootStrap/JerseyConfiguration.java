package com.nandini.altimetrik.stockExchangeManagement.stockExchangeManagement.bootStrap;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.nandini.altimetrik.stockExchangeManagement.stockExchangeManagement.controller.StockController;

@Component
public class JerseyConfiguration extends ResourceConfig {

	public JerseyConfiguration() {
        register(StockController.class);
    }

}
