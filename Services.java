import javax.swing.*;

public class Services {
    public static void deposit(String user) {
    String amountStr = JOptionPane.showInputDialog("Enter amount to deposit:");
    try {
        if (amountStr == null || amountStr.trim().isEmpty()) throw new NumberFormatException();
        int amount = Integer.parseInt(amountStr.trim());
        if (amount <= 0) throw new NumberFormatException();
        int current = Database.getBalance(user);
        Database.updateBalance(user, current + amount);
        Database.addTransaction(user, "Deposited Rs. " + amount);
        JOptionPane.showMessageDialog(null, "Deposited successfully.");
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Please enter a valid positive number.");
    }
    }


    public static void withdraw(String user) {
    String amountStr = JOptionPane.showInputDialog("Enter amount to withdraw:");
    try {
        if (amountStr == null || amountStr.trim().isEmpty()) throw new NumberFormatException();
        int amount = Integer.parseInt(amountStr.trim());
        int current = Database.getBalance(user);
        if (amount <= 0 || amount > current) throw new Exception("Invalid amount or insufficient funds.");
        Database.updateBalance(user, current - amount);
        Database.addTransaction(user, "Withdrew Rs. " + amount);
        JOptionPane.showMessageDialog(null, "Withdrawn successfully.");
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Please enter a valid number.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    }


    public static void checkBalance(String user) {
        JOptionPane.showMessageDialog(null, "Current balance: Rs. " + Database.getBalance(user));
    }

    public static void fundTransfer(String user) {
    String toUser = JOptionPane.showInputDialog("Enter recipient username:");
    String amountStr = JOptionPane.showInputDialog("Enter amount to transfer:");
    try {
        if (toUser == null || toUser.trim().isEmpty()) throw new Exception("Recipient username is empty.");
        if (!Database.users.containsKey(toUser)) throw new Exception("Recipient not found.");
        if (amountStr == null || amountStr.trim().isEmpty()) throw new NumberFormatException();
        int amount = Integer.parseInt(amountStr.trim());
        int current = Database.getBalance(user);
        if (amount <= 0 || amount > current) throw new Exception("Invalid amount or insufficient funds.");
        Database.updateBalance(user, current - amount);
        Database.updateBalance(toUser, Database.getBalance(toUser) + amount);
        Database.addTransaction(user, "Transferred Rs. " + amount + " to " + toUser);
        Database.addTransaction(toUser, "Received Rs. " + amount + " from " + user);
        JOptionPane.showMessageDialog(null, "Transfer successful.");
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Enter a valid amount.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Transfer failed: " + e.getMessage());
    }
    }
 
    public static void loanChecker() {
    String incomeStr = JOptionPane.showInputDialog("Enter monthly income:");
    try {
        if (incomeStr == null || incomeStr.trim().isEmpty()) throw new NumberFormatException();
        int income = Integer.parseInt(incomeStr.trim());
        String eligible = (income >= 20000) ? "Eligible" : "Not eligible";
        JOptionPane.showMessageDialog(null, "Loan eligibility: " + eligible);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Enter a valid income value.");
    }
    }

    public static void emiCalculator() {
    try {
        int loan = Integer.parseInt(JOptionPane.showInputDialog("Loan amount:").trim());
        int rate = Integer.parseInt(JOptionPane.showInputDialog("Interest rate (%):").trim());
        int time = Integer.parseInt(JOptionPane.showInputDialog("Time (years):").trim());
        double emi = (loan * rate * Math.pow(1 + rate / 100.0, time)) / (Math.pow(1 + rate / 100.0, time) - 1);
        JOptionPane.showMessageDialog(null, "Monthly EMI: Rs. " + Math.round(emi));
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Invalid input for EMI calculation.");
    }
    }

    
    public static void fdCalculator() {
    try {
        int principal = Integer.parseInt(JOptionPane.showInputDialog("Enter principal amount:").trim());
        int rate = Integer.parseInt(JOptionPane.showInputDialog("Interest rate (%):").trim());
        int time = Integer.parseInt(JOptionPane.showInputDialog("Time (years):").trim());
        double maturity = principal * Math.pow((1 + rate / 100.0), time);
        JOptionPane.showMessageDialog(null, "Maturity amount: Rs. " + Math.round(maturity));
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Invalid input for FD calculation.");
    }
    }

}