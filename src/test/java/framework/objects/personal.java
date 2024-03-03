package framework.objects;

import java.text.SimpleDateFormat;
import java.util.Date;

public class personal {
    private String lastName;
    private String firstName;
    private Date DOB;
    private String email;

    public personal(String lastName, String firstName, Date DOB, String email) {
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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM-dd-yyyy");
        return simpleDateFormat.format(this.DOB);
    }

    public String getEmail() {
        return email;
    }
}
