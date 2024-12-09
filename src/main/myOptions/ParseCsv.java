package myOptions;

import java.io.*;
import java.util.Scanner;

public class ParseCsv {

    public String parseCsv(String data) throws FileNotFoundException {
        StringBuilder builder = new StringBuilder();
        Scanner scanner = new Scanner(new File(data));
        scanner.useDelimiter(",");

        while (scanner.hasNext()) {
            builder.append(scanner.next()).append(" - ");
        }

        scanner.close();
        return builder.toString();
    }
}
