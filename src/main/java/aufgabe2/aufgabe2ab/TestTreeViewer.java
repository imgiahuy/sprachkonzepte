package aufgabe2.aufgabe2ab;

import aufgabe2.aufgabe2ab.gen.bestellungsParser;
import aufgabe2.aufgabe2ab.gen.bestellungsLexer;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.*;

import javax.swing.*;
import java.util.*;

public class TestTreeViewer {

    public static void main(String[] args) throws Exception {

        System.out.println("Gib Bestellung ein (Ctrl+D zum Beenden):");

        CharStream input = CharStreams.fromFileName("C:\\sem7\\SPR\\sprachkonzepte\\test_examples\\example1.txt");

        bestellungsLexer lexer = new bestellungsLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        bestellungsParser parser = new bestellungsParser(tokens);

        var tree = parser.bestellung();

        // GUI Tree Viewer
        JFrame frame = new JFrame("Parse Tree");
        TreeViewer viewer = new TreeViewer(
                Arrays.asList(parser.getRuleNames()),
                tree
        );

        frame.add(viewer);
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}