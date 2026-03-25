package Collections;

import java.util.*;

public class Alist {
    public static void main(String[] args){
        double[] sales = { 10.5, -3.2, 7.8, -1.4, 0.0 };

        List<Double>negative = new ArrayList<>();
        List<Double>positive = new ArrayList<>();
        
        for(double s : sales){
            if (s >= 0) {
                positive.add(s);
            }else {
                negative.add(s);
            }
        }

        System.out.println("Positive: " + positive);
        System.out.println("Negative: " + negative);
    }
}
