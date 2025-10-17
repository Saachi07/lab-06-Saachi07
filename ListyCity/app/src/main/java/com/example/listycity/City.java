package com.example.listycity;

/**
 * This is a class that defines a City.
 * Each city has a name and a province, and cities can be compared alphabetically by name.
 */
public class City implements Comparable {
    private String city;
    private String province;

    /**
     * Constructs a new City with the specified name and province.
     *
     * @param city The name of the city
     * @param province The name of the province where the city is located
     */
    City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * Gets the name of the city.
     *
     * @return The city name
     */
    String getCityName() {
        return this.city;
    }

    /**
     * Gets the name of the province.
     *
     * @return The province name
     */
    String getProvinceName() {
        return this.province;
    }

    /**
     * Compares this city to another city alphabetically by city name.
     *
     * @param o The object to compare to (should be a City object)
     * @return A negative integer, zero, or a positive integer as this city's name
     *         is less than, equal to, or greater than the specified city's name
     */
    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * Two cities are considered equal if they have the same city name and province name.
     *
     * @param obj The reference object with which to compare
     * @return true if this object is the same as the obj argument; false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        City other = (City) obj;
        if (this.city == null || other.city == null) return false;
        if (this.province == null || other.province == null) return false;
        return this.city.equals(other.city) && this.province.equals(other.province);
    }

    /**
     * Returns a hash code value for the object.
     * This method is supported for the benefit of hash tables.
     *
     * @return A hash code value for this object
     */
    @Override
    public int hashCode() {
        if (city == null || province == null) return 0;
        int result = city.hashCode();
        result = 31 * result + province.hashCode();
        return result;
    }
}