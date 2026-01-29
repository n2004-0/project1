package dao;

import model.Expense;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ExpenseDAO {

    public void addExpense(Expense e) {

        String sql =
            "INSERT INTO expenses(title, category, amount, expense_date) VALUES (?,?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, e.getTitle());
            ps.setString(2, e.getCategory());
            ps.setDouble(3, e.getAmount());
            ps.setDate(4, e.getExpenseDate());

            ps.executeUpdate();
            System.out.println("✅ Expense Added Successfully!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 👇 THIS METHOD MUST EXIST
    public void viewAllExpenses() {

        String sql = "SELECT * FROM expenses";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\nID | Title | Category | Amount | Date");
            System.out.println("-------------------------------------");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("title") + " | " +
                    rs.getString("category") + " | " +
                    rs.getDouble("amount") + " | " +
                    rs.getDate("expense_date")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
