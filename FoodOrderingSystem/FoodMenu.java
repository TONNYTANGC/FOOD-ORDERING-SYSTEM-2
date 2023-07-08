/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FoodOrderingSystem;

/**
 *
 * @author User
 */
public class FoodMenu {

    private Food[] food;
    private int count;

    public FoodMenu(int n) {
        food = new Food[n];
        count = 0;
    }

    public void addFood(String name, String foodID, double unitPrice) {
        food[count] = new Food(name, foodID, unitPrice);
        count++;

    }

    public boolean isEmpty() {
        boolean containNull = true;

        for (int i = 0; i < food.length; i++) {
            if (food[i] != null) {
                containNull = false;

            } else if (food[i] == null) {
                containNull = true;
            }
        }
        return containNull;
    }

    public boolean isArrayNull() {
        if (food == null) {
            return true;
        } else if (food.length == 0) {
            return true;
        } else {
            for (Food f : food) {
                if (f != null) {
                    return false;
                }
            }
            return true;
        }
    }

    public void searchFood(String ID) {
        int i = 0;

        while (food[i] != null && !food[i].getFoodID().equals(ID)) {
            i++;
        }
        if (food[i] == null) {
            //not found - unsuccessful search
            System.out.println("FOOD ID: " + ID + " DOES NOT FOUND.");
            System.out.println(" ");
        } else {
            //found - successful search
            System.out.println(food[i].toString());
        }

    }

    public void deleteFood(String ID) {
        int i = 0;

        while (food[i] != null && !food[i].getFoodID().equals(ID)) {
            i++;
        }
        if (food[i] == null) {
            //not found - unsuccessful search
            System.out.println("FOOD ID: " + ID + " DOES NOT FOUND.");
            System.out.println(" ");
        } else {
            //found - successful search
            food[i] = food[i + 1];
//            food[count] = null;
            count--;
            System.out.println("FOOD ID: " + ID + "HAD BEEN DELETED.");

        }

    }

    public void updateFood(String ID, String name, String foodID, double unitPrice) {
        int i = 0;

        while (food[i] != null && !food[i].getFoodID().equals(ID)) {
            i++;
        }
        if (food[i] == null) {
            //not found - unsuccessful search
            System.out.println("FOOD ID: " + ID + " DOES NOT FOUND.");
            System.out.println(" ");
        } else {
            //found - successful search
            food[i].setName(name);
            food[i].setFoodID(foodID);
            food[i].setUnitPrice(unitPrice);
            System.out.println("UPDATE DETAILS FOR ID: " + foodID + " SUCCESSFULLY!");
        }
    }

    public String toString() {
        String dat = "";
        for (int i = 0; i < count; i++) {
            dat = dat + "\n" + "FoodOrder " + (i + 1) + "\n" + food[i].toString() + "\n";
            System.out.println(" ");
        }
        return dat;
    }

}
