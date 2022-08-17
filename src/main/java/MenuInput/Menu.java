package MenuInput;

import Classes.Opportunity;
import Classes.Lead;

import java.util.Scanner;
import java.util.*;

public class Menu {

    static int id;

    public static void start() throws ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        String exit = null;
        while (exit != "exit") {

            System.out.println("List of available commands:\n- New Lead\n- Show Leads\n- Lookup Lead ID\n- Convert ID\n- Close Lost ID\n- Close Won ID\n- Exit");

            String command = input.nextLine().toLowerCase();


            exit = command;

            if (command.contains("lookup lead")) {
                String[] splitCommand = command.split(" ");
                String id = splitCommand[splitCommand.length-1];

                Lead.lookUpLead(Integer.parseInt(id));
            }
            switch (command) {



                case "new lead" -> Lead.newLead();

                case "show leads" -> Lead.showLeads();

                case "lookup Lead ID" -> {
                    System.out.println("Write the Lead Id:");
                    try {
                        id = input.nextInt();
                        Lead.lookUpLead(id);
                    }
                    catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }

                case "convert id" -> {
                    Lead.convertID(id);
                    try {
                        int id2 = input.nextInt();
                        Lead.convertID(id2);
                    } catch (InputMismatchException e) {
                        System.err.println("Invalid input, please write a valid Id number");
                    }
                }

                case "close lost id" -> {
                    System.out.println("Write the Oportunity Id");
                    try {
                        int idOpp = input.nextInt();
                        Opportunity.closeLost(idOpp);
                    } catch (InputMismatchException e) {
                        throw e;
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }


                case "close won id" -> {
                    System.out.println("Write the Oportunity Id");
                    try {
                        int idOpp2 = input.nextInt();
                        Opportunity.closeWon(idOpp2);

                    } catch (InputMismatchException e) {
                        System.err.println("Invalid input, please write a valid Id number");

                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }

                default -> {
                    if(command != "exit")
                        System.out.println("The Command doesn't exist try again");
                }

            }
        }
    }

}
