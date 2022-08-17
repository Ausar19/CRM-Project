package Lead;

import java.util.*;
import java.util.regex.*;

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
        boolean incorrectInput = true;
        boolean found = false;

        System.out.println("Press Enter to process the conversion or type 'exit' to get back to the main Menu.");
        String exit = input.nextLine();

        for (int i = 0; i < leadList.size(); i++) {
            if (leadList.get(i).getID() == idNum) {

                found = true;

                while (incorrectInput && !Objects.equals(exit, "exit")) {
                    try {

                        // Collect Opportunity parameters - number of trucks and product
                        System.out.println("Fill in the following fields.");
                        System.out.println("Number of trucks: ");
                        int truckNum = input.nextInt();
                        System.out.println("Select the product (insert the number)\n1 - BOX\n2 - FLATBED\n3 - HYBRID");
                        int chosenOne = input.nextInt();

                        Product product = null;
                        while (product == null) {

                            switch (chosenOne) {
                                case 1 -> product = Product.BOX;
                                case 2 -> product = Product.FLATBED;
                                case 3 -> product = Product.HYBRID;
                                default -> {
                                    System.out.println("Invalid number, try again.");
                                    chosenOne = input.nextInt();
                                }
                            }
                        }
                        //Creates a new Opportunity with the Lead's data
                        Contact contact = new Contact(leadList.get(i).getName(), leadList.get(i).getPhoneNumber(), leadList.get(i).getEmail(), leadList.get(i).getCompanyName());
                        Opportunity opportunity = new Opportunity(product, truckNum, contact, Status.OPEN);
                        Opportunity.opportunitiesList.add(opportunity);
                    } catch (InputMismatchException e) {
                        System.out.println("Please, insert a proper kind of data for each field.\n");
                        convertID(idNum);
                        break;
                    }

                    try {
                        //Account info

                        System.out.println("Opportunity successfully created! To complete the process you must create an Account.");
                        System.out.println("City name: ");
                        String city = input.next();
                        System.out.println("Country of the organization: ");
                        String country = input.next();
                        System.out.println("Number of employees: ");
                        int employees = input.nextInt();

                        System.out.println("Select the product (insert the number)\n1 - ECOMMERCE\n2 - MANUFACTURING\n3 - MEDICAL\n4 - PRODUCE\n5 - OTHER");
                        int chosenTwo = input.nextInt();

                        Industry industry = null;
                        while (industry == null) {
                            switch (chosenTwo) {
                                case 1 -> industry = Industry.ECOMMERCE;
                                case 2 -> industry = Industry.MANUFACTURING;
                                case 3 -> industry = Industry.MEDICAL;
                                case 4 -> industry = Industry.PRODUCE;
                                case 5 -> industry = Industry.OTHER;
                                default -> {
                                    System.out.println("Invalid number, try again.");
                                    chosenTwo = input.nextInt();
                                }
                            }
                        }

                        //Creates a new Account
                        Account account = new Account(industry, employees, city, country);
                        //Add Lead.Lead to another list and delete it from the current one
                        oldLeads.add(leadList.get(i));
                        leadList.remove(leadList.get(i));
                    } catch (InputMismatchException ex) {
                        System.out.println("Invalid number, repeat the process.\n");
                        convertID(idNum);


                    }
                    System.out.println("Account Created!\n");

                    System.out.println("Type 'exit' to return to the main Menu or 'new' to convert another Lead.");

                    while (true) {
                        String command = input.next().toLowerCase();
                        if ("exit".equals(command)) {
                            incorrectInput = false;
                            break;
                        } else if ("new".equals(command)) {
                            while (true) {
                                try {
                                    System.out.println("Insert a Id number: ");
                                    idNum = input.nextInt();
                                    convertID(idNum);
                                    break;
                                } catch (InputMismatchException exe) {
                                    System.out.println("Please, insert an Id number or type exit to leave.");
                                    break;
                                }
                            }
                            break;
                        }
                        System.out.println("Please, insert a valid command.");
                        break;
                    }
                }

            }

        }
        // ID not found
        if (!found)
            System.err.println("This Id doesn't match with any Lead, it could have been already converted into a Opportunity, you can verify typing 'Show Opportunities' in the main Menu, otherwise try again with the correct Id.");
            System.exit(1);
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