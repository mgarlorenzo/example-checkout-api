package org.test.checkout.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * Amount
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-16T09:44:11.302Z[GMT]")


public class Amount   {
  @JsonProperty("total")
  private BigDecimal total = null;

  @JsonProperty("totalWithDiscount")
  private BigDecimal totalWithDiscount = null;

  public Amount(BigDecimal total, BigDecimal totalWithDiscount) {
    this.total = total;
    this.totalWithDiscount = totalWithDiscount;
  }

  public Amount total(BigDecimal total) {
    this.total = total;
    return this;
  }

  /**
   * Get total
   * @return total
   **/
  @Schema(example = "50", description = "")
  
    @Valid
    public BigDecimal getTotal() {
    return total;
  }

  public void setTotal(BigDecimal total) {
    this.total = total;
  }

  public Amount totalBefore(BigDecimal totalBefore) {
    this.totalWithDiscount = totalBefore;
    return this;
  }

  /**
   * Get totalBefore
   * @return totalBefore
   **/
  @Schema(example = "75", description = "")
  
    @Valid
    public BigDecimal getTotalWithDiscount() {
    return totalWithDiscount;
  }

  public void setTotalWithDiscount(BigDecimal totalWithDiscount) {
    this.totalWithDiscount = totalWithDiscount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Amount amount = (Amount) o;
    return Objects.equals(this.total, amount.total) &&
        Objects.equals(this.totalWithDiscount, amount.totalWithDiscount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(total, totalWithDiscount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Amount {\n");
    
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    totalBefore: ").append(toIndentedString(totalWithDiscount)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
