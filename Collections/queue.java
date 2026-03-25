package Collections;

import java.util.*;

public class queue {
    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5 };

        Queue<Integer> q = new LinkedList<>();

        
        q.add(arr[arr.length - 1]);

       
        for (int i = 0; i < arr.length - 1; i++) {
            q.add(arr[i]);
        }

        while (!q.isEmpty()) {
            System.out.print(q.poll() + " ");
        }
    }
}