package stream_api;

import java.util.*;
import java.util.stream.Collectors;

public class stream {
    public static void main(String args[]){
        ArrayList<Employee> users = new ArrayList<>();
        Employee e1 = new Employee(101, "Ajay", 20000.0);
        Employee e2 = new Employee(102, "Jatin", 80000.0);
        Employee e3 = new Employee(103, "kavita", 90000.0);
        Employee e4 = new Employee(107, "komal", 70000.0);
        Employee e5 = new Employee(108, "kishor", 30000.0);

        users.add(e1);
        users.add(e2);
        users.add(e3);
        users.add(e4);
        users.add(e5);

    

        // for (Employee e : users) {
        //     System.out.println(e.toString());
        // }

        // users.stream().forEach(i -> System.out.println(i.toString()));
        // users.stream().filter(i -> i.getSalary() > 40000).forEach(i -> System.out.println(i.toString()));


        // Book list
        List<Book> books = Arrays.asList(
                new Book(1, "Java Basics", "James", 500, "Programming"),
                new Book(2, "Spring Boot", "Rod", 800, "Programming"),
                new Book(3, "Python Guide", "Guido", 600, "Programming"),
                new Book(4, "History India", "Ram", 300, "History"),
                new Book(5, "Maths 101", "Shyam", 200, "Education"),
                new Book(6, "Data Structures", "Mark", 700, "Programming"),
                new Book(7, "English Grammar", "John", 250, "Education"),
                new Book(8, "AI Basics", "Andrew", 900, "Technology"),
                new Book(9, "Machine Learning", "Andrew", 1200, "Technology"),
                new Book(10, "World War", "Alex", 400, "History"));

                // books.stream().forEach(i -> System.out.println(i.toString()));
                // books.stream().filter(i -> i.getPrice() > 500).forEach(i -> System.out.println(i.toString()));

                // no of books
                // long bookCount = books.stream().count();
                // System.out.println("Total books: " + bookCount);

                //min price
                // Optional<Book> maxPriceBook = books.stream().max(Comparator.comparingDouble(Book::getPrice));
                //     System.out.println("MAX Price: " + maxPriceBook.get().getPrice());
                
                 //min price
                // Optional<Book> minPriceBook = books.stream().min(Comparator.comparingDouble(Book::getPrice));
                // System.out.println("MIN Price: " + minPriceBook.get().getPrice());

                //print all authors
                // books.stream().forEach(i -> System.out.println(i.getAuthor()));
                
                // /'sort books by price'
                // books.stream()
                //      .sorted(Comparator.comparingDouble(Book::getPrice))
                //      .forEach(i -> System.out.println(i.getTitle() + " - " + i.getPrice()));

                // sort books by title
                // books.stream()
                //      .sorted(Comparator.comparing(Book::getTitle).reversed())
                //      .forEach(i -> System.out.println(i.getTitle()));

                // Get all books belonging to "Programming" category
                books.stream()
                     .filter(i ->i.getCategory().equals("Programming"))
                     .forEach(i -> System.out.println(i.getTitle() + " - " + i.getCategory()));

                // Find average price of all books
                double avg = books.stream()
                     .mapToDouble(Book::getPrice)
                     .average()
                     .orElse(0);

                System.out.println("Average Price: " + avg);

                //Gropubu
                Map<String, Long> countByCategory = books.stream()
        .collect(Collectors.groupingBy(
                Book::getCategory,
                Collectors.counting()
        ));
        // ...existing code...
        // List<Integer> marks = Arrays.asList(10,40,50,60);
        // for(Integer i : marks){
        //     System.out.println(i);
        // }

        // marks.stream().forEach(i->System.out.println(i));
        // marks.stream().filter(i -> i<50).forEach(i-> System.out.println(i));

        // long c=marks.stream().filter(i -> i>=50).count();
        // System.out.println(c);

        // marks.stream().sorted().forEach(i-> System.out.println(i));

        // List<String> users = Arrays.asList("kavita", "jatin", "ajay", "ram", "arti");
        // users.stream().sorted().forEach(i -> System.out.println(i));

        // users.stream().filter(i -> i.startsWith("a")).forEach(i -> System.out.println(i));
        // marks.stream().filter(i->i<30).map(i->i+5).forEach((i)->System.out.println(i));
    }

}
