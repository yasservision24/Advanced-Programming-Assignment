package com.example.zoo_management;

interface Modify{
    void modify(int index, String description,double ticket_price);   // Modify Attraction
    void modify(String name, String newType, String newHistory, String newNoise);  // Modify Animal
    void modify(String name, boolean newStatus);  // ScheduleEvent modify
    void modify(String code, double newPercentage,String category); // discount
    void modify(int dealNumber, String description, int numberOfTickets, double discountPercentage); // speacial deal
}
