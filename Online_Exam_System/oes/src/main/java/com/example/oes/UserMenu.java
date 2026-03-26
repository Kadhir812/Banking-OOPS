package com.example.oes;

import com.example.oes.dao.questionDAOImpl;
import com.example.oes.dto.Question;

import java.util.List;
import java.util.Scanner;

public class UserMenu {
    public static void main(String[] args) {
        questionDAOImpl dao = new questionDAOImpl();
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        boolean registered = false;
        String userName = "";
        String userEmail = "";

        while (running) {
            System.out.println("\n--- User Menu ---");
            System.out.println("1. Register");
            System.out.println("2. Give Exam");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter your name: ");
                    userName = sc.nextLine();
                    System.out.print("Enter your email: ");
                    userEmail = sc.nextLine();
                    registered = true;
                    System.out.println("Registration successful!");
                    break;
                case "2":
                    if (!registered) {
                        System.out.println("Please register first.");
                        break;
                    }
                    List<Question> questions = dao.getAllQuestions();
                    if (questions.isEmpty()) {
                        System.out.println("No questions available.");
                        break;
                    }
                    int score = 0;
                    for (Question q : questions) {
                        System.out.println("Q: " + q.getQuestionText());
                        System.out.println("A: " + q.getOptionA());
                        System.out.println("B: " + q.getOptionB());
                        System.out.println("C: " + q.getOptionC());
                        System.out.println("D: " + q.getOptionD());
                        System.out.print("Your answer (A/B/C/D): ");
                        String ans = sc.nextLine().trim();
                        if (ans.equalsIgnoreCase(q.getCorrectAnswer())) {
                            score++;
                        }
                    }
                    System.out.println("Exam finished! Your score: " + score + "/" + questions.size());
                    break;
                case "3":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}
