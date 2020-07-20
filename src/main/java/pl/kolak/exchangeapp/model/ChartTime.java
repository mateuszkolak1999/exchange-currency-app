
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
    "Time Series FX (Daily)"
})
public class ChartTime {

    @JsonProperty("Meta Data")
    private MetaData metaData;
    @JsonProperty("Time Series FX (Daily)")
    private TimeSeriesFXDaily timeSeriesFXDaily;
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

    @JsonProperty("Time Series FX (Daily)")
    public TimeSeriesFXDaily getTimeSeriesFXDaily() {
        return timeSeriesFXDaily;
    }

    @JsonProperty("Time Series FX (Daily)")
    public void setTimeSeriesFXDaily(TimeSeriesFXDaily timeSeriesFXDaily) {
        this.timeSeriesFXDaily = timeSeriesFXDaily;
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
