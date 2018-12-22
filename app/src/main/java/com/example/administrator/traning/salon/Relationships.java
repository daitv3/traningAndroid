package com.example.administrator.traning.salon;

import java.util.List;

public class Relationships  {
    public List<SalonService> getServices() {
        return services;
    }

    public void setServices(List<SalonService> services) {
        this.services = services;
    }

    public List<SalonService> services = null;

}

