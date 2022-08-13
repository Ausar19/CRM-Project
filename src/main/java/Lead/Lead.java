package Lead;

import java.util.List;
import java.util.Scanner;

public class Lead {

    private List<Lead> oldLeads;
    private List<Lead> leadList;


    public static void convertID(int idNum) {

        Scanner input = new Scanner(System.in);

        for (int i = 0; i < leadList.size(); i++) {
            if (leadList.get(i).getID() == idNum) {

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
}