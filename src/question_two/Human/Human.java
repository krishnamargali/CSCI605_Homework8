package question_two.Human;

import java.sql.Date;

public class Human implements Comparable<Human> {
    Date dateOfBirth;
    String firstName;
    String userId;

    public Human(Date dateOfBirth, String firstName, String userId) {
        this.dateOfBirth = dateOfBirth;
        this.firstName = firstName;
        this.userId = userId;
    }

    @Override
    public int compareTo(Human anotherHuman) {
        return this.dateOfBirth.compareTo(anotherHuman.dateOfBirth);
    }

    @Override
    public String toString() {
        return "Human{" +
                "dateOfBirth=" + dateOfBirth +
                ", firstName='" + firstName + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
