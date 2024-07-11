package javaProject;

public class Contact {
    private String name;
    private String phoneNo;
    private String emailId;
    final String red = "\u001B[31m";
    final String resetColor = "\u001B[0m";
    final String green = "\u001B[32m";
    final String yellow = "\u001B[33m";
    public Contact(String name,String phoneNo, String emailId) {
        this.name = name;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void displayContact(){
        System.out.println("Name: "+green+""+name+" "+resetColor);
        System.out.println("Mobile Number: "+green+""+phoneNo+" "+resetColor);
        System.out.println("Email ID: "+green+""+emailId+" "+resetColor);
    }
}
