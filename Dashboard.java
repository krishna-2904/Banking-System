import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame {
    String username;

    public Dashboard(String user) {
        this.username = user;
        setTitle("Dashboard - " + user);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 3, 10, 10));
        JButton depositBtn = new JButton("Deposit");
        JButton withdrawBtn = new JButton("Withdraw");
        JButton balanceBtn = new JButton("Check Balance");
        JButton transferBtn = new JButton("Fund Transfer");
        JButton loanBtn = new JButton("Loan Checker");
        JButton emiBtn = new JButton("EMI Calculator");
        JButton fdBtn = new JButton("FD Calculator");
        JButton historyBtn = new JButton("Transaction History");

        panel.add(depositBtn);
        panel.add(withdrawBtn);
        panel.add(balanceBtn);
        panel.add(transferBtn);
        panel.add(loanBtn);
        panel.add(emiBtn);
        panel.add(fdBtn);
        panel.add(historyBtn);

        add(panel);

        depositBtn.addActionListener(e -> Services.deposit(username));
        withdrawBtn.addActionListener(e -> Services.withdraw(username));
        balanceBtn.addActionListener(e -> Services.checkBalance(username));
        transferBtn.addActionListener(e -> Services.fundTransfer(username));
        loanBtn.addActionListener(e -> Services.loanChecker());
        emiBtn.addActionListener(e -> Services.emiCalculator());
        fdBtn.addActionListener(e -> Services.fdCalculator());
        historyBtn.addActionListener(e -> {
        java.util.List<String> history = Database.getTransactionHistory(username);
        StringBuilder sb = new StringBuilder("Transaction History:\n\n");
        for (String entry : history) {
            sb.append(entry).append("\n");
        }
        JTextArea area = new JTextArea(sb.toString());
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area);
        scroll.setPreferredSize(new Dimension(400, 200));
        JOptionPane.showMessageDialog(null, scroll, "History", JOptionPane.INFORMATION_MESSAGE);
        });


        setVisible(true);
    }
}