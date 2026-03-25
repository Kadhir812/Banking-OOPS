

import java.util.Scanner;

import service.Library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Create Member");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Add Book");
            System.out.println("5. Remove Book");
            System.out.println("6. Update Book");
            System.out.println("7. Show All Books");
            System.out.println("8. Remove Member");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    library.createMember(name);
                    break;
                case 2:
                    System.out.print("Enter Member ID: ");
                    int memId = sc.nextInt();
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    library.issueBook(memId, bookId);
                    break;
                case 3:
                    System.out.print("Enter Member ID: ");
                    int memId2 = sc.nextInt();
                    library.returnBook(memId2);
                    break;
                case 4:
                    System.out.print("Enter Book ID: ");
                    int addBookId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    library.addBook(addBookId, title, author);
                    break;
                case 5:
                    System.out.print("Enter Book ID: ");
                    int remBookId = sc.nextInt();
                    library.removeBook(remBookId);
                    break;
                case 6:
                    System.out.print("Enter Book ID: ");
                    int updBookId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Title: ");
                    String newTitle = sc.nextLine();
                    System.out.print("Enter New Author: ");
                    String newAuthor = sc.nextLine();
                    library.updateBook(updBookId, newTitle, newAuthor);
                    break;
                case 7:
                    library.showAllBooks();
                    break;
                case 8:
                    System.out.print("Enter Member ID: ");
                    int remMemId = sc.nextInt();
                    library.removeMember(remMemId);
                    break;
                case 9:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
