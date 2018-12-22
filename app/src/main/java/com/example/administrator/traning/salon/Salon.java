package com.example.administrator.traning.salon;

import java.util.List;

public class Salon {

    public String id;

    public String userSalon;

    public String name_salon;

    public String phone;

    public String address;

    public String city;

    public String description;

    public String openingHours;

    public String locationLat;

    public String locationLon;

    public List<String> image_salon = null;

    public Relationships relationships;

    public Relationships getRelationships() {
        return relationships;
    }

    public void setRelationships(Relationships relationships) {
        this.relationships = relationships;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserSalon() {
        return userSalon;
    }

    public void setUserSalon(String userSalon) {
        this.userSalon = userSalon;
    }

    public String getName_salon() {
        return name_salon;
    }

    public void setName_salon(String name_salon) {
        this.name_salon = name_salon;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public String getLocationLat() {
        return locationLat;
    }

    public void setLocationLat(String locationLat) {
        this.locationLat = locationLat;
    }

    public String getLocationLon() {
        return locationLon;
    }

    public void setLocationLon(String locationLon) {
        this.locationLon = locationLon;
    }

    public List<String> getImage_salon() {
        return image_salon;
    }

    public void setImage_salon(List<String> image_salon) {
        this.image_salon = image_salon;
    }

    public Salon(){}

    public Salon(String id, String userSalon, String name_salon, String phone, String address, String city, String description, String openingHours, String locationLat, String locationLon, List<String> image_salon, Relationships relationships) {
        this.id = id;
        this.userSalon = userSalon;
        this.name_salon = name_salon;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.description = description;
        this.openingHours = openingHours;
        this.locationLat = locationLat;
        this.locationLon = locationLon;
        this.image_salon = image_salon;
        this.relationships = relationships;
    }
}
