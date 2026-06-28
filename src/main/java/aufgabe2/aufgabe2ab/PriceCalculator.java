package aufgabe2.aufgabe2ab;

import aufgabe2.aufgabe2ab.ast.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Dynamische Semantik: Preisberechnung und Quittungsgenerierung
 * 
 * Interpretiert den AST und berechnet Preise basierend auf:
 * - Gericht-Typ (MitSauce, MitGebraten, NurBeilage)
 * - Fleisch-Typ (verschiedene Preise)
 * - Beilage-Typ
 * - Box-Typ
 * - Mengen
 */
public class PriceCalculator implements ASTVisitor {
    
    // Preisliste (in Euro)
    private static final double PREIS_SAUCE_BASE = 8.50;
    private static final double PREIS_GEBRATEN_BASE = 9.00;
    private static final double PREIS_BEILAGE_REIS = 3.00;
    private static final double PREIS_BEILAGE_NUDELN = 3.50;
    private static final double PREIS_BEILAGE_SOSSE = 1.50;
    
    // Fleisch-Preisaufschläge
    private static final double PREIS_FLEISCH_HAEHNCHEN = 0.0;
    private static final double PREIS_FLEISCH_ENTE = 2.00;
    private static final double PREIS_FLEISCH_TOFU = 0.0;
    private static final double PREIS_FLEISCH_GEMUESE = 0.0;
    private static final double PREIS_FLEISCH_RIND = 1.50;
    
    // Box-Preise
    private static final double PREIS_BOX_PFANDBOX = 0.50;
    private static final double PREIS_BOX_EINWEG = 0.20;
    
    // Aufschlag für Außer-Haus
    private static final double AUSSER_HAUS_AUFSCHAG = 1.00;
    
    private double totalPrice = 0.0;
    private List<String> receiptLines = new ArrayList<>();
    private DecimalFormat df = new DecimalFormat("0.00");
    
    private Bestellung currentBestellung;
    private int currentDetailIndex = 0;
    
    public PriceCalculator() {
        receiptLines.add("========================================");
        receiptLines.add("        RESTAURANT QUITTUNG");
        receiptLines.add("========================================");
    }
    
    @Override
    public void visit(Bestellung bestellung) {
        currentBestellung = bestellung;
        currentDetailIndex = 0;
        
        // Header
        receiptLines.add("");
        receiptLines.add("Tisch: " + bestellung.tischInfo.tischNummer);
        receiptLines.add("Art: " + bestellung.kind.typ);
        receiptLines.add("");
        receiptLines.add("BESTELLUNG:");
        receiptLines.add("----------------------------------------");
        
        // Besuche alle Details
        for (Bestellungsdetail detail : bestellung.details) {
            detail.accept(this);
            currentDetailIndex++;
        }
        
        // Box
        if (bestellung.box != null) {
            bestellung.box.accept(this);
        }
        
        // Außer-Haus Aufschlag
        if (bestellung.kind.typ.equals("Ausser-Haus")) {
            double aufschlag = AUSSER_HAUS_AUFSCHAG;
            totalPrice += aufschlag;
            receiptLines.add(String.format("%-30s %6s€", "Außer-Haus Aufschlag", df.format(aufschlag)));
        }
        
        // Abholung
        if (bestellung.abholung != null) {
            receiptLines.add("");
            receiptLines.add("Abholung: " + bestellung.abholung.zeit);
        }
        
        // Anmerkung
        if (bestellung.anmerkung != null) {
            receiptLines.add("Anmerkung: " + bestellung.anmerkung.text);
        }
        
        receiptLines.add("");
        receiptLines.add("----------------------------------------");
        receiptLines.add(String.format("%-30s %6s€", "GESAMT", df.format(totalPrice)));
        receiptLines.add("========================================");
    }
    
    @Override
    public void visit(TischInfo tischInfo) {
        // Wird in visit(Bestellung) behandelt
    }
    
    @Override
    public void visit(Kind kind) {
        // Wird in visit(Bestellung) behandelt
    }
    
    @Override
    public void visit(Bestellungsdetail detail) {
        double itemPrice = calculateGerichtPrice(detail.gericht) * detail.menge;
        totalPrice += itemPrice;
        
        String gerichtName = detail.gericht.toString();
        String line = String.format("%dx %-25s %6s€", 
            detail.menge, gerichtName, df.format(itemPrice));
        receiptLines.add(line);
        
        // Item-Anmerkung
        if (detail.itemAnmerkung != null) {
            receiptLines.add("   (" + detail.itemAnmerkung.text + ")");
        }
    }
    
    @Override
    public void visit(Gericht gericht) {
        // Abstrakte Klasse - wird nicht direkt aufgerufen
    }
    
    @Override
    public void visit(Gericht.MitSauce mitSauce) {
        // Wird in calculateGerichtPrice behandelt
    }
    
    @Override
    public void visit(Gericht.MitGebraten mitGebraten) {
        // Wird in calculateGerichtPrice behandelt
    }
    
    @Override
    public void visit(Gericht.NurBeilage nurBeilage) {
        // Wird in calculateGerichtPrice behandelt
    }
    
    @Override
    public void visit(Sauce sauce) {
        // Wird in calculateGerichtPrice behandelt
    }
    
    @Override
    public void visit(Gebraten gebraten) {
        // Wird in calculateGerichtPrice behandelt
    }
    
    @Override
    public void visit(Fleisch fleisch) {
        // Wird in calculateGerichtPrice behandelt
    }
    
    @Override
    public void visit(Beilage beilage) {
        // Wird in calculateGerichtPrice behandelt
    }
    
    @Override
    public void visit(Box box) {
        double boxPrice = 0.0;
        if (box.typ.equals("Pfandbox")) {
            boxPrice = PREIS_BOX_PFANDBOX * (box.menge > 0 ? box.menge : 1);
        } else if (box.typ.equals("Einweg")) {
            boxPrice = PREIS_BOX_EINWEG * (box.menge > 0 ? box.menge : 1);
        }
        
        totalPrice += boxPrice;
        String line = String.format("%-30s %6s€", 
            (box.menge > 0 ? box.menge + "x " : "") + box.typ, df.format(boxPrice));
        receiptLines.add(line);
    }
    
    @Override
    public void visit(Abholung abholung) {
        // Wird in visit(Bestellung) behandelt
    }
    
    @Override
    public void visit(Anmerkung anmerkung) {
        // Wird in visit(Bestellung) oder visit(Bestellungsdetail) behandelt
    }
    
    /**
     * Berechnet den Preis eines Gerichts
     */
    private double calculateGerichtPrice(Gericht gericht) {
        if (gericht instanceof Gericht.MitSauce) {
            Gericht.MitSauce mitSauce = (Gericht.MitSauce) gericht;
            double basePrice = PREIS_SAUCE_BASE;
            double fleischAufschlag = getFleischAufschlag(mitSauce.fleisch.wert);
            return basePrice + fleischAufschlag;
        }
        else if (gericht instanceof Gericht.MitGebraten) {
            Gericht.MitGebraten mitGebraten = (Gericht.MitGebraten) gericht;
            double basePrice = PREIS_GEBRATEN_BASE;
            double fleischAufschlag = getFleischAufschlag(mitGebraten.fleisch.wert);
            return basePrice + fleischAufschlag;
        }
        else if (gericht instanceof Gericht.NurBeilage) {
            Gericht.NurBeilage nurBeilage = (Gericht.NurBeilage) gericht;
            return getBeilagePrice(nurBeilage.beilage.wert);
        }
        return 0.0;
    }
    
    /**
     * Liefert den Aufschlag für einen Fleisch-Typ
     */
    private double getFleischAufschlag(String fleisch) {
        switch (fleisch) {
            case "Hähnchen": return PREIS_FLEISCH_HAEHNCHEN;
            case "Ente": return PREIS_FLEISCH_ENTE;
            case "Tofu": return PREIS_FLEISCH_TOFU;
            case "Gemüse": return PREIS_FLEISCH_GEMUESE;
            case "Rind": return PREIS_FLEISCH_RIND;
            default: return 0.0;
        }
    }
    
    /**
     * Liefert den Preis für eine Beilage
     */
    private double getBeilagePrice(String beilage) {
        switch (beilage) {
            case "Reis": return PREIS_BEILAGE_REIS;
            case "Nudeln": return PREIS_BEILAGE_NUDELN;
            case "Soße": return PREIS_BEILAGE_SOSSE;
            default: return 0.0;
        }
    }
    
    public double getTotalPrice() {
        return totalPrice;
    }
    
    public List<String> getReceiptLines() {
        return receiptLines;
    }
    
    public void printReceipt() {
        for (String line : receiptLines) {
            System.out.println(line);
        }
    }
}
