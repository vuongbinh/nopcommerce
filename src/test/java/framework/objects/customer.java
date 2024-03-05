package framework.objects;

import java.io.*;
import java.util.Properties;

public class customer extends personal {
    Properties pros = new Properties();
    private final String companyName;
    private final String password;

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
        try {
            pros.setProperty("email",this.getEmail());
            pros.setProperty("password",this.password);
            OutputStream output = new FileOutputStream("src/test/java/framework/supporter/resources/config.properties");
            pros.store(output,null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPassword() {
        return password;
    }
}
