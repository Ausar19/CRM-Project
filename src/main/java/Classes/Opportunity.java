package Classes;

import Classes.Enums.Product;
import Classes.Enums.Status;

import java.util.ArrayList;
import java.util.List;

public class Opportunity {

    private int id;
    private Product product;
    private int quantity;
    private Contact decisionMaker;
    private Status status;

    private static int idCounter;


    public static List<Opportunity> opportunitiesList = new ArrayList<>();


    //constructor
    public Opportunity(Product product, int quantity, Contact decisionMaker, Status status) {
        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.status = status;
    }

    public static void closeLost(int id) throws ClassNotFoundException {
        boolean found = false;
        for (int i = 0; i < opportunitiesList.size(); i++) {
            if (opportunitiesList.get(i).getId() == id) {
                opportunitiesList.get(i).setStatus(Status.CLOSED_LOST);
                found = true;
            }
        }
        if (!found) {
            System.out.println("The ID provided does not correspond to any existing opportunities.");
        }
    }

    public static void closeWon(int id){
        boolean found = false;
        for (int i = 0; i < opportunitiesList.size(); i++) {
            if (opportunitiesList.get(i).getId() == id) {
                opportunitiesList.get(i).setStatus(Status.CLOSED_WON);
                found = true;
            }
        }
        if (!found) {
            System.out.println("The ID provided does not correspond to any existing opportunities.");
        }
    }


    public static void showOpportunities() {
        if (opportunitiesList.size() == 0) {
            System.out.println("Currently our systems don't have any Opportunities in the database");
        }
        for (int i = 0; i < opportunitiesList.size(); i++) {
            System.out.println("Opportunity with ID: " + opportunitiesList.get(i).getId() + "\n Product type: " + opportunitiesList.get(i).getProduct() + "\n Quantity of trucks: " + opportunitiesList.get(i).getQuantity());
            System.out.println("===");
        }
    }

    public static void lookUpOpportunity(int id) {
        if (opportunitiesList.size() == 0){
            System.out.println("There are no Opportunities saved in our database.");
        } else {
            for (int i = 0; i < opportunitiesList.size(); i++) {
                Integer leadID = opportunitiesList.get(i).getId();
                if (leadID.equals(id)) {
                    System.out.println(
                            "This ID corresponds to the opportunity created by " + opportunitiesList.get(i).getDecisionMaker().getName() + "\n" +
                                    "It's " + opportunitiesList.get(i).getQuantity() + "trucks of " + opportunitiesList.get(i).getProduct() + "products. \n" +
                                    "It's current status is; " + opportunitiesList.get(i).getStatus());
                } else {
                    System.out.println("The ID you introduced doesn't correspond with any Opportunities in our database.");
                }
            }
        }

    }

    //getters
    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public Contact getDecisionMaker() {
        return decisionMaker;
    }

    public Status getStatus() {
        return status;
    }


    //setters
    public void setId(int id) {
        this.id = idCounter++;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDecisionMaker(Contact decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

