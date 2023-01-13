package ATM_Project;

import java.text.DecimalFormat;
import java.util.*;
import java.io.IOException;


public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer,Integer> data = new HashMap<Integer, Integer>();

    /*Validate login information that customer number and pin number*/

    public void getLogin() throws IOException{
        int x = 1;

        do{
            try {

                data.put(7388180, 2023);
                data.put(8180441, 2024);

                System.out.println("Welcome to the ATM Project");

                System.out.print("Enter your Customer Number: ");
                setCustomerNumber(menuInput.nextInt());

                System.out.print("Enter your PIN Number: ");
                setPinNumber(menuInput.nextInt());
            }
            catch(Exception e) {
                System.out.println("\n" + "Invalid Character(s). Only Number." + "\n");
                x = 2;
            }
            for(Map.Entry entry: data.entrySet()) {
                if (entry.getKey().equals(getCustomerNumber()) && entry.getValue().equals(getPinNumber())) {
                    getAccountType();
                } else {
                    System.out.println("\n" + "Wrong Customer Number or Pin Number." + "\n");
                }
            }
        } while(x == 1);
    }

    /* Display Account Type Menu with selection */

    public void getAccountType() {
        System.out.println("Select the Account you want to access: ");
        System.out.println("Type 1: Checking Account");
        System.out.println("Type 2: Saving Account");
        System.out.println("Type 3: Exit");
        System.out.print("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Thank You for using this ATM, bye.");
                break;
            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getAccountType();
        }
    }
    public void getChecking(){
        System.out.println("Checking Account: ");
        System.out.println("Type 1: View Balance");
        System.out.println("Type 2: Withdraw Money");
        System.out.println("Type 3: Deposit Money");
        System.out.println("Type 4: Exit");
        System.out.print("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection){
            case 1:
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getChecking();
                break;
            case 4:
                System.out.println("Thank You for using this ATM,bye.");
                break;
            default:
                System.out.println("\n" + "Inalid Choice." + "\n");
                getChecking();
        }
    }

    public void getSaving(){
        System.out.println("Saving Account: ");
        System.out.println("Type 1: View Balance");
        System.out.println("Type 2: Withdraw Money");
        System.out.println("Type 3: Deposit Money");
        System.out.println("Type 4: Exit");
        System.out.print("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection){
            case 1:
                System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getSaving();
                break;
            case 4:
                System.out.println("Thank You for using this ATM,bye.");
                break;
            default:
                System.out.println("\n" + "Inalid Choice." + "\n");
                getSaving();
        }
    }
}
