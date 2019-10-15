import java.util.*;
import java.io.*;
public class TestExpense{
    public static void main (String[] args) throws FileNotFoundException{
        try{
            File input = new File(args[0]);
            Scanner scan = new Scanner(input);
            String accountType = scan.next(), first = scan.next(), last = scan.next(), name = first + " " + last;
            PrintWriter output = new PrintWriter("output.txt");
            try{
                ExpenseAccount acc = createAccount(accountType, name);
                double initialBalance = acc.getBalance();
                while(scan.hasNextLine()){
                    double charge = scan.nextInt();
                    try{
                        acc.makePayment(charge);
                    }
                    catch(AccountDepletedException ex){
                        output.println(ex.getMessage());
                    }
                }
                acc.printInvoice(scan, output);
            }
            catch(UnknownAccountException ex){
                output.println("Invoice For: " + name);
                output.println(ex.getMessage());
                output.close();
                scan.close();
            }
        }
        catch(FileNotFoundException ex){
            System.out.println("The file could not be found");
        }
    }
    public static ExpenseAccount createAccount(String accountType, String name) throws UnknownAccountException{
        if(accountType.equals("E")){
            return new ExpenseAccount(name);
        }
        else if(accountType.equals("G")){
            return new GraderExpense(name, 2000);
        }
        else if(accountType.equals("F")){
            return new FacultyExpense(name, 2000);
        }
        else{
            throw new UnknownAccountException();
        }
    }
}