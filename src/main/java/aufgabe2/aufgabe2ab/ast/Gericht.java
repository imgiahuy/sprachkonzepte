package aufgabe2.aufgabe2ab.ast;

/**
 * Abstrakte Basisklasse für Gericht (mit Flexibilität für verschiedene Arten)
 */
public class Gericht extends ASTNode {

    @Override
    public String toString() {
        return "Gericht{}";
    }

    @Override
    public void accept(ASTVisitor visitor) {
        // Subklassen überschreiben dies
    }

    /**
     * Gericht mit Sauce und Fleisch
     */
    public static class MitSauce extends Gericht {
        public Sauce sauce;
        public Fleisch fleisch;

        public MitSauce(Sauce sauce, Fleisch fleisch) {
            this.sauce = sauce;
            this.fleisch = fleisch;
        }

        @Override
        public String toString() {
            return sauce + " " + fleisch;
        }

        @Override
        public void accept(ASTVisitor visitor) {
            visitor.visit(this);
        }
    }

    /**
     * Gericht mit Gebraten und Fleisch
     */
    public static class MitGebraten extends Gericht {
        public Gebraten gebraten;
        public Fleisch fleisch;

        public MitGebraten(Gebraten gebraten, Fleisch fleisch) {
            this.gebraten = gebraten;
            this.fleisch = fleisch;
        }

        @Override
        public String toString() {
            return gebraten + " " + fleisch;
        }

        @Override
        public void accept(ASTVisitor visitor) {
            visitor.visit(this);
        }
    }

    /**
     * Nur eine Beilage
     */
    public static class NurBeilage extends Gericht {
        public Beilage beilage;

        public NurBeilage(Beilage beilage) {
            this.beilage = beilage;
        }

        @Override
        public String toString() {
            return beilage.toString();
        }

        @Override
        public void accept(ASTVisitor visitor) {
            visitor.visit(this);
        }
    }
}

