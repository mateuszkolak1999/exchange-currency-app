
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
    "1. Information",
    "2. From Symbol",
    "3. To Symbol",
    "4. Output Size",
    "5. Last Refreshed",
    "6. Time Zone"
})
public class MetaData {

    @JsonProperty("1. Information")
    private String _1Information;
    @JsonProperty("2. From Symbol")
    private String _2FromSymbol;
    @JsonProperty("3. To Symbol")
    private String _3ToSymbol;
    @JsonProperty("4. Output Size")
    private String _4OutputSize;
    @JsonProperty("5. Last Refreshed")
    private String _5LastRefreshed;
    @JsonProperty("6. Time Zone")
    private String _6TimeZone;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("1. Information")
    public String get1Information() {
        return _1Information;
    }

    @JsonProperty("1. Information")
    public void set1Information(String _1Information) {
        this._1Information = _1Information;
    }

    @JsonProperty("2. From Symbol")
    public String get2FromSymbol() {
        return _2FromSymbol;
    }

    @JsonProperty("2. From Symbol")
    public void set2FromSymbol(String _2FromSymbol) {
        this._2FromSymbol = _2FromSymbol;
    }

    @JsonProperty("3. To Symbol")
    public String get3ToSymbol() {
        return _3ToSymbol;
    }

    @JsonProperty("3. To Symbol")
    public void set3ToSymbol(String _3ToSymbol) {
        this._3ToSymbol = _3ToSymbol;
    }

    @JsonProperty("4. Output Size")
    public String get4OutputSize() {
        return _4OutputSize;
    }

    @JsonProperty("4. Output Size")
    public void set4OutputSize(String _4OutputSize) {
        this._4OutputSize = _4OutputSize;
    }

    @JsonProperty("5. Last Refreshed")
    public String get5LastRefreshed() {
        return _5LastRefreshed;
    }

    @JsonProperty("5. Last Refreshed")
    public void set5LastRefreshed(String _5LastRefreshed) {
        this._5LastRefreshed = _5LastRefreshed;
    }

    @JsonProperty("6. Time Zone")
    public String get6TimeZone() {
        return _6TimeZone;
    }

    @JsonProperty("6. Time Zone")
    public void set6TimeZone(String _6TimeZone) {
        this._6TimeZone = _6TimeZone;
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
