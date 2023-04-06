package org.test.checkout.api.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.test.checkout.api.interfaces.CheckoutApi;
import org.test.checkout.model.Amount;
import org.test.checkout.model.Cart;
import org.test.checkout.model.Item;
import org.test.checkout.model.LineItem;
import org.test.checkout.repository.CartRepository;
import org.test.checkout.repository.ItemRepository;
import org.test.checkout.repository.RulesRepository;
import org.test.checkout.usecase.ApplyDiscount;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-16T09:51:14.580Z[GMT]")
@RestController
public class CheckoutApiController implements CheckoutApi {

    private static final Logger log = LoggerFactory.getLogger(CheckoutApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    RulesRepository rRepository;

    @Autowired
    ItemRepository iRepository;

    @Autowired
    CartRepository cRepository;

    @org.springframework.beans.factory.annotation.Autowired
    public CheckoutApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addCartItem(@Parameter(in = ParameterIn.DEFAULT, description = "RFID of item to add.", schema=@Schema()) @Valid @RequestBody String body) {
        String accept = request.getHeader("Accept");
        Item item = iRepository.findById(body);
        if(item != null){
            cRepository.addLineItem(new LineItem(item,1));
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Amount> getAmount() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                ApplyDiscount applyDiscount = new ApplyDiscount();
                return new ResponseEntity<Amount>(applyDiscount.getAmmount(cRepository.getCart(), rRepository.findAll()), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Amount>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Amount>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Cart> getCartItems() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Cart>(cRepository.getCart(), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Cart>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Cart>(HttpStatus.NOT_IMPLEMENTED);
    }

}
