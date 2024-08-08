package com.example.planetsapp;

// This acts as the model class for our ListView

public class Planet {
    private String planetName;
    private String moonCount;

    private int planetImage;

    // constructor allows to instantiate objects of that class

    public Planet(String planetName, String moonCount, int planetImage) {
        this.planetName = planetName;
        this.moonCount = moonCount;
        this.planetImage = planetImage;
    }

    // getters and setters
    // getters allows other parts of code to retrieve the values stored
    //setters update the values

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public String getMoonCount() {
        return moonCount;
    }

    public void setMoonCount(String moonCount) {
        this.moonCount = moonCount;
    }

    public int getPlanetImage() {
        return planetImage;
    }

    public void setPlanetImage(int planetImage) {
        this.planetImage = planetImage;
    }


}







