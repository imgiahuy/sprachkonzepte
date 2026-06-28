package aufgabe2.aufgabe2ab;

import aufgabe2.aufgabe2ab.gen.bestellungsParser;
import aufgabe2.aufgabe2ab.gen.bestellungsParserBaseListener;
import aufgabe2.aufgabe2ab.gen.bestellungsLexer;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

/**
 * Einfaches Beispiel: Parse Tree direkt nutzen
 * (ohne Konvertierung zu AST)
 *
 * Dieses Programm zeigt, wie man einen Parse Tree
 * mit ANTLR4 direkt untersucht und traversiert.
 */
public class SimpleParseTreeExample {

    public static void main(String[] args) throws Exception {
        String input = "Tisch 5, Vor-Ort, 1X Erdnuss Hähnchen, 1X Pfandbox.";

        System.out.println("========================================");
        System.out.println("Einfaches Parse Tree Beispiel");
        System.out.println("========================================\n");

        System.out.println("EINGABE:\n" + input + "\n");

        // Schritt 1: CharStream erstellen
        CharStream charStream = CharStreams.fromString(input);

        // Schritt 2: Lexer erstellen
        bestellungsLexer lexer = new bestellungsLexer(charStream);

        // Schritt 3: Token-Stream erstellen
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Schritt 4: Parser erstellen
        bestellungsParser parser = new bestellungsParser(tokens);

        // Schritt 5: Parse Tree erzeugen (Start-Regel: bestellung)
        ParseTree tree = parser.bestellung();

        // Schritt 6: Parse Tree ausgeben
        System.out.println("PARSE TREE:");
        System.out.println(tree.toStringTree(parser));
        System.out.println("\n");

        // Schritt 7: Tokens auflisten
        System.out.println("TOKENS:");
        tokens.seek(0);
        for (Token token : tokens.getTokens()) {
            String tokenName = parser.getVocabulary().getSymbolicName(token.getType());
            System.out.println("  " + tokenName + ": " + token.getText());
        }
        System.out.println();

        // Schritt 8: Tree traversieren (Visitor Pattern würde auch gehen)
        System.out.println("TREE-STRUKTUR (mit Tiefe):");
        PrintTreeListener listener = new PrintTreeListener(parser);
        ParseTreeWalker.DEFAULT.walk(listener, tree);

        System.out.println("\n========================================");
        System.out.println("ERKENNTNIS:");
        System.out.println("========================================");
        System.out.println("Der Parse Tree enthält ALLE grammatikalischen Informationen.");
        System.out.println("Ein Abstract Syntax Tree (AST) würde nur die");
        System.out.println("semantisch relevanten Teile enthalten.");
    }
}

/**
 * Einfacher Listener um einen Parsen Tree zu traversieren
 */
class PrintTreeListener extends bestellungsParserBaseListener {
    private int depth = 0;
    private bestellungsParser parser;

    public PrintTreeListener(bestellungsParser parser) {
        this.parser = parser;
    }

    private String indent() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth * 2; i++) sb.append(" ");
        return sb.toString();
    }

    @Override
    public void enterEveryRule(org.antlr.v4.runtime.ParserRuleContext ctx) {
        String ruleName = parser.getRuleNames()[ctx.getRuleIndex()];
        System.out.println(indent() + "↓ " + ruleName);
        depth++;
        super.enterEveryRule(ctx);
    }

    @Override
    public void exitEveryRule(org.antlr.v4.runtime.ParserRuleContext ctx) {
        depth--;
        super.exitEveryRule(ctx);
    }

    @Override
    public void visitTerminal(org.antlr.v4.runtime.tree.TerminalNode node) {
        String tokenName = parser.getVocabulary().getSymbolicName(node.getSymbol().getType());
        System.out.println(indent() + "● " + tokenName + "[" + node.getText() + "]");
        super.visitTerminal(node);
    }
}

