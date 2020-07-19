package ru.itis.grocerystore.dto;


public enum WorkType {
    INTERNSHIP("Internship"), FULL("Full time"), PART("Part time");

    private String name;

    WorkType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}