package framework.objects;

import com.github.javafaker.Faker;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class customer extends personal {
    private String companyName;
    private String password;
    Properties pros = new Properties();
    {
        try {
            InputStream input = new FileInputStream("src/test/java/framework/supporter/resources/config.properties");
            pros.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public customer(String lastName, String firstName, String DOB, String email, String companyName) {
        super(lastName, firstName, DOB, email);
        this.companyName = companyName;
        this.password = pros.getProperty("password");
    }

    public customer() {
        super();
        this.companyName = faker.company().name();
        this.password = pros.getProperty("password");
    }

    public void logCustomerInfo() {
        System.out.println(this.getFirstName());
        System.out.println(this.getLastName());
        System.out.println(this.getDOB());
        System.out.println(this.getEmail());
        System.out.println(this.getCompanyName());
    }
    public String getCompanyName() {
        return companyName;
    }
    public String getPassword() {
        return password;
    }
}
