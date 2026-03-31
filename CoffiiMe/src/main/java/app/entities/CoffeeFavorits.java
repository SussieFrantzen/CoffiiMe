package app.entities;

import java.util.Objects;

public class CoffeeFavorits {
    private int user_id;
    private String coffeetype;
    private int milk;
    private int water;
    private int bean;
    private String brand;

    public CoffeeFavorits(int user_id, String coffeetype, int milk, int water, int bean, String brand) {
        this.user_id = user_id;
        this.coffeetype = coffeetype;
        this.milk = milk;
        this.water = water;
        this.bean = bean;
        this.brand = brand;
    }


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getCoffeetype() {
        return coffeetype;
    }

    public void setCoffeetype(String coffeetype) {
        this.coffeetype = coffeetype;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getBeans() {
        return bean;
    }

    public void setBeans(int beans) {
        this.bean = beans;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CoffeeFavorits that = (CoffeeFavorits) o;
        return user_id == that.user_id && milk == that.milk && water == that.water && bean == that.bean && Objects.equals(coffeetype, that.coffeetype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, coffeetype, milk, water, bean);
    }
}
