package Classes;

import Classes.Enums.Industry;
import Classes.Enums.Product;
import Classes.Enums.Status;

import java.security.InvalidParameterException;
import java.util.*;
import java.util.regex.Pattern;

public class Lead {

    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;


    private static int idCounter;


    //constructor
    public Lead(String name, String phoneNumber, String email, String companyName) {
        setId();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
    }

    static ArrayList<Lead> leadList = new ArrayList<Lead>();

    static ArrayList<Lead> oldLeadList = new ArrayList<Lead>();

    public static void newLead() {

        String leadName = "";
        String leadPhone = "";
        String leadEmail = "";
        String leadCompany = "";

        Scanner sc = new Scanner(System.in);
        boolean correct = false;

        while (!correct) {
            try {
                System.out.println("Please input the new Lead's name");
                leadName = sc.nextLine();
                if (leadName.matches("/^([A-Z][a-z]+([ ]?[a-z]?['-]?[A-Z][a-z]+)*)$/")) {
                    correct = true;
                }
                else {
                    throw new InvalidParameterException("The name introduced is not valid, please only use letters");
                }
            } catch (InvalidParameterException e) {

                System.out.println("The name introduced is not valid, please only use letters");
            }
        }

        correct = false;
        while (!correct) {

            try {
                System.out.println("Please input the new Lead's phone number");
                leadPhone = sc.nextLine();
                if (leadPhone.matches("/^\\s*(?:\\+?(\\d{1,3}))?([-. (]*(\\d{3})[-. )]*)?((\\d{3})[-. ]*(\\d{2,4})(?:[-.x ]*(\\d+))?)\\s*$/gm")) {
                    correct = true;
                }
                else {
                    throw new InvalidParameterException("The phone number introduced is not valid, please only use letters");
                }
            } catch (InvalidParameterException e) {
                correct = false;
                System.out.println("The phone number introduced is not valid, please only use letters");
            }
        }
        while (!correct) {
            correct = false;
            try {
                System.out.println("Please input the new Lead's email");
                leadEmail = sc.nextLine();
                if (leadEmail.matches("/^(?:(?:[\\w`~!#$%^&*\\-=+;:{}'|,?\\/]+(?:(?:\\.(?:\"(?:\\\\?[\\w`~!#$%^&*\\-=+;:{}'|,?\\/\\.()<>\\[\\] @]|\\\\\"|\\\\\\\\)*\"|[\\w`~!#$%^&*\\-=+;:{}'|,?\\/]+))*\\.[\\w`~!#$%^&*\\-=+;:{}'|,?\\/]+)?)|(?:\"(?:\\\\?[\\w`~!#$%^&*\\-=+;:{}'|,?\\/\\.()<>\\[\\] @]|\\\\\"|\\\\\\\\)+\"))@(?:[a-zA-Z\\d\\-]+(?:\\.[a-zA-Z\\d\\-]+)*|\\[\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\])$/gm"))
                {
                    correct = true;

                } else {
                    throw new InvalidParameterException("The email address introduced is not valid, please use the proper format");
                }
            } catch (InvalidParameterException e) {
                correct = false;
                System.out.println("The email address introduced is not valid, please use the proper format");
            }
        }

        while (!correct) {
            correct = false;
            try {
                System.out.println("Please input the new Lead's company name");
                leadCompany = sc.nextLine();
                if (leadCompany.matches("/^(?:(?:[\\w`~!#$%^&*\\-=+;:{}'|,?\\/]+(?:(?:\\.(?:\"(?:\\\\?[\\w`~!#$%^&*\\-=+;:{}'|,?\\/\\.()<>\\[\\] @]|\\\\\"|\\\\\\\\)*\"|[\\w`~!#$%^&*\\-=+;:{}'|,?\\/]+))*\\.[\\w`~!#$%^&*\\-=+;:{}'|,?\\/]+)?)|(?:\"(?:\\\\?[\\w`~!#$%^&*\\-=+;:{}'|,?\\/\\.()<>\\[\\] @]|\\\\\"|\\\\\\\\)+\"))@(?:[a-zA-Z\\d\\-]+(?:\\.[a-zA-Z\\d\\-]+)*|\\[\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\])$/gm"))
                {
                    correct = true;

                } else {
                    throw new InvalidParameterException("The company name introduced is not valid, please only use letters");
                }
            } catch (InvalidParameterException e) {
                correct = false;
                System.out.println("The company introduced is not valid, please only use letters");
            }
        }


        Lead newLead = new Lead(leadName, leadPhone, leadEmail, leadCompany);

        leadList.add(newLead);
    }

    public static void showLeads() {
        if (leadList.size() == 0) {
            throw new RuntimeException("Currently our systems don't have any Leads in the database");
        } else {
            for (int i = 0; i < leadList.size(); i++) {
                System.out.println("Lead with ID: " + leadList.get(i).getId() + " \n Name: " + leadList.get(i).getName());
                System.out.println("===");
            }
        }

    }

    public static void lookUpLead(int id) throws ClassNotFoundException {
        boolean found = false;
        for (int i = 0; i < leadList.size(); i++) {
            Integer leadID = leadList.get(i).getId();
            if (leadID.equals(id)) {
                System.out.println(
                        "This ID corresponds to the Lead: " + leadList.get(i).getName() + " \n " +
                                "Lead phone number: " + leadList.get(i).getPhoneNumber() + " \n" +
                                "Lead Company: " + leadList.get(i).getCompanyName());
                found = true;
            } else {
                for (int j = 0; j < oldLeadList.size(); j++) {
                    leadID = leadList.get(i).getId();
                    if (leadID.equals(id)) {
                        System.out.println("The ID you introduced corresponds to a Lead that has became an Opportunity " +
                                "and is no longer in our system");
                        found = true;
                    }
                }
            }
        }
        if (!found) {
            throw new ClassNotFoundException("The ID you introduced doesn't correspond to any Lead in our system.");
        }
    }

    public static void convertID(int idNum) {

        Scanner input = new Scanner(System.in);
        Pattern regex = Pattern.compile("[\sS]*[^a-z-A-Z]+");
        boolean found = false;

        //Since it's a long process, this allows the user to interrupt it from the beginning
        System.out.println("Press Enter to process the conversion or type 'exit' to quit.");
        String exit = input.nextLine();

        for (int i = 0; i < leadList.size(); i++) {
            if (leadList.get(i).getId() == idNum) {

                found = true;

                while (!Objects.equals(exit, "exit")) {
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
                        //Creates a new Contact with the Lead's data
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

                        while (city.matches(String.valueOf(regex))) {
                            System.out.println("Please, insert a valid city name: ");
                            city = input.next();
                        }

                        System.out.println("Country of the organization: ");
                        String country = input.next();

                        while (country.matches(String.valueOf(regex))) {
                            System.out.println("Please, insert a valid country name: ");
                            country = input.next();
                        }

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

                        //Creates a new Account and a list for Contact and Opportunity
                        List<Contact> contactList = new ArrayList<>();
                        List<Opportunity> opportunityList = new ArrayList<>();
                        Account account = new Account(industry, employees, city, country, contactList, opportunityList);

                        //Add Lead to another list and delete it from the current one
                        oldLeadList.add(leadList.get(i));
                        leadList.remove(leadList.get(i));
                    } catch (InputMismatchException ex) {
                        System.out.println("Invalid number, aborting process...\n");
                        convertID(idNum);


                    }
                    System.out.println("Account Created!\n");
                    break;
                }

            }

        }

        // ID not found
        if (!found && !exit.equals("exit")) {
            System.out.println("This Id doesn't match with any Lead, it could have been already converted into a Opportunity, you can verify typing 'Show Opportunities' in the main Menu, otherwise try again with the correct Id.");
        }
    }


    //getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getCompanyName() {
        return companyName;
    }

    //setters
    public void setId() {
        this.id = idCounter++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}