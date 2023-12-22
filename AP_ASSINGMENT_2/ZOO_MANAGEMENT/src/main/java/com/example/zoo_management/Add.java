package com.example.zoo_management;

interface Add{
    void add(String name, String description, long value,double ticket_price); // Attraction Add
    void add(String name, String type, String history, String noise); // Animal Add
    
    void add(String name, int age, long phoneNumber, double balance, String email, String password);
    void add(String code, double percentage,String category);//discount
    void add(int deal,String Description,int numberOfTickets_for_offer,double discountPercentage);  //Spefcial deal
    
    

}