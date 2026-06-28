package aufgabe2.aufgabe2ab.ast;

import aufgabe2.aufgabe2ab.gen.bestellungsParser;
import org.antlr.v4.runtime.tree.ParseTree;
import java.util.ArrayList;
import java.util.List;

/**
 * Konvertiert einen ANTLR4 Parse Tree in einen AST
 *
 * Diese Klasse nutzt Reflection und direkte Typprüfung,
 * um mit den generierten ANTLR-Klassen zu arbeiten.
 *
 * WEGGELASSENE TERMINALE (nicht im AST):
 * - KOMMA: nur Strukturtrennzeichen
 * - PUNKT: nur Satzende-Terminator
 * - DOPPELPUNKT: nur Separator
 * - UHR: redundant, Zeit ist ausreichend
 * - TISCH: Keyword, nur Nummer relevant
 * - NOTE: Keyword, nur Text relevant
 * - ABHOLUNG: Keyword, nur Zeit relevant
 *
 * WEGGELASSENE NICHTTERMINALE (vereinfacht):
 * - sauce, gebraten, fleisch, beilage: Wrapper um Token -> nur Werte
 * - text: mehrere WORD-Token -> einzelner String
 * - itemAnmerkung wird zu Anmerkung übernommen
 */
public class ParseTreeToASTConverter {

    /**
     * Konvertiert einen Bestellung Parse Tree zu einem AST-Knoten
     */
    public Bestellung convertBestellung(ParseTree tree) {
        if (!(tree instanceof bestellungsParser.BestellungContext)) {
            throw new IllegalArgumentException("Tree ist kein BestellungContext");
        }

        bestellungsParser.BestellungContext ctx = (bestellungsParser.BestellungContext) tree;

        // 1. TischInfo
        TischInfo tischInfo = convertTischInfo(ctx.tischInfo());

        // 2. Kind
        Kind kind = convertKind(ctx.kind());

        // 3. Bestellungsdetails (Liste)
        List<Bestellungsdetail> details = new ArrayList<>();
        for (bestellungsParser.BestellungsdetailsContext detailCtx : ctx.bestellungsdetails()) {
            details.add(convertBestellungsdetail(detailCtx));
        }

        // 4. Box
        Box box = convertBox(ctx.box());

        // 5. Abholung (optional)
        Abholung abholung = null;
        if (ctx.abholung() != null) {
            abholung = convertAbholung(ctx.abholung());
        }

        // 6. Anmerkung (optional)
        Anmerkung anmerkung = null;
        if (ctx.anmerkung() != null) {
            anmerkung = convertAnmerkung(ctx.anmerkung());
        }

        return new Bestellung(tischInfo, kind, details, box, abholung, anmerkung);
    }

    /**
     * Konvertiert TischInfo
     * WEGGELASSEN: TISCH Token (Keyword)
     */
    private TischInfo convertTischInfo(bestellungsParser.TischInfoContext ctx) {
        String numeroText = ctx.NUMMER().getText();
        int numero = Integer.parseInt(numeroText);
        return new TischInfo(numero);
    }

    /**
     * Konvertiert Kind (Art der Bestellung)
     */
    private Kind convertKind(bestellungsParser.KindContext ctx) {
        String kindText = ctx.KIND().getText();
        return new Kind(kindText);
    }

    /**
     * Konvertiert ein Bestellungsdetail (Menge + Gericht + optionale Anmerkung)
     */
    private Bestellungsdetail convertBestellungsdetail(bestellungsParser.BestellungsdetailsContext ctx) {
        // QUANTITY: "1X", "2x", etc.
        String quantityText = ctx.QUANTITY().getText();
        int menge = extractMenge(quantityText);

        // Gericht
        Gericht gericht = convertGericht(ctx.gericht());

        // optionale itemAnmerkung (Anmerkung wird für both global und item verwendet)
        Anmerkung itemAnmerkung = null;
        if (ctx.itemAnmerkung() != null) {
            itemAnmerkung = convertItemAnmerkung(ctx.itemAnmerkung());
        }

        return new Bestellungsdetail(menge, gericht, itemAnmerkung);
    }

    /**
     * Konvertiert ein Gericht
     * WEGGELASSEN: sauce, gebraten, fleisch, beilage Wrapper-Regeln
     * Die Kontext-Klassen werden verflacht -> nur die Werte bleiben
     */
    private Gericht convertGericht(bestellungsParser.GerichtContext ctx) {
        // Die Gericht-Regel hat drei Alternativen:
        // 1. sauce fleisch -> MitSauce
        // 2. gebraten fleisch -> MitGebraten
        // 3. beilage -> NurBeilage

        if (ctx.sauce() != null && ctx.fleisch() != null) {
            // Alternative 1: sauce fleisch
            Sauce sauce = convertSauce(ctx.sauce());
            Fleisch fleisch = convertFleisch(ctx.fleisch());
            return new Gericht.MitSauce(sauce, fleisch);
        }
        else if (ctx.gebraten() != null && ctx.fleisch() != null) {
            // Alternative 2: gebraten fleisch
            Gebraten gebraten = convertGebraten(ctx.gebraten());
            Fleisch fleisch = convertFleisch(ctx.fleisch());
            return new Gericht.MitGebraten(gebraten, fleisch);
        }
        else if (ctx.beilage() != null) {
            // Alternative 3: beilage
            Beilage beilage = convertBeilage(ctx.beilage());
            return new Gericht.NurBeilage(beilage);
        }

        throw new RuntimeException("Ungültiges Gericht-Kontext");
    }

    /**
     * Konvertiert Sauce
     * WEGGELASSEN: sauce-Rule (ist nur ein Wrapper um das Token)
     * Nur der Token-Wert wird extrahiert
     */
    private Sauce convertSauce(bestellungsParser.SauceContext ctx) {
        String wert = ctx.SAUCE().getText();
        return new Sauce(wert);
    }

    /**
     * Konvertiert Gebraten
     * WEGGELASSEN: gebraten-Rule (ist nur ein Wrapper um das Token)
     */
    private Gebraten convertGebraten(bestellungsParser.GebratenContext ctx) {
        String wert = ctx.GEBRATEN().getText();
        return new Gebraten(wert);
    }

    /**
     * Konvertiert Fleisch
     * WEGGELASSEN: fleisch-Rule (ist nur ein Wrapper um das Token)
     */
    private Fleisch convertFleisch(bestellungsParser.FleischContext ctx) {
        String wert = ctx.FLEISCH().getText();
        return new Fleisch(wert);
    }

    /**
     * Konvertiert Beilage
     * WEGGELASSEN: beilage-Rule (ist nur ein Wrapper um das Token)
     */
    private Beilage convertBeilage(bestellungsParser.BeilageContext ctx) {
        String wert = ctx.BEILAGE().getText();
        return new Beilage(wert);
    }

    /**
     * Konvertiert Box
     * WEGGELASSEN: BOX Token-Wert (nur "Pfandbox" oder "Einweg" gelten als Typ)
     */
    private Box convertBox(bestellungsParser.BoxContext ctx) {
        // QUANTITY ist optional
        int menge = 0;
        if (ctx.QUANTITY() != null) {
            String quantityText = ctx.QUANTITY().getText();
            menge = extractMenge(quantityText);
        }

        String typ = ctx.BOX().getText();

        return new Box(menge, typ);
    }

    /**
     * Konvertiert Abholung
     * WEGGELASSEN: ABHOLUNG (Keyword), DOPPELPUNKT (Separator), UHR (redundant)
     * Nur die TIME wird extrahiert
     */
    private Abholung convertAbholung(bestellungsParser.AbholungContext ctx) {
        String zeit = ctx.TIME().getText();
        return new Abholung(zeit);
    }

    /**
     * Konvertiert Anmerkung (global)
     * WEGGELASSEN: NOTE (Keyword), DOPPELPUNKT (Separator)
     * VEREINFACHT: text-Regel wird zu String zusammengefasst
     */
    private Anmerkung convertAnmerkung(bestellungsParser.AnmerkungContext ctx) {
        String text = extractTextFromRule(ctx.text());
        return new Anmerkung(text);
    }

    /**
     * Konvertiert ItemAnmerkung
     * WEGGELASSEN: NOTE (Keyword), DOPPELPUNKT (Separator)
     * VEREINFACHT: text-Regel wird zu String zusammengefasst
     */
    private Anmerkung convertItemAnmerkung(bestellungsParser.ItemAnmerkungContext ctx) {
        String text = extractTextFromRule(ctx.text());
        return new Anmerkung(text);
    }

    /**
     * Extrahiert einen String aus einer text-Regel
     * text : WORD (WORD)*
     * Alle WORD-Token werden mit Leerzeichen verbunden
     */
    private String extractTextFromRule(bestellungsParser.TextContext ctx) {
        StringBuilder result = new StringBuilder();
        java.util.List<org.antlr.v4.runtime.tree.TerminalNode> words = ctx.WORD();
        for (int i = 0; i < words.size(); i++) {
            if (i > 0) {
                result.append(" ");
            }
            result.append(words.get(i).getText());
        }
        return result.toString();
    }

    /**
     * Extrakt die Menge aus einem QUANTITY-Token
     * Format: "1X", "2x", etc.
     * Returns: Die Zahl (z.B. 1, 2)
     */
    private int extractMenge(String quantityText) {
        // Entferne das 'X' oder 'x' am Ende
        String numberText = quantityText.substring(0, quantityText.length() - 1);
        return Integer.parseInt(numberText);
    }
}

