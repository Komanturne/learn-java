import java.util.HashMap;
import java.util.Map;

public class lang {
    // Constant commands
    private static final String PRT = "println:"; //print 
    private static final String VAR = "int:"; //defines an integer
    private static final String DEF_VAR = "int.println:"; //def int () and println
    private static final String FOR_LOOP = "for i in range:"; //for loop where i is blank
    private static final String IF_STATE = "if:"; //if statement

    // Hashmap to store variables
    private static Map<String, Integer> variables = new HashMap<>();

    public static void main(String[] args) {
        //inputs stored in strings rather than in a line.
        Map<String, String> inputs = new HashMap<>();
        inputs.put("input000", "if:");
        inputs.put("input001", "int:");
        inputs.put("input002", "y");
        inputs.put("input003", "3");
        inputs.put("input004", "println:");
        inputs.put("input005", "hello world");

        // Process inputs
        processInputs(inputs);
    }

    public static void processInputs(Map<String, String> inputs) {
        String input000 = inputs.getOrDefault("input000", "");
        String input001 = inputs.getOrDefault("input001", "");
        String input002 = inputs.getOrDefault("input002", "");
        String input003 = inputs.getOrDefault("input003", "");
        String input004 = inputs.getOrDefault("input004", "");
        String input005 = inputs.getOrDefault("input005", "");

        // print command
        if (input000.equals(PRT)) {
            handlePrintln(input001);
        }
        
        // def var
        if (input000.equals(VAR)) {
            handleDefineVariable(input002, input003);
        }
        
        // def var and print
        if (input000.equals(DEF_VAR)) {
            handleDefVar(input001);
        }
        
        // forloop command
        if (input000.equals(FOR_LOOP)) {
            handleForLoop(input001, input002, input003);
        }

        // if statement
        if (input000.equals(IF_STATE)) {
            handleIf(input001, input002, input003, input004, input005);
        }
    }

    private static void handleIf(String varType, String varName, String varValue, String command, String toPrint) {
        try {
            // First, check if it's defining an integer variable
            if (varType.equals(VAR)) {
                // Parse and store the variable
                int value = Integer.parseInt(varValue);
                variables.put(varName, value);
                
                // If there's a subsequent command (like println)
                if (command.equals(PRT)) {
                    System.out.println(toPrint);
                }
            } else {
                // Check if the variable exists and meets a condition
                if (variables.containsKey(varName)) {
                    int value = variables.get(varName);
                    
                    // Simple condition check (for demonstration)
                    if (value > 0) {
                        if (command.equals(PRT)) {
                            System.out.println(toPrint);
                        }
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid variable value. Expected an integer.");
        }
    }

    private static void handleDefineVariable(String varName, String varValue) {
        try {
            // Parse and store the variable
            int value = Integer.parseInt(varValue);
            variables.put(varName, value);
            System.out.println("Variable " + varName + " set to " + value);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Expected an integer.");
        }
    }

    private static void handlePrintln(String input) {
        try {
            // if input is a valid integer, throw an error
            Integer.valueOf(input);
            System.out.println("Invalid input, try 'int.println:' instead.");
        } catch (NumberFormatException e) {
            // if not an integer, print the input
            System.out.println(input);
        }
    }

    private static void handleDefVar(String input) {
        try {
            // if input is a valid integer, print it
            int x = Integer.valueOf(input);
            System.out.println(x);
        } catch (NumberFormatException e) {
            // if not an integer, show an error
            System.out.println("Invalid input, try 'println:' instead.");
        }
    }

    private static void handleForLoop(String loopCount, String command, String toPrint) {
        try {
            // parse loop count
            int x = Integer.valueOf(loopCount);
            
            // check if the command is println
            if (command.equals(PRT)) {
                // execute loop
                for (int i = 0; i < x; i++) {
                    System.out.println(toPrint);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, try using a valid integer for loop count.");
        }
    }
}