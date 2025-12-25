public class Book {
    private int id;
    private String title;
    private String author;
    private boolean issued;

    public Book(int id, String title, String author, boolean issued) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = issued;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return issued;
    }

    public void issueBook() {
        issued = true;
    }

    public void returnBook() {
        issued = false;
    }

    public String toFileString() {
        return id + "," + title + "," + author + "," + issued;
    }

    @Override
    public String toString() {
        return id + " | " + title + " | " + author + " | " +
                (issued ? "Issued" : "Available");
    }
}
