package com.objectfrontier.training.java.jdbc.model;

public class Address {

    private long id;
    private String street;
    private String city;
    private long postalCode;

    public Address() {}

    public Address(long id) {
        this.id = id;
    }

    public Address(String street, String city, long postalCode) {

        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    public Address(long id, String street, String city, long postalCode) {

        this.id = id;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(long postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + (int) (postalCode ^ (postalCode >>> 32));
        result = prime * result + ((street == null) ? 0 : street.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Address other = (Address) obj;
        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        if (postalCode != other.postalCode)
            return false;
        if (street == null) {
            if (other.street != null)
                return false;
        } else if (!street.equals(other.street))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Address [street=" + street + ", city=" + city + ", postalCode=" + postalCode + "]";
    }
}
