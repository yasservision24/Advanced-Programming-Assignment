package com.example.zoo_management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stats {
    private int totalTicketsSold;
    private double totalRevenue;
    private int total_visitors_to_zoo;
    private int total_visitors_who_visited_attraction;
    private int total_visitors_who_visited_animals;

    private List<String> popularAttractions;

    public Stats() {
        this.totalTicketsSold = 0;
        this.totalRevenue = 0.0;
        this.total_visitors_to_zoo=0;
        this.total_visitors_who_visited_animals=0;
        this.total_visitors_who_visited_attraction=0;

        
        this.popularAttractions = new ArrayList<>();
    }

    public void incrementVisitorsToZoo() {
        total_visitors_to_zoo++;
    }

    public void incrementVisitorsWhoVisitedAttraction() {
        total_visitors_who_visited_attraction++;
    }

    public void incrementVisitorsWhoVisitedAnimals() {
        total_visitors_who_visited_animals++;
    }

    public int getTotalVisitorsToZoo() {
        return total_visitors_to_zoo;
    }

    public int getTotalVisitorsWhoVisitedAttraction() {
        return total_visitors_who_visited_attraction;
    }

    public int getTotalVisitorsWhoVisitedAnimals() {
        return total_visitors_who_visited_animals;
    }

    








    public int getTotalTicketsSold() {
        return totalTicketsSold;
    }

    

    public double getTotalRevenue() {
        return totalRevenue;
    }
    



    public List<String> getPopularAttractions() {
        return popularAttractions;
    }

    public void updateStats(int ticketsSold, double revenue) {
        totalTicketsSold += ticketsSold;
        totalRevenue += revenue;
    
    }

    public void updatestats2(String newpopularAttractions){
        popularAttractions.add(newpopularAttractions);
        
    }

    public void updatestats3(double revenue ){
        totalRevenue += revenue;

    }

    public String getMostFrequentAttraction() {
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String attraction : popularAttractions) {
            frequencyMap.put(attraction, frequencyMap.getOrDefault(attraction, 0) + 1);
        }

        String mostFrequentAttraction = null;
        int maxFrequency = 0;

        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                mostFrequentAttraction = entry.getKey();
            }
        }

        return mostFrequentAttraction;
    }
}
