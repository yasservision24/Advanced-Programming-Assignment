package com.example;
import java.util.Scanner;


public class Main {
    
    public static void main(String[] args) {
        
        Mammal mammal=new Mammal();
        Amphibian amphibian=new Amphibian();
        Reptile reptile=new Reptile();
        Attraction attraction=new Attraction();
        
        
        Visitor visitor=new Visitor();
        Discount discount = new Discount();
        SpecialDeals specialDeals = new SpecialDeals();
        Stats stats=new Stats();
        

        while(true){
        System.out.println("1.-ENTER AS ADMIN");
        System.out.println("2.-ENTER AS VISITOR");
        System.out.println("3.-VIEW SPECIAL DEALS\n");
        System.out.print("enter you choice:- ");
        Scanner sc=new Scanner(System.in);
        int choice=sc.nextInt();
        sc.nextLine();

        
        if(choice==1){
            AdminMain adminMain = new AdminMain(mammal,amphibian, reptile,attraction, visitor, discount, specialDeals, stats);
            
        }


        else if(choice==2){
            VisitorMain visitorMain=new VisitorMain(mammal,amphibian,reptile,attraction, visitor, discount, specialDeals, stats);
        }


        else if(choice==3){
            System.out.println();
            specialDeals.displayDeals();

        }


        else{
            System.out.println("invalid input");
        }
        
        }
    }
}   