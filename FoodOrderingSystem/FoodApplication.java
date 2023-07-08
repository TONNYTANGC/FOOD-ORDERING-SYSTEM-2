/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FoodOrderingSystem;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class FoodApplication {

    private static Scanner scan = new Scanner(System.in);
    private static int numOfFoods = 0;
    final static FoodMenu food = new FoodMenu(3);

    public static void main(String[] args) {
        String name = "", foodID = "";
        double unitPrice = 0;
        int option = 0;

        try {
            while (option != 6) {
                menu();
                option = scan.nextInt();

                while (option < 1 || option > 6) {
                    System.out.println("Please enter correct value");
                    menu();
                    option = scan.nextInt();
                }
                switch (option) {
                    case 1:
                        if (!food.isEmpty()) {
                            System.out.println("");
                            System.out.println("THE COLLECTION IS FULL.");
                            break;
                        } else {
                            newFood(food, name, foodID, unitPrice);
                            break;
                        }

                    case 2:
                        if (food.isArrayNull()) {
                            System.out.println("");
                            System.out.println("THE COLLECTION IS EMPTY.");
                            break;
                        } else {
                            System.out.println("");
                            System.out.print("Please Enter the Order ID to delete : ");
                            String ID = scan.next() + scan.nextLine();
                            food.deleteFood(ID);
                            numOfFoods--;
                            break;
                        }

                    case 3:
                        if (food.isArrayNull()) {
                            System.out.println("");
                            System.out.println("THE COLLECTION IS EMPTY.");
                            break;
                        } else {
                            System.out.println("");
                            System.out.print("Please Enter the Order ID to Search : ");
                            String ID = scan.next() + scan.nextLine();
                            food.searchFood(ID);
                            break;
                        }

                    case 4:
                        if (food.isArrayNull()) {
                            System.out.println("");
                            System.out.println("THE COLLECTION IS EMPTY.");
                            break;
                        } else {
                            System.out.println("");
                            System.out.print("Please Enter the Order ID to Update : ");
                            String ID = scan.next() + scan.nextLine();
                            System.out.print("ENTER NEW FOOD NAME                 : ");
                            name = scan.next() + scan.nextLine();
                            System.out.print("ENTER NEW FOOD ID                   : ");
                            foodID = scan.next() + scan.nextLine();
                            System.out.print("ENTER NEW FOOD UNITPRICE            : ");
                            unitPrice = scan.nextDouble();
                            food.updateFood(ID, name, foodID, unitPrice);
                            numOfFoods--;
                            break;
                        }
                    case 5:
                        System.out.println(food.toString());
                        break;
                    case 6:
                        System.out.println("");
                        System.out.println("Thank you for using our services. Hope to see you again in future!");
                        System.out.printf("%34s%n", "----- End -----");
                        System.out.println("-------------------------------------------------------------");
                        System.exit(0);
                }
            }
        } catch (InputMismatchException e) {
            System.err.println("Please enter correct value");
            scan.nextLine();
            menu();
        }

    }

    public static void menu() {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("x 1 : ADDING NEW FOOD                                       x");
        System.out.println("x 2 : DELECTING EXISTING FOOD                               x");
        System.out.println("x 3 : SEARCHING FOOD                                        x");
        System.out.println("x 4 : UPDATING FOOD'S DETAILS                               x");
        System.out.println("x 5 : DISPLAYING ALL FOOD                                   x");
        System.out.println("x 6 : EXIT                                                  x");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.print("Please Enter the Corresponding Number To Perform Operation(1-5)> ");
    }

    public static void newFood(FoodMenu FM, String name, String foodID, double unitPrice) {

        try {
            System.out.println(" ");
            System.out.print("ENTER FOOD NAME               : ");
            name = scan.next() + scan.nextLine();
            System.out.print("ENTER FOOD ID                 : ");
            foodID = scan.next() + scan.nextLine();
            System.out.print("ENTER FOOD UNITPRICE          : ");
            unitPrice = scan.nextDouble();
            FM.addFood(name, foodID, unitPrice);

            System.out.println("");
            System.out.println("Congratulations! NO." + (numOfFoods + 1) + " Food has been registered successfully.");
            System.out.println("*************************************************************");
            System.out.println(FM.toString());
            System.out.println("*************************************************************");
            System.out.println("");

            numOfFoods++;

        } catch (InputMismatchException e) {
            System.out.println("Please enter correct value");
            scan.nextLine();
            newFood(FM, name, foodID, unitPrice);
        }
    }

    public static void search(FoodMenu FM) {
        String ID = " ";

        try {
            System.out.print("ENTER FOOD ID      : ");
            ID = scan.next() + scan.nextLine();
        } catch (InputMismatchException q) {
            System.out.println("Please enter integer only");
            scan.nextLine();
            search(FM);
        } catch (Exception q) {
            System.out.println("Something Went  Wrong");
            scan.nextLine();
            search(FM);
        }
        FM.searchFood(ID);
    }


}
