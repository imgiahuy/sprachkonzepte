package aufgabe2.aufgabe2ab;

import aufgabe2.aufgabe2ab.gen.bestellungsParserBaseListener;
import aufgabe2.aufgabe2ab.gen.bestellungsParser;
import java.util.ArrayList;
import java.util.List;

/**
 * Statische Semantik-Prüfung für die Bestellungssprache
 * 
 * Validiert:
 * - Tischnummer im Bereich 1-200
 * - Mengen im Bereich 1-50
 * - Uhrzeit innerhalb der Öffnungszeiten (11:00-22:00)
 * - Mindestens ein Bestellungsdetail vorhanden
 */
public class StaticSemanticsChecker extends bestellungsParserBaseListener {
    
    private List<String> errors = new ArrayList<>();
    private List<String> warnings = new ArrayList<>();
    
    // Konstanten für Validierung
    private static final int MIN_TABLE = 1;
    private static final int MAX_TABLE = 200;
    private static final int MIN_QUANTITY = 1;
    private static final int MAX_QUANTITY = 50;
    private static final String OPENING_TIME = "11:00";
    private static final String CLOSING_TIME = "22:00";
    
    private int detailCount = 0;
    
    @Override
    public void exitTischInfo(bestellungsParser.TischInfoContext ctx) {
        String nummerText = ctx.NUMMER().getText();
        try {
            int nummer = Integer.parseInt(nummerText);
            if (nummer < MIN_TABLE || nummer > MAX_TABLE) {
                errors.add(String.format(
                    "Tischnummer %d ist außerhalb des gültigen Bereichs (%d-%d)",
                    nummer, MIN_TABLE, MAX_TABLE
                ));
            }
        } catch (NumberFormatException e) {
            errors.add("Tischnummer konnte nicht als Zahl geparst werden: " + nummerText);
        }
    }
    
    @Override
    public void exitBestellungsdetails(bestellungsParser.BestellungsdetailsContext ctx) {
        detailCount++;
        
        String quantityText = ctx.QUANTITY().getText();
        try {
            int menge = extractMenge(quantityText);
            if (menge < MIN_QUANTITY || menge > MAX_QUANTITY) {
                errors.add(String.format(
                    "Menge %d ist außerhalb des gültigen Bereichs (%d-%d)",
                    menge, MIN_QUANTITY, MAX_QUANTITY
                ));
            }
        } catch (NumberFormatException e) {
            errors.add("Menge konnte nicht als Zahl geparst werden: " + quantityText);
        }
    }
    
    @Override
    public void exitBox(bestellungsParser.BoxContext ctx) {
        if (ctx.QUANTITY() != null) {
            String quantityText = ctx.QUANTITY().getText();
            try {
                int menge = extractMenge(quantityText);
                if (menge < MIN_QUANTITY || menge > MAX_QUANTITY) {
                    errors.add(String.format(
                        "Box-Menge %d ist außerhalb des gültigen Bereichs (%d-%d)",
                        menge, MIN_QUANTITY, MAX_QUANTITY
                    ));
                }
            } catch (NumberFormatException e) {
                errors.add("Box-Menge konnte nicht als Zahl geparst werden: " + quantityText);
            }
        }
    }
    
    @Override
    public void exitAbholung(bestellungsParser.AbholungContext ctx) {
        String zeit = ctx.TIME().getText();
        if (!isWithinOpeningHours(zeit)) {
            errors.add(String.format(
                "Abholzeit %s ist außerhalb der Öffnungszeiten (%s-%s)",
                zeit, OPENING_TIME, CLOSING_TIME
            ));
        }
    }
    
    @Override
    public void exitBestellung(bestellungsParser.BestellungContext ctx) {
        if (detailCount == 0) {
            errors.add("Eine Bestellung muss mindestens ein Bestellungsdetail enthalten");
        }
    }
    
    /**
     * Extrahiert die Menge aus einem QUANTITY-Token (z.B. "1X" -> 1)
     */
    private int extractMenge(String quantityText) {
        String numberText = quantityText.substring(0, quantityText.length() - 1);
        return Integer.parseInt(numberText);
    }
    
    /**
     * Prüft, ob eine Zeit innerhalb der Öffnungszeiten liegt
     */
    private boolean isWithinOpeningHours(String time) {
        try {
            String[] parts = time.split(":");
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            
            String[] openParts = OPENING_TIME.split(":");
            int openHours = Integer.parseInt(openParts[0]);
            int openMinutes = Integer.parseInt(openParts[1]);
            
            String[] closeParts = CLOSING_TIME.split(":");
            int closeHours = Integer.parseInt(closeParts[0]);
            int closeMinutes = Integer.parseInt(closeParts[1]);
            
            // Konvertiere zu Minuten seit Mitternacht
            int timeMinutes = hours * 60 + minutes;
            int openMinutesTotal = openHours * 60 + openMinutes;
            int closeMinutesTotal = closeHours * 60 + closeMinutes;
            
            return timeMinutes >= openMinutesTotal && timeMinutes <= closeMinutesTotal;
        } catch (Exception e) {
            return false;
        }
    }
    
    public List<String> getErrors() {
        return errors;
    }
    
    public List<String> getWarnings() {
        return warnings;
    }
    
    public boolean hasErrors() {
        return !errors.isEmpty();
    }
    
    public void printReport() {
        if (errors.isEmpty() && warnings.isEmpty()) {
            System.out.println("✓ Statische Semantik-Prüfung bestanden");
        } else {
            if (!errors.isEmpty()) {
                System.out.println("✗ FEHLER:");
                for (String error : errors) {
                    System.out.println("  - " + error);
                }
            }
            if (!warnings.isEmpty()) {
                System.out.println("⚠ WARNUNGEN:");
                for (String warning : warnings) {
                    System.out.println("  - " + warning);
                }
            }
        }
    }
}
