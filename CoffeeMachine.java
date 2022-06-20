package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scanner = new Scanner(System.in);
    static int money = 550;
    static int []coffeeMaterials = new int[4];
    public static void main(String[] args) {

       menu();
    }

    public static int[] getInitialMaterials(){
        int[]materials = new int[4];
        materials[0] = 400;
        materials[1] = 540;
        materials[2] = 120;
        materials[3] = 9;

        return materials;
    }

    public static void updateCoffeeMaterials(int [] initialMaterials) {
        System.out.println("Write how many ml of water you want to add:");
        initialMaterials[0] = initialMaterials[0] + scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        initialMaterials[1] = initialMaterials[1] + scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        initialMaterials[2] =initialMaterials[2] +scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        initialMaterials[3] =initialMaterials[3] +scanner.nextInt();
        System.out.println();

    }

    public static void printMoney(){

        System.out.println("$" + money + " of money");

    }

    public static void printCurrentMaterials(int []currentMaterials){
        System.out.println("The coffee machine has:");
        System.out.println(currentMaterials[0] + " ml of water");
        System.out.println(currentMaterials[1] + " ml of milk");
        System.out.println(currentMaterials[2] +" g of coffee beans");
        System.out.println(currentMaterials[3] +" disposable cups");
        printMoney();

    }

    public static void calculateCoffeeMaterials(int water, int milk, int coffeeBeans, int income) {
        if (coffeeMaterials[0] >= water){
            if (coffeeMaterials[1] >= milk){
                if (coffeeMaterials[2] >= coffeeBeans){
                    if (coffeeMaterials[3] > 1) {
                        coffeeMaterials[0] = coffeeMaterials[0] - water;
                        coffeeMaterials[1] = coffeeMaterials[1] - milk;
                        coffeeMaterials[2] = coffeeMaterials[2] - coffeeBeans;
                        coffeeMaterials[3] = coffeeMaterials[3] - 1;
                        money = money + income;
                        System.out.println("I have enough resources, making you a coffee!");
                        System.out.println();

                  } else {
                      System.out.println("Sorry, not enough cups");
                  }
                } else {
                   System.out.println("Sorry, not enough coffee beans!");
               }
            } else {
                System.out.println("Sorry, not enough milk!");
            }
        } else {
            System.out.println("Sorry, not enough water!");
        }

    }
    public static void selectCoffee(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String selection = scanner.next();
        switch (selection) {
            case "1":
                calculateCoffeeMaterials(250,0,16,4);
                break;

            case "2":
                calculateCoffeeMaterials(350,75,20,7);
                break;

            case "3":
                calculateCoffeeMaterials(200,100,12,6);
                break;

            case "back":
                break;
        }
    }

    public static void takeMoney() {
        System.out.println("I gave you $" + money);
        money = 0;
        System.out.println();
    }

    public static void menu() {
        boolean exit = false;
        coffeeMaterials = getInitialMaterials();
        while (!exit) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String choice = scanner.next();

            switch (choice) {
                case "buy" -> {
                    System.out.println();
                    selectCoffee();
                }
                case "fill" -> {
                    System.out.println();
                    updateCoffeeMaterials(coffeeMaterials);
                }
                case "take" -> {
                    System.out.println();
                    takeMoney();
                }
                case "remaining" -> {
                    System.out.println();
                    printCurrentMaterials(coffeeMaterials);
                }
                case "exit" -> exit = true;
            }


        }
    }

}


