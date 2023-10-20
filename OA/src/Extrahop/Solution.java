//package Extrahop;
//
//public class Solution {
//# Write a function that takes an input array describing some operation to be evaluated (the “request”), and outputs a map containing the result of that calculation. The input and output formats should have the following format:
//#
//# Input: array of strings containing the command name, followed by zero or more arguments. For example:
//# ["sum", "1", "2", "3"]
//# ["sum", "1.2", "2", "3"]
//# Output: string-to-string map, with a “result” key and the calculation result as a string. For example:
//# {"result": "6"}
//#
//# Implement three different commands: “sum”, “product”, and “average”, which compute the sum, product, and average of the argument list, respectively.
//
//=== Extension 1: Error handling ===
//Discuss what sort of input validation would need to be done if the input is an arbitrary array of strings. Make the function robust to invalid inputs by returning a map of the form {"error": "<message>"} if an error is encountered.
//
//=== Extension 2: Different parameter types ===
//Add support for the “substr” command, which takes exactly two parameters, a base string and a starting offset. For example, ["substr", "abcde", "2"] should give the result "cde"
//
//
//// command not found
//// If arguments are not number
//// if req is null or have no value
//
//    //
//    public class Commands {
//        public static Set<String> commands;
//    }
//
//    public Map<String, String> handleRequest(String[] req) {
//        Map<String, String> map = new HashMap<>();
//        if (req == null || req.length == 0) {
//            map.put("error" : "Invalid Input: not exist / no arguments");
//            return map;
//        }
//        double res = 0;
//        Set<String> validCommands = new HashSet<>();
//        set.add("sum");
//        set.add("product");
//        set.add("average");
//        set.add("for");
//        // command is invalid
//        req[0] = req[0].toLowerCase();
//        if (!validCommands.contains(req[0]) {
//            map.put("error" : "Command is invalid");
//        }
//        if (!req[0].equals("for") && req.length == 1) {
//            map.put("result" : "");
//            return map;
//        }
//        // handle three commands
//        if (req[0].equals("sum")) {
//            for (int i = 1; i < req.length; i++) {
//                if (req[i].isDigit()) {//
//                    res += Integer.parseValue(req[i]);   // "3.2"
//                } else {
//                    map.put("error" : "Invalid Arguments: Please input integers");
//                    return map;
//                }
//            }
//        } else if (req[0].equals("product")) {
//            res = 1;
//            for (int i = 1; i < req.length; i++) {
//                if (req[i].isDigit()) {//
//                    res *= Integer.parseValue(req[i]);   // "3.2"
//                } else {
//                    map.put("error" : "Invalid Arguments: Please input integers");
//                    return map;
//                }
//            }
//        } else if (req[0].equals("average")) {
//            for (int i = 1; i < req.length; i++) {
//                if (req[i].isDigit()) {//
//                    res += Integer.parseValue(req[i]);   // "3.2"
//                } else {
//                    map.put("error" : "Invalid Arguments: Please input integers");
//                    return map;
//                }
//            }
//            res /= req.length - 1;
//        } else {
//            if (!req.length == 3) {
//                map.put("error" : "Invalid Arguments: Please input two arguments);
//                return map;
//            }
//            // check if the index is valid or the boundary
//            if (req[2].isDigit() && Integer.parseValue(req[2]) <= req[1].length()) {
//                //
//            } else {
//                map.put("error" : "Invalid Arguments: );
//                return map;
//            }
//        }
//        map.put("result", res + "");
//        return map;
//    }
//}
