package com.example;
import java.util.Map;
import java.util.HashMap;

class DiscountInfo extends AbstractClass{
    private String category;
    private double percentage;
    private String code;
    
      
    public DiscountInfo(String code, double percentage) {
        this.code = code;
        this.percentage = percentage;
    
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPercentage() {
        return percentage;
    }

    @Override
    public void display() {
        System.out.println("category: " + code + ", percentage: " + percentage);
    }

    @Override
    public String toString() {
        return "  category: " + code + ", percentage: " + percentage;
    }
}



public class Discount extends AbstractClass{
    private Map<String, DiscountInfo> discounts;

    /*public Discount() {
        Discount discount = new Discount();
        this.discounts = new HashMap<>();
        discount.add("MINOR", 10, "Visitor");
        discount.add("SENIOR", 20, "Visitor");
    }


*/
    public Discount(){
        this.discounts=new HashMap<>();
        add("MINOR10", 10, "minor");
        add("SENIOR20", 20, "senior");
    }


    
    @Override
    public void add(String code, double percentage,String category) {
        DiscountInfo info = new DiscountInfo(category, percentage);
        discounts.put(code, info);
        
        
    }

    public void viewDiscounts() {
        if (discounts.isEmpty()) {
            System.out.println("No Discount  available.");
        } else {
            System.out.println("List of Discount :\n");
            int index = 1; // Start the index from 1
            for (Map.Entry<String, DiscountInfo> entry : discounts.entrySet()) {
                System.out.print(index);
                System.out.print(" CODE: " + entry.getKey()+", ");
                entry.getValue().display();
                System.out.println(); // Add an empty line for separation
                index++;
            }
        }
    }

    @Override
    public void display() {
        for (Map.Entry<String, DiscountInfo> entry : discounts.entrySet()) {
            System.out.println("CODE: " + entry.getKey());
            entry.getValue().display();
        }
    }

  

    @Override
    public void modify(String code, double percentage,String category) {
        if (discounts.containsKey(category)) {
            DiscountInfo info = discounts.get(category);
            info.setCode(code);
            System.out.println("code modified successfully.");
        } else {
            System.out.println("Attraction not found.");
        }
    }
    
    @Override
    public void remove(String category) {
        if (discounts.containsKey(category)) {
            discounts.remove(category);
            System.out.println("Attraction removed successfully.");
        } else {
            System.out.println("Attraction not found.");
        }
    }


    public boolean isInputPresent(String input){
        
            return discounts.containsKey(input);
        
    }

    

    @Override
    public boolean check() {
        return !discounts.isEmpty();
    }
    public double getPercentageForCode(String code) {
        DiscountInfo info = discounts.get(code);
        if (info != null) {
            return info.getPercentage();
        } else {
            return -1; // Return a special value to indicate code not found
        }
    }
    

  

  

   
}