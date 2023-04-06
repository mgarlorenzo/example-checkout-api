package org.test.checkout.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * LineItem
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-16T10:56:39.111Z[GMT]")



public class LineItem {

    @JsonProperty("Item")
    private Item item = null;

    @JsonProperty("quantity")
    private Integer quantity = null;

    public LineItem(Item item, Integer quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public LineItem item(Item item) {
        this.item = item;
        return this;
    }

    /**
     * Get item
     * @return item
     **/
    @Schema(description = "")

    @Valid
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public LineItem quantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    /**
     * Get quantity
     * @return quantity
     **/
    @Schema(example = "5", description = "")

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LineItem lineItem = (LineItem) o;
        return Objects.equals(this.item, lineItem.item) &&
                Objects.equals(this.quantity, lineItem.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, quantity);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LineItem {\n");

        sb.append("    item: ").append(toIndentedString(item)).append("\n");
        sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    public void addUnit(){
        this.quantity++;
    }

    public String getItemCode(){ return item.getCode(); }

}
