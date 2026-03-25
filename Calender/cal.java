package Calender;


import java.time.LocalDate;
import java.util.*;

public class cal {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("Today: " + today);

        // Get year, month, day
        System.out.println("Year: " + today.getYear());
        System.out.println("Month: " + today.getMonthValue());
        System.out.println("Day: " + today.getDayOfMonth());

        // Add days, months, years
        LocalDate nextWeek = today.plusDays(7);
        System.out.println("Date after 7 days: " + nextWeek);

        LocalDate nextMonth = today.plusMonths(1);
        System.out.println("Date after 1 month: " + nextMonth);

        LocalDate nextYear = today.plusYears(1);
        System.out.println("Date after 1 year: " + nextYear);

        // Subtract days, months, years
        LocalDate prevWeek = today.minusDays(7);
        System.out.println("Date 7 days ago: " + prevWeek);

        LocalDate prevMonth = today.minusMonths(1);
        System.out.println("Date 1 month ago: " + prevMonth);

        LocalDate prevYear = today.minusYears(1);
        System.out.println("Date 1 year ago: " + prevYear);
    }
}
