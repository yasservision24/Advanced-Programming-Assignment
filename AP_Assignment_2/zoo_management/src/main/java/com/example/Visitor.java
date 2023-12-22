package com.example;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class VisitorInfo extends AbstractClass{

    
    private String name;
    private int age;
    private long phoneNumber;
    private double balance;
    private String email;
    private String password;
    private String membership;
    private int no_of_ticket;
    private String feedback;
    private String[] myattraction;
    

   
    public VisitorInfo(String name, int age, long phoneNumber, double balance, String email, String password) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.email = email;
        this.password = password;
        this.membership="null";
        this.no_of_ticket=0;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public String getMembership() {
        return membership;
    }

    public void setNo_of_ticket(int no_of_ticket) {
        this.no_of_ticket = no_of_ticket;
    }

    public int getNo_of_ticket() {
        return no_of_ticket;
    }


    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }


    public String getFeedback() {
        return feedback;
    }

    public void setMyattraction(String[] myattraction) {
        this.myattraction = myattraction;
    }
      public String[] getMyattraction() {
          return myattraction;
      }
   

    @Override
    public void display() {
        System.out.println("Name=" + name + ", Age=" + age + ", Phone Number=" + phoneNumber + ", Balance=" + balance
                + ", Email=" + email + ", Password=" + password);
    }

    @Override
    public String toString() {
        return "Name=" + name + ", Age=" + age + ", Phone Number=" + phoneNumber + ", Balance=" + balance
                + ", Email=" + email + ", Password=" + password;
    }
}



public class Visitor extends AbstractClass{
    private Map<String, VisitorInfo> visitors;

    public Visitor() {
        this.visitors = new HashMap<>();
    }

    @Override
    public void add(String name, int age, long phoneNumber, double balance, String email, String password) {
        VisitorInfo info = new VisitorInfo(name,age,phoneNumber,balance,email, password);
        visitors.put(email, info);
        System.out.println("Visitor added successfully.");
        
    }

    public boolean login(String email, String password) {
        VisitorInfo visitor = visitors.get(email);
        System.out.println();

        if (visitor != null && visitor.getPassword().equals(password)) {
            System.out.println("Welcome "+visitor.getName()+" login successfull!!");
            return true;
            
        } else {
            System.out.println("either wrong username or password");
            return false;
        }
    }


    public void changeMembership(String email, String membershipType) {
        VisitorInfo visitor = visitors.get(email);

        if (visitor != null) {
            visitor.setMembership(membershipType);
            System.out.println("Membership purchased successfully.");
        } else {
            System.out.println("Visitor not found with the provided email.");
        }
    }

    public void feedback(String email, String membershipType) {
        VisitorInfo visitor = visitors.get(email);

        if (visitor != null) {
            visitor.setFeedback(membershipType);
            System.out.println("Membership purchased successfully.");
        } else {
            System.out.println("Visitor not found with the provided email.");
        }
    }


    public boolean checkMembershipType(String email) {
        VisitorInfo visitor = visitors.get(email);

        if (visitor != null && visitor.getMembership() != null && visitor.getMembership().equalsIgnoreCase("Basic")) {
            System.out.println("Membership type is Basic.");
            return true;
        }

        else if(visitor != null && visitor.getMembership() != null && visitor.getMembership().equalsIgnoreCase("Premium")) {
            System.out.println("you dont have to buy ticket  you have PREMIUM membership");
            return false;
        } 
        else {
            System.out.println("You need to have a basic membership to buy ticket");
            return false;
        }
    }

    public void showAllFeedbacks() {
        System.out.println("All Feedbacks:\n");
    
        boolean feedbackFound = false;
    
        for (VisitorInfo visitor : visitors.values()) {
            if (visitor.getFeedback() != null) {
                System.out.println("Visitor: " + visitor.getName() + ", Feedback: " + visitor.getFeedback());
                feedbackFound = true;
            }
        }
    
        if (!feedbackFound) {
            System.out.println("No feedbacks available.");
        }
    }
    


    public void addAttractionsToVisitor(String email, String[] myattractions) {
        VisitorInfo visitor = visitors.get(email);
    
        if (visitor != null) {
            visitor.setMyattraction(myattractions);
            System.out.println("Attractions added to visitor successfully.");
        } else {
            System.out.println("Visitor not found with the provided email.");
        }
    }


    public void removeAttractionFromVisitor(String email, String attractionName) {
        VisitorInfo visitor = visitors.get(email);
    
        String[] myAttractions = visitor.getMyattraction();
        if (myAttractions != null) {
            List<String> updatedAttractions = new ArrayList<>(Arrays.asList(myAttractions));
    
            // Find and remove the first occurrence of attractionName
            if (updatedAttractions.remove(attractionName)) {
                visitor.setMyattraction(updatedAttractions.toArray(new String[0]));
                
            } else {
                System.out.println("Attraction not found in the list.");
            }
        }
    }
    


    public boolean isAttractionInList(String email, String attractionName) {
        VisitorInfo visitor = visitors.get(email);
    
        if (visitor != null) {
            String[] myAttractions = visitor.getMyattraction();
            if (myAttractions != null) {
                for (String attraction : myAttractions) {
                    // Check for null values in the array before comparison
                    if (attraction != null && attraction.equalsIgnoreCase(attractionName)) {
                        return true;
                    }
                }
                // Return false if no match is found in the loop
                return false;
            }
        }
    
        // Return false if the array is null or if the visitor is null
        return false;
    }
    

    public void saveFeedback(String email, String feedback) {
        VisitorInfo visitor = visitors.get(email);

        if (visitor != null) {
            visitor.setFeedback(feedback);
            System.out.println("Feedback saved successfully.");
        } else {
            System.out.println("Visitor not found with the provided email.");
        }
    }
    

    public boolean processPayment(String email, double totalPayable) {
        VisitorInfo visitor = visitors.get(email);

        if (visitor != null) {
            double currentBalance = visitor.getBalance();

            if (currentBalance >= totalPayable) {
                double updatedBalance = currentBalance - totalPayable;
                visitor.setBalance(updatedBalance);
                System.out.println("Payment processed successfully.");
                return true;
            } else {
                System.out.println("Insufficient balance for payment.");
            }
        } else {
            System.out.println("Visitor not found with the provided email.");
        }

        return false;
    }


    public boolean isBasicOrPremiumMember(String email) {
        VisitorInfo visitor = visitors.get(email);
    
        if (visitor != null && visitor.getMembership() != null) {
            String membershipType = visitor.getMembership();
            return membershipType.equalsIgnoreCase("Basic") || membershipType.equalsIgnoreCase("Premium");
        }
    
        return false;
    }

    public double getBalanceForEmail(String email) {
        VisitorInfo visitor = visitors.get(email);
    
        if (visitor != null) {
            return visitor.getBalance();
        } else {
            System.out.println("Visitor not found with the provided email.");
            return -1; // Return a sentinel value to indicate visitor not found
        }
    }

    public int getAge(String email) {
        VisitorInfo visitor = visitors.get(email);
    
        if (visitor != null) {
            return visitor.getAge();
        } else {
            System.out.println("Visitor not found with the provided email.");
            return -1; // Return a sentinel value to indicate visitor not found
        }
    }
    

    public boolean isMembershipTypeBasic(String email) {
        VisitorInfo visitor = visitors.get(email);

        if (visitor != null && visitor.getMembership() != null) {
            String membershipType = visitor.getMembership();
            return membershipType.equalsIgnoreCase("Basic");
        }

        return false;
    }

    public boolean isMembershipTypePremium(String email) {
        VisitorInfo visitor = visitors.get(email);

        if (visitor != null && visitor.getMembership() != null) {
            String membershipType = visitor.getMembership();
            return membershipType.equalsIgnoreCase("Premium");
        }

        return false;
    }

    
   
}