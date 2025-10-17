package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    // ==================== NEW TESTS ====================

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        City edmontonCity = new City("Edmonton", "Alberta");

        // Test that the city is found (using equals/hashCode)
        assertTrue(cityList.hasCity(edmontonCity));

        // Test that a city not in the list is not found
        City calgaryCity = new City("Calgary", "Alberta");
        assertFalse(cityList.hasCity(calgaryCity));
    }

    @Test
    void testHasCityEmptyList() {
        CityList cityList = new CityList();
        City city = new City("Vancouver", "British Columbia");

        // Test that hasCity returns false for empty list
        assertFalse(cityList.hasCity(city));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        City edmontonCity = new City("Edmonton", "Alberta");

        // Verify city exists before deletion
        assertTrue(cityList.hasCity(edmontonCity));
        assertEquals(1, cityList.countCities());

        // Delete the city
        cityList.delete(edmontonCity);

        // Verify city no longer exists after deletion
        assertFalse(cityList.hasCity(edmontonCity));
        assertEquals(0, cityList.countCities());
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        City city = new City("Toronto", "Ontario");

        // Test that exception is thrown when trying to delete a city not in the list
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

    @Test
    void testDeleteMultipleCities() {
        CityList cityList = new CityList();
        City city1 = new City("Edmonton", "Alberta");
        City city2 = new City("Calgary", "Alberta");
        City city3 = new City("Vancouver", "British Columbia");

        cityList.add(city1);
        cityList.add(city2);
        cityList.add(city3);

        assertEquals(3, cityList.countCities());

        // Delete middle city
        cityList.delete(city2);
        assertEquals(2, cityList.countCities());
        assertFalse(cityList.hasCity(city2));
        assertTrue(cityList.hasCity(city1));
        assertTrue(cityList.hasCity(city3));
    }

    @Test
    void testCountCities() {
        CityList cityList = new CityList();

        // Test empty list
        assertEquals(0, cityList.countCities());

        // Add one city
        City city1 = new City("Edmonton", "Alberta");
        cityList.add(city1);
        assertEquals(1, cityList.countCities());

        // Add second city
        City city2 = new City("Calgary", "Alberta");
        cityList.add(city2);
        assertEquals(2, cityList.countCities());

        // Add third city
        City city3 = new City("Vancouver", "British Columbia");
        cityList.add(city3);
        assertEquals(3, cityList.countCities());
    }

    @Test
    void testCountCitiesAfterDelete() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.countCities());

        cityList.delete(city);
        assertEquals(1, cityList.countCities());
    }
}