package Stripe;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        List<String> commands = new ArrayList<>();
//        "INIT, Alice, 100, Chase, Wells Fargo",
//        "INIT, Bob, 50, Bank of America, Chase, Ally",
//         "INIT, Charles, 0 ‚Bank of America" "POST, 212,Alice, Bob, 50", "GET ,211,Alice" "POST, 213, Alice, Charles, 5o%, ink Conidential "GET, 214,Alice", "POST, 301, Charles, Bob, 100", "POST, 302, Ally, Charles, 10" "POST, 305, Kate, Alice, 50" "GET, 401, Charles" "POST, 306, Alice, Chase, 50"
        commands.add("INIT,Alice,100,Chase,Wells Fargo");
        commands.add("INIT,Bob,50,Bank of America,Chase,Ally");
        commands.add("INIT,Charles,0,Bank of America");
        commands.add("POST,212,Alice,Bob,50");
        commands.add("GET,211,Alice");
        commands.add("POST,213,Alice,Charles,50");
        commands.add("GET,214,Alice");
        commands.add("POST,301,Charles,Bob,100");
        commands.add("POST,302,Ally,Charles,10");
        commands.add("POST,305,Kate,Alice,50");
        commands.add("GET,401,Charles");
        commands.add("POST,306,Alice,Chase,50");
        System.out.println(get_command_results(commands));
    }
    public static String get_command_results(List<String> commands) {
        Map<String, String> sorted = new TreeMap<>(); // sorted time : command
        Set<String> allBanks = new HashSet<>(); // all banks
        Map<String, String> res = new HashMap<>(); // time : result
        Map<String, Long> balances = new HashMap<>(); // name : balance
        List<String> order = new ArrayList<>(); // order of time
        Map<String, Set<String>> banks = new HashMap<>(); // name : banks

        for (String c : commands) {
            String[] tokens = c.split(",");
            if (tokens[0].equals("INIT")) {
                balances.put(tokens[1].trim(), (long)Integer.parseInt(tokens[2].trim()));
                Set<String> bank = new HashSet<>();
                for (int i = 3; i < tokens.length; i++) {
                    bank.add(tokens[i].trim());
                    allBanks.add(tokens[i].trim());
                }
                banks.put(tokens[1].trim(), bank);
            } else {
                sorted.put(tokens[1].trim(), c);
                order.add(tokens[1].trim());
            }
        }


        for (String time : sorted.keySet()) {
            String command = sorted.get(time);
            String[] tokens = command.split(",");
            if (tokens[0].equals("POST")) {
                // post
                String sender = tokens[2].trim();
                String receiver = tokens[3].trim();
                int amount = Integer.parseInt(tokens[4].trim());
                // both bank
                if (allBanks.contains(sender) && allBanks.contains(receiver)) {
                    res.put(time, "FAILURE");
                } else if (allBanks.contains(sender)) {
                    // deposite
                    if (!balances.containsKey(receiver)) {
                        res.put(time, "FAILURE");
                    } else if (banks.get(receiver).contains(sender)) {
                        balances.put(receiver, balances.get(receiver) + amount);
                        res.put(time, "SUCCESS");
                    } else {
                        res.put(time, "FAILURE");
                    }
                } else if (allBanks.contains(receiver)) { // withdraw
                    if (!balances.containsKey(sender)) {
                        res.put(time, "FAILURE");
                    } else if (banks.get(sender).contains(receiver)) {
                        if (balances.get(sender) < amount) {
                            res.put(time, "FAILURE");
                        } else {
                            balances.put(sender, balances.get(sender) - amount);
                            res.put(time, "SUCCESS");
                        }
                    } else {
                        res.put(time, "FAILURE");
                    }
                } else { // both user
                    if (!balances.containsKey(sender) || !balances.containsKey(receiver)) {
                        res.put(time, "FAILURE");
                    } else if (balances.get(sender) < amount) {
                        res.put(time, "FAILURE");
                    } else {
                        balances.put(sender, balances.get(sender) - amount);
                        balances.put(receiver, balances.get(receiver) + amount);
                        res.put(time, "SUCCESS");
                    }
                }
            } else {
                // get
                String name = tokens[2].trim();
                if (balances.containsKey(name)) {
                    res.put(time, balances.get(name) + "");
                } else {
                    res.put(time, "FAILURE");
                }
            }
        }
        String result = "";
        for (int i = 0; i < order.size(); i++) {
            result += res.get(order.get(i)) + ",";
        }
        return result.substring(0, result.length() - 1);
    }
}
