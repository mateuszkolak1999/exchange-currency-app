package pl.kolak.exchangeapp.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import pl.kolak.exchangeapp.model.CurrencyExchangeRate;

@Controller
public class CurrencyController {
    @GetMapping("/")
    public String exchangeCurrency(@RequestParam(name = "currency_from") String currency_from,
                                   @RequestParam(name = "currency_to") String currency_to,
                                   Model model){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        ResponseEntity<CurrencyExchangeRate> currency = restTemplate.exchange("https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency="+ currency_from +"&to_currency="+currency_to+"&apikey=P3PKRC0UY3YZR65Z",
                HttpMethod.GET,
                httpEntity,
                CurrencyExchangeRate.class);
        String exchangeRate = currency.getBody().getRealtimeCurrencyExchangeRate().get5ExchangeRate();
        model.addAttribute("exchangeRate",exchangeRate);
        return "index";
    }
}
