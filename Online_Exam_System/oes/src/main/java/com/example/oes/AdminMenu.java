package com.example.oes;

import com.example.oes.dao.questionDAOImpl;
import com.example.oes.dto.Question;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {
    public static void main(String[] args) {
        questionDAOImpl dao = new questionDAOImpl();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Add Question");
            System.out.println("2. Update Question");
            System.out.println("3. View Questions");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                  
                    System.out.print("Enter question text: ");
                    String questionText = sc.nextLine();
                    System.out.print("Enter option A: ");
                    String optionA = sc.nextLine();
                    System.out.print("Enter option B: ");
                    String optionB = sc.nextLine();
                    System.out.print("Enter option C: ");
                    String optionC = sc.nextLine();
                    System.out.print("Enter option D: ");
                    String optionD = sc.nextLine();
                    System.out.print("Enter correct answer: ");
                    String correctAnswer = sc.nextLine();
                    Question newQ = new Question(0, questionText, optionA, optionB, optionC, optionD, correctAnswer);
                    dao.addQuestion(newQ);
                    break;
                case "2":
                    
                    System.out.print("Enter question ID to update: ");
                    int updateId = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter new question text: ");
                    String newText = sc.nextLine();
                    dao.updateQuestion(updateId, newText);
                    break;
                case "3":
                    List<Question> questions = dao.getAllQuestions();
                    if (questions.isEmpty()) {
                        System.out.println("No questions found.");
                    } else {
                        for (Question q : questions) {
                            System.out.println("ID: " + q.getQuestionId());
                            System.out.println("Q: " + q.getQuestionText());
                            System.out.println("A: " + q.getOptionA());
                            System.out.println("B: " + q.getOptionB());
                            System.out.println("C: " + q.getOptionC());
                            System.out.println("D: " + q.getOptionD());
                            System.out.println("Correct: " + q.getCorrectAnswer());
                            
                        }
                    }
                    break;
                case "4":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}