
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
    "type",
    "subType",
    "name",
    "detailedName",
    "id",
    "self",
    "timeZoneOffset",
    "iataCode",
    "geoCode",
    "address",
    "analytics"
})
public class Datum {

    @JsonProperty("type")
    private String type;
    @JsonProperty("subType")
    private String subType;
    @JsonProperty("name")
    private String name;
    @JsonProperty("detailedName")
    private String detailedName;
    @JsonProperty("id")
    private String id;
    @JsonProperty("self")
    private Self self;
    @JsonProperty("timeZoneOffset")
    private String timeZoneOffset;
    @JsonProperty("iataCode")
    private String iataCode;
    @JsonProperty("geoCode")
    private GeoCode geoCode;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("analytics")
    private Analytics analytics;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("subType")
    public String getSubType() {
        return subType;
    }

    @JsonProperty("subType")
    public void setSubType(String subType) {
        this.subType = subType;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("detailedName")
    public String getDetailedName() {
        return detailedName;
    }

    @JsonProperty("detailedName")
    public void setDetailedName(String detailedName) {
        this.detailedName = detailedName;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("self")
    public Self getSelf() {
        return self;
    }

    @JsonProperty("self")
    public void setSelf(Self self) {
        this.self = self;
    }

    @JsonProperty("timeZoneOffset")
    public String getTimeZoneOffset() {
        return timeZoneOffset;
    }

    @JsonProperty("timeZoneOffset")
    public void setTimeZoneOffset(String timeZoneOffset) {
        this.timeZoneOffset = timeZoneOffset;
    }

    @JsonProperty("iataCode")
    public String getIataCode() {
        return iataCode;
    }

    @JsonProperty("iataCode")
    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    @JsonProperty("geoCode")
    public GeoCode getGeoCode() {
        return geoCode;
    }

    @JsonProperty("geoCode")
    public void setGeoCode(GeoCode geoCode) {
        this.geoCode = geoCode;
    }

    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(Address address) {
        this.address = address;
    }

    @JsonProperty("analytics")
    public Analytics getAnalytics() {
        return analytics;
    }

    @JsonProperty("analytics")
    public void setAnalytics(Analytics analytics) {
        this.analytics = analytics;
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
