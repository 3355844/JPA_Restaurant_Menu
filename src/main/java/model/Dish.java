package model;

import javax.persistence.*;

/**
 * Created by 33558 on 11.02.2017.
 */
@Entity
@Table(name = "MENU")
@NamedQueries({
        @NamedQuery(name = "menu.getAll", query = "SELECT d FROM Dish d"),
        @NamedQuery(name = "menu.getAllWithDiscount", query = "SELECT d FROM Dish d WHERE d.discountDish = true"),
        @NamedQuery(name = "menu.getFromTo", query = "SELECT d FROM Dish d WHERE d.priceDish >= :priceFrom and d.priceDish <= :priceTo")
})
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;
    @Column(name = "NAME")
    private String nameDish;
    @Column(name = "PRICE")
    private double priceDish;
    @Column(name = "WEIGHT")
    private double weightDish;
    @Column(name = "DISCOUNT")
    private boolean discountDish;

    @Override
    public String toString() {
        return "Dish{" +
                "nameDish='" + nameDish + '\'' +
                ", priceDish=" + priceDish +
                ", weightDish=" + weightDish +
                ", discountDish=" + discountDish +
                '}' + '\n';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameDish() {
        return nameDish;
    }

    public void setNameDish(String nameDish) {
        this.nameDish = nameDish;
    }

    public double getPriceDish() {
        return priceDish;
    }

    public void setPriceDish(double priceDish) {
        this.priceDish = priceDish;
    }

    public double getWeightDish() {
        return weightDish;
    }

    public void setWeightDish(double weightDish) {
        this.weightDish = weightDish;
    }

    public boolean isDiscountDish() {
        return discountDish;
    }

    public void setDiscountDish(boolean discountDish) {
        this.discountDish = discountDish;
    }

    public Dish(String nameDish, double priceDish, double weightDish, boolean discountDish) {
        this.nameDish = nameDish;
        this.priceDish = priceDish;
        this.weightDish = weightDish;
        this.discountDish = discountDish;
    }

    public Dish() {
    }
}
