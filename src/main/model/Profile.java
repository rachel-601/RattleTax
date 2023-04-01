package model;

// Represents profile of user who is filing T4
public class Profile {
    private String firstName;
    private String lastName;
    private int sin;
    private String dob;
    private String address;
    private Boolean marital;

    public Profile(String firstName, String lastName, int sin, String dob, String address, Boolean marital) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sin = sin;
        this.dob = dob;
        this.address = address;
        this.marital = marital;
    }

    // getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSin() {
        return sin;
    }

    public String getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public Boolean getMarital() {
        return marital;
    }

}
