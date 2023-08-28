import java.util.*;
public class Booking
{
    public static void bookTickets(int passangerId, int ticket, Flight currflight){
        String passDetails = "";
        passDetails = "PassangerId : "+passangerId+" Tickets Booked : "+ticket+" Total Cost : "+currflight.ticketPrice*ticket;
        currflight.addPassangerDeatils(passDetails,passangerId,ticket);
        System.out.println("Ticket Booked for Passanger ID"+passangerId);
    }
    public static void cancel(Flight currflight, int passId){
        currflight.cancelTicekts(passId);
    }
	public static void main(String[] args) {
		List<Flight> flights = new ArrayList<>();
		for(int i=0;i<3;i++){
		    flights.add(new Flight());
		}
		System.out.println("Welcome to Zoho Flights");
		System.out.println();
		Scanner sc = new Scanner(System.in);
		Boolean flag = true;
		int passangerId = 1;
		while(flag){
		    System.out.println("Enter 1 to Book Tickets");
		    System.out.println("Enter 2 to Cancel Tickets");
		    System.out.println("Enter 3 to View Detils");
		    System.out.println("Enter 4 to Exit ");
		    System.out.println();
		    System.out.println("Enter the choice :");
		    int choice = sc.nextInt();
		    switch(choice){
		        case 1:
		        {
		            System.out.println("Enter Flight ID");
		            int fid = sc.nextInt();
		            if(fid>flights.size()){
		                System.out.println("Enter Valid FLight ID");
		                break;
		            }
		            System.out.println("Enter Number of Tickets Required");
		            int ticket = sc.nextInt();
		            Flight currflight = null;
		            for(Flight i : flights){
		                if(fid==i.flightId){
		                    currflight=i;
		                    break;
		                }
		            }
		            if(ticket>currflight.ticketsAvailable){
		                System.out.println("No Tickets Available, Try Again Later :)");
		                break;
		            }
		            bookTickets(passangerId,ticket,currflight);
		            passangerId=passangerId+1;
		            break;
		        }
		        case 2:
		        {
		            System.out.println("Enter Flight ID");
		            int fid = sc.nextInt();
		            if(fid>flights.size()){
		                System.out.println("Enter Valid FLight ID");
		                break;
		            }
		            Flight currflight = null;
		            for(Flight i : flights){
		                if(fid==i.flightId){
		                    currflight=i;
		                    break;
		                }
		            }
		            System.out.println("Enter PassangerId :");
		            int passId = sc.nextInt();
		            if(passId>passangerId){
		                System.out.println("Enter Valid Passanger ID");
		                break;
		            }
		            cancel(currflight,passId);
		            break;
		        }
		        case 3:
		        {
		            for(Flight i: flights){
		                if(i.passangerDetails.size()==0){
		                    System.out.println("No Active Passaners for this Flight ID "+i.flightId);
		                }
		                else{
		                    i.flightDeails();
		                }
		            }
		            break;
		        }
		        case 4:
		        {
		            flag=false;
		            break;
		        }
		        default:
		        {
		            System.out.println("Enter a Valid Choice....");
		        }
		        System.out.println();
		    }
		}
	}
}
