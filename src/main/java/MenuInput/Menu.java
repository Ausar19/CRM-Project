package MenuInput;

import Lead.Lead;

import java.util.Scanner;
import java.util.*;

public class Menu {

    public static void start() {
        Scanner input = new Scanner(System.in);
        String exit = null;
        while (exit != "exit") {

            System.out.println("Write the preferred command:\n- New Lead\n- Show Leads\n- Lookup Leads ID\n- Convert ID\n- Close Lost ID\n- Close Won ID\n- Exit");

            String command = input.nextLine().toLowerCase();

            exit = command;
            switch (command) {
                case "new lead" -> Lead.NewLead();

                case "show leads" -> Lead.showLeads();

                case "lookup leads id" -> System.out.println("Write the Lead Id:");

                    try {
                        int id = input.nextInt();
                        Lead.LookUpLead(id);
                        break;
                    } catch (InputMismatchException e) {
                        System.err.println("Invalid input, please write a valid Id number");
                        break;
                    }


                case "convert id" -> Lead.convertID(int id);
                try {
                    int id2 = input.nextInt();
                    Lead.convertID(id2);
                    break;
                } catch (InputMismatchException e) {
                    System.err.println("Invalid input, please write a valid Id number");
                    break;
                }

                case "close lost id" -> System.out.println("Write the Oportunity Id");
                try {
                    int idOpp = input.nextInt();
                    Opportunity.closeLostId(idOpp);
                    break;
                } catch (InputMismatchException e) {
                    System.err.println("Invalid input, please write a valid Id number");
                    break;
                }


                case "close won id" -> System.out.println("Write the Oportunity Id");
                try {
                    int idOpp2 = input.nextInt();
                    Opportunity.closeWonId(idOpp2);
                    break;
                } catch (InputMismatchException e) {
                    System.err.println("Invalid input, please write a valid Id number");
                    break;
                }

                default -> {
                    if(command != "exit")
                            System.out.println("The Command doesn't exist try again");
                }

            }
        }

    }
//Contenido Clase Opportunity
    public void closeLostId(int id){
        for(int i = 0, opportunityList.size(), i++){
            if(opportunityList.get(i).getId() == id){
                opportunityList.get(i).setStatus(Status.CLOSED_LOST);
            }
        }System.err.println("Invalid Id, please write another Id:");
    }

    public void closeWonId(int id){
        for(int i = 0, opportunityList.size(), i++){
            if(opportunityList.get(i).getId() == id){
                opportunityList.get(i).setStatus(Status.CLOSED_WON);
            }
        }System.err.println("Invalid Id, please write another Id:");
    }

}
