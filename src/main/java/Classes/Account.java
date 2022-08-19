package Classes;

import Classes.Enums.Industry;

import java.util.ArrayList;
import java.util.List;

public class Account {

    int id;
    Industry industry;
    int employeeCount;
    String city;
    String country;
    List<Contact> contactList;
    List<Opportunity> opportunityList;

    int idCounter = 0;

    public static List<Account> accountsList = new ArrayList<>();

    //constructor
    public Account(Industry industry, int employeeCount, String city, String country, List<Contact> contactList, List<Opportunity> opportunityList) {
        this.industry = industry;
        this.employeeCount = employeeCount;
        this.city = city;
        this.country = country;
        this.contactList = contactList;
        this.opportunityList = opportunityList;
    }


    public static void showAccounts() {
        if (accountsList.size() == 0) {
            System.out.println("Currently our systems don't have any Accounts in the database");
        }
        for (int i = 0; i < accountsList.size(); i++) {
            System.out.println("Account with ID: " + accountsList.get(i).getId() + "\n" +
                    accountsList.get(i).getIndustry() + " company based in: " + accountsList.get(i).getCity() + ", " +
                    accountsList.get(i).getCountry() + "\n" + accountsList.get(i).getEmployeeCount() + " employees.");
            System.out.println("===");
        }
    }

    public static void lookUpAccount(int id){
        if (accountsList.size() == 0){
            System.out.println("There are no Accounts saved in our database.");
        } else {
            for (int i = 0; i < accountsList.size(); i++) {
                Integer leadID = accountsList.get(i).getId();
                if (leadID.equals(id)) {

                    System.out.println(
                            "This ID corresponds to the account from a " + accountsList.get(i).getIndustry() +
                            " company with " + accountsList.get(i).getEmployeeCount() + "employees. \n" +
                            "It's based in " + accountsList.get(i).getCity() + ", " + accountsList.get(i).getCountry() + ".");
                } else {
                    System.out.println("The ID you introduced doesn't correspond with any Account in our database.");
                }
            }
        }

    }


    //getters
    public int getId() {
        return id;
    }

    public Industry getIndustry() {
        return industry;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public List<Opportunity> getOpportunityList() {
        return opportunityList;
    }

    //setters
    public void setId(int id) {
        this.id = idCounter++;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public void setOpportunityList(List<Opportunity> opportunityList) {
        this.opportunityList = opportunityList;
    }
}
