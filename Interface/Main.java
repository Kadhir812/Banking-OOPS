package Interface;

public class Main {
    public static void main(String args[]){

        Phone airtel = (rate)-> {
            System.out.println("Airtel calling " + rate + " Rs");
        };
        
        Phone jio = (rate) -> {
        System.out.println("Jio calling " + rate + " Rs");
        };

        Phone Vodafone = (rate) -> {
            System.out.println("Vodafone calling " + rate + " Rs");
        };

        airtel.calling(5);
        airtel.msg();

        jio.calling(4);
        jio.msg();

        Vodafone.calling(5);
        Vodafone.msg();
    }
}
