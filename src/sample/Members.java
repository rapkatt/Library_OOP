package sample;

public class Members{
   private String firstName;
   private String lastName;
   private String userName;
   private String password;
   private String location;
   private String NoBooksIssue;
   private final int maxBookLimit =20;
   private String ph_no;
    private int memberId;

    public Members(String firstName, String lastName, String userName,
                   String password, String location,
                   String ph_no) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.location = location;
        this.ph_no =ph_no;
    }

    public Members() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNoBooksIssue() {
        return NoBooksIssue;
    }

    public void setNoBooksIssue(String noBooksIssue) {
        NoBooksIssue = noBooksIssue;
    }

    public String getPh_no() {
        return ph_no;
    }

    public void setPh_no(String ph_no) {
        this.ph_no = ph_no;
    }
}
