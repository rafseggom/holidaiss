
package aiss.model.tomtom;

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
    "topLeftPoint",
    "btmRightPoint"
})
public class BoundingBox {

    @JsonProperty("topLeftPoint")
    private TopLeftPoint_ topLeftPoint;
    @JsonProperty("btmRightPoint")
    private BtmRightPoint_ btmRightPoint;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("topLeftPoint")
    public TopLeftPoint_ getTopLeftPoint() {
        return topLeftPoint;
    }

    @JsonProperty("topLeftPoint")
    public void setTopLeftPoint(TopLeftPoint_ topLeftPoint) {
        this.topLeftPoint = topLeftPoint;
    }

    @JsonProperty("btmRightPoint")
    public BtmRightPoint_ getBtmRightPoint() {
        return btmRightPoint;
    }

    @JsonProperty("btmRightPoint")
    public void setBtmRightPoint(BtmRightPoint_ btmRightPoint) {
        this.btmRightPoint = btmRightPoint;
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
