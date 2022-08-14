package Lead;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lead {

    private int id;
    private String name;
    private int phoneNumber;
    private String email;
    private String companyName;

    //constructor
    public Lead(String name, int phoneNumber, String email, String companyName) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
    }

    static ArrayList<Lead> leadList = new ArrayList<Lead>();

    static ArrayList<Lead> oldLeadList = new ArrayList<Lead>();

    public static void NewLead() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please input the new Lead's name");
        String leadName = sc.nextLine();
        //exception si el nombre es incorrecto
        System.out.println("Please input the new Lead's phone number");
        String leadPhoneStr = sc.nextLine();
        //If() to see if it's numbers only and proper lenght, otherwise, return exception
        System.out.println("Please input the new Lead's email");
        String leadEmail = sc.nextLine();
        //Regex for emails to check if it's a valid email, return exception if not
        System.out.println("Please input the new Lead's company name");
        String leadCompany = sc.nextLine();

        int leadPhone = Integer.parseInt(leadPhoneStr);
        Lead newLead = new Lead(leadName, leadPhone, leadEmail, leadCompany);

        leadList.add(newLead);
    }

    public static void showLeads() {
        for (int i = 0; i < leadList.size(); i++) {
            System.out.println("Lead with ID: " + leadList.get(i).getId() " \n Name: " + leadList.get(i).getName());
            System.out.println("===");
        }
    }

    public static void LookUpLead(int id) {
        for (int i = 0; i < leadList.size(); i++) {
            Integer leadID = leadList.get(i).getId();
            if (leadID.equals(id)) {
                System.out.println(
                        "This ID corresponds to the Lead: " + leadList.get(i).getName() + " \n " +
                        "Lead phone number: " + leadList.get(i).getPhoneNumber() + " \n" +
                        "Lead Company: " + leadList.get(i).getCompanyName());
            } else {
                for (int j = 0; j < oldLeadList.size() ; j++) {
                    leadID = leadList.get(i).getId();
                    if (leadID.equals(id)) {
                        System.out.println("The ID you introduced corresponds to a Lead that has became an Opportunity " +
                                "and is no longer in our system");
                        //throw exception here?
                    }
                }
            }
        }
    }

    public static void convertID(int idNum) {

        Scanner input = new Scanner(System.in);

        for (int i = 0; i < leadList.size(); i++) {
            if (leadList.get(i).getId() == idNum) {

                // Collect Opportunity parameters - number of trucks and product
                System.out.println("Number of trucks: ");
                int truckNum = Integer.parseInt(input.nextLine());
                System.out.println("Select the product (insert the number)\n1 - BOX\n2 - FLATBED\n3 - HYBRID");
                String chosenOne = input.next();

                Product product = null;
                switch (chosenOne) {
                    case "1" -> product = Product.BOX;
                    case "2" -> product = Product.FLATBED;
                    case "3" -> product = Product.HYBRID;
                }

                //Account info
                System.out.println("City name: ");
                String city = input.next();
                System.out.println("Country of the organization: ");
                String country = input.next();
                System.out.println("Number of employees: ");
                int employees = Integer.parseInt(input.next());

                System.out.println("Select the product (insert the number)\n1 - ECOMMERCE\n2 - MANUFACTURING\n3 - MEDICAL\n4 - PRODUCE\n5 - OTHER");
                String chosenTwo = input.next();

                Industry industry = null;
                switch (chosenTwo) {
                    case "1" -> industry = Industry.ECOMMERCE;
                    case "2" -> industry = Industry.MANUFACTURING;
                    case "3" -> industry = Industry.MEDICAL;
                    case "4" -> industry = Industry.PRODUCE;
                    case "5" -> industry = Industry.OTHER;
                }

                //Creates a new Opportunity with the Lead.Lead's data
                Opportunity opportunity = new Opportunity(leadList.get(i).getName(), leadList.get(i).getPhoneNum(), leadList.get(i).getEmail(), leadList.get(i).getCompanyName(), product, truckNum);
                //Creates a new Account
                Account account = new Account(industry, employees, city, country);
                //Add Lead.Lead to another list and delete it from the current one
                oldLeads.add(leadList.get(i));
                leadList.remove(leadList.get(i));
            }
        }
        // ID not found
        System.err.println("This ID doesn't match with any Lead.Lead, it could have been converted in a Opportunity, type 'Show Opportunities' command to verify or insert the correct ID.");

    }

    //getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getCompanyName() {
        return companyName;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


}