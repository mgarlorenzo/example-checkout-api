package org.test.checkout.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.test.checkout.model.Cart;
import org.test.checkout.model.Item;
import org.test.checkout.model.LineItem;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CartRepository {

    private static final Logger log = LoggerFactory.getLogger(CartRepository.class);

    Cart cart = new Cart();

    public Cart getCart(){ return this.cart; }

    public void clear() {
        cart.clearCart();
    }

    public void addLineItem(LineItem lineItem){ cart.addLineItem(lineItem); }

    public List<LineItem> getLineItem(LineItem lineItem){
        return cart.getLineItems();
    }

    public List<Item> getItems(){return cart.getItems();
    }
}
