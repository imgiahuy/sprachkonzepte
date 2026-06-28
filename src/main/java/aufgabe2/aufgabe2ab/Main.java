package aufgabe2.aufgabe2ab;

import aufgabe2.aufgabe2ab.ast.*;
import aufgabe2.aufgabe2ab.gen.bestellungsParser;
import aufgabe2.aufgabe2ab.gen.bestellungsLexer;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("========================================");
        System.out.println("BESTELLUNGSSPRACHE - ANTLR4 BEISPIELE");
        System.out.println("========================================\n");

        // ====== BEISPIEL 1: Einfache Bestellung ======
        testExample(
            "Beispiel 1: Einfache Bestellung",
            "Tisch 5, Vor-Ort, 1X Erdnuss Hähnchen, 1X Pfandbox."
        );

        // ====== BEISPIEL 2: Mit Abholung und Anmerkung ======
        try {
            testExample(
                "Beispiel 2: Mit Abholung und Anmerkung",
                "Tisch 100, Ausser-Haus, 2X Erdnuss Rind, 1X Bami-Goreng Ente, 3X Pfandbox, Abholung: 10:00 Uhr, Anmerkung: Bitte keine Zwiebeln."
            );
        } catch (Exception e) {
            System.err.println("Beispiel 2 Fehler: " + e.getMessage());
        }

        // ====== BEISPIEL 3: Mit nur Beilage ======
        testExample(
            "Beispiel 3: Mit nur Beilage",
            "Tisch 42, Vor-Ort, 1X Reis, 2X Einweg."
        );

        // ====== BEISPIEL 4: Mehrere Items ======
        try {
            testExample(
                "Beispiel 4: Mehrere Items",
                "Tisch 1, Vor-Ort, 3X Curry Gemüse, 2X Hoisin Ente, 1X Nasi-Goreng Tofu, 1X Pfandbox, Abholung: 18:30 Uhr."
            );
        } catch (Exception e) {
            System.err.println("Beispiel 4 Fehler: " + e.getMessage());
        }

        System.out.println("\n========================================");
        System.out.println("TESTRIG VERWENDUNG:");
        System.out.println("========================================");
        System.out.println("Die org.antlr.v4.gui.TestRig Klasse kann mit der GUI");
        System.out.println("verwendet werden um Parse Trees zu visualisieren.");
        System.out.println("========================================\n");
    }

    private static void testExample(String title, String input) throws Exception {
        System.out.println("\n" + title);
        System.out.println("-------------------------------------------");
        System.out.println("EINGABE: " + input);
        System.out.println();

        try {
            CharStream charStream = CharStreams.fromString(input);
            bestellungsLexer lexer = new bestellungsLexer(charStream);
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            bestellungsParser parser = new bestellungsParser(tokens);
            ParseTree tree = parser.bestellung();

            System.out.println("PARSE TREE:");
            System.out.println(tree.toStringTree(parser));
            System.out.println();

            // Versuche, zu AST zu konvertieren
            try {
                ParseTreeToASTConverter converter = new ParseTreeToASTConverter();
                Bestellung ast = converter.convertBestellung(tree);

                System.out.println("AST:");
                System.out.println(ast.toString());
                System.out.println();
            } catch (Exception e) {
                System.err.println("AST-Konversion fehler (kann sein, dass generierte Parser zu alt ist): " + e.getMessage());
            }

        } catch (Exception e) {
            System.err.println("FEHLER: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
