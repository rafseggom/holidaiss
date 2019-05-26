
package aiss.model.mapbox;

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
    "short_code",
    "wikidata"
})
public class Properties {

    @JsonProperty("short_code")
    private String short_code;
    @JsonProperty("wikidata")
    private String wikidata;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("short_code")
    public String getShort_code() {
        return short_code;
    }

    @JsonProperty("short_code")
    public void setShort_code(String short_code) {
        this.short_code = short_code;
    }

    @JsonProperty("wikidata")
    public String getWikidata() {
        return wikidata;
    }

    @JsonProperty("wikidata")
    public void setWikidata(String wikidata) {
        this.wikidata = wikidata;
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
