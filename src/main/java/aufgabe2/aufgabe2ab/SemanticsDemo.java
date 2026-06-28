package aufgabe2.aufgabe2ab;

import aufgabe2.aufgabe2ab.ast.*;
import aufgabe2.aufgabe2ab.gen.bestellungsParser;
import aufgabe2.aufgabe2ab.gen.bestellungsLexer;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

/**
 * Demo für statische und dynamische Semantik
 * 
 * Aufgabe 3a: Statische Semantik-Prüfung
 * Aufgabe 3b: Dynamische Semantik (Preisberechnung)
 */
public class SemanticsDemo {
    
    public static void main(String[] args) throws Exception {
        System.out.println("========================================");
        System.out.println("AUFGABE 3: STATISCHE & DYNAMISCHE SEMANTIK");
        System.out.println("========================================\n");
        
        // ====== BEISPIEL 1: Gültige Bestellung ======
        System.out.println("=== BEISPIEL 1: Gültige Bestellung ===");
        testSemantics(
            "Tisch 5, Vor-Ort, 1X Erdnuss Hähnchen, 1X Pfandbox."
        );
        
        // ====== BEISPIEL 2: Ungültige Tischnummer ======
        System.out.println("\n=== BEISPIEL 2: Ungültige Tischnummer ===");
        testSemantics(
            "Tisch 250, Vor-Ort, 1X Erdnuss Hähnchen, 1X Pfandbox."
        );
        
        // ====== BEISPIEL 3: Ungültige Abholzeit ======
        System.out.println("\n=== BEISPIEL 3: Ungültige Abholzeit ===");
        testSemantics(
            "Tisch 10, Ausser-Haus, 2X Curry Gemüse, 1X Einweg, Abholung: 23:00 Uhr."
        );
        
        // ====== BEISPIEL 4: Komplexe gültige Bestellung ======
        System.out.println("\n=== BEISPIEL 4: Komplexe gültige Bestellung ===");
        testSemantics(
            "Tisch 42, Ausser-Haus, 2X Erdnuss Ente, 1X Nasi-Goreng Rind, 1X Reis, 2X Pfandbox, Abholung: 18:30 Uhr, Anmerkung: Bitte scharf."
        );
        
        // ====== BEISPIEL 5: Ungültige Menge ======
        System.out.println("\n=== BEISPIEL 5: Ungültige Menge ===");
        testSemantics(
            "Tisch 15, Vor-Ort, 100X Erdnuss Hähnchen, 1X Pfandbox."
        );
        
        System.out.println("\n========================================");
        System.out.println("ZUSAMMENFASSUNG:");
        System.out.println("========================================");
        System.out.println("Statische Semantik: Prüft Tischnummern, Mengen, Zeiten");
        System.out.println("Dynamische Semantik: Berechnet Preise und generiert Quittungen");
        System.out.println("========================================\n");
    }
    
    private static void testSemantics(String input) {
        System.out.println("EINGABE: " + input);
        System.out.println("----------------------------------------");
        
        try {
            // 1. Parsing
            CharStream charStream = CharStreams.fromString(input);
            bestellungsLexer lexer = new bestellungsLexer(charStream);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            bestellungsParser parser = new bestellungsParser(tokens);
            ParseTree tree = parser.bestellung();
            
            // 2. Statische Semantik-Prüfung
            System.out.println("STATISCHE SEMANTIK:");
            StaticSemanticsChecker staticChecker = new StaticSemanticsChecker();
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(staticChecker, tree);
            staticChecker.printReport();
            
            // 3. Nur wenn keine statischen Fehler, dynamische Semantik
            if (!staticChecker.hasErrors()) {
                System.out.println("\nDYNAMISCHE SEMANTIK (Preisberechnung):");
                ParseTreeToASTConverter converter = new ParseTreeToASTConverter();
                Bestellung ast = converter.convertBestellung(tree);
                
                PriceCalculator priceCalculator = new PriceCalculator();
                ast.accept(priceCalculator);
                priceCalculator.printReceipt();
            } else {
                System.out.println("\nDynamische Semantik wird übersprungen (statische Fehler vorhanden)");
            }
            
        } catch (Exception e) {
            System.err.println("FEHLER: " + e.getMessage());
            e.printStackTrace();
        }
        
        System.out.println();
    }
}
