
package aiss.model.mapbox;

import java.util.HashMap;
import java.util.List;
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
    "type",
    "place_type",
    "relevance",
    "properties",
    "text",
    "place_name",
    "bbox",
    "center",
    "geometry",
    "context",
    "matching_text",
    "matching_place_name"
})
public class Feature {

    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("place_type")
    private List<String> place_type = null;
    @JsonProperty("relevance")
    private Integer relevance;
    @JsonProperty("properties")
    private Properties properties;
    @JsonProperty("text")
    private String text;
    @JsonProperty("place_name")
    private String place_name;
    @JsonProperty("bbox")
    private List<Double> bbox = null;
    @JsonProperty("center")
    private List<Double> center = null;
    @JsonProperty("geometry")
    private Geometry geometry;
    @JsonProperty("context")
    private List<Context> context = null;
    @JsonProperty("matching_text")
    private String matching_text;
    @JsonProperty("matching_place_name")
    private String matching_place_name;
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

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("place_type")
    public List<String> getPlace_type() {
        return place_type;
    }

    @JsonProperty("place_type")
    public void setPlace_type(List<String> place_type) {
        this.place_type = place_type;
    }

    @JsonProperty("relevance")
    public Integer getRelevance() {
        return relevance;
    }

    @JsonProperty("relevance")
    public void setRelevance(Integer relevance) {
        this.relevance = relevance;
    }

    @JsonProperty("properties")
    public Properties getProperties() {
        return properties;
    }

    @JsonProperty("properties")
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("place_name")
    public String getPlace_name() {
        return place_name;
    }

    @JsonProperty("place_name")
    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    @JsonProperty("bbox")
    public List<Double> getBbox() {
        return bbox;
    }

    @JsonProperty("bbox")
    public void setBbox(List<Double> bbox) {
        this.bbox = bbox;
    }

    @JsonProperty("center")
    public List<Double> getCenter() {
        return center;
    }

    @JsonProperty("center")
    public void setCenter(List<Double> center) {
        this.center = center;
    }

    @JsonProperty("geometry")
    public Geometry getGeometry() {
        return geometry;
    }

    @JsonProperty("geometry")
    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    @JsonProperty("context")
    public List<Context> getContext() {
        return context;
    }

    @JsonProperty("context")
    public void setContext(List<Context> context) {
        this.context = context;
    }

    @JsonProperty("matching_text")
    public String getMatching_text() {
        return matching_text;
    }

    @JsonProperty("matching_text")
    public void setMatching_text(String matching_text) {
        this.matching_text = matching_text;
    }

    @JsonProperty("matching_place_name")
    public String getMatching_place_name() {
        return matching_place_name;
    }

    @JsonProperty("matching_place_name")
    public void setMatching_place_name(String matching_place_name) {
        this.matching_place_name = matching_place_name;
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
