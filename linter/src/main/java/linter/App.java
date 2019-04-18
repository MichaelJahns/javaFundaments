/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package linter;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Path path = Paths.get("src/main/resources/gates.js");
        int lineNumber = 1;
        try {
            BufferedReader linter = Files.newBufferedReader(path);

            String line = linter.readLine();
            while (line != null) {
                if(!linterSemicolon(line).isEmpty()){
                    System.out.println("Line " + lineNumber + ": " + linterSemicolon(line));
                }
                lineNumber++;
                line = linter.readLine();
            }
            linter.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
    public static String linterSemicolon(String line){
        String output = "Error missing semicolon";
        if (line.isEmpty()) {
            output = "";
        } else if (line.endsWith(";")) {
            output = "";
        } else if (line.endsWith("{") || line.endsWith("}") || line.endsWith("if") || line.endsWith("else")) {
            output = "";
            return output;
        }
        return output;
    }
}
/*Read through the file line by line. Print an error message such as "Line 3: Missing semicolon." if a line is missing a semicolon.

Don’t show an error if the line is empty.
Don’t show an error if the line ends with an opening curly brace {
Don’t show an error if the line ends with an closing curly brace }
Don’t show an error if the line contains if or else*/
