package MenuInput;

import java.util.Scanner;
import java.util.*;

public class Menu {

    public static void start() {

        Scanner input = new Scanner(System.in);
        System.out.println("Write the preferred command:\n- New Lead\n- Show Leads\n- Lookup Leads ID\n- Convert ID\n- Close Lost ID\n- Close Won ID");
        String command = input.nextLine();
        switch() {
            case "new lead" ->
                //metodo New lead
            case "show leads" -> {
                for (int i = 0; i < Lead.getLeadList().size(); i++) {
                    System.out.println(Lead.getLeadList().get(i));
                }
            }//metodo show leads
            case "lookup leads id" ->
                //metodo lookup leads id
            case "convert id" ->
                //metodo convert id
            case "close lost id" ->
                //metodo close lost id
            case "close won id" ->
                //metodo close won id
            default ->
                System.out.println("The Command doesn't exist try again");

        }




    }



}
