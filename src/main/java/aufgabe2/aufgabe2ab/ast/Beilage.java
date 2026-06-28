package aufgabe2.aufgabe2ab.ast;

public class Beilage extends ASTNode {
    public String wert; // "Reis", "Nudeln", "Soße"

    public Beilage(String wert) {
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

