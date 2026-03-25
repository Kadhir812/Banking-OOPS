package generics;

import java.util.ArrayList;
import java.util.List;

public class ex1 {
    public static void main(String[] args){
        List<String> studentNames = new ArrayList<>();
studentNames.add("Kadhir");

List<Integer> marks = new ArrayList<>();
marks.add(85);


String name = studentNames.get(0);
int mark = marks.get(0);

System.out.println(name);
System.out.println(mark);
    }
}
