import java.util.*;

public class Database {
    static Map<String, String> users = new HashMap<>();
    static Map<String, Integer> balances = new HashMap<>();
    static Map<String, List<String>> history = new HashMap<>();
    
    static {
        users.put("user", "pass");
        balances.put("user", 1000);
    }

    public static boolean validateLogin(String user, String pass) {
        return users.containsKey(user) && users.get(user).equals(pass);
    }

    public static int getBalance(String user) {
        return balances.getOrDefault(user, 0);
    }

    public static void updateBalance(String user, int newBalance) {
        balances.put(user, newBalance);
    }
    
    public static void addTransaction(String user, String message) {
        history.putIfAbsent(user, new ArrayList<>());
        history.get(user).add(message);
    }

    public static List<String> getTransactionHistory(String user) {
        return history.getOrDefault(user, new ArrayList<>());
    }

}