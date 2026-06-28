package aufgabe2.aufgabe2ab.ast;

public class Kind extends ASTNode {
    public String typ; // "Ausser-Haus" oder "Vor-Ort"

    public Kind(String typ) {
        this.typ = typ;
    }

    @Override
    public String toString() {
        return "Kind{" + typ + "}";
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}

