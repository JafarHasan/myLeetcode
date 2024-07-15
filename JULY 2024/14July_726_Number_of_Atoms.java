
import java.util.*;
import java.util.HashMap;
import java.util.Stack;

class Solution {
    public String countOfAtoms(String formula) {
        StringBuilder sb = new StringBuilder();
        Stack<HashMap<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());
        int i = 0, n = formula.length();

        while (i < n) {
            if (formula.charAt(i) == '(') {
                stack.push(new HashMap<>());
                i++;
            } else if (formula.charAt(i) == ')') {
                HashMap<String, Integer> currMap = stack.pop();
                i++;

                // Read the multiplier after the closing parenthesis
                StringBuilder digit = new StringBuilder();
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    digit.append(formula.charAt(i));
                    i++;
                }

                int multiplier = digit.length() == 0 ? 1 : Integer.parseInt(digit.toString());

                // Multiply each atom in the current map by the multiplier
                for (String key : currMap.keySet()) {
                    currMap.put(key, currMap.get(key) * multiplier);
                }

                // Merge current map with the top of the stack
                for (String key : currMap.keySet()) {
                    stack.peek().put(key, stack.peek().getOrDefault(key, 0) + currMap.get(key));
                }
            } else {
                StringBuilder atom = new StringBuilder();
                atom.append(formula.charAt(i));
                i++;

                // Read the full atom name (first letter uppercase, followed by lowercase)
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    atom.append(formula.charAt(i));
                    i++;
                }

                // Read the count of the atom
                StringBuilder count = new StringBuilder();
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    count.append(formula.charAt(i));
                    i++;
                }

                int atomCount = count.length() == 0 ? 1 : Integer.parseInt(count.toString());

                // Add the atom and its count to the top map in the stack
                stack.peek().put(atom.toString(), stack.peek().getOrDefault(atom.toString(), 0) + atomCount);
            }
        }

        // Using TreeMap to sort the atoms
        TreeMap<String, Integer> finalMap = new TreeMap<>(stack.pop());
        StringBuilder ans = new StringBuilder();

        // Build the final output string
        for (String key : finalMap.keySet()) {
            ans.append(key);
            // Append the count only if it's greater than 1
            if (finalMap.get(key) > 1) {
                ans.append(finalMap.get(key));
            }
        }

        return ans.toString();
    }
}
