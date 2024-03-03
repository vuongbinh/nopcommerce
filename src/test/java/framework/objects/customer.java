package framework.objects;

import java.util.Date;

public class customer extends personal {
    private String companyName;
    private String password;
    public customer(String lastName, String firstName, Date DOB, String email,String companyName) {
        super(lastName, firstName, DOB, email);
        this.companyName = companyName;
        this.password = "Test!234";
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
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
