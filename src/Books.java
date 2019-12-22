public class Books {
    private String IsB_NNO;
    private String author;
    private String name;
    private int edition;
    private  int No_OfBooks;
    private String status;

    public Books(String isB_NNO, String author, String name,
                 int edition, int no_OfBooks, String status) {
        IsB_NNO = isB_NNO;
        this.author = author;
        this.name = name;
        this.edition = edition;
        No_OfBooks = no_OfBooks;
        this.status = status;
    }

    public String getIsB_NNO() {
        return IsB_NNO;
    }

    public void setIsB_NNO(String isB_NNO) {
        IsB_NNO = isB_NNO;
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

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public int getNo_OfBooks() {
        return No_OfBooks;
    }

    public void setNo_OfBooks(int no_OfBooks) {
        No_OfBooks = no_OfBooks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
