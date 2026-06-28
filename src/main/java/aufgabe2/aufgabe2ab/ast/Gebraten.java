package aufgabe2.aufgabe2ab.ast;

public class Gebraten extends ASTNode {
    public String wert; // "Nasi-Goreng", "Bami-Goreng"

    public Gebraten(String wert) {
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

