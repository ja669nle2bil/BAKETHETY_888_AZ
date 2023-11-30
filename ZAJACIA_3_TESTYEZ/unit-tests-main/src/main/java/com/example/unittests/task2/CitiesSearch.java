package com.example.unittests.task2;

import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

class CitiesSearch {
//task 2-11
    private static final Set<String> AVAILABLE_CITIES = Set.of(
        "Paris",
        "Budapest",
        "Skopje",
        "Rotterdam",
        "Valencia",
        "Vancouver",
        "Amsterdam",
        "Vienna",
        "Sydney",
        "New York City",
        "London",
        "Bangkok",
        "Hong Kong",
        "Dubai",
        "Rome",
        "Istanbul"
);
    //step 1.1
    Set<String> search(String inputText) {
        //      step1.1
        //        throw new RuntimeException("Not implemented yet");

        //  step 1.2
        if(inputText == null || inputText.length()<2){
            return Set.of();
        }
        //  step 1.2
//        return AVAILABLE_CITIES;

        //  step 2
        return AVAILABLE_CITIES.stream()
//                .filter(city -> city.startsWith(inputText))
//                .collect(toSet());

//        step 3
                .filter(city -> city.toLowerCase().startsWith(inputText.toLowerCase()))
                    .collect(toSet());
    }
}
