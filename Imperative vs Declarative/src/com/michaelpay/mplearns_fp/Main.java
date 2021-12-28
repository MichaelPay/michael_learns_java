package com.michaelpay.mplearns_fp;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        List<String> ingredients = Arrays.asList(
                "flour",
                "salt",
                "baking powder",
                "butter",
                "eggs",
                "milk"
        );
/*Imperative way of programming: */
//        boolean hasEggs = false;
//        for (String ingredient : ingredients) {
//            if (ingredient.equals("eggs")) {
//                hasEggs = true;
//                break;
//            }
//        }
//        if (hasEggs) {
//            System.out.println("Sorry, has eggs!");
//        }

/*Declarative way of programming:*/
//        if (ingredients.contains("eggs")) {
//            System.out.println("Sorry, has eggs!");
//        }
        ingredients.forEach(System.out::println);
    }
}