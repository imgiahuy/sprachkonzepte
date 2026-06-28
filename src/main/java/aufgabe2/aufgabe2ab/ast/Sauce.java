package aufgabe2.aufgabe2ab.ast;

public class Sauce extends ASTNode {
    public String wert; // "Erdnuss", "Süß-Sauer", etc.

    public Sauce(String wert) {
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

