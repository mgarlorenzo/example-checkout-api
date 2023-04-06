package org.test.checkout.usecase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.test.checkout.model.Amount;
import org.test.checkout.model.Cart;
import org.test.checkout.model.LineItem;
import org.test.checkout.model.Rules;
import org.test.checkout.model.TypeEnum;
import org.test.checkout.repository.CartRepository;
import org.test.checkout.repository.RulesRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class ApplyDiscount {
    private static final Logger log = LoggerFactory.getLogger(ApplyDiscount.class);

    public Amount getAmmount(Cart cart, List<Rules> rules){
        Amount amount = new Amount(getTotal(cart.getLineItems()), getTotalWithDiscount(cart.getLineItems(),rules));
        return amount;
    }

    private BigDecimal getTotal(List<LineItem> lineItems){
        BigDecimal total = BigDecimal.ZERO;

        for(LineItem lineItem:lineItems){
            total = total.add(getTotalAmount(lineItem.getItem().getPrice(),new BigDecimal(lineItem.getQuantity())));
        }

        return total;
    }

    private BigDecimal getTotalWithDiscount(List<LineItem> lineItems, List<Rules> rules){
        BigDecimal totalWithDiscount = BigDecimal.ZERO;
        for(LineItem lineItem:lineItems){
            BigDecimal quantity = new BigDecimal(lineItem.getQuantity());
            Rules rule = findRule(lineItem.getItemCode(),rules);
            if (rule != null) {
                if(rule.getType() == TypeEnum.QTY){
                        if(lineItem.getQuantity() >= rule.getMinitems()){
                            totalWithDiscount =   totalWithDiscount.add(getTotalAmount(rule.getDiscount(),quantity));
                        }else{
                            totalWithDiscount = totalWithDiscount.add(getTotalAmount(lineItem.getItem().getPrice(),quantity));
                        }
                }else if(rule.getType() == TypeEnum.FIFTY) {
                    if (lineItem.getQuantity() % 2 == 0 && lineItem.getQuantity() > 1) {
                        BigDecimal priceDiscount = lineItem.getItem().getPrice();
                        priceDiscount = priceDiscount.divide(new BigDecimal(2));
                        totalWithDiscount = totalWithDiscount.add(getTotalAmount(priceDiscount,quantity));
                    } else if (lineItem.getQuantity() > 1) {
                        BigDecimal priceDiscount = lineItem.getItem().getPrice().divide(new BigDecimal(2));
                        totalWithDiscount = totalWithDiscount.add(lineItem.getItem().getPrice());
                        totalWithDiscount = totalWithDiscount.add(getTotalAmount(priceDiscount,quantity.min(new BigDecimal(1))));

                    }else{
                        totalWithDiscount =  totalWithDiscount.add(lineItem.getItem().getPrice());
                    }
                }
            }else{
                BigDecimal price = lineItem.getItem().getPrice();
                price = price.multiply(quantity);
                totalWithDiscount =  totalWithDiscount.add(price);
            }
        }
        return totalWithDiscount;
    }

    public Rules findRule(String code, List<Rules> rules) {
        Optional<Rules> rule = rules.stream().filter(a -> a.getCode().equals(code)).findFirst();
        if (rule.isPresent())
            return rule.get();
        else
            return null;
    }

    private BigDecimal getTotalAmount(BigDecimal price, BigDecimal quantity){
        return price.multiply(quantity);
    }

}
