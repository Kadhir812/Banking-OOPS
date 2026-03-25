package Collections;


import java.util.*;

public class hashMap {
    public static void main(String[] args){

    //     HashMap<String, String> login = new HashMap<>();
    //     login.put("user1", "kad123");
    //     login.put("user2", "kad234");

    //     Scanner sc = new Scanner(System.in);
        
    //     System.out.println("Enter userId:");
    //     String userId = sc.nextLine();


    //     System.out.print("Enter password: ");
    //     String password = sc.nextLine();

    //     if(login.containsKey(userId)){
    //         if(login.get(userId).equals(password)){
    //             System.out.println("Login Successful");
    //         }else{
    //             System.out.println("Wrong Password");
    //         }
    //     } else {
    //         System.out.println("User Not Found");
    //     }
           
    


            String[] fruits = {
                    "Apple", "Banana", "Mango", "Apple", "Orange",
                    "Banana", "Grapes", "Mango", "Apple", "Pineapple",
                    "Orange", "Banana", "Apple", "Mango", "Grapes",
                    "Banana", "Apple", "Orange", "Mango", "Banana"
            };

            HashMap<String, Integer> count = new HashMap<>();

            for(String fruit : fruits){
                if(count.containsKey(fruit)){
                    count.put(fruit, count.get(fruit) + 1);
                }else{
                    count.put(fruit, 1);
                }
            }

            for (String key : count.keySet()) {
                System.out.println(key + " - " + count.get(key));
            }

            // // Print all fruits
            // for (String fruit : fruits) {
            //     System.out.println(fruit);
            // }
    }
}
