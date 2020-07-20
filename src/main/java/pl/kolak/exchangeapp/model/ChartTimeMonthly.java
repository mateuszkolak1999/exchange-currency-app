
package pl.kolak.exchangeapp.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Meta Data",
    "Time Series FX (Monthly)"
})
public class ChartTimeMonthly {

    @JsonProperty("Meta Data")
    private MetaData metaData;
    @JsonProperty("Time Series FX (Monthly)")
    private TimeSeriesFXMonthly timeSeriesFXMonthly;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Meta Data")
    public MetaData getMetaData() {
        return metaData;
    }

    @JsonProperty("Meta Data")
    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    @JsonProperty("Time Series FX (Monthly)")
    public TimeSeriesFXMonthly getTimeSeriesFXMonthly() {
        return timeSeriesFXMonthly;
    }

    @JsonProperty("Time Series FX (Monthly)")
    public void setTimeSeriesFXMonthly(TimeSeriesFXMonthly timeSeriesFXMonthly) {
        this.timeSeriesFXMonthly = timeSeriesFXMonthly;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
