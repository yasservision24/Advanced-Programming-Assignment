package com.example.zoo_management;
import java.util.Map;
import java.util.HashMap;

class SpecialDealInfo {
    private String description;
    private int numberOfTickets;
    private double discountPercentage;

    public SpecialDealInfo(String description, int numberOfTickets, double discountPercentage) {
        this.description = description;
        this.numberOfTickets = numberOfTickets;
        this.discountPercentage = discountPercentage;
    }

    public String getDescription() {
        return description;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public void display() {
        System.out.println("Abount the deal:"+description + ", Buy " + numberOfTickets + " tickets and get " + discountPercentage + "% off");
    }
}

public class SpecialDeals extends AbstractClass{
    private Map<Integer, SpecialDealInfo> specialDeals;

    public SpecialDeals() {
        this.specialDeals = new HashMap<>();
        //SpecialDeals specialDeals=new SpecialDeals();
        add(101, "buys more than 2 attractions,get a special discount of 15% on the total amount",2, 15);
        add(201, "buys more than 2 attractions,get a special discount of 15% on the total amount", 3, 30);
    }
    
    @Override
    public void add(int dealNumber, String description, int numberOfTickets, double discountPercentage) {
        specialDeals.put(dealNumber, new SpecialDealInfo(description, numberOfTickets, discountPercentage));
        
    }
    
    @Override
    public void remove(int dealNumber) {
        if (specialDeals.containsKey(dealNumber)) {
            specialDeals.remove(dealNumber);
            System.out.println("Deal " + dealNumber + " removed successfully.");
        } else {
            System.out.println("Deal " + dealNumber + " not found.");
        }
    }


    @Override
    public void modify(int dealNumber, String description, int numberOfTickets, double discountPercentage) {
        if (specialDeals.containsKey(dealNumber)) {
            SpecialDealInfo dealInfo = specialDeals.get(dealNumber);
            dealInfo.setDescription(description);
            dealInfo.setNumberOfTickets(numberOfTickets);
            dealInfo.setDiscountPercentage(discountPercentage);
            System.out.println("Deal " + dealNumber + " modified successfully.");
        } else {
            System.out.println("Deal " + dealNumber + " not found.");
        }
    }

    public void displayDeals() {
        if (specialDeals.isEmpty()) {
            System.out.println("No special deals available.");
        } else {
            System.out.println("Special Deals:");
            for (Map.Entry<Integer, SpecialDealInfo> entry : specialDeals.entrySet()) {
                System.out.println("Deal ID: " + entry.getKey());
                entry.getValue().display();
                System.out.println(); // Add an empty line for separation
            }
        }
        System.out.println();
    }
    


    public double findDealsByNumberOfTickets(int numberOfTickets) {
        for (Map.Entry<Integer, SpecialDealInfo> entry : specialDeals.entrySet()) {
            SpecialDealInfo dealInfo = entry.getValue();
            if (dealInfo.getNumberOfTickets() == numberOfTickets) {
                dealInfo.display();
                return dealInfo.getDiscountPercentage();
            }
        }
    
        System.out.println("No deals found for " + numberOfTickets + " tickets.");
        return -1; // Return a sentinel value to indicate no matching deal was found
    }

    public boolean findDealsByNumberOfTickets_bool(int numberOfTickets) {
        for (Map.Entry<Integer, SpecialDealInfo> entry : specialDeals.entrySet()) {
            SpecialDealInfo dealInfo = entry.getValue();
            if (dealInfo.getNumberOfTickets() == numberOfTickets) {
                dealInfo.display();
                return true; // Return true to indicate a matching deal was found
            }
        }
    
        System.out.println("No deals found for " + numberOfTickets + " tickets.");
        return false; // Return false to indicate no matching deal was found
    }

    @Override
    public boolean check() {
        return !specialDeals.isEmpty();
    }
    
    
}
