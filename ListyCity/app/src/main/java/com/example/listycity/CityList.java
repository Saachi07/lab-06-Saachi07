package com.example.listycity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects.
 * It provides methods to add, remove, and query cities in the list.
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist.
     *
     * @param city This is a candidate city to add
     * @throws IllegalArgumentException if the city already exists in the list
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities.
     * The list is sorted alphabetically by city name.
     *
     * @return Return the sorted list of cities
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * Checks if a given city exists in the list.
     *
     * @param city The city to search for in the list
     * @return true if the city is in the list, false otherwise
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Removes a city from the list if it exists.
     *
     * @param city The city to remove from the list
     * @throws IllegalArgumentException if the city is not present in the list
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException("City not found in the list");
        }
        cities.remove(city);
    }

    /**
     * Returns the number of cities currently in the list.
     *
     * @return The count of cities in the list
     */
    public int countCities() {
        return cities.size();
    }
}