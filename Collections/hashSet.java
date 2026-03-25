package Collections;


import java.util.*;

public class hashSet {
    public static void main(String[] args){

        int[] arr = { 1, 2, 3, 2, 4, 5, 1, 6 };

        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        Set<Integer> nonDuplicates = new HashSet<>();

        for(int num : arr){
            if(!seen.add(num)){
                duplicates.add(num);
            }
        }

        for (int num : seen) {
            if (!duplicates.contains(num)) {
                nonDuplicates.add(num);
            }
        }


        System.out.println("Non-duplicate numbers: " + nonDuplicates);

    }
}
