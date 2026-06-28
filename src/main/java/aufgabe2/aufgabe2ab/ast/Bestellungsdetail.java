package aufgabe2.aufgabe2ab.ast;

/**
 * Ein Bestellungsdetail mit Menge und Gericht
 */
public class Bestellungsdetail extends ASTNode {
    public int menge;
    public Gericht gericht;
    public Anmerkung itemAnmerkung; // optional

    public Bestellungsdetail(int menge, Gericht gericht, Anmerkung itemAnmerkung) {
        this.menge = menge;
        this.gericht = gericht;
        this.itemAnmerkung = itemAnmerkung;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Detail{").append(menge).append("x ").append(gericht);
        if (itemAnmerkung != null) sb.append(" ").append(itemAnmerkung);
        sb.append("}");
        return sb.toString();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}

