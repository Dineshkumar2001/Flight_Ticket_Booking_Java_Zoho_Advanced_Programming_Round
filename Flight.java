import java.util.*;
public class Flight{
    static int id = 0;
    int flightId;
    int ticketsAvailable;
    int ticketPrice;
    List<String> passangerDetails;
    List<Integer> passangerId;
    List<Integer> passangerToatlCost;
    List<Integer> passangerTotalTickets;
    public Flight(){
        id=id+1;
        flightId=id;
        ticketsAvailable=50;
        ticketPrice=5000;
        passangerDetails=new ArrayList<>();
        passangerId=new ArrayList<>();
        passangerTotalTickets=new ArrayList<>();
        passangerToatlCost=new ArrayList<>();
    }
    public void addPassangerDeatils(String deails,int id,int ticket){
        int cost = ticket*ticketPrice;
        ticketsAvailable-=ticket;
        ticketPrice+=200*ticket;
        passangerDetails.add(deails);
        passangerId.add(id);
        passangerToatlCost.add(cost);
        passangerTotalTickets.add(ticket);
        System.out.println("Added Passanger Detail to Server, Successfully !");
    }
    public void printDetails(int Id){
        int index = passangerId.indexOf(id);
        System.out.println(passangerDetails.get(index));
    }
    public void cancelTicekts(int passId){
        int index = passangerId.indexOf(passId);
        int tic = passangerTotalTickets.get(index);
        ticketPrice-=200*tic;
        ticketsAvailable+=tic;
        System.out.println("Amount Refunded to Bank Account rs:"+passangerToatlCost.get(index));
        passangerDetails.remove(index);
        passangerId.remove(index);
        passangerToatlCost.remove(index);
        passangerTotalTickets.remove(index);
        System.out.println("Cancellation Done, Removed Passanger Details from Server");
    }
    public void flightSummary(){
        System.out.println("Flight ID = "+flightId+" Available Tickets :"+ticketsAvailable+" Ticket Price: "+ticketPrice);
    }
    public void flightDeails(){
        System.out.println("Flight Id = "+flightId);
        for(String it: passangerDetails){
            System.out.println(it);
        }
    }
}
