package aufgabe2.aufgabe2a;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {
    public static void main(String[] args) throws Exception {

        String input =
                "Tisch 100, Ausser-Haus, " +
                        "2X Erdnuss Rindfleisch, " +
                        "1X Bami-Goreng Ente, " +
                        "3X Pfandbox, Abholung : 10:00 Uhr.";

        CharStream charStream = CharStreams.fromString(input);

        bestellungslexer lexer = new bestellungslexer(charStream);;
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        gen.bestellungsparser parser = new gen.bestellungsparser(tokens);

        ParseTree tree = parser.bestellung();

        System.out.println(tree.toStringTree(parser));
    }
}
