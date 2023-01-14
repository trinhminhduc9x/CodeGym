package Ss12_Java_collection_Framework.exercise.model;

import java.util.Objects;

public class Product {
    private int Id;
    private String Name;
    private int Cost;

    public Product() {
    }

    public Product(int id) {
        Id = id;
    }

    public Product(int id, String name, int cost) {
        Id = id;
        Name = name;
        Cost = cost;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getCost() {
        return Cost;
    }

    public void setCost(int cost) {
        Cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Id == product.Id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Cost=" + Cost +
                '}';
    }
}
