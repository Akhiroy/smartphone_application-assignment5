package com.example.cord;


public class Country {
    private String name;
    private int population;
    private int flagResId;
    private String url; // Link associated with the country

    public Country(String name, int population, int flagResId, String url) {
        this.name = name;
        this.population = population;
        this.flagResId = flagResId;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getFlagResId() {
        return flagResId;
    }

    public String getUrl() {
        return url;
    }
}


