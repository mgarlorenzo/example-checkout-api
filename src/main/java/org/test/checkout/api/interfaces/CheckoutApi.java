/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.25).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package org.test.checkout.api.interfaces;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;
import org.test.checkout.model.Amount;
import org.test.checkout.model.Cart;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-16T11:06:41.877Z[GMT]")
@Validated
public interface CheckoutApi {

    @Operation(summary = "adds item to the cart", description = "Adds an item to the cart", tags={ "checkout process" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "item added to the cart"),
        
        @ApiResponse(responseCode = "400", description = "invalid input, object invalid"),
        
        @ApiResponse(responseCode = "409", description = "an existing item already exists") })
    @RequestMapping(value = "/checkout/items/",
        consumes = { "text/plain" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> addCartItem(@Parameter(in = ParameterIn.DEFAULT, description = "RFID of item to add.", schema=@Schema()) @Valid @RequestBody String body);


    @Operation(summary = "Get total amount", description = "Get total amount", tags={ "checkout process" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(schema = @Schema(implementation = Amount.class))),
        
        @ApiResponse(responseCode = "400", description = "bad input parameter") })
    @RequestMapping(value = "/checkout/previeworder/",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Amount> getAmount();


    @Operation(summary = "Return all items in the cart", description = "Return all item in the cart", tags={ "checkout process" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Cart.class)))),
        
        @ApiResponse(responseCode = "400", description = "bad input parameter") })
    @RequestMapping(value = "/checkout/items/",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Cart> getCartItems();

}
