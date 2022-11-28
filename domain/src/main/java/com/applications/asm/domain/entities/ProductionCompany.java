package com.applications.asm.domain.entities;

public class ProductionCompany {
    private final String nameCompany;
    private final String imageCompany;

    public ProductionCompany(String nameCompany, String imageCompany) {
        this.nameCompany = nameCompany;
        this.imageCompany = imageCompany;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public String getImageCompany() {
        return imageCompany;
    }
}
