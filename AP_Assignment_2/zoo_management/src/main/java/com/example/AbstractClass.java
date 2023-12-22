package com.example;

abstract class AbstractClass implements Add,Modify,Displayable,Remove,Cheackable{
    @Override
    public void add(String name, String description, long value,double ticket_price) {     // Add Attraction
        
    }
    @Override
    public void add(String name, String type, String history, String noise) {// Animal Add
       
    }

    

    @Override
    public void add(String name, int age, long phoneNumber, double balance, String email, String password) {
        
    }

    @Override
    public void add(String code, double percentage,String category){} //discount
    
   @Override
   public void add(int deal,String Description,int numberOfTickets_for_offer,double discountPercentage){} //speacialdeal


    @Override
    public void modify(int index, String description,double ticket_price){} // Add Attraction

    @Override
    public void modify(String name, String newType, String newHistory, String newNoise){}    // Add Animal

    @Override
    public void modify(String name, boolean newStatus){}  // scheduleEvent

    @Override
    public void modify(String code, double newPercentage,String category){}  //discount


    @Override
    public void modify(int dealNumber, String description, int numberOfTickets, double discountPercentage){} //modify speacil deal

    @Override
    public void remove(String name){} // to remove attarction

    @Override
    public void remove(int any_no){}  // to remove animal, to remove deal

    @Override
    public void display(){}

    @Override
    public void display(int animalID){}

    @Override
    public boolean check(String type){
        return true;
    }
     
    @Override
    public boolean check(){  // check if the attaraction is empty or not  
        return true;
    }

}
