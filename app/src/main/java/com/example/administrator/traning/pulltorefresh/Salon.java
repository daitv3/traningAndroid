package com.example.administrator.traning.pulltorefresh;

import java.util.ArrayList;

public class Salon {
    public String user_salon;
    public String name_salon;
    public String phone;
    public String address;
    public String city;
    public String description;
    public String opening_hours;
    public String location_lat;
    public String location_lon;
    public Relationships relationships;
    public ArrayList<String> image_salon = null;


    public class Relationships {

        public ArrayList<Object> services = null;

    }
}
