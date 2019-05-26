
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
    "departureDate",
    "oneWay",
    "duration",
    "nonStop",
    "viewBy"
})
public class Defaults {

    @JsonProperty("departureDate")
    private String departureDate;
    @JsonProperty("oneWay")
    private Boolean oneWay;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("nonStop")
    private Boolean nonStop;
    @JsonProperty("viewBy")
    private String viewBy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("departureDate")
    public String getDepartureDate() {
        return departureDate;
    }

    @JsonProperty("departureDate")
    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    @JsonProperty("oneWay")
    public Boolean getOneWay() {
        return oneWay;
    }

    @JsonProperty("oneWay")
    public void setOneWay(Boolean oneWay) {
        this.oneWay = oneWay;
    }

    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    @JsonProperty("nonStop")
    public Boolean getNonStop() {
        return nonStop;
    }

    @JsonProperty("nonStop")
    public void setNonStop(Boolean nonStop) {
        this.nonStop = nonStop;
    }

    @JsonProperty("viewBy")
    public String getViewBy() {
        return viewBy;
    }

    @JsonProperty("viewBy")
    public void setViewBy(String viewBy) {
        this.viewBy = viewBy;
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
