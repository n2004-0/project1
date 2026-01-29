package main;

import dao.ExpenseDAO;
import model.Expense;

import java.sql.Date;
import java.util.Scanner;

public class ExpenseTrackerApp {
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ExpenseDAO dao = new ExpenseDAO();

        while (true) {
            System.out.println("\n====== EXPENSE TRACKER ======");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    Expense e = new Expense();
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    e.setTitle(sc.nextLine());

                    System.out.print("Enter Category: ");
                    e.setCategory(sc.nextLine());

                    System.out.print("Enter Amount: ");
                    e.setAmount(sc.nextDouble());

                    e.setExpenseDate(
                        new Date(System.currentTimeMillis())
                    );

                    dao.addExpense(e);
                    break;

                case 2:
                    dao.viewAllExpenses();
                    break;

                case 3:
                    System.out.println("👋 Exiting... Bye!");
                    System.exit(0);

                default:
                    System.out.println("❌ Invalid choice");
            }
        }
    }

}
