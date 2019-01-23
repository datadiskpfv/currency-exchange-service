package uk.co.datadisk.microservices.currencyexchangeservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.datadisk.microservices.currencyexchangeservice.entities.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

    ExchangeValue findByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);
}
