package uk.co.datadisk.microservices.currencyexchangeservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import uk.co.datadisk.microservices.currencyexchangeservice.entities.ExchangeValue;
import uk.co.datadisk.microservices.currencyexchangeservice.repositories.ExchangeValueRepository;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueRepository repository;

    @GetMapping("/currency-exchange/from/{fromCurrency}/to/{toCurrency}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String fromCurrency, @PathVariable String toCurrency) {
//        ExchangeValue exchangeValue =
//                new ExchangeValue(1000L, fromCurrency, toCurrency, BigDecimal.valueOf(65));

        ExchangeValue exchangeValue = repository.findByFromCurrencyAndToCurrency(fromCurrency, toCurrency);

        exchangeValue.setPort(
                Integer.parseInt(environment.getProperty("local.server.port")));

        return exchangeValue;
    }
}
