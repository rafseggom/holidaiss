
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
    "id",
    "rateCode",
    "rateFamilyEstimated",
    "boardType",
    "room",
    "guests",
    "price",
    "policies"
})
public class Offer {

    @JsonProperty("id")
    private String id;
    @JsonProperty("rateCode")
    private String rateCode;
    @JsonProperty("rateFamilyEstimated")
    private RateFamilyEstimated rateFamilyEstimated;
    @JsonProperty("boardType")
    private String boardType;
    @JsonProperty("room")
    private Room room;
    @JsonProperty("guests")
    private Guests guests;
    @JsonProperty("price")
    private Price price;
    @JsonProperty("policies")
    private Policies policies;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("rateCode")
    public String getRateCode() {
        return rateCode;
    }

    @JsonProperty("rateCode")
    public void setRateCode(String rateCode) {
        this.rateCode = rateCode;
    }

    @JsonProperty("rateFamilyEstimated")
    public RateFamilyEstimated getRateFamilyEstimated() {
        return rateFamilyEstimated;
    }

    @JsonProperty("rateFamilyEstimated")
    public void setRateFamilyEstimated(RateFamilyEstimated rateFamilyEstimated) {
        this.rateFamilyEstimated = rateFamilyEstimated;
    }

    @JsonProperty("boardType")
    public String getBoardType() {
        return boardType;
    }

    @JsonProperty("boardType")
    public void setBoardType(String boardType) {
        this.boardType = boardType;
    }

    @JsonProperty("room")
    public Room getRoom() {
        return room;
    }

    @JsonProperty("room")
    public void setRoom(Room room) {
        this.room = room;
    }

    @JsonProperty("guests")
    public Guests getGuests() {
        return guests;
    }

    @JsonProperty("guests")
    public void setGuests(Guests guests) {
        this.guests = guests;
    }

    @JsonProperty("price")
    public Price getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Price price) {
        this.price = price;
    }

    @JsonProperty("policies")
    public Policies getPolicies() {
        return policies;
    }

    @JsonProperty("policies")
    public void setPolicies(Policies policies) {
        this.policies = policies;
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
