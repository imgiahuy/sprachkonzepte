package aufgabe2.aufgabe2ab.ast;

/**
 * Pfandbox oder Einwepackung für die Bestellung
 */
public class Box extends ASTNode {
    public int menge; // 0 bedeutet Standardmenge (1)
    public String typ; // "Pfandbox" oder "Einweg"

    public Box(int menge, String typ) {
        this.menge = menge > 0 ? menge : 1;
        this.typ = typ;
    }

    @Override
    public String toString() {
        return "Box{" + menge + "x " + typ + "}";
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}

