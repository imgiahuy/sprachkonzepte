package aufgabe4;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

import java.io.BufferedReader;
import java.util.LinkedList;

public final class Procedural {
    private Procedural() { }

    private static final int MIN_LENGTH = 20;

    public static void main(String[] args) throws IOException {
        var input = Paths.get(args[0]);
        var lines = new LinkedList<String>();

        long start = System.nanoTime();

        readLines(Files.newBufferedReader(input), lines);
        removeEmptyLines(lines);
        removeShortLines(lines);
        int n = totalLineLengths(lines);

        long stop = System.nanoTime();

        System.out.printf("result = %d (%d microsec)%n", n, (stop - start) / 1000);
    }

    // TODO: Klassenmethoden readLines, removeEmptyLines, removeShortLines, totalLineLengths

    public static void readLines(BufferedReader reader, LinkedList<String> lines) throws IOException {
        String line = reader.readLine();
        while (line != null) {
            lines.add(line);
            line = reader.readLine();
        }
    }

    public static void removeEmptyLines(LinkedList<String> lines) {
        for (int i = lines.size() -1; i >= 0; i--) {
            if (lines.get(i).trim().isEmpty()) {
                lines.remove(i);
            }
        }
    }

    public static void removeShortLines(LinkedList<String> lines) {
        for (int i = lines.size() - 1; i >= 0; i--) {
            if (lines.get(i).length() < MIN_LENGTH) {
                lines.remove(i);
            }
        }
    }

    public static int totalLineLengths(LinkedList<String> lines) {
        int total = 0;
        for (String line : lines) {
            total += line.length();
        }
        return total;
    }

}
