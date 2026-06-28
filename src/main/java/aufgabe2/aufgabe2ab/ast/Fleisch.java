package aufgabe2.aufgabe2ab.ast;

public class Fleisch extends ASTNode {
    public String wert; // "Hähnchen", "Ente", "Tofu", "Gemüse", "Rind"

    public Fleisch(String wert) {
        this.wert = wert;
    }

    @Override
    public String toString() {
        return wert;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}

