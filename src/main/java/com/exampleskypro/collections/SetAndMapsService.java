package com.exampleskypro.collections;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SetAndMapsService {
    List<Integer> nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7));
    public List<Integer> oddNumber(List <Integer> lists) {
        List <Integer> oddNumbers = new ArrayList<>(nums);
            for (Integer i : oddNumbers){
                System.out.println(i);
            }
            return oddNumbers;
    }



}
