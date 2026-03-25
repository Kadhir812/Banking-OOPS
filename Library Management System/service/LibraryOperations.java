package service;

public interface LibraryOperations {
    // Member operations
    void createMember(String name);
    void issueBook(int memberId, int bookId);
    void returnBook(int memberId);
    
    // Admin operations
    void addBook(int bookId, String title, String author);
    void removeBook(int bookId);
    void updateBook(int bookId, String newTitle, String newAuthor);
    void showAllBooks();
    void removeMember(int memberId);
}
