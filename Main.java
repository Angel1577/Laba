package com.company;

import java.util.Scanner;

abstract class Bike{
    public double get_sum(){
        return 0;
    }

    Bike(){}

    void repair(){}

}
class Unicycle extends Bike{
    private int num_of_wheels = 1;
    private double diameter;
    Unicycle(double diameter){
        this.diameter = diameter;
    }

    public double get_sum(){
        return diameter;
    }

    @Override
    public void repair(){
        System.out.println("Unicycle починен");
    }
}

class Bicycle extends Bike{
    private int num_of_wheels = 2;
    private double diameter,diameter_1;
    Bicycle(double diameter, double diameter_1){
        this.diameter = diameter;
        this.diameter_1 = diameter_1;
    }

    public double get_sum(){
        return diameter+diameter_1;
    }

    @Override
    public void repair(){
        System.out.println("Bicycle починен");
    }
}

class Tricycle extends Bike{
    private int num_of_wheels = 3;
    private double diameter,diameter_1,diameter_2;
    Tricycle(double diameter, double diameter_1, double diameter_2){
        this.diameter = diameter;
        this.diameter_1 = diameter_1;
        this.diameter_2 = diameter_2;
    }

    public double get_sum(){
        return diameter+diameter_1+diameter_2;
    }

    @Override
    public void repair(){
        System.out.println("Tricycle починен");
    }
}

 class Workroom {
     public static void repair(Bike bike) {
         bike.repair();
     }
 }

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сколько велосипедов потребуется?");
        int n = scanner.nextInt();
        Bike[] Array = new Bike[n];
        for (int i = 0; i < n; i++) {
            int r = (int) (Math.random() * 3);
            double d = Math.random() * 10;
            double d1 = Math.random() * 10;
            double d2 = Math.random() * 10;
            switch (r) {
                case 0:
                    Unicycle unicycle = new Unicycle(d);
                    Array[i] = unicycle;
                    break;
                case 1:
                    Bicycle bicycle = new Bicycle(d, d1);
                    Array[i] = bicycle;
                    break;
                case 2:
                    Tricycle tricycle = new Tricycle(d, d1, d2);
                    Array[i] = tricycle;
                    break;
            }
        }
        System.out.println("Ремонтируем все Unicycle");
        for(int i = 0; i < n; i++){
            if(Array[i] instanceof Unicycle){
                ((Unicycle) Array[i]).repair();
            }
        }
        System.out.println(" " + " ");
        for(int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (Array[j].get_sum() > Array[j - 1].get_sum()) {
                    Bike b = Array[j];
                    Array[j] = Array[j - 1];
                    Array[j - 1] = b;
                }
            }
        }
        System.out.println(" " + " ");
        System.out.println("Отсортированные диаметры:");
        for(int i = 0;i<n;i++){
            System.out.println(Array[i].get_sum());
        }
    }
}