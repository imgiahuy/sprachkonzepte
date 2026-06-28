package aufgabe2.aufgabe2ab.ast;

public class TischInfo extends ASTNode {
    public int tischNummer;

    public TischInfo(int tischNummer) {
        this.tischNummer = tischNummer;
    }

    @Override
    public String toString() {
        return "TischInfo{" + tischNummer + "}";
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}

