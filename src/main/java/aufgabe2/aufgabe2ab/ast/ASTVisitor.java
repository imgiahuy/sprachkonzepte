package aufgabe2.aufgabe2ab.ast;

public interface ASTVisitor {
    void visit(Bestellung bestellung);
    void visit(TischInfo tischInfo);
    void visit(Kind kind);
    void visit(Bestellungsdetail detail);
    void visit(Gericht gericht);
    void visit(Gericht.MitSauce mitSauce);
    void visit(Gericht.MitGebraten mitGebraten);
    void visit(Gericht.NurBeilage nurBeilage);
    void visit(Sauce sauce);
    void visit(Gebraten gebraten);
    void visit(Fleisch fleisch);
    void visit(Beilage beilage);
    void visit(Box box);
    void visit(Abholung abholung);
    void visit(Anmerkung anmerkung);
}

