package com.example.zoo_management;
import java.util.Scanner;
import java.util.Random;

public class VisitorMain {
    Mammal mammal=new Mammal();
        Amphibian amphibian=new Amphibian();
        Reptile reptile=new Reptile();
        Attraction attraction=new Attraction();
    
        Visitor visitor=new Visitor();
        Discount discount = new Discount();
        SpecialDeals specialDeals = new SpecialDeals();
        Stats stats=new Stats();
        

    public VisitorMain(Mammal mammal,Amphibian amphibian,Reptile reptile,Attraction attraction, Visitor visitor,
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

        while(true){
            System.out.println();
            System.out.println("1.Register");
            System.out.println("2.Login");
            System.out.println("3.Exit\n");
            System.out.print("Enter your choice: ");
            int choice=sc.nextInt();
            sc.nextLine();
            System.out.println();


            if(choice==1){
                System.out.print("Enter Visitor Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Visitor Age: ");
                int age = sc.nextInt();
                sc.nextLine(); 
                System.out.print("Enter Visitor Phone Number: ");
                long phoneNumber = sc.nextLong();
                sc.nextLine(); 
                System.out.print("Enter Visitor Balance: ");
                double balance = sc.nextDouble();
                sc.nextLine(); 
                System.out.print("Enter Visitor Email: ");
                String email = sc.nextLine();
                System.out.print("Enter Visitor Password: ");
                String password = sc.nextLine();
                visitor.add(name, age, phoneNumber, balance, email, password);
                System.out.println();
            }


            else if(choice==2){
                System.out.print("Enter your email as username: ");
                String email=sc.nextLine();
                System.out.print("Enter your password: ");
                String password=sc.nextLine();
                System.out.println();
                if(visitor.login(email, password)){;
                    while(true){
                        System.out.println("Visitor Menu:");
                        System.out.println("1. Explore the Zoo");
                        System.out.println("2. Buy Membership");
                        System.out.println("3. Buy Tickets");
                        System.out.println("4. View Discounts");
                        System.out.println("5. View Special Deals");
                        System.out.println("6. Visit Animals");
                        System.out.println("7. Visit Attractions");
                        System.out.println("8. Leave Feedback");
                        System.out.println("9. Log Out\n");
                        System.out.print("Enter your choice: ");
                        choice=sc.nextInt();
                        sc.nextLine();





                        if(choice==1){
                            int ex=1;
                            while(ex==1){
                                System.out.println("1. View Attractions");
                                System.out.println("2. View Animals");
                                System.out.println("3. Exit\n");
                                System.out.print("Enter your choice: ");
                                choice=sc.nextInt();
                                sc.nextLine();
                                switch(choice){
                                    case 1:
                                        attraction.viewAttractions();
                                        System.out.println();
                                        break;
                                    case 2:
                                        mammal.justview();;
                                        amphibian.justview();
                                        reptile.justview();
                                        System.out.println();
                                        break;
                                    case 3:
                                        ex=0;
                                        break;                                
                                    default:
                                        System.out.println("Invalid choice. Please try again.");
                                }
                            }
                            continue;
                        }
                        
                        
                        
                        
                        
                        else if (choice==2){
                            int ex=1;
                            while(ex==1){
                                System.out.println("1.Basic membership(₹20)");
                                System.out.println("2.Premium(₹50)");
                                System.out.println("3.Exit");
                                System.out.print("Enter your choice:- ");
                                double discount_deal=0;
                                choice=sc.nextInt();
                                sc.nextLine();
                                switch(choice){
                                    case 1:
                                        if(visitor.isMembershipTypeBasic(email)){
                                            System.out.println("You already have BASIC membership");
                                            break;
                                        }
                                        else{
                                        double total_payble=20;                               
                                        System.out.print("Enter discount code here:- ");
                                        String couponcode=sc.nextLine().trim();
                                        if(discount.isInputPresent(couponcode)){

                                            if(couponcode.equals("MINOR10")){
                                                if(visitor.getAge(email)<18){
                                                    discount_deal=discount.getPercentageForCode(couponcode);
                                                    System.out.println("coupan applied successfully");

                                                }
                                                else{System.out.println("copon failed");}
                                            }

                                            else if(couponcode.equals("SENIOR20")){
                                                if(visitor.getAge(email)>60){
                                                    discount_deal=discount.getPercentageForCode(couponcode);
                                                    System.out.println("coupan applied successfully");

                                                }
                                                else{
                                                    System.out.println("copon code failed");
                                                }
                                            }


                                            else{
                                                discount_deal=discount.getPercentageForCode(couponcode);
                                                    System.out.println("coupan applied successfully");

                                            }
                                            
                                           
                                        } 
                                        else{
                                            System.out.println("coupon failed");
                                        }  
                                        total_payble=total_payble * (1 - (discount_deal/ 100));              
                                        System.out.println("total amount to be paid "+(total_payble));
                                        if(visitor.processPayment(email, total_payble)){
                                            visitor.changeMembership(email, "Basic");
                                            System.out.println("BALANCE: "+visitor.getBalanceForEmail(email));
                                            stats.updatestats3(total_payble);
                                            stats.incrementVisitorsToZoo();
                                            
                                        }
                                        ex=0;
                                        break;
                                    }
                                    case 2:
                                        if(visitor.isMembershipTypePremium(email)){
                                            System.out.println("You already have premium membership");
                                            break;
                                        }
                                        else{
                                        double total_payble=50;                               
                                        System.out.print("Enter discount code here:- ");
                                        String couponcode=sc.nextLine().trim();
                                        if(discount.isInputPresent(couponcode)){

                                            if(couponcode.equals("MINOR10")){
                                                if(visitor.getAge(email)<18){
                                                    discount_deal=discount.getPercentageForCode(couponcode);
                                                    System.out.println("coupan applied successfully");

                                                }
                                            }

                                            else if(couponcode.equals("SENIOR20")){
                                                if(visitor.getAge(email)>60){
                                                    discount_deal=discount.getPercentageForCode(couponcode);
                                                    System.out.println("coupan applied successfully");

                                                }
                                            }


                                            else{
                                                discount_deal=discount.getPercentageForCode(couponcode);
                                                    System.out.println("coupan applied successfully");

                                            }
                                            
                                            
                                        } 
                                        else{
                                            System.out.println("coupon failed");
                                        }  
                                        total_payble=total_payble * (1 - (discount_deal/ 100));              
                                        System.out.println("total amount to be paid "+(total_payble));
                                        if(visitor.processPayment(email, total_payble)){
                                            visitor.changeMembership(email, "Premium");
                                            System.out.println("BALANCE: "+visitor.getBalanceForEmail(email));
                                            stats.updatestats3(total_payble);
                                            stats.incrementVisitorsToZoo();
                                            
                                        }
                                        ex=0;
                                        break;
                                    }
                                    case 3:
                                        ex=0;
                                        break;
                                    default:
                                        System.out.println("Invalid choice. Please try again.");
                                }
                            }
                        }





                        else if(choice==3){
                            if(visitor.checkMembershipType(email)){
                                String[] cart=new String[100];
                                
                                double total_payble=0;
                                double discount_deal=0;
                                double special_deal=0;
                                int no_of_ticket=0;
                                int ind=0;
                                while(true){
                                    attraction.viewAttractions();
                                    System.out.print("Enter you choice of attraction: ");
                                    int index=sc.nextInt();
                                    sc.nextLine();
                                    System.out.println();
                                    System.out.print("Enter your coupon code here: ");
                                    String couponcode=sc.nextLine();
                                    
                                    System.out.println("Enter 1 to buy another ticket");
                                    System.out.println("Enter 2 to process paymant");
                                    System.out.print("Enter your choice: ");
                                    choice =sc.nextInt();
                                    sc.nextLine();
                                    cart[ind]=attraction.getNameAtIndex(index);
                                    System.out.println(attraction.getNameAtIndex(index));
                                    
                                    if(discount.isInputPresent(couponcode)){
                                        discount_deal=discount.getPercentageForCode(couponcode);
                                    }
                                    else{
                                        System.out.println("coupon failed");
                                    }
                                    total_payble=total_payble+attraction.getTicketPrice(index);
                                    total_payble=total_payble * (1 - (discount_deal/ 100));
                                    
                                 
                                    no_of_ticket=no_of_ticket+1;
                                    ind=ind+1;
                                    
                                
                                    if(choice==1){
                                        continue;
                                    }
                                    else{
                                        break;
                                    }
                                } 
                                if(specialDeals.findDealsByNumberOfTickets_bool(no_of_ticket)){
                                        special_deal=specialDeals.findDealsByNumberOfTickets(no_of_ticket);                      
                                }
                                total_payble=total_payble * (1 - (special_deal/ 100));

                                System.out.println("total amount to be paid "+(total_payble));
                                if(visitor.processPayment(email, total_payble)){
                                    visitor.addAttractionsToVisitor(email, cart);
                                    stats.updateStats(no_of_ticket, total_payble);
                                    System.out.println("Balance: "+visitor.getBalanceForEmail(email));
                                    System.out.println("YOUR TICKETS ARE: ");
                                    for(int i=0;i<no_of_ticket;i++){
                                        stats.updatestats2(cart[i]);
                                        System.out.println(i+1+": "+cart[i]);
                                       
                                    }
                                }

                            }

                            
                        }    

                                      
                                
                        





                        else if(choice==4){
                            discount.viewDiscounts();
                            System.out.println();
                        }





                        else if(choice==5){
                            specialDeals.displayDeals();
                            System.out.println();
                        }

                        



                        else if(choice==6){
                            
                                if(visitor.isBasicOrPremiumMember(email)){
                                
                                    System.out.print("Select Animal Type:\n1. Mammal\n2. Amphibian\n3. Reptile\n");
                                    System.out.print("Enter your choice: ");
                                    int type=sc.nextInt();
                                    sc.nextLine();
                                    switch(type){
                                        case 1:
                                            mammal.justview();
                                            System.out.print("Enter you choice: ");
                                            choice=sc.nextInt();
                                            sc.nextLine();
                                            System.out.println("1 To feed the animal");
                                            System.out.println("2 To read the history");
                                            System.out.print("Enter your choice: ");
                                            int newchoice=sc.nextInt();
                                            sc.nextLine();
                                            if(newchoice==1){
                                                mammal.feed(choice);
                                            }
                                            else if(newchoice==2){
                                                mammal.readAbout(choice);
                                            }
                                            else{
                                                System.out.println("wrong choice");
                                            }
                                            stats.incrementVisitorsWhoVisitedAnimals();
                                            break;
                                        case 2:
                                            amphibian.justview();
                                            System.out.println("Enter you choice: ");
                                            choice=sc.nextInt();
                                            sc.nextLine();
                                            System.out.println("1 To feed the animal");
                                            System.out.println("2 To read the history");
                                            System.out.print("Enter your choice: ");
                                            newchoice=sc.nextInt();
                                            sc.nextLine();
                                            if(newchoice==1){
                                                amphibian.feed(choice);
                                            }
                                            else if(newchoice==2){
                                                amphibian.readAbout(choice);
                                            }
                                            else{
                                                System.out.println("wrong choice");
                                            }
                                            stats.incrementVisitorsWhoVisitedAnimals();
                                            break;
                                        case 3:
                                            reptile.justview();
                                            System.out.println("Enter you choice: ");
                                            choice=sc.nextInt();
                                            sc.nextLine();
                                            System.out.println("1 To feed the animal");
                                            System.out.println("2 To read the history");
                                            System.out.println("Enter your choice: ");
                                            newchoice=sc.nextInt();
                                            sc.nextLine();
                                            if(newchoice==1){
                                                reptile.feed(choice);
                                            }
                                            else if(newchoice==2){
                                                reptile.readAbout(choice);
                                            }
                                            else{
                                                System.out.println("wrong choice");
                                            }
                                            stats.incrementVisitorsWhoVisitedAnimals();
                                            break;
                                        default :
                                            System.out.println("wrong choice");

                                    }
                                }
                                else{
                                    System.out.println("first buy memebrship\n");
                                }
                        }

                        else if(choice==7){
                            attraction.viewAttractions();
                            System.out.print("Enter index to visit the attraction  attraction: ");
                            choice=sc.nextInt();
                            sc.nextLine();
                            

                            String name=attraction.getNameAtIndex(choice);
                            if(visitor.isMembershipTypeBasic(email))
                                if(visitor.isAttractionInList(email, name)){
                                    if(attraction.getIsOpenForAttractionIndex(choice)){
                                        System.out.println("welcome to the "+name);
                                        attraction.displayDescription(name);
                                        visitor.removeAttractionFromVisitor(email, name);
                                        stats.incrementVisitorsWhoVisitedAttraction();
                                    }
                                    else{
                                        System.out.println("event is closed, visit later");
                                    }
                                }
                                else{
                                    System.out.println("You dont have ticket for this attraction");
                                }


                            else if(visitor.isMembershipTypePremium(email)){
                                if(attraction.getIsOpenForAttractionIndex(choice)){
                                    System.out.println("welcome to the "+name);
                                    attraction.displayDescription(name);
                                    stats.incrementVisitorsWhoVisitedAttraction();
                                }
                                else{
                                    System.out.println("event is closed, visit later");
                                }
                            }
                            else{
                                System.out.println("first buy memebrship\n");

                            }
                        }

                        else if(choice==8){
                            System.out.print("Enter your feedback: ");
                            String feedback=sc.nextLine();
                            visitor.saveFeedback(email, feedback);
                        }
                        




                        else if(choice==9){
                            break;
                        }
                        
                
                    }
                }
        }   

            else if(choice==3){
                break;
            }

            else{
                System.out.println("invalid input");
            }
              
        }
    }
}

           
            
        