package aufgabe2.aufgabe2ab.ast;

import java.util.List;

/**
 * AST-Knoten für eine komplette Bestellung
 * Terminale weggelassen: KOMMA, PUNKT (Struktursymbole)
 * Nichtterminale: bestellungsdetails-Context, genau gericht-Kontexte
 */
public class Bestellung extends ASTNode {
    public TischInfo tischInfo;
    public Kind kind;
    public List<Bestellungsdetail> details;
    public Box box;
    public Abholung abholung; // optional
    public Anmerkung anmerkung; // optional

    public Bestellung(TischInfo tischInfo, Kind kind, List<Bestellungsdetail> details,
                      Box box, Abholung abholung, Anmerkung anmerkung) {
        this.tischInfo = tischInfo;
        this.kind = kind;
        this.details = details;
        this.box = box;
        this.abholung = abholung;
        this.anmerkung = anmerkung;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bestellung{\n");
        sb.append("  ").append(tischInfo).append("\n");
        sb.append("  ").append(kind).append("\n");
        sb.append("  Details: ").append(details).append("\n");
        sb.append("  ").append(box).append("\n");
        if (abholung != null) sb.append("  ").append(abholung).append("\n");
        if (anmerkung != null) sb.append("  ").append(anmerkung).append("\n");
        sb.append("}");
        return sb.toString();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}

