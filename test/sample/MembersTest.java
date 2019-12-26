package sample;
import org.junit.Test;
import static org.junit.Assert.*;

public class MembersTest {

    Members user = new Members("Rapkat","Baudunov","rapkatt","0775580","Bishkek","0550333508");

    @Test
    public void testClassName(){
        assertEquals("Members",user.getClass().getSimpleName());
    }
//    @Test
//    public void testPackageName(){
//        assertEquals("Sample",user.getClass().getPackageName());
//    }

    @Test
    public void getFirstName() {
        assertEquals("Rapkat",user.getFirstName());
    }

    @Test
    public void setFirstName() {
        user.setFirstName("Amir");
        assertEquals("Amir",user.getFirstName());

    }

    @Test
    public void getLastName() {
        assertEquals("Baudunov",user.getLastName());
    }

    @Test
    public void setLastName() {
        user.setLastName("Ismailov");
        assertEquals("Ismailov",user.getLastName());
    }

    @Test
    public void getUserName() {
        assertEquals("rapkatt",user.getUserName());

    }

    @Test
    public void setUserName() {
        user.setUserName("Amir");
        assertEquals("Amir",user.getUserName());
    }

    @Test
    public void getPassword() {
        assertEquals("0775580",user.getPassword());
    }

    @Test
    public void setPassword() {
        user.setPassword("123123");
        assertEquals("123123",user.getPassword());
    }

    @Test
    public void getLocation() {
        assertEquals("Bishkek",user.getLocation());

    }

    @Test
    public void setLocation() {
        user.setLocation("Bishkek");
        assertEquals("Bishkek",user.getLocation());

    }


    @Test
    public void setNoBooksIssue() {
        user.setNoBooksIssue("10");
        assertEquals("10",user.getNoBooksIssue());
    }

    @Test
    public void getPh_no() {
        assertEquals("0550333508",user.getPh_no());
    }

    @Test
    public void setPh_no() {
        user.setPh_no("0550333508");
        assertEquals("0550333508",user.getPh_no());

    }
}