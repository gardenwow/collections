package com.exampleskypro.collections;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ServiceStore {

    private final Map<Integer, Item> items1 = new HashMap<>();
    private final Basket basket;

    public ServiceStore(Basket basket) {
        this.basket = basket;

    }

    @PostConstruct
    public void setup(){
        items1.put(1, new Item(1, "banan", 25_000));
        items1.put(2, new Item(2, "samsung", 1_000));
        items1.put(3, new Item(3, "orbit", 500));
        items1.put(4, new Item(4, "icecream", 150));
        items1.put(5, new Item(5, "poco", 12_000));
    }


    public List<Item> getItems() {
        return basket.getItems();
    }

    // 1 1 1 1 4
    public void add(List<Integer> ids){
        basket.add(ids.stream()
                .map(items1::get)
                .collect(Collectors.toList()));
    }
}
