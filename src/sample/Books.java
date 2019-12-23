package sample;

public class Books {
    private String bookId;
    private String author;
    private String name;
    private String subject;
    private String status;
    private int price;
    private int No_OfBooks;
    private String edition;

    public Books(String title, String author, String name, String subject, String edition, int price, int No_OfBooks) {
        this.bookId = bookId;
        this.author = this.author;
        this.name = this.name;
        this.subject = this.subject;
        this.status = status;
        this.price = this.price;
        No_OfBooks = No_OfBooks;
        this.edition = this.edition;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNo_OfBooks() {
        return No_OfBooks;
    }

    public void setNo_OfBooks(int no_OfBooks) {
        No_OfBooks = no_OfBooks;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }
}
