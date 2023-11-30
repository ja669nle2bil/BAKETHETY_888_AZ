package com.example.unittests.task2;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static java.util.Collections.EMPTY_SET;
import static org.junit.jupiter.api.Assertions.assertEquals;


/* Zadanie:
D
 */
class CitiesSearchTests {
    private final CitiesSearch citiesSearch = new CitiesSearch();
    @Test
    //step1.1
    public void shouldNotFindAnyCityWhenInputTextIsNull() {
        String inputText = null;
//        when
        Set<String> foundCities = citiesSearch.search(inputText);
//        then
        assertEquals(EMPTY_SET, foundCities);
    }
    //step1.1
    @Test void shouldNotFindAnyCityWhenInputTextIsTooShort() {
        String inputText="B";
//        when
        Set<String> foundCities = citiesSearch.search(inputText);
//        then
        assertEquals(EMPTY_SET, foundCities);
    }
    //step 2:
    @Test
    public void shouldFindCitiesThatStartWithInputText() {
        String inputText ="Va";
        //when
        Set<String> foundCities = citiesSearch.search(inputText);
//        then
        assertEquals(Set.of("Vancouver", "Valencia"), foundCities);
    }
    //step3:
    @Test
    public void shouldFindCitiesIgnoringCaseDifferences() {
        String inputText="vA";
//        when
        Set<String> foundCities = citiesSearch.search(inputText);
//        then
        assertEquals(Set.of("Vancouver", "Valencia"), foundCities);
    }
    //step4: 2 tests>..
    @Test
    public void shouldFindCitiesThatContainInputText() {
        String inputText="ape";
//        when
        Set<String> foundCities = citiesSearch.search(inputText);
//        then
        assertEquals(Set.of("Budapest"), foundCities);
    }
    @Test
    public void shouldFindCitiesThatEdnWithInputText() {
        String inputText="rdam";
//        when
        Set<String> foundCities = citiesSearch.search(inputText);
//        then
        assertEquals(Set.of("Rotterdam", "Amsterdam"), foundCities);
    }
}
