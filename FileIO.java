
/**
 * File input/output example that reads integers from a file, sums them, and handles errors.
 * 
 * @author KincaidBD
 * @version 1.0.0
 * @since 26/10/14
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileIO {
    public static void main(String[] args) throws Exception {
        // opening the files
        Scanner input = new Scanner(new File("/home/vscode/ICS4UC/Unit2/Unit2-02/Unit2-02-Java-FileIO/Unit2-02-input.txt"));
        PrintWriter output = new PrintWriter("/home/vscode/ICS4UC/Unit2/Unit2-02/Unit2-02-Java-FileIO/Unit2-02-output.txt");

        while (input.hasNextLine()) {
            String line = input.nextLine();
            Scanner numbers = new Scanner(line);

            // sum of all numbers on the line variable
            int sum = 0;
            // flags
            boolean error = false;
            boolean found = false;

            // go through the numbers on the line
            while (numbers.hasNext()) {
                String word = numbers.next();

                // check if the word is an integer before parsing
                try {
                    int num = Integer.parseInt(word);
                    sum = sum + num;
                    found = true;
                } catch (Exception e) {
                    // handle the case where the word is not an integer
                    if (!found) {
                        output.println("Error: " + word + " is not a number.");
                    }
                    // if an integer was found before stilll print the error message
                    else {
                        output.println("Error: " + word + " is not a number.");
                    }

                    // set the error to a boolean as a flag
                    error = true;
                    break;
                }
            }

            // if no error then print the sum or an error message if no integers were found
            if (!error) {
                if (found) {
                    output.println(sum);
                } else {
                    output.println("Error: No integers were found on this line.");
                }
            }
            
            numbers.close();
        }

        // closing the files
        input.close();
        output.close();
    }
}
