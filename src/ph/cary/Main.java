//Mortgage Calculator
// V2
// Refactoring and extracting methods and repetitive patterns

package ph.cary;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static int MONTHS_IN_YEAR = 12;
    final static int PERCENT = 100;

    public static void main(String[] args) {
        int principal = (int) read_input("Principal Loan ($1K - $1M): ", 1000, 1_000_000);
        double interest = read_input("Annual Interest (1% - 30%): ", 1,30);
        int years = (int) read_input("Period In Years (1yr - 30 yrs): ", 1,30);

        display_mortgage(principal, interest, years);
        display_payment_schedule(principal, interest, years);
    }

    public static double read_input(String prompt,  int min, int max) {
        Scanner scanner = new Scanner(System.in);
        double number;
        while(true) {
            System.out.print(prompt);
            number = scanner.nextDouble();

            if (number < min || number > max) {
                System.out.println("Enter within " + min + " and " + max);
            }
            else
                break;
        }
        return number;
    }

    public static double calc(int principal, double interest, int years) {
        double monthly_interest = (interest/PERCENT)/MONTHS_IN_YEAR;
        int monthly_payment = years * MONTHS_IN_YEAR;
        return principal * ((monthly_interest* Math.pow((1+monthly_interest), monthly_payment))/(Math.pow((1+monthly_interest), monthly_payment)-1));
    }

    public static double calc(int principal, double interest, int years, int p) {
        double monthly_interest = (interest/PERCENT)/MONTHS_IN_YEAR;
        int monthly_payment = years * MONTHS_IN_YEAR;

        return(principal * (Math.pow(1 + monthly_interest, monthly_payment) - Math.pow(1 + monthly_interest, p)))  /  (Math.pow(1 + monthly_interest, monthly_payment) - 1)  ;
    }

    public static void display_mortgage(int principal, double interest, int years) {
        System.out.println("\nMORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + NumberFormat.getCurrencyInstance().format(calc(principal, interest, years)));
    }

    public static void display_payment_schedule(int principal, double interest, int years) {
        System.out.println("\nPAYMENT SCHEDULE");
        System.out.println("----------------");
        for(int p = 1; p <= (years * MONTHS_IN_YEAR); p++){
            System.out.println(NumberFormat.getCurrencyInstance().format(calc(principal, interest, years, p)));
        }
    }
}
