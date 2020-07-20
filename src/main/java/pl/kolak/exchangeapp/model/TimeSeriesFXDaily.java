
package pl.kolak.exchangeapp.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TimeSeriesFXDaily {
    @JsonIgnore
    private Map<String, Map<String, String>> additionalProperties = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Map<String, String>> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Map<String, String> value) {
        this.additionalProperties.put(name, value);
    }

}
