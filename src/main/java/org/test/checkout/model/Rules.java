package org.test.checkout.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Rules
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-16T08:33:17.576Z[GMT]")


public class Rules   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("code")
  private String code = null;

  @JsonProperty("type")
  private TypeEnum type = null;

  @JsonProperty("discount")
  private BigDecimal discount = null;

  @JsonProperty("minitems")
  private Integer minitems = null;

  public Rules(Integer id, String name, String code, TypeEnum type, BigDecimal discount, Integer minitems) {
    this.id = id;
    this.name = name;
    this.code = code;
    this.type = type;
    this.discount = discount;
    this.minitems = minitems;
  }

  public Rules id(Integer id) {
    this.id = id;
    return this;
  }


  /**
   * Get id
   * @return id
   **/
  @Schema(example = "1", required = true, description = "")
  @NotNull

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Rules name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  @Schema(example = "A 2 for1 special on VOUCHER items", required = true, description = "")
  @NotNull

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Rules code(String code) {
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

  public Rules type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   **/
  @Schema(example = "Widget Adapter", required = true, description = "")
  @NotNull

  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public Rules discount(BigDecimal discount) {
    this.discount = discount;
    return this;
  }

  /**
   * Get discount
   * @return discount
   **/
  @Schema(example = "5", required = true, description = "")
  @NotNull

  @Valid
  public BigDecimal getDiscount() {
    return discount;
  }

  public void setDiscount(BigDecimal discount) {
    this.discount = discount;
  }

  public Rules minitems(Integer minitems) {
    this.minitems = minitems;
    return this;
  }

  /**
   * Get minitems
   * @return minitems
   **/
  @Schema(example = "1", required = true, description = "")
  @NotNull

  public Integer getMinitems() {
    return minitems;
  }

  public void setMinitems(Integer minitems) {
    this.minitems = minitems;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Rules rules = (Rules) o;
    return Objects.equals(this.id, rules.id) &&
            Objects.equals(this.name, rules.name) &&
            Objects.equals(this.code, rules.code) &&
            Objects.equals(this.type, rules.type) &&
            Objects.equals(this.discount, rules.discount) &&
            Objects.equals(this.minitems, rules.minitems);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, code, type, discount, minitems);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Rules {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    discount: ").append(toIndentedString(discount)).append("\n");
    sb.append("    minitems: ").append(toIndentedString(minitems)).append("\n");
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
