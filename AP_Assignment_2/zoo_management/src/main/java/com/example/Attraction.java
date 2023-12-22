package com.example;
import java.util.LinkedHashMap;
import java.util.Map;

class AttractionInfo extends AbstractClass {
    private String name;
    private String description;
    private long value;
    private double ticket_price;
    private boolean isopen=true;
    private int total_ticket_sold_for_this_attraction;

    public AttractionInfo(String description, long value, double ticket_price) {
        this.description = description;
        this.value = value;
        this.ticket_price = ticket_price;
    }

    public boolean isIsopen() {
        return isopen;
    }

    public void setIsopen(boolean isopen) {
        this.isopen = isopen;
    }

    
    public void incrementTicketCount() {
        total_ticket_sold_for_this_attraction++;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getValue() {
        return value;
    }
    
    

    public void setTicket_price(double ticket_price) {
        this.ticket_price = ticket_price;
    }

    @Override
    public void display() {
        System.out.println(" Description: " + description + " ,unique ID: " + value + " ,Ticket price: " + ticket_price+",is_open:"+isopen);
    }

    @Override
    public String toString() {
        return " Description: " + description + ",unique ID: " + value + ",Ticket price: " + ticket_price+",is_open:"+isopen;
    }

    public double getTicket_price() {
        return ticket_price;
    }

    public String getName() {
        return name;
    }
}

public class Attraction extends AbstractClass {
    private Map<String, AttractionInfo> attractions;

    public Attraction() {
        this.attractions = new LinkedHashMap<>();
        add("LIGHT SHOW","THis is an animal light show",101,30);
        add("dino show","this is an dino show",201,50);


    }

    @Override
    public void add(String name, String description, long value, double ticket_price) {
        AttractionInfo info = new AttractionInfo(description, value, ticket_price);
        attractions.put(name, info);
        
    }

    public void viewAttractions() {
        if (attractions.isEmpty()) {
            System.out.println("No attractions available.\n");
        } else {
            System.out.println("List of Attractions:\n");
            int index = 0; // Start the index from 1
            for (Map.Entry<String, AttractionInfo> entry : attractions.entrySet()) {
                System.out.print(index);
                System.out.print("-  Name: " + entry.getKey() + ", ");
                entry.getValue().display();
                System.out.println(); // Add an empty line for separation
                index++;
            }
        }
    }

    @Override
    public void display() {
        for (Map.Entry<String, AttractionInfo> entry : attractions.entrySet()) {
            System.out.println("Name: " + entry.getKey());
            entry.getValue().display();
        }
    }

    @Override
    public void modify(int attractionIndex, String newDescription, double newTicketPrice) {
    if (attractionIndex >= 0 && attractionIndex < attractions.size()) {
        String name = getNameAtIndex(attractionIndex);
        if (name != null) {
            AttractionInfo info = attractions.get(name);
            info.setDescription(newDescription);
            info.setTicket_price(newTicketPrice);
            System.out.println("Attraction modified successfully.");
        } else {
            System.out.println("Invalid attraction index.");
        }
    } else {
        System.out.println("Invalid attraction index.");
    }
}

    @Override
    public void remove(int attractionIndex) {
        if (attractionIndex >= 0 && attractionIndex < attractions.size()) {
            String name = getNameAtIndex(attractionIndex);
            if (name != null) {
                attractions.remove(name);
                System.out.println(name + " removed from the attraction list.");
            } else {
                System.out.println("Invalid attraction index.");
            }
        } else {
            System.out.println("Invalid attraction index.");
        }
    }


    public int countEntries() {
        return attractions.size();
    }
 
    // public void sellTicket(int attractionIndex) {
    //     if (attractionIndex >= 0 && attractionIndex < attractions.size()) {
    //         AttractionInfo info = attractions.get(attractionIndex);
    //         info.incrementTicketCount();
    //         System.out.println("Ticket sold successfully for " + info.getName());
    //     } else {
    //         System.out.println("Invalid attraction index.");
    //     }
    // }

    public double getTicketPrice(int attractionIndex) {
        if (attractionIndex >= 0 && attractionIndex < attractions.size()) {
            String name = getNameAtIndex(attractionIndex);
            if (name != null) {
                AttractionInfo info = attractions.get(name);
                return info.getTicket_price();
            } else {
                System.out.println("Invalid attraction index.");
                return -1; // Return a sentinel value to indicate an error
            }
        } else {
            System.out.println("Invalid attraction index.");
            return -1; // Return a sentinel value to indicate an error
        }
    }

    public String getNameAtIndex(int attractionIndex) {
        if (attractionIndex >= 0 && attractionIndex < attractions.size()) {
            return (String) attractions.keySet().toArray()[attractionIndex];
        } else {
            return null; // Return null for an invalid index
        }
    }

    public void displayDescription(String name) {
        AttractionInfo info = attractions.get(name);

        if (info != null) {
            System.out.println("Description for " + name + ": " + info.getDescription());
        } else {
            System.out.println("Attraction not found with the provided name.");
        }
    }

    @Override
    public boolean check(String name) {
        return attractions.containsKey(name);
    }

    @Override
    public boolean check() {
        return !attractions.isEmpty();
    }

    public void printAttractionNamesAndTotal() {
        System.out.println("List of Attractions:");
        int index = 0; // Start the index from 1
    
        for (Map.Entry<String, AttractionInfo> entry : attractions.entrySet()) {
            System.out.println((index) + "-Name: " + entry.getKey());
            index++;
        }
    
        System.out.println("Total Attractions: " + attractions.size());
    }


    public void ScheduleEvent(int attractionIndex, boolean isopen) {
        String name = getNameAtIndex(attractionIndex);
    
        if (name != null) {
            AttractionInfo info = attractions.get(name);
            info.setIsopen(isopen);
            System.out.println("Event scheduled successfully for " + name);
        } else {
            System.out.println("Invalid attraction index.");
        }
    }

    public boolean getIsOpenForAttractionIndex(int attractionIndex) {
        if (attractionIndex >= 0 && attractionIndex < attractions.size()) {
            String name = getNameAtIndex(attractionIndex);
            if (name != null) {
                AttractionInfo info = attractions.get(name);
                return info.isIsopen();
            } else {
                System.out.println("Invalid attraction index.");
                return false;
            }
        } else {
            System.out.println("attraction is closed.");
            return false;
        }
    }
    
    




}
