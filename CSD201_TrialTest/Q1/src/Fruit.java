/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class Fruit {
    private String type;
    private  int amount;
    private int price;

    public Fruit(String type, int amount, int price) {
        this.type = type;
        this.amount = amount;
        this.price = price;
    }
    
    public Fruit(String type, int amount) {
        this.type = type;
        this.amount = amount;
        this.price = 0;
    }

    public Fruit() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public String toString(){
        return "("+type+","+amount+","+price+")";
    }
}
