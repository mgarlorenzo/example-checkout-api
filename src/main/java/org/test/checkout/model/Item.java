package org.test.checkout.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import javax.validation.Valid;
import javax.validation.constraints.*;

public class Item {
    @JsonProperty("rfid")
    private String rfid = null;

    @JsonProperty("code")
    private String code = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("price")
    private BigDecimal price = null;

    public Item(String rfid, String code, String name, BigDecimal price) {
        this.rfid = rfid;
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public Item(String rfid) {
        this.rfid = rfid;
    }

    public Item rfid(String rfid) {
        this.rfid = rfid;
        return this;
    }

    /**
     * Get rfid
     * @return rfid
     **/
    @Schema(example = "d290f1ee-6c54-4b01-90e6-d701748f0851", required = true, description = "")

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public Item code(String code) {
        this.code = code;
        return this;
    }

    /**
     * Get code
     * @return code
     **/
    @Schema(example = "Widget Adapter", required = true, description = "")
    @NotNull

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Item name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     * @return name
     **/
    @Schema(example = "Widget Adapter", required = true, description = "")
    @NotNull

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item price(BigDecimal price) {
        this.price = price;
        return this;
    }

    /**
     * Get price
     * @return price
     **/
    @Schema(example = "5", required = true, description = "")
    @NotNull

    @Valid
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return Objects.equals(this.rfid, item.rfid) &&
                Objects.equals(this.code, item.code) &&
                Objects.equals(this.name, item.name) &&
                Objects.equals(this.price, item.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rfid, code, name, price);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Item {\n");

        sb.append("    rfid: ").append(toIndentedString(rfid)).append("\n");
        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    price: ").append(toIndentedString(price)).append("\n");
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
