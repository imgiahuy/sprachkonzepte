package aufgabe2.aufgabe2ab.ast;

/**
 * Abhol-Zeit für die Bestellung
 */
public class Abholung extends ASTNode {
    public String zeit; // Format: "HH:mm" z.B. "10:00"

    public Abholung(String zeit) {
        this.zeit = zeit;
    }

    @Override
    public String toString() {
        return "Abholung{" + zeit + " Uhr}";
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}

