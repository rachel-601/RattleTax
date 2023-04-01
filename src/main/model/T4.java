package model;

import java.util.HashMap;

// Represents the T4 form
public class T4 {
    private Profile user;
    private int year;
    private String employer;
    private Integer id;
    private Double input;
    private HashMap<Integer, Double> t4 = new HashMap<>();

    public T4(Profile user, int year, String employer) {
        this.user = user;
        this.year = year;
        this.employer = employer;
        t4.put(54, 0.0);
        t4.put(12, (double) user.getSin());
        t4.put(14, 0.0);
        t4.put(22, 0.0);
        t4.put(16, 0.0);
        t4.put(24, 0.0);
        t4.put(17, 0.0);
        t4.put(26, 0.0);
        t4.put(18, 0.0);
        t4.put(44, 0.0);
        t4.put(20, 0.0);
        t4.put(46, 0.0);
        t4.put(52, 0.0);
        t4.put(50, 0.0);
        t4.put(55, 0.0);
        t4.put(56, 0.0);
    }

    // EFFECTS: fills in box with
    public void fillBox(Integer id, Double input) {
        t4.replace(id, input);
    }

    //
}
