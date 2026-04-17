package com.example.movie.menu;

import java.util.Scanner;

import com.example.movie.service.bookingService;
import com.example.movie.service.memberService;
import com.example.movie.service.movieService;

public class Menu {

	private final movieService movieService;
	private final memberService memberService;
	private final bookingService bookingService;
	private final Scanner scanner;

	public Menu() {
		this.movieService = new movieService();
		this.memberService = new memberService();
		this.bookingService = new bookingService();
		this.scanner = new Scanner(System.in);
	}

	public static void main(String[] args) {
		new Menu().start();
	}

	public void start() {
		while (true) {
			printMenu();
			int choice = readInt("Enter your choice: ");

			switch (choice) {
				case 1 -> addMovie();
				case 2 -> movieService.showAllMovies();
				case 3 -> searchMovieById();
				case 4 -> updateMoviePrice();
				case 5 -> deleteMovie();
				case 6 -> addMember();
				case 7 -> memberService.showAllMembers();
				case 8 -> searchMemberById();
				case 9 -> deleteMember();
				case 10 -> bookTicket();
				case 11 -> cancelTicket();
					case 12 -> bookingService.showBooking();
					case 13 -> showTotalAmount();
				case 0 -> {
					System.out.println("Exiting application...");
					scanner.close();
					return;
				}
				default -> System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private void printMenu() {
		System.out.println();
		System.out.println("========== Movie Operations ==========");
		System.out.println("1. Add Movie");
		System.out.println("2. Show All Movies");
		System.out.println("3. Search Movie by Id");
		System.out.println("4. Update Price");
		System.out.println("5. Delete Movie");
		System.out.println("========== Member Operations ==========");
		System.out.println("6. Add Member");
		System.out.println("7. Show All Members");
		System.out.println("8. Search Member by Id");
		System.out.println("9. Delete Member");
		System.out.println("========== Booking Operations ==========");
		System.out.println("10. Book Ticket");
		System.out.println("11. Cancel Ticket");
		System.out.println("12. Show Booking");
		System.out.println("13. Details Total Amount");
		System.out.println("0. Exit");
	}

	private void addMovie() {
		System.out.print("Enter movie name: ");
		String movieName = scanner.nextLine().trim();
		double price = readDouble("Enter price: ");
		int seats = readInt("Enter seats: ");
		movieService.addMovie(movieName, price, seats);
	}

	private void searchMovieById() {
		int id = readInt("Enter movie id: ");
		movieService.searchMovieById(id);
	}

	private void updateMoviePrice() {
		int id = readInt("Enter movie id: ");
		double newPrice = readDouble("Enter new price: ");
		movieService.updateMoviePrice(id, newPrice);
	}

	private void deleteMovie() {
		int id = readInt("Enter movie id: ");
		movieService.deleteMovie(id);
	}

	private void addMember() {
		System.out.print("Enter member name: ");
		String memberName = scanner.nextLine().trim();
		memberService.addMember(memberName);
	}

	private void searchMemberById() {
		int id = readInt("Enter member id: ");
		memberService.searchMemberById(id);
	}

	private void deleteMember() {
		int id = readInt("Enter member id: ");
		memberService.deleteMember(id);
	}

	private void bookTicket() {
		int memberId = readInt("Enter member id: ");
		int movieId = readInt("Enter movie id: ");
		int ticketCount = readInt("Enter ticket count: ");
		bookingService.bookTicket(memberId, movieId, ticketCount);
	}

	private void cancelTicket() {
		int memberId = readInt("Enter member id: ");
		int ticketCount = readInt("Enter ticket count: ");
		bookingService.cancelTicket(memberId, ticketCount);
	}

	private void showTotalAmount() {
		int memberId = readInt("Enter member id: ");
		bookingService.detailsTotalAmount(memberId);
	}

	private int readInt(String prompt) {
		while (true) {
			try {
				System.out.print(prompt);
				return Integer.parseInt(scanner.nextLine().trim());
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid number.");
			}
		}
	}

	private double readDouble(String prompt) {
		while (true) {
			try {
				System.out.print(prompt);
				return Double.parseDouble(scanner.nextLine().trim());
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid decimal number.");
			}
		}
	}
}
