package com.exampleskypro.collections;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class BasketContr {
   private  final ServiceStore serviceStore;

    public BasketContr(ServiceStore serviceStore) {
        this.serviceStore = serviceStore;
    }

    @GetMapping("/add")
    public void add(@RequestParam("id")List<Integer> id) {
        serviceStore.add(id);
    }
    @GetMapping("/get")
    public  List <Item> get(){
        return serviceStore.getItems();
    }
}
