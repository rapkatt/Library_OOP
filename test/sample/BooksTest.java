package sample;

import org.junit.Test;

import static org.junit.Assert.*;

public class BooksTest {

    Books book = new Books("Green Mile", "King","litress", "Fantasy",2);
    @Test
    public void testClassName(){
        assertEquals("Books",book.getClass().getSimpleName());
    }

    @Test
    public void setnumOfBook() {
        book.setnumOfBook(10);
        assertEquals(10,book.getNumOfBook());
    }

    @Test
    public void getBookId() {
        assertEquals(2,book.getNumOfBook());
    }

    @Test
    public void getTitle() {
        assertEquals("Green Mile",book.getTitle());
    }

    @Test
    public void getAuthor() {
        assertEquals("King",book.getAuthor());
    }

    @Test
    public void getEdition() {
        assertEquals("litress",book.getEdition());
    }

    @Test
    public void getSubject() {
        assertEquals("Fantasy",book.getSubject());
    }

    @Test
    public void getNumOfBook() {
        assertEquals(2,book.getNumOfBook());

    }
    @Test
    public void setTitle(){
        book.setTitle("To Kill a Mockingbird");
        assertEquals("To Kill a Mockingbird", book.getTitle());
    }
    @Test
    public void setAuthor(){
        book.setAuthor("Harper");
        assertEquals("Harper", book.getAuthor());
    }

    @Test
    public void setEdition(){
        book.setEdition("Act");
        assertEquals("Act", book.getEdition());
    }
    @Test
    public void setSubject(){
        book.setSubject("True story");
        assertEquals("True story",book.getSubject());
    }
}