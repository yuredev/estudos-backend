package models;

public class Product {
    private String name;
    private String decription;
    private Integer id;
    private Double price;

    public Product(String name, String description, Integer id, Double price) {
        this.name = name;
        this.decription = description;
        this.id = id;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", decription='" + decription + '\'' +
                ", id=" + id +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}