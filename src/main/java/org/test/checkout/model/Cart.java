package org.test.checkout.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Cart
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-16T10:56:39.111Z[GMT]")


public class Cart {
    @JsonProperty("LineItems")
    @Valid
    private List<LineItem> lineItems = null;

    public Cart() {  }

    public Cart(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public Cart lineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
        return this;
    }

    /**
     * Get lineItems
     * @return lineItems
     **/
    @Schema(description = "")
    @Valid
    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public void addLineItem(LineItem lineItem){
        if (this.lineItems == null) {
            this.lineItems = new ArrayList<LineItem>();
        }
        this.lineItems.stream()
                .filter(a -> a.getItemCode().equals(lineItem.getItemCode())).findFirst()
                .ifPresentOrElse(a -> a.addUnit(),()->{this.lineItems.add(lineItem);});
    }

    public List<Item> getItems(){
        List<Item> items = lineItems.stream()
                .map(a -> a.getItem())
                .collect(Collectors.toList());
        return items;
    }

    public void clearCart(){
        lineItems.clear();
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cart cart = (Cart) o;
        return Objects.equals(this.lineItems, cart.lineItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineItems);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Cart {\n");

        sb.append("    lineItems: ").append(toIndentedString(lineItems)).append("\n");
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
}
