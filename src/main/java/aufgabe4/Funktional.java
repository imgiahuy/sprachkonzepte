package aufgabe4;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;


public final class Funktional {
    private Funktional() { }

    private static final int MIN_LENGTH = 20;

    public static void main(String[] args) throws IOException {
        var input = Paths.get(args[0]);

        long start = System.nanoTime();
        int n = Files.lines(input)  // Erstellt Stream<String> aus Datei
                .filter(line -> !line.trim().isEmpty())  // Entfernt leere Zeilen
                .filter(line -> line.length() >= MIN_LENGTH)  // Entfernt kurze Zeilen
                .mapToInt(String::length)  // Wandelt Strings in Integers um
                .sum();  // Summiert alle Längen

        long stop = System.nanoTime();

        System.out.printf("result = %d (%d microsec)%n", n, (stop - start) / 1000);
    }

}
