package org.test.checkout.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.test.checkout.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ItemRepository {

    private static final Logger log = LoggerFactory.getLogger(ItemRepository.class);

    private List<Item> items = new ArrayList<>();

    public Item add(Item item) {
         items.add(item);
        return item;
    }

    public Item findById(String rfid) {
        Optional<Item> item = items.stream().filter(a -> a.getRfid().equals(rfid)).findFirst();
        if (item.isPresent())
            return item.get();
        else
            return null;
    }

    public List<Item> findAll() {
        return items;
    }

    public boolean contains(Item item){
        if (items.contains(item)){
            return true;
        }
        return false;
    }

}
