package aufgabe2.aufgabe2ab;

import aufgabe2.aufgabe2ab.ast.*;
import aufgabe2.aufgabe2ab.gen.bestellungsLexer;
import aufgabe2.aufgabe2ab.gen.bestellungsParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

/**
 * Visualisierung des AST (Abstrakte Syntax) mit Swing JTree.
 *
 * Liest einen Bestellungstext ein, wandelt ihn in einen Parse Tree um,
 * konvertiert ihn in einen AST und zeigt diesen AST grafisch an.
 */
public class ASTViewer {

    public static void main(String[] args) throws Exception {
        String input = "Tisch 5, Vor-Ort, 1X Erdnuss Hähnchen, 1X Pfandbox.";

        // 1. Parse Tree erzeugen
        CharStream charStream = CharStreams.fromString(input);
        bestellungsLexer lexer = new bestellungsLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        bestellungsParser parser = new bestellungsParser(tokens);
        ParseTree parseTree = parser.bestellung();

        // 2. AST erzeugen
        ParseTreeToASTConverter converter = new ParseTreeToASTConverter();
        Bestellung ast = converter.convertBestellung(parseTree);

        // 3. AST als JTree visualisieren
        DefaultMutableTreeNode root = buildASTTree(ast);
        JTree tree = new JTree(root);

        JFrame frame = new JFrame("AST Viewer - Abstrakte Syntax");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 700);
        frame.add(new JScrollPane(tree));
        frame.setVisible(true);
    }

    /**
     * Baut aus einem ASTNode einen Swing-Tree-Knoten.
     */
    private static DefaultMutableTreeNode buildASTTree(ASTNode node) {
        DefaultMutableTreeNode treeNode;

        if (node instanceof Bestellung) {
            Bestellung b = (Bestellung) node;
            treeNode = new DefaultMutableTreeNode("Bestellung");
            treeNode.add(buildASTTree(b.tischInfo));
            treeNode.add(buildASTTree(b.kind));
            for (Bestellungsdetail detail : b.details) {
                treeNode.add(buildASTTree(detail));
            }
            treeNode.add(buildASTTree(b.box));
            if (b.abholung != null) {
                treeNode.add(buildASTTree(b.abholung));
            }
            if (b.anmerkung != null) {
                treeNode.add(buildASTTree(b.anmerkung));
            }
        }
        else if (node instanceof Bestellungsdetail) {
            Bestellungsdetail d = (Bestellungsdetail) node;
            treeNode = new DefaultMutableTreeNode("Detail: " + d.menge + "x");
            treeNode.add(buildASTTree(d.gericht));
            if (d.itemAnmerkung != null) {
                treeNode.add(buildASTTree(d.itemAnmerkung));
            }
        }
        else if (node instanceof Gericht.MitSauce) {
            Gericht.MitSauce ms = (Gericht.MitSauce) node;
            treeNode = new DefaultMutableTreeNode("MitSauce");
            treeNode.add(new DefaultMutableTreeNode(ms.sauce.wert));
            treeNode.add(new DefaultMutableTreeNode(ms.fleisch.wert));
        }
        else if (node instanceof Gericht.MitGebraten) {
            Gericht.MitGebraten mg = (Gericht.MitGebraten) node;
            treeNode = new DefaultMutableTreeNode("MitGebraten");
            treeNode.add(new DefaultMutableTreeNode(mg.gebraten.wert));
            treeNode.add(new DefaultMutableTreeNode(mg.fleisch.wert));
        }
        else if (node instanceof Gericht.NurBeilage) {
            Gericht.NurBeilage nb = (Gericht.NurBeilage) node;
            treeNode = new DefaultMutableTreeNode("NurBeilage");
            treeNode.add(new DefaultMutableTreeNode(nb.beilage.wert));
        }
        else if (node instanceof TischInfo) {
            TischInfo t = (TischInfo) node;
            treeNode = new DefaultMutableTreeNode("Tisch: " + t.tischNummer);
        }
        else if (node instanceof Kind) {
            Kind k = (Kind) node;
            treeNode = new DefaultMutableTreeNode("Art: " + k.typ);
        }
        else if (node instanceof aufgabe2.aufgabe2ab.ast.Box) {
            aufgabe2.aufgabe2ab.ast.Box b = (aufgabe2.aufgabe2ab.ast.Box) node;
            treeNode = new DefaultMutableTreeNode("Box: " + b.menge + "x " + b.typ);
        }
        else if (node instanceof Abholung) {
            Abholung a = (Abholung) node;
            treeNode = new DefaultMutableTreeNode("Abholung: " + a.zeit);
        }
        else if (node instanceof Anmerkung) {
            Anmerkung a = (Anmerkung) node;
            treeNode = new DefaultMutableTreeNode("Anmerkung: " + a.text);
        }
        else if (node instanceof Sauce) {
            treeNode = new DefaultMutableTreeNode("Sauce: " + ((Sauce) node).wert);
        }
        else if (node instanceof Gebraten) {
            treeNode = new DefaultMutableTreeNode("Gebraten: " + ((Gebraten) node).wert);
        }
        else if (node instanceof Fleisch) {
            treeNode = new DefaultMutableTreeNode("Fleisch: " + ((Fleisch) node).wert);
        }
        else if (node instanceof Beilage) {
            treeNode = new DefaultMutableTreeNode("Beilage: " + ((Beilage) node).wert);
        }
        else {
            treeNode = new DefaultMutableTreeNode(node.toString());
        }

        return treeNode;
    }
}
