/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FoodOrderingSystem;

/**
 *
 * @author User
 */


public class Food {

    private String name, foodID;
    private double unitPrice;

    public Food(String name, String foodID, double unitPrice) { // contractor 
        this.name = name;
        this.foodID = foodID;
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Food Details: \n" + "name=" + name + "\nfoodID=" + foodID + "\nunitPrice= RM" + unitPrice;
    }

    public String getName() {
        return name;
    }

    public String getFoodID() {
        return foodID;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }
    
    
}//end class