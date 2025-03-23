package test.api.project.model;

public class Motor {
    private Long id;
    private String name;
    private String brand;
    private String color;
    private int year;
    
    public Motor(Long id, String name, String brand, String color, int year) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
