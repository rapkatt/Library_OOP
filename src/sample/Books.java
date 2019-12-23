package sample;

public class Books {
    private String bookId;
    private String title;
    private String author;
    private String edition;
    private int price;
    private String subject;
    private int No_OfBook;



    public Books(String title, String author, String subject, String edition, int price, int No_OfBook) {
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.price = price;
        this.subject = subject;
        this.No_OfBook = No_OfBook;

    }


    public void setPrice(int price) {
        this.price = price;
    }

    public void setNo_OfBook(int No_OfBook) {
        this.No_OfBook = No_OfBook;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getEdition() {
        return edition;
    }

    public int getPrice() {
        return price;
    }

    public String getSubject() {
        return subject;
    }

    public int getNumOfBook() {
        return No_OfBook;
    }
}
