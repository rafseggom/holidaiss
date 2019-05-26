
package aiss.model.amadeus;

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
    "currencies",
    "locations"
})
public class Dictionaries {

    @JsonProperty("currencies")
    private Currencies currencies;
    @JsonProperty("locations")
    private Locations locations;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("currencies")
    public Currencies getCurrencies() {
        return currencies;
    }

    @JsonProperty("currencies")
    public void setCurrencies(Currencies currencies) {
        this.currencies = currencies;
    }

    @JsonProperty("locations")
    public Locations getLocations() {
        return locations;
    }

    @JsonProperty("locations")
    public void setLocations(Locations locations) {
        this.locations = locations;
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
