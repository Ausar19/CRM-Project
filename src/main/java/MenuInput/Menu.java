package MenuInput;

import Classes.Account;
import Classes.Opportunity;
import Classes.Lead;

import java.util.Scanner;
import java.util.*;

public class Menu {

    static int id;

    public static void start() throws ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        String exit = null;
        int id = 0;
        while (!Objects.equals(exit, "exit")) {

            System.out.println("List of available commands:\n- New Lead\n- Show Leads\n- Lookup Lead ID\n- Convert ID\n- Close Lost ID\n- Close Won ID\n- Exit");

            String command = input.nextLine().toLowerCase().trim();

            exit = command;

            if (command.contains("lookup account") || command.contains("lookup opportunity") ||
                command.contains("lookup lead") || command.contains("close lost") || command.contains("close won")) {
                String[] splitCommand = command.split(" ");
                id = Integer.parseInt(splitCommand[splitCommand.length - 1]);

                command = splitCommand[0] + " " + splitCommand[1];

            } else if (command.contains("convert")) {
                String[] splitCommand = command.split(" ");
                id = Integer.parseInt(splitCommand[splitCommand.length - 1]);
                command = splitCommand[0];
            }
            switch (command) {

                case "new lead" -> Lead.newLead();

                case "show leads" -> Lead.showLeads();

                case "show opportunities" -> Opportunity.showOpportunities();

                case "show accounts" -> Account.showAccounts();

                case "lookup lead" -> Lead.lookUpLead(id);

                case "lookup opportunity" -> Opportunity.lookUpOpportunity(id);

                case "lookup account" -> Account.lookUpAccount(id);

                case "convert" -> Lead.convertID(id);

                case "close lost" -> Opportunity.closeLost(id);

                case "close won" -> Opportunity.closeWon(id);

                default -> {
                    if (!command.equals("exit")) System.out.println("The Command doesn't exist try again");

                }
            }
        }
    }
}