package framework.objects;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;

public class personal {
    public Faker faker = new Faker();
    private final String lastName;
    private final String firstName;
    private final String DOB;
    private final String email;

    public personal() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM-dd-yyyy");
        this.lastName = faker.name().lastName();
        this.firstName = faker.name().firstName();
        this.DOB = simpleDateFormat.format(faker.date().birthday(18, 95));
        this.email = faker.internet().safeEmailAddress();
    }

    public personal(String lastName, String firstName, String DOB, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.DOB = DOB;
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getDOB() {
        return DOB;
    }

    public String getEmail() {
        return email;
    }
}
