import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = s.nextInt();
            s.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    int id = s.nextInt();
                    s.nextLine();
                    System.out.print("Title: ");
                    String title = s.nextLine();
                    System.out.print("Author: ");
                    String author = s.nextLine();
                    library.addBook(new Book(id, title, author, false));
                    break;

                case 2:
                    library.viewBooks();
                    break;

                case 3:
                    System.out.print("Enter book ID: ");
                    library.issueBook(s.nextInt());
                    break;

                case 4:
                    System.out.print("Enter book ID: ");
                    library.returnBook(s.nextInt());
                    break;

                case 5:
                    System.out.print("Enter keyword: ");
                    library.searchBook(s.nextLine());
                    break;

                case 6:
                    System.out.println("Exiting...");
                    s.close();   // ✅ Proper resource cleanup
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

