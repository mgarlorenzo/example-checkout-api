package org.test.checkout.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.test.checkout.model.Item;
import org.test.checkout.model.Rules;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RulesRepository {

    private static final Logger log = LoggerFactory.getLogger(RulesRepository.class);

    private List<Rules> rules = new ArrayList<>();

    public Rules add(Rules rule) {
        rules.add(rule);
        return rule;
    }

    public void replace(List<Rules> rules) {
        this.rules = rules;
    }
    public List<Rules> findAll() {
        return rules;
    }
}
