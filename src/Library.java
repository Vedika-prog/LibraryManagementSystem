import java.io.*;
import java.util.*;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();
    private final String FILE_NAME = "books.txt";

    public Library() {
        loadBooks();
    }

    // Load data from file
    private void loadBooks() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                books.add(new Book(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        Boolean.parseBoolean(data[3])
                ));
            }
        } catch (IOException e) {
            System.out.println("Starting with empty library...");
        }
    }

    // Save data to file
    private void saveBooks() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Book book : books) {
                pw.println(book.toFileString());
            }
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    public void addBook(Book book) {
        books.add(book);
        saveBooks();
        System.out.println("Book added successfully.");
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        books.forEach(System.out::println);
    }

    public void issueBook(int id) {
        for (Book book : books) {
            if (book.getId() == id && !book.isIssued()) {
                book.issueBook();
                saveBooks();
                System.out.println("Book issued.");
                return;
            }
        }
        System.out.println("Book not available.");
    }

    public void returnBook(int id) {
        for (Book book : books) {
            if (book.getId() == id && book.isIssued()) {
                book.returnBook();
                saveBooks();
                System.out.println("Book returned.");
                return;
            }
        }
        System.out.println("Invalid return.");
    }

    public void searchBook(String keyword) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())
                    || book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No book found.");
        }
    }
}
