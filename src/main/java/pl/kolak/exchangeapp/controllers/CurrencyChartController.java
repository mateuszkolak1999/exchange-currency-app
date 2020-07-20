package pl.kolak.exchangeapp.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import pl.kolak.exchangeapp.model.*;

import java.util.Map;
import java.util.TreeMap;

@Controller
public class CurrencyChartController {

    @GetMapping("/chart/{time}")
    public String getPieChart(@PathVariable(name = "time") String time,
                              @RequestParam(name = "from_symbol") String from_symbol,
                              @RequestParam(name = "to_symbol") String to_symbol,
                              Model model) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(httpHeaders);


        Map<String, Map<String, String>> additionalProperties = null;
        switch (time){
            case "FX_DAILY":
                ResponseEntity<?> exchange = restTemplate.exchange("https://www.alphavantage.co/query?function="+time+"&from_symbol=" + from_symbol + "&to_symbol=" + to_symbol + "&apikey=P3PKRC0UY3YZR65Z",
                        HttpMethod.GET,
                        httpEntity,
                        ChartTime.class);
                TimeSeriesFXDaily timeSeriesFXDaily = ((ResponseEntity<ChartTime>)exchange).getBody().getTimeSeriesFXDaily();
                additionalProperties = timeSeriesFXDaily.getAdditionalProperties();
                break;
            case "FX_WEEKLY":
                ResponseEntity<?> exchangeWeekly = restTemplate.exchange("https://www.alphavantage.co/query?function="+time+"&from_symbol=" + from_symbol + "&to_symbol=" + to_symbol + "&apikey=P3PKRC0UY3YZR65Z",
                        HttpMethod.GET,
                        httpEntity,
                        ChartTimeWeekly.class);
                TimeSeriesFXWeekly timeSeriesFXWeekly = ((ResponseEntity<ChartTimeWeekly>) exchangeWeekly).getBody().getTimeSeriesFXWeekly();
                additionalProperties = timeSeriesFXWeekly.getAdditionalProperties();
                break;
            case "FX_MONTHLY":
                ResponseEntity<?> exchangeMonthly = restTemplate.exchange("https://www.alphavantage.co/query?function="+time+"&from_symbol=" + from_symbol + "&to_symbol=" + to_symbol + "&apikey=P3PKRC0UY3YZR65Z",
                        HttpMethod.GET,
                        httpEntity,
                        ChartTimeMonthly.class);
                TimeSeriesFXMonthly timeSeriesFXMonthly = ((ResponseEntity<ChartTimeMonthly>) exchangeMonthly).getBody().getTimeSeriesFXMonthly();
                additionalProperties = timeSeriesFXMonthly.getAdditionalProperties();
                break;
        }
        Map<String, Object> graphData = new TreeMap<>();
        additionalProperties.forEach((d,v)->{
            String s = v.get("4. close");
            graphData.put(d,Double.parseDouble(s));
        });
        model.addAttribute("chartData", graphData);
        return "chart";
    }
}
