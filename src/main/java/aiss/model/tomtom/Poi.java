
package aiss.model.tomtom;

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
    "name",
    "phone",
    "brands",
    "categorySet",
    "categories",
    "classifications"
})
public class Poi {

    @JsonProperty("name")
    private String name;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("brands")
    private List<Brand> brands = null;
    @JsonProperty("categorySet")
    private List<CategorySet> categorySet = null;
    @JsonProperty("categories")
    private List<String> categories = null;
    @JsonProperty("classifications")
    private List<Classification> classifications = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("brands")
    public List<Brand> getBrands() {
        return brands;
    }

    @JsonProperty("brands")
    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }

    @JsonProperty("categorySet")
    public List<CategorySet> getCategorySet() {
        return categorySet;
    }

    @JsonProperty("categorySet")
    public void setCategorySet(List<CategorySet> categorySet) {
        this.categorySet = categorySet;
    }

    @JsonProperty("categories")
    public List<String> getCategories() {
        return categories;
    }

    @JsonProperty("categories")
    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    @JsonProperty("classifications")
    public List<Classification> getClassifications() {
        return classifications;
    }

    @JsonProperty("classifications")
    public void setClassifications(List<Classification> classifications) {
        this.classifications = classifications;
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
