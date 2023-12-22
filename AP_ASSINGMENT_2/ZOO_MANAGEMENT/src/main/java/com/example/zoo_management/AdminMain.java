package com.example.zoo_management;
import java.util.Scanner;
import java.util.Random;

public class AdminMain {
    
        Mammal mammal=new Mammal();
        Amphibian amphibian=new Amphibian();
        Reptile reptile=new Reptile();
        Attraction attraction=new Attraction();
        
        Visitor visitor=new Visitor();
        Discount discount = new Discount();
        
        SpecialDeals specialDeals = new SpecialDeals();
        Stats stats=new Stats();
        

    public AdminMain(Mammal mammal,Amphibian amphibian,Reptile reptile,Attraction attraction, Visitor visitor,
                     Discount discount, SpecialDeals specialDeals, Stats stats) {
        this.attraction = attraction;
        this.mammal=mammal;
        this.amphibian=amphibian;
        this.reptile=reptile;
        
    
        this.visitor = visitor;
        this.discount = discount;
        this.specialDeals = specialDeals;
        this.stats = stats;
        
        
        
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Username:- ");
        String username=sc.nextLine();
        System.out.print("Enter Password:- ");
        String password=sc.nextLine();
        Admin admin=new Admin();
        while(true){
            if((admin.getPassword().equals(password)) && (admin.getUsername().equals(username))){
                    System.out.println("Logged in as Admin\n");
                    System.out.println("Admin MenU:");
                    System.out.println("1.-Manage Attractions/Events");
                    System.out.println("2.-Manage Animals");
                    System.out.println("3.-Schedule Events");
                    System.out.println("4.-Set Discounts");
                    System.out.println("5.-Set Special Deal");  
                    System.out.println("6.-View Visitor Stats");
                    System.out.println("7.-View Feedback");
                    System.out.println("8.-Exit\n");
                    System.out.print("Enter your choice:- ");
                    int choice =sc.nextInt();
                    sc.nextLine();
                    System.out.println();



                    
                    if(choice==1){
                        int ex=1;
                        while(ex==1){ 
                            System.out.println("Manage Attractions/Events");
                            System.out.println("1.-Add attractions");
                            System.out.println("2.-View Attractions");
                            System.out.println("3.-Modify Attractions");
                            System.out.println("4.-Remove Attractions");
                            System.out.println("5.-Exit\n");
                            System.out.print("Enter your choice:- ");
                            choice=sc.nextInt();
                            sc.nextLine();
                            switch (choice) {
                                case 1:
                                    System.out.println();
                                    Random random = new Random();
                                    long id = random.nextLong() % 1000L;
                                    if (id < 0) {
                                        id = -id;
                                    }
                                    System.out.print("Enter Attraction Name: ");
                                    String name = sc.nextLine().trim();
                                    System.out.print("Enter Description: ");
                                    String description =sc.nextLine();
                                    System.out.print("Enter ticket price: ");
                                    double ticket_price=sc.nextDouble();
                                    sc.nextLine();
                                    attraction.add(name,description,id,ticket_price);
                                    System.out.println("attraction added\n");
                                    break;
                                case 2:
                                    attraction.viewAttractions();
                                    break;
                                case 3:
                                    attraction.viewAttractions();
                                    if(attraction.check()){
                                        System.out.print("Enter index of Attraction to be modified: ");
                                        int index =sc.nextInt();
                                        sc.nextLine();
                                        System.out.print("Enter Description: ");
                                        String newDescription =sc.nextLine();
                                        System.out.print("Enter ticket price: ");
                                        ticket_price=sc.nextInt();
                                        sc.nextLine();
                                        
                                        attraction.modify(index, newDescription,ticket_price);
                                    }
                                    
                                    
                                    
                                    
                                    break;
                                case 4:
                                    attraction.viewAttractions();
                                    if(attraction.check()){
                                        System.out.print("Enter index  to remove: ");
                                        int index=sc.nextInt();
                                        sc.nextLine();
                                        attraction.remove(index);
                                        }
                                    break;
                                case 5:
                                    ex=0;
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please try again.");
                                    continue;
                            }
                        }
                        continue; 
                    }



                        
                    if(choice==2){
                        int ex=1;
                        while(ex==1){
                            System.out.println("Manage Animals:");
                            System.out.println("1. Add Animal");
                            System.out.println("2. Update Animal Details");
                            System.out.println("3. View Animal");
                            System.out.println("4. Remove Animal");
                            System.out.println("5. Exit\n");
                            System.out.print("Enter you choice: ");
                            choice=sc.nextInt();
                            sc.nextLine();
                            switch (choice){
                                case 1:
                                    System.out.print("Select Animal Type:\n1. Mammal\n2. Amphibian\n3. Reptile\nEnter your choice: ");
                                    int animalTypeChoice = sc.nextInt();
                                    sc.nextLine();
                            
                                    switch (animalTypeChoice) {
                                        case 1:
                                            System.out.print("Enter Mammal Name: ");
                                            String name = sc.nextLine();
                            
                                            System.out.print("Enter Mammal voice: ");
                                            String noise = sc.nextLine();
                            
                                            System.out.print("Enter Mammal History: ");
                                            String history = sc.nextLine();
                            
                                        
                                            mammal.addAnimal(name, noise, history);
                            
                                            System.out.println("Mammal added successfully.");
                                            break;
                                        case 2:
                                            System.out.print("Enter amphibian Name: ");
                                            name = sc.nextLine();
                            
                                            System.out.print("Enter amphibian voice: ");
                                            noise = sc.nextLine();
                            
                                            System.out.print("Enter amphibian History: ");
                                            history = sc.nextLine();
                            
                                        
                                            amphibian.addAnimal(name, noise, history);
                            
                                            System.out.println("amphibian added successfully.");
                                            break;
                                        case 3:
                                            System.out.print("Enter reptile Name: ");
                                             name = sc.nextLine();
                            
                                            System.out.print("Enter reptile voice: ");
                                            noise = sc.nextLine();
                            
                                            System.out.print("Enter reptile History: ");
                                            history = sc.nextLine();
                            
                                        
                                            reptile.addAnimal(name, noise, history);
                            
                                            System.out.println("reptile added successfully.");
                                            break;
                                        default:
                                            System.out.println("Invalid choice. Please try again.");
                                            break;
                                    }
                                    System.out.println();
                                    break;
                                case 2:
                                    System.out.print("Select Animal Type:\n1. Mammal\n2. Amphibian\n3. Reptile\nEnter your choice: ");
                                    animalTypeChoice = sc.nextInt();
                                    sc.nextLine();
                                    switch (animalTypeChoice) {
                                        case 1:
                                            mammal.viewAnimals();
                                            System.out.print("Enter index : ");
                                            int index=sc.nextInt();
                                            sc.nextLine();
                            
                                            System.out.print("Enter Mammal voice: ");
                                            String noise = sc.nextLine();
                            
                                            System.out.print("Enter Mammal History: ");
                                            String history = sc.nextLine();
                            
                                        
                                            mammal.modifyAnimal(index, noise, history);
                            
                                            System.out.println("Mammal updated successfully.");
                                            break;
                                        case 2:
                                            mammal.viewAnimals();
                                            System.out.print("Enter index : ");
                                            index=sc.nextInt();
                                            sc.nextLine();
                            
                                            System.out.print("Enter amphibian voice: ");
                                            noise = sc.nextLine();
                            
                                            System.out.print("Enter amphibian History: ");
                                            history = sc.nextLine();
                            
                                        
                                            mammal.modifyAnimal(index, noise, history);
                            
                                            System.out.println("amphibian updated successfully.");
                                            break;
                                        case 3:
                                            mammal.viewAnimals();
                                            System.out.print("Enter index : ");
                                            index=sc.nextInt();
                                            sc.nextLine();
                            
                                            System.out.print("Enter reptile voice: ");
                                            noise = sc.nextLine();
                            
                                            System.out.print("Enter reptile History: ");
                                            history = sc.nextLine();
                            
                                        
                                            reptile.modifyAnimal(index, noise, history);
                            
                                            System.out.println("reptile updated successfully.");
                                            break;
                                        default:
                                            System.out.println("Invalid choice. Please try again.");
                                            break;
                                    }
                                    System.out.println();
                                    break;
                                    
                                case 3:
                                    mammal.viewAnimals();
                                    amphibian.viewAnimals();
                                    reptile.viewAnimals();

                                        break;
                                case 4:
                                    System.out.print("Select Animal Type:\n1. Mammal\n2. Amphibian\n3. Reptile\nEnter your choice: ");
                                    animalTypeChoice = sc.nextInt();
                                    sc.nextLine();
                                    switch (animalTypeChoice) {
                                        case 1:
                                            mammal.viewAnimals();
                                            System.out.print("Enter Mammal index: ");
                                            int index=sc.nextInt();
                                            sc.nextLine();
                                            
                                            mammal.removeAnimal(index);
                                            System.out.println();
                                            break;

                                        case 2:
                                            amphibian.viewAnimals();
                                            System.out.print("Enter Amphibian index: ");
                                            index=sc.nextInt();
                                            sc.nextLine();
                                            
                                            amphibian.removeAnimal(index);
                                            System.out.println();
                                            break;
                                        case 3:
                                            reptile.viewAnimals();
                                            System.out.print("Enter Reptile indedx: ");
                                            index=sc.nextInt();
                                            sc.nextLine();
                                            
                                            reptile.removeAnimal(index);
                                            System.out.println();
                                            break;   
                                    }

                                    break;
                                case 5:
                                    ex=0;
                                    break;   
                                default:
                                    System.out.println("Invalid choice. Please try again.");
                            }
                        } 
                        continue;
                    }




                    if(choice==3){
                        int ex=1;
                        while(ex==1){
                            System.out.println("1.-Schedule an event");
                           
                            System.out.println("2.-Exit\n");
                            System.out.print("Enter your choice: ");
                            choice=sc.nextInt();
                            sc.nextLine();
                            switch(choice){
                                case 1:
                                    attraction.viewAttractions();
                                    if(attraction.check()){
                                        System.out.println("Schedule Event:");
                                        System.out.print("Enter attraction index: ");
                                        int index=sc.nextInt();
                                        sc.nextLine();
                                        System.out.println("1.Open Attraction");
                                        System.out.println("2.Close Attraction");
                                        System.out.print("ENTER YOUR CHOICE: ");
                                        int is_open =sc.nextInt();
                                        sc.nextLine();
                                        if(is_open==1){
                                            attraction.ScheduleEvent(index, true);

                                        }
                                        else if(is_open==2){
                                            attraction.ScheduleEvent(index, false);
                                        }

                                        else{
                                            System.out.println("Invalid choice");
                                        }
                                    }
                                    break;
                                
                                
                                case 2:
                                    ex=0;
                                    break;               
                                default:
                                    System.out.println("Invalid choice. Please try again.");
                                    continue;
                            }
                        }
                        continue;
                    }



                    if(choice==4){
                        int ex=1;
                        while (ex==1) {
                            System.out.println("Set Discounts:");
                            System.out.println("1. Add Discount");
                            System.out.println("2. Modify Discount");
                            System.out.println("3. Remove Discount");
                            System.out.println("4. View Discounts");
                            System.out.println("5. Exit\n");
                
                            System.out.print("Enter your choice: ");
                            choice = sc.nextInt();
                            sc.nextLine(); // Consume the newline character
                
                            switch (choice) {
                                case 1:
                                    System.out.print("Enter Discount Category: ");
                                    String category = sc.nextLine().trim();
                                    System.out.print("Enter Discount Percentage (e.g., 20 for 20%): ");
                                    double percentage = sc.nextDouble();
                                    sc.nextLine(); // Consume the newline character
                                    System.out.print("Enter coupon code:- ");
                                    String code=sc.nextLine().trim();
                                    discount.add(code, percentage,category);  
                                    System.out.println();
                                    break;
                                case 2:
                                    if(discount.check()){
                                        System.out.print("Enter Discount Category: ");
                                        category = sc.nextLine().trim();
                                        System.out.print("Enter New Discount Percentage (e.g., 20 for 20%): ");
                                        percentage = sc.nextInt();
                                        sc.nextLine(); // Consume the newline character
                                        System.out.print("Enter coupon code:- ");
                                        code=sc.nextLine().trim();
                                        discount.modify(code, percentage,category);
                                        System.out.println();
                                    }
                                    break;
                                case 3:
                                    if(discount.check()){
                                    System.out.print("Enter Discount Category: ");
                                    category = sc.nextLine().trim();
                                    discount.remove(category);
                                    System.out.println();
                                    }
                                    break;
                                case 4:
                                    discount.viewDiscounts();
                                    break;
                                case 5:
                                    ex=0;
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please try again.");
                                    continue;
                            }
                        }
                        continue;
                    }




                    if(choice==5){
                        int ex=1;
                        while(ex==1){
                            System.out.println("Special Deals:");
                            System.out.println("1. Set Deal");
                            System.out.println("2. Remove Deal");
                            System.out.println("3. Modify deal");
                            System.out.println("4.view Special deals");
                            System.out.println("5. Exit\n");
                            System.out.print("Enter you choice: ");
                            choice=sc.nextInt();
                            sc.nextLine();
                            
                            switch(choice){
                                case 1:
                                    System.out.print("Enter Deal ID (lets say 101): ");
                                    int dealNumber=sc.nextInt();
                                    sc.nextLine();
                                    System.out.print("Enter deal description: ");
                                    String dealdescription=sc.nextLine();
                                    System.out.print("Enter no of ticket for an offer: ");
                                    int numberOfTickets_for_offer=sc.nextInt();
                                    sc.nextLine();
                                    System.out.print("Enter discount percentage: ");
                                    double discountPercentage=sc.nextDouble();
                                    sc.nextLine();
                                    specialDeals.add(dealNumber, dealdescription, numberOfTickets_for_offer, discountPercentage);
                                    break;
                                case 2:
                                    if(specialDeals.check()){
                                        System.out.print("Enter deal no to remove ");
                                        dealNumber=sc.nextInt();
                                        sc.nextLine();
                                        specialDeals.remove(dealNumber);
                                    }
                                    break;

                                case 3:
                                    if(specialDeals.check()){
                                        System.out.print("Enter Deal ID  to modify: ");
                                        dealNumber=sc.nextInt();
                                        sc.nextLine();
                                        System.out.print("Enter deal description: ");
                                        dealdescription=sc.nextLine();
                                        System.out.print("Enter no of ticket for an offer: ");
                                        numberOfTickets_for_offer=sc.nextInt();
                                        sc.nextLine();
                                        System.out.print("Enter discount percentage: ");
                                        discountPercentage=sc.nextInt();
                                        sc.nextLine();
                                        specialDeals.modify(dealNumber, dealdescription, numberOfTickets_for_offer, discountPercentage);
                                    }
                                    break;
                                
                                case 4:
                                    System.out.println();
                                    specialDeals.displayDeals();
                                    System.out.println();
                                case 5:
                                    ex=0;
                                    break;

                                default:
                                    System.out.println("Invalid choice. Please try again.");
                                    continue;
                                    

                            }
                            continue;
                        }
                    }




                    if(choice==6){
                        System.out.println("Visitor Statistics:\n");
                        System.out.println("Total revenue in $: "+stats.getTotalRevenue());
                        System.out.println("Total Tickets sold: "+stats.getTotalTicketsSold());
                        System.out.println("Most Popular Attraction: "+stats.getMostFrequentAttraction());
                        System.out.println("Total memberships in zoo: "+stats.getTotalVisitorsToZoo());
                        System.out.println("Total visits to Attractions: "+stats.getTotalVisitorsWhoVisitedAttraction());
                        System.out.println("Total visits to animal: "+stats.getTotalVisitorsWhoVisitedAnimals());
                        attraction.printAttractionNamesAndTotal();
                        System.out.println();
                        

                    }



                    
                    if(choice==7){
                        visitor.showAllFeedbacks();
                        System.out.println();
                        

                        
                    }

                    if(choice==8){
                        break;
                    }


            }

            else{
                System.out.println("Wrong Password or username\n");
                break;

            }

        }
          
    }
            
}

       