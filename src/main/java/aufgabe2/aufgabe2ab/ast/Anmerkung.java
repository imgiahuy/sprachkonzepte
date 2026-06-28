package aufgabe2.aufgabe2ab.ast;

/**
 * Anmerkung zu einer Bestellung (global oder für ein Item)
 */
public class Anmerkung extends ASTNode {
    public String text;

    public Anmerkung(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Anmerkung{" + text + "}";
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}

